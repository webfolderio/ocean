package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Tagged Resource Statistics include metadata regarding the resource type that
 * has been tagged.
 */
@JsonPropertyOrder({ TagMetadata.JSON_PROPERTY_COUNT, TagMetadata.JSON_PROPERTY_LAST_TAGGED_URI })
public class TagMetadata {
    public static final String JSON_PROPERTY_COUNT = "count";
    private Integer count;

    public static final String JSON_PROPERTY_LAST_TAGGED_URI = "last_tagged_uri";
    private String lastTaggedUri;

    public TagMetadata() {
    }

    public TagMetadata count(Integer count) {
        this.count = count;
        return this;
    }

    /**
     * The number of tagged objects for this type of resource. minimum: 0
     *
     * @return count
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_COUNT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Integer getCount() {
        return count;
    }

    @JsonProperty(JSON_PROPERTY_COUNT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCount(Integer count) {
        this.count = count;
    }

    public TagMetadata lastTaggedUri(String lastTaggedUri) {
        this.lastTaggedUri = lastTaggedUri;
        return this;
    }

    /**
     * The URI for the last tagged object for this type of resource.
     *
     * @return lastTaggedUri
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LAST_TAGGED_URI)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLastTaggedUri() {
        return lastTaggedUri;
    }

    @JsonProperty(JSON_PROPERTY_LAST_TAGGED_URI)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLastTaggedUri(String lastTaggedUri) {
        this.lastTaggedUri = lastTaggedUri;
    }

    /**
     * Return true if this tag_metadata object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TagMetadata tagMetadata = (TagMetadata) o;
        return Objects.equals(this.count, tagMetadata.count)
                && Objects.equals(this.lastTaggedUri, tagMetadata.lastTaggedUri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, lastTaggedUri);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TagMetadata {\n");
        sb.append("    count: ").append(toIndentedString(count)).append("\n");
        sb.append("    lastTaggedUri: ").append(toIndentedString(lastTaggedUri)).append("\n");
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