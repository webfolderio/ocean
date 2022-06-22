package io.webfolder.ocean.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets app_alert_phase
 */
public enum AppAlertPhase {

    UNKNOWN("UNKNOWN"),

    PENDING("PENDING"),

    CONFIGURING("CONFIGURING"),

    ACTIVE("ACTIVE"),

    ERROR("ERROR");

    private String value;

    AppAlertPhase(String value) {
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
    public static AppAlertPhase fromValue(String value) {
        for (AppAlertPhase b : AppAlertPhase.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}