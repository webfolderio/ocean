package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * An object specifying the maintenance window policy for the Kubernetes
 * cluster.
 */
@JsonPropertyOrder({ MaintenancePolicy.JSON_PROPERTY_START_TIME, MaintenancePolicy.JSON_PROPERTY_DURATION,
        MaintenancePolicy.JSON_PROPERTY_DAY })
public class MaintenancePolicy {
    public static final String JSON_PROPERTY_START_TIME = "start_time";
    private String startTime;

    public static final String JSON_PROPERTY_DURATION = "duration";
    private String duration;

    /**
     * The day of the maintenance window policy. May be one of &#x60;monday&#x60;
     * through &#x60;sunday&#x60;, or &#x60;any&#x60; to indicate an arbitrary week
     * day.
     */
    public enum DayEnum {
        ANY("any"),

        MONDAY("monday"),

        TUESDAY("tuesday"),

        WEDNESDAY("wednesday"),

        THURSDAY("thursday"),

        FRIDAY("friday"),

        SATURDAY("saturday"),

        SUNDAY("sunday");

        private String value;

        DayEnum(String value) {
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
        public static DayEnum fromValue(String value) {
            for (DayEnum b : DayEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_DAY = "day";
    private DayEnum day;

    public MaintenancePolicy() {
    }

    @JsonCreator
    public MaintenancePolicy(@JsonProperty(JSON_PROPERTY_DURATION) String duration) {
        this();
        this.duration = duration;
    }

    public MaintenancePolicy startTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * The start time in UTC of the maintenance window policy in 24-hour clock
     * format / HH:MM notation (e.g., &#x60;15:00&#x60;).
     *
     * @return startTime
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_START_TIME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getStartTime() {
        return startTime;
    }

    @JsonProperty(JSON_PROPERTY_START_TIME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * The duration of the maintenance window policy in human-readable format.
     *
     * @return duration
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DURATION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getDuration() {
        return duration;
    }

    public MaintenancePolicy day(DayEnum day) {
        this.day = day;
        return this;
    }

    /**
     * The day of the maintenance window policy. May be one of &#x60;monday&#x60;
     * through &#x60;sunday&#x60;, or &#x60;any&#x60; to indicate an arbitrary week
     * day.
     *
     * @return day
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DAY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public DayEnum getDay() {
        return day;
    }

    @JsonProperty(JSON_PROPERTY_DAY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDay(DayEnum day) {
        this.day = day;
    }

    /**
     * Return true if this maintenance_policy object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MaintenancePolicy maintenancePolicy = (MaintenancePolicy) o;
        return Objects.equals(this.startTime, maintenancePolicy.startTime)
                && Objects.equals(this.duration, maintenancePolicy.duration)
                && Objects.equals(this.day, maintenancePolicy.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, duration, day);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MaintenancePolicy {\n");
        sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
        sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
        sb.append("    day: ").append(toIndentedString(day)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}