package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppAlertProgress
 */
@JsonPropertyOrder({ AppAlertProgress.JSON_PROPERTY_STEPS })
public class AppAlertProgress {
    public static final String JSON_PROPERTY_STEPS = "steps";
    private List<AppAlertProgressStep> steps = null;

    public AppAlertProgress() {
    }

    public AppAlertProgress steps(List<AppAlertProgressStep> steps) {
        this.steps = steps;
        return this;
    }

    public AppAlertProgress addStepsItem(AppAlertProgressStep stepsItem) {
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
    public List<AppAlertProgressStep> getSteps() {
        return steps;
    }

    @JsonProperty(JSON_PROPERTY_STEPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSteps(List<AppAlertProgressStep> steps) {
        this.steps = steps;
    }

    /**
     * Return true if this app_alert_progress object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppAlertProgress appAlertProgress = (AppAlertProgress) o;
        return Objects.equals(this.steps, appAlertProgress.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(steps);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppAlertProgress {\n");
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