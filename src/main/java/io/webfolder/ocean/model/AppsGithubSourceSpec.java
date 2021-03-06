package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppsGithubSourceSpec
 */
@JsonPropertyOrder({ AppsGithubSourceSpec.JSON_PROPERTY_BRANCH, AppsGithubSourceSpec.JSON_PROPERTY_DEPLOY_ON_PUSH,
        AppsGithubSourceSpec.JSON_PROPERTY_REPO })
public class AppsGithubSourceSpec {
    public static final String JSON_PROPERTY_BRANCH = "branch";
    private String branch;

    public static final String JSON_PROPERTY_DEPLOY_ON_PUSH = "deploy_on_push";
    private Boolean deployOnPush;

    public static final String JSON_PROPERTY_REPO = "repo";
    private String repo;

    public AppsGithubSourceSpec() {
    }

    public AppsGithubSourceSpec branch(String branch) {
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

    public AppsGithubSourceSpec deployOnPush(Boolean deployOnPush) {
        this.deployOnPush = deployOnPush;
        return this;
    }

    /**
     * Whether to automatically deploy new commits made to the repo
     *
     * @return deployOnPush
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DEPLOY_ON_PUSH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Boolean getDeployOnPush() {
        return deployOnPush;
    }

    @JsonProperty(JSON_PROPERTY_DEPLOY_ON_PUSH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDeployOnPush(Boolean deployOnPush) {
        this.deployOnPush = deployOnPush;
    }

    public AppsGithubSourceSpec repo(String repo) {
        this.repo = repo;
        return this;
    }

    /**
     * The name of the repo in the format owner/repo. Example:
     * &#x60;digitalocean/sample-golang&#x60;
     *
     * @return repo
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REPO)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getRepo() {
        return repo;
    }

    @JsonProperty(JSON_PROPERTY_REPO)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRepo(String repo) {
        this.repo = repo;
    }

    /**
     * Return true if this apps_github_source_spec object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsGithubSourceSpec appsGithubSourceSpec = (AppsGithubSourceSpec) o;
        return Objects.equals(this.branch, appsGithubSourceSpec.branch)
                && Objects.equals(this.deployOnPush, appsGithubSourceSpec.deployOnPush)
                && Objects.equals(this.repo, appsGithubSourceSpec.repo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branch, deployOnPush, repo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsGithubSourceSpec {\n");
        sb.append("    branch: ").append(toIndentedString(branch)).append("\n");
        sb.append("    deployOnPush: ").append(toIndentedString(deployOnPush)).append("\n");
        sb.append("    repo: ").append(toIndentedString(repo)).append("\n");
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