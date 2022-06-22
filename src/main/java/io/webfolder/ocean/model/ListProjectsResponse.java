package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListProjectsResponse
 */
@JsonPropertyOrder({ ListProjectsResponse.JSON_PROPERTY_PROJECTS, ListProjectsResponse.JSON_PROPERTY_LINKS,
        ListProjectsResponse.JSON_PROPERTY_META })
public class ListProjectsResponse {
    public static final String JSON_PROPERTY_PROJECTS = "projects";
    private List<Project> projects = null;

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public ListProjectsResponse() {
    }

    public ListProjectsResponse projects(List<Project> projects) {
        this.projects = projects;
        return this;
    }

    public ListProjectsResponse addProjectsItem(Project projectsItem) {
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
    @ApiModelProperty(value = "")
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

    public ListProjectsResponse links(PageLinks links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     *
     * @return links
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_LINKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public PageLinks getLinks() {
        return links;
    }

    @JsonProperty(JSON_PROPERTY_LINKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLinks(PageLinks links) {
        this.links = links;
    }

    public ListProjectsResponse meta(MetaMeta meta) {
        this.meta = meta;
        return this;
    }

    /**
     * Get meta
     *
     * @return meta
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_META)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public MetaMeta getMeta() {
        return meta;
    }

    @JsonProperty(JSON_PROPERTY_META)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setMeta(MetaMeta meta) {
        this.meta = meta;
    }

    /**
     * Return true if this list_projects_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListProjectsResponse listProjectsResponse = (ListProjectsResponse) o;
        return Objects.equals(this.projects, listProjectsResponse.projects)
                && Objects.equals(this.links, listProjectsResponse.links)
                && Objects.equals(this.meta, listProjectsResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projects, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListProjectsResponse {\n");
        sb.append("    projects: ").append(toIndentedString(projects)).append("\n");
        sb.append("    links: ").append(toIndentedString(links)).append("\n");
        sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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