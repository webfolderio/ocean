package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListAllKubernetesClustersResponseAllOf
 */
@JsonPropertyOrder({ ListAllKubernetesClustersResponseAllOf.JSON_PROPERTY_KUBERNETES_CLUSTERS })
public class ListAllKubernetesClustersResponseAllOf {
    public static final String JSON_PROPERTY_KUBERNETES_CLUSTERS = "kubernetes_clusters";
    private List<Cluster> kubernetesClusters = null;

    public ListAllKubernetesClustersResponseAllOf() {
    }

    public ListAllKubernetesClustersResponseAllOf kubernetesClusters(List<Cluster> kubernetesClusters) {
        this.kubernetesClusters = kubernetesClusters;
        return this;
    }

    public ListAllKubernetesClustersResponseAllOf addKubernetesClustersItem(Cluster kubernetesClustersItem) {
        if (this.kubernetesClusters == null) {
            this.kubernetesClusters = new ArrayList<>();
        }
        this.kubernetesClusters.add(kubernetesClustersItem);
        return this;
    }

    /**
     * Get kubernetesClusters
     *
     * @return kubernetesClusters
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_KUBERNETES_CLUSTERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Cluster> getKubernetesClusters() {
        return kubernetesClusters;
    }

    @JsonProperty(JSON_PROPERTY_KUBERNETES_CLUSTERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setKubernetesClusters(List<Cluster> kubernetesClusters) {
        this.kubernetesClusters = kubernetesClusters;
    }

    /**
     * Return true if this list_all_kubernetes_clusters_response_allOf object is
     * equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListAllKubernetesClustersResponseAllOf listAllKubernetesClustersResponseAllOf = (ListAllKubernetesClustersResponseAllOf) o;
        return Objects.equals(this.kubernetesClusters, listAllKubernetesClustersResponseAllOf.kubernetesClusters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kubernetesClusters);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListAllKubernetesClustersResponseAllOf {\n");
        sb.append("    kubernetesClusters: ").append(toIndentedString(kubernetesClusters)).append("\n");
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
