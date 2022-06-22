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
 * An object containing information about a resource to be scheduled for
 * deletion.
 */
@ApiModel(description = "An object containing information about a resource to be scheduled for deletion.")
@JsonPropertyOrder({ SelectiveDestroyAssociatedResource.JSON_PROPERTY_FLOATING_IPS,
        SelectiveDestroyAssociatedResource.JSON_PROPERTY_RESERVED_IPS,
        SelectiveDestroyAssociatedResource.JSON_PROPERTY_SNAPSHOTS,
        SelectiveDestroyAssociatedResource.JSON_PROPERTY_VOLUMES,
        SelectiveDestroyAssociatedResource.JSON_PROPERTY_VOLUME_SNAPSHOTS })
public class SelectiveDestroyAssociatedResource {
    public static final String JSON_PROPERTY_FLOATING_IPS = "floating_ips";
    private List<String> floatingIps = null;

    public static final String JSON_PROPERTY_RESERVED_IPS = "reserved_ips";
    private List<String> reservedIps = null;

    public static final String JSON_PROPERTY_SNAPSHOTS = "snapshots";
    private List<String> snapshots = null;

    public static final String JSON_PROPERTY_VOLUMES = "volumes";
    private List<String> volumes = null;

    public static final String JSON_PROPERTY_VOLUME_SNAPSHOTS = "volume_snapshots";
    private List<String> volumeSnapshots = null;

    public SelectiveDestroyAssociatedResource() {
    }

    public SelectiveDestroyAssociatedResource floatingIps(List<String> floatingIps) {
        this.floatingIps = floatingIps;
        return this;
    }

    public SelectiveDestroyAssociatedResource addFloatingIpsItem(String floatingIpsItem) {
        if (this.floatingIps == null) {
            this.floatingIps = new ArrayList<>();
        }
        this.floatingIps.add(floatingIpsItem);
        return this;
    }

    /**
     * An array of unique identifiers for the floating IPs to be scheduled for
     * deletion.
     *
     * @return floatingIps
     * @deprecated
     **/
    @Deprecated
    @javax.annotation.Nullable
    @ApiModelProperty(example = "[\"6186916\"]", value = "An array of unique identifiers for the floating IPs to be scheduled for deletion.")
    @JsonProperty(JSON_PROPERTY_FLOATING_IPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getFloatingIps() {
        return floatingIps;
    }

    @JsonProperty(JSON_PROPERTY_FLOATING_IPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFloatingIps(List<String> floatingIps) {
        this.floatingIps = floatingIps;
    }

    public SelectiveDestroyAssociatedResource reservedIps(List<String> reservedIps) {
        this.reservedIps = reservedIps;
        return this;
    }

    public SelectiveDestroyAssociatedResource addReservedIpsItem(String reservedIpsItem) {
        if (this.reservedIps == null) {
            this.reservedIps = new ArrayList<>();
        }
        this.reservedIps.add(reservedIpsItem);
        return this;
    }

    /**
     * An array of unique identifiers for the reserved IPs to be scheduled for
     * deletion.
     *
     * @return reservedIps
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "[\"6186916\"]", value = "An array of unique identifiers for the reserved IPs to be scheduled for deletion.")
    @JsonProperty(JSON_PROPERTY_RESERVED_IPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getReservedIps() {
        return reservedIps;
    }

    @JsonProperty(JSON_PROPERTY_RESERVED_IPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setReservedIps(List<String> reservedIps) {
        this.reservedIps = reservedIps;
    }

    public SelectiveDestroyAssociatedResource snapshots(List<String> snapshots) {
        this.snapshots = snapshots;
        return this;
    }

    public SelectiveDestroyAssociatedResource addSnapshotsItem(String snapshotsItem) {
        if (this.snapshots == null) {
            this.snapshots = new ArrayList<>();
        }
        this.snapshots.add(snapshotsItem);
        return this;
    }

    /**
     * An array of unique identifiers for the snapshots to be scheduled for
     * deletion.
     *
     * @return snapshots
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "[\"61486916\"]", value = "An array of unique identifiers for the snapshots to be scheduled for deletion.")
    @JsonProperty(JSON_PROPERTY_SNAPSHOTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getSnapshots() {
        return snapshots;
    }

    @JsonProperty(JSON_PROPERTY_SNAPSHOTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSnapshots(List<String> snapshots) {
        this.snapshots = snapshots;
    }

    public SelectiveDestroyAssociatedResource volumes(List<String> volumes) {
        this.volumes = volumes;
        return this;
    }

    public SelectiveDestroyAssociatedResource addVolumesItem(String volumesItem) {
        if (this.volumes == null) {
            this.volumes = new ArrayList<>();
        }
        this.volumes.add(volumesItem);
        return this;
    }

    /**
     * An array of unique identifiers for the volumes to be scheduled for deletion.
     *
     * @return volumes
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "[\"ba49449a-7435-11ea-b89e-0a58ac14480f\"]", value = "An array of unique identifiers for the volumes to be scheduled for deletion.")
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

    public SelectiveDestroyAssociatedResource volumeSnapshots(List<String> volumeSnapshots) {
        this.volumeSnapshots = volumeSnapshots;
        return this;
    }

    public SelectiveDestroyAssociatedResource addVolumeSnapshotsItem(String volumeSnapshotsItem) {
        if (this.volumeSnapshots == null) {
            this.volumeSnapshots = new ArrayList<>();
        }
        this.volumeSnapshots.add(volumeSnapshotsItem);
        return this;
    }

    /**
     * An array of unique identifiers for the volume snapshots to be scheduled for
     * deletion.
     *
     * @return volumeSnapshots
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "[\"edb0478d-7436-11ea-86e6-0a58ac144b91\"]", value = "An array of unique identifiers for the volume snapshots to be scheduled for deletion.")
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
     * Return true if this selective_destroy_associated_resource object is equal to
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
        SelectiveDestroyAssociatedResource selectiveDestroyAssociatedResource = (SelectiveDestroyAssociatedResource) o;
        return Objects.equals(this.floatingIps, selectiveDestroyAssociatedResource.floatingIps)
                && Objects.equals(this.reservedIps, selectiveDestroyAssociatedResource.reservedIps)
                && Objects.equals(this.snapshots, selectiveDestroyAssociatedResource.snapshots)
                && Objects.equals(this.volumes, selectiveDestroyAssociatedResource.volumes)
                && Objects.equals(this.volumeSnapshots, selectiveDestroyAssociatedResource.volumeSnapshots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(floatingIps, reservedIps, snapshots, volumes, volumeSnapshots);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SelectiveDestroyAssociatedResource {\n");
        sb.append("    floatingIps: ").append(toIndentedString(floatingIps)).append("\n");
        sb.append("    reservedIps: ").append(toIndentedString(reservedIps)).append("\n");
        sb.append("    snapshots: ").append(toIndentedString(snapshots)).append("\n");
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
