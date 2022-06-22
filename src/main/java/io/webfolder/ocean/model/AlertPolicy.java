package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * AlertPolicy
 */
@JsonPropertyOrder({ AlertPolicy.JSON_PROPERTY_ALERTS, AlertPolicy.JSON_PROPERTY_COMPARE,
        AlertPolicy.JSON_PROPERTY_DESCRIPTION, AlertPolicy.JSON_PROPERTY_ENABLED, AlertPolicy.JSON_PROPERTY_ENTITIES,
        AlertPolicy.JSON_PROPERTY_TAGS, AlertPolicy.JSON_PROPERTY_TYPE, AlertPolicy.JSON_PROPERTY_UUID,
        AlertPolicy.JSON_PROPERTY_VALUE, AlertPolicy.JSON_PROPERTY_WINDOW })
public class AlertPolicy {
    public static final String JSON_PROPERTY_ALERTS = "alerts";
    private Alerts alerts;

    /**
     * Gets or Sets compare
     */
    public enum CompareEnum {
        GREATERTHAN("GreaterThan"),

        LESSTHAN("LessThan");

        private String value;

        CompareEnum(String value) {
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
        public static CompareEnum fromValue(String value) {
            for (CompareEnum b : CompareEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_COMPARE = "compare";
    private CompareEnum compare;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_ENABLED = "enabled";
    private Boolean enabled;

    public static final String JSON_PROPERTY_ENTITIES = "entities";
    private List<String> entities = new ArrayList<>();

    public static final String JSON_PROPERTY_TAGS = "tags";
    private List<String> tags = new ArrayList<>();

    /**
     * Gets or Sets type
     */
    public enum TypeEnum {
        DROPLET_LOAD_1("v1/insights/droplet/load_1"),

        DROPLET_LOAD_5("v1/insights/droplet/load_5"),

        DROPLET_LOAD_15("v1/insights/droplet/load_15"),

        DROPLET_MEMORY_UTILIZATION_PERCENT("v1/insights/droplet/memory_utilization_percent"),

        DROPLET_DISK_UTILIZATION_PERCENT("v1/insights/droplet/disk_utilization_percent"),

        DROPLET_CPU("v1/insights/droplet/cpu"),

        DROPLET_DISK_READ("v1/insights/droplet/disk_read"),

        DROPLET_DISK_WRITE("v1/insights/droplet/disk_write"),

        DROPLET_PUBLIC_OUTBOUND_BANDWIDTH("v1/insights/droplet/public_outbound_bandwidth"),

        DROPLET_PUBLIC_INBOUND_BANDWIDTH("v1/insights/droplet/public_inbound_bandwidth"),

        DROPLET_PRIVATE_OUTBOUND_BANDWIDTH("v1/insights/droplet/private_outbound_bandwidth"),

        DROPLET_PRIVATE_INBOUND_BANDWIDTH("v1/insights/droplet/private_inbound_bandwidth"),

        LBAAS_AVG_CPU_UTILIZATION_PERCENT("v1/insights/lbaas/avg_cpu_utilization_percent"),

        LBAAS_CONNECTION_UTILIZATION_PERCENT("v1/insights/lbaas/connection_utilization_percent"),

        LBAAS_DROPLET_HEALTH("v1/insights/lbaas/droplet_health"),

        LBAAS_TLS_CONNECTIONS_PER_SECOND_UTILIZATION_PERCENT(
                "v1/insights/lbaas/tls_connections_per_second_utilization_percent");

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

    public static final String JSON_PROPERTY_UUID = "uuid";
    private String uuid;

    public static final String JSON_PROPERTY_VALUE = "value";
    private Float value;

    /**
     * Gets or Sets window
     */
    public enum WindowEnum {
        _5M("5m"),

        _10M("10m"),

        _30M("30m"),

        _1H("1h");

        private String value;

        WindowEnum(String value) {
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
        public static WindowEnum fromValue(String value) {
            for (WindowEnum b : WindowEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_WINDOW = "window";
    private WindowEnum window;

    public AlertPolicy() {
    }

    public AlertPolicy alerts(Alerts alerts) {
        this.alerts = alerts;
        return this;
    }

    /**
     * Get alerts
     *
     * @return alerts
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ALERTS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Alerts getAlerts() {
        return alerts;
    }

    @JsonProperty(JSON_PROPERTY_ALERTS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setAlerts(Alerts alerts) {
        this.alerts = alerts;
    }

    public AlertPolicy compare(CompareEnum compare) {
        this.compare = compare;
        return this;
    }

    /**
     * Get compare
     *
     * @return compare
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_COMPARE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public CompareEnum getCompare() {
        return compare;
    }

    @JsonProperty(JSON_PROPERTY_COMPARE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setCompare(CompareEnum compare) {
        this.compare = compare;
    }

    public AlertPolicy description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getDescription() {
        return description;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDescription(String description) {
        this.description = description;
    }

    public AlertPolicy enabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Get enabled
     *
     * @return enabled
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ENABLED)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Boolean getEnabled() {
        return enabled;
    }

    @JsonProperty(JSON_PROPERTY_ENABLED)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public AlertPolicy entities(List<String> entities) {
        this.entities = entities;
        return this;
    }

    public AlertPolicy addEntitiesItem(String entitiesItem) {
        this.entities.add(entitiesItem);
        return this;
    }

    /**
     * Get entities
     *
     * @return entities
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ENTITIES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<String> getEntities() {
        return entities;
    }

    @JsonProperty(JSON_PROPERTY_ENTITIES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setEntities(List<String> entities) {
        this.entities = entities;
    }

    public AlertPolicy tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public AlertPolicy addTagsItem(String tagsItem) {
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * Get tags
     *
     * @return tags
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<String> getTags() {
        return tags;
    }

    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public AlertPolicy type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
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

    public AlertPolicy uuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    /**
     * Get uuid
     *
     * @return uuid
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_UUID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getUuid() {
        return uuid;
    }

    @JsonProperty(JSON_PROPERTY_UUID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public AlertPolicy value(Float value) {
        this.value = value;
        return this;
    }

    /**
     * Get value
     *
     * @return value
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_VALUE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Float getValue() {
        return value;
    }

    @JsonProperty(JSON_PROPERTY_VALUE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setValue(Float value) {
        this.value = value;
    }

    public AlertPolicy window(WindowEnum window) {
        this.window = window;
        return this;
    }

    /**
     * Get window
     *
     * @return window
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_WINDOW)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public WindowEnum getWindow() {
        return window;
    }

    @JsonProperty(JSON_PROPERTY_WINDOW)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setWindow(WindowEnum window) {
        this.window = window;
    }

    /**
     * Return true if this alert_policy object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AlertPolicy alertPolicy = (AlertPolicy) o;
        return Objects.equals(this.alerts, alertPolicy.alerts) && Objects.equals(this.compare, alertPolicy.compare)
                && Objects.equals(this.description, alertPolicy.description)
                && Objects.equals(this.enabled, alertPolicy.enabled)
                && Objects.equals(this.entities, alertPolicy.entities) && Objects.equals(this.tags, alertPolicy.tags)
                && Objects.equals(this.type, alertPolicy.type) && Objects.equals(this.uuid, alertPolicy.uuid)
                && Objects.equals(this.value, alertPolicy.value) && Objects.equals(this.window, alertPolicy.window);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alerts, compare, description, enabled, entities, tags, type, uuid, value, window);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AlertPolicy {\n");
        sb.append("    alerts: ").append(toIndentedString(alerts)).append("\n");
        sb.append("    compare: ").append(toIndentedString(compare)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    entities: ").append(toIndentedString(entities)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    window: ").append(toIndentedString(window)).append("\n");
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
