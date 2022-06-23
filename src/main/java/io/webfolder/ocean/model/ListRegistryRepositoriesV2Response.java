package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListRegistryRepositoriesV2Response
 */
@JsonPropertyOrder({ ListRegistryRepositoriesV2Response.JSON_PROPERTY_REPOSITORIES,
        ListRegistryRepositoriesV2Response.JSON_PROPERTY_LINKS, ListRegistryRepositoriesV2Response.JSON_PROPERTY_META })
public class ListRegistryRepositoriesV2Response {
    public static final String JSON_PROPERTY_REPOSITORIES = "repositories";
    private List<RepositoryV2> repositories = null;

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public ListRegistryRepositoriesV2Response() {
    }

    public ListRegistryRepositoriesV2Response repositories(List<RepositoryV2> repositories) {
        this.repositories = repositories;
        return this;
    }

    public ListRegistryRepositoriesV2Response addRepositoriesItem(RepositoryV2 repositoriesItem) {
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
    @JsonProperty(JSON_PROPERTY_REPOSITORIES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<RepositoryV2> getRepositories() {
        return repositories;
    }

    @JsonProperty(JSON_PROPERTY_REPOSITORIES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRepositories(List<RepositoryV2> repositories) {
        this.repositories = repositories;
    }

    public ListRegistryRepositoriesV2Response links(PageLinks links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     *
     * @return links
     **/
    @javax.annotation.Nullable
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

    public ListRegistryRepositoriesV2Response meta(MetaMeta meta) {
        this.meta = meta;
        return this;
    }

    /**
     * Get meta
     *
     * @return meta
     **/
    @javax.annotation.Nonnull
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
     * Return true if this list_registry_repositories_v2_response object is equal to
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
        ListRegistryRepositoriesV2Response listRegistryRepositoriesV2Response = (ListRegistryRepositoriesV2Response) o;
        return Objects.equals(this.repositories, listRegistryRepositoriesV2Response.repositories)
                && Objects.equals(this.links, listRegistryRepositoriesV2Response.links)
                && Objects.equals(this.meta, listRegistryRepositoriesV2Response.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repositories, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListRegistryRepositoriesV2Response {\n");
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