package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * UpdateDatabaseFirewallRequest
 */
@JsonPropertyOrder({ UpdateDatabaseFirewallRequest.JSON_PROPERTY_RULES })
public class UpdateDatabaseFirewallRequest {
    public static final String JSON_PROPERTY_RULES = "rules";
    private List<FirewallRule> rules = null;

    public UpdateDatabaseFirewallRequest() {
    }

    public UpdateDatabaseFirewallRequest rules(List<FirewallRule> rules) {
        this.rules = rules;
        return this;
    }

    public UpdateDatabaseFirewallRequest addRulesItem(FirewallRule rulesItem) {
        if (this.rules == null) {
            this.rules = new ArrayList<>();
        }
        this.rules.add(rulesItem);
        return this;
    }

    /**
     * Get rules
     *
     * @return rules
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_RULES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<FirewallRule> getRules() {
        return rules;
    }

    @JsonProperty(JSON_PROPERTY_RULES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRules(List<FirewallRule> rules) {
        this.rules = rules;
    }

    /**
     * Return true if this update_database_firewall_request object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdateDatabaseFirewallRequest updateDatabaseFirewallRequest = (UpdateDatabaseFirewallRequest) o;
        return Objects.equals(this.rules, updateDatabaseFirewallRequest.rules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rules);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateDatabaseFirewallRequest {\n");
        sb.append("    rules: ").append(toIndentedString(rules)).append("\n");
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
