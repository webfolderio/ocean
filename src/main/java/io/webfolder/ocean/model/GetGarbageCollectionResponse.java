package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * GetGarbageCollectionResponse
 */
@JsonPropertyOrder({ GetGarbageCollectionResponse.JSON_PROPERTY_GARBAGE_COLLECTION })
public class GetGarbageCollectionResponse {
    public static final String JSON_PROPERTY_GARBAGE_COLLECTION = "garbage_collection";
    private GarbageCollection garbageCollection;

    public GetGarbageCollectionResponse() {
    }

    public GetGarbageCollectionResponse garbageCollection(GarbageCollection garbageCollection) {
        this.garbageCollection = garbageCollection;
        return this;
    }

    /**
     * Get garbageCollection
     *
     * @return garbageCollection
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_GARBAGE_COLLECTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public GarbageCollection getGarbageCollection() {
        return garbageCollection;
    }

    @JsonProperty(JSON_PROPERTY_GARBAGE_COLLECTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setGarbageCollection(GarbageCollection garbageCollection) {
        this.garbageCollection = garbageCollection;
    }

    /**
     * Return true if this get_garbage_collection_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetGarbageCollectionResponse getGarbageCollectionResponse = (GetGarbageCollectionResponse) o;
        return Objects.equals(this.garbageCollection, getGarbageCollectionResponse.garbageCollection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(garbageCollection);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetGarbageCollectionResponse {\n");
        sb.append("    garbageCollection: ").append(toIndentedString(garbageCollection)).append("\n");
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
