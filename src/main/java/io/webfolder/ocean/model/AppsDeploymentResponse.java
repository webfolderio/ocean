package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppsDeploymentResponse
 */
@JsonPropertyOrder({ AppsDeploymentResponse.JSON_PROPERTY_DEPLOYMENT })
public class AppsDeploymentResponse {
    public static final String JSON_PROPERTY_DEPLOYMENT = "deployment";
    private AppsDeployment deployment;

    public AppsDeploymentResponse() {
    }

    public AppsDeploymentResponse deployment(AppsDeployment deployment) {
        this.deployment = deployment;
        return this;
    }

    /**
     * Get deployment
     *
     * @return deployment
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DEPLOYMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public AppsDeployment getDeployment() {
        return deployment;
    }

    @JsonProperty(JSON_PROPERTY_DEPLOYMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDeployment(AppsDeployment deployment) {
        this.deployment = deployment;
    }

    /**
     * Return true if this apps_deployment_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsDeploymentResponse appsDeploymentResponse = (AppsDeploymentResponse) o;
        return Objects.equals(this.deployment, appsDeploymentResponse.deployment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deployment);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsDeploymentResponse {\n");
        sb.append("    deployment: ").append(toIndentedString(deployment)).append("\n");
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