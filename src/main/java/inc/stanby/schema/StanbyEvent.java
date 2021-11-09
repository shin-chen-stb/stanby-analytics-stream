/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package inc.stanby.schema;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class StanbyEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -2732263274051153410L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"StanbyEvent\",\"namespace\":\"inc.stanby.schema\",\"fields\":[{\"name\":\"service\",\"type\":\"string\",\"default\":\"NONE\"},{\"name\":\"event_type\",\"type\":\"string\",\"default\":\"NONE\"},{\"name\":\"suid\",\"type\":\"string\",\"default\":\"NONE\"},{\"name\":\"ssid\",\"type\":\"string\",\"default\":\"NONE\"},{\"name\":\"current_url\",\"type\":\"string\",\"default\":\"NONE\"},{\"name\":\"referrer\",\"type\":\"string\",\"default\":\"NONE\"},{\"name\":\"page\",\"type\":\"string\",\"default\":\"NONE\"},{\"name\":\"page_type\",\"type\":\"string\",\"default\":\"NONE\"},{\"name\":\"user_agent\",\"type\":\"string\",\"default\":\"NONE\"},{\"name\":\"search_request_id\",\"type\":\"string\",\"default\":\"NONE\"},{\"name\":\"epoch\",\"type\":\"long\",\"default\":\"NONE\"},{\"name\":\"ip\",\"type\":\"string\",\"default\":\"NONE\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<StanbyEvent> ENCODER =
      new BinaryMessageEncoder<StanbyEvent>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<StanbyEvent> DECODER =
      new BinaryMessageDecoder<StanbyEvent>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<StanbyEvent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<StanbyEvent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<StanbyEvent>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this StanbyEvent to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a StanbyEvent from a ByteBuffer. */
  public static StanbyEvent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence service;
  @Deprecated public java.lang.CharSequence event_type;
  @Deprecated public java.lang.CharSequence suid;
  @Deprecated public java.lang.CharSequence ssid;
  @Deprecated public java.lang.CharSequence current_url;
  @Deprecated public java.lang.CharSequence referrer;
  @Deprecated public java.lang.CharSequence page;
  @Deprecated public java.lang.CharSequence page_type;
  @Deprecated public java.lang.CharSequence user_agent;
  @Deprecated public java.lang.CharSequence search_request_id;
  @Deprecated public long epoch;
  @Deprecated public java.lang.CharSequence ip;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public StanbyEvent() {}

  /**
   * All-args constructor.
   * @param service The new value for service
   * @param event_type The new value for event_type
   * @param suid The new value for suid
   * @param ssid The new value for ssid
   * @param current_url The new value for current_url
   * @param referrer The new value for referrer
   * @param page The new value for page
   * @param page_type The new value for page_type
   * @param user_agent The new value for user_agent
   * @param search_request_id The new value for search_request_id
   * @param epoch The new value for epoch
   * @param ip The new value for ip
   */
  public StanbyEvent(java.lang.CharSequence service, java.lang.CharSequence event_type, java.lang.CharSequence suid, java.lang.CharSequence ssid, java.lang.CharSequence current_url, java.lang.CharSequence referrer, java.lang.CharSequence page, java.lang.CharSequence page_type, java.lang.CharSequence user_agent, java.lang.CharSequence search_request_id, java.lang.Long epoch, java.lang.CharSequence ip) {
    this.service = service;
    this.event_type = event_type;
    this.suid = suid;
    this.ssid = ssid;
    this.current_url = current_url;
    this.referrer = referrer;
    this.page = page;
    this.page_type = page_type;
    this.user_agent = user_agent;
    this.search_request_id = search_request_id;
    this.epoch = epoch;
    this.ip = ip;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return service;
    case 1: return event_type;
    case 2: return suid;
    case 3: return ssid;
    case 4: return current_url;
    case 5: return referrer;
    case 6: return page;
    case 7: return page_type;
    case 8: return user_agent;
    case 9: return search_request_id;
    case 10: return epoch;
    case 11: return ip;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: service = (java.lang.CharSequence)value$; break;
    case 1: event_type = (java.lang.CharSequence)value$; break;
    case 2: suid = (java.lang.CharSequence)value$; break;
    case 3: ssid = (java.lang.CharSequence)value$; break;
    case 4: current_url = (java.lang.CharSequence)value$; break;
    case 5: referrer = (java.lang.CharSequence)value$; break;
    case 6: page = (java.lang.CharSequence)value$; break;
    case 7: page_type = (java.lang.CharSequence)value$; break;
    case 8: user_agent = (java.lang.CharSequence)value$; break;
    case 9: search_request_id = (java.lang.CharSequence)value$; break;
    case 10: epoch = (java.lang.Long)value$; break;
    case 11: ip = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'service' field.
   * @return The value of the 'service' field.
   */
  public java.lang.CharSequence getService() {
    return service;
  }

  /**
   * Sets the value of the 'service' field.
   * @param value the value to set.
   */
  public void setService(java.lang.CharSequence value) {
    this.service = value;
  }

  /**
   * Gets the value of the 'event_type' field.
   * @return The value of the 'event_type' field.
   */
  public java.lang.CharSequence getEventType() {
    return event_type;
  }

  /**
   * Sets the value of the 'event_type' field.
   * @param value the value to set.
   */
  public void setEventType(java.lang.CharSequence value) {
    this.event_type = value;
  }

  /**
   * Gets the value of the 'suid' field.
   * @return The value of the 'suid' field.
   */
  public java.lang.CharSequence getSuid() {
    return suid;
  }

  /**
   * Sets the value of the 'suid' field.
   * @param value the value to set.
   */
  public void setSuid(java.lang.CharSequence value) {
    this.suid = value;
  }

  /**
   * Gets the value of the 'ssid' field.
   * @return The value of the 'ssid' field.
   */
  public java.lang.CharSequence getSsid() {
    return ssid;
  }

  /**
   * Sets the value of the 'ssid' field.
   * @param value the value to set.
   */
  public void setSsid(java.lang.CharSequence value) {
    this.ssid = value;
  }

  /**
   * Gets the value of the 'current_url' field.
   * @return The value of the 'current_url' field.
   */
  public java.lang.CharSequence getCurrentUrl() {
    return current_url;
  }

  /**
   * Sets the value of the 'current_url' field.
   * @param value the value to set.
   */
  public void setCurrentUrl(java.lang.CharSequence value) {
    this.current_url = value;
  }

  /**
   * Gets the value of the 'referrer' field.
   * @return The value of the 'referrer' field.
   */
  public java.lang.CharSequence getReferrer() {
    return referrer;
  }

  /**
   * Sets the value of the 'referrer' field.
   * @param value the value to set.
   */
  public void setReferrer(java.lang.CharSequence value) {
    this.referrer = value;
  }

  /**
   * Gets the value of the 'page' field.
   * @return The value of the 'page' field.
   */
  public java.lang.CharSequence getPage() {
    return page;
  }

  /**
   * Sets the value of the 'page' field.
   * @param value the value to set.
   */
  public void setPage(java.lang.CharSequence value) {
    this.page = value;
  }

  /**
   * Gets the value of the 'page_type' field.
   * @return The value of the 'page_type' field.
   */
  public java.lang.CharSequence getPageType() {
    return page_type;
  }

  /**
   * Sets the value of the 'page_type' field.
   * @param value the value to set.
   */
  public void setPageType(java.lang.CharSequence value) {
    this.page_type = value;
  }

  /**
   * Gets the value of the 'user_agent' field.
   * @return The value of the 'user_agent' field.
   */
  public java.lang.CharSequence getUserAgent() {
    return user_agent;
  }

  /**
   * Sets the value of the 'user_agent' field.
   * @param value the value to set.
   */
  public void setUserAgent(java.lang.CharSequence value) {
    this.user_agent = value;
  }

  /**
   * Gets the value of the 'search_request_id' field.
   * @return The value of the 'search_request_id' field.
   */
  public java.lang.CharSequence getSearchRequestId() {
    return search_request_id;
  }

  /**
   * Sets the value of the 'search_request_id' field.
   * @param value the value to set.
   */
  public void setSearchRequestId(java.lang.CharSequence value) {
    this.search_request_id = value;
  }

  /**
   * Gets the value of the 'epoch' field.
   * @return The value of the 'epoch' field.
   */
  public java.lang.Long getEpoch() {
    return epoch;
  }

  /**
   * Sets the value of the 'epoch' field.
   * @param value the value to set.
   */
  public void setEpoch(java.lang.Long value) {
    this.epoch = value;
  }

  /**
   * Gets the value of the 'ip' field.
   * @return The value of the 'ip' field.
   */
  public java.lang.CharSequence getIp() {
    return ip;
  }

  /**
   * Sets the value of the 'ip' field.
   * @param value the value to set.
   */
  public void setIp(java.lang.CharSequence value) {
    this.ip = value;
  }

  /**
   * Creates a new StanbyEvent RecordBuilder.
   * @return A new StanbyEvent RecordBuilder
   */
  public static inc.stanby.schema.StanbyEvent.Builder newBuilder() {
    return new inc.stanby.schema.StanbyEvent.Builder();
  }

  /**
   * Creates a new StanbyEvent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new StanbyEvent RecordBuilder
   */
  public static inc.stanby.schema.StanbyEvent.Builder newBuilder(inc.stanby.schema.StanbyEvent.Builder other) {
    return new inc.stanby.schema.StanbyEvent.Builder(other);
  }

  /**
   * Creates a new StanbyEvent RecordBuilder by copying an existing StanbyEvent instance.
   * @param other The existing instance to copy.
   * @return A new StanbyEvent RecordBuilder
   */
  public static inc.stanby.schema.StanbyEvent.Builder newBuilder(inc.stanby.schema.StanbyEvent other) {
    return new inc.stanby.schema.StanbyEvent.Builder(other);
  }

  /**
   * RecordBuilder for StanbyEvent instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<StanbyEvent>
    implements org.apache.avro.data.RecordBuilder<StanbyEvent> {

    private java.lang.CharSequence service;
    private java.lang.CharSequence event_type;
    private java.lang.CharSequence suid;
    private java.lang.CharSequence ssid;
    private java.lang.CharSequence current_url;
    private java.lang.CharSequence referrer;
    private java.lang.CharSequence page;
    private java.lang.CharSequence page_type;
    private java.lang.CharSequence user_agent;
    private java.lang.CharSequence search_request_id;
    private long epoch;
    private java.lang.CharSequence ip;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(inc.stanby.schema.StanbyEvent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.service)) {
        this.service = data().deepCopy(fields()[0].schema(), other.service);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.event_type)) {
        this.event_type = data().deepCopy(fields()[1].schema(), other.event_type);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.suid)) {
        this.suid = data().deepCopy(fields()[2].schema(), other.suid);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.ssid)) {
        this.ssid = data().deepCopy(fields()[3].schema(), other.ssid);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.current_url)) {
        this.current_url = data().deepCopy(fields()[4].schema(), other.current_url);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.referrer)) {
        this.referrer = data().deepCopy(fields()[5].schema(), other.referrer);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.page)) {
        this.page = data().deepCopy(fields()[6].schema(), other.page);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.page_type)) {
        this.page_type = data().deepCopy(fields()[7].schema(), other.page_type);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.user_agent)) {
        this.user_agent = data().deepCopy(fields()[8].schema(), other.user_agent);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.search_request_id)) {
        this.search_request_id = data().deepCopy(fields()[9].schema(), other.search_request_id);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.epoch)) {
        this.epoch = data().deepCopy(fields()[10].schema(), other.epoch);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.ip)) {
        this.ip = data().deepCopy(fields()[11].schema(), other.ip);
        fieldSetFlags()[11] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing StanbyEvent instance
     * @param other The existing instance to copy.
     */
    private Builder(inc.stanby.schema.StanbyEvent other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.service)) {
        this.service = data().deepCopy(fields()[0].schema(), other.service);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.event_type)) {
        this.event_type = data().deepCopy(fields()[1].schema(), other.event_type);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.suid)) {
        this.suid = data().deepCopy(fields()[2].schema(), other.suid);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.ssid)) {
        this.ssid = data().deepCopy(fields()[3].schema(), other.ssid);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.current_url)) {
        this.current_url = data().deepCopy(fields()[4].schema(), other.current_url);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.referrer)) {
        this.referrer = data().deepCopy(fields()[5].schema(), other.referrer);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.page)) {
        this.page = data().deepCopy(fields()[6].schema(), other.page);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.page_type)) {
        this.page_type = data().deepCopy(fields()[7].schema(), other.page_type);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.user_agent)) {
        this.user_agent = data().deepCopy(fields()[8].schema(), other.user_agent);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.search_request_id)) {
        this.search_request_id = data().deepCopy(fields()[9].schema(), other.search_request_id);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.epoch)) {
        this.epoch = data().deepCopy(fields()[10].schema(), other.epoch);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.ip)) {
        this.ip = data().deepCopy(fields()[11].schema(), other.ip);
        fieldSetFlags()[11] = true;
      }
    }

    /**
      * Gets the value of the 'service' field.
      * @return The value.
      */
    public java.lang.CharSequence getService() {
      return service;
    }

    /**
      * Sets the value of the 'service' field.
      * @param value The value of 'service'.
      * @return This builder.
      */
    public inc.stanby.schema.StanbyEvent.Builder setService(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.service = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'service' field has been set.
      * @return True if the 'service' field has been set, false otherwise.
      */
    public boolean hasService() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'service' field.
      * @return This builder.
      */
    public inc.stanby.schema.StanbyEvent.Builder clearService() {
      service = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'event_type' field.
      * @return The value.
      */
    public java.lang.CharSequence getEventType() {
      return event_type;
    }

    /**
      * Sets the value of the 'event_type' field.
      * @param value The value of 'event_type'.
      * @return This builder.
      */
    public inc.stanby.schema.StanbyEvent.Builder setEventType(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.event_type = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'event_type' field has been set.
      * @return True if the 'event_type' field has been set, false otherwise.
      */
    public boolean hasEventType() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'event_type' field.
      * @return This builder.
      */
    public inc.stanby.schema.StanbyEvent.Builder clearEventType() {
      event_type = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'suid' field.
      * @return The value.
      */
    public java.lang.CharSequence getSuid() {
      return suid;
    }

    /**
      * Sets the value of the 'suid' field.
      * @param value The value of 'suid'.
      * @return This builder.
      */
    public inc.stanby.schema.StanbyEvent.Builder setSuid(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.suid = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'suid' field has been set.
      * @return True if the 'suid' field has been set, false otherwise.
      */
    public boolean hasSuid() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'suid' field.
      * @return This builder.
      */
    public inc.stanby.schema.StanbyEvent.Builder clearSuid() {
      suid = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'ssid' field.
      * @return The value.
      */
    public java.lang.CharSequence getSsid() {
      return ssid;
    }

    /**
      * Sets the value of the 'ssid' field.
      * @param value The value of 'ssid'.
      * @return This builder.
      */
    public inc.stanby.schema.StanbyEvent.Builder setSsid(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.ssid = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'ssid' field has been set.
      * @return True if the 'ssid' field has been set, false otherwise.
      */
    public boolean hasSsid() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'ssid' field.
      * @return This builder.
      */
    public inc.stanby.schema.StanbyEvent.Builder clearSsid() {
      ssid = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'current_url' field.
      * @return The value.
      */
    public java.lang.CharSequence getCurrentUrl() {
      return current_url;
    }

    /**
      * Sets the value of the 'current_url' field.
      * @param value The value of 'current_url'.
      * @return This builder.
      */
    public inc.stanby.schema.StanbyEvent.Builder setCurrentUrl(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.current_url = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'current_url' field has been set.
      * @return True if the 'current_url' field has been set, false otherwise.
      */
    public boolean hasCurrentUrl() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'current_url' field.
      * @return This builder.
      */
    public inc.stanby.schema.StanbyEvent.Builder clearCurrentUrl() {
      current_url = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'referrer' field.
      * @return The value.
      */
    public java.lang.CharSequence getReferrer() {
      return referrer;
    }

    /**
      * Sets the value of the 'referrer' field.
      * @param value The value of 'referrer'.
      * @return This builder.
      */
    public inc.stanby.schema.StanbyEvent.Builder setReferrer(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.referrer = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'referrer' field has been set.
      * @return True if the 'referrer' field has been set, false otherwise.
      */
    public boolean hasReferrer() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'referrer' field.
      * @return This builder.
      */
    public inc.stanby.schema.StanbyEvent.Builder clearReferrer() {
      referrer = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'page' field.
      * @return The value.
      */
    public java.lang.CharSequence getPage() {
      return page;
    }

    /**
      * Sets the value of the 'page' field.
      * @param value The value of 'page'.
      * @return This builder.
      */
    public inc.stanby.schema.StanbyEvent.Builder setPage(java.lang.CharSequence value) {
      validate(fields()[6], value);
      this.page = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'page' field has been set.
      * @return True if the 'page' field has been set, false otherwise.
      */
    public boolean hasPage() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'page' field.
      * @return This builder.
      */
    public inc.stanby.schema.StanbyEvent.Builder clearPage() {
      page = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'page_type' field.
      * @return The value.
      */
    public java.lang.CharSequence getPageType() {
      return page_type;
    }

    /**
      * Sets the value of the 'page_type' field.
      * @param value The value of 'page_type'.
      * @return This builder.
      */
    public inc.stanby.schema.StanbyEvent.Builder setPageType(java.lang.CharSequence value) {
      validate(fields()[7], value);
      this.page_type = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'page_type' field has been set.
      * @return True if the 'page_type' field has been set, false otherwise.
      */
    public boolean hasPageType() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'page_type' field.
      * @return This builder.
      */
    public inc.stanby.schema.StanbyEvent.Builder clearPageType() {
      page_type = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'user_agent' field.
      * @return The value.
      */
    public java.lang.CharSequence getUserAgent() {
      return user_agent;
    }

    /**
      * Sets the value of the 'user_agent' field.
      * @param value The value of 'user_agent'.
      * @return This builder.
      */
    public inc.stanby.schema.StanbyEvent.Builder setUserAgent(java.lang.CharSequence value) {
      validate(fields()[8], value);
      this.user_agent = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'user_agent' field has been set.
      * @return True if the 'user_agent' field has been set, false otherwise.
      */
    public boolean hasUserAgent() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'user_agent' field.
      * @return This builder.
      */
    public inc.stanby.schema.StanbyEvent.Builder clearUserAgent() {
      user_agent = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'search_request_id' field.
      * @return The value.
      */
    public java.lang.CharSequence getSearchRequestId() {
      return search_request_id;
    }

    /**
      * Sets the value of the 'search_request_id' field.
      * @param value The value of 'search_request_id'.
      * @return This builder.
      */
    public inc.stanby.schema.StanbyEvent.Builder setSearchRequestId(java.lang.CharSequence value) {
      validate(fields()[9], value);
      this.search_request_id = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'search_request_id' field has been set.
      * @return True if the 'search_request_id' field has been set, false otherwise.
      */
    public boolean hasSearchRequestId() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'search_request_id' field.
      * @return This builder.
      */
    public inc.stanby.schema.StanbyEvent.Builder clearSearchRequestId() {
      search_request_id = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    /**
      * Gets the value of the 'epoch' field.
      * @return The value.
      */
    public java.lang.Long getEpoch() {
      return epoch;
    }

    /**
      * Sets the value of the 'epoch' field.
      * @param value The value of 'epoch'.
      * @return This builder.
      */
    public inc.stanby.schema.StanbyEvent.Builder setEpoch(long value) {
      validate(fields()[10], value);
      this.epoch = value;
      fieldSetFlags()[10] = true;
      return this;
    }

    /**
      * Checks whether the 'epoch' field has been set.
      * @return True if the 'epoch' field has been set, false otherwise.
      */
    public boolean hasEpoch() {
      return fieldSetFlags()[10];
    }


    /**
      * Clears the value of the 'epoch' field.
      * @return This builder.
      */
    public inc.stanby.schema.StanbyEvent.Builder clearEpoch() {
      fieldSetFlags()[10] = false;
      return this;
    }

    /**
      * Gets the value of the 'ip' field.
      * @return The value.
      */
    public java.lang.CharSequence getIp() {
      return ip;
    }

    /**
      * Sets the value of the 'ip' field.
      * @param value The value of 'ip'.
      * @return This builder.
      */
    public inc.stanby.schema.StanbyEvent.Builder setIp(java.lang.CharSequence value) {
      validate(fields()[11], value);
      this.ip = value;
      fieldSetFlags()[11] = true;
      return this;
    }

    /**
      * Checks whether the 'ip' field has been set.
      * @return True if the 'ip' field has been set, false otherwise.
      */
    public boolean hasIp() {
      return fieldSetFlags()[11];
    }


    /**
      * Clears the value of the 'ip' field.
      * @return This builder.
      */
    public inc.stanby.schema.StanbyEvent.Builder clearIp() {
      ip = null;
      fieldSetFlags()[11] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public StanbyEvent build() {
      try {
        StanbyEvent record = new StanbyEvent();
        record.service = fieldSetFlags()[0] ? this.service : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.event_type = fieldSetFlags()[1] ? this.event_type : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.suid = fieldSetFlags()[2] ? this.suid : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.ssid = fieldSetFlags()[3] ? this.ssid : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.current_url = fieldSetFlags()[4] ? this.current_url : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.referrer = fieldSetFlags()[5] ? this.referrer : (java.lang.CharSequence) defaultValue(fields()[5]);
        record.page = fieldSetFlags()[6] ? this.page : (java.lang.CharSequence) defaultValue(fields()[6]);
        record.page_type = fieldSetFlags()[7] ? this.page_type : (java.lang.CharSequence) defaultValue(fields()[7]);
        record.user_agent = fieldSetFlags()[8] ? this.user_agent : (java.lang.CharSequence) defaultValue(fields()[8]);
        record.search_request_id = fieldSetFlags()[9] ? this.search_request_id : (java.lang.CharSequence) defaultValue(fields()[9]);
        record.epoch = fieldSetFlags()[10] ? this.epoch : (java.lang.Long) defaultValue(fields()[10]);
        record.ip = fieldSetFlags()[11] ? this.ip : (java.lang.CharSequence) defaultValue(fields()[11]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<StanbyEvent>
    WRITER$ = (org.apache.avro.io.DatumWriter<StanbyEvent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<StanbyEvent>
    READER$ = (org.apache.avro.io.DatumReader<StanbyEvent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
