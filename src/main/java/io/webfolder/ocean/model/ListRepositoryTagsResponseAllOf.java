package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListRepositoryTagsResponseAllOf
 */
@JsonPropertyOrder({ ListRepositoryTagsResponseAllOf.JSON_PROPERTY_TAGS })
public class ListRepositoryTagsResponseAllOf {
    public static final String JSON_PROPERTY_TAGS = "tags";
    private List<RepositoryTag> tags = null;

    public ListRepositoryTagsResponseAllOf() {
    }

    public ListRepositoryTagsResponseAllOf tags(List<RepositoryTag> tags) {
        this.tags = tags;
        return this;
    }

    public ListRepositoryTagsResponseAllOf addTagsItem(RepositoryTag tagsItem) {
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
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<RepositoryTag> getTags() {
        return tags;
    }

    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTags(List<RepositoryTag> tags) {
        this.tags = tags;
    }

    /**
     * Return true if this list_repository_tags_response_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListRepositoryTagsResponseAllOf listRepositoryTagsResponseAllOf = (ListRepositoryTagsResponseAllOf) o;
        return Objects.equals(this.tags, listRepositoryTagsResponseAllOf.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tags);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListRepositoryTagsResponseAllOf {\n");
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
