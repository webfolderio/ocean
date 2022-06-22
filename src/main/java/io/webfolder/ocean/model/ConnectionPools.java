package io.webfolder.ocean.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ConnectionPools
 */
@JsonPropertyOrder({ ConnectionPools.JSON_PROPERTY_POOLS })
public class ConnectionPools {
    public static final String JSON_PROPERTY_POOLS = "pools";
    private List<ConnectionPool> pools = null;

    public ConnectionPools() {
    }

    @JsonCreator
    public ConnectionPools(@JsonProperty(JSON_PROPERTY_POOLS) List<ConnectionPool> pools) {
        this();
        this.pools = pools;
    }

    /**
     * An array of connection pool objects.
     *
     * @return pools
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_POOLS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<ConnectionPool> getPools() {
        return pools;
    }

    /**
     * Return true if this connection_pools object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ConnectionPools connectionPools = (ConnectionPools) o;
        return Objects.equals(this.pools, connectionPools.pools);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pools);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ConnectionPools {\n");
        sb.append("    pools: ").append(toIndentedString(pools)).append("\n");
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
