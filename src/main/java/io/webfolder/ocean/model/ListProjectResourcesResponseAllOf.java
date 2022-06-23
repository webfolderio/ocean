package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListProjectResourcesResponseAllOf
 */
@JsonPropertyOrder({ ListProjectResourcesResponseAllOf.JSON_PROPERTY_RESOURCES })
public class ListProjectResourcesResponseAllOf {
    public static final String JSON_PROPERTY_RESOURCES = "resources";
    private List<Resource> resources = null;

    public ListProjectResourcesResponseAllOf() {
    }

    public ListProjectResourcesResponseAllOf resources(List<Resource> resources) {
        this.resources = resources;
        return this;
    }

    public ListProjectResourcesResponseAllOf addResourcesItem(Resource resourcesItem) {
        if (this.resources == null) {
            this.resources = new ArrayList<>();
        }
        this.resources.add(resourcesItem);
        return this;
    }

    /**
     * Get resources
     *
     * @return resources
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_RESOURCES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<Resource> getResources() {
        return resources;
    }

    @JsonProperty(JSON_PROPERTY_RESOURCES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    /**
     * Return true if this list_project_resources_response_allOf object is equal to
     * o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListProjectResourcesResponseAllOf listProjectResourcesResponseAllOf = (ListProjectResourcesResponseAllOf) o;
        return Objects.equals(this.resources, listProjectResourcesResponseAllOf.resources);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resources);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListProjectResourcesResponseAllOf {\n");
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