package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ClusterUpdate
 */
@JsonPropertyOrder({ ClusterUpdate.JSON_PROPERTY_NAME, ClusterUpdate.JSON_PROPERTY_TAGS,
        ClusterUpdate.JSON_PROPERTY_MAINTENANCE_POLICY, ClusterUpdate.JSON_PROPERTY_AUTO_UPGRADE,
        ClusterUpdate.JSON_PROPERTY_SURGE_UPGRADE })
public class ClusterUpdate {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_TAGS = "tags";
    private List<String> tags = null;

    public static final String JSON_PROPERTY_MAINTENANCE_POLICY = "maintenance_policy";
    private MaintenancePolicy maintenancePolicy;

    public static final String JSON_PROPERTY_AUTO_UPGRADE = "auto_upgrade";
    private Boolean autoUpgrade = false;

    public static final String JSON_PROPERTY_SURGE_UPGRADE = "surge_upgrade";
    private Boolean surgeUpgrade = false;

    public ClusterUpdate() {
    }

    public ClusterUpdate name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A human-readable name for a Kubernetes cluster.
     *
     * @return name
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setName(String name) {
        this.name = name;
    }

    public ClusterUpdate tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public ClusterUpdate addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * An array of tags applied to the Kubernetes cluster. All clusters are
     * automatically tagged &#x60;k8s&#x60; and &#x60;k8s:$K8S_CLUSTER_ID&#x60;.
     *
     * @return tags
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public ClusterUpdate maintenancePolicy(MaintenancePolicy maintenancePolicy) {
        this.maintenancePolicy = maintenancePolicy;
        return this;
    }

    /**
     * Get maintenancePolicy
     *
     * @return maintenancePolicy
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MAINTENANCE_POLICY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public MaintenancePolicy getMaintenancePolicy() {
        return maintenancePolicy;
    }

    @JsonProperty(JSON_PROPERTY_MAINTENANCE_POLICY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMaintenancePolicy(MaintenancePolicy maintenancePolicy) {
        this.maintenancePolicy = maintenancePolicy;
    }

    public ClusterUpdate autoUpgrade(Boolean autoUpgrade) {
        this.autoUpgrade = autoUpgrade;
        return this;
    }

    /**
     * A boolean value indicating whether the cluster will be automatically upgraded
     * to new patch releases during its maintenance window.
     *
     * @return autoUpgrade
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_AUTO_UPGRADE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getAutoUpgrade() {
        return autoUpgrade;
    }

    @JsonProperty(JSON_PROPERTY_AUTO_UPGRADE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAutoUpgrade(Boolean autoUpgrade) {
        this.autoUpgrade = autoUpgrade;
    }

    public ClusterUpdate surgeUpgrade(Boolean surgeUpgrade) {
        this.surgeUpgrade = surgeUpgrade;
        return this;
    }

    /**
     * A boolean value indicating whether surge upgrade is enabled/disabled for the
     * cluster. Surge upgrade makes cluster upgrades fast and reliable by bringing
     * up new nodes before destroying the outdated nodes.
     *
     * @return surgeUpgrade
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SURGE_UPGRADE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getSurgeUpgrade() {
        return surgeUpgrade;
    }

    @JsonProperty(JSON_PROPERTY_SURGE_UPGRADE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSurgeUpgrade(Boolean surgeUpgrade) {
        this.surgeUpgrade = surgeUpgrade;
    }

    /**
     * Return true if this cluster_update object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClusterUpdate clusterUpdate = (ClusterUpdate) o;
        return Objects.equals(this.name, clusterUpdate.name) && Objects.equals(this.tags, clusterUpdate.tags)
                && Objects.equals(this.maintenancePolicy, clusterUpdate.maintenancePolicy)
                && Objects.equals(this.autoUpgrade, clusterUpdate.autoUpgrade)
                && Objects.equals(this.surgeUpgrade, clusterUpdate.surgeUpgrade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, tags, maintenancePolicy, autoUpgrade, surgeUpgrade);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ClusterUpdate {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    maintenancePolicy: ").append(toIndentedString(maintenancePolicy)).append("\n");
        sb.append("    autoUpgrade: ").append(toIndentedString(autoUpgrade)).append("\n");
        sb.append("    surgeUpgrade: ").append(toIndentedString(surgeUpgrade)).append("\n");
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