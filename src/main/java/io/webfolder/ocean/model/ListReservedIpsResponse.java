package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListReservedIpsResponse
 */
@JsonPropertyOrder({ ListReservedIpsResponse.JSON_PROPERTY_RESERVED_IPS, ListReservedIpsResponse.JSON_PROPERTY_LINKS,
        ListReservedIpsResponse.JSON_PROPERTY_META })
public class ListReservedIpsResponse {
    public static final String JSON_PROPERTY_RESERVED_IPS = "reserved_ips";
    private List<ReservedIp> reservedIps = null;

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public ListReservedIpsResponse() {
    }

    public ListReservedIpsResponse reservedIps(List<ReservedIp> reservedIps) {
        this.reservedIps = reservedIps;
        return this;
    }

    public ListReservedIpsResponse addReservedIpsItem(ReservedIp reservedIpsItem) {
        if (this.reservedIps == null) {
            this.reservedIps = new ArrayList<>();
        }
        this.reservedIps.add(reservedIpsItem);
        return this;
    }

    /**
     * Get reservedIps
     *
     * @return reservedIps
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_RESERVED_IPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<ReservedIp> getReservedIps() {
        return reservedIps;
    }

    @JsonProperty(JSON_PROPERTY_RESERVED_IPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setReservedIps(List<ReservedIp> reservedIps) {
        this.reservedIps = reservedIps;
    }

    public ListReservedIpsResponse links(PageLinks links) {
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

    public ListReservedIpsResponse meta(MetaMeta meta) {
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
     * Return true if this list_reserved_ips_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListReservedIpsResponse listReservedIpsResponse = (ListReservedIpsResponse) o;
        return Objects.equals(this.reservedIps, listReservedIpsResponse.reservedIps)
                && Objects.equals(this.links, listReservedIpsResponse.links)
                && Objects.equals(this.meta, listReservedIpsResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservedIps, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListReservedIpsResponse {\n");
        sb.append("    reservedIps: ").append(toIndentedString(reservedIps)).append("\n");
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