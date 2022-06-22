package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListGarbageCollectionsResponse
 */
@JsonPropertyOrder({ ListGarbageCollectionsResponse.JSON_PROPERTY_GARBAGE_COLLECTIONS })
public class ListGarbageCollectionsResponse {
    public static final String JSON_PROPERTY_GARBAGE_COLLECTIONS = "garbage_collections";
    private List<GarbageCollection> garbageCollections = null;

    public ListGarbageCollectionsResponse() {
    }

    public ListGarbageCollectionsResponse garbageCollections(List<GarbageCollection> garbageCollections) {
        this.garbageCollections = garbageCollections;
        return this;
    }

    public ListGarbageCollectionsResponse addGarbageCollectionsItem(GarbageCollection garbageCollectionsItem) {
        if (this.garbageCollections == null) {
            this.garbageCollections = new ArrayList<>();
        }
        this.garbageCollections.add(garbageCollectionsItem);
        return this;
    }

    /**
     * Get garbageCollections
     *
     * @return garbageCollections
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_GARBAGE_COLLECTIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<GarbageCollection> getGarbageCollections() {
        return garbageCollections;
    }

    @JsonProperty(JSON_PROPERTY_GARBAGE_COLLECTIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setGarbageCollections(List<GarbageCollection> garbageCollections) {
        this.garbageCollections = garbageCollections;
    }

    /**
     * Return true if this list_garbage_collections_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListGarbageCollectionsResponse listGarbageCollectionsResponse = (ListGarbageCollectionsResponse) o;
        return Objects.equals(this.garbageCollections, listGarbageCollectionsResponse.garbageCollections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(garbageCollections);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListGarbageCollectionsResponse {\n");
        sb.append("    garbageCollections: ").append(toIndentedString(garbageCollections)).append("\n");
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
