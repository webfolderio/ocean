package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppsDeploymentProgressStep
 */
@JsonPropertyOrder({ AppsDeploymentProgressStep.JSON_PROPERTY_COMPONENT_NAME,
        AppsDeploymentProgressStep.JSON_PROPERTY_ENDED_AT, AppsDeploymentProgressStep.JSON_PROPERTY_MESSAGE_BASE,
        AppsDeploymentProgressStep.JSON_PROPERTY_NAME, AppsDeploymentProgressStep.JSON_PROPERTY_REASON,
        AppsDeploymentProgressStep.JSON_PROPERTY_STARTED_AT, AppsDeploymentProgressStep.JSON_PROPERTY_STATUS,
        AppsDeploymentProgressStep.JSON_PROPERTY_STEPS })
public class AppsDeploymentProgressStep {
    public static final String JSON_PROPERTY_COMPONENT_NAME = "component_name";
    private String componentName;

    public static final String JSON_PROPERTY_ENDED_AT = "ended_at";
    private OffsetDateTime endedAt;

    public static final String JSON_PROPERTY_MESSAGE_BASE = "message_base";
    private String messageBase;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_REASON = "reason";
    private AppsDeploymentProgressStepReason reason;

    public static final String JSON_PROPERTY_STARTED_AT = "started_at";
    private OffsetDateTime startedAt;

    public static final String JSON_PROPERTY_STATUS = "status";
    private AppsDeploymentProgressStepStatus status = AppsDeploymentProgressStepStatus.UNKNOWN;

    public static final String JSON_PROPERTY_STEPS = "steps";
    private List<Object> steps = null;

    public AppsDeploymentProgressStep() {
    }

    public AppsDeploymentProgressStep componentName(String componentName) {
        this.componentName = componentName;
        return this;
    }

    /**
     * Get componentName
     *
     * @return componentName
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_COMPONENT_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getComponentName() {
        return componentName;
    }

    @JsonProperty(JSON_PROPERTY_COMPONENT_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public AppsDeploymentProgressStep endedAt(OffsetDateTime endedAt) {
        this.endedAt = endedAt;
        return this;
    }

    /**
     * Get endedAt
     *
     * @return endedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ENDED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getEndedAt() {
        return endedAt;
    }

    @JsonProperty(JSON_PROPERTY_ENDED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEndedAt(OffsetDateTime endedAt) {
        this.endedAt = endedAt;
    }

    public AppsDeploymentProgressStep messageBase(String messageBase) {
        this.messageBase = messageBase;
        return this;
    }

    /**
     * The base of a human-readable description of the step intended to be combined
     * with the component name for presentation. For example:
     * &#x60;message_base&#x60; &#x3D; \&quot;Building service\&quot;
     * &#x60;component_name&#x60; &#x3D; \&quot;api\&quot;
     *
     * @return messageBase
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MESSAGE_BASE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getMessageBase() {
        return messageBase;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE_BASE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMessageBase(String messageBase) {
        this.messageBase = messageBase;
    }

    public AppsDeploymentProgressStep name(String name) {
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

    public AppsDeploymentProgressStep reason(AppsDeploymentProgressStepReason reason) {
        this.reason = reason;
        return this;
    }

    /**
     * Get reason
     *
     * @return reason
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REASON)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AppsDeploymentProgressStepReason getReason() {
        return reason;
    }

    @JsonProperty(JSON_PROPERTY_REASON)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setReason(AppsDeploymentProgressStepReason reason) {
        this.reason = reason;
    }

    public AppsDeploymentProgressStep startedAt(OffsetDateTime startedAt) {
        this.startedAt = startedAt;
        return this;
    }

    /**
     * Get startedAt
     *
     * @return startedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STARTED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getStartedAt() {
        return startedAt;
    }

    @JsonProperty(JSON_PROPERTY_STARTED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStartedAt(OffsetDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public AppsDeploymentProgressStep status(AppsDeploymentProgressStepStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AppsDeploymentProgressStepStatus getStatus() {
        return status;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStatus(AppsDeploymentProgressStepStatus status) {
        this.status = status;
    }

    public AppsDeploymentProgressStep steps(List<Object> steps) {
        this.steps = steps;
        return this;
    }

    public AppsDeploymentProgressStep addStepsItem(Object stepsItem) {
        if (this.steps == null) {
            this.steps = new ArrayList<>();
        }
        this.steps.add(stepsItem);
        return this;
    }

    /**
     * Get steps
     *
     * @return steps
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STEPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Object> getSteps() {
        return steps;
    }

    @JsonProperty(JSON_PROPERTY_STEPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSteps(List<Object> steps) {
        this.steps = steps;
    }

    /**
     * Return true if this apps_deployment_progress_step object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsDeploymentProgressStep appsDeploymentProgressStep = (AppsDeploymentProgressStep) o;
        return Objects.equals(this.componentName, appsDeploymentProgressStep.componentName)
                && Objects.equals(this.endedAt, appsDeploymentProgressStep.endedAt)
                && Objects.equals(this.messageBase, appsDeploymentProgressStep.messageBase)
                && Objects.equals(this.name, appsDeploymentProgressStep.name)
                && Objects.equals(this.reason, appsDeploymentProgressStep.reason)
                && Objects.equals(this.startedAt, appsDeploymentProgressStep.startedAt)
                && Objects.equals(this.status, appsDeploymentProgressStep.status)
                && Objects.equals(this.steps, appsDeploymentProgressStep.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(componentName, endedAt, messageBase, name, reason, startedAt, status, steps);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsDeploymentProgressStep {\n");
        sb.append("    componentName: ").append(toIndentedString(componentName)).append("\n");
        sb.append("    endedAt: ").append(toIndentedString(endedAt)).append("\n");
        sb.append("    messageBase: ").append(toIndentedString(messageBase)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    startedAt: ").append(toIndentedString(startedAt)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    steps: ").append(toIndentedString(steps)).append("\n");
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
