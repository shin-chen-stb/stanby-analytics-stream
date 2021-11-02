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
import inc.stanby.utils.StanbyEventBucketAssigner;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
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
import org.apache.flink.table.api.*;
import static org.apache.flink.table.api.Expressions.*;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.types.Row;
import org.apache.flink.streaming.api.functions.sink.filesystem.StreamingFileSink;
import org.apache.flink.core.fs.Path;
import org.apache.flink.streaming.api.functions.sink.filesystem.StreamingFileSink;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import com.amazonaws.services.kinesisanalytics.runtime.KinesisAnalyticsRuntime;
import org.apache.flink.api.common.serialization.SimpleStringEncoder;
import org.apache.flink.streaming.api.functions.sink.filesystem.OutputFileConfig;

import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.flink.formats.parquet.avro.ParquetAvroWriters;
import org.apache.avro.Schema;


public class StreamingSQL {

	private static final String region = "ap-northeast-1";
    private static final String inputStreamName = "dmt-dataplatform-analytics-stream";
	private static final String s3SinkPath = "s3a://dpg-chen/data-table-api";

    private static DataStream<StanbyEvent> createSourceFromStaticConfig(StreamExecutionEnvironment env) {
        Properties inputProperties = new Properties();
        inputProperties.setProperty(ConsumerConfigConstants.AWS_REGION, region);
        inputProperties.setProperty(ConsumerConfigConstants.STREAM_INITIAL_POSITION, "TRIM_HORIZON");

        return env.addSource(new FlinkKinesisConsumer<>(inputStreamName, new StanbyEventSchema(), inputProperties));
    }

    private static DataStream<StanbyEvent> createSourceFromApplicationProperties(StreamExecutionEnvironment env) throws IOException {
        Map<String, Properties> applicationProperties = KinesisAnalyticsRuntime.getApplicationProperties();
        return env.addSource(new FlinkKinesisConsumer<>(inputStreamName, new StanbyEventSchema(),
                applicationProperties.get("ConsumerConfigProperties")));
    }

	private static StreamingFileSink<StanbyEvent> createS3SinkFromStaticConfig() {
        OutputFileConfig outputFileConfig = OutputFileConfig
            .builder()
            .withPartSuffix(".parquet")
            .build();

        final StreamingFileSink<StanbyEvent> sink = StreamingFileSink
                .forBulkFormat(new Path(s3SinkPath), ParquetAvroWriters.forSpecificRecord(StanbyEvent.class))
                .withBucketAssigner(new StanbyEventBucketAssigner())
                .withOutputFileConfig(outputFileConfig)
                // .withRollingPolicy(
                //         DefaultRollingPolicy.builder()
                //             .withRolloverInterval(TimeUnit.MINUTES.toMillis(15))
                //             .withInactivityInterval(TimeUnit.MINUTES.toMillis(5))
                //             .withMaxPartSize(1024 * 1024 * 1024)
                //             .build())
                .build();
        return sink;
    }

	public static void main(String[] args) throws Exception {
		// set up the streaming execution environment
		final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		StreamTableEnvironment tableEnv = StreamTableEnvironment.create(env);

        DataStream<StanbyEvent> input = createSourceFromStaticConfig(env);

		// Table table = tableEnv.fromDataStream(input);

		// tableEnv.createTemporaryView("InputTable", input);
		// Table resultTable = tableEnv.sqlQuery("SELECT UPPER(f0) as c1, f1 as c2 FROM InputTable");
		// DataStream<Row> resultStream = tableEnv.toDataStream(resultTable);

		input.addSink(createS3SinkFromStaticConfig());
		// execute program
		env.execute("Stanby Analytics Streaming sql dev");
	}
}
