package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * VolumeSnapshotId
 */
@JsonPropertyOrder({ VolumeSnapshotId.JSON_PROPERTY_SNAPSHOT_ID })
public class VolumeSnapshotId {
    public static final String JSON_PROPERTY_SNAPSHOT_ID = "snapshot_id";
    private String snapshotId;

    public VolumeSnapshotId() {
    }

    public VolumeSnapshotId snapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
        return this;
    }

    /**
     * The unique identifier for the volume snapshot from which to create the
     * volume.
     *
     * @return snapshotId
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SNAPSHOT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getSnapshotId() {
        return snapshotId;
    }

    @JsonProperty(JSON_PROPERTY_SNAPSHOT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    /**
     * Return true if this volume_snapshot_id object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VolumeSnapshotId volumeSnapshotId = (VolumeSnapshotId) o;
        return Objects.equals(this.snapshotId, volumeSnapshotId.snapshotId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(snapshotId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VolumeSnapshotId {\n");
        sb.append("    snapshotId: ").append(toIndentedString(snapshotId)).append("\n");
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