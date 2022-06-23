package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * CreateReservedIpResponse
 */
@JsonPropertyOrder({ CreateReservedIpResponse.JSON_PROPERTY_RESERVED_IP, CreateReservedIpResponse.JSON_PROPERTY_LINKS })
public class CreateReservedIpResponse {
    public static final String JSON_PROPERTY_RESERVED_IP = "reserved_ip";
    private ReservedIp reservedIp;

    public static final String JSON_PROPERTY_LINKS = "links";
    private CreateFloatingIpResponseLinks links;

    public CreateReservedIpResponse() {
    }

    public CreateReservedIpResponse reservedIp(ReservedIp reservedIp) {
        this.reservedIp = reservedIp;
        return this;
    }

    /**
     * Get reservedIp
     *
     * @return reservedIp
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_RESERVED_IP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public ReservedIp getReservedIp() {
        return reservedIp;
    }

    @JsonProperty(JSON_PROPERTY_RESERVED_IP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setReservedIp(ReservedIp reservedIp) {
        this.reservedIp = reservedIp;
    }

    public CreateReservedIpResponse links(CreateFloatingIpResponseLinks links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     *
     * @return links
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LINKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public CreateFloatingIpResponseLinks getLinks() {
        return links;
    }

    @JsonProperty(JSON_PROPERTY_LINKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLinks(CreateFloatingIpResponseLinks links) {
        this.links = links;
    }

    /**
     * Return true if this create_reserved_ip_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateReservedIpResponse createReservedIpResponse = (CreateReservedIpResponse) o;
        return Objects.equals(this.reservedIp, createReservedIpResponse.reservedIp)
                && Objects.equals(this.links, createReservedIpResponse.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservedIp, links);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateReservedIpResponse {\n");
        sb.append("    reservedIp: ").append(toIndentedString(reservedIp)).append("\n");
        sb.append("    links: ").append(toIndentedString(links)).append("\n");
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