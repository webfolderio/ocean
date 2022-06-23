package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * NeighborIds
 */
@JsonPropertyOrder({ NeighborIds.JSON_PROPERTY_NEIGHBOR_IDS })
public class NeighborIds {
    public static final String JSON_PROPERTY_NEIGHBOR_IDS = "neighbor_ids";
    private List<List<Integer>> neighborIds = null;

    public NeighborIds() {
    }

    public NeighborIds neighborIds(List<List<Integer>> neighborIds) {
        this.neighborIds = neighborIds;
        return this;
    }

    public NeighborIds addNeighborIdsItem(List<Integer> neighborIdsItem) {
        if (this.neighborIds == null) {
            this.neighborIds = new ArrayList<>();
        }
        this.neighborIds.add(neighborIdsItem);
        return this;
    }

    /**
     * An array of arrays. Each array will contain a set of Droplet IDs for Droplets
     * that share a physical server.
     *
     * @return neighborIds
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NEIGHBOR_IDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<List<Integer>> getNeighborIds() {
        return neighborIds;
    }

    @JsonProperty(JSON_PROPERTY_NEIGHBOR_IDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setNeighborIds(List<List<Integer>> neighborIds) {
        this.neighborIds = neighborIds;
    }

    /**
     * Return true if this neighbor_ids object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NeighborIds neighborIds = (NeighborIds) o;
        return Objects.equals(this.neighborIds, neighborIds.neighborIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(neighborIds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NeighborIds {\n");
        sb.append("    neighborIds: ").append(toIndentedString(neighborIds)).append("\n");
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