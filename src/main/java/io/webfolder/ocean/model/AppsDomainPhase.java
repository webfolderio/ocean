package io.webfolder.ocean.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets apps_domain_phase
 */
public enum AppsDomainPhase {

    UNKNOWN("UNKNOWN"),

    PENDING("PENDING"),

    CONFIGURING("CONFIGURING"),

    ACTIVE("ACTIVE"),

    ERROR("ERROR");

    private String value;

    AppsDomainPhase(String value) {
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
    public static AppsDomainPhase fromValue(String value) {
        for (AppsDomainPhase b : AppsDomainPhase.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
