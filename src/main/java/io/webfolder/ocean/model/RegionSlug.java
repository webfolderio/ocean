package io.webfolder.ocean.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The slug identifier for the region where the resource will initially be
 * available.
 */
public enum RegionSlug {

    AMS1("ams1"),

    AMS2("ams2"),

    AMS3("ams3"),

    BLR1("blr1"),

    FRA1("fra1"),

    LON1("lon1"),

    NYC1("nyc1"),

    NYC2("nyc2"),

    NYC3("nyc3"),

    SFO1("sfo1"),

    SFO2("sfo2"),

    SFO3("sfo3"),

    SGP1("sgp1"),

    TOR1("tor1");

    private String value;

    RegionSlug(String value) {
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
    public static RegionSlug fromValue(String value) {
        for (RegionSlug b : RegionSlug.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}