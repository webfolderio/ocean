package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListAllDropletsResponseAllOf
 */
@JsonPropertyOrder({ ListAllDropletsResponseAllOf.JSON_PROPERTY_DROPLETS })
public class ListAllDropletsResponseAllOf {
    public static final String JSON_PROPERTY_DROPLETS = "droplets";
    private List<Droplet> droplets = null;

    public ListAllDropletsResponseAllOf() {
    }

    public ListAllDropletsResponseAllOf droplets(List<Droplet> droplets) {
        this.droplets = droplets;
        return this;
    }

    public ListAllDropletsResponseAllOf addDropletsItem(Droplet dropletsItem) {
        if (this.droplets == null) {
            this.droplets = new ArrayList<>();
        }
        this.droplets.add(dropletsItem);
        return this;
    }

    /**
     * Get droplets
     *
     * @return droplets
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DROPLETS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Droplet> getDroplets() {
        return droplets;
    }

    @JsonProperty(JSON_PROPERTY_DROPLETS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDroplets(List<Droplet> droplets) {
        this.droplets = droplets;
    }

    /**
     * Return true if this list_all_droplets_response_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListAllDropletsResponseAllOf listAllDropletsResponseAllOf = (ListAllDropletsResponseAllOf) o;
        return Objects.equals(this.droplets, listAllDropletsResponseAllOf.droplets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(droplets);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListAllDropletsResponseAllOf {\n");
        sb.append("    droplets: ").append(toIndentedString(droplets)).append("\n");
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
