package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * CreateKubernetesClusterResponse
 */
@JsonPropertyOrder({ CreateKubernetesClusterResponse.JSON_PROPERTY_KUBERNETES_CLUSTER })
public class CreateKubernetesClusterResponse {
    public static final String JSON_PROPERTY_KUBERNETES_CLUSTER = "kubernetes_cluster";
    private Cluster kubernetesCluster;

    public CreateKubernetesClusterResponse() {
    }

    public CreateKubernetesClusterResponse kubernetesCluster(Cluster kubernetesCluster) {
        this.kubernetesCluster = kubernetesCluster;
        return this;
    }

    /**
     * Get kubernetesCluster
     *
     * @return kubernetesCluster
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_KUBERNETES_CLUSTER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Cluster getKubernetesCluster() {
        return kubernetesCluster;
    }

    @JsonProperty(JSON_PROPERTY_KUBERNETES_CLUSTER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setKubernetesCluster(Cluster kubernetesCluster) {
        this.kubernetesCluster = kubernetesCluster;
    }

    /**
     * Return true if this create_kubernetes_cluster_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateKubernetesClusterResponse createKubernetesClusterResponse = (CreateKubernetesClusterResponse) o;
        return Objects.equals(this.kubernetesCluster, createKubernetesClusterResponse.kubernetesCluster);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kubernetesCluster);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateKubernetesClusterResponse {\n");
        sb.append("    kubernetesCluster: ").append(toIndentedString(kubernetesCluster)).append("\n");
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