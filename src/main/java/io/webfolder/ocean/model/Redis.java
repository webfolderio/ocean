package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Redis
 */
@JsonPropertyOrder({ Redis.JSON_PROPERTY_REDIS_MAXMEMORY_POLICY,
        Redis.JSON_PROPERTY_REDIS_PUBSUB_CLIENT_OUTPUT_BUFFER_LIMIT, Redis.JSON_PROPERTY_REDIS_NUMBER_OF_DATABASES,
        Redis.JSON_PROPERTY_REDIS_IO_THREADS, Redis.JSON_PROPERTY_REDIS_LFU_LOG_FACTOR,
        Redis.JSON_PROPERTY_REDIS_LFU_DECAY_TIME, Redis.JSON_PROPERTY_REDIS_SSL, Redis.JSON_PROPERTY_REDIS_TIMEOUT,
        Redis.JSON_PROPERTY_REDIS_NOTIFY_KEYSPACE_EVENTS, Redis.JSON_PROPERTY_REDIS_PERSISTENCE,
        Redis.JSON_PROPERTY_REDIS_ACL_CHANNELS_DEFAULT })
public class Redis {
    /**
     * Gets or Sets redisMaxmemoryPolicy
     */
    public enum RedisMaxmemoryPolicyEnum {
        NOEVICTION("noeviction"),

        ALLKEYS_LRU("allkeys-lru"),

        VOLATILE_LRU("volatile-lru"),

        ALLKEYS_RANDOM("allkeys-random"),

        VOLATILE_RANDOM("volatile-random"),

        VOLATILE_TTL("volatile-ttl"),

        VOLATILE_LFU("volatile-lfu"),

        ALLKEYS_LFU("allkeys-lfu");

        private String value;

        RedisMaxmemoryPolicyEnum(String value) {
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
        public static RedisMaxmemoryPolicyEnum fromValue(String value) {
            for (RedisMaxmemoryPolicyEnum b : RedisMaxmemoryPolicyEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_REDIS_MAXMEMORY_POLICY = "redis_maxmemory_policy";
    private RedisMaxmemoryPolicyEnum redisMaxmemoryPolicy = RedisMaxmemoryPolicyEnum.NOEVICTION;

    public static final String JSON_PROPERTY_REDIS_PUBSUB_CLIENT_OUTPUT_BUFFER_LIMIT = "redis_pubsub_client_output_buffer_limit";
    private Integer redisPubsubClientOutputBufferLimit;

    public static final String JSON_PROPERTY_REDIS_NUMBER_OF_DATABASES = "redis_number_of_databases";
    private Integer redisNumberOfDatabases;

    public static final String JSON_PROPERTY_REDIS_IO_THREADS = "redis_io_threads";
    private Integer redisIoThreads;

    public static final String JSON_PROPERTY_REDIS_LFU_LOG_FACTOR = "redis_lfu_log_factor";
    private Integer redisLfuLogFactor = 10;

    public static final String JSON_PROPERTY_REDIS_LFU_DECAY_TIME = "redis_lfu_decay_time";
    private Integer redisLfuDecayTime = 1;

    public static final String JSON_PROPERTY_REDIS_SSL = "redis_ssl";
    private Boolean redisSsl = true;

    public static final String JSON_PROPERTY_REDIS_TIMEOUT = "redis_timeout";
    private Integer redisTimeout = 300;

    public static final String JSON_PROPERTY_REDIS_NOTIFY_KEYSPACE_EVENTS = "redis_notify_keyspace_events";
    private String redisNotifyKeyspaceEvents = "";

    /**
     * When persistence is &#39;rdb&#39;, Redis does RDB dumps each 10 minutes if
     * any key is changed. Also RDB dumps are done according to backup schedule for
     * backup purposes. When persistence is &#39;off&#39;, no RDB dumps and backups
     * are done, so data can be lost at any moment if service is restarted for any
     * reason, or if service is powered off. Also service can&#39;t be forked.
     */
    public enum RedisPersistenceEnum {
        OFF("off"),

        RDB("rdb");

        private String value;

        RedisPersistenceEnum(String value) {
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
        public static RedisPersistenceEnum fromValue(String value) {
            for (RedisPersistenceEnum b : RedisPersistenceEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_REDIS_PERSISTENCE = "redis_persistence";
    private RedisPersistenceEnum redisPersistence;

    /**
     * Determines default pub/sub channels&#39; ACL for new users if ACL is not
     * supplied. When this option is not defined, all_channels is assumed to keep
     * backward compatibility. This option doesn&#39;t affect Redis configuration
     * acl-pubsub-default.
     */
    public enum RedisAclChannelsDefaultEnum {
        ALLCHANNELS("allchannels"),

        RESETCHANNELS("resetchannels");

        private String value;

        RedisAclChannelsDefaultEnum(String value) {
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
        public static RedisAclChannelsDefaultEnum fromValue(String value) {
            for (RedisAclChannelsDefaultEnum b : RedisAclChannelsDefaultEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_REDIS_ACL_CHANNELS_DEFAULT = "redis_acl_channels_default";
    private RedisAclChannelsDefaultEnum redisAclChannelsDefault;

    public Redis() {
    }

    public Redis redisMaxmemoryPolicy(RedisMaxmemoryPolicyEnum redisMaxmemoryPolicy) {
        this.redisMaxmemoryPolicy = redisMaxmemoryPolicy;
        return this;
    }

    /**
     * Get redisMaxmemoryPolicy
     *
     * @return redisMaxmemoryPolicy
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REDIS_MAXMEMORY_POLICY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public RedisMaxmemoryPolicyEnum getRedisMaxmemoryPolicy() {
        return redisMaxmemoryPolicy;
    }

    @JsonProperty(JSON_PROPERTY_REDIS_MAXMEMORY_POLICY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRedisMaxmemoryPolicy(RedisMaxmemoryPolicyEnum redisMaxmemoryPolicy) {
        this.redisMaxmemoryPolicy = redisMaxmemoryPolicy;
    }

    public Redis redisPubsubClientOutputBufferLimit(Integer redisPubsubClientOutputBufferLimit) {
        this.redisPubsubClientOutputBufferLimit = redisPubsubClientOutputBufferLimit;
        return this;
    }

    /**
     * Set output buffer limit for pub / sub clients in MB. The value is the hard
     * limit, the soft limit is 1/4 of the hard limit. When setting the limit, be
     * mindful of the available memory in the selected service plan. minimum: 32
     * maximum: 512
     *
     * @return redisPubsubClientOutputBufferLimit
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REDIS_PUBSUB_CLIENT_OUTPUT_BUFFER_LIMIT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Integer getRedisPubsubClientOutputBufferLimit() {
        return redisPubsubClientOutputBufferLimit;
    }

    @JsonProperty(JSON_PROPERTY_REDIS_PUBSUB_CLIENT_OUTPUT_BUFFER_LIMIT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRedisPubsubClientOutputBufferLimit(Integer redisPubsubClientOutputBufferLimit) {
        this.redisPubsubClientOutputBufferLimit = redisPubsubClientOutputBufferLimit;
    }

    public Redis redisNumberOfDatabases(Integer redisNumberOfDatabases) {
        this.redisNumberOfDatabases = redisNumberOfDatabases;
        return this;
    }

    /**
     * Set number of redis databases. Changing this will cause a restart of redis
     * service. minimum: 1 maximum: 128
     *
     * @return redisNumberOfDatabases
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REDIS_NUMBER_OF_DATABASES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Integer getRedisNumberOfDatabases() {
        return redisNumberOfDatabases;
    }

    @JsonProperty(JSON_PROPERTY_REDIS_NUMBER_OF_DATABASES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRedisNumberOfDatabases(Integer redisNumberOfDatabases) {
        this.redisNumberOfDatabases = redisNumberOfDatabases;
    }

    public Redis redisIoThreads(Integer redisIoThreads) {
        this.redisIoThreads = redisIoThreads;
        return this;
    }

    /**
     * Redis IO thread count minimum: 1 maximum: 32
     *
     * @return redisIoThreads
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REDIS_IO_THREADS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getRedisIoThreads() {
        return redisIoThreads;
    }

    @JsonProperty(JSON_PROPERTY_REDIS_IO_THREADS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRedisIoThreads(Integer redisIoThreads) {
        this.redisIoThreads = redisIoThreads;
    }

    public Redis redisLfuLogFactor(Integer redisLfuLogFactor) {
        this.redisLfuLogFactor = redisLfuLogFactor;
        return this;
    }

    /**
     * Counter logarithm factor for volatile-lfu and allkeys-lfu maxmemory-policies
     * minimum: 0 maximum: 100
     *
     * @return redisLfuLogFactor
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REDIS_LFU_LOG_FACTOR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getRedisLfuLogFactor() {
        return redisLfuLogFactor;
    }

    @JsonProperty(JSON_PROPERTY_REDIS_LFU_LOG_FACTOR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRedisLfuLogFactor(Integer redisLfuLogFactor) {
        this.redisLfuLogFactor = redisLfuLogFactor;
    }

    public Redis redisLfuDecayTime(Integer redisLfuDecayTime) {
        this.redisLfuDecayTime = redisLfuDecayTime;
        return this;
    }

    /**
     * LFU maxmemory-policy counter decay time in minutes minimum: 1 maximum: 120
     *
     * @return redisLfuDecayTime
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REDIS_LFU_DECAY_TIME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getRedisLfuDecayTime() {
        return redisLfuDecayTime;
    }

    @JsonProperty(JSON_PROPERTY_REDIS_LFU_DECAY_TIME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRedisLfuDecayTime(Integer redisLfuDecayTime) {
        this.redisLfuDecayTime = redisLfuDecayTime;
    }

    public Redis redisSsl(Boolean redisSsl) {
        this.redisSsl = redisSsl;
        return this;
    }

    /**
     * Require SSL to access Redis
     *
     * @return redisSsl
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REDIS_SSL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getRedisSsl() {
        return redisSsl;
    }

    @JsonProperty(JSON_PROPERTY_REDIS_SSL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRedisSsl(Boolean redisSsl) {
        this.redisSsl = redisSsl;
    }

    public Redis redisTimeout(Integer redisTimeout) {
        this.redisTimeout = redisTimeout;
        return this;
    }

    /**
     * Redis idle connection timeout in seconds minimum: 0 maximum: 31536000
     *
     * @return redisTimeout
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REDIS_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getRedisTimeout() {
        return redisTimeout;
    }

    @JsonProperty(JSON_PROPERTY_REDIS_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRedisTimeout(Integer redisTimeout) {
        this.redisTimeout = redisTimeout;
    }

    public Redis redisNotifyKeyspaceEvents(String redisNotifyKeyspaceEvents) {
        this.redisNotifyKeyspaceEvents = redisNotifyKeyspaceEvents;
        return this;
    }

    /**
     * Set notify-keyspace-events option
     *
     * @return redisNotifyKeyspaceEvents
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REDIS_NOTIFY_KEYSPACE_EVENTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getRedisNotifyKeyspaceEvents() {
        return redisNotifyKeyspaceEvents;
    }

    @JsonProperty(JSON_PROPERTY_REDIS_NOTIFY_KEYSPACE_EVENTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRedisNotifyKeyspaceEvents(String redisNotifyKeyspaceEvents) {
        this.redisNotifyKeyspaceEvents = redisNotifyKeyspaceEvents;
    }

    public Redis redisPersistence(RedisPersistenceEnum redisPersistence) {
        this.redisPersistence = redisPersistence;
        return this;
    }

    /**
     * When persistence is &#39;rdb&#39;, Redis does RDB dumps each 10 minutes if
     * any key is changed. Also RDB dumps are done according to backup schedule for
     * backup purposes. When persistence is &#39;off&#39;, no RDB dumps and backups
     * are done, so data can be lost at any moment if service is restarted for any
     * reason, or if service is powered off. Also service can&#39;t be forked.
     *
     * @return redisPersistence
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REDIS_PERSISTENCE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public RedisPersistenceEnum getRedisPersistence() {
        return redisPersistence;
    }

    @JsonProperty(JSON_PROPERTY_REDIS_PERSISTENCE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRedisPersistence(RedisPersistenceEnum redisPersistence) {
        this.redisPersistence = redisPersistence;
    }

    public Redis redisAclChannelsDefault(RedisAclChannelsDefaultEnum redisAclChannelsDefault) {
        this.redisAclChannelsDefault = redisAclChannelsDefault;
        return this;
    }

    /**
     * Determines default pub/sub channels&#39; ACL for new users if ACL is not
     * supplied. When this option is not defined, all_channels is assumed to keep
     * backward compatibility. This option doesn&#39;t affect Redis configuration
     * acl-pubsub-default.
     *
     * @return redisAclChannelsDefault
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REDIS_ACL_CHANNELS_DEFAULT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public RedisAclChannelsDefaultEnum getRedisAclChannelsDefault() {
        return redisAclChannelsDefault;
    }

    @JsonProperty(JSON_PROPERTY_REDIS_ACL_CHANNELS_DEFAULT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRedisAclChannelsDefault(RedisAclChannelsDefaultEnum redisAclChannelsDefault) {
        this.redisAclChannelsDefault = redisAclChannelsDefault;
    }

    /**
     * Return true if this redis object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Redis redis = (Redis) o;
        return Objects.equals(this.redisMaxmemoryPolicy, redis.redisMaxmemoryPolicy)
                && Objects.equals(this.redisPubsubClientOutputBufferLimit, redis.redisPubsubClientOutputBufferLimit)
                && Objects.equals(this.redisNumberOfDatabases, redis.redisNumberOfDatabases)
                && Objects.equals(this.redisIoThreads, redis.redisIoThreads)
                && Objects.equals(this.redisLfuLogFactor, redis.redisLfuLogFactor)
                && Objects.equals(this.redisLfuDecayTime, redis.redisLfuDecayTime)
                && Objects.equals(this.redisSsl, redis.redisSsl)
                && Objects.equals(this.redisTimeout, redis.redisTimeout)
                && Objects.equals(this.redisNotifyKeyspaceEvents, redis.redisNotifyKeyspaceEvents)
                && Objects.equals(this.redisPersistence, redis.redisPersistence)
                && Objects.equals(this.redisAclChannelsDefault, redis.redisAclChannelsDefault);
    }

    @Override
    public int hashCode() {
        return Objects.hash(redisMaxmemoryPolicy, redisPubsubClientOutputBufferLimit, redisNumberOfDatabases,
                redisIoThreads, redisLfuLogFactor, redisLfuDecayTime, redisSsl, redisTimeout, redisNotifyKeyspaceEvents,
                redisPersistence, redisAclChannelsDefault);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Redis {\n");
        sb.append("    redisMaxmemoryPolicy: ").append(toIndentedString(redisMaxmemoryPolicy)).append("\n");
        sb.append("    redisPubsubClientOutputBufferLimit: ")
                .append(toIndentedString(redisPubsubClientOutputBufferLimit)).append("\n");
        sb.append("    redisNumberOfDatabases: ").append(toIndentedString(redisNumberOfDatabases)).append("\n");
        sb.append("    redisIoThreads: ").append(toIndentedString(redisIoThreads)).append("\n");
        sb.append("    redisLfuLogFactor: ").append(toIndentedString(redisLfuLogFactor)).append("\n");
        sb.append("    redisLfuDecayTime: ").append(toIndentedString(redisLfuDecayTime)).append("\n");
        sb.append("    redisSsl: ").append(toIndentedString(redisSsl)).append("\n");
        sb.append("    redisTimeout: ").append(toIndentedString(redisTimeout)).append("\n");
        sb.append("    redisNotifyKeyspaceEvents: ").append(toIndentedString(redisNotifyKeyspaceEvents)).append("\n");
        sb.append("    redisPersistence: ").append(toIndentedString(redisPersistence)).append("\n");
        sb.append("    redisAclChannelsDefault: ").append(toIndentedString(redisAclChannelsDefault)).append("\n");
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