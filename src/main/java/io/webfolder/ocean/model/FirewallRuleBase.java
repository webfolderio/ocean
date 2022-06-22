package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * FirewallRuleBase
 */
@JsonPropertyOrder({ FirewallRuleBase.JSON_PROPERTY_PROTOCOL, FirewallRuleBase.JSON_PROPERTY_PORTS })
public class FirewallRuleBase {
    /**
     * The type of traffic to be allowed. This may be one of &#x60;tcp&#x60;,
     * &#x60;udp&#x60;, or &#x60;icmp&#x60;.
     */
    public enum ProtocolEnum {
        TCP("tcp"),

        UDP("udp"),

        ICMP("icmp");

        private String value;

        ProtocolEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static ProtocolEnum fromValue(String value) {
            for (ProtocolEnum b : ProtocolEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_PROTOCOL = "protocol";
    private ProtocolEnum protocol;

    public static final String JSON_PROPERTY_PORTS = "ports";
    private String ports;

    public FirewallRuleBase() {
    }

    public FirewallRuleBase protocol(ProtocolEnum protocol) {
        this.protocol = protocol;
        return this;
    }

    /**
     * The type of traffic to be allowed. This may be one of &#x60;tcp&#x60;,
     * &#x60;udp&#x60;, or &#x60;icmp&#x60;.
     *
     * @return protocol
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_PROTOCOL)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public ProtocolEnum getProtocol() {
        return protocol;
    }

    @JsonProperty(JSON_PROPERTY_PROTOCOL)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setProtocol(ProtocolEnum protocol) {
        this.protocol = protocol;
    }

    public FirewallRuleBase ports(String ports) {
        this.ports = ports;
        return this;
    }

    /**
     * The ports on which traffic will be allowed specified as a string containing a
     * single port, a range (e.g. \&quot;8000-9000\&quot;), or \&quot;0\&quot; when
     * all ports are open for a protocol. For ICMP rules this parameter will always
     * return \&quot;0\&quot;.
     *
     * @return ports
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_PORTS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getPorts() {
        return ports;
    }

    @JsonProperty(JSON_PROPERTY_PORTS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setPorts(String ports) {
        this.ports = ports;
    }

    /**
     * Return true if this firewall_rule_base object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FirewallRuleBase firewallRuleBase = (FirewallRuleBase) o;
        return Objects.equals(this.protocol, firewallRuleBase.protocol)
                && Objects.equals(this.ports, firewallRuleBase.ports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(protocol, ports);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FirewallRuleBase {\n");
        sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
        sb.append("    ports: ").append(toIndentedString(ports)).append("\n");
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
