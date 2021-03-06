package inc.stanby.utils;

import inc.stanby.schema.StanbyEvent;
import org.apache.avro.data.TimeConversions;
import org.apache.avro.specific.SpecificData;
import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.serialization.SerializationSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.formats.avro.typeutils.AvroTypeInfo;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.JsonNode;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.node.ObjectNode;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;
import java.util.HashMap;
import ua_parser.Parser;
import ua_parser.Client;

public class StanbyEventSchema implements SerializationSchema<StanbyEvent>, DeserializationSchema<StanbyEvent> {

  private final ObjectMapper mapper = new ObjectMapper();
  private static final Logger LOG = LoggerFactory.getLogger(StanbyEventSchema.class);

  static {
    SpecificData.get().addLogicalTypeConversion(new TimeConversions.TimestampConversion());
  }

  @Override
  public byte[] serialize(StanbyEvent event) {
    LOG.info("Serializing node: {}", toJson(event));
    return toJson(event).getBytes();
  }

  @Override
  public boolean isEndOfStream(StanbyEvent event) {
    return false;
  }

  @Override
  public TypeInformation<StanbyEvent> getProducedType() {
    return new AvroTypeInfo<>(StanbyEvent.class);
  }

  @Override
  public StanbyEvent deserialize(byte[] bytes) {
    try {
      ObjectNode node = this.mapper.readValue(bytes, ObjectNode.class);
      LOG.info("Reading node: {}", node.toString());
      String service = "";
      String event_type = "";
      String suid = "";
      String ssid = "";
      String current_url = "";
      String referrer = "";
      String page = "";
      String page_type = "";
      String user_agent = "";
      String search_request_id = "";
      Long epoch = 0L;
      String ip = "";

      if (node.has("service")) service = node.get("service").asText();
      if (node.has("event_type")) event_type = node.get("event_type").asText();
      if (node.has("suid")) suid = node.get("suid").asText();
      if (node.has("ssid")) ssid = node.get("ssid").asText();
      if (node.has("current_url")) current_url = node.get("current_url").asText();
      if (node.has("referrer")) referrer = node.get("referrer").asText();
      if (node.has("page")) page = node.get("page").asText();
      if (node.has("page_type")) page_type = node.get("page_type").asText();
      if (node.has("user_agent")) user_agent = node.get("user_agent").asText();
      if (node.has("search_request_id")) search_request_id = node.get("search_request_id").asText();
      if (node.has("epoch")) epoch = node.get("epoch").asLong();
      if (node.has("ip")) ip = node.get("ip").asText();
      Parser uaParser = new Parser();
      Client c = uaParser.parse(user_agent.toString());
      String ua_os = String.format("%s_%s", c.os.family, c.os.major);
      String ua_device = c.device.family;
      String ua_family = c.userAgent.family;
      return StanbyEvent
          .newBuilder()
          .setService(service)
          .setEventType(event_type)
          .setSuid(suid)
          .setSsid(ssid)
          .setCurrentUrl(current_url)
          .setReferrer(referrer)
          .setPage(page)
          .setPageType(page_type)
          .setUserAgent(user_agent)
          .setSearchRequestId(search_request_id)
          .setEpoch(epoch)
          .setIp(ip)
          .setUaDevice(ua_os)
          .setUaOs(ua_device)
          .setUaFamily(ua_family)
          .build();
    } catch (Exception e) {
      LOG.warn("Failed to serialize event: {}", new String(bytes), e);

      return null;
    }
  }

  public static String toJson(StanbyEvent event) {
    StringBuilder builder = new StringBuilder();

    builder.append("{");
    addTextField(builder, event, "service");
    builder.append(", ");
    addTextField(builder, event, "event_type");
    builder.append(", ");
    addTextField(builder, event, "suid");
    builder.append(", ");
    addTextField(builder, event, "ssid");
    builder.append(", ");
    addTextField(builder, event, "current_url");
    builder.append(", ");
    addTextField(builder, event, "referrer");
    builder.append(", ");
    addTextField(builder, event, "page");
    builder.append(", ");
    addTextField(builder, event, "page_type");
    builder.append(", ");
    addTextField(builder, event, "user_agent");
    builder.append(", ");
    addTextField(builder, event, "search_request_id");
    builder.append(", ");
    addField(builder, event, "epoch");
    builder.append(", ");
    addTextField(builder, event, "ip");
    builder.append(", ");
    addTextField(builder, event, "ua_os");
    builder.append(", ");
    addField(builder, event, "ua_device");
    builder.append(", ");
    addTextField(builder, event, "ua_family");
    builder.append("}");

    return builder.toString();
  }

  private static void addField(StringBuilder builder, StanbyEvent event, String fieldName) {
    addField(builder, fieldName, event.get(fieldName));
  }

  private static void addField(StringBuilder builder, String fieldName, Object value) {
    builder.append("\"");
    builder.append(fieldName);
    builder.append("\"");

    builder.append(": ");
    builder.append(value);
  }

  private static void addTextField(StringBuilder builder, StanbyEvent event, String fieldName) {
    builder.append("\"");
    builder.append(fieldName);
    builder.append("\"");

    builder.append(": ");
    builder.append("\"");
    builder.append(event.get(fieldName));
    builder.append("\"");
  }
}
