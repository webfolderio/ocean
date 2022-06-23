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
 * MetricsData
 */
@JsonPropertyOrder({ MetricsData.JSON_PROPERTY_RESULT, MetricsData.JSON_PROPERTY_RESULT_TYPE })
public class MetricsData {
    public static final String JSON_PROPERTY_RESULT = "result";
    private List<MetricsResult> result = new ArrayList<>();

    /**
     * Gets or Sets resultType
     */
    public enum ResultTypeEnum {
        MATRIX("matrix");

        private String value;

        ResultTypeEnum(String value) {
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
        public static ResultTypeEnum fromValue(String value) {
            for (ResultTypeEnum b : ResultTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_RESULT_TYPE = "resultType";
    private ResultTypeEnum resultType;

    public MetricsData() {
    }

    public MetricsData result(List<MetricsResult> result) {
        this.result = result;
        return this;
    }

    public MetricsData addResultItem(MetricsResult resultItem) {
        this.result.add(resultItem);
        return this;
    }

    /**
     * Result of query.
     *
     * @return result
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_RESULT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<MetricsResult> getResult() {
        return result;
    }

    @JsonProperty(JSON_PROPERTY_RESULT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setResult(List<MetricsResult> result) {
        this.result = result;
    }

    public MetricsData resultType(ResultTypeEnum resultType) {
        this.resultType = resultType;
        return this;
    }

    /**
     * Get resultType
     *
     * @return resultType
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_RESULT_TYPE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public ResultTypeEnum getResultType() {
        return resultType;
    }

    @JsonProperty(JSON_PROPERTY_RESULT_TYPE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setResultType(ResultTypeEnum resultType) {
        this.resultType = resultType;
    }

    /**
     * Return true if this metrics_data object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MetricsData metricsData = (MetricsData) o;
        return Objects.equals(this.result, metricsData.result)
                && Objects.equals(this.resultType, metricsData.resultType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, resultType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MetricsData {\n");
        sb.append("    result: ").append(toIndentedString(result)).append("\n");
        sb.append("    resultType: ").append(toIndentedString(resultType)).append("\n");
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