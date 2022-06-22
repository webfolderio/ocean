package io.webfolder.ocean.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets apps_deployment_progress_step_status
 */
public enum AppsDeploymentProgressStepStatus {

    UNKNOWN("UNKNOWN"),

    PENDING("PENDING"),

    RUNNING("RUNNING"),

    ERROR("ERROR"),

    SUCCESS("SUCCESS");

    private String value;

    AppsDeploymentProgressStepStatus(String value) {
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
    public static AppsDeploymentProgressStepStatus fromValue(String value) {
        for (AppsDeploymentProgressStepStatus b : AppsDeploymentProgressStepStatus.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}