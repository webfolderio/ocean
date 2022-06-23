package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListDropletAssociatedResourcesResponse
 */
@JsonPropertyOrder({ ListDropletAssociatedResourcesResponse.JSON_PROPERTY_RESERVED_IPS,
        ListDropletAssociatedResourcesResponse.JSON_PROPERTY_FLOATING_IPS,
        ListDropletAssociatedResourcesResponse.JSON_PROPERTY_SNAPSHOTS,
        ListDropletAssociatedResourcesResponse.JSON_PROPERTY_VOLUMES,
        ListDropletAssociatedResourcesResponse.JSON_PROPERTY_VOLUME_SNAPSHOTS })
public class ListDropletAssociatedResourcesResponse {
    public static final String JSON_PROPERTY_RESERVED_IPS = "reserved_ips";
    private List<AssociatedResource> reservedIps = null;

    public static final String JSON_PROPERTY_FLOATING_IPS = "floating_ips";
    private List<AssociatedResource> floatingIps = null;

    public static final String JSON_PROPERTY_SNAPSHOTS = "snapshots";
    private List<AssociatedResource> snapshots = null;

    public static final String JSON_PROPERTY_VOLUMES = "volumes";
    private List<AssociatedResource> volumes = null;

    public static final String JSON_PROPERTY_VOLUME_SNAPSHOTS = "volume_snapshots";
    private List<AssociatedResource> volumeSnapshots = null;

    public ListDropletAssociatedResourcesResponse() {
    }

    public ListDropletAssociatedResourcesResponse reservedIps(List<AssociatedResource> reservedIps) {
        this.reservedIps = reservedIps;
        return this;
    }

    public ListDropletAssociatedResourcesResponse addReservedIpsItem(AssociatedResource reservedIpsItem) {
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
    public List<AssociatedResource> getReservedIps() {
        return reservedIps;
    }

    @JsonProperty(JSON_PROPERTY_RESERVED_IPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setReservedIps(List<AssociatedResource> reservedIps) {
        this.reservedIps = reservedIps;
    }

    public ListDropletAssociatedResourcesResponse floatingIps(List<AssociatedResource> floatingIps) {
        this.floatingIps = floatingIps;
        return this;
    }

    public ListDropletAssociatedResourcesResponse addFloatingIpsItem(AssociatedResource floatingIpsItem) {
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
    public List<AssociatedResource> getFloatingIps() {
        return floatingIps;
    }

    @JsonProperty(JSON_PROPERTY_FLOATING_IPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFloatingIps(List<AssociatedResource> floatingIps) {
        this.floatingIps = floatingIps;
    }

    public ListDropletAssociatedResourcesResponse snapshots(List<AssociatedResource> snapshots) {
        this.snapshots = snapshots;
        return this;
    }

    public ListDropletAssociatedResourcesResponse addSnapshotsItem(AssociatedResource snapshotsItem) {
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
    public List<AssociatedResource> getSnapshots() {
        return snapshots;
    }

    @JsonProperty(JSON_PROPERTY_SNAPSHOTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSnapshots(List<AssociatedResource> snapshots) {
        this.snapshots = snapshots;
    }

    public ListDropletAssociatedResourcesResponse volumes(List<AssociatedResource> volumes) {
        this.volumes = volumes;
        return this;
    }

    public ListDropletAssociatedResourcesResponse addVolumesItem(AssociatedResource volumesItem) {
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

    public List<AssociatedResource> getVolumes() {
        return volumes;
    }

    @JsonProperty(JSON_PROPERTY_VOLUMES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVolumes(List<AssociatedResource> volumes) {
        this.volumes = volumes;
    }

    public ListDropletAssociatedResourcesResponse volumeSnapshots(List<AssociatedResource> volumeSnapshots) {
        this.volumeSnapshots = volumeSnapshots;
        return this;
    }

    public ListDropletAssociatedResourcesResponse addVolumeSnapshotsItem(AssociatedResource volumeSnapshotsItem) {
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

    public List<AssociatedResource> getVolumeSnapshots() {
        return volumeSnapshots;
    }

    @JsonProperty(JSON_PROPERTY_VOLUME_SNAPSHOTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVolumeSnapshots(List<AssociatedResource> volumeSnapshots) {
        this.volumeSnapshots = volumeSnapshots;
    }

    /**
     * Return true if this list_droplet_associated_resources_response object is
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
        ListDropletAssociatedResourcesResponse listDropletAssociatedResourcesResponse = (ListDropletAssociatedResourcesResponse) o;
        return Objects.equals(this.reservedIps, listDropletAssociatedResourcesResponse.reservedIps)
                && Objects.equals(this.floatingIps, listDropletAssociatedResourcesResponse.floatingIps)
                && Objects.equals(this.snapshots, listDropletAssociatedResourcesResponse.snapshots)
                && Objects.equals(this.volumes, listDropletAssociatedResourcesResponse.volumes)
                && Objects.equals(this.volumeSnapshots, listDropletAssociatedResourcesResponse.volumeSnapshots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservedIps, floatingIps, snapshots, volumes, volumeSnapshots);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListDropletAssociatedResourcesResponse {\n");
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