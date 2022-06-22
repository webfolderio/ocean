package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListReservedIpsResponseAllOf
 */
@JsonPropertyOrder({ ListReservedIpsResponseAllOf.JSON_PROPERTY_RESERVED_IPS })
public class ListReservedIpsResponseAllOf {
    public static final String JSON_PROPERTY_RESERVED_IPS = "reserved_ips";
    private List<ReservedIp> reservedIps = null;

    public ListReservedIpsResponseAllOf() {
    }

    public ListReservedIpsResponseAllOf reservedIps(List<ReservedIp> reservedIps) {
        this.reservedIps = reservedIps;
        return this;
    }

    public ListReservedIpsResponseAllOf addReservedIpsItem(ReservedIp reservedIpsItem) {
        if (this.reservedIps == null) {
            this.reservedIps = new ArrayList<>();
        }
        this.reservedIps.add(reservedIpsItem);
        return this;
    }

    /**
     * Get reservedIps
     *
     * @return reservedIps
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_RESERVED_IPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<ReservedIp> getReservedIps() {
        return reservedIps;
    }

    @JsonProperty(JSON_PROPERTY_RESERVED_IPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setReservedIps(List<ReservedIp> reservedIps) {
        this.reservedIps = reservedIps;
    }

    /**
     * Return true if this list_reserved_ips_response_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListReservedIpsResponseAllOf listReservedIpsResponseAllOf = (ListReservedIpsResponseAllOf) o;
        return Objects.equals(this.reservedIps, listReservedIpsResponseAllOf.reservedIps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservedIps);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListReservedIpsResponseAllOf {\n");
        sb.append("    reservedIps: ").append(toIndentedString(reservedIps)).append("\n");
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
