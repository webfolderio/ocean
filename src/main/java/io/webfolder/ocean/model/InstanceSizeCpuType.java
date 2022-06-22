package io.webfolder.ocean.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets instance_size_cpu_type
 */
public enum InstanceSizeCpuType {

    UNSPECIFIED("UNSPECIFIED"),

    SHARED("SHARED"),

    DEDICATED("DEDICATED");

    private String value;

    InstanceSizeCpuType(String value) {
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
    public static InstanceSizeCpuType fromValue(String value) {
        for (InstanceSizeCpuType b : InstanceSizeCpuType.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
