package io.webfolder.ocean.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets app_alert_spec_operator
 */
public enum AppAlertSpecOperator {

    UNSPECIFIED_OPERATOR("UNSPECIFIED_OPERATOR"),

    GREATER_THAN("GREATER_THAN"),

    LESS_THAN("LESS_THAN");

    private String value;

    AppAlertSpecOperator(String value) {
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
    public static AppAlertSpecOperator fromValue(String value) {
        for (AppAlertSpecOperator b : AppAlertSpecOperator.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
