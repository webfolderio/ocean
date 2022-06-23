package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Metrics
 */
@JsonPropertyOrder({ Metrics.JSON_PROPERTY_DATA, Metrics.JSON_PROPERTY_STATUS })
public class Metrics {
    public static final String JSON_PROPERTY_DATA = "data";
    private MetricsData data;

    /**
     * Gets or Sets status
     */
    public enum StatusEnum {
        SUCCESS("success"),

        ERROR("error");

        private String value;

        StatusEnum(String value) {
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
        public static StatusEnum fromValue(String value) {
            for (StatusEnum b : StatusEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_STATUS = "status";
    private StatusEnum status;

    public Metrics() {
    }

    public Metrics data(MetricsData data) {
        this.data = data;
        return this;
    }

    /**
     * Get data
     *
     * @return data
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DATA)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public MetricsData getData() {
        return data;
    }

    @JsonProperty(JSON_PROPERTY_DATA)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setData(MetricsData data) {
        this.data = data;
    }

    public Metrics status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public StatusEnum getStatus() {
        return status;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    /**
     * Return true if this metrics object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Metrics metrics = (Metrics) o;
        return Objects.equals(this.data, metrics.data) && Objects.equals(this.status, metrics.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Metrics {\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
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