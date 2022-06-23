package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * NetworkV6
 */
@JsonPropertyOrder({ NetworkV6.JSON_PROPERTY_IP_ADDRESS, NetworkV6.JSON_PROPERTY_NETMASK,
        NetworkV6.JSON_PROPERTY_GATEWAY, NetworkV6.JSON_PROPERTY_TYPE })
public class NetworkV6 {
    public static final String JSON_PROPERTY_IP_ADDRESS = "ip_address";
    private String ipAddress;

    public static final String JSON_PROPERTY_NETMASK = "netmask";
    private Integer netmask;

    public static final String JSON_PROPERTY_GATEWAY = "gateway";
    private String gateway;

    /**
     * The type of the IPv6 network interface. **Note**: IPv6 private networking is
     * not currently supported.
     */
    public enum TypeEnum {
        PUBLIC("public");

        private String value;

        TypeEnum(String value) {
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
        public static TypeEnum fromValue(String value) {
            for (TypeEnum b : TypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_TYPE = "type";
    private TypeEnum type;

    public NetworkV6() {
    }

    public NetworkV6 ipAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    /**
     * The IP address of the IPv6 network interface.
     *
     * @return ipAddress
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_IP_ADDRESS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getIpAddress() {
        return ipAddress;
    }

    @JsonProperty(JSON_PROPERTY_IP_ADDRESS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public NetworkV6 netmask(Integer netmask) {
        this.netmask = netmask;
        return this;
    }

    /**
     * The netmask of the IPv6 network interface.
     *
     * @return netmask
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NETMASK)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Integer getNetmask() {
        return netmask;
    }

    @JsonProperty(JSON_PROPERTY_NETMASK)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setNetmask(Integer netmask) {
        this.netmask = netmask;
    }

    public NetworkV6 gateway(String gateway) {
        this.gateway = gateway;
        return this;
    }

    /**
     * The gateway of the specified IPv6 network interface.
     *
     * @return gateway
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_GATEWAY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getGateway() {
        return gateway;
    }

    @JsonProperty(JSON_PROPERTY_GATEWAY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public NetworkV6 type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * The type of the IPv6 network interface. **Note**: IPv6 private networking is
     * not currently supported.
     *
     * @return type
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public TypeEnum getType() {
        return type;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setType(TypeEnum type) {
        this.type = type;
    }

    /**
     * Return true if this network_v6 object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NetworkV6 networkV6 = (NetworkV6) o;
        return Objects.equals(this.ipAddress, networkV6.ipAddress) && Objects.equals(this.netmask, networkV6.netmask)
                && Objects.equals(this.gateway, networkV6.gateway) && Objects.equals(this.type, networkV6.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipAddress, netmask, gateway, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NetworkV6 {\n");
        sb.append("    ipAddress: ").append(toIndentedString(ipAddress)).append("\n");
        sb.append("    netmask: ").append(toIndentedString(netmask)).append("\n");
        sb.append("    gateway: ").append(toIndentedString(gateway)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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