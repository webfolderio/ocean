package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * CreateFirewallResponse
 */
@JsonPropertyOrder({ CreateFirewallResponse.JSON_PROPERTY_FIREWALL })
public class CreateFirewallResponse {
    public static final String JSON_PROPERTY_FIREWALL = "firewall";
    private Firewall firewall;

    public CreateFirewallResponse() {
    }

    public CreateFirewallResponse firewall(Firewall firewall) {
        this.firewall = firewall;
        return this;
    }

    /**
     * Get firewall
     *
     * @return firewall
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FIREWALL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Firewall getFirewall() {
        return firewall;
    }

    @JsonProperty(JSON_PROPERTY_FIREWALL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFirewall(Firewall firewall) {
        this.firewall = firewall;
    }

    /**
     * Return true if this create_firewall_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateFirewallResponse createFirewallResponse = (CreateFirewallResponse) o;
        return Objects.equals(this.firewall, createFirewallResponse.firewall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firewall);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateFirewallResponse {\n");
        sb.append("    firewall: ").append(toIndentedString(firewall)).append("\n");
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
