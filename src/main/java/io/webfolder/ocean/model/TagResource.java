package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * TagResource
 */
@JsonPropertyOrder({ TagResource.JSON_PROPERTY_RESOURCES })
public class TagResource {
    public static final String JSON_PROPERTY_RESOURCES = "resources";
    private List<TagResourceResourcesInner> resources = new ArrayList<>();

    public TagResource() {
    }

    public TagResource resources(List<TagResourceResourcesInner> resources) {
        this.resources = resources;
        return this;
    }

    public TagResource addResourcesItem(TagResourceResourcesInner resourcesItem) {
        this.resources.add(resourcesItem);
        return this;
    }

    /**
     * An array of objects containing resource_id and resource_type attributes.
     *
     * @return resources
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_RESOURCES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<TagResourceResourcesInner> getResources() {
        return resources;
    }

    @JsonProperty(JSON_PROPERTY_RESOURCES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setResources(List<TagResourceResourcesInner> resources) {
        this.resources = resources;
    }

    /**
     * Return true if this tag_resource object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TagResource tagResource = (TagResource) o;
        return Objects.equals(this.resources, tagResource.resources);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resources);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TagResource {\n");
        sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
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
