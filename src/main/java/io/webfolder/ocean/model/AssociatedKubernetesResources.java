package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An object containing the IDs of resources associated with a Kubernetes
 * cluster.
 */
@ApiModel(description = "An object containing the IDs of resources associated with a Kubernetes cluster.")
@JsonPropertyOrder({ AssociatedKubernetesResources.JSON_PROPERTY_LOAD_BALANCERS,
        AssociatedKubernetesResources.JSON_PROPERTY_VOLUMES,
        AssociatedKubernetesResources.JSON_PROPERTY_VOLUME_SNAPSHOTS })
public class AssociatedKubernetesResources {
    public static final String JSON_PROPERTY_LOAD_BALANCERS = "load_balancers";
    private List<AssociatedKubernetesResource> loadBalancers = null;

    public static final String JSON_PROPERTY_VOLUMES = "volumes";
    private List<AssociatedKubernetesResource> volumes = null;

    public static final String JSON_PROPERTY_VOLUME_SNAPSHOTS = "volume_snapshots";
    private List<AssociatedKubernetesResource> volumeSnapshots = null;

    public AssociatedKubernetesResources() {
    }

    public AssociatedKubernetesResources loadBalancers(List<AssociatedKubernetesResource> loadBalancers) {
        this.loadBalancers = loadBalancers;
        return this;
    }

    public AssociatedKubernetesResources addLoadBalancersItem(AssociatedKubernetesResource loadBalancersItem) {
        if (this.loadBalancers == null) {
            this.loadBalancers = new ArrayList<>();
        }
        this.loadBalancers.add(loadBalancersItem);
        return this;
    }

    /**
     * A list of names and IDs for associated load balancers that can be destroyed
     * along with the cluster.
     *
     * @return loadBalancers
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "[{\"id\":\"4de7ac8b-495b-4884-9a69-1050c6793cd6\",\"name\":\"lb-001\"}]", value = "A list of names and IDs for associated load balancers that can be destroyed along with the cluster.")
    @JsonProperty(JSON_PROPERTY_LOAD_BALANCERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AssociatedKubernetesResource> getLoadBalancers() {
        return loadBalancers;
    }

    @JsonProperty(JSON_PROPERTY_LOAD_BALANCERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLoadBalancers(List<AssociatedKubernetesResource> loadBalancers) {
        this.loadBalancers = loadBalancers;
    }

    public AssociatedKubernetesResources volumes(List<AssociatedKubernetesResource> volumes) {
        this.volumes = volumes;
        return this;
    }

    public AssociatedKubernetesResources addVolumesItem(AssociatedKubernetesResource volumesItem) {
        if (this.volumes == null) {
            this.volumes = new ArrayList<>();
        }
        this.volumes.add(volumesItem);
        return this;
    }

    /**
     * A list of names and IDs for associated volumes that can be destroyed along
     * with the cluster.
     *
     * @return volumes
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "[{\"id\":\"ba49449a-7435-11ea-b89e-0a58ac14480f\",\"name\":\"volume-001\"}]", value = "A list of names and IDs for associated volumes that can be destroyed along with the cluster.")
    @JsonProperty(JSON_PROPERTY_VOLUMES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AssociatedKubernetesResource> getVolumes() {
        return volumes;
    }

    @JsonProperty(JSON_PROPERTY_VOLUMES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVolumes(List<AssociatedKubernetesResource> volumes) {
        this.volumes = volumes;
    }

    public AssociatedKubernetesResources volumeSnapshots(List<AssociatedKubernetesResource> volumeSnapshots) {
        this.volumeSnapshots = volumeSnapshots;
        return this;
    }

    public AssociatedKubernetesResources addVolumeSnapshotsItem(AssociatedKubernetesResource volumeSnapshotsItem) {
        if (this.volumeSnapshots == null) {
            this.volumeSnapshots = new ArrayList<>();
        }
        this.volumeSnapshots.add(volumeSnapshotsItem);
        return this;
    }

    /**
     * A list of names and IDs for associated volume snapshots that can be destroyed
     * along with the cluster.
     *
     * @return volumeSnapshots
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "[{\"id\":\"edb0478d-7436-11ea-86e6-0a58ac144b91\",\"name\":\"snapshot-001\"}]", value = "A list of names and IDs for associated volume snapshots that can be destroyed along with the cluster.")
    @JsonProperty(JSON_PROPERTY_VOLUME_SNAPSHOTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AssociatedKubernetesResource> getVolumeSnapshots() {
        return volumeSnapshots;
    }

    @JsonProperty(JSON_PROPERTY_VOLUME_SNAPSHOTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVolumeSnapshots(List<AssociatedKubernetesResource> volumeSnapshots) {
        this.volumeSnapshots = volumeSnapshots;
    }

    /**
     * Return true if this associated_kubernetes_resources object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AssociatedKubernetesResources associatedKubernetesResources = (AssociatedKubernetesResources) o;
        return Objects.equals(this.loadBalancers, associatedKubernetesResources.loadBalancers)
                && Objects.equals(this.volumes, associatedKubernetesResources.volumes)
                && Objects.equals(this.volumeSnapshots, associatedKubernetesResources.volumeSnapshots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loadBalancers, volumes, volumeSnapshots);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssociatedKubernetesResources {\n");
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
