package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * DropletSnapshotAllOf
 */
@JsonPropertyOrder({ DropletSnapshotAllOf.JSON_PROPERTY_ID })
public class DropletSnapshotAllOf {
    public static final String JSON_PROPERTY_ID = "id";
    private Integer id;

    public DropletSnapshotAllOf() {
    }

    public DropletSnapshotAllOf id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * The unique identifier for the snapshot or backup.
     *
     * @return id
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Integer getId() {
        return id;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Return true if this droplet_snapshot_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DropletSnapshotAllOf dropletSnapshotAllOf = (DropletSnapshotAllOf) o;
        return Objects.equals(this.id, dropletSnapshotAllOf.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DropletSnapshotAllOf {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
