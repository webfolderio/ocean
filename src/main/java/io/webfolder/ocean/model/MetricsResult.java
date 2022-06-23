package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * MetricsResult
 */
@JsonPropertyOrder({ MetricsResult.JSON_PROPERTY_METRIC, MetricsResult.JSON_PROPERTY_VALUES })
public class MetricsResult {
    public static final String JSON_PROPERTY_METRIC = "metric";
    private Map<String, String> metric = new HashMap<>();

    public static final String JSON_PROPERTY_VALUES = "values";
    private List<List<MetricsResultValuesInnerInner>> values = new ArrayList<>();

    public MetricsResult() {
    }

    public MetricsResult metric(Map<String, String> metric) {
        this.metric = metric;
        return this;
    }

    public MetricsResult putMetricItem(String key, String metricItem) {
        this.metric.put(key, metricItem);
        return this;
    }

    /**
     * An object containing the metric labels.
     *
     * @return metric
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_METRIC)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Map<String, String> getMetric() {
        return metric;
    }

    @JsonProperty(JSON_PROPERTY_METRIC)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setMetric(Map<String, String> metric) {
        this.metric = metric;
    }

    public MetricsResult values(List<List<MetricsResultValuesInnerInner>> values) {
        this.values = values;
        return this;
    }

    public MetricsResult addValuesItem(List<MetricsResultValuesInnerInner> valuesItem) {
        this.values.add(valuesItem);
        return this;
    }

    /**
     * Get values
     *
     * @return values
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_VALUES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<List<MetricsResultValuesInnerInner>> getValues() {
        return values;
    }

    @JsonProperty(JSON_PROPERTY_VALUES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setValues(List<List<MetricsResultValuesInnerInner>> values) {
        this.values = values;
    }

    /**
     * Return true if this metrics_result object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MetricsResult metricsResult = (MetricsResult) o;
        return Objects.equals(this.metric, metricsResult.metric) && Objects.equals(this.values, metricsResult.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metric, values);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MetricsResult {\n");
        sb.append("    metric: ").append(toIndentedString(metric)).append("\n");
        sb.append("    values: ").append(toIndentedString(values)).append("\n");
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