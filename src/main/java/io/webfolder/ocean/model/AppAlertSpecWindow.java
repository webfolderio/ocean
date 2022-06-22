package io.webfolder.ocean.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets app_alert_spec_window
 */
public enum AppAlertSpecWindow {

    UNSPECIFIED_WINDOW("UNSPECIFIED_WINDOW"),

    FIVE_MINUTES("FIVE_MINUTES"),

    TEN_MINUTES("TEN_MINUTES"),

    THIRTY_MINUTES("THIRTY_MINUTES"),

    ONE_HOUR("ONE_HOUR");

    private String value;

    AppAlertSpecWindow(String value) {
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
    public static AppAlertSpecWindow fromValue(String value) {
        for (AppAlertSpecWindow b : AppAlertSpecWindow.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
