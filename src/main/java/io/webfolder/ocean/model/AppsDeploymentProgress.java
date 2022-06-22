package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * AppsDeploymentProgress
 */
@JsonPropertyOrder({ AppsDeploymentProgress.JSON_PROPERTY_ERROR_STEPS,
        AppsDeploymentProgress.JSON_PROPERTY_PENDING_STEPS, AppsDeploymentProgress.JSON_PROPERTY_RUNNING_STEPS,
        AppsDeploymentProgress.JSON_PROPERTY_STEPS, AppsDeploymentProgress.JSON_PROPERTY_SUCCESS_STEPS,
        AppsDeploymentProgress.JSON_PROPERTY_SUMMARY_STEPS, AppsDeploymentProgress.JSON_PROPERTY_TOTAL_STEPS })
public class AppsDeploymentProgress {
    public static final String JSON_PROPERTY_ERROR_STEPS = "error_steps";
    private Integer errorSteps;

    public static final String JSON_PROPERTY_PENDING_STEPS = "pending_steps";
    private Integer pendingSteps;

    public static final String JSON_PROPERTY_RUNNING_STEPS = "running_steps";
    private Integer runningSteps;

    public static final String JSON_PROPERTY_STEPS = "steps";
    private List<AppsDeploymentProgressStep> steps = null;

    public static final String JSON_PROPERTY_SUCCESS_STEPS = "success_steps";
    private Integer successSteps;

    public static final String JSON_PROPERTY_SUMMARY_STEPS = "summary_steps";
    private List<AppsDeploymentProgressStep> summarySteps = null;

    public static final String JSON_PROPERTY_TOTAL_STEPS = "total_steps";
    private Integer totalSteps;

    public AppsDeploymentProgress() {
    }

    public AppsDeploymentProgress errorSteps(Integer errorSteps) {
        this.errorSteps = errorSteps;
        return this;
    }

    /**
     * Get errorSteps
     *
     * @return errorSteps
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "3", value = "")
    @JsonProperty(JSON_PROPERTY_ERROR_STEPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getErrorSteps() {
        return errorSteps;
    }

    @JsonProperty(JSON_PROPERTY_ERROR_STEPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setErrorSteps(Integer errorSteps) {
        this.errorSteps = errorSteps;
    }

    public AppsDeploymentProgress pendingSteps(Integer pendingSteps) {
        this.pendingSteps = pendingSteps;
        return this;
    }

    /**
     * Get pendingSteps
     *
     * @return pendingSteps
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "2", value = "")
    @JsonProperty(JSON_PROPERTY_PENDING_STEPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getPendingSteps() {
        return pendingSteps;
    }

    @JsonProperty(JSON_PROPERTY_PENDING_STEPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPendingSteps(Integer pendingSteps) {
        this.pendingSteps = pendingSteps;
    }

    public AppsDeploymentProgress runningSteps(Integer runningSteps) {
        this.runningSteps = runningSteps;
        return this;
    }

    /**
     * Get runningSteps
     *
     * @return runningSteps
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "2", value = "")
    @JsonProperty(JSON_PROPERTY_RUNNING_STEPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getRunningSteps() {
        return runningSteps;
    }

    @JsonProperty(JSON_PROPERTY_RUNNING_STEPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRunningSteps(Integer runningSteps) {
        this.runningSteps = runningSteps;
    }

    public AppsDeploymentProgress steps(List<AppsDeploymentProgressStep> steps) {
        this.steps = steps;
        return this;
    }

    public AppsDeploymentProgress addStepsItem(AppsDeploymentProgressStep stepsItem) {
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
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_STEPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AppsDeploymentProgressStep> getSteps() {
        return steps;
    }

    @JsonProperty(JSON_PROPERTY_STEPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSteps(List<AppsDeploymentProgressStep> steps) {
        this.steps = steps;
    }

    public AppsDeploymentProgress successSteps(Integer successSteps) {
        this.successSteps = successSteps;
        return this;
    }

    /**
     * Get successSteps
     *
     * @return successSteps
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "4", value = "")
    @JsonProperty(JSON_PROPERTY_SUCCESS_STEPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getSuccessSteps() {
        return successSteps;
    }

    @JsonProperty(JSON_PROPERTY_SUCCESS_STEPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSuccessSteps(Integer successSteps) {
        this.successSteps = successSteps;
    }

    public AppsDeploymentProgress summarySteps(List<AppsDeploymentProgressStep> summarySteps) {
        this.summarySteps = summarySteps;
        return this;
    }

    public AppsDeploymentProgress addSummaryStepsItem(AppsDeploymentProgressStep summaryStepsItem) {
        if (this.summarySteps == null) {
            this.summarySteps = new ArrayList<>();
        }
        this.summarySteps.add(summaryStepsItem);
        return this;
    }

    /**
     * Get summarySteps
     *
     * @return summarySteps
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_SUMMARY_STEPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AppsDeploymentProgressStep> getSummarySteps() {
        return summarySteps;
    }

    @JsonProperty(JSON_PROPERTY_SUMMARY_STEPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSummarySteps(List<AppsDeploymentProgressStep> summarySteps) {
        this.summarySteps = summarySteps;
    }

    public AppsDeploymentProgress totalSteps(Integer totalSteps) {
        this.totalSteps = totalSteps;
        return this;
    }

    /**
     * Get totalSteps
     *
     * @return totalSteps
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "5", value = "")
    @JsonProperty(JSON_PROPERTY_TOTAL_STEPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getTotalSteps() {
        return totalSteps;
    }

    @JsonProperty(JSON_PROPERTY_TOTAL_STEPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTotalSteps(Integer totalSteps) {
        this.totalSteps = totalSteps;
    }

    /**
     * Return true if this apps_deployment_progress object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsDeploymentProgress appsDeploymentProgress = (AppsDeploymentProgress) o;
        return Objects.equals(this.errorSteps, appsDeploymentProgress.errorSteps)
                && Objects.equals(this.pendingSteps, appsDeploymentProgress.pendingSteps)
                && Objects.equals(this.runningSteps, appsDeploymentProgress.runningSteps)
                && Objects.equals(this.steps, appsDeploymentProgress.steps)
                && Objects.equals(this.successSteps, appsDeploymentProgress.successSteps)
                && Objects.equals(this.summarySteps, appsDeploymentProgress.summarySteps)
                && Objects.equals(this.totalSteps, appsDeploymentProgress.totalSteps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorSteps, pendingSteps, runningSteps, steps, successSteps, summarySteps, totalSteps);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsDeploymentProgress {\n");
        sb.append("    errorSteps: ").append(toIndentedString(errorSteps)).append("\n");
        sb.append("    pendingSteps: ").append(toIndentedString(pendingSteps)).append("\n");
        sb.append("    runningSteps: ").append(toIndentedString(runningSteps)).append("\n");
        sb.append("    steps: ").append(toIndentedString(steps)).append("\n");
        sb.append("    successSteps: ").append(toIndentedString(successSteps)).append("\n");
        sb.append("    summarySteps: ").append(toIndentedString(summarySteps)).append("\n");
        sb.append("    totalSteps: ").append(toIndentedString(totalSteps)).append("\n");
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
