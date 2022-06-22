package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppsRollbackAppRequest
 */
@JsonPropertyOrder({ AppsRollbackAppRequest.JSON_PROPERTY_DEPLOYMENT_ID,
        AppsRollbackAppRequest.JSON_PROPERTY_SKIP_PIN })
public class AppsRollbackAppRequest {
    public static final String JSON_PROPERTY_DEPLOYMENT_ID = "deployment_id";
    private String deploymentId;

    public static final String JSON_PROPERTY_SKIP_PIN = "skip_pin";
    private Boolean skipPin;

    public AppsRollbackAppRequest() {
    }

    public AppsRollbackAppRequest deploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
        return this;
    }

    /**
     * The ID of the deployment to rollback to.
     *
     * @return deploymentId
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DEPLOYMENT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDeploymentId() {
        return deploymentId;
    }

    @JsonProperty(JSON_PROPERTY_DEPLOYMENT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    public AppsRollbackAppRequest skipPin(Boolean skipPin) {
        this.skipPin = skipPin;
        return this;
    }

    /**
     * Whether to skip pinning the rollback deployment. If false, the rollback
     * deployment will be pinned and any new deployments including Auto Deploy on
     * Push hooks will be disabled until the rollback is either manually committed
     * or reverted via the CommitAppRollback or RevertAppRollback endpoints
     * respectively. If true, the rollback will be immediately committed and the app
     * will remain unpinned.
     *
     * @return skipPin
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SKIP_PIN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getSkipPin() {
        return skipPin;
    }

    @JsonProperty(JSON_PROPERTY_SKIP_PIN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSkipPin(Boolean skipPin) {
        this.skipPin = skipPin;
    }

    /**
     * Return true if this apps_rollback_app_request object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsRollbackAppRequest appsRollbackAppRequest = (AppsRollbackAppRequest) o;
        return Objects.equals(this.deploymentId, appsRollbackAppRequest.deploymentId)
                && Objects.equals(this.skipPin, appsRollbackAppRequest.skipPin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deploymentId, skipPin);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsRollbackAppRequest {\n");
        sb.append("    deploymentId: ").append(toIndentedString(deploymentId)).append("\n");
        sb.append("    skipPin: ").append(toIndentedString(skipPin)).append("\n");
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
