package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * DropletActionRenameAllOf
 */
@JsonPropertyOrder({ DropletActionRenameAllOf.JSON_PROPERTY_NAME })
public class DropletActionRenameAllOf {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public DropletActionRenameAllOf() {
    }

    public DropletActionRenameAllOf name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The new name for the Droplet.
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

    /**
     * Return true if this droplet_action_rename_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DropletActionRenameAllOf dropletActionRenameAllOf = (DropletActionRenameAllOf) o;
        return Objects.equals(this.name, dropletActionRenameAllOf.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DropletActionRenameAllOf {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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