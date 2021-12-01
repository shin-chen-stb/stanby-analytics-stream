/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package inc.stanby;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * Skeleton for a Flink Streaming Job.
 *
 * <p>For a tutorial how to write a Flink streaming application, check the
 * tutorials and examples on the <a href="https://flink.apache.org/docs/stable/">Flink Website</a>.
 *
 * <p>To package your application into a JAR file for execution, run
 * 'mvn clean package' on the command line.
 *
 * <p>If you change the name of the main class (with the public static void main(String[] args))
 * method, change the respective entry in the POM.xml file (simply search for 'mainClass').
 */

import inc.stanby.operators.AmazonElasticsearchSink;
import inc.stanby.schema.StanbyEvent;
import inc.stanby.utils.StanbyEventSchema;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.common.functions.RuntimeContext;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kinesis.FlinkKinesisConsumer;
import org.apache.flink.streaming.connectors.kinesis.FlinkKinesisProducer;
import org.apache.flink.streaming.connectors.kinesis.config.ConsumerConfigConstants;
import org.apache.flink.streaming.api.functions.sink.filesystem.rollingpolicies.DefaultRollingPolicy;
import org.apache.flink.streaming.api.functions.sink.filesystem.bucketassigners.DateTimeBucketAssigner;
import org.apache.flink.streaming.connectors.elasticsearch.ElasticsearchSinkFunction;
import org.apache.flink.streaming.connectors.elasticsearch.RequestIndexer;
import org.apache.flink.streaming.connectors.elasticsearch7.ElasticsearchSink;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import com.amazonaws.services.kinesisanalytics.runtime.KinesisAnalyticsRuntime;

import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Date;
import java.util.Calendar;
import java.util.TimeZone;

import ua_parser.Parser;
import ua_parser.Client;


public class StreamingJob {
	private static String serviceName = "es";
	private static final String region = "ap-northeast-1";
    private static final String inputStreamName = "dmt-dataplatform-analytics-stream";
    private static final String domainEndpoint = "https://search-chen-stanby-analytics-dev-dqo5rvvb3udyugdkkrrzjr5gda.ap-northeast-1.es.amazonaws.com";
    private static final Logger logger = LoggerFactory.getLogger(StreamingJob.class);

    private static DataStream<StanbyEvent> createStanbyEventSourceFromStaticConfig(StreamExecutionEnvironment env, String inputStreamName) {
        Properties inputProperties = new Properties();
        inputProperties.setProperty(ConsumerConfigConstants.AWS_REGION, region);
        inputProperties.setProperty(ConsumerConfigConstants.STREAM_INITIAL_POSITION, "TRIM_HORIZON");
        return env.addSource(new FlinkKinesisConsumer<>(inputStreamName, new StanbyEventSchema(), inputProperties));
    }

    private static DataStream<String> createSourceFromStaticConfig(StreamExecutionEnvironment env, String inputStreamName) {
        Properties inputProperties = new Properties();
        inputProperties.setProperty(ConsumerConfigConstants.AWS_REGION, region);
        inputProperties.setProperty(ConsumerConfigConstants.STREAM_INITIAL_POSITION, "TRIM_HORIZON");
        return env.addSource(new FlinkKinesisConsumer<>(inputStreamName, new SimpleStringSchema(), inputProperties));
    }

    private static DataStream<StanbyEvent> createSourceFromApplicationProperties(StreamExecutionEnvironment env) throws IOException {
        Map<String, Properties> applicationProperties = KinesisAnalyticsRuntime.getApplicationProperties();
        return env.addSource(new FlinkKinesisConsumer<>(inputStreamName, new StanbyEventSchema(),
                applicationProperties.get("ConsumerConfigProperties")));
    }

	public static void main(String[] args) throws Exception {
		// set up the streaming execution environment
		final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<StanbyEvent> input = createStanbyEventSourceFromStaticConfig(env, "dmt-dataplatform-analytics-stream");
		input.addSink(AmazonElasticsearchSink.buildElasticsearchSink(domainEndpoint, region, "stanby_event2", "_doc"));
        DataStream<String> input3 = createSourceFromStaticConfig(env, "dmt-jse-tracker");
		input3.filter(new FilterFunction<String>() {
            @Override
            public boolean filter(String value) throws Exception {
                return value.contains("jobSearchRequest");
            }
        });.addSink(AmazonElasticsearchSink.buildElasticsearchSink(domainEndpoint, region, "dmt-jse-job-search", "_doc"));
		input3.filter(new FilterFunction<String>() {
            @Override
            public boolean filter(String value) throws Exception {
                return value.contains("jobImpression");
            }
        });.addSink(AmazonElasticsearchSink.buildElasticsearchSink(domainEndpoint, region, "dmt-jse-job-impression", "_doc"));
        input3.filter(new FilterFunction<String>() {
            @Override
            public boolean filter(String value) throws Exception {
                return value.contains("jobDetailsImpression");
            }
        });.addSink(AmazonElasticsearchSink.buildElasticsearchSink(domainEndpoint, region, "dmt-jse-job-detail-impression", "_doc"));
        input3.filter(new FilterFunction<String>() {
            @Override
            public boolean filter(String value) throws Exception {
                return value.contains("jobClick");
            }
        });.addSink(AmazonElasticsearchSink.buildElasticsearchSink(domainEndpoint, region, "dmt-jse-job-click", "_doc"));
		// execute program
		env.execute("Stanby Analytics Streaming dev");
	}
}
