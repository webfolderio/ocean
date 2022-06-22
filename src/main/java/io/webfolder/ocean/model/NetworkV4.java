package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * NetworkV4
 */
@JsonPropertyOrder({ NetworkV4.JSON_PROPERTY_IP_ADDRESS, NetworkV4.JSON_PROPERTY_NETMASK,
        NetworkV4.JSON_PROPERTY_GATEWAY, NetworkV4.JSON_PROPERTY_TYPE })
public class NetworkV4 {
    public static final String JSON_PROPERTY_IP_ADDRESS = "ip_address";
    private String ipAddress;

    public static final String JSON_PROPERTY_NETMASK = "netmask";
    private String netmask;

    public static final String JSON_PROPERTY_GATEWAY = "gateway";
    private String gateway;

    /**
     * The type of the IPv4 network interface.
     */
    public enum TypeEnum {
        PUBLIC("public"),

        PRIVATE("private");

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

    public NetworkV4() {
    }

    public NetworkV4 ipAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    /**
     * The IP address of the IPv4 network interface.
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

    public NetworkV4 netmask(String netmask) {
        this.netmask = netmask;
        return this;
    }

    /**
     * The netmask of the IPv4 network interface.
     *
     * @return netmask
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NETMASK)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getNetmask() {
        return netmask;
    }

    @JsonProperty(JSON_PROPERTY_NETMASK)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setNetmask(String netmask) {
        this.netmask = netmask;
    }

    public NetworkV4 gateway(String gateway) {
        this.gateway = gateway;
        return this;
    }

    /**
     * The gateway of the specified IPv4 network interface. For private interfaces,
     * a gateway is not provided. This is denoted by returning &#x60;nil&#x60; as
     * its value.
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

    public NetworkV4 type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * The type of the IPv4 network interface.
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
     * Return true if this network_v4 object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NetworkV4 networkV4 = (NetworkV4) o;
        return Objects.equals(this.ipAddress, networkV4.ipAddress) && Objects.equals(this.netmask, networkV4.netmask)
                && Objects.equals(this.gateway, networkV4.gateway) && Objects.equals(this.type, networkV4.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipAddress, netmask, gateway, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NetworkV4 {\n");
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
