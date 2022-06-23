package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * MultipleDropletResponse
 */
@JsonPropertyOrder({ MultipleDropletResponse.JSON_PROPERTY_DROPLETS, MultipleDropletResponse.JSON_PROPERTY_LINKS })
public class MultipleDropletResponse {
    public static final String JSON_PROPERTY_DROPLETS = "droplets";
    private List<Droplet> droplets = new ArrayList<>();

    public static final String JSON_PROPERTY_LINKS = "links";
    private SingleDropletResponseLinks links;

    public MultipleDropletResponse() {
    }

    public MultipleDropletResponse droplets(List<Droplet> droplets) {
        this.droplets = droplets;
        return this;
    }

    public MultipleDropletResponse addDropletsItem(Droplet dropletsItem) {
        this.droplets.add(dropletsItem);
        return this;
    }

    /**
     * Get droplets
     *
     * @return droplets
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DROPLETS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<Droplet> getDroplets() {
        return droplets;
    }

    @JsonProperty(JSON_PROPERTY_DROPLETS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDroplets(List<Droplet> droplets) {
        this.droplets = droplets;
    }

    public MultipleDropletResponse links(SingleDropletResponseLinks links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     *
     * @return links
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_LINKS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public SingleDropletResponseLinks getLinks() {
        return links;
    }

    @JsonProperty(JSON_PROPERTY_LINKS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setLinks(SingleDropletResponseLinks links) {
        this.links = links;
    }

    /**
     * Return true if this Multiple_Droplet_Response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MultipleDropletResponse multipleDropletResponse = (MultipleDropletResponse) o;
        return Objects.equals(this.droplets, multipleDropletResponse.droplets)
                && Objects.equals(this.links, multipleDropletResponse.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(droplets, links);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MultipleDropletResponse {\n");
        sb.append("    droplets: ").append(toIndentedString(droplets)).append("\n");
        sb.append("    links: ").append(toIndentedString(links)).append("\n");
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