package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * AddLoadBalancerForwardingRulesRequest
 */
@JsonPropertyOrder({ AddLoadBalancerForwardingRulesRequest.JSON_PROPERTY_FORWARDING_RULES })
public class AddLoadBalancerForwardingRulesRequest {
    public static final String JSON_PROPERTY_FORWARDING_RULES = "forwarding_rules";
    private List<ForwardingRule> forwardingRules = new ArrayList<>();

    public AddLoadBalancerForwardingRulesRequest() {
    }

    public AddLoadBalancerForwardingRulesRequest forwardingRules(List<ForwardingRule> forwardingRules) {
        this.forwardingRules = forwardingRules;
        return this;
    }

    public AddLoadBalancerForwardingRulesRequest addForwardingRulesItem(ForwardingRule forwardingRulesItem) {
        this.forwardingRules.add(forwardingRulesItem);
        return this;
    }

    /**
     * Get forwardingRules
     *
     * @return forwardingRules
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_FORWARDING_RULES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<ForwardingRule> getForwardingRules() {
        return forwardingRules;
    }

    @JsonProperty(JSON_PROPERTY_FORWARDING_RULES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setForwardingRules(List<ForwardingRule> forwardingRules) {
        this.forwardingRules = forwardingRules;
    }

    /**
     * Return true if this add_load_balancer_forwarding_rules_request object is
     * equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AddLoadBalancerForwardingRulesRequest addLoadBalancerForwardingRulesRequest = (AddLoadBalancerForwardingRulesRequest) o;
        return Objects.equals(this.forwardingRules, addLoadBalancerForwardingRulesRequest.forwardingRules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(forwardingRules);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AddLoadBalancerForwardingRulesRequest {\n");
        sb.append("    forwardingRules: ").append(toIndentedString(forwardingRules)).append("\n");
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
