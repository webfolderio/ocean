package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListAllRegionsResponse
 */
@JsonPropertyOrder({ ListAllRegionsResponse.JSON_PROPERTY_REGIONS, ListAllRegionsResponse.JSON_PROPERTY_LINKS,
        ListAllRegionsResponse.JSON_PROPERTY_META })
public class ListAllRegionsResponse {
    public static final String JSON_PROPERTY_REGIONS = "regions";
    private List<Region> regions = new ArrayList<>();

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public ListAllRegionsResponse() {
    }

    public ListAllRegionsResponse regions(List<Region> regions) {
        this.regions = regions;
        return this;
    }

    public ListAllRegionsResponse addRegionsItem(Region regionsItem) {
        this.regions.add(regionsItem);
        return this;
    }

    /**
     * Get regions
     *
     * @return regions
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_REGIONS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<Region> getRegions() {
        return regions;
    }

    @JsonProperty(JSON_PROPERTY_REGIONS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public ListAllRegionsResponse links(PageLinks links) {
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

    public ListAllRegionsResponse meta(MetaMeta meta) {
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
     * Return true if this list_all_regions_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListAllRegionsResponse listAllRegionsResponse = (ListAllRegionsResponse) o;
        return Objects.equals(this.regions, listAllRegionsResponse.regions)
                && Objects.equals(this.links, listAllRegionsResponse.links)
                && Objects.equals(this.meta, listAllRegionsResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regions, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListAllRegionsResponse {\n");
        sb.append("    regions: ").append(toIndentedString(regions)).append("\n");
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
