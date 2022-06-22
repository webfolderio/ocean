package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * DropletMultiCreateAllOf
 */
@JsonPropertyOrder({ DropletMultiCreateAllOf.JSON_PROPERTY_NAMES })
public class DropletMultiCreateAllOf {
    public static final String JSON_PROPERTY_NAMES = "names";
    private List<String> names = new ArrayList<>();

    public DropletMultiCreateAllOf() {
    }

    public DropletMultiCreateAllOf names(List<String> names) {
        this.names = names;
        return this;
    }

    public DropletMultiCreateAllOf addNamesItem(String namesItem) {
        this.names.add(namesItem);
        return this;
    }

    /**
     * An array of human human-readable strings you wish to use when displaying the
     * Droplet name. Each name, if set to a domain name managed in the DigitalOcean
     * DNS management system, will configure a PTR record for the Droplet. Each name
     * set during creation will also determine the hostname for the Droplet in its
     * internal configuration.
     *
     * @return names
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_NAMES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<String> getNames() {
        return names;
    }

    @JsonProperty(JSON_PROPERTY_NAMES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setNames(List<String> names) {
        this.names = names;
    }

    /**
     * Return true if this droplet_multi_create_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DropletMultiCreateAllOf dropletMultiCreateAllOf = (DropletMultiCreateAllOf) o;
        return Objects.equals(this.names, dropletMultiCreateAllOf.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DropletMultiCreateAllOf {\n");
        sb.append("    names: ").append(toIndentedString(names)).append("\n");
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
