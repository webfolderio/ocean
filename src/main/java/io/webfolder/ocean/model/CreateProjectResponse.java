package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * CreateProjectResponse
 */
@JsonPropertyOrder({ CreateProjectResponse.JSON_PROPERTY_PROJECT })
public class CreateProjectResponse {
    public static final String JSON_PROPERTY_PROJECT = "project";
    private Project project;

    public CreateProjectResponse() {
    }

    public CreateProjectResponse project(Project project) {
        this.project = project;
        return this;
    }

    /**
     * Get project
     *
     * @return project
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PROJECT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Project getProject() {
        return project;
    }

    @JsonProperty(JSON_PROPERTY_PROJECT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * Return true if this create_project_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateProjectResponse createProjectResponse = (CreateProjectResponse) o;
        return Objects.equals(this.project, createProjectResponse.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateProjectResponse {\n");
        sb.append("    project: ").append(toIndentedString(project)).append("\n");
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