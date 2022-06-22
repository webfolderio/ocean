package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListAllVolumesResponseAllOf
 */
@JsonPropertyOrder({ ListAllVolumesResponseAllOf.JSON_PROPERTY_VOLUMES })
public class ListAllVolumesResponseAllOf {
    public static final String JSON_PROPERTY_VOLUMES = "volumes";
    private List<VolumeFull> volumes = new ArrayList<>();

    public ListAllVolumesResponseAllOf() {
    }

    public ListAllVolumesResponseAllOf volumes(List<VolumeFull> volumes) {
        this.volumes = volumes;
        return this;
    }

    public ListAllVolumesResponseAllOf addVolumesItem(VolumeFull volumesItem) {
        this.volumes.add(volumesItem);
        return this;
    }

    /**
     * Array of volumes.
     *
     * @return volumes
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_VOLUMES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<VolumeFull> getVolumes() {
        return volumes;
    }

    @JsonProperty(JSON_PROPERTY_VOLUMES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setVolumes(List<VolumeFull> volumes) {
        this.volumes = volumes;
    }

    /**
     * Return true if this list_all_volumes_response_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListAllVolumesResponseAllOf listAllVolumesResponseAllOf = (ListAllVolumesResponseAllOf) o;
        return Objects.equals(this.volumes, listAllVolumesResponseAllOf.volumes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(volumes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListAllVolumesResponseAllOf {\n");
        sb.append("    volumes: ").append(toIndentedString(volumes)).append("\n");
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
