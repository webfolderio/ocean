package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * An object specifying a forwarding rule for a load balancer.
 */
@JsonPropertyOrder({ ForwardingRule.JSON_PROPERTY_ENTRY_PROTOCOL, ForwardingRule.JSON_PROPERTY_ENTRY_PORT,
        ForwardingRule.JSON_PROPERTY_TARGET_PROTOCOL, ForwardingRule.JSON_PROPERTY_TARGET_PORT,
        ForwardingRule.JSON_PROPERTY_CERTIFICATE_ID, ForwardingRule.JSON_PROPERTY_TLS_PASSTHROUGH })
public class ForwardingRule {
    /**
     * The protocol used for traffic to the load balancer. The possible values are:
     * &#x60;http&#x60;, &#x60;https&#x60;, &#x60;http2&#x60;, or &#x60;tcp&#x60;.
     */
    public enum EntryProtocolEnum {
        HTTP("http"),

        HTTPS("https"),

        HTTP2("http2"),

        TCP("tcp");

        private String value;

        EntryProtocolEnum(String value) {
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
        public static EntryProtocolEnum fromValue(String value) {
            for (EntryProtocolEnum b : EntryProtocolEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_ENTRY_PROTOCOL = "entry_protocol";
    private EntryProtocolEnum entryProtocol;

    public static final String JSON_PROPERTY_ENTRY_PORT = "entry_port";
    private Integer entryPort;

    /**
     * The protocol used for traffic from the load balancer to the backend Droplets.
     * The possible values are: &#x60;http&#x60;, &#x60;https&#x60;,
     * &#x60;http2&#x60;, or &#x60;tcp&#x60;.
     */
    public enum TargetProtocolEnum {
        HTTP("http"),

        HTTPS("https"),

        HTTP2("http2"),

        TCP("tcp");

        private String value;

        TargetProtocolEnum(String value) {
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
        public static TargetProtocolEnum fromValue(String value) {
            for (TargetProtocolEnum b : TargetProtocolEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_TARGET_PROTOCOL = "target_protocol";
    private TargetProtocolEnum targetProtocol;

    public static final String JSON_PROPERTY_TARGET_PORT = "target_port";
    private Integer targetPort;

    public static final String JSON_PROPERTY_CERTIFICATE_ID = "certificate_id";
    private String certificateId;

    public static final String JSON_PROPERTY_TLS_PASSTHROUGH = "tls_passthrough";
    private Boolean tlsPassthrough;

    public ForwardingRule() {
    }

    public ForwardingRule entryProtocol(EntryProtocolEnum entryProtocol) {
        this.entryProtocol = entryProtocol;
        return this;
    }

    /**
     * The protocol used for traffic to the load balancer. The possible values are:
     * &#x60;http&#x60;, &#x60;https&#x60;, &#x60;http2&#x60;, or &#x60;tcp&#x60;.
     *
     * @return entryProtocol
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ENTRY_PROTOCOL)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public EntryProtocolEnum getEntryProtocol() {
        return entryProtocol;
    }

    @JsonProperty(JSON_PROPERTY_ENTRY_PROTOCOL)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setEntryProtocol(EntryProtocolEnum entryProtocol) {
        this.entryProtocol = entryProtocol;
    }

    public ForwardingRule entryPort(Integer entryPort) {
        this.entryPort = entryPort;
        return this;
    }

    /**
     * An integer representing the port on which the load balancer instance will
     * listen.
     *
     * @return entryPort
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ENTRY_PORT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Integer getEntryPort() {
        return entryPort;
    }

    @JsonProperty(JSON_PROPERTY_ENTRY_PORT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setEntryPort(Integer entryPort) {
        this.entryPort = entryPort;
    }

    public ForwardingRule targetProtocol(TargetProtocolEnum targetProtocol) {
        this.targetProtocol = targetProtocol;
        return this;
    }

    /**
     * The protocol used for traffic from the load balancer to the backend Droplets.
     * The possible values are: &#x60;http&#x60;, &#x60;https&#x60;,
     * &#x60;http2&#x60;, or &#x60;tcp&#x60;.
     *
     * @return targetProtocol
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_TARGET_PROTOCOL)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public TargetProtocolEnum getTargetProtocol() {
        return targetProtocol;
    }

    @JsonProperty(JSON_PROPERTY_TARGET_PROTOCOL)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setTargetProtocol(TargetProtocolEnum targetProtocol) {
        this.targetProtocol = targetProtocol;
    }

    public ForwardingRule targetPort(Integer targetPort) {
        this.targetPort = targetPort;
        return this;
    }

    /**
     * An integer representing the port on the backend Droplets to which the load
     * balancer will send traffic.
     *
     * @return targetPort
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_TARGET_PORT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Integer getTargetPort() {
        return targetPort;
    }

    @JsonProperty(JSON_PROPERTY_TARGET_PORT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setTargetPort(Integer targetPort) {
        this.targetPort = targetPort;
    }

    public ForwardingRule certificateId(String certificateId) {
        this.certificateId = certificateId;
        return this;
    }

    /**
     * The ID of the TLS certificate used for SSL termination if enabled.
     *
     * @return certificateId
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CERTIFICATE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getCertificateId() {
        return certificateId;
    }

    @JsonProperty(JSON_PROPERTY_CERTIFICATE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public ForwardingRule tlsPassthrough(Boolean tlsPassthrough) {
        this.tlsPassthrough = tlsPassthrough;
        return this;
    }

    /**
     * A boolean value indicating whether SSL encrypted traffic will be passed
     * through to the backend Droplets.
     *
     * @return tlsPassthrough
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TLS_PASSTHROUGH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Boolean getTlsPassthrough() {
        return tlsPassthrough;
    }

    @JsonProperty(JSON_PROPERTY_TLS_PASSTHROUGH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTlsPassthrough(Boolean tlsPassthrough) {
        this.tlsPassthrough = tlsPassthrough;
    }

    /**
     * Return true if this forwarding_rule object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ForwardingRule forwardingRule = (ForwardingRule) o;
        return Objects.equals(this.entryProtocol, forwardingRule.entryProtocol)
                && Objects.equals(this.entryPort, forwardingRule.entryPort)
                && Objects.equals(this.targetProtocol, forwardingRule.targetProtocol)
                && Objects.equals(this.targetPort, forwardingRule.targetPort)
                && Objects.equals(this.certificateId, forwardingRule.certificateId)
                && Objects.equals(this.tlsPassthrough, forwardingRule.tlsPassthrough);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entryProtocol, entryPort, targetProtocol, targetPort, certificateId, tlsPassthrough);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ForwardingRule {\n");
        sb.append("    entryProtocol: ").append(toIndentedString(entryProtocol)).append("\n");
        sb.append("    entryPort: ").append(toIndentedString(entryPort)).append("\n");
        sb.append("    targetProtocol: ").append(toIndentedString(targetProtocol)).append("\n");
        sb.append("    targetPort: ").append(toIndentedString(targetPort)).append("\n");
        sb.append("    certificateId: ").append(toIndentedString(certificateId)).append("\n");
        sb.append("    tlsPassthrough: ").append(toIndentedString(tlsPassthrough)).append("\n");
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