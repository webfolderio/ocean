package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * FirewallRule
 */
@JsonPropertyOrder({ FirewallRule.JSON_PROPERTY_UUID, FirewallRule.JSON_PROPERTY_CLUSTER_UUID,
        FirewallRule.JSON_PROPERTY_TYPE, FirewallRule.JSON_PROPERTY_VALUE, FirewallRule.JSON_PROPERTY_CREATED_AT })
public class FirewallRule {
    public static final String JSON_PROPERTY_UUID = "uuid";
    private String uuid;

    public static final String JSON_PROPERTY_CLUSTER_UUID = "cluster_uuid";
    private String clusterUuid;

    /**
     * The type of resource that the firewall rule allows to access the database
     * cluster.
     */
    public enum TypeEnum {
        DROPLET("droplet"),

        K8S("k8s"),

        IP_ADDR("ip_addr"),

        TAG("tag"),

        APP("app");

        private String value;

        TypeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static TypeEnum fromValue(String value) {
            for (TypeEnum b : TypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_TYPE = "type";
    private TypeEnum type;

    public static final String JSON_PROPERTY_VALUE = "value";
    private String value;

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    private OffsetDateTime createdAt;

    public FirewallRule() {
    }

    @JsonCreator
    public FirewallRule(@JsonProperty(JSON_PROPERTY_CREATED_AT) OffsetDateTime createdAt) {
        this();
        this.createdAt = createdAt;
    }

    public FirewallRule uuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    /**
     * A unique ID for the firewall rule itself.
     *
     * @return uuid
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_UUID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getUuid() {
        return uuid;
    }

    @JsonProperty(JSON_PROPERTY_UUID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public FirewallRule clusterUuid(String clusterUuid) {
        this.clusterUuid = clusterUuid;
        return this;
    }

    /**
     * A unique ID for the database cluster to which the rule is applied.
     *
     * @return clusterUuid
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CLUSTER_UUID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getClusterUuid() {
        return clusterUuid;
    }

    @JsonProperty(JSON_PROPERTY_CLUSTER_UUID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setClusterUuid(String clusterUuid) {
        this.clusterUuid = clusterUuid;
    }

    public FirewallRule type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * The type of resource that the firewall rule allows to access the database
     * cluster.
     *
     * @return type
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public TypeEnum getType() {
        return type;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setType(TypeEnum type) {
        this.type = type;
    }

    public FirewallRule value(String value) {
        this.value = value;
        return this;
    }

    /**
     * The ID of the specific resource, the name of a tag applied to a group of
     * resources, or the IP address that the firewall rule allows to access the
     * database cluster.
     *
     * @return value
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_VALUE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getValue() {
        return value;
    }

    @JsonProperty(JSON_PROPERTY_VALUE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * A time value given in ISO8601 combined date and time format that represents
     * when the firewall rule was created.
     *
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Return true if this firewall_rule object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FirewallRule firewallRule = (FirewallRule) o;
        return Objects.equals(this.uuid, firewallRule.uuid)
                && Objects.equals(this.clusterUuid, firewallRule.clusterUuid)
                && Objects.equals(this.type, firewallRule.type) && Objects.equals(this.value, firewallRule.value)
                && Objects.equals(this.createdAt, firewallRule.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, clusterUuid, type, value, createdAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FirewallRule {\n");
        sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    clusterUuid: ").append(toIndentedString(clusterUuid)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
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