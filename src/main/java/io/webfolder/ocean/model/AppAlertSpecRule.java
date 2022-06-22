package io.webfolder.ocean.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets app_alert_spec_rule
 */
public enum AppAlertSpecRule {

    UNSPECIFIED_RULE("UNSPECIFIED_RULE"),

    CPU_UTILIZATION("CPU_UTILIZATION"),

    MEM_UTILIZATION("MEM_UTILIZATION"),

    RESTART_COUNT("RESTART_COUNT"),

    DEPLOYMENT_FAILED("DEPLOYMENT_FAILED"),

    DEPLOYMENT_LIVE("DEPLOYMENT_LIVE"),

    DOMAIN_FAILED("DOMAIN_FAILED"),

    DOMAIN_LIVE("DOMAIN_LIVE"),

    FUNCTIONS_ACTIVATION_COUNT("FUNCTIONS_ACTIVATION_COUNT"),

    FUNCTIONS_AVERAGE_DURATION_MS("FUNCTIONS_AVERAGE_DURATION_MS"),

    FUNCTIONS_ERROR_RATE_PER_MINUTE("FUNCTIONS_ERROR_RATE_PER_MINUTE"),

    FUNCTIONS_AVERAGE_WAIT_TIME_MS("FUNCTIONS_AVERAGE_WAIT_TIME_MS"),

    FUNCTIONS_ERROR_COUNT("FUNCTIONS_ERROR_COUNT"),

    FUNCTIONS_GB_RATE_PER_SECOND("FUNCTIONS_GB_RATE_PER_SECOND");

    private String value;

    AppAlertSpecRule(String value) {
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
    public static AppAlertSpecRule fromValue(String value) {
        for (AppAlertSpecRule b : AppAlertSpecRule.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
