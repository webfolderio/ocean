package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppsGitSourceSpec
 */
@JsonPropertyOrder({ AppsGitSourceSpec.JSON_PROPERTY_BRANCH, AppsGitSourceSpec.JSON_PROPERTY_REPO_CLONE_URL })
public class AppsGitSourceSpec {
    public static final String JSON_PROPERTY_BRANCH = "branch";
    private String branch;

    public static final String JSON_PROPERTY_REPO_CLONE_URL = "repo_clone_url";
    private String repoCloneUrl;

    public AppsGitSourceSpec() {
    }

    public AppsGitSourceSpec branch(String branch) {
        this.branch = branch;
        return this;
    }

    /**
     * The name of the branch to use
     *
     * @return branch
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_BRANCH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getBranch() {
        return branch;
    }

    @JsonProperty(JSON_PROPERTY_BRANCH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setBranch(String branch) {
        this.branch = branch;
    }

    public AppsGitSourceSpec repoCloneUrl(String repoCloneUrl) {
        this.repoCloneUrl = repoCloneUrl;
        return this;
    }

    /**
     * The clone URL of the repo. Example:
     * &#x60;https://github.com/digitalocean/sample-golang.git&#x60;
     *
     * @return repoCloneUrl
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REPO_CLONE_URL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getRepoCloneUrl() {
        return repoCloneUrl;
    }

    @JsonProperty(JSON_PROPERTY_REPO_CLONE_URL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRepoCloneUrl(String repoCloneUrl) {
        this.repoCloneUrl = repoCloneUrl;
    }

    /**
     * Return true if this apps_git_source_spec object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsGitSourceSpec appsGitSourceSpec = (AppsGitSourceSpec) o;
        return Objects.equals(this.branch, appsGitSourceSpec.branch)
                && Objects.equals(this.repoCloneUrl, appsGitSourceSpec.repoCloneUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branch, repoCloneUrl);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsGitSourceSpec {\n");
        sb.append("    branch: ").append(toIndentedString(branch)).append("\n");
        sb.append("    repoCloneUrl: ").append(toIndentedString(repoCloneUrl)).append("\n");
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