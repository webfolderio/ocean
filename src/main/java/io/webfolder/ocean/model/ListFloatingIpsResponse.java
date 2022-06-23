package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListFloatingIpsResponse
 */
@JsonPropertyOrder({ ListFloatingIpsResponse.JSON_PROPERTY_FLOATING_IPS, ListFloatingIpsResponse.JSON_PROPERTY_LINKS,
        ListFloatingIpsResponse.JSON_PROPERTY_META })
public class ListFloatingIpsResponse {
    public static final String JSON_PROPERTY_FLOATING_IPS = "floating_ips";
    private List<FloatingIp> floatingIps = null;

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public ListFloatingIpsResponse() {
    }

    public ListFloatingIpsResponse floatingIps(List<FloatingIp> floatingIps) {
        this.floatingIps = floatingIps;
        return this;
    }

    public ListFloatingIpsResponse addFloatingIpsItem(FloatingIp floatingIpsItem) {
        if (this.floatingIps == null) {
            this.floatingIps = new ArrayList<>();
        }
        this.floatingIps.add(floatingIpsItem);
        return this;
    }

    /**
     * Get floatingIps
     *
     * @return floatingIps
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FLOATING_IPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<FloatingIp> getFloatingIps() {
        return floatingIps;
    }

    @JsonProperty(JSON_PROPERTY_FLOATING_IPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFloatingIps(List<FloatingIp> floatingIps) {
        this.floatingIps = floatingIps;
    }

    public ListFloatingIpsResponse links(PageLinks links) {
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

    public ListFloatingIpsResponse meta(MetaMeta meta) {
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
     * Return true if this list_floating_ips_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListFloatingIpsResponse listFloatingIpsResponse = (ListFloatingIpsResponse) o;
        return Objects.equals(this.floatingIps, listFloatingIpsResponse.floatingIps)
                && Objects.equals(this.links, listFloatingIpsResponse.links)
                && Objects.equals(this.meta, listFloatingIpsResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(floatingIps, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListFloatingIpsResponse {\n");
        sb.append("    floatingIps: ").append(toIndentedString(floatingIps)).append("\n");
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