package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListVpcsResponse
 */
@JsonPropertyOrder({ ListVpcsResponse.JSON_PROPERTY_VPCS, ListVpcsResponse.JSON_PROPERTY_LINKS,
        ListVpcsResponse.JSON_PROPERTY_META })
public class ListVpcsResponse {
    public static final String JSON_PROPERTY_VPCS = "vpcs";
    private List<Vpc> vpcs = null;

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public ListVpcsResponse() {
    }

    public ListVpcsResponse vpcs(List<Vpc> vpcs) {
        this.vpcs = vpcs;
        return this;
    }

    public ListVpcsResponse addVpcsItem(Vpc vpcsItem) {
        if (this.vpcs == null) {
            this.vpcs = new ArrayList<>();
        }
        this.vpcs.add(vpcsItem);
        return this;
    }

    /**
     * Get vpcs
     *
     * @return vpcs
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_VPCS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<Vpc> getVpcs() {
        return vpcs;
    }

    @JsonProperty(JSON_PROPERTY_VPCS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVpcs(List<Vpc> vpcs) {
        this.vpcs = vpcs;
    }

    public ListVpcsResponse links(PageLinks links) {
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

    public ListVpcsResponse meta(MetaMeta meta) {
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
     * Return true if this list_vpcs_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListVpcsResponse listVpcsResponse = (ListVpcsResponse) o;
        return Objects.equals(this.vpcs, listVpcsResponse.vpcs) && Objects.equals(this.links, listVpcsResponse.links)
                && Objects.equals(this.meta, listVpcsResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vpcs, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListVpcsResponse {\n");
        sb.append("    vpcs: ").append(toIndentedString(vpcs)).append("\n");
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