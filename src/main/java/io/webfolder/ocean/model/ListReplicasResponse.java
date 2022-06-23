package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListReplicasResponse
 */
@JsonPropertyOrder({ ListReplicasResponse.JSON_PROPERTY_REPLICAS })
public class ListReplicasResponse {
    public static final String JSON_PROPERTY_REPLICAS = "replicas";
    private List<DatabaseReplica> replicas = null;

    public ListReplicasResponse() {
    }

    public ListReplicasResponse replicas(List<DatabaseReplica> replicas) {
        this.replicas = replicas;
        return this;
    }

    public ListReplicasResponse addReplicasItem(DatabaseReplica replicasItem) {
        if (this.replicas == null) {
            this.replicas = new ArrayList<>();
        }
        this.replicas.add(replicasItem);
        return this;
    }

    /**
     * Get replicas
     *
     * @return replicas
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REPLICAS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<DatabaseReplica> getReplicas() {
        return replicas;
    }

    @JsonProperty(JSON_PROPERTY_REPLICAS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setReplicas(List<DatabaseReplica> replicas) {
        this.replicas = replicas;
    }

    /**
     * Return true if this list_replicas_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListReplicasResponse listReplicasResponse = (ListReplicasResponse) o;
        return Objects.equals(this.replicas, listReplicasResponse.replicas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(replicas);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListReplicasResponse {\n");
        sb.append("    replicas: ").append(toIndentedString(replicas)).append("\n");
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