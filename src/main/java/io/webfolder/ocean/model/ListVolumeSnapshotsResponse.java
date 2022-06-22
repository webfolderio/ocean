package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListVolumeSnapshotsResponse
 */
@JsonPropertyOrder({ ListVolumeSnapshotsResponse.JSON_PROPERTY_SNAPSHOTS,
        ListVolumeSnapshotsResponse.JSON_PROPERTY_LINKS, ListVolumeSnapshotsResponse.JSON_PROPERTY_META })
public class ListVolumeSnapshotsResponse {
    public static final String JSON_PROPERTY_SNAPSHOTS = "snapshots";
    private List<Snapshot> snapshots = null;

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public ListVolumeSnapshotsResponse() {
    }

    public ListVolumeSnapshotsResponse snapshots(List<Snapshot> snapshots) {
        this.snapshots = snapshots;
        return this;
    }

    public ListVolumeSnapshotsResponse addSnapshotsItem(Snapshot snapshotsItem) {
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

    public List<Snapshot> getSnapshots() {
        return snapshots;
    }

    @JsonProperty(JSON_PROPERTY_SNAPSHOTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSnapshots(List<Snapshot> snapshots) {
        this.snapshots = snapshots;
    }

    public ListVolumeSnapshotsResponse links(PageLinks links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     *
     * @return links
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LINKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public PageLinks getLinks() {
        return links;
    }

    @JsonProperty(JSON_PROPERTY_LINKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLinks(PageLinks links) {
        this.links = links;
    }

    public ListVolumeSnapshotsResponse meta(MetaMeta meta) {
        this.meta = meta;
        return this;
    }

    /**
     * Get meta
     *
     * @return meta
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_META)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public MetaMeta getMeta() {
        return meta;
    }

    @JsonProperty(JSON_PROPERTY_META)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setMeta(MetaMeta meta) {
        this.meta = meta;
    }

    /**
     * Return true if this list_volume_snapshots_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListVolumeSnapshotsResponse listVolumeSnapshotsResponse = (ListVolumeSnapshotsResponse) o;
        return Objects.equals(this.snapshots, listVolumeSnapshotsResponse.snapshots)
                && Objects.equals(this.links, listVolumeSnapshotsResponse.links)
                && Objects.equals(this.meta, listVolumeSnapshotsResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(snapshots, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListVolumeSnapshotsResponse {\n");
        sb.append("    snapshots: ").append(toIndentedString(snapshots)).append("\n");
        sb.append("    links: ").append(toIndentedString(links)).append("\n");
        sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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
