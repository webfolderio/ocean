package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * LoadBalancerBase
 */
@JsonPropertyOrder({ LoadBalancerBase.JSON_PROPERTY_ID, LoadBalancerBase.JSON_PROPERTY_NAME,
        LoadBalancerBase.JSON_PROPERTY_IP, LoadBalancerBase.JSON_PROPERTY_SIZE_UNIT,
        LoadBalancerBase.JSON_PROPERTY_SIZE, LoadBalancerBase.JSON_PROPERTY_ALGORITHM,
        LoadBalancerBase.JSON_PROPERTY_STATUS, LoadBalancerBase.JSON_PROPERTY_CREATED_AT,
        LoadBalancerBase.JSON_PROPERTY_FORWARDING_RULES, LoadBalancerBase.JSON_PROPERTY_HEALTH_CHECK,
        LoadBalancerBase.JSON_PROPERTY_STICKY_SESSIONS, LoadBalancerBase.JSON_PROPERTY_REDIRECT_HTTP_TO_HTTPS,
        LoadBalancerBase.JSON_PROPERTY_ENABLE_PROXY_PROTOCOL, LoadBalancerBase.JSON_PROPERTY_ENABLE_BACKEND_KEEPALIVE,
        LoadBalancerBase.JSON_PROPERTY_VPC_UUID, LoadBalancerBase.JSON_PROPERTY_DISABLE_LETS_ENCRYPT_DNS_RECORDS })
public class LoadBalancerBase {
    public static final String JSON_PROPERTY_ID = "id";
    private UUID id;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_IP = "ip";
    private String ip;

    public static final String JSON_PROPERTY_SIZE_UNIT = "size_unit";
    private Integer sizeUnit = 1;

    /**
     * This field has been replaced by the &#x60;size_unit&#x60; field for all
     * regions except in AMS2, NYC2, and SFO1. Each available load balancer size now
     * equates to the load balancer having a set number of nodes. *
     * &#x60;lb-small&#x60; &#x3D; 1 node * &#x60;lb-medium&#x60; &#x3D; 3 nodes *
     * &#x60;lb-large&#x60; &#x3D; 6 nodes You can resize load balancers after
     * creation up to once per hour. You cannot resize a load balancer within the
     * first hour of its creation.
     */
    public enum SizeEnum {
        SMALL("lb-small"),

        MEDIUM("lb-medium"),

        LARGE("lb-large");

        private String value;

        SizeEnum(String value) {
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
        public static SizeEnum fromValue(String value) {
            for (SizeEnum b : SizeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_SIZE = "size";
    private SizeEnum size = SizeEnum.SMALL;

    /**
     * This field has been deprecated. You can no longer specify an algorithm for
     * load balancers.
     */
    public enum AlgorithmEnum {
        ROUND_ROBIN("round_robin"),

        LEAST_CONNECTIONS("least_connections");

        private String value;

        AlgorithmEnum(String value) {
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
        public static AlgorithmEnum fromValue(String value) {
            for (AlgorithmEnum b : AlgorithmEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_ALGORITHM = "algorithm";
    private AlgorithmEnum algorithm = AlgorithmEnum.ROUND_ROBIN;

    /**
     * A status string indicating the current state of the load balancer. This can
     * be &#x60;new&#x60;, &#x60;active&#x60;, or &#x60;errored&#x60;.
     */
    public enum StatusEnum {
        NEW("new"),

        ACTIVE("active"),

        ERRORED("errored");

        private String value;

        StatusEnum(String value) {
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
        public static StatusEnum fromValue(String value) {
            for (StatusEnum b : StatusEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_STATUS = "status";
    private StatusEnum status;

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    private OffsetDateTime createdAt;

    public static final String JSON_PROPERTY_FORWARDING_RULES = "forwarding_rules";
    private List<ForwardingRule> forwardingRules = new ArrayList<>();

    public static final String JSON_PROPERTY_HEALTH_CHECK = "health_check";
    private HealthCheck healthCheck;

    public static final String JSON_PROPERTY_STICKY_SESSIONS = "sticky_sessions";
    private StickySessions stickySessions;

    public static final String JSON_PROPERTY_REDIRECT_HTTP_TO_HTTPS = "redirect_http_to_https";
    private Boolean redirectHttpToHttps = false;

    public static final String JSON_PROPERTY_ENABLE_PROXY_PROTOCOL = "enable_proxy_protocol";
    private Boolean enableProxyProtocol = false;

    public static final String JSON_PROPERTY_ENABLE_BACKEND_KEEPALIVE = "enable_backend_keepalive";
    private Boolean enableBackendKeepalive = false;

    public static final String JSON_PROPERTY_VPC_UUID = "vpc_uuid";
    private UUID vpcUuid;

    public static final String JSON_PROPERTY_DISABLE_LETS_ENCRYPT_DNS_RECORDS = "disable_lets_encrypt_dns_records";
    private Boolean disableLetsEncryptDnsRecords = false;

    public LoadBalancerBase() {
    }

    @JsonCreator
    public LoadBalancerBase(@JsonProperty(JSON_PROPERTY_ID) UUID id, @JsonProperty(JSON_PROPERTY_IP) String ip,
            @JsonProperty(JSON_PROPERTY_STATUS) StatusEnum status,
            @JsonProperty(JSON_PROPERTY_CREATED_AT) OffsetDateTime createdAt) {
        this();
        this.id = id;
        this.ip = ip;
        this.status = status;
        this.createdAt = createdAt;
    }

    /**
     * A unique ID that can be used to identify and reference a load balancer.
     *
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public UUID getId() {
        return id;
    }

    public LoadBalancerBase name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A human-readable name for a load balancer instance.
     *
     * @return name
     **/
    @javax.annotation.Nullable
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

    /**
     * An attribute containing the public-facing IP address of the load balancer.
     *
     * @return ip
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_IP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getIp() {
        return ip;
    }

    public LoadBalancerBase sizeUnit(Integer sizeUnit) {
        this.sizeUnit = sizeUnit;
        return this;
    }

    /**
     * How many nodes the load balancer contains. Each additional node increases the
     * load balancer&#39;s ability to manage more connections. Load balancers can be
     * scaled up or down, and you can change the number of nodes after creation up
     * to once per hour. This field is currently not available in the AMS2, NYC2, or
     * SFO1 regions. Use the &#x60;size&#x60; field to scale load balancers that
     * reside in these regions. minimum: 1 maximum: 100
     *
     * @return sizeUnit
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SIZE_UNIT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getSizeUnit() {
        return sizeUnit;
    }

    @JsonProperty(JSON_PROPERTY_SIZE_UNIT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSizeUnit(Integer sizeUnit) {
        this.sizeUnit = sizeUnit;
    }

    public LoadBalancerBase size(SizeEnum size) {
        this.size = size;
        return this;
    }

    /**
     * This field has been replaced by the &#x60;size_unit&#x60; field for all
     * regions except in AMS2, NYC2, and SFO1. Each available load balancer size now
     * equates to the load balancer having a set number of nodes. *
     * &#x60;lb-small&#x60; &#x3D; 1 node * &#x60;lb-medium&#x60; &#x3D; 3 nodes *
     * &#x60;lb-large&#x60; &#x3D; 6 nodes You can resize load balancers after
     * creation up to once per hour. You cannot resize a load balancer within the
     * first hour of its creation.
     *
     * @return size
     * @deprecated
     **/
    @Deprecated
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public SizeEnum getSize() {
        return size;
    }

    @JsonProperty(JSON_PROPERTY_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSize(SizeEnum size) {
        this.size = size;
    }

    public LoadBalancerBase algorithm(AlgorithmEnum algorithm) {
        this.algorithm = algorithm;
        return this;
    }

    /**
     * This field has been deprecated. You can no longer specify an algorithm for
     * load balancers.
     *
     * @return algorithm
     * @deprecated
     **/
    @Deprecated
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ALGORITHM)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AlgorithmEnum getAlgorithm() {
        return algorithm;
    }

    @JsonProperty(JSON_PROPERTY_ALGORITHM)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAlgorithm(AlgorithmEnum algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * A status string indicating the current state of the load balancer. This can
     * be &#x60;new&#x60;, &#x60;active&#x60;, or &#x60;errored&#x60;.
     *
     * @return status
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public StatusEnum getStatus() {
        return status;
    }

    /**
     * A time value given in ISO8601 combined date and time format that represents
     * when the load balancer was created.
     *
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public LoadBalancerBase forwardingRules(List<ForwardingRule> forwardingRules) {
        this.forwardingRules = forwardingRules;
        return this;
    }

    public LoadBalancerBase addForwardingRulesItem(ForwardingRule forwardingRulesItem) {
        this.forwardingRules.add(forwardingRulesItem);
        return this;
    }

    /**
     * An array of objects specifying the forwarding rules for a load balancer.
     *
     * @return forwardingRules
     **/
    @javax.annotation.Nonnull
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

    public LoadBalancerBase healthCheck(HealthCheck healthCheck) {
        this.healthCheck = healthCheck;
        return this;
    }

    /**
     * Get healthCheck
     *
     * @return healthCheck
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_HEALTH_CHECK)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public HealthCheck getHealthCheck() {
        return healthCheck;
    }

    @JsonProperty(JSON_PROPERTY_HEALTH_CHECK)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setHealthCheck(HealthCheck healthCheck) {
        this.healthCheck = healthCheck;
    }

    public LoadBalancerBase stickySessions(StickySessions stickySessions) {
        this.stickySessions = stickySessions;
        return this;
    }

    /**
     * Get stickySessions
     *
     * @return stickySessions
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STICKY_SESSIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public StickySessions getStickySessions() {
        return stickySessions;
    }

    @JsonProperty(JSON_PROPERTY_STICKY_SESSIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStickySessions(StickySessions stickySessions) {
        this.stickySessions = stickySessions;
    }

    public LoadBalancerBase redirectHttpToHttps(Boolean redirectHttpToHttps) {
        this.redirectHttpToHttps = redirectHttpToHttps;
        return this;
    }

    /**
     * A boolean value indicating whether HTTP requests to the load balancer on port
     * 80 will be redirected to HTTPS on port 443.
     *
     * @return redirectHttpToHttps
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REDIRECT_HTTP_TO_HTTPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getRedirectHttpToHttps() {
        return redirectHttpToHttps;
    }

    @JsonProperty(JSON_PROPERTY_REDIRECT_HTTP_TO_HTTPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRedirectHttpToHttps(Boolean redirectHttpToHttps) {
        this.redirectHttpToHttps = redirectHttpToHttps;
    }

    public LoadBalancerBase enableProxyProtocol(Boolean enableProxyProtocol) {
        this.enableProxyProtocol = enableProxyProtocol;
        return this;
    }

    /**
     * A boolean value indicating whether PROXY Protocol is in use.
     *
     * @return enableProxyProtocol
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ENABLE_PROXY_PROTOCOL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getEnableProxyProtocol() {
        return enableProxyProtocol;
    }

    @JsonProperty(JSON_PROPERTY_ENABLE_PROXY_PROTOCOL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEnableProxyProtocol(Boolean enableProxyProtocol) {
        this.enableProxyProtocol = enableProxyProtocol;
    }

    public LoadBalancerBase enableBackendKeepalive(Boolean enableBackendKeepalive) {
        this.enableBackendKeepalive = enableBackendKeepalive;
        return this;
    }

    /**
     * A boolean value indicating whether HTTP keepalive connections are maintained
     * to target Droplets.
     *
     * @return enableBackendKeepalive
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ENABLE_BACKEND_KEEPALIVE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getEnableBackendKeepalive() {
        return enableBackendKeepalive;
    }

    @JsonProperty(JSON_PROPERTY_ENABLE_BACKEND_KEEPALIVE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEnableBackendKeepalive(Boolean enableBackendKeepalive) {
        this.enableBackendKeepalive = enableBackendKeepalive;
    }

    public LoadBalancerBase vpcUuid(UUID vpcUuid) {
        this.vpcUuid = vpcUuid;
        return this;
    }

    /**
     * A string specifying the UUID of the VPC to which the load balancer is
     * assigned.
     *
     * @return vpcUuid
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_VPC_UUID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public UUID getVpcUuid() {
        return vpcUuid;
    }

    @JsonProperty(JSON_PROPERTY_VPC_UUID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVpcUuid(UUID vpcUuid) {
        this.vpcUuid = vpcUuid;
    }

    public LoadBalancerBase disableLetsEncryptDnsRecords(Boolean disableLetsEncryptDnsRecords) {
        this.disableLetsEncryptDnsRecords = disableLetsEncryptDnsRecords;
        return this;
    }

    /**
     * A boolean value indicating whether to disable automatic DNS record creation
     * for Let&#39;s Encrypt certificates that are added to the load balancer.
     *
     * @return disableLetsEncryptDnsRecords
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DISABLE_LETS_ENCRYPT_DNS_RECORDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getDisableLetsEncryptDnsRecords() {
        return disableLetsEncryptDnsRecords;
    }

    @JsonProperty(JSON_PROPERTY_DISABLE_LETS_ENCRYPT_DNS_RECORDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDisableLetsEncryptDnsRecords(Boolean disableLetsEncryptDnsRecords) {
        this.disableLetsEncryptDnsRecords = disableLetsEncryptDnsRecords;
    }

    /**
     * Return true if this load_balancer_base object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LoadBalancerBase loadBalancerBase = (LoadBalancerBase) o;
        return Objects.equals(this.id, loadBalancerBase.id) && Objects.equals(this.name, loadBalancerBase.name)
                && Objects.equals(this.ip, loadBalancerBase.ip)
                && Objects.equals(this.sizeUnit, loadBalancerBase.sizeUnit)
                && Objects.equals(this.size, loadBalancerBase.size)
                && Objects.equals(this.algorithm, loadBalancerBase.algorithm)
                && Objects.equals(this.status, loadBalancerBase.status)
                && Objects.equals(this.createdAt, loadBalancerBase.createdAt)
                && Objects.equals(this.forwardingRules, loadBalancerBase.forwardingRules)
                && Objects.equals(this.healthCheck, loadBalancerBase.healthCheck)
                && Objects.equals(this.stickySessions, loadBalancerBase.stickySessions)
                && Objects.equals(this.redirectHttpToHttps, loadBalancerBase.redirectHttpToHttps)
                && Objects.equals(this.enableProxyProtocol, loadBalancerBase.enableProxyProtocol)
                && Objects.equals(this.enableBackendKeepalive, loadBalancerBase.enableBackendKeepalive)
                && Objects.equals(this.vpcUuid, loadBalancerBase.vpcUuid)
                && Objects.equals(this.disableLetsEncryptDnsRecords, loadBalancerBase.disableLetsEncryptDnsRecords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ip, sizeUnit, size, algorithm, status, createdAt, forwardingRules, healthCheck,
                stickySessions, redirectHttpToHttps, enableProxyProtocol, enableBackendKeepalive, vpcUuid,
                disableLetsEncryptDnsRecords);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LoadBalancerBase {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
        sb.append("    sizeUnit: ").append(toIndentedString(sizeUnit)).append("\n");
        sb.append("    size: ").append(toIndentedString(size)).append("\n");
        sb.append("    algorithm: ").append(toIndentedString(algorithm)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    forwardingRules: ").append(toIndentedString(forwardingRules)).append("\n");
        sb.append("    healthCheck: ").append(toIndentedString(healthCheck)).append("\n");
        sb.append("    stickySessions: ").append(toIndentedString(stickySessions)).append("\n");
        sb.append("    redirectHttpToHttps: ").append(toIndentedString(redirectHttpToHttps)).append("\n");
        sb.append("    enableProxyProtocol: ").append(toIndentedString(enableProxyProtocol)).append("\n");
        sb.append("    enableBackendKeepalive: ").append(toIndentedString(enableBackendKeepalive)).append("\n");
        sb.append("    vpcUuid: ").append(toIndentedString(vpcUuid)).append("\n");
        sb.append("    disableLetsEncryptDnsRecords: ").append(toIndentedString(disableLetsEncryptDnsRecords))
                .append("\n");
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