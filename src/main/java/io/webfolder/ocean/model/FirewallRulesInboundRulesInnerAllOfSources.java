package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * FirewallRulesInboundRulesInnerAllOfSources
 */
@JsonPropertyOrder({ FirewallRulesInboundRulesInnerAllOfSources.JSON_PROPERTY_ADDRESSES,
        FirewallRulesInboundRulesInnerAllOfSources.JSON_PROPERTY_DROPLET_IDS,
        FirewallRulesInboundRulesInnerAllOfSources.JSON_PROPERTY_LOAD_BALANCER_UIDS,
        FirewallRulesInboundRulesInnerAllOfSources.JSON_PROPERTY_KUBERNETES_IDS,
        FirewallRulesInboundRulesInnerAllOfSources.JSON_PROPERTY_TAGS })
public class FirewallRulesInboundRulesInnerAllOfSources {
    public static final String JSON_PROPERTY_ADDRESSES = "addresses";
    private List<String> addresses = null;

    public static final String JSON_PROPERTY_DROPLET_IDS = "droplet_ids";
    private List<Integer> dropletIds = null;

    public static final String JSON_PROPERTY_LOAD_BALANCER_UIDS = "load_balancer_uids";
    private List<String> loadBalancerUids = null;

    public static final String JSON_PROPERTY_KUBERNETES_IDS = "kubernetes_ids";
    private List<String> kubernetesIds = null;

    public static final String JSON_PROPERTY_TAGS = "tags";
    private List<Tag> tags;

    public FirewallRulesInboundRulesInnerAllOfSources() {
    }

    public FirewallRulesInboundRulesInnerAllOfSources addresses(List<String> addresses) {
        this.addresses = addresses;
        return this;
    }

    public FirewallRulesInboundRulesInnerAllOfSources addAddressesItem(String addressesItem) {
        if (this.addresses == null) {
            this.addresses = new ArrayList<>();
        }
        this.addresses.add(addressesItem);
        return this;
    }

    /**
     * An array of strings containing the IPv4 addresses, IPv6 addresses, IPv4
     * CIDRs, and/or IPv6 CIDRs to which the firewall will allow traffic.
     *
     * @return addresses
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ADDRESSES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getAddresses() {
        return addresses;
    }

    @JsonProperty(JSON_PROPERTY_ADDRESSES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    public FirewallRulesInboundRulesInnerAllOfSources dropletIds(List<Integer> dropletIds) {
        this.dropletIds = dropletIds;
        return this;
    }

    public FirewallRulesInboundRulesInnerAllOfSources addDropletIdsItem(Integer dropletIdsItem) {
        if (this.dropletIds == null) {
            this.dropletIds = new ArrayList<>();
        }
        this.dropletIds.add(dropletIdsItem);
        return this;
    }

    /**
     * An array containing the IDs of the Droplets to which the firewall will allow
     * traffic.
     *
     * @return dropletIds
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DROPLET_IDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Integer> getDropletIds() {
        return dropletIds;
    }

    @JsonProperty(JSON_PROPERTY_DROPLET_IDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDropletIds(List<Integer> dropletIds) {
        this.dropletIds = dropletIds;
    }

    public FirewallRulesInboundRulesInnerAllOfSources loadBalancerUids(List<String> loadBalancerUids) {
        this.loadBalancerUids = loadBalancerUids;
        return this;
    }

    public FirewallRulesInboundRulesInnerAllOfSources addLoadBalancerUidsItem(String loadBalancerUidsItem) {
        if (this.loadBalancerUids == null) {
            this.loadBalancerUids = new ArrayList<>();
        }
        this.loadBalancerUids.add(loadBalancerUidsItem);
        return this;
    }

    /**
     * An array containing the IDs of the load balancers to which the firewall will
     * allow traffic.
     *
     * @return loadBalancerUids
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LOAD_BALANCER_UIDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getLoadBalancerUids() {
        return loadBalancerUids;
    }

    @JsonProperty(JSON_PROPERTY_LOAD_BALANCER_UIDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLoadBalancerUids(List<String> loadBalancerUids) {
        this.loadBalancerUids = loadBalancerUids;
    }

    public FirewallRulesInboundRulesInnerAllOfSources kubernetesIds(List<String> kubernetesIds) {
        this.kubernetesIds = kubernetesIds;
        return this;
    }

    public FirewallRulesInboundRulesInnerAllOfSources addKubernetesIdsItem(String kubernetesIdsItem) {
        if (this.kubernetesIds == null) {
            this.kubernetesIds = new ArrayList<>();
        }
        this.kubernetesIds.add(kubernetesIdsItem);
        return this;
    }

    /**
     * An array containing the IDs of the Kubernetes clusters to which the firewall
     * will allow traffic.
     *
     * @return kubernetesIds
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_KUBERNETES_IDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getKubernetesIds() {
        return kubernetesIds;
    }

    @JsonProperty(JSON_PROPERTY_KUBERNETES_IDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setKubernetesIds(List<String> kubernetesIds) {
        this.kubernetesIds = kubernetesIds;
    }

    public FirewallRulesInboundRulesInnerAllOfSources tags(List<Tag> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Get tags
     *
     * @return tags
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Tag> getTags() {
        return tags;
    }

    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    /**
     * Return true if this firewall_rules_inbound_rules_inner_allOf_sources object
     * is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FirewallRulesInboundRulesInnerAllOfSources firewallRulesInboundRulesInnerAllOfSources = (FirewallRulesInboundRulesInnerAllOfSources) o;
        return Objects.equals(this.addresses, firewallRulesInboundRulesInnerAllOfSources.addresses)
                && Objects.equals(this.dropletIds, firewallRulesInboundRulesInnerAllOfSources.dropletIds)
                && Objects.equals(this.loadBalancerUids, firewallRulesInboundRulesInnerAllOfSources.loadBalancerUids)
                && Objects.equals(this.kubernetesIds, firewallRulesInboundRulesInnerAllOfSources.kubernetesIds)
                && Objects.equals(this.tags, firewallRulesInboundRulesInnerAllOfSources.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addresses, dropletIds, loadBalancerUids, kubernetesIds, tags);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FirewallRulesInboundRulesInnerAllOfSources {\n");
        sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
        sb.append("    dropletIds: ").append(toIndentedString(dropletIds)).append("\n");
        sb.append("    loadBalancerUids: ").append(toIndentedString(loadBalancerUids)).append("\n");
        sb.append("    kubernetesIds: ").append(toIndentedString(kubernetesIds)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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
