package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListDatabasesResponse
 */
@JsonPropertyOrder({ ListDatabasesResponse.JSON_PROPERTY_DBS })
public class ListDatabasesResponse {
    public static final String JSON_PROPERTY_DBS = "dbs";
    private List<Database> dbs = null;

    public ListDatabasesResponse() {
    }

    public ListDatabasesResponse dbs(List<Database> dbs) {
        this.dbs = dbs;
        return this;
    }

    public ListDatabasesResponse addDbsItem(Database dbsItem) {
        if (this.dbs == null) {
            this.dbs = new ArrayList<>();
        }
        this.dbs.add(dbsItem);
        return this;
    }

    /**
     * Get dbs
     *
     * @return dbs
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DBS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Database> getDbs() {
        return dbs;
    }

    @JsonProperty(JSON_PROPERTY_DBS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDbs(List<Database> dbs) {
        this.dbs = dbs;
    }

    /**
     * Return true if this list_databases_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListDatabasesResponse listDatabasesResponse = (ListDatabasesResponse) o;
        return Objects.equals(this.dbs, listDatabasesResponse.dbs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dbs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListDatabasesResponse {\n");
        sb.append("    dbs: ").append(toIndentedString(dbs)).append("\n");
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
