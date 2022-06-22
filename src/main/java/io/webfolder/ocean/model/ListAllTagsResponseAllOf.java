package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListAllTagsResponseAllOf
 */
@JsonPropertyOrder({ ListAllTagsResponseAllOf.JSON_PROPERTY_TAGS })
public class ListAllTagsResponseAllOf {
    public static final String JSON_PROPERTY_TAGS = "tags";
    private List<Tag> tags = null;

    public ListAllTagsResponseAllOf() {
    }

    public ListAllTagsResponseAllOf tags(List<Tag> tags) {
        this.tags = tags;
        return this;
    }

    public ListAllTagsResponseAllOf addTagsItem(Tag tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * Get tags
     *
     * @return tags
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Tag> getTags() {
        return tags;
    }

    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    /**
     * Return true if this list_all_tags_response_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListAllTagsResponseAllOf listAllTagsResponseAllOf = (ListAllTagsResponseAllOf) o;
        return Objects.equals(this.tags, listAllTagsResponseAllOf.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tags);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListAllTagsResponseAllOf {\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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
