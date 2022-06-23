package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * UpdateDatabaseClusterRequest
 */
@JsonPropertyOrder({ UpdateDatabaseClusterRequest.JSON_PROPERTY_REGION })
public class UpdateDatabaseClusterRequest {
    public static final String JSON_PROPERTY_REGION = "region";
    private String region;

    public UpdateDatabaseClusterRequest() {
    }

    public UpdateDatabaseClusterRequest region(String region) {
        this.region = region;
        return this;
    }

    /**
     * A slug identifier for the region to which the database cluster will be
     * migrated.
     *
     * @return region
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getRegion() {
        return region;
    }

    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Return true if this update_database_cluster_request object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdateDatabaseClusterRequest updateDatabaseClusterRequest = (UpdateDatabaseClusterRequest) o;
        return Objects.equals(this.region, updateDatabaseClusterRequest.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(region);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateDatabaseClusterRequest {\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
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