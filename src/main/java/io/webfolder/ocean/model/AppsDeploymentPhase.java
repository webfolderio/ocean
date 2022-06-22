package io.webfolder.ocean.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets apps_deployment_phase
 */
public enum AppsDeploymentPhase {

    UNKNOWN("UNKNOWN"),

    PENDING_BUILD("PENDING_BUILD"),

    BUILDING("BUILDING"),

    PENDING_DEPLOY("PENDING_DEPLOY"),

    DEPLOYING("DEPLOYING"),

    ACTIVE("ACTIVE"),

    SUPERSEDED("SUPERSEDED"),

    ERROR("ERROR"),

    CANCELED("CANCELED");

    private String value;

    AppsDeploymentPhase(String value) {
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
    public static AppsDeploymentPhase fromValue(String value) {
        for (AppsDeploymentPhase b : AppsDeploymentPhase.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}