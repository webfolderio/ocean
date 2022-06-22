package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListAllSnapshotsResponseAllOf
 */
@JsonPropertyOrder({ ListAllSnapshotsResponseAllOf.JSON_PROPERTY_SNAPSHOTS })
public class ListAllSnapshotsResponseAllOf {
    public static final String JSON_PROPERTY_SNAPSHOTS = "snapshots";
    private List<Snapshot> snapshots = null;

    public ListAllSnapshotsResponseAllOf() {
    }

    public ListAllSnapshotsResponseAllOf snapshots(List<Snapshot> snapshots) {
        this.snapshots = snapshots;
        return this;
    }

    public ListAllSnapshotsResponseAllOf addSnapshotsItem(Snapshot snapshotsItem) {
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
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_SNAPSHOTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Snapshot> getSnapshots() {
        return snapshots;
    }

    @JsonProperty(JSON_PROPERTY_SNAPSHOTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSnapshots(List<Snapshot> snapshots) {
        this.snapshots = snapshots;
    }

    /**
     * Return true if this list_all_snapshots_response_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListAllSnapshotsResponseAllOf listAllSnapshotsResponseAllOf = (ListAllSnapshotsResponseAllOf) o;
        return Objects.equals(this.snapshots, listAllSnapshotsResponseAllOf.snapshots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(snapshots);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListAllSnapshotsResponseAllOf {\n");
        sb.append("    snapshots: ").append(toIndentedString(snapshots)).append("\n");
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
