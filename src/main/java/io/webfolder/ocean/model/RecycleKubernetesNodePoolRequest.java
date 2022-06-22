package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * RecycleKubernetesNodePoolRequest
 */
@JsonPropertyOrder({ RecycleKubernetesNodePoolRequest.JSON_PROPERTY_NODES })
public class RecycleKubernetesNodePoolRequest {
    public static final String JSON_PROPERTY_NODES = "nodes";
    private List<String> nodes = null;

    public RecycleKubernetesNodePoolRequest() {
    }

    public RecycleKubernetesNodePoolRequest nodes(List<String> nodes) {
        this.nodes = nodes;
        return this;
    }

    public RecycleKubernetesNodePoolRequest addNodesItem(String nodesItem) {
        if (this.nodes == null) {
            this.nodes = new ArrayList<>();
        }
        this.nodes.add(nodesItem);
        return this;
    }

    /**
     * Get nodes
     *
     * @return nodes
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NODES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getNodes() {
        return nodes;
    }

    @JsonProperty(JSON_PROPERTY_NODES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }

    /**
     * Return true if this recycle_kubernetes_node_pool_request object is equal to
     * o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RecycleKubernetesNodePoolRequest recycleKubernetesNodePoolRequest = (RecycleKubernetesNodePoolRequest) o;
        return Objects.equals(this.nodes, recycleKubernetesNodePoolRequest.nodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RecycleKubernetesNodePoolRequest {\n");
        sb.append("    nodes: ").append(toIndentedString(nodes)).append("\n");
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
