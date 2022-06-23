package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListDropletFirewallsResponseAllOf
 */
@JsonPropertyOrder({ ListDropletFirewallsResponseAllOf.JSON_PROPERTY_FIREWALLS })
public class ListDropletFirewallsResponseAllOf {
    public static final String JSON_PROPERTY_FIREWALLS = "firewalls";
    private List<Firewall> firewalls = null;

    public ListDropletFirewallsResponseAllOf() {
    }

    public ListDropletFirewallsResponseAllOf firewalls(List<Firewall> firewalls) {
        this.firewalls = firewalls;
        return this;
    }

    public ListDropletFirewallsResponseAllOf addFirewallsItem(Firewall firewallsItem) {
        if (this.firewalls == null) {
            this.firewalls = new ArrayList<>();
        }
        this.firewalls.add(firewallsItem);
        return this;
    }

    /**
     * Get firewalls
     *
     * @return firewalls
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FIREWALLS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<Firewall> getFirewalls() {
        return firewalls;
    }

    @JsonProperty(JSON_PROPERTY_FIREWALLS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFirewalls(List<Firewall> firewalls) {
        this.firewalls = firewalls;
    }

    /**
     * Return true if this list_droplet_firewalls_response_allOf object is equal to
     * o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListDropletFirewallsResponseAllOf listDropletFirewallsResponseAllOf = (ListDropletFirewallsResponseAllOf) o;
        return Objects.equals(this.firewalls, listDropletFirewallsResponseAllOf.firewalls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firewalls);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListDropletFirewallsResponseAllOf {\n");
        sb.append("    firewalls: ").append(toIndentedString(firewalls)).append("\n");
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