package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppsDeploymentJob
 */
@JsonPropertyOrder({ AppsDeploymentJob.JSON_PROPERTY_NAME, AppsDeploymentJob.JSON_PROPERTY_SOURCE_COMMIT_HASH })
public class AppsDeploymentJob {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_SOURCE_COMMIT_HASH = "source_commit_hash";
    private String sourceCommitHash;

    public AppsDeploymentJob() {
    }

    public AppsDeploymentJob name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setName(String name) {
        this.name = name;
    }

    public AppsDeploymentJob sourceCommitHash(String sourceCommitHash) {
        this.sourceCommitHash = sourceCommitHash;
        return this;
    }

    /**
     * Get sourceCommitHash
     *
     * @return sourceCommitHash
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SOURCE_COMMIT_HASH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSourceCommitHash() {
        return sourceCommitHash;
    }

    @JsonProperty(JSON_PROPERTY_SOURCE_COMMIT_HASH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSourceCommitHash(String sourceCommitHash) {
        this.sourceCommitHash = sourceCommitHash;
    }

    /**
     * Return true if this apps_deployment_job object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsDeploymentJob appsDeploymentJob = (AppsDeploymentJob) o;
        return Objects.equals(this.name, appsDeploymentJob.name)
                && Objects.equals(this.sourceCommitHash, appsDeploymentJob.sourceCommitHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sourceCommitHash);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsDeploymentJob {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    sourceCommitHash: ").append(toIndentedString(sourceCommitHash)).append("\n");
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
