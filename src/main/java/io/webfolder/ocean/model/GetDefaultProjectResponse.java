package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * GetDefaultProjectResponse
 */
@JsonPropertyOrder({ GetDefaultProjectResponse.JSON_PROPERTY_PROJECT })
public class GetDefaultProjectResponse {
    public static final String JSON_PROPERTY_PROJECT = "project";
    private Project project;

    public GetDefaultProjectResponse() {
    }

    public GetDefaultProjectResponse project(Project project) {
        this.project = project;
        return this;
    }

    /**
     * Get project
     *
     * @return project
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
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
     * Return true if this get_default_project_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetDefaultProjectResponse getDefaultProjectResponse = (GetDefaultProjectResponse) o;
        return Objects.equals(this.project, getDefaultProjectResponse.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetDefaultProjectResponse {\n");
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
