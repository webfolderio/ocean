package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListRegistryRepositoriesResponseAllOf
 */
@JsonPropertyOrder({ ListRegistryRepositoriesResponseAllOf.JSON_PROPERTY_REPOSITORIES })
public class ListRegistryRepositoriesResponseAllOf {
    public static final String JSON_PROPERTY_REPOSITORIES = "repositories";
    private List<Repository> repositories = null;

    public ListRegistryRepositoriesResponseAllOf() {
    }

    public ListRegistryRepositoriesResponseAllOf repositories(List<Repository> repositories) {
        this.repositories = repositories;
        return this;
    }

    public ListRegistryRepositoriesResponseAllOf addRepositoriesItem(Repository repositoriesItem) {
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

    public List<Repository> getRepositories() {
        return repositories;
    }

    @JsonProperty(JSON_PROPERTY_REPOSITORIES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }

    /**
     * Return true if this list_registry_repositories_response_allOf object is equal
     * to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListRegistryRepositoriesResponseAllOf listRegistryRepositoriesResponseAllOf = (ListRegistryRepositoriesResponseAllOf) o;
        return Objects.equals(this.repositories, listRegistryRepositoriesResponseAllOf.repositories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repositories);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListRegistryRepositoriesResponseAllOf {\n");
        sb.append("    repositories: ").append(toIndentedString(repositories)).append("\n");
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
