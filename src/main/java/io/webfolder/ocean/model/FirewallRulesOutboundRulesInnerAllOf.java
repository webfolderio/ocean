package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * FirewallRulesOutboundRulesInnerAllOf
 */
@JsonPropertyOrder({ FirewallRulesOutboundRulesInnerAllOf.JSON_PROPERTY_DESTINATIONS })
public class FirewallRulesOutboundRulesInnerAllOf {
    public static final String JSON_PROPERTY_DESTINATIONS = "destinations";
    private FirewallRulesOutboundRulesInnerAllOfDestinations destinations;

    public FirewallRulesOutboundRulesInnerAllOf() {
    }

    public FirewallRulesOutboundRulesInnerAllOf destinations(
            FirewallRulesOutboundRulesInnerAllOfDestinations destinations) {
        this.destinations = destinations;
        return this;
    }

    /**
     * Get destinations
     *
     * @return destinations
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DESTINATIONS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public FirewallRulesOutboundRulesInnerAllOfDestinations getDestinations() {
        return destinations;
    }

    @JsonProperty(JSON_PROPERTY_DESTINATIONS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDestinations(FirewallRulesOutboundRulesInnerAllOfDestinations destinations) {
        this.destinations = destinations;
    }

    /**
     * Return true if this firewall_rules_outbound_rules_inner_allOf object is equal
     * to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FirewallRulesOutboundRulesInnerAllOf firewallRulesOutboundRulesInnerAllOf = (FirewallRulesOutboundRulesInnerAllOf) o;
        return Objects.equals(this.destinations, firewallRulesOutboundRulesInnerAllOf.destinations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinations);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FirewallRulesOutboundRulesInnerAllOf {\n");
        sb.append("    destinations: ").append(toIndentedString(destinations)).append("\n");
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