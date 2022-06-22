package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * AppsCreateDeploymentRequest
 */
@JsonPropertyOrder({ AppsCreateDeploymentRequest.JSON_PROPERTY_FORCE_BUILD })
public class AppsCreateDeploymentRequest {
    public static final String JSON_PROPERTY_FORCE_BUILD = "force_build";
    private Boolean forceBuild;

    public AppsCreateDeploymentRequest() {
    }

    public AppsCreateDeploymentRequest forceBuild(Boolean forceBuild) {
        this.forceBuild = forceBuild;
        return this;
    }

    /**
     * Get forceBuild
     *
     * @return forceBuild
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "true", value = "")
    @JsonProperty(JSON_PROPERTY_FORCE_BUILD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getForceBuild() {
        return forceBuild;
    }

    @JsonProperty(JSON_PROPERTY_FORCE_BUILD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setForceBuild(Boolean forceBuild) {
        this.forceBuild = forceBuild;
    }

    /**
     * Return true if this apps_create_deployment_request object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsCreateDeploymentRequest appsCreateDeploymentRequest = (AppsCreateDeploymentRequest) o;
        return Objects.equals(this.forceBuild, appsCreateDeploymentRequest.forceBuild);
    }

    @Override
    public int hashCode() {
        return Objects.hash(forceBuild);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsCreateDeploymentRequest {\n");
        sb.append("    forceBuild: ").append(toIndentedString(forceBuild)).append("\n");
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
