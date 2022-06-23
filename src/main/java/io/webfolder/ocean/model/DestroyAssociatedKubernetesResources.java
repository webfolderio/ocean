package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * An object containing the IDs of resources to be destroyed along with their
 * associated with a Kubernetes cluster.
 */
@JsonPropertyOrder({ DestroyAssociatedKubernetesResources.JSON_PROPERTY_LOAD_BALANCERS,
        DestroyAssociatedKubernetesResources.JSON_PROPERTY_VOLUMES,
        DestroyAssociatedKubernetesResources.JSON_PROPERTY_VOLUME_SNAPSHOTS })
public class DestroyAssociatedKubernetesResources {
    public static final String JSON_PROPERTY_LOAD_BALANCERS = "load_balancers";
    private List<String> loadBalancers = null;

    public static final String JSON_PROPERTY_VOLUMES = "volumes";
    private List<String> volumes = null;

    public static final String JSON_PROPERTY_VOLUME_SNAPSHOTS = "volume_snapshots";
    private List<String> volumeSnapshots = null;

    public DestroyAssociatedKubernetesResources() {
    }

    public DestroyAssociatedKubernetesResources loadBalancers(List<String> loadBalancers) {
        this.loadBalancers = loadBalancers;
        return this;
    }

    public DestroyAssociatedKubernetesResources addLoadBalancersItem(String loadBalancersItem) {
        if (this.loadBalancers == null) {
            this.loadBalancers = new ArrayList<>();
        }
        this.loadBalancers.add(loadBalancersItem);
        return this;
    }

    /**
     * A list of IDs for associated load balancers to destroy along with the
     * cluster.
     *
     * @return loadBalancers
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LOAD_BALANCERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<String> getLoadBalancers() {
        return loadBalancers;
    }

    @JsonProperty(JSON_PROPERTY_LOAD_BALANCERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLoadBalancers(List<String> loadBalancers) {
        this.loadBalancers = loadBalancers;
    }

    public DestroyAssociatedKubernetesResources volumes(List<String> volumes) {
        this.volumes = volumes;
        return this;
    }

    public DestroyAssociatedKubernetesResources addVolumesItem(String volumesItem) {
        if (this.volumes == null) {
            this.volumes = new ArrayList<>();
        }
        this.volumes.add(volumesItem);
        return this;
    }

    /**
     * A list of IDs for associated volumes to destroy along with the cluster.
     *
     * @return volumes
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_VOLUMES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getVolumes() {
        return volumes;
    }

    @JsonProperty(JSON_PROPERTY_VOLUMES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVolumes(List<String> volumes) {
        this.volumes = volumes;
    }

    public DestroyAssociatedKubernetesResources volumeSnapshots(List<String> volumeSnapshots) {
        this.volumeSnapshots = volumeSnapshots;
        return this;
    }

    public DestroyAssociatedKubernetesResources addVolumeSnapshotsItem(String volumeSnapshotsItem) {
        if (this.volumeSnapshots == null) {
            this.volumeSnapshots = new ArrayList<>();
        }
        this.volumeSnapshots.add(volumeSnapshotsItem);
        return this;
    }

    /**
     * A list of IDs for associated volume snapshots to destroy along with the
     * cluster.
     *
     * @return volumeSnapshots
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_VOLUME_SNAPSHOTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getVolumeSnapshots() {
        return volumeSnapshots;
    }

    @JsonProperty(JSON_PROPERTY_VOLUME_SNAPSHOTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVolumeSnapshots(List<String> volumeSnapshots) {
        this.volumeSnapshots = volumeSnapshots;
    }

    /**
     * Return true if this destroy_associated_kubernetes_resources object is equal
     * to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DestroyAssociatedKubernetesResources destroyAssociatedKubernetesResources = (DestroyAssociatedKubernetesResources) o;
        return Objects.equals(this.loadBalancers, destroyAssociatedKubernetesResources.loadBalancers)
                && Objects.equals(this.volumes, destroyAssociatedKubernetesResources.volumes)
                && Objects.equals(this.volumeSnapshots, destroyAssociatedKubernetesResources.volumeSnapshots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loadBalancers, volumes, volumeSnapshots);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DestroyAssociatedKubernetesResources {\n");
        sb.append("    loadBalancers: ").append(toIndentedString(loadBalancers)).append("\n");
        sb.append("    volumes: ").append(toIndentedString(volumes)).append("\n");
        sb.append("    volumeSnapshots: ").append(toIndentedString(volumeSnapshots)).append("\n");
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