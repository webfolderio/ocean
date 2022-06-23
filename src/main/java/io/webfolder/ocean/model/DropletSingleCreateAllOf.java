package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * DropletSingleCreateAllOf
 */
@JsonPropertyOrder({ DropletSingleCreateAllOf.JSON_PROPERTY_NAME })
public class DropletSingleCreateAllOf {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public DropletSingleCreateAllOf() {
    }

    public DropletSingleCreateAllOf name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The human-readable string you wish to use when displaying the Droplet name.
     * The name, if set to a domain name managed in the DigitalOcean DNS management
     * system, will configure a PTR record for the Droplet. The name set during
     * creation will also determine the hostname for the Droplet in its internal
     * configuration.
     *
     * @return name
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return true if this droplet_single_create_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DropletSingleCreateAllOf dropletSingleCreateAllOf = (DropletSingleCreateAllOf) o;
        return Objects.equals(this.name, dropletSingleCreateAllOf.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DropletSingleCreateAllOf {\n");
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