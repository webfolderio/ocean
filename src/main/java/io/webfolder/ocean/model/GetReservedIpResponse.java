package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * GetReservedIpResponse
 */
@JsonPropertyOrder({ GetReservedIpResponse.JSON_PROPERTY_RESERVED_IP })
public class GetReservedIpResponse {
    public static final String JSON_PROPERTY_RESERVED_IP = "reserved_ip";
    private ReservedIp reservedIp;

    public GetReservedIpResponse() {
    }

    public GetReservedIpResponse reservedIp(ReservedIp reservedIp) {
        this.reservedIp = reservedIp;
        return this;
    }

    /**
     * Get reservedIp
     *
     * @return reservedIp
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_RESERVED_IP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ReservedIp getReservedIp() {
        return reservedIp;
    }

    @JsonProperty(JSON_PROPERTY_RESERVED_IP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setReservedIp(ReservedIp reservedIp) {
        this.reservedIp = reservedIp;
    }

    /**
     * Return true if this get_reserved_ip_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetReservedIpResponse getReservedIpResponse = (GetReservedIpResponse) o;
        return Objects.equals(this.reservedIp, getReservedIpResponse.reservedIp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservedIp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetReservedIpResponse {\n");
        sb.append("    reservedIp: ").append(toIndentedString(reservedIp)).append("\n");
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
