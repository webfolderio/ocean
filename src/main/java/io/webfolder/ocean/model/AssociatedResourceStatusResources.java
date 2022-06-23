package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * An object containing additional information about resource related to a
 * Droplet requested to be destroyed.
 */
@JsonPropertyOrder({ AssociatedResourceStatusResources.JSON_PROPERTY_RESERVED_IPS,
        AssociatedResourceStatusResources.JSON_PROPERTY_FLOATING_IPS,
        AssociatedResourceStatusResources.JSON_PROPERTY_SNAPSHOTS,
        AssociatedResourceStatusResources.JSON_PROPERTY_VOLUMES,
        AssociatedResourceStatusResources.JSON_PROPERTY_VOLUME_SNAPSHOTS })
public class AssociatedResourceStatusResources {
    public static final String JSON_PROPERTY_RESERVED_IPS = "reserved_ips";
    private List<DestroyedAssociatedResource> reservedIps = null;

    public static final String JSON_PROPERTY_FLOATING_IPS = "floating_ips";
    private List<DestroyedAssociatedResource> floatingIps = null;

    public static final String JSON_PROPERTY_SNAPSHOTS = "snapshots";
    private List<DestroyedAssociatedResource> snapshots = null;

    public static final String JSON_PROPERTY_VOLUMES = "volumes";
    private List<DestroyedAssociatedResource> volumes = null;

    public static final String JSON_PROPERTY_VOLUME_SNAPSHOTS = "volume_snapshots";
    private List<DestroyedAssociatedResource> volumeSnapshots = null;

    public AssociatedResourceStatusResources() {
    }

    public AssociatedResourceStatusResources reservedIps(List<DestroyedAssociatedResource> reservedIps) {
        this.reservedIps = reservedIps;
        return this;
    }

    public AssociatedResourceStatusResources addReservedIpsItem(DestroyedAssociatedResource reservedIpsItem) {
        if (this.reservedIps == null) {
            this.reservedIps = new ArrayList<>();
        }
        this.reservedIps.add(reservedIpsItem);
        return this;
    }

    /**
     * Get reservedIps
     *
     * @return reservedIps
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_RESERVED_IPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<DestroyedAssociatedResource> getReservedIps() {
        return reservedIps;
    }

    @JsonProperty(JSON_PROPERTY_RESERVED_IPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setReservedIps(List<DestroyedAssociatedResource> reservedIps) {
        this.reservedIps = reservedIps;
    }

    public AssociatedResourceStatusResources floatingIps(List<DestroyedAssociatedResource> floatingIps) {
        this.floatingIps = floatingIps;
        return this;
    }

    public AssociatedResourceStatusResources addFloatingIpsItem(DestroyedAssociatedResource floatingIpsItem) {
        if (this.floatingIps == null) {
            this.floatingIps = new ArrayList<>();
        }
        this.floatingIps.add(floatingIpsItem);
        return this;
    }

    /**
     * Get floatingIps
     *
     * @return floatingIps
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FLOATING_IPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<DestroyedAssociatedResource> getFloatingIps() {
        return floatingIps;
    }

    @JsonProperty(JSON_PROPERTY_FLOATING_IPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFloatingIps(List<DestroyedAssociatedResource> floatingIps) {
        this.floatingIps = floatingIps;
    }

    public AssociatedResourceStatusResources snapshots(List<DestroyedAssociatedResource> snapshots) {
        this.snapshots = snapshots;
        return this;
    }

    public AssociatedResourceStatusResources addSnapshotsItem(DestroyedAssociatedResource snapshotsItem) {
        if (this.snapshots == null) {
            this.snapshots = new ArrayList<>();
        }
        this.snapshots.add(snapshotsItem);
        return this;
    }

    /**
     * Get snapshots
     *
     * @return snapshots
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SNAPSHOTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<DestroyedAssociatedResource> getSnapshots() {
        return snapshots;
    }

    @JsonProperty(JSON_PROPERTY_SNAPSHOTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSnapshots(List<DestroyedAssociatedResource> snapshots) {
        this.snapshots = snapshots;
    }

    public AssociatedResourceStatusResources volumes(List<DestroyedAssociatedResource> volumes) {
        this.volumes = volumes;
        return this;
    }

    public AssociatedResourceStatusResources addVolumesItem(DestroyedAssociatedResource volumesItem) {
        if (this.volumes == null) {
            this.volumes = new ArrayList<>();
        }
        this.volumes.add(volumesItem);
        return this;
    }

    /**
     * Get volumes
     *
     * @return volumes
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_VOLUMES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<DestroyedAssociatedResource> getVolumes() {
        return volumes;
    }

    @JsonProperty(JSON_PROPERTY_VOLUMES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVolumes(List<DestroyedAssociatedResource> volumes) {
        this.volumes = volumes;
    }

    public AssociatedResourceStatusResources volumeSnapshots(List<DestroyedAssociatedResource> volumeSnapshots) {
        this.volumeSnapshots = volumeSnapshots;
        return this;
    }

    public AssociatedResourceStatusResources addVolumeSnapshotsItem(DestroyedAssociatedResource volumeSnapshotsItem) {
        if (this.volumeSnapshots == null) {
            this.volumeSnapshots = new ArrayList<>();
        }
        this.volumeSnapshots.add(volumeSnapshotsItem);
        return this;
    }

    /**
     * Get volumeSnapshots
     *
     * @return volumeSnapshots
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_VOLUME_SNAPSHOTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<DestroyedAssociatedResource> getVolumeSnapshots() {
        return volumeSnapshots;
    }

    @JsonProperty(JSON_PROPERTY_VOLUME_SNAPSHOTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVolumeSnapshots(List<DestroyedAssociatedResource> volumeSnapshots) {
        this.volumeSnapshots = volumeSnapshots;
    }

    /**
     * Return true if this associated_resource_status_resources object is equal to
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
        AssociatedResourceStatusResources associatedResourceStatusResources = (AssociatedResourceStatusResources) o;
        return Objects.equals(this.reservedIps, associatedResourceStatusResources.reservedIps)
                && Objects.equals(this.floatingIps, associatedResourceStatusResources.floatingIps)
                && Objects.equals(this.snapshots, associatedResourceStatusResources.snapshots)
                && Objects.equals(this.volumes, associatedResourceStatusResources.volumes)
                && Objects.equals(this.volumeSnapshots, associatedResourceStatusResources.volumeSnapshots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservedIps, floatingIps, snapshots, volumes, volumeSnapshots);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssociatedResourceStatusResources {\n");
        sb.append("    reservedIps: ").append(toIndentedString(reservedIps)).append("\n");
        sb.append("    floatingIps: ").append(toIndentedString(floatingIps)).append("\n");
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