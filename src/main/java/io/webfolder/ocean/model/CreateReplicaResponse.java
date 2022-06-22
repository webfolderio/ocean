package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * CreateReplicaResponse
 */
@JsonPropertyOrder({ CreateReplicaResponse.JSON_PROPERTY_REPLICA })
public class CreateReplicaResponse {
    public static final String JSON_PROPERTY_REPLICA = "replica";
    private DatabaseReplica replica;

    public CreateReplicaResponse() {
    }

    public CreateReplicaResponse replica(DatabaseReplica replica) {
        this.replica = replica;
        return this;
    }

    /**
     * Get replica
     *
     * @return replica
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_REPLICA)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public DatabaseReplica getReplica() {
        return replica;
    }

    @JsonProperty(JSON_PROPERTY_REPLICA)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setReplica(DatabaseReplica replica) {
        this.replica = replica;
    }

    /**
     * Return true if this create_replica_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateReplicaResponse createReplicaResponse = (CreateReplicaResponse) o;
        return Objects.equals(this.replica, createReplicaResponse.replica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(replica);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateReplicaResponse {\n");
        sb.append("    replica: ").append(toIndentedString(replica)).append("\n");
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
