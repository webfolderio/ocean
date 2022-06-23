package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * FirewallRules
 */
@JsonPropertyOrder({ FirewallRules.JSON_PROPERTY_INBOUND_RULES, FirewallRules.JSON_PROPERTY_OUTBOUND_RULES })
public class FirewallRules {
    public static final String JSON_PROPERTY_INBOUND_RULES = "inbound_rules";
    private List<FirewallRulesInboundRulesInner> inboundRules = null;

    public static final String JSON_PROPERTY_OUTBOUND_RULES = "outbound_rules";
    private List<FirewallRulesOutboundRulesInner> outboundRules = null;

    public FirewallRules() {
    }

    public FirewallRules inboundRules(List<FirewallRulesInboundRulesInner> inboundRules) {
        this.inboundRules = inboundRules;
        return this;
    }

    public FirewallRules addInboundRulesItem(FirewallRulesInboundRulesInner inboundRulesItem) {
        if (this.inboundRules == null) {
            this.inboundRules = new ArrayList<>();
        }
        this.inboundRules.add(inboundRulesItem);
        return this;
    }

    /**
     * Get inboundRules
     *
     * @return inboundRules
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INBOUND_RULES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<FirewallRulesInboundRulesInner> getInboundRules() {
        return inboundRules;
    }

    @JsonProperty(JSON_PROPERTY_INBOUND_RULES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInboundRules(List<FirewallRulesInboundRulesInner> inboundRules) {
        this.inboundRules = inboundRules;
    }

    public FirewallRules outboundRules(List<FirewallRulesOutboundRulesInner> outboundRules) {
        this.outboundRules = outboundRules;
        return this;
    }

    public FirewallRules addOutboundRulesItem(FirewallRulesOutboundRulesInner outboundRulesItem) {
        if (this.outboundRules == null) {
            this.outboundRules = new ArrayList<>();
        }
        this.outboundRules.add(outboundRulesItem);
        return this;
    }

    /**
     * Get outboundRules
     *
     * @return outboundRules
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_OUTBOUND_RULES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<FirewallRulesOutboundRulesInner> getOutboundRules() {
        return outboundRules;
    }

    @JsonProperty(JSON_PROPERTY_OUTBOUND_RULES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setOutboundRules(List<FirewallRulesOutboundRulesInner> outboundRules) {
        this.outboundRules = outboundRules;
    }

    /**
     * Return true if this firewall_rules object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FirewallRules firewallRules = (FirewallRules) o;
        return Objects.equals(this.inboundRules, firewallRules.inboundRules)
                && Objects.equals(this.outboundRules, firewallRules.outboundRules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inboundRules, outboundRules);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FirewallRules {\n");
        sb.append("    inboundRules: ").append(toIndentedString(inboundRules)).append("\n");
        sb.append("    outboundRules: ").append(toIndentedString(outboundRules)).append("\n");
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