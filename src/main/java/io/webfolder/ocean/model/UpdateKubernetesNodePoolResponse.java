package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * UpdateKubernetesNodePoolResponse
 */
@JsonPropertyOrder({ UpdateKubernetesNodePoolResponse.JSON_PROPERTY_NODE_POOL })
public class UpdateKubernetesNodePoolResponse {
    public static final String JSON_PROPERTY_NODE_POOL = "node_pool";
    private KubernetesNodePool nodePool;

    public UpdateKubernetesNodePoolResponse() {
    }

    public UpdateKubernetesNodePoolResponse nodePool(KubernetesNodePool nodePool) {
        this.nodePool = nodePool;
        return this;
    }

    /**
     * Get nodePool
     *
     * @return nodePool
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NODE_POOL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public KubernetesNodePool getNodePool() {
        return nodePool;
    }

    @JsonProperty(JSON_PROPERTY_NODE_POOL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setNodePool(KubernetesNodePool nodePool) {
        this.nodePool = nodePool;
    }

    /**
     * Return true if this update_kubernetes_node_pool_response object is equal to
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
        UpdateKubernetesNodePoolResponse updateKubernetesNodePoolResponse = (UpdateKubernetesNodePoolResponse) o;
        return Objects.equals(this.nodePool, updateKubernetesNodePoolResponse.nodePool);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodePool);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateKubernetesNodePoolResponse {\n");
        sb.append("    nodePool: ").append(toIndentedString(nodePool)).append("\n");
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