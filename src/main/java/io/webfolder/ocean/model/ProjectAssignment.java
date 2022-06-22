package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ProjectAssignment
 */
@JsonPropertyOrder({ ProjectAssignment.JSON_PROPERTY_RESOURCES })
public class ProjectAssignment {
    public static final String JSON_PROPERTY_RESOURCES = "resources";
    private List<String> resources = null;

    public ProjectAssignment() {
    }

    public ProjectAssignment resources(List<String> resources) {
        this.resources = resources;
        return this;
    }

    public ProjectAssignment addResourcesItem(String resourcesItem) {
        if (this.resources == null) {
            this.resources = new ArrayList<>();
        }
        this.resources.add(resourcesItem);
        return this;
    }

    /**
     * A list of uniform resource names (URNs) to be added to a project.
     *
     * @return resources
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_RESOURCES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getResources() {
        return resources;
    }

    @JsonProperty(JSON_PROPERTY_RESOURCES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setResources(List<String> resources) {
        this.resources = resources;
    }

    /**
     * Return true if this project_assignment object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProjectAssignment projectAssignment = (ProjectAssignment) o;
        return Objects.equals(this.resources, projectAssignment.resources);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resources);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProjectAssignment {\n");
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
