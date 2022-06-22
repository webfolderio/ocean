package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ClusterRegistries
 */
@JsonPropertyOrder({ ClusterRegistries.JSON_PROPERTY_CLUSTER_UUIDS })
public class ClusterRegistries {
    public static final String JSON_PROPERTY_CLUSTER_UUIDS = "cluster_uuids";
    private List<String> clusterUuids = null;

    public ClusterRegistries() {
    }

    public ClusterRegistries clusterUuids(List<String> clusterUuids) {
        this.clusterUuids = clusterUuids;
        return this;
    }

    public ClusterRegistries addClusterUuidsItem(String clusterUuidsItem) {
        if (this.clusterUuids == null) {
            this.clusterUuids = new ArrayList<>();
        }
        this.clusterUuids.add(clusterUuidsItem);
        return this;
    }

    /**
     * An array containing the UUIDs of Kubernetes clusters.
     *
     * @return clusterUuids
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CLUSTER_UUIDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getClusterUuids() {
        return clusterUuids;
    }

    @JsonProperty(JSON_PROPERTY_CLUSTER_UUIDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setClusterUuids(List<String> clusterUuids) {
        this.clusterUuids = clusterUuids;
    }

    /**
     * Return true if this cluster_registries object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClusterRegistries clusterRegistries = (ClusterRegistries) o;
        return Objects.equals(this.clusterUuids, clusterRegistries.clusterUuids);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clusterUuids);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ClusterRegistries {\n");
        sb.append("    clusterUuids: ").append(toIndentedString(clusterUuids)).append("\n");
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
