package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * DatabaseClusterResize
 */
@JsonPropertyOrder({ DatabaseClusterResize.JSON_PROPERTY_SIZE, DatabaseClusterResize.JSON_PROPERTY_NUM_NODES })
public class DatabaseClusterResize {
    public static final String JSON_PROPERTY_SIZE = "size";
    private String size;

    public static final String JSON_PROPERTY_NUM_NODES = "num_nodes";
    private Integer numNodes;

    public DatabaseClusterResize() {
    }

    public DatabaseClusterResize size(String size) {
        this.size = size;
        return this;
    }

    /**
     * A slug identifier representing desired the size of the nodes in the database
     * cluster.
     *
     * @return size
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_SIZE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getSize() {
        return size;
    }

    @JsonProperty(JSON_PROPERTY_SIZE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSize(String size) {
        this.size = size;
    }

    public DatabaseClusterResize numNodes(Integer numNodes) {
        this.numNodes = numNodes;
        return this;
    }

    /**
     * The number of nodes in the database cluster. Valid values are are 1-3. In
     * addition to the primary node, up to two standby nodes may be added for highly
     * available configurations.
     *
     * @return numNodes
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_NUM_NODES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Integer getNumNodes() {
        return numNodes;
    }

    @JsonProperty(JSON_PROPERTY_NUM_NODES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setNumNodes(Integer numNodes) {
        this.numNodes = numNodes;
    }

    /**
     * Return true if this database_cluster_resize object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DatabaseClusterResize databaseClusterResize = (DatabaseClusterResize) o;
        return Objects.equals(this.size, databaseClusterResize.size)
                && Objects.equals(this.numNodes, databaseClusterResize.numNodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, numNodes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DatabaseClusterResize {\n");
        sb.append("    size: ").append(toIndentedString(size)).append("\n");
        sb.append("    numNodes: ").append(toIndentedString(numNodes)).append("\n");
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