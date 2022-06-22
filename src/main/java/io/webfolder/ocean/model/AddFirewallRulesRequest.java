package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AddFirewallRulesRequest
 */
@JsonPropertyOrder({ AddFirewallRulesRequest.JSON_PROPERTY_INBOUND_RULES,
        AddFirewallRulesRequest.JSON_PROPERTY_OUTBOUND_RULES })
public class AddFirewallRulesRequest {
    public static final String JSON_PROPERTY_INBOUND_RULES = "inbound_rules";
    private List<FirewallRulesInboundRulesInner> inboundRules = new ArrayList<>();

    public static final String JSON_PROPERTY_OUTBOUND_RULES = "outbound_rules";
    private List<FirewallRulesOutboundRulesInner> outboundRules = new ArrayList<>();

    public AddFirewallRulesRequest() {
    }

    public AddFirewallRulesRequest inboundRules(List<FirewallRulesInboundRulesInner> inboundRules) {
        this.inboundRules = inboundRules;
        return this;
    }

    public AddFirewallRulesRequest addInboundRulesItem(FirewallRulesInboundRulesInner inboundRulesItem) {
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
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<FirewallRulesInboundRulesInner> getInboundRules() {
        return inboundRules;
    }

    @JsonProperty(JSON_PROPERTY_INBOUND_RULES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setInboundRules(List<FirewallRulesInboundRulesInner> inboundRules) {
        this.inboundRules = inboundRules;
    }

    public AddFirewallRulesRequest outboundRules(List<FirewallRulesOutboundRulesInner> outboundRules) {
        this.outboundRules = outboundRules;
        return this;
    }

    public AddFirewallRulesRequest addOutboundRulesItem(FirewallRulesOutboundRulesInner outboundRulesItem) {
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
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<FirewallRulesOutboundRulesInner> getOutboundRules() {
        return outboundRules;
    }

    @JsonProperty(JSON_PROPERTY_OUTBOUND_RULES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setOutboundRules(List<FirewallRulesOutboundRulesInner> outboundRules) {
        this.outboundRules = outboundRules;
    }

    /**
     * Return true if this add_firewall_rules_request object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AddFirewallRulesRequest addFirewallRulesRequest = (AddFirewallRulesRequest) o;
        return Objects.equals(this.inboundRules, addFirewallRulesRequest.inboundRules)
                && Objects.equals(this.outboundRules, addFirewallRulesRequest.outboundRules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inboundRules, outboundRules);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AddFirewallRulesRequest {\n");
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
