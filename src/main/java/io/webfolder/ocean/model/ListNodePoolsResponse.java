package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListNodePoolsResponse
 */
@JsonPropertyOrder({ ListNodePoolsResponse.JSON_PROPERTY_NODE_POOLS })
public class ListNodePoolsResponse {
    public static final String JSON_PROPERTY_NODE_POOLS = "node_pools";
    private List<KubernetesNodePool> nodePools = null;

    public ListNodePoolsResponse() {
    }

    public ListNodePoolsResponse nodePools(List<KubernetesNodePool> nodePools) {
        this.nodePools = nodePools;
        return this;
    }

    public ListNodePoolsResponse addNodePoolsItem(KubernetesNodePool nodePoolsItem) {
        if (this.nodePools == null) {
            this.nodePools = new ArrayList<>();
        }
        this.nodePools.add(nodePoolsItem);
        return this;
    }

    /**
     * Get nodePools
     *
     * @return nodePools
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NODE_POOLS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<KubernetesNodePool> getNodePools() {
        return nodePools;
    }

    @JsonProperty(JSON_PROPERTY_NODE_POOLS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setNodePools(List<KubernetesNodePool> nodePools) {
        this.nodePools = nodePools;
    }

    /**
     * Return true if this list_node_pools_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListNodePoolsResponse listNodePoolsResponse = (ListNodePoolsResponse) o;
        return Objects.equals(this.nodePools, listNodePoolsResponse.nodePools);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodePools);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListNodePoolsResponse {\n");
        sb.append("    nodePools: ").append(toIndentedString(nodePools)).append("\n");
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