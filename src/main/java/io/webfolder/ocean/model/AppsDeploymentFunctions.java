package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppsDeploymentFunctions
 */
@JsonPropertyOrder({ AppsDeploymentFunctions.JSON_PROPERTY_NAME,
        AppsDeploymentFunctions.JSON_PROPERTY_SOURCE_COMMIT_HASH, AppsDeploymentFunctions.JSON_PROPERTY_NAMESPACE })
public class AppsDeploymentFunctions {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_SOURCE_COMMIT_HASH = "source_commit_hash";
    private String sourceCommitHash;

    public static final String JSON_PROPERTY_NAMESPACE = "namespace";
    private String namespace;

    public AppsDeploymentFunctions() {
    }

    public AppsDeploymentFunctions name(String name) {
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

    public AppsDeploymentFunctions sourceCommitHash(String sourceCommitHash) {
        this.sourceCommitHash = sourceCommitHash;
        return this;
    }

    /**
     * The commit hash of the repository that was used to build this functions
     * component.
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

    public AppsDeploymentFunctions namespace(String namespace) {
        this.namespace = namespace;
        return this;
    }

    /**
     * The namespace where the functions are deployed.
     *
     * @return namespace
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NAMESPACE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getNamespace() {
        return namespace;
    }

    @JsonProperty(JSON_PROPERTY_NAMESPACE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * Return true if this apps_deployment_functions object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsDeploymentFunctions appsDeploymentFunctions = (AppsDeploymentFunctions) o;
        return Objects.equals(this.name, appsDeploymentFunctions.name)
                && Objects.equals(this.sourceCommitHash, appsDeploymentFunctions.sourceCommitHash)
                && Objects.equals(this.namespace, appsDeploymentFunctions.namespace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sourceCommitHash, namespace);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsDeploymentFunctions {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    sourceCommitHash: ").append(toIndentedString(sourceCommitHash)).append("\n");
        sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
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
