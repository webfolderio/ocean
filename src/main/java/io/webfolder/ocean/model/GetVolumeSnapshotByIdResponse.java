package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * GetVolumeSnapshotByIdResponse
 */
@JsonPropertyOrder({ GetVolumeSnapshotByIdResponse.JSON_PROPERTY_SNAPSHOT })
public class GetVolumeSnapshotByIdResponse {
    public static final String JSON_PROPERTY_SNAPSHOT = "snapshot";
    private Snapshot snapshot;

    public GetVolumeSnapshotByIdResponse() {
    }

    public GetVolumeSnapshotByIdResponse snapshot(Snapshot snapshot) {
        this.snapshot = snapshot;
        return this;
    }

    /**
     * Get snapshot
     *
     * @return snapshot
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SNAPSHOT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Snapshot getSnapshot() {
        return snapshot;
    }

    @JsonProperty(JSON_PROPERTY_SNAPSHOT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSnapshot(Snapshot snapshot) {
        this.snapshot = snapshot;
    }

    /**
     * Return true if this get_volume_snapshot_by_id_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetVolumeSnapshotByIdResponse getVolumeSnapshotByIdResponse = (GetVolumeSnapshotByIdResponse) o;
        return Objects.equals(this.snapshot, getVolumeSnapshotByIdResponse.snapshot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(snapshot);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetVolumeSnapshotByIdResponse {\n");
        sb.append("    snapshot: ").append(toIndentedString(snapshot)).append("\n");
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