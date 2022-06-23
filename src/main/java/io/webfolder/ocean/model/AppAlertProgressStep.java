package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppAlertProgressStep
 */
@JsonPropertyOrder({ AppAlertProgressStep.JSON_PROPERTY_NAME, AppAlertProgressStep.JSON_PROPERTY_STATUS,
        AppAlertProgressStep.JSON_PROPERTY_STARTED_AT, AppAlertProgressStep.JSON_PROPERTY_ENDED_AT,
        AppAlertProgressStep.JSON_PROPERTY_REASON })
public class AppAlertProgressStep {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_STATUS = "status";
    private AppAlertProgressStepStatus status = AppAlertProgressStepStatus.UNKNOWN;

    public static final String JSON_PROPERTY_STARTED_AT = "started_at";
    private OffsetDateTime startedAt;

    public static final String JSON_PROPERTY_ENDED_AT = "ended_at";
    private OffsetDateTime endedAt;

    public static final String JSON_PROPERTY_REASON = "reason";
    private AppAlertProgressStepReason reason;

    public AppAlertProgressStep() {
    }

    public AppAlertProgressStep name(String name) {
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

    public AppAlertProgressStep status(AppAlertProgressStepStatus status) {
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

    public AppAlertProgressStepStatus getStatus() {
        return status;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStatus(AppAlertProgressStepStatus status) {
        this.status = status;
    }

    public AppAlertProgressStep startedAt(OffsetDateTime startedAt) {
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

    public AppAlertProgressStep endedAt(OffsetDateTime endedAt) {
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

    public AppAlertProgressStep reason(AppAlertProgressStepReason reason) {
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

    public AppAlertProgressStepReason getReason() {
        return reason;
    }

    @JsonProperty(JSON_PROPERTY_REASON)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setReason(AppAlertProgressStepReason reason) {
        this.reason = reason;
    }

    /**
     * Return true if this app_alert_progress_step object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppAlertProgressStep appAlertProgressStep = (AppAlertProgressStep) o;
        return Objects.equals(this.name, appAlertProgressStep.name)
                && Objects.equals(this.status, appAlertProgressStep.status)
                && Objects.equals(this.startedAt, appAlertProgressStep.startedAt)
                && Objects.equals(this.endedAt, appAlertProgressStep.endedAt)
                && Objects.equals(this.reason, appAlertProgressStep.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, status, startedAt, endedAt, reason);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppAlertProgressStep {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    startedAt: ").append(toIndentedString(startedAt)).append("\n");
        sb.append("    endedAt: ").append(toIndentedString(endedAt)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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