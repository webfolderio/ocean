package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListFloatingIpsResponseAllOf
 */
@JsonPropertyOrder({ ListFloatingIpsResponseAllOf.JSON_PROPERTY_FLOATING_IPS })
public class ListFloatingIpsResponseAllOf {
    public static final String JSON_PROPERTY_FLOATING_IPS = "floating_ips";
    private List<FloatingIp> floatingIps = null;

    public ListFloatingIpsResponseAllOf() {
    }

    public ListFloatingIpsResponseAllOf floatingIps(List<FloatingIp> floatingIps) {
        this.floatingIps = floatingIps;
        return this;
    }

    public ListFloatingIpsResponseAllOf addFloatingIpsItem(FloatingIp floatingIpsItem) {
        if (this.floatingIps == null) {
            this.floatingIps = new ArrayList<>();
        }
        this.floatingIps.add(floatingIpsItem);
        return this;
    }

    /**
     * Get floatingIps
     *
     * @return floatingIps
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FLOATING_IPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<FloatingIp> getFloatingIps() {
        return floatingIps;
    }

    @JsonProperty(JSON_PROPERTY_FLOATING_IPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFloatingIps(List<FloatingIp> floatingIps) {
        this.floatingIps = floatingIps;
    }

    /**
     * Return true if this list_floating_ips_response_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListFloatingIpsResponseAllOf listFloatingIpsResponseAllOf = (ListFloatingIpsResponseAllOf) o;
        return Objects.equals(this.floatingIps, listFloatingIpsResponseAllOf.floatingIps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(floatingIps);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListFloatingIpsResponseAllOf {\n");
        sb.append("    floatingIps: ").append(toIndentedString(floatingIps)).append("\n");
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
