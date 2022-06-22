package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListRepositoryDigestsResponseAllOf
 */
@JsonPropertyOrder({ ListRepositoryDigestsResponseAllOf.JSON_PROPERTY_MANIFESTS })
public class ListRepositoryDigestsResponseAllOf {
    public static final String JSON_PROPERTY_MANIFESTS = "manifests";
    private List<RepositoryManifest> manifests = null;

    public ListRepositoryDigestsResponseAllOf() {
    }

    public ListRepositoryDigestsResponseAllOf manifests(List<RepositoryManifest> manifests) {
        this.manifests = manifests;
        return this;
    }

    public ListRepositoryDigestsResponseAllOf addManifestsItem(RepositoryManifest manifestsItem) {
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
    @ApiModelProperty(value = "")
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

    /**
     * Return true if this list_repository_digests_response_allOf object is equal to
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
        ListRepositoryDigestsResponseAllOf listRepositoryDigestsResponseAllOf = (ListRepositoryDigestsResponseAllOf) o;
        return Objects.equals(this.manifests, listRepositoryDigestsResponseAllOf.manifests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manifests);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListRepositoryDigestsResponseAllOf {\n");
        sb.append("    manifests: ").append(toIndentedString(manifests)).append("\n");
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
