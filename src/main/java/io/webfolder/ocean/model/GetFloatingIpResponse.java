package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * GetFloatingIpResponse
 */
@JsonPropertyOrder({ GetFloatingIpResponse.JSON_PROPERTY_FLOATING_IP })
public class GetFloatingIpResponse {
    public static final String JSON_PROPERTY_FLOATING_IP = "floating_ip";
    private FloatingIp floatingIp;

    public GetFloatingIpResponse() {
    }

    public GetFloatingIpResponse floatingIp(FloatingIp floatingIp) {
        this.floatingIp = floatingIp;
        return this;
    }

    /**
     * Get floatingIp
     *
     * @return floatingIp
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_FLOATING_IP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public FloatingIp getFloatingIp() {
        return floatingIp;
    }

    @JsonProperty(JSON_PROPERTY_FLOATING_IP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFloatingIp(FloatingIp floatingIp) {
        this.floatingIp = floatingIp;
    }

    /**
     * Return true if this get_floating_ip_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetFloatingIpResponse getFloatingIpResponse = (GetFloatingIpResponse) o;
        return Objects.equals(this.floatingIp, getFloatingIpResponse.floatingIp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(floatingIp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetFloatingIpResponse {\n");
        sb.append("    floatingIp: ").append(toIndentedString(floatingIp)).append("\n");
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
