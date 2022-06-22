package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * DatabaseBackup
 */
@JsonPropertyOrder({ DatabaseBackup.JSON_PROPERTY_DATABASE_NAME, DatabaseBackup.JSON_PROPERTY_BACKUP_CREATED_AT })
public class DatabaseBackup {
    public static final String JSON_PROPERTY_DATABASE_NAME = "database_name";
    private String databaseName;

    public static final String JSON_PROPERTY_BACKUP_CREATED_AT = "backup_created_at";
    private OffsetDateTime backupCreatedAt;

    public DatabaseBackup() {
    }

    public DatabaseBackup databaseName(String databaseName) {
        this.databaseName = databaseName;
        return this;
    }

    /**
     * The name of an existing database cluster from which the backup will be
     * restored.
     *
     * @return databaseName
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DATABASE_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getDatabaseName() {
        return databaseName;
    }

    @JsonProperty(JSON_PROPERTY_DATABASE_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public DatabaseBackup backupCreatedAt(OffsetDateTime backupCreatedAt) {
        this.backupCreatedAt = backupCreatedAt;
        return this;
    }

    /**
     * The timestamp of an existing database cluster backup in ISO8601 combined date
     * and time format. The most recent backup will be used if excluded.
     *
     * @return backupCreatedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_BACKUP_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getBackupCreatedAt() {
        return backupCreatedAt;
    }

    @JsonProperty(JSON_PROPERTY_BACKUP_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setBackupCreatedAt(OffsetDateTime backupCreatedAt) {
        this.backupCreatedAt = backupCreatedAt;
    }

    /**
     * Return true if this database_backup object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DatabaseBackup databaseBackup = (DatabaseBackup) o;
        return Objects.equals(this.databaseName, databaseBackup.databaseName)
                && Objects.equals(this.backupCreatedAt, databaseBackup.backupCreatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(databaseName, backupCreatedAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DatabaseBackup {\n");
        sb.append("    databaseName: ").append(toIndentedString(databaseName)).append("\n");
        sb.append("    backupCreatedAt: ").append(toIndentedString(backupCreatedAt)).append("\n");
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
