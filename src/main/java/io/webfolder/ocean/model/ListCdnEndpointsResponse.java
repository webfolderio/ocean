package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListCdnEndpointsResponse
 */
@JsonPropertyOrder({ ListCdnEndpointsResponse.JSON_PROPERTY_ENDPOINTS, ListCdnEndpointsResponse.JSON_PROPERTY_LINKS,
        ListCdnEndpointsResponse.JSON_PROPERTY_META })
public class ListCdnEndpointsResponse {
    public static final String JSON_PROPERTY_ENDPOINTS = "endpoints";
    private List<CdnEndpoint> endpoints = null;

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public ListCdnEndpointsResponse() {
    }

    public ListCdnEndpointsResponse endpoints(List<CdnEndpoint> endpoints) {
        this.endpoints = endpoints;
        return this;
    }

    public ListCdnEndpointsResponse addEndpointsItem(CdnEndpoint endpointsItem) {
        if (this.endpoints == null) {
            this.endpoints = new ArrayList<>();
        }
        this.endpoints.add(endpointsItem);
        return this;
    }

    /**
     * Get endpoints
     *
     * @return endpoints
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ENDPOINTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<CdnEndpoint> getEndpoints() {
        return endpoints;
    }

    @JsonProperty(JSON_PROPERTY_ENDPOINTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEndpoints(List<CdnEndpoint> endpoints) {
        this.endpoints = endpoints;
    }

    public ListCdnEndpointsResponse links(PageLinks links) {
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

    public ListCdnEndpointsResponse meta(MetaMeta meta) {
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
     * Return true if this list_cdn_endpoints_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListCdnEndpointsResponse listCdnEndpointsResponse = (ListCdnEndpointsResponse) o;
        return Objects.equals(this.endpoints, listCdnEndpointsResponse.endpoints)
                && Objects.equals(this.links, listCdnEndpointsResponse.links)
                && Objects.equals(this.meta, listCdnEndpointsResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endpoints, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListCdnEndpointsResponse {\n");
        sb.append("    endpoints: ").append(toIndentedString(endpoints)).append("\n");
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
