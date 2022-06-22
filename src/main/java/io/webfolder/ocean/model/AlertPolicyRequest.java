package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * AlertPolicyRequest
 */
@JsonPropertyOrder({ AlertPolicyRequest.JSON_PROPERTY_ALERTS, AlertPolicyRequest.JSON_PROPERTY_COMPARE,
        AlertPolicyRequest.JSON_PROPERTY_DESCRIPTION, AlertPolicyRequest.JSON_PROPERTY_ENABLED,
        AlertPolicyRequest.JSON_PROPERTY_ENTITIES, AlertPolicyRequest.JSON_PROPERTY_TAGS,
        AlertPolicyRequest.JSON_PROPERTY_TYPE, AlertPolicyRequest.JSON_PROPERTY_VALUE,
        AlertPolicyRequest.JSON_PROPERTY_WINDOW })
public class AlertPolicyRequest {
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

    public AlertPolicyRequest() {
    }

    public AlertPolicyRequest alerts(Alerts alerts) {
        this.alerts = alerts;
        return this;
    }

    /**
     * Get alerts
     *
     * @return alerts
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")
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

    public AlertPolicyRequest compare(CompareEnum compare) {
        this.compare = compare;
        return this;
    }

    /**
     * Get compare
     *
     * @return compare
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "GreaterThan", required = true, value = "")
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

    public AlertPolicyRequest description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "CPU Alert", required = true, value = "")
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

    public AlertPolicyRequest enabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Get enabled
     *
     * @return enabled
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "true", required = true, value = "")
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

    public AlertPolicyRequest entities(List<String> entities) {
        this.entities = entities;
        return this;
    }

    public AlertPolicyRequest addEntitiesItem(String entitiesItem) {
        this.entities.add(entitiesItem);
        return this;
    }

    /**
     * Get entities
     *
     * @return entities
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "[\"192018292\"]", required = true, value = "")
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

    public AlertPolicyRequest tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public AlertPolicyRequest addTagsItem(String tagsItem) {
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * Get tags
     *
     * @return tags
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "[\"droplet_tag\"]", required = true, value = "")
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

    public AlertPolicyRequest type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "v1/insights/droplet/cpu", required = true, value = "")
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

    public AlertPolicyRequest value(Float value) {
        this.value = value;
        return this;
    }

    /**
     * Get value
     *
     * @return value
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "80", required = true, value = "")
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

    public AlertPolicyRequest window(WindowEnum window) {
        this.window = window;
        return this;
    }

    /**
     * Get window
     *
     * @return window
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "5m", required = true, value = "")
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
     * Return true if this alert_policy_request object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AlertPolicyRequest alertPolicyRequest = (AlertPolicyRequest) o;
        return Objects.equals(this.alerts, alertPolicyRequest.alerts)
                && Objects.equals(this.compare, alertPolicyRequest.compare)
                && Objects.equals(this.description, alertPolicyRequest.description)
                && Objects.equals(this.enabled, alertPolicyRequest.enabled)
                && Objects.equals(this.entities, alertPolicyRequest.entities)
                && Objects.equals(this.tags, alertPolicyRequest.tags)
                && Objects.equals(this.type, alertPolicyRequest.type)
                && Objects.equals(this.value, alertPolicyRequest.value)
                && Objects.equals(this.window, alertPolicyRequest.window);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alerts, compare, description, enabled, entities, tags, type, value, window);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AlertPolicyRequest {\n");
        sb.append("    alerts: ").append(toIndentedString(alerts)).append("\n");
        sb.append("    compare: ").append(toIndentedString(compare)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    entities: ").append(toIndentedString(entities)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
