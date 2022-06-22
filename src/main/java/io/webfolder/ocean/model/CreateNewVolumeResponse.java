package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * CreateNewVolumeResponse
 */
@JsonPropertyOrder({ CreateNewVolumeResponse.JSON_PROPERTY_VOLUME })
public class CreateNewVolumeResponse {
    public static final String JSON_PROPERTY_VOLUME = "volume";
    private VolumeFull volume;

    public CreateNewVolumeResponse() {
    }

    public CreateNewVolumeResponse volume(VolumeFull volume) {
        this.volume = volume;
        return this;
    }

    /**
     * Get volume
     *
     * @return volume
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_VOLUME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public VolumeFull getVolume() {
        return volume;
    }

    @JsonProperty(JSON_PROPERTY_VOLUME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVolume(VolumeFull volume) {
        this.volume = volume;
    }

    /**
     * Return true if this create_new_volume_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateNewVolumeResponse createNewVolumeResponse = (CreateNewVolumeResponse) o;
        return Objects.equals(this.volume, createNewVolumeResponse.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(volume);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateNewVolumeResponse {\n");
        sb.append("    volume: ").append(toIndentedString(volume)).append("\n");
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
