package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * VpcUpdatable
 */
@JsonPropertyOrder({ VpcUpdatable.JSON_PROPERTY_NAME, VpcUpdatable.JSON_PROPERTY_DESCRIPTION })
public class VpcUpdatable {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public VpcUpdatable() {
    }

    public VpcUpdatable name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the VPC. Must be unique and may only contain alphanumeric
     * characters, dashes, and periods.
     *
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setName(String name) {
        this.name = name;
    }

    public VpcUpdatable description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A free-form text field for describing the VPC&#39;s purpose. It may be a
     * maximum of 255 characters.
     *
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getDescription() {
        return description;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Return true if this vpc_updatable object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VpcUpdatable vpcUpdatable = (VpcUpdatable) o;
        return Objects.equals(this.name, vpcUpdatable.name)
                && Objects.equals(this.description, vpcUpdatable.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VpcUpdatable {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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