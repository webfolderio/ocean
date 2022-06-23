package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListAllDropletsResponse
 */
@JsonPropertyOrder({ ListAllDropletsResponse.JSON_PROPERTY_DROPLETS, ListAllDropletsResponse.JSON_PROPERTY_LINKS,
        ListAllDropletsResponse.JSON_PROPERTY_META })
public class ListAllDropletsResponse {
    public static final String JSON_PROPERTY_DROPLETS = "droplets";
    private List<Droplet> droplets = null;

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public ListAllDropletsResponse() {
    }

    public ListAllDropletsResponse droplets(List<Droplet> droplets) {
        this.droplets = droplets;
        return this;
    }

    public ListAllDropletsResponse addDropletsItem(Droplet dropletsItem) {
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

    public ListAllDropletsResponse links(PageLinks links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     *
     * @return links
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LINKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public PageLinks getLinks() {
        return links;
    }

    @JsonProperty(JSON_PROPERTY_LINKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLinks(PageLinks links) {
        this.links = links;
    }

    public ListAllDropletsResponse meta(MetaMeta meta) {
        this.meta = meta;
        return this;
    }

    /**
     * Get meta
     *
     * @return meta
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_META)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public MetaMeta getMeta() {
        return meta;
    }

    @JsonProperty(JSON_PROPERTY_META)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setMeta(MetaMeta meta) {
        this.meta = meta;
    }

    /**
     * Return true if this list_all_droplets_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListAllDropletsResponse listAllDropletsResponse = (ListAllDropletsResponse) o;
        return Objects.equals(this.droplets, listAllDropletsResponse.droplets)
                && Objects.equals(this.links, listAllDropletsResponse.links)
                && Objects.equals(this.meta, listAllDropletsResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(droplets, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListAllDropletsResponse {\n");
        sb.append("    droplets: ").append(toIndentedString(droplets)).append("\n");
        sb.append("    links: ").append(toIndentedString(links)).append("\n");
        sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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