package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * DomainRecordSrv
 */
@JsonPropertyOrder({ DomainRecordSrv.JSON_PROPERTY_ID, DomainRecordSrv.JSON_PROPERTY_TYPE,
        DomainRecordSrv.JSON_PROPERTY_NAME, DomainRecordSrv.JSON_PROPERTY_DATA, DomainRecordSrv.JSON_PROPERTY_PRIORITY,
        DomainRecordSrv.JSON_PROPERTY_PORT, DomainRecordSrv.JSON_PROPERTY_TTL, DomainRecordSrv.JSON_PROPERTY_WEIGHT,
        DomainRecordSrv.JSON_PROPERTY_FLAGS, DomainRecordSrv.JSON_PROPERTY_TAG })
public class DomainRecordSrv {
    public static final String JSON_PROPERTY_ID = "id";
    private Integer id;

    public static final String JSON_PROPERTY_TYPE = "type";
    private String type;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_DATA = "data";
    private String data;

    public static final String JSON_PROPERTY_PRIORITY = "priority";
    private Integer priority;

    public static final String JSON_PROPERTY_PORT = "port";
    private Integer port;

    public static final String JSON_PROPERTY_TTL = "ttl";
    private Integer ttl;

    public static final String JSON_PROPERTY_WEIGHT = "weight";
    private Integer weight;

    public static final String JSON_PROPERTY_FLAGS = "flags";
    private Integer flags;

    public static final String JSON_PROPERTY_TAG = "tag";
    private String tag;

    public DomainRecordSrv() {
    }

    @JsonCreator
    public DomainRecordSrv(@JsonProperty(JSON_PROPERTY_ID) Integer id) {
        this();
        this.id = id;
    }

    /**
     * A unique identifier for each domain record.
     *
     * @return id
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "28448429", value = "A unique identifier for each domain record.")
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getId() {
        return id;
    }

    public DomainRecordSrv type(String type) {
        this.type = type;
        return this;
    }

    /**
     * The type of the DNS record. For example: A, CNAME, TXT, ...
     *
     * @return type
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "NS", required = true, value = "The type of the DNS record. For example: A, CNAME, TXT, ...")
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getType() {
        return type;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setType(String type) {
        this.type = type;
    }

    public DomainRecordSrv name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The host name, alias, or service being defined by the record.
     *
     * @return name
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "@", required = true, value = "The host name, alias, or service being defined by the record.")
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setName(String name) {
        this.name = name;
    }

    public DomainRecordSrv data(String data) {
        this.data = data;
        return this;
    }

    /**
     * Variable data depending on record type. For example, the \&quot;data\&quot;
     * value for an A record would be the IPv4 address to which the domain will be
     * mapped. For a CAA record, it would contain the domain name of the CA being
     * granted permission to issue certificates.
     *
     * @return data
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "ns1.digitalocean.com", required = true, value = "Variable data depending on record type. For example, the \"data\" value for an A record would be the IPv4 address to which the domain will be mapped. For a CAA record, it would contain the domain name of the CA being granted permission to issue certificates.")
    @JsonProperty(JSON_PROPERTY_DATA)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getData() {
        return data;
    }

    @JsonProperty(JSON_PROPERTY_DATA)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setData(String data) {
        this.data = data;
    }

    public DomainRecordSrv priority(Integer priority) {
        this.priority = priority;
        return this;
    }

    /**
     * The priority for SRV and MX records.
     *
     * @return priority
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(required = true, value = "The priority for SRV and MX records.")
    @JsonProperty(JSON_PROPERTY_PRIORITY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Integer getPriority() {
        return priority;
    }

    @JsonProperty(JSON_PROPERTY_PRIORITY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public DomainRecordSrv port(Integer port) {
        this.port = port;
        return this;
    }

    /**
     * The port for SRV records.
     *
     * @return port
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(required = true, value = "The port for SRV records.")
    @JsonProperty(JSON_PROPERTY_PORT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Integer getPort() {
        return port;
    }

    @JsonProperty(JSON_PROPERTY_PORT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setPort(Integer port) {
        this.port = port;
    }

    public DomainRecordSrv ttl(Integer ttl) {
        this.ttl = ttl;
        return this;
    }

    /**
     * This value is the time to live for the record, in seconds. This defines the
     * time frame that clients can cache queried information before a refresh should
     * be requested.
     *
     * @return ttl
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "1800", value = "This value is the time to live for the record, in seconds. This defines the time frame that clients can cache queried information before a refresh should be requested.")
    @JsonProperty(JSON_PROPERTY_TTL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getTtl() {
        return ttl;
    }

    @JsonProperty(JSON_PROPERTY_TTL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    public DomainRecordSrv weight(Integer weight) {
        this.weight = weight;
        return this;
    }

    /**
     * The weight for SRV records.
     *
     * @return weight
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The weight for SRV records.")
    @JsonProperty(JSON_PROPERTY_WEIGHT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getWeight() {
        return weight;
    }

    @JsonProperty(JSON_PROPERTY_WEIGHT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public DomainRecordSrv flags(Integer flags) {
        this.flags = flags;
        return this;
    }

    /**
     * An unsigned integer between 0-255 used for CAA records.
     *
     * @return flags
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(required = true, value = "An unsigned integer between 0-255 used for CAA records.")
    @JsonProperty(JSON_PROPERTY_FLAGS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Integer getFlags() {
        return flags;
    }

    @JsonProperty(JSON_PROPERTY_FLAGS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setFlags(Integer flags) {
        this.flags = flags;
    }

    public DomainRecordSrv tag(String tag) {
        this.tag = tag;
        return this;
    }

    /**
     * The parameter tag for CAA records. Valid values are \&quot;issue\&quot;,
     * \&quot;issuewild\&quot;, or \&quot;iodef\&quot;
     *
     * @return tag
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(required = true, value = "The parameter tag for CAA records. Valid values are \"issue\", \"issuewild\", or \"iodef\"")
    @JsonProperty(JSON_PROPERTY_TAG)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getTag() {
        return tag;
    }

    @JsonProperty(JSON_PROPERTY_TAG)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * Return true if this domain_record_srv object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DomainRecordSrv domainRecordSrv = (DomainRecordSrv) o;
        return Objects.equals(this.id, domainRecordSrv.id) && Objects.equals(this.type, domainRecordSrv.type)
                && Objects.equals(this.name, domainRecordSrv.name) && Objects.equals(this.data, domainRecordSrv.data)
                && Objects.equals(this.priority, domainRecordSrv.priority)
                && Objects.equals(this.port, domainRecordSrv.port) && Objects.equals(this.ttl, domainRecordSrv.ttl)
                && Objects.equals(this.weight, domainRecordSrv.weight)
                && Objects.equals(this.flags, domainRecordSrv.flags) && Objects.equals(this.tag, domainRecordSrv.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, data, priority, port, ttl, weight, flags, tag);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DomainRecordSrv {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
        sb.append("    port: ").append(toIndentedString(port)).append("\n");
        sb.append("    ttl: ").append(toIndentedString(ttl)).append("\n");
        sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
        sb.append("    flags: ").append(toIndentedString(flags)).append("\n");
        sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
