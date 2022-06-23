package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The details of the network that are configured for the Droplet instance. This
 * is an object that contains keys for IPv4 and IPv6. The value of each of these
 * is an array that contains objects describing an individual IP resource
 * allocated to the Droplet. These will define attributes like the IP address,
 * netmask, and gateway of the specific network depending on the type of network
 * it is.
 */
@JsonPropertyOrder({ DropletNetworks.JSON_PROPERTY_V4, DropletNetworks.JSON_PROPERTY_V6 })
public class DropletNetworks {
    public static final String JSON_PROPERTY_V4 = "v4";
    private List<NetworkV4> v4 = null;

    public static final String JSON_PROPERTY_V6 = "v6";
    private List<NetworkV6> v6 = null;

    public DropletNetworks() {
    }

    public DropletNetworks v4(List<NetworkV4> v4) {
        this.v4 = v4;
        return this;
    }

    public DropletNetworks addV4Item(NetworkV4 v4Item) {
        if (this.v4 == null) {
            this.v4 = new ArrayList<>();
        }
        this.v4.add(v4Item);
        return this;
    }

    /**
     * Get v4
     *
     * @return v4
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_V4)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<NetworkV4> getV4() {
        return v4;
    }

    @JsonProperty(JSON_PROPERTY_V4)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setV4(List<NetworkV4> v4) {
        this.v4 = v4;
    }

    public DropletNetworks v6(List<NetworkV6> v6) {
        this.v6 = v6;
        return this;
    }

    public DropletNetworks addV6Item(NetworkV6 v6Item) {
        if (this.v6 == null) {
            this.v6 = new ArrayList<>();
        }
        this.v6.add(v6Item);
        return this;
    }

    /**
     * Get v6
     *
     * @return v6
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_V6)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<NetworkV6> getV6() {
        return v6;
    }

    @JsonProperty(JSON_PROPERTY_V6)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setV6(List<NetworkV6> v6) {
        this.v6 = v6;
    }

    /**
     * Return true if this droplet_networks object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DropletNetworks dropletNetworks = (DropletNetworks) o;
        return Objects.equals(this.v4, dropletNetworks.v4) && Objects.equals(this.v6, dropletNetworks.v6);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v4, v6);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DropletNetworks {\n");
        sb.append("    v4: ").append(toIndentedString(v4)).append("\n");
        sb.append("    v6: ").append(toIndentedString(v6)).append("\n");
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