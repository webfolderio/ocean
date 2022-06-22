package io.webfolder.ocean.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets app_alert_progress_step_status
 */
public enum AppAlertProgressStepStatus {

    UNKNOWN("UNKNOWN"),

    PENDING("PENDING"),

    RUNNING("RUNNING"),

    ERROR("ERROR"),

    SUCCESS("SUCCESS");

    private String value;

    AppAlertProgressStepStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static AppAlertProgressStepStatus fromValue(String value) {
        for (AppAlertProgressStepStatus b : AppAlertProgressStepStatus.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
