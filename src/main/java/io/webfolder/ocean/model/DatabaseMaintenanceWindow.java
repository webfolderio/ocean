package io.webfolder.ocean.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * DatabaseMaintenanceWindow
 */
@JsonPropertyOrder({ DatabaseMaintenanceWindow.JSON_PROPERTY_DAY, DatabaseMaintenanceWindow.JSON_PROPERTY_HOUR,
        DatabaseMaintenanceWindow.JSON_PROPERTY_PENDING, DatabaseMaintenanceWindow.JSON_PROPERTY_DESCRIPTION })
public class DatabaseMaintenanceWindow {
    public static final String JSON_PROPERTY_DAY = "day";
    private String day;

    public static final String JSON_PROPERTY_HOUR = "hour";
    private String hour;

    public static final String JSON_PROPERTY_PENDING = "pending";
    private Boolean pending;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private List<String> description = null;

    public DatabaseMaintenanceWindow() {
    }

    @JsonCreator
    public DatabaseMaintenanceWindow(@JsonProperty(JSON_PROPERTY_PENDING) Boolean pending,
            @JsonProperty(JSON_PROPERTY_DESCRIPTION) List<String> description) {
        this();
        this.pending = pending;
        this.description = description;
    }

    public DatabaseMaintenanceWindow day(String day) {
        this.day = day;
        return this;
    }

    /**
     * The day of the week on which to apply maintenance updates.
     *
     * @return day
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DAY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getDay() {
        return day;
    }

    @JsonProperty(JSON_PROPERTY_DAY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDay(String day) {
        this.day = day;
    }

    public DatabaseMaintenanceWindow hour(String hour) {
        this.hour = hour;
        return this;
    }

    /**
     * The hour in UTC at which maintenance updates will be applied in 24 hour
     * format.
     *
     * @return hour
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_HOUR)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getHour() {
        return hour;
    }

    @JsonProperty(JSON_PROPERTY_HOUR)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setHour(String hour) {
        this.hour = hour;
    }

    /**
     * A boolean value indicating whether any maintenance is scheduled to be
     * performed in the next window.
     *
     * @return pending
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PENDING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Boolean getPending() {
        return pending;
    }

    /**
     * A list of strings, each containing information about a pending maintenance
     * update.
     *
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<String> getDescription() {
        return description;
    }

    /**
     * Return true if this database_maintenance_window object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DatabaseMaintenanceWindow databaseMaintenanceWindow = (DatabaseMaintenanceWindow) o;
        return Objects.equals(this.day, databaseMaintenanceWindow.day)
                && Objects.equals(this.hour, databaseMaintenanceWindow.hour)
                && Objects.equals(this.pending, databaseMaintenanceWindow.pending)
                && Objects.equals(this.description, databaseMaintenanceWindow.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, hour, pending, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DatabaseMaintenanceWindow {\n");
        sb.append("    day: ").append(toIndentedString(day)).append("\n");
        sb.append("    hour: ").append(toIndentedString(hour)).append("\n");
        sb.append("    pending: ").append(toIndentedString(pending)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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