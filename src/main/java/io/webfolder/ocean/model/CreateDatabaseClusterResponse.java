package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * CreateDatabaseClusterResponse
 */
@JsonPropertyOrder({ CreateDatabaseClusterResponse.JSON_PROPERTY_DATABASE })
public class CreateDatabaseClusterResponse {
    public static final String JSON_PROPERTY_DATABASE = "database";
    private DatabaseCluster database;

    public CreateDatabaseClusterResponse() {
    }

    public CreateDatabaseClusterResponse database(DatabaseCluster database) {
        this.database = database;
        return this;
    }

    /**
     * Get database
     *
     * @return database
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DATABASE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public DatabaseCluster getDatabase() {
        return database;
    }

    @JsonProperty(JSON_PROPERTY_DATABASE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDatabase(DatabaseCluster database) {
        this.database = database;
    }

    /**
     * Return true if this create_database_cluster_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateDatabaseClusterResponse createDatabaseClusterResponse = (CreateDatabaseClusterResponse) o;
        return Objects.equals(this.database, createDatabaseClusterResponse.database);
    }

    @Override
    public int hashCode() {
        return Objects.hash(database);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateDatabaseClusterResponse {\n");
        sb.append("    database: ").append(toIndentedString(database)).append("\n");
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