package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Information about the response itself.
 */
@ApiModel(description = "Information about the response itself.")
@JsonPropertyOrder({ MetaProperties.JSON_PROPERTY_TOTAL })
public class MetaProperties {
    public static final String JSON_PROPERTY_TOTAL = "total";
    private Integer total;

    public MetaProperties() {
    }

    public MetaProperties total(Integer total) {
        this.total = total;
        return this;
    }

    /**
     * Number of objects returned by the request.
     *
     * @return total
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "1", value = "Number of objects returned by the request.")
    @JsonProperty(JSON_PROPERTY_TOTAL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getTotal() {
        return total;
    }

    @JsonProperty(JSON_PROPERTY_TOTAL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * Return true if this meta_properties object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MetaProperties metaProperties = (MetaProperties) o;
        return Objects.equals(this.total, metaProperties.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MetaProperties {\n");
        sb.append("    total: ").append(toIndentedString(total)).append("\n");
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
