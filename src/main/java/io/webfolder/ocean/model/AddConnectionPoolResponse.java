package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AddConnectionPoolResponse
 */
@JsonPropertyOrder({ AddConnectionPoolResponse.JSON_PROPERTY_POOL })
public class AddConnectionPoolResponse {
    public static final String JSON_PROPERTY_POOL = "pool";
    private ConnectionPool pool;

    public AddConnectionPoolResponse() {
    }

    public AddConnectionPoolResponse pool(ConnectionPool pool) {
        this.pool = pool;
        return this;
    }

    /**
     * Get pool
     *
     * @return pool
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_POOL)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public ConnectionPool getPool() {
        return pool;
    }

    @JsonProperty(JSON_PROPERTY_POOL)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setPool(ConnectionPool pool) {
        this.pool = pool;
    }

    /**
     * Return true if this add_connection_pool_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AddConnectionPoolResponse addConnectionPoolResponse = (AddConnectionPoolResponse) o;
        return Objects.equals(this.pool, addConnectionPoolResponse.pool);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pool);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AddConnectionPoolResponse {\n");
        sb.append("    pool: ").append(toIndentedString(pool)).append("\n");
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