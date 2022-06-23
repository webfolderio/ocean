package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * FirewallRulesInboundRulesInnerAllOf
 */
@JsonPropertyOrder({ FirewallRulesInboundRulesInnerAllOf.JSON_PROPERTY_SOURCES })
public class FirewallRulesInboundRulesInnerAllOf {
    public static final String JSON_PROPERTY_SOURCES = "sources";
    private FirewallRulesInboundRulesInnerAllOfSources sources;

    public FirewallRulesInboundRulesInnerAllOf() {
    }

    public FirewallRulesInboundRulesInnerAllOf sources(FirewallRulesInboundRulesInnerAllOfSources sources) {
        this.sources = sources;
        return this;
    }

    /**
     * Get sources
     *
     * @return sources
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_SOURCES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public FirewallRulesInboundRulesInnerAllOfSources getSources() {
        return sources;
    }

    @JsonProperty(JSON_PROPERTY_SOURCES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSources(FirewallRulesInboundRulesInnerAllOfSources sources) {
        this.sources = sources;
    }

    /**
     * Return true if this firewall_rules_inbound_rules_inner_allOf object is equal
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
        FirewallRulesInboundRulesInnerAllOf firewallRulesInboundRulesInnerAllOf = (FirewallRulesInboundRulesInnerAllOf) o;
        return Objects.equals(this.sources, firewallRulesInboundRulesInnerAllOf.sources);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sources);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FirewallRulesInboundRulesInnerAllOf {\n");
        sb.append("    sources: ").append(toIndentedString(sources)).append("\n");
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