package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListRepositoryDigestsResponse
 */
@JsonPropertyOrder({ ListRepositoryDigestsResponse.JSON_PROPERTY_MANIFESTS,
        ListRepositoryDigestsResponse.JSON_PROPERTY_LINKS, ListRepositoryDigestsResponse.JSON_PROPERTY_META })
public class ListRepositoryDigestsResponse {
    public static final String JSON_PROPERTY_MANIFESTS = "manifests";
    private List<RepositoryManifest> manifests = null;

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public ListRepositoryDigestsResponse() {
    }

    public ListRepositoryDigestsResponse manifests(List<RepositoryManifest> manifests) {
        this.manifests = manifests;
        return this;
    }

    public ListRepositoryDigestsResponse addManifestsItem(RepositoryManifest manifestsItem) {
        if (this.manifests == null) {
            this.manifests = new ArrayList<>();
        }
        this.manifests.add(manifestsItem);
        return this;
    }

    /**
     * Get manifests
     *
     * @return manifests
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MANIFESTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<RepositoryManifest> getManifests() {
        return manifests;
    }

    @JsonProperty(JSON_PROPERTY_MANIFESTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setManifests(List<RepositoryManifest> manifests) {
        this.manifests = manifests;
    }

    public ListRepositoryDigestsResponse links(PageLinks links) {
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

    public ListRepositoryDigestsResponse meta(MetaMeta meta) {
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
     * Return true if this list_repository_digests_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListRepositoryDigestsResponse listRepositoryDigestsResponse = (ListRepositoryDigestsResponse) o;
        return Objects.equals(this.manifests, listRepositoryDigestsResponse.manifests)
                && Objects.equals(this.links, listRepositoryDigestsResponse.links)
                && Objects.equals(this.meta, listRepositoryDigestsResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manifests, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListRepositoryDigestsResponse {\n");
        sb.append("    manifests: ").append(toIndentedString(manifests)).append("\n");
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
