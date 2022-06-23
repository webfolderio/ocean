package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListDatabaseBackupsResponse
 */
@JsonPropertyOrder({ ListDatabaseBackupsResponse.JSON_PROPERTY_BACKUPS })
public class ListDatabaseBackupsResponse {
    public static final String JSON_PROPERTY_BACKUPS = "backups";
    private List<Backup> backups = new ArrayList<>();

    public ListDatabaseBackupsResponse() {
    }

    public ListDatabaseBackupsResponse backups(List<Backup> backups) {
        this.backups = backups;
        return this;
    }

    public ListDatabaseBackupsResponse addBackupsItem(Backup backupsItem) {
        this.backups.add(backupsItem);
        return this;
    }

    /**
     * Get backups
     *
     * @return backups
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_BACKUPS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<Backup> getBackups() {
        return backups;
    }

    @JsonProperty(JSON_PROPERTY_BACKUPS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setBackups(List<Backup> backups) {
        this.backups = backups;
    }

    /**
     * Return true if this list_database_backups_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListDatabaseBackupsResponse listDatabaseBackupsResponse = (ListDatabaseBackupsResponse) o;
        return Objects.equals(this.backups, listDatabaseBackupsResponse.backups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(backups);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListDatabaseBackupsResponse {\n");
        sb.append("    backups: ").append(toIndentedString(backups)).append("\n");
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