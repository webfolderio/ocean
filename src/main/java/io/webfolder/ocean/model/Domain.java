package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * Domain
 */
@JsonPropertyOrder({ Domain.JSON_PROPERTY_NAME, Domain.JSON_PROPERTY_IP_ADDRESS, Domain.JSON_PROPERTY_TTL,
        Domain.JSON_PROPERTY_ZONE_FILE })
public class Domain {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_IP_ADDRESS = "ip_address";
    private String ipAddress;

    public static final String JSON_PROPERTY_TTL = "ttl";
    private Integer ttl;

    public static final String JSON_PROPERTY_ZONE_FILE = "zone_file";
    private String zoneFile;

    public Domain() {
    }

    @JsonCreator
    public Domain(@JsonProperty(JSON_PROPERTY_TTL) Integer ttl,
            @JsonProperty(JSON_PROPERTY_ZONE_FILE) String zoneFile) {
        this();
        this.ttl = ttl;
        this.zoneFile = zoneFile;
    }

    public Domain name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the domain itself. This should follow the standard domain format
     * of domain.TLD. For instance, &#x60;example.com&#x60; is a valid domain name.
     *
     * @return name
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "example.com", value = "The name of the domain itself. This should follow the standard domain format of domain.TLD. For instance, `example.com` is a valid domain name.")
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setName(String name) {
        this.name = name;
    }

    public Domain ipAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    /**
     * This optional attribute may contain an IP address. When provided, an A record
     * will be automatically created pointing to the apex domain.
     *
     * @return ipAddress
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "192.0.2.1", value = "This optional attribute may contain an IP address. When provided, an A record will be automatically created pointing to the apex domain.")
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

    /**
     * This value is the time to live for the records on this domain, in seconds.
     * This defines the time frame that clients can cache queried information before
     * a refresh should be requested.
     *
     * @return ttl
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "1800", value = "This value is the time to live for the records on this domain, in seconds. This defines the time frame that clients can cache queried information before a refresh should be requested.")
    @JsonProperty(JSON_PROPERTY_TTL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getTtl() {
        return ttl;
    }

    /**
     * This attribute contains the complete contents of the zone file for the
     * selected domain. Individual domain record resources should be used to get
     * more granular control over records. However, this attribute can also be used
     * to get information about the SOA record, which is created automatically and
     * is not accessible as an individual record resource.
     *
     * @return zoneFile
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "$ORIGIN example.com. $TTL 1800 example.com. IN SOA ns1.digitalocean.com. hostmaster.example.com. 1415982609 10800 3600 604800 1800 example.com. 1800 IN NS ns1.digitalocean.com. example.com. 1800 IN NS ns2.digitalocean.com. example.com. 1800 IN NS ns3.digitalocean.com. example.com. 1800 IN A 1.2.3.4 ", value = "This attribute contains the complete contents of the zone file for the selected domain. Individual domain record resources should be used to get more granular control over records. However, this attribute can also be used to get information about the SOA record, which is created automatically and is not accessible as an individual record resource.")
    @JsonProperty(JSON_PROPERTY_ZONE_FILE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getZoneFile() {
        return zoneFile;
    }

    /**
     * Return true if this domain object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Domain domain = (Domain) o;
        return Objects.equals(this.name, domain.name) && Objects.equals(this.ipAddress, domain.ipAddress)
                && Objects.equals(this.ttl, domain.ttl) && Objects.equals(this.zoneFile, domain.zoneFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ipAddress, ttl, zoneFile);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Domain {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    ipAddress: ").append(toIndentedString(ipAddress)).append("\n");
        sb.append("    ttl: ").append(toIndentedString(ttl)).append("\n");
        sb.append("    zoneFile: ").append(toIndentedString(zoneFile)).append("\n");
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
