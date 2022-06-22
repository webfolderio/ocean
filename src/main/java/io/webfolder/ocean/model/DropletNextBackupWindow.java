package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The details of the Droplet&#39;s backups feature, if backups are configured
 * for the Droplet. This object contains keys for the start and end times of the
 * window during which the backup will start.
 */
@JsonPropertyOrder({ DropletNextBackupWindow.JSON_PROPERTY_START, DropletNextBackupWindow.JSON_PROPERTY_END })
public class DropletNextBackupWindow {
    public static final String JSON_PROPERTY_START = "start";
    private OffsetDateTime start;

    public static final String JSON_PROPERTY_END = "end";
    private OffsetDateTime end;

    public DropletNextBackupWindow() {
    }

    public DropletNextBackupWindow start(OffsetDateTime start) {
        this.start = start;
        return this;
    }

    /**
     * A time value given in ISO8601 combined date and time format specifying the
     * start of the Droplet&#39;s backup window.
     *
     * @return start
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_START)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getStart() {
        return start;
    }

    @JsonProperty(JSON_PROPERTY_START)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStart(OffsetDateTime start) {
        this.start = start;
    }

    public DropletNextBackupWindow end(OffsetDateTime end) {
        this.end = end;
        return this;
    }

    /**
     * A time value given in ISO8601 combined date and time format specifying the
     * end of the Droplet&#39;s backup window.
     *
     * @return end
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_END)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getEnd() {
        return end;
    }

    @JsonProperty(JSON_PROPERTY_END)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEnd(OffsetDateTime end) {
        this.end = end;
    }

    /**
     * Return true if this droplet_next_backup_window object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DropletNextBackupWindow dropletNextBackupWindow = (DropletNextBackupWindow) o;
        return Objects.equals(this.start, dropletNextBackupWindow.start)
                && Objects.equals(this.end, dropletNextBackupWindow.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DropletNextBackupWindow {\n");
        sb.append("    start: ").append(toIndentedString(start)).append("\n");
        sb.append("    end: ").append(toIndentedString(end)).append("\n");
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
