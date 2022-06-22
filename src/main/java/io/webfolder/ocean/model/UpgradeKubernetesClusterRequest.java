package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * UpgradeKubernetesClusterRequest
 */
@JsonPropertyOrder({ UpgradeKubernetesClusterRequest.JSON_PROPERTY_VERSION })
public class UpgradeKubernetesClusterRequest {
    public static final String JSON_PROPERTY_VERSION = "version";
    private String version;

    public UpgradeKubernetesClusterRequest() {
    }

    public UpgradeKubernetesClusterRequest version(String version) {
        this.version = version;
        return this;
    }

    /**
     * The slug identifier for the version of Kubernetes that the cluster will be
     * upgraded to.
     *
     * @return version
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getVersion() {
        return version;
    }

    @JsonProperty(JSON_PROPERTY_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Return true if this upgrade_kubernetes_cluster_request object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpgradeKubernetesClusterRequest upgradeKubernetesClusterRequest = (UpgradeKubernetesClusterRequest) o;
        return Objects.equals(this.version, upgradeKubernetesClusterRequest.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(version);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpgradeKubernetesClusterRequest {\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
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
