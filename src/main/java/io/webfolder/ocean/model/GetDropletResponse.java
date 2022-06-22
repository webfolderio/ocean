package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * GetDropletResponse
 */
@JsonPropertyOrder({ GetDropletResponse.JSON_PROPERTY_DROPLET })
public class GetDropletResponse {
    public static final String JSON_PROPERTY_DROPLET = "droplet";
    private Droplet droplet;

    public GetDropletResponse() {
    }

    public GetDropletResponse droplet(Droplet droplet) {
        this.droplet = droplet;
        return this;
    }

    /**
     * Get droplet
     *
     * @return droplet
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_DROPLET)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Droplet getDroplet() {
        return droplet;
    }

    @JsonProperty(JSON_PROPERTY_DROPLET)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDroplet(Droplet droplet) {
        this.droplet = droplet;
    }

    /**
     * Return true if this get_droplet_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetDropletResponse getDropletResponse = (GetDropletResponse) o;
        return Objects.equals(this.droplet, getDropletResponse.droplet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(droplet);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetDropletResponse {\n");
        sb.append("    droplet: ").append(toIndentedString(droplet)).append("\n");
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
