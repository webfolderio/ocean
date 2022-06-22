package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListAllLoadBalancersResponse
 */
@JsonPropertyOrder({ ListAllLoadBalancersResponse.JSON_PROPERTY_LOAD_BALANCERS,
        ListAllLoadBalancersResponse.JSON_PROPERTY_LINKS, ListAllLoadBalancersResponse.JSON_PROPERTY_META })
public class ListAllLoadBalancersResponse {
    public static final String JSON_PROPERTY_LOAD_BALANCERS = "load_balancers";
    private List<LoadBalancer> loadBalancers = null;

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public ListAllLoadBalancersResponse() {
    }

    public ListAllLoadBalancersResponse loadBalancers(List<LoadBalancer> loadBalancers) {
        this.loadBalancers = loadBalancers;
        return this;
    }

    public ListAllLoadBalancersResponse addLoadBalancersItem(LoadBalancer loadBalancersItem) {
        if (this.loadBalancers == null) {
            this.loadBalancers = new ArrayList<>();
        }
        this.loadBalancers.add(loadBalancersItem);
        return this;
    }

    /**
     * Get loadBalancers
     *
     * @return loadBalancers
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_LOAD_BALANCERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<LoadBalancer> getLoadBalancers() {
        return loadBalancers;
    }

    @JsonProperty(JSON_PROPERTY_LOAD_BALANCERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLoadBalancers(List<LoadBalancer> loadBalancers) {
        this.loadBalancers = loadBalancers;
    }

    public ListAllLoadBalancersResponse links(PageLinks links) {
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

    public ListAllLoadBalancersResponse meta(MetaMeta meta) {
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
     * Return true if this list_all_load_balancers_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListAllLoadBalancersResponse listAllLoadBalancersResponse = (ListAllLoadBalancersResponse) o;
        return Objects.equals(this.loadBalancers, listAllLoadBalancersResponse.loadBalancers)
                && Objects.equals(this.links, listAllLoadBalancersResponse.links)
                && Objects.equals(this.meta, listAllLoadBalancersResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loadBalancers, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListAllLoadBalancersResponse {\n");
        sb.append("    loadBalancers: ").append(toIndentedString(loadBalancers)).append("\n");
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
