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

public class StanbyEventSchema implements SerializationSchema<StanbyEvent>, DeserializationSchema<StanbyEvent> {

  private final ObjectMapper mapper = new ObjectMapper();
  private static final Logger LOG = LoggerFactory.getLogger(StanbyEventSchema.class);

  static {
    SpecificData.get().addLogicalTypeConversion(new TimeConversions.TimestampConversion());
  }

  @Override
  public byte[] serialize(StanbyEvent event) {
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

      return StanbyEvent
          .newBuilder()
          .setService(node.get("service").asText())
          .setEventType(node.get("event_type").asText())
          .setSuid(node.get("suid").asText())
          .setSsid(node.get("ssid").asText())
          .setCurrentUrl(node.get("current_url").asText())
          .setReferrer(node.get("referrer").asText())
          .setPage(node.get("page").asText())
          .setPageType(node.get("page_type").asText())
          .setUserAgent(node.get("user_agent").asText())
          .setSearchRequestId(node.get("search_request_id").asText())
          .setEpoch(node.get("epoch").asLong())
          .setIp(node.get("ip").asText())
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
    addTextField(builder, event, "type");
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
