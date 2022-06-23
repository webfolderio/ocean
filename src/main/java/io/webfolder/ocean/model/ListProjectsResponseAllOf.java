package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListProjectsResponseAllOf
 */
@JsonPropertyOrder({ ListProjectsResponseAllOf.JSON_PROPERTY_PROJECTS })
public class ListProjectsResponseAllOf {
    public static final String JSON_PROPERTY_PROJECTS = "projects";
    private List<Project> projects = null;

    public ListProjectsResponseAllOf() {
    }

    public ListProjectsResponseAllOf projects(List<Project> projects) {
        this.projects = projects;
        return this;
    }

    public ListProjectsResponseAllOf addProjectsItem(Project projectsItem) {
        if (this.projects == null) {
            this.projects = new ArrayList<>();
        }
        this.projects.add(projectsItem);
        return this;
    }

    /**
     * Get projects
     *
     * @return projects
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PROJECTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<Project> getProjects() {
        return projects;
    }

    @JsonProperty(JSON_PROPERTY_PROJECTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    /**
     * Return true if this list_projects_response_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListProjectsResponseAllOf listProjectsResponseAllOf = (ListProjectsResponseAllOf) o;
        return Objects.equals(this.projects, listProjectsResponseAllOf.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projects);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListProjectsResponseAllOf {\n");
        sb.append("    projects: ").append(toIndentedString(projects)).append("\n");
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