package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListRegistryRepositoriesResponse
 */
@JsonPropertyOrder({ ListRegistryRepositoriesResponse.JSON_PROPERTY_REPOSITORIES,
        ListRegistryRepositoriesResponse.JSON_PROPERTY_LINKS, ListRegistryRepositoriesResponse.JSON_PROPERTY_META })
public class ListRegistryRepositoriesResponse {
    public static final String JSON_PROPERTY_REPOSITORIES = "repositories";
    private List<Repository> repositories = null;

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public ListRegistryRepositoriesResponse() {
    }

    public ListRegistryRepositoriesResponse repositories(List<Repository> repositories) {
        this.repositories = repositories;
        return this;
    }

    public ListRegistryRepositoriesResponse addRepositoriesItem(Repository repositoriesItem) {
        if (this.repositories == null) {
            this.repositories = new ArrayList<>();
        }
        this.repositories.add(repositoriesItem);
        return this;
    }

    /**
     * Get repositories
     *
     * @return repositories
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_REPOSITORIES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Repository> getRepositories() {
        return repositories;
    }

    @JsonProperty(JSON_PROPERTY_REPOSITORIES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }

    public ListRegistryRepositoriesResponse links(PageLinks links) {
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

    public ListRegistryRepositoriesResponse meta(MetaMeta meta) {
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
     * Return true if this list_registry_repositories_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListRegistryRepositoriesResponse listRegistryRepositoriesResponse = (ListRegistryRepositoriesResponse) o;
        return Objects.equals(this.repositories, listRegistryRepositoriesResponse.repositories)
                && Objects.equals(this.links, listRegistryRepositoriesResponse.links)
                && Objects.equals(this.meta, listRegistryRepositoriesResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repositories, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListRegistryRepositoriesResponse {\n");
        sb.append("    repositories: ").append(toIndentedString(repositories)).append("\n");
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
