package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * CreateDatabaseClusterRequestAllOf
 */
@JsonPropertyOrder({ CreateDatabaseClusterRequestAllOf.JSON_PROPERTY_BACKUP_RESTORE })
public class CreateDatabaseClusterRequestAllOf {
    public static final String JSON_PROPERTY_BACKUP_RESTORE = "backup_restore";
    private DatabaseBackup backupRestore;

    public CreateDatabaseClusterRequestAllOf() {
    }

    public CreateDatabaseClusterRequestAllOf backupRestore(DatabaseBackup backupRestore) {
        this.backupRestore = backupRestore;
        return this;
    }

    /**
     * Get backupRestore
     *
     * @return backupRestore
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_BACKUP_RESTORE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public DatabaseBackup getBackupRestore() {
        return backupRestore;
    }

    @JsonProperty(JSON_PROPERTY_BACKUP_RESTORE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setBackupRestore(DatabaseBackup backupRestore) {
        this.backupRestore = backupRestore;
    }

    /**
     * Return true if this create_database_cluster_request_allOf object is equal to
     * o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateDatabaseClusterRequestAllOf createDatabaseClusterRequestAllOf = (CreateDatabaseClusterRequestAllOf) o;
        return Objects.equals(this.backupRestore, createDatabaseClusterRequestAllOf.backupRestore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(backupRestore);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateDatabaseClusterRequestAllOf {\n");
        sb.append("    backupRestore: ").append(toIndentedString(backupRestore)).append("\n");
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
