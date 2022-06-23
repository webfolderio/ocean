package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * SingleDropletResponse
 */
@JsonPropertyOrder({ SingleDropletResponse.JSON_PROPERTY_DROPLET, SingleDropletResponse.JSON_PROPERTY_LINKS })
public class SingleDropletResponse {
    public static final String JSON_PROPERTY_DROPLET = "droplet";
    private Droplet droplet;

    public static final String JSON_PROPERTY_LINKS = "links";
    private SingleDropletResponseLinks links;

    public SingleDropletResponse() {
    }

    public SingleDropletResponse droplet(Droplet droplet) {
        this.droplet = droplet;
        return this;
    }

    /**
     * Get droplet
     *
     * @return droplet
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DROPLET)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Droplet getDroplet() {
        return droplet;
    }

    @JsonProperty(JSON_PROPERTY_DROPLET)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDroplet(Droplet droplet) {
        this.droplet = droplet;
    }

    public SingleDropletResponse links(SingleDropletResponseLinks links) {
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
     * Return true if this Single_Droplet_Response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SingleDropletResponse singleDropletResponse = (SingleDropletResponse) o;
        return Objects.equals(this.droplet, singleDropletResponse.droplet)
                && Objects.equals(this.links, singleDropletResponse.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(droplet, links);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SingleDropletResponse {\n");
        sb.append("    droplet: ").append(toIndentedString(droplet)).append("\n");
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