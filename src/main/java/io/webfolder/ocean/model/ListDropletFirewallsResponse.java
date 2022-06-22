package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListDropletFirewallsResponse
 */
@JsonPropertyOrder({ ListDropletFirewallsResponse.JSON_PROPERTY_FIREWALLS,
        ListDropletFirewallsResponse.JSON_PROPERTY_LINKS, ListDropletFirewallsResponse.JSON_PROPERTY_META })
public class ListDropletFirewallsResponse {
    public static final String JSON_PROPERTY_FIREWALLS = "firewalls";
    private List<Firewall> firewalls = null;

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public ListDropletFirewallsResponse() {
    }

    public ListDropletFirewallsResponse firewalls(List<Firewall> firewalls) {
        this.firewalls = firewalls;
        return this;
    }

    public ListDropletFirewallsResponse addFirewallsItem(Firewall firewallsItem) {
        if (this.firewalls == null) {
            this.firewalls = new ArrayList<>();
        }
        this.firewalls.add(firewallsItem);
        return this;
    }

    /**
     * Get firewalls
     *
     * @return firewalls
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_FIREWALLS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Firewall> getFirewalls() {
        return firewalls;
    }

    @JsonProperty(JSON_PROPERTY_FIREWALLS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFirewalls(List<Firewall> firewalls) {
        this.firewalls = firewalls;
    }

    public ListDropletFirewallsResponse links(PageLinks links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     *
     * @return links
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
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

    public ListDropletFirewallsResponse meta(MetaMeta meta) {
        this.meta = meta;
        return this;
    }

    /**
     * Get meta
     *
     * @return meta
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")
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
     * Return true if this list_droplet_firewalls_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListDropletFirewallsResponse listDropletFirewallsResponse = (ListDropletFirewallsResponse) o;
        return Objects.equals(this.firewalls, listDropletFirewallsResponse.firewalls)
                && Objects.equals(this.links, listDropletFirewallsResponse.links)
                && Objects.equals(this.meta, listDropletFirewallsResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firewalls, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListDropletFirewallsResponse {\n");
        sb.append("    firewalls: ").append(toIndentedString(firewalls)).append("\n");
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
