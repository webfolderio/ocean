package io.webfolder.ocean.model;

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Mysql
 */
@JsonPropertyOrder({ Mysql.JSON_PROPERTY_BACKUP_HOUR, Mysql.JSON_PROPERTY_BACKUP_MINUTE, Mysql.JSON_PROPERTY_SQL_MODE,
        Mysql.JSON_PROPERTY_CONNECT_TIMEOUT, Mysql.JSON_PROPERTY_DEFAULT_TIME_ZONE,
        Mysql.JSON_PROPERTY_GROUP_CONCAT_MAX_LEN, Mysql.JSON_PROPERTY_INFORMATION_SCHEMA_STATS_EXPIRY,
        Mysql.JSON_PROPERTY_INNODB_FT_MIN_TOKEN_SIZE, Mysql.JSON_PROPERTY_INNODB_FT_SERVER_STOPWORD_TABLE,
        Mysql.JSON_PROPERTY_INNODB_LOCK_WAIT_TIMEOUT, Mysql.JSON_PROPERTY_INNODB_LOG_BUFFER_SIZE,
        Mysql.JSON_PROPERTY_INNODB_ONLINE_ALTER_LOG_MAX_SIZE, Mysql.JSON_PROPERTY_INNODB_PRINT_ALL_DEADLOCKS,
        Mysql.JSON_PROPERTY_INNODB_ROLLBACK_ON_TIMEOUT, Mysql.JSON_PROPERTY_INTERACTIVE_TIMEOUT,
        Mysql.JSON_PROPERTY_INTERNAL_TMP_MEM_STORAGE_ENGINE, Mysql.JSON_PROPERTY_NET_READ_TIMEOUT,
        Mysql.JSON_PROPERTY_NET_WRITE_TIMEOUT, Mysql.JSON_PROPERTY_SQL_REQUIRE_PRIMARY_KEY,
        Mysql.JSON_PROPERTY_WAIT_TIMEOUT, Mysql.JSON_PROPERTY_MAX_ALLOWED_PACKET,
        Mysql.JSON_PROPERTY_MAX_HEAP_TABLE_SIZE, Mysql.JSON_PROPERTY_SORT_BUFFER_SIZE,
        Mysql.JSON_PROPERTY_TMP_TABLE_SIZE, Mysql.JSON_PROPERTY_SLOW_QUERY_LOG, Mysql.JSON_PROPERTY_LONG_QUERY_TIME })
public class Mysql {
    public static final String JSON_PROPERTY_BACKUP_HOUR = "backup_hour";
    private Integer backupHour;

    public static final String JSON_PROPERTY_BACKUP_MINUTE = "backup_minute";
    private Integer backupMinute;

    public static final String JSON_PROPERTY_SQL_MODE = "sql_mode";
    private String sqlMode;

    public static final String JSON_PROPERTY_CONNECT_TIMEOUT = "connect_timeout";
    private Integer connectTimeout;

    public static final String JSON_PROPERTY_DEFAULT_TIME_ZONE = "default_time_zone";
    private String defaultTimeZone;

    public static final String JSON_PROPERTY_GROUP_CONCAT_MAX_LEN = "group_concat_max_len";
    private Integer groupConcatMaxLen;

    public static final String JSON_PROPERTY_INFORMATION_SCHEMA_STATS_EXPIRY = "information_schema_stats_expiry";
    private Integer informationSchemaStatsExpiry;

    public static final String JSON_PROPERTY_INNODB_FT_MIN_TOKEN_SIZE = "innodb_ft_min_token_size";
    private Integer innodbFtMinTokenSize;

    public static final String JSON_PROPERTY_INNODB_FT_SERVER_STOPWORD_TABLE = "innodb_ft_server_stopword_table";
    private String innodbFtServerStopwordTable;

    public static final String JSON_PROPERTY_INNODB_LOCK_WAIT_TIMEOUT = "innodb_lock_wait_timeout";
    private Integer innodbLockWaitTimeout;

    public static final String JSON_PROPERTY_INNODB_LOG_BUFFER_SIZE = "innodb_log_buffer_size";
    private Integer innodbLogBufferSize;

    public static final String JSON_PROPERTY_INNODB_ONLINE_ALTER_LOG_MAX_SIZE = "innodb_online_alter_log_max_size";
    private Integer innodbOnlineAlterLogMaxSize;

    public static final String JSON_PROPERTY_INNODB_PRINT_ALL_DEADLOCKS = "innodb_print_all_deadlocks";
    private Boolean innodbPrintAllDeadlocks;

    public static final String JSON_PROPERTY_INNODB_ROLLBACK_ON_TIMEOUT = "innodb_rollback_on_timeout";
    private Boolean innodbRollbackOnTimeout;

    public static final String JSON_PROPERTY_INTERACTIVE_TIMEOUT = "interactive_timeout";
    private Integer interactiveTimeout;

    /**
     * The storage engine for in-memory internal temporary tables.
     */
    public enum InternalTmpMemStorageEngineEnum {
        TEMPTABLE("TempTable"),

        MEMORY("MEMORY");

        private String value;

        InternalTmpMemStorageEngineEnum(String value) {
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
        public static InternalTmpMemStorageEngineEnum fromValue(String value) {
            for (InternalTmpMemStorageEngineEnum b : InternalTmpMemStorageEngineEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_INTERNAL_TMP_MEM_STORAGE_ENGINE = "internal_tmp_mem_storage_engine";
    private InternalTmpMemStorageEngineEnum internalTmpMemStorageEngine;

    public static final String JSON_PROPERTY_NET_READ_TIMEOUT = "net_read_timeout";
    private Integer netReadTimeout;

    public static final String JSON_PROPERTY_NET_WRITE_TIMEOUT = "net_write_timeout";
    private Integer netWriteTimeout;

    public static final String JSON_PROPERTY_SQL_REQUIRE_PRIMARY_KEY = "sql_require_primary_key";
    private Boolean sqlRequirePrimaryKey;

    public static final String JSON_PROPERTY_WAIT_TIMEOUT = "wait_timeout";
    private Integer waitTimeout;

    public static final String JSON_PROPERTY_MAX_ALLOWED_PACKET = "max_allowed_packet";
    private Integer maxAllowedPacket;

    public static final String JSON_PROPERTY_MAX_HEAP_TABLE_SIZE = "max_heap_table_size";
    private Integer maxHeapTableSize;

    public static final String JSON_PROPERTY_SORT_BUFFER_SIZE = "sort_buffer_size";
    private Integer sortBufferSize;

    public static final String JSON_PROPERTY_TMP_TABLE_SIZE = "tmp_table_size";
    private Integer tmpTableSize;

    public static final String JSON_PROPERTY_SLOW_QUERY_LOG = "slow_query_log";
    private Boolean slowQueryLog;

    public static final String JSON_PROPERTY_LONG_QUERY_TIME = "long_query_time";
    private BigDecimal longQueryTime;

    public Mysql() {
    }

    public Mysql backupHour(Integer backupHour) {
        this.backupHour = backupHour;
        return this;
    }

    /**
     * The hour of day (in UTC) when backup for the service starts. New backup only
     * starts if previous backup has already completed. minimum: 0 maximum: 23
     *
     * @return backupHour
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_BACKUP_HOUR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Integer getBackupHour() {
        return backupHour;
    }

    @JsonProperty(JSON_PROPERTY_BACKUP_HOUR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setBackupHour(Integer backupHour) {
        this.backupHour = backupHour;
    }

    public Mysql backupMinute(Integer backupMinute) {
        this.backupMinute = backupMinute;
        return this;
    }

    /**
     * The minute of the backup hour when backup for the service starts. New backup
     * only starts if previous backup has already completed. minimum: 0 maximum: 59
     *
     * @return backupMinute
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_BACKUP_MINUTE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getBackupMinute() {
        return backupMinute;
    }

    @JsonProperty(JSON_PROPERTY_BACKUP_MINUTE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setBackupMinute(Integer backupMinute) {
        this.backupMinute = backupMinute;
    }

    public Mysql sqlMode(String sqlMode) {
        this.sqlMode = sqlMode;
        return this;
    }

    /**
     * Global SQL mode. If empty, uses MySQL server defaults. Must only include
     * uppercase alphabetic characters, underscores, and commas.
     *
     * @return sqlMode
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SQL_MODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSqlMode() {
        return sqlMode;
    }

    @JsonProperty(JSON_PROPERTY_SQL_MODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSqlMode(String sqlMode) {
        this.sqlMode = sqlMode;
    }

    public Mysql connectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    /**
     * The number of seconds that the mysqld server waits for a connect packet
     * before responding with bad handshake. minimum: 2 maximum: 3600
     *
     * @return connectTimeout
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONNECT_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    @JsonProperty(JSON_PROPERTY_CONNECT_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public Mysql defaultTimeZone(String defaultTimeZone) {
        this.defaultTimeZone = defaultTimeZone;
        return this;
    }

    /**
     * Default server time zone, in the form of an offset from UTC (from -12:00 to
     * +12:00), a time zone name (EST), or &#39;SYSTEM&#39; to use the MySQL server
     * default.
     *
     * @return defaultTimeZone
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DEFAULT_TIME_ZONE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDefaultTimeZone() {
        return defaultTimeZone;
    }

    @JsonProperty(JSON_PROPERTY_DEFAULT_TIME_ZONE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDefaultTimeZone(String defaultTimeZone) {
        this.defaultTimeZone = defaultTimeZone;
    }

    public Mysql groupConcatMaxLen(Integer groupConcatMaxLen) {
        this.groupConcatMaxLen = groupConcatMaxLen;
        return this;
    }

    /**
     * The maximum permitted result length, in bytes, for the GROUP_CONCAT()
     * function. minimum: 4 maximum: 384
     *
     * @return groupConcatMaxLen
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_GROUP_CONCAT_MAX_LEN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getGroupConcatMaxLen() {
        return groupConcatMaxLen;
    }

    @JsonProperty(JSON_PROPERTY_GROUP_CONCAT_MAX_LEN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setGroupConcatMaxLen(Integer groupConcatMaxLen) {
        this.groupConcatMaxLen = groupConcatMaxLen;
    }

    public Mysql informationSchemaStatsExpiry(Integer informationSchemaStatsExpiry) {
        this.informationSchemaStatsExpiry = informationSchemaStatsExpiry;
        return this;
    }

    /**
     * The time, in seconds, before cached statistics expire. minimum: 900 maximum:
     * 31536000
     *
     * @return informationSchemaStatsExpiry
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INFORMATION_SCHEMA_STATS_EXPIRY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getInformationSchemaStatsExpiry() {
        return informationSchemaStatsExpiry;
    }

    @JsonProperty(JSON_PROPERTY_INFORMATION_SCHEMA_STATS_EXPIRY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInformationSchemaStatsExpiry(Integer informationSchemaStatsExpiry) {
        this.informationSchemaStatsExpiry = informationSchemaStatsExpiry;
    }

    public Mysql innodbFtMinTokenSize(Integer innodbFtMinTokenSize) {
        this.innodbFtMinTokenSize = innodbFtMinTokenSize;
        return this;
    }

    /**
     * The minimum length of words that an InnoDB FULLTEXT index stores. minimum: 0
     * maximum: 16
     *
     * @return innodbFtMinTokenSize
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INNODB_FT_MIN_TOKEN_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getInnodbFtMinTokenSize() {
        return innodbFtMinTokenSize;
    }

    @JsonProperty(JSON_PROPERTY_INNODB_FT_MIN_TOKEN_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInnodbFtMinTokenSize(Integer innodbFtMinTokenSize) {
        this.innodbFtMinTokenSize = innodbFtMinTokenSize;
    }

    public Mysql innodbFtServerStopwordTable(String innodbFtServerStopwordTable) {
        this.innodbFtServerStopwordTable = innodbFtServerStopwordTable;
        return this;
    }

    /**
     * The InnoDB FULLTEXT index stopword list for all InnoDB tables.
     *
     * @return innodbFtServerStopwordTable
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INNODB_FT_SERVER_STOPWORD_TABLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getInnodbFtServerStopwordTable() {
        return innodbFtServerStopwordTable;
    }

    @JsonProperty(JSON_PROPERTY_INNODB_FT_SERVER_STOPWORD_TABLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInnodbFtServerStopwordTable(String innodbFtServerStopwordTable) {
        this.innodbFtServerStopwordTable = innodbFtServerStopwordTable;
    }

    public Mysql innodbLockWaitTimeout(Integer innodbLockWaitTimeout) {
        this.innodbLockWaitTimeout = innodbLockWaitTimeout;
        return this;
    }

    /**
     * The time, in seconds, that an InnoDB transaction waits for a row lock. before
     * giving up. minimum: 1 maximum: 3600
     *
     * @return innodbLockWaitTimeout
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INNODB_LOCK_WAIT_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getInnodbLockWaitTimeout() {
        return innodbLockWaitTimeout;
    }

    @JsonProperty(JSON_PROPERTY_INNODB_LOCK_WAIT_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInnodbLockWaitTimeout(Integer innodbLockWaitTimeout) {
        this.innodbLockWaitTimeout = innodbLockWaitTimeout;
    }

    public Mysql innodbLogBufferSize(Integer innodbLogBufferSize) {
        this.innodbLogBufferSize = innodbLogBufferSize;
        return this;
    }

    /**
     * The size of the buffer, in bytes, that InnoDB uses to write to the log files.
     * on disk. minimum: 1048576 maximum: 4294967295
     *
     * @return innodbLogBufferSize
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INNODB_LOG_BUFFER_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getInnodbLogBufferSize() {
        return innodbLogBufferSize;
    }

    @JsonProperty(JSON_PROPERTY_INNODB_LOG_BUFFER_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInnodbLogBufferSize(Integer innodbLogBufferSize) {
        this.innodbLogBufferSize = innodbLogBufferSize;
    }

    public Mysql innodbOnlineAlterLogMaxSize(Integer innodbOnlineAlterLogMaxSize) {
        this.innodbOnlineAlterLogMaxSize = innodbOnlineAlterLogMaxSize;
        return this;
    }

    /**
     * The upper limit, in bytes, of the size of the temporary log files used during
     * online DDL operations for InnoDB tables. minimum: 65536 maximum:
     * 1099511627776
     *
     * @return innodbOnlineAlterLogMaxSize
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INNODB_ONLINE_ALTER_LOG_MAX_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getInnodbOnlineAlterLogMaxSize() {
        return innodbOnlineAlterLogMaxSize;
    }

    @JsonProperty(JSON_PROPERTY_INNODB_ONLINE_ALTER_LOG_MAX_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInnodbOnlineAlterLogMaxSize(Integer innodbOnlineAlterLogMaxSize) {
        this.innodbOnlineAlterLogMaxSize = innodbOnlineAlterLogMaxSize;
    }

    public Mysql innodbPrintAllDeadlocks(Boolean innodbPrintAllDeadlocks) {
        this.innodbPrintAllDeadlocks = innodbPrintAllDeadlocks;
        return this;
    }

    /**
     * When enabled, records information about all deadlocks in InnoDB user
     * transactions in the error log. Disabled by default.
     *
     * @return innodbPrintAllDeadlocks
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INNODB_PRINT_ALL_DEADLOCKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getInnodbPrintAllDeadlocks() {
        return innodbPrintAllDeadlocks;
    }

    @JsonProperty(JSON_PROPERTY_INNODB_PRINT_ALL_DEADLOCKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInnodbPrintAllDeadlocks(Boolean innodbPrintAllDeadlocks) {
        this.innodbPrintAllDeadlocks = innodbPrintAllDeadlocks;
    }

    public Mysql innodbRollbackOnTimeout(Boolean innodbRollbackOnTimeout) {
        this.innodbRollbackOnTimeout = innodbRollbackOnTimeout;
        return this;
    }

    /**
     * When enabled, transaction timeouts cause InnoDB to abort and roll back the
     * entire transaction.
     *
     * @return innodbRollbackOnTimeout
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INNODB_ROLLBACK_ON_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getInnodbRollbackOnTimeout() {
        return innodbRollbackOnTimeout;
    }

    @JsonProperty(JSON_PROPERTY_INNODB_ROLLBACK_ON_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInnodbRollbackOnTimeout(Boolean innodbRollbackOnTimeout) {
        this.innodbRollbackOnTimeout = innodbRollbackOnTimeout;
    }

    public Mysql interactiveTimeout(Integer interactiveTimeout) {
        this.interactiveTimeout = interactiveTimeout;
        return this;
    }

    /**
     * The time, in seconds, the server waits for activity on an interactive.
     * connection before closing it. minimum: 30 maximum: 604800
     *
     * @return interactiveTimeout
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INTERACTIVE_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getInteractiveTimeout() {
        return interactiveTimeout;
    }

    @JsonProperty(JSON_PROPERTY_INTERACTIVE_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInteractiveTimeout(Integer interactiveTimeout) {
        this.interactiveTimeout = interactiveTimeout;
    }

    public Mysql internalTmpMemStorageEngine(InternalTmpMemStorageEngineEnum internalTmpMemStorageEngine) {
        this.internalTmpMemStorageEngine = internalTmpMemStorageEngine;
        return this;
    }

    /**
     * The storage engine for in-memory internal temporary tables.
     *
     * @return internalTmpMemStorageEngine
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INTERNAL_TMP_MEM_STORAGE_ENGINE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public InternalTmpMemStorageEngineEnum getInternalTmpMemStorageEngine() {
        return internalTmpMemStorageEngine;
    }

    @JsonProperty(JSON_PROPERTY_INTERNAL_TMP_MEM_STORAGE_ENGINE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInternalTmpMemStorageEngine(InternalTmpMemStorageEngineEnum internalTmpMemStorageEngine) {
        this.internalTmpMemStorageEngine = internalTmpMemStorageEngine;
    }

    public Mysql netReadTimeout(Integer netReadTimeout) {
        this.netReadTimeout = netReadTimeout;
        return this;
    }

    /**
     * The time, in seconds, to wait for more data from an existing connection.
     * aborting the read. minimum: 1 maximum: 3600
     *
     * @return netReadTimeout
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NET_READ_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getNetReadTimeout() {
        return netReadTimeout;
    }

    @JsonProperty(JSON_PROPERTY_NET_READ_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setNetReadTimeout(Integer netReadTimeout) {
        this.netReadTimeout = netReadTimeout;
    }

    public Mysql netWriteTimeout(Integer netWriteTimeout) {
        this.netWriteTimeout = netWriteTimeout;
        return this;
    }

    /**
     * The number of seconds to wait for a block to be written to a connection
     * before aborting the write. minimum: 1 maximum: 3600
     *
     * @return netWriteTimeout
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NET_WRITE_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getNetWriteTimeout() {
        return netWriteTimeout;
    }

    @JsonProperty(JSON_PROPERTY_NET_WRITE_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setNetWriteTimeout(Integer netWriteTimeout) {
        this.netWriteTimeout = netWriteTimeout;
    }

    public Mysql sqlRequirePrimaryKey(Boolean sqlRequirePrimaryKey) {
        this.sqlRequirePrimaryKey = sqlRequirePrimaryKey;
        return this;
    }

    /**
     * Require primary key to be defined for new tables or old tables modified with
     * ALTER TABLE and fail if missing. It is recommended to always have primary
     * keys because various functionality may break if any large table is missing
     * them.
     *
     * @return sqlRequirePrimaryKey
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SQL_REQUIRE_PRIMARY_KEY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getSqlRequirePrimaryKey() {
        return sqlRequirePrimaryKey;
    }

    @JsonProperty(JSON_PROPERTY_SQL_REQUIRE_PRIMARY_KEY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSqlRequirePrimaryKey(Boolean sqlRequirePrimaryKey) {
        this.sqlRequirePrimaryKey = sqlRequirePrimaryKey;
    }

    public Mysql waitTimeout(Integer waitTimeout) {
        this.waitTimeout = waitTimeout;
        return this;
    }

    /**
     * The number of seconds the server waits for activity on a noninteractive
     * connection before closing it. minimum: 1 maximum: 2147483
     *
     * @return waitTimeout
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_WAIT_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getWaitTimeout() {
        return waitTimeout;
    }

    @JsonProperty(JSON_PROPERTY_WAIT_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setWaitTimeout(Integer waitTimeout) {
        this.waitTimeout = waitTimeout;
    }

    public Mysql maxAllowedPacket(Integer maxAllowedPacket) {
        this.maxAllowedPacket = maxAllowedPacket;
        return this;
    }

    /**
     * The size of the largest message, in bytes, that can be received by the
     * server. Default is 67108864 (64M). minimum: 102400 maximum: 1073741824
     *
     * @return maxAllowedPacket
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MAX_ALLOWED_PACKET)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getMaxAllowedPacket() {
        return maxAllowedPacket;
    }

    @JsonProperty(JSON_PROPERTY_MAX_ALLOWED_PACKET)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMaxAllowedPacket(Integer maxAllowedPacket) {
        this.maxAllowedPacket = maxAllowedPacket;
    }

    public Mysql maxHeapTableSize(Integer maxHeapTableSize) {
        this.maxHeapTableSize = maxHeapTableSize;
        return this;
    }

    /**
     * The maximum size, in bytes, of internal in-memory tables. Also set
     * tmp_table_size. Default is 16777216 (16M) minimum: 1048576 maximum:
     * 1073741824
     *
     * @return maxHeapTableSize
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MAX_HEAP_TABLE_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getMaxHeapTableSize() {
        return maxHeapTableSize;
    }

    @JsonProperty(JSON_PROPERTY_MAX_HEAP_TABLE_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMaxHeapTableSize(Integer maxHeapTableSize) {
        this.maxHeapTableSize = maxHeapTableSize;
    }

    public Mysql sortBufferSize(Integer sortBufferSize) {
        this.sortBufferSize = sortBufferSize;
        return this;
    }

    /**
     * The sort buffer size, in bytes, for ORDER BY optimization. Default is 262144.
     * (256K). minimum: 32768 maximum: 1073741824
     *
     * @return sortBufferSize
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SORT_BUFFER_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getSortBufferSize() {
        return sortBufferSize;
    }

    @JsonProperty(JSON_PROPERTY_SORT_BUFFER_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSortBufferSize(Integer sortBufferSize) {
        this.sortBufferSize = sortBufferSize;
    }

    public Mysql tmpTableSize(Integer tmpTableSize) {
        this.tmpTableSize = tmpTableSize;
        return this;
    }

    /**
     * The maximum size, in bytes, of internal in-memory tables. Also set
     * max_heap_table_size. Default is 16777216 (16M). minimum: 1048576 maximum:
     * 1073741824
     *
     * @return tmpTableSize
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TMP_TABLE_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getTmpTableSize() {
        return tmpTableSize;
    }

    @JsonProperty(JSON_PROPERTY_TMP_TABLE_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTmpTableSize(Integer tmpTableSize) {
        this.tmpTableSize = tmpTableSize;
    }

    public Mysql slowQueryLog(Boolean slowQueryLog) {
        this.slowQueryLog = slowQueryLog;
        return this;
    }

    /**
     * When enabled, captures slow queries. When disabled, also truncates the
     * mysql.slow_log table. Default is false.
     *
     * @return slowQueryLog
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SLOW_QUERY_LOG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getSlowQueryLog() {
        return slowQueryLog;
    }

    @JsonProperty(JSON_PROPERTY_SLOW_QUERY_LOG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSlowQueryLog(Boolean slowQueryLog) {
        this.slowQueryLog = slowQueryLog;
    }

    public Mysql longQueryTime(BigDecimal longQueryTime) {
        this.longQueryTime = longQueryTime;
        return this;
    }

    /**
     * The time, in seconds, for a query to take to execute before being captured by
     * slow_query_logs. Default is 10 seconds. minimum: 0 maximum: 3600
     *
     * @return longQueryTime
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LONG_QUERY_TIME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public BigDecimal getLongQueryTime() {
        return longQueryTime;
    }

    @JsonProperty(JSON_PROPERTY_LONG_QUERY_TIME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLongQueryTime(BigDecimal longQueryTime) {
        this.longQueryTime = longQueryTime;
    }

    /**
     * Return true if this mysql object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mysql mysql = (Mysql) o;
        return Objects.equals(this.backupHour, mysql.backupHour)
                && Objects.equals(this.backupMinute, mysql.backupMinute) && Objects.equals(this.sqlMode, mysql.sqlMode)
                && Objects.equals(this.connectTimeout, mysql.connectTimeout)
                && Objects.equals(this.defaultTimeZone, mysql.defaultTimeZone)
                && Objects.equals(this.groupConcatMaxLen, mysql.groupConcatMaxLen)
                && Objects.equals(this.informationSchemaStatsExpiry, mysql.informationSchemaStatsExpiry)
                && Objects.equals(this.innodbFtMinTokenSize, mysql.innodbFtMinTokenSize)
                && Objects.equals(this.innodbFtServerStopwordTable, mysql.innodbFtServerStopwordTable)
                && Objects.equals(this.innodbLockWaitTimeout, mysql.innodbLockWaitTimeout)
                && Objects.equals(this.innodbLogBufferSize, mysql.innodbLogBufferSize)
                && Objects.equals(this.innodbOnlineAlterLogMaxSize, mysql.innodbOnlineAlterLogMaxSize)
                && Objects.equals(this.innodbPrintAllDeadlocks, mysql.innodbPrintAllDeadlocks)
                && Objects.equals(this.innodbRollbackOnTimeout, mysql.innodbRollbackOnTimeout)
                && Objects.equals(this.interactiveTimeout, mysql.interactiveTimeout)
                && Objects.equals(this.internalTmpMemStorageEngine, mysql.internalTmpMemStorageEngine)
                && Objects.equals(this.netReadTimeout, mysql.netReadTimeout)
                && Objects.equals(this.netWriteTimeout, mysql.netWriteTimeout)
                && Objects.equals(this.sqlRequirePrimaryKey, mysql.sqlRequirePrimaryKey)
                && Objects.equals(this.waitTimeout, mysql.waitTimeout)
                && Objects.equals(this.maxAllowedPacket, mysql.maxAllowedPacket)
                && Objects.equals(this.maxHeapTableSize, mysql.maxHeapTableSize)
                && Objects.equals(this.sortBufferSize, mysql.sortBufferSize)
                && Objects.equals(this.tmpTableSize, mysql.tmpTableSize)
                && Objects.equals(this.slowQueryLog, mysql.slowQueryLog)
                && Objects.equals(this.longQueryTime, mysql.longQueryTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(backupHour, backupMinute, sqlMode, connectTimeout, defaultTimeZone, groupConcatMaxLen,
                informationSchemaStatsExpiry, innodbFtMinTokenSize, innodbFtServerStopwordTable, innodbLockWaitTimeout,
                innodbLogBufferSize, innodbOnlineAlterLogMaxSize, innodbPrintAllDeadlocks, innodbRollbackOnTimeout,
                interactiveTimeout, internalTmpMemStorageEngine, netReadTimeout, netWriteTimeout, sqlRequirePrimaryKey,
                waitTimeout, maxAllowedPacket, maxHeapTableSize, sortBufferSize, tmpTableSize, slowQueryLog,
                longQueryTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Mysql {\n");
        sb.append("    backupHour: ").append(toIndentedString(backupHour)).append("\n");
        sb.append("    backupMinute: ").append(toIndentedString(backupMinute)).append("\n");
        sb.append("    sqlMode: ").append(toIndentedString(sqlMode)).append("\n");
        sb.append("    connectTimeout: ").append(toIndentedString(connectTimeout)).append("\n");
        sb.append("    defaultTimeZone: ").append(toIndentedString(defaultTimeZone)).append("\n");
        sb.append("    groupConcatMaxLen: ").append(toIndentedString(groupConcatMaxLen)).append("\n");
        sb.append("    informationSchemaStatsExpiry: ").append(toIndentedString(informationSchemaStatsExpiry))
                .append("\n");
        sb.append("    innodbFtMinTokenSize: ").append(toIndentedString(innodbFtMinTokenSize)).append("\n");
        sb.append("    innodbFtServerStopwordTable: ").append(toIndentedString(innodbFtServerStopwordTable))
                .append("\n");
        sb.append("    innodbLockWaitTimeout: ").append(toIndentedString(innodbLockWaitTimeout)).append("\n");
        sb.append("    innodbLogBufferSize: ").append(toIndentedString(innodbLogBufferSize)).append("\n");
        sb.append("    innodbOnlineAlterLogMaxSize: ").append(toIndentedString(innodbOnlineAlterLogMaxSize))
                .append("\n");
        sb.append("    innodbPrintAllDeadlocks: ").append(toIndentedString(innodbPrintAllDeadlocks)).append("\n");
        sb.append("    innodbRollbackOnTimeout: ").append(toIndentedString(innodbRollbackOnTimeout)).append("\n");
        sb.append("    interactiveTimeout: ").append(toIndentedString(interactiveTimeout)).append("\n");
        sb.append("    internalTmpMemStorageEngine: ").append(toIndentedString(internalTmpMemStorageEngine))
                .append("\n");
        sb.append("    netReadTimeout: ").append(toIndentedString(netReadTimeout)).append("\n");
        sb.append("    netWriteTimeout: ").append(toIndentedString(netWriteTimeout)).append("\n");
        sb.append("    sqlRequirePrimaryKey: ").append(toIndentedString(sqlRequirePrimaryKey)).append("\n");
        sb.append("    waitTimeout: ").append(toIndentedString(waitTimeout)).append("\n");
        sb.append("    maxAllowedPacket: ").append(toIndentedString(maxAllowedPacket)).append("\n");
        sb.append("    maxHeapTableSize: ").append(toIndentedString(maxHeapTableSize)).append("\n");
        sb.append("    sortBufferSize: ").append(toIndentedString(sortBufferSize)).append("\n");
        sb.append("    tmpTableSize: ").append(toIndentedString(tmpTableSize)).append("\n");
        sb.append("    slowQueryLog: ").append(toIndentedString(slowQueryLog)).append("\n");
        sb.append("    longQueryTime: ").append(toIndentedString(longQueryTime)).append("\n");
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