package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListDatabaseClustersResponse
 */
@JsonPropertyOrder({ ListDatabaseClustersResponse.JSON_PROPERTY_DATABASES })
public class ListDatabaseClustersResponse {
    public static final String JSON_PROPERTY_DATABASES = "databases";
    private List<DatabaseCluster> databases = null;

    public ListDatabaseClustersResponse() {
    }

    public ListDatabaseClustersResponse databases(List<DatabaseCluster> databases) {
        this.databases = databases;
        return this;
    }

    public ListDatabaseClustersResponse addDatabasesItem(DatabaseCluster databasesItem) {
        if (this.databases == null) {
            this.databases = new ArrayList<>();
        }
        this.databases.add(databasesItem);
        return this;
    }

    /**
     * Get databases
     *
     * @return databases
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_DATABASES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<DatabaseCluster> getDatabases() {
        return databases;
    }

    @JsonProperty(JSON_PROPERTY_DATABASES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDatabases(List<DatabaseCluster> databases) {
        this.databases = databases;
    }

    /**
     * Return true if this list_database_clusters_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListDatabaseClustersResponse listDatabaseClustersResponse = (ListDatabaseClustersResponse) o;
        return Objects.equals(this.databases, listDatabaseClustersResponse.databases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(databases);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListDatabaseClustersResponse {\n");
        sb.append("    databases: ").append(toIndentedString(databases)).append("\n");
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
