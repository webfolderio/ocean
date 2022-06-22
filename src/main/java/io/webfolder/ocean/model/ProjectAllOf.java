package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ProjectAllOf
 */
@JsonPropertyOrder({ ProjectAllOf.JSON_PROPERTY_IS_DEFAULT })
public class ProjectAllOf {
    public static final String JSON_PROPERTY_IS_DEFAULT = "is_default";
    private Boolean isDefault;

    public ProjectAllOf() {
    }

    public ProjectAllOf isDefault(Boolean isDefault) {
        this.isDefault = isDefault;
        return this;
    }

    /**
     * If true, all resources will be added to this project if no project is
     * specified.
     *
     * @return isDefault
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_IS_DEFAULT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getIsDefault() {
        return isDefault;
    }

    @JsonProperty(JSON_PROPERTY_IS_DEFAULT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * Return true if this project_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProjectAllOf projectAllOf = (ProjectAllOf) o;
        return Objects.equals(this.isDefault, projectAllOf.isDefault);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isDefault);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProjectAllOf {\n");
        sb.append("    isDefault: ").append(toIndentedString(isDefault)).append("\n");
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
