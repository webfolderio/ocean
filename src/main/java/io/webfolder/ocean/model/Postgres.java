package io.webfolder.ocean.model;

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Postgres
 */
@JsonPropertyOrder({ Postgres.JSON_PROPERTY_AUTOVACUUM_FREEZE_MAX_AGE, Postgres.JSON_PROPERTY_AUTOVACUUM_MAX_WORKERS,
        Postgres.JSON_PROPERTY_AUTOVACUUM_NAPTIME, Postgres.JSON_PROPERTY_AUTOVACUUM_VACUUM_THRESHOLD,
        Postgres.JSON_PROPERTY_AUTOVACUUM_ANALYZE_THRESHOLD, Postgres.JSON_PROPERTY_AUTOVACUUM_VACUUM_SCALE_FACTOR,
        Postgres.JSON_PROPERTY_AUTOVACUUM_ANALYZE_SCALE_FACTOR, Postgres.JSON_PROPERTY_AUTOVACUUM_VACUUM_COST_DELAY,
        Postgres.JSON_PROPERTY_AUTOVACUUM_VACUUM_COST_LIMIT, Postgres.JSON_PROPERTY_BACKUP_HOUR,
        Postgres.JSON_PROPERTY_BACKUP_MINUTE, Postgres.JSON_PROPERTY_BGWRITER_DELAY,
        Postgres.JSON_PROPERTY_BGWRITER_FLUSH_AFTER, Postgres.JSON_PROPERTY_BGWRITER_LRU_MAXPAGES,
        Postgres.JSON_PROPERTY_BGWRITER_LRU_MULTIPLIER, Postgres.JSON_PROPERTY_DEADLOCK_TIMEOUT,
        Postgres.JSON_PROPERTY_DEFAULT_TOAST_COMPRESSION, Postgres.JSON_PROPERTY_IDLE_IN_TRANSACTION_SESSION_TIMEOUT,
        Postgres.JSON_PROPERTY_JIT, Postgres.JSON_PROPERTY_LOG_AUTOVACUUM_MIN_DURATION,
        Postgres.JSON_PROPERTY_LOG_ERROR_VERBOSITY, Postgres.JSON_PROPERTY_LOG_LINE_PREFIX,
        Postgres.JSON_PROPERTY_LOG_MIN_DURATION_STATEMENT, Postgres.JSON_PROPERTY_MAX_FILES_PER_PROCESS,
        Postgres.JSON_PROPERTY_MAX_PREPARED_TRANSACTIONS, Postgres.JSON_PROPERTY_MAX_PRED_LOCKS_PER_TRANSACTION,
        Postgres.JSON_PROPERTY_MAX_LOCKS_PER_TRANSACTION, Postgres.JSON_PROPERTY_MAX_STACK_DEPTH,
        Postgres.JSON_PROPERTY_MAX_STANDBY_ARCHIVE_DELAY, Postgres.JSON_PROPERTY_MAX_STANDBY_STREAMING_DELAY,
        Postgres.JSON_PROPERTY_MAX_REPLICATION_SLOTS, Postgres.JSON_PROPERTY_MAX_LOGICAL_REPLICATION_WORKERS,
        Postgres.JSON_PROPERTY_MAX_PARALLEL_WORKERS, Postgres.JSON_PROPERTY_MAX_PARALLEL_WORKERS_PER_GATHER,
        Postgres.JSON_PROPERTY_MAX_WORKER_PROCESSES, Postgres.JSON_PROPERTY_PG_PARTMAN_BGW_ROLE,
        Postgres.JSON_PROPERTY_PG_PARTMAN_BGW_INTERVAL, Postgres.JSON_PROPERTY_PG_STAT_STATEMENTS_TRACK,
        Postgres.JSON_PROPERTY_TEMP_FILE_LIMIT, Postgres.JSON_PROPERTY_TIMEZONE,
        Postgres.JSON_PROPERTY_TRACK_ACTIVITY_QUERY_SIZE, Postgres.JSON_PROPERTY_TRACK_COMMIT_TIMESTAMP,
        Postgres.JSON_PROPERTY_TRACK_FUNCTIONS, Postgres.JSON_PROPERTY_TRACK_IO_TIMING,
        Postgres.JSON_PROPERTY_MAX_WAL_SENDERS, Postgres.JSON_PROPERTY_WAL_SENDER_TIMEOUT,
        Postgres.JSON_PROPERTY_WAL_WRITER_DELAY, Postgres.JSON_PROPERTY_SHARED_BUFFERS_PERCENTAGE,
        Postgres.JSON_PROPERTY_PGBOUNCER })
public class Postgres {
    public static final String JSON_PROPERTY_AUTOVACUUM_FREEZE_MAX_AGE = "autovacuum_freeze_max_age";
    private Integer autovacuumFreezeMaxAge;

    public static final String JSON_PROPERTY_AUTOVACUUM_MAX_WORKERS = "autovacuum_max_workers";
    private Integer autovacuumMaxWorkers;

    public static final String JSON_PROPERTY_AUTOVACUUM_NAPTIME = "autovacuum_naptime";
    private Integer autovacuumNaptime;

    public static final String JSON_PROPERTY_AUTOVACUUM_VACUUM_THRESHOLD = "autovacuum_vacuum_threshold";
    private Integer autovacuumVacuumThreshold;

    public static final String JSON_PROPERTY_AUTOVACUUM_ANALYZE_THRESHOLD = "autovacuum_analyze_threshold";
    private Integer autovacuumAnalyzeThreshold;

    public static final String JSON_PROPERTY_AUTOVACUUM_VACUUM_SCALE_FACTOR = "autovacuum_vacuum_scale_factor";
    private BigDecimal autovacuumVacuumScaleFactor;

    public static final String JSON_PROPERTY_AUTOVACUUM_ANALYZE_SCALE_FACTOR = "autovacuum_analyze_scale_factor";
    private BigDecimal autovacuumAnalyzeScaleFactor;

    public static final String JSON_PROPERTY_AUTOVACUUM_VACUUM_COST_DELAY = "autovacuum_vacuum_cost_delay";
    private Integer autovacuumVacuumCostDelay;

    public static final String JSON_PROPERTY_AUTOVACUUM_VACUUM_COST_LIMIT = "autovacuum_vacuum_cost_limit";
    private Integer autovacuumVacuumCostLimit;

    public static final String JSON_PROPERTY_BACKUP_HOUR = "backup_hour";
    private Integer backupHour;

    public static final String JSON_PROPERTY_BACKUP_MINUTE = "backup_minute";
    private Integer backupMinute;

    public static final String JSON_PROPERTY_BGWRITER_DELAY = "bgwriter_delay";
    private Integer bgwriterDelay;

    public static final String JSON_PROPERTY_BGWRITER_FLUSH_AFTER = "bgwriter_flush_after";
    private Integer bgwriterFlushAfter;

    public static final String JSON_PROPERTY_BGWRITER_LRU_MAXPAGES = "bgwriter_lru_maxpages";
    private Integer bgwriterLruMaxpages;

    public static final String JSON_PROPERTY_BGWRITER_LRU_MULTIPLIER = "bgwriter_lru_multiplier";
    private BigDecimal bgwriterLruMultiplier;

    public static final String JSON_PROPERTY_DEADLOCK_TIMEOUT = "deadlock_timeout";
    private Integer deadlockTimeout;

    /**
     * Specifies the default TOAST compression method for values of compressible
     * columns (the default is lz4).
     */
    public enum DefaultToastCompressionEnum {
        LZ4("lz4"),

        PGLZ("pglz");

        private String value;

        DefaultToastCompressionEnum(String value) {
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
        public static DefaultToastCompressionEnum fromValue(String value) {
            for (DefaultToastCompressionEnum b : DefaultToastCompressionEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_DEFAULT_TOAST_COMPRESSION = "default_toast_compression";
    private DefaultToastCompressionEnum defaultToastCompression;

    public static final String JSON_PROPERTY_IDLE_IN_TRANSACTION_SESSION_TIMEOUT = "idle_in_transaction_session_timeout";
    private Integer idleInTransactionSessionTimeout;

    public static final String JSON_PROPERTY_JIT = "jit";
    private Boolean jit;

    public static final String JSON_PROPERTY_LOG_AUTOVACUUM_MIN_DURATION = "log_autovacuum_min_duration";
    private Integer logAutovacuumMinDuration;

    /**
     * Controls the amount of detail written in the server log for each message that
     * is logged.
     */
    public enum LogErrorVerbosityEnum {
        TERSE("TERSE"),

        DEFAULT("DEFAULT"),

        VERBOSE("VERBOSE");

        private String value;

        LogErrorVerbosityEnum(String value) {
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
        public static LogErrorVerbosityEnum fromValue(String value) {
            for (LogErrorVerbosityEnum b : LogErrorVerbosityEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_LOG_ERROR_VERBOSITY = "log_error_verbosity";
    private LogErrorVerbosityEnum logErrorVerbosity;

    /**
     * Selects one of the available log-formats. These can support popular log
     * analyzers like pgbadger, pganalyze, etc.
     */
    public enum LogLinePrefixEnum {
        PID_P_USER_U_DB_D_APP_A_CLIENT_H("pid=%p,user=%u,db=%d,app=%a,client=%h"),

        _M_P_Q_USER_U_DB_D_APP_A_("%m [%p] %q[user=%u,db=%d,app=%a]"),

        _T_P_L_1_USER_U_DB_D_APP_A_CLIENT_H("%t [%p]: [%l-1] user=%u,db=%d,app=%a,client=%h");

        private String value;

        LogLinePrefixEnum(String value) {
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
        public static LogLinePrefixEnum fromValue(String value) {
            for (LogLinePrefixEnum b : LogLinePrefixEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_LOG_LINE_PREFIX = "log_line_prefix";
    private LogLinePrefixEnum logLinePrefix;

    public static final String JSON_PROPERTY_LOG_MIN_DURATION_STATEMENT = "log_min_duration_statement";
    private Integer logMinDurationStatement;

    public static final String JSON_PROPERTY_MAX_FILES_PER_PROCESS = "max_files_per_process";
    private Integer maxFilesPerProcess;

    public static final String JSON_PROPERTY_MAX_PREPARED_TRANSACTIONS = "max_prepared_transactions";
    private Integer maxPreparedTransactions;

    public static final String JSON_PROPERTY_MAX_PRED_LOCKS_PER_TRANSACTION = "max_pred_locks_per_transaction";
    private Integer maxPredLocksPerTransaction;

    public static final String JSON_PROPERTY_MAX_LOCKS_PER_TRANSACTION = "max_locks_per_transaction";
    private Integer maxLocksPerTransaction;

    public static final String JSON_PROPERTY_MAX_STACK_DEPTH = "max_stack_depth";
    private Integer maxStackDepth;

    public static final String JSON_PROPERTY_MAX_STANDBY_ARCHIVE_DELAY = "max_standby_archive_delay";
    private Integer maxStandbyArchiveDelay;

    public static final String JSON_PROPERTY_MAX_STANDBY_STREAMING_DELAY = "max_standby_streaming_delay";
    private Integer maxStandbyStreamingDelay;

    public static final String JSON_PROPERTY_MAX_REPLICATION_SLOTS = "max_replication_slots";
    private Integer maxReplicationSlots;

    public static final String JSON_PROPERTY_MAX_LOGICAL_REPLICATION_WORKERS = "max_logical_replication_workers";
    private Integer maxLogicalReplicationWorkers;

    public static final String JSON_PROPERTY_MAX_PARALLEL_WORKERS = "max_parallel_workers";
    private Integer maxParallelWorkers;

    public static final String JSON_PROPERTY_MAX_PARALLEL_WORKERS_PER_GATHER = "max_parallel_workers_per_gather";
    private Integer maxParallelWorkersPerGather;

    public static final String JSON_PROPERTY_MAX_WORKER_PROCESSES = "max_worker_processes";
    private Integer maxWorkerProcesses;

    public static final String JSON_PROPERTY_PG_PARTMAN_BGW_ROLE = "pg_partman_bgw.role";
    private String pgPartmanBgwRole;

    public static final String JSON_PROPERTY_PG_PARTMAN_BGW_INTERVAL = "pg_partman_bgw.interval";
    private Integer pgPartmanBgwInterval;

    /**
     * Controls which statements are counted. Specify &#39;top&#39; to track
     * top-level statements (those issued directly by clients), &#39;all&#39; to
     * also track nested statements (such as statements invoked within functions),
     * or &#39;none&#39; to disable statement statistics collection. The default
     * value is top.
     */
    public enum PgStatStatementsTrackEnum {
        ALL("all"),

        TOP("top"),

        NONE("none");

        private String value;

        PgStatStatementsTrackEnum(String value) {
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
        public static PgStatStatementsTrackEnum fromValue(String value) {
            for (PgStatStatementsTrackEnum b : PgStatStatementsTrackEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_PG_STAT_STATEMENTS_TRACK = "pg_stat_statements.track";
    private PgStatStatementsTrackEnum pgStatStatementsTrack;

    public static final String JSON_PROPERTY_TEMP_FILE_LIMIT = "temp_file_limit";
    private Integer tempFileLimit;

    public static final String JSON_PROPERTY_TIMEZONE = "timezone";
    private String timezone;

    public static final String JSON_PROPERTY_TRACK_ACTIVITY_QUERY_SIZE = "track_activity_query_size";
    private Integer trackActivityQuerySize;

    /**
     * Record commit time of transactions.
     */
    public enum TrackCommitTimestampEnum {
        OFF("off"),

        ON("on");

        private String value;

        TrackCommitTimestampEnum(String value) {
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
        public static TrackCommitTimestampEnum fromValue(String value) {
            for (TrackCommitTimestampEnum b : TrackCommitTimestampEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_TRACK_COMMIT_TIMESTAMP = "track_commit_timestamp";
    private TrackCommitTimestampEnum trackCommitTimestamp;

    /**
     * Enables tracking of function call counts and time used.
     */
    public enum TrackFunctionsEnum {
        ALL("all"),

        PL("pl"),

        NONE("none");

        private String value;

        TrackFunctionsEnum(String value) {
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
        public static TrackFunctionsEnum fromValue(String value) {
            for (TrackFunctionsEnum b : TrackFunctionsEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_TRACK_FUNCTIONS = "track_functions";
    private TrackFunctionsEnum trackFunctions;

    /**
     * Enables timing of database I/O calls. This parameter is off by default,
     * because it will repeatedly query the operating system for the current time,
     * which may cause significant overhead on some platforms.
     */
    public enum TrackIoTimingEnum {
        OFF("off"),

        ON("on");

        private String value;

        TrackIoTimingEnum(String value) {
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
        public static TrackIoTimingEnum fromValue(String value) {
            for (TrackIoTimingEnum b : TrackIoTimingEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_TRACK_IO_TIMING = "track_io_timing";
    private TrackIoTimingEnum trackIoTiming;

    public static final String JSON_PROPERTY_MAX_WAL_SENDERS = "max_wal_senders";
    private Integer maxWalSenders;

    public static final String JSON_PROPERTY_WAL_SENDER_TIMEOUT = "wal_sender_timeout";
    private Integer walSenderTimeout;

    public static final String JSON_PROPERTY_WAL_WRITER_DELAY = "wal_writer_delay";
    private Integer walWriterDelay;

    public static final String JSON_PROPERTY_SHARED_BUFFERS_PERCENTAGE = "shared_buffers_percentage";
    private BigDecimal sharedBuffersPercentage;

    public static final String JSON_PROPERTY_PGBOUNCER = "pgbouncer";
    private Pgbouncer pgbouncer;

    public Postgres() {
    }

    public Postgres autovacuumFreezeMaxAge(Integer autovacuumFreezeMaxAge) {
        this.autovacuumFreezeMaxAge = autovacuumFreezeMaxAge;
        return this;
    }

    /**
     * Specifies the maximum age (in transactions) that a table&#39;s
     * pg_class.relfrozenxid field can attain before a VACUUM operation is forced to
     * prevent transaction ID wraparound within the table. Note that the system will
     * launch autovacuum processes to prevent wraparound even when autovacuum is
     * otherwise disabled. This parameter will cause the server to be restarted.
     * minimum: 200000000 maximum: 1500000000
     *
     * @return autovacuumFreezeMaxAge
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_AUTOVACUUM_FREEZE_MAX_AGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Integer getAutovacuumFreezeMaxAge() {
        return autovacuumFreezeMaxAge;
    }

    @JsonProperty(JSON_PROPERTY_AUTOVACUUM_FREEZE_MAX_AGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAutovacuumFreezeMaxAge(Integer autovacuumFreezeMaxAge) {
        this.autovacuumFreezeMaxAge = autovacuumFreezeMaxAge;
    }

    public Postgres autovacuumMaxWorkers(Integer autovacuumMaxWorkers) {
        this.autovacuumMaxWorkers = autovacuumMaxWorkers;
        return this;
    }

    /**
     * Specifies the maximum number of autovacuum processes (other than the
     * autovacuum launcher) that may be running at any one time. The default is
     * three. This parameter can only be set at server start. minimum: 1 maximum: 20
     *
     * @return autovacuumMaxWorkers
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_AUTOVACUUM_MAX_WORKERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Integer getAutovacuumMaxWorkers() {
        return autovacuumMaxWorkers;
    }

    @JsonProperty(JSON_PROPERTY_AUTOVACUUM_MAX_WORKERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAutovacuumMaxWorkers(Integer autovacuumMaxWorkers) {
        this.autovacuumMaxWorkers = autovacuumMaxWorkers;
    }

    public Postgres autovacuumNaptime(Integer autovacuumNaptime) {
        this.autovacuumNaptime = autovacuumNaptime;
        return this;
    }

    /**
     * Specifies the minimum delay, in seconds, between autovacuum runs on any given
     * database. The default is one minute. minimum: 0 maximum: 86400
     *
     * @return autovacuumNaptime
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_AUTOVACUUM_NAPTIME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Integer getAutovacuumNaptime() {
        return autovacuumNaptime;
    }

    @JsonProperty(JSON_PROPERTY_AUTOVACUUM_NAPTIME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAutovacuumNaptime(Integer autovacuumNaptime) {
        this.autovacuumNaptime = autovacuumNaptime;
    }

    public Postgres autovacuumVacuumThreshold(Integer autovacuumVacuumThreshold) {
        this.autovacuumVacuumThreshold = autovacuumVacuumThreshold;
        return this;
    }

    /**
     * Specifies the minimum number of updated or deleted tuples needed to trigger a
     * VACUUM in any one table. The default is 50 tuples. minimum: 0 maximum:
     * 2147483647
     *
     * @return autovacuumVacuumThreshold
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_AUTOVACUUM_VACUUM_THRESHOLD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getAutovacuumVacuumThreshold() {
        return autovacuumVacuumThreshold;
    }

    @JsonProperty(JSON_PROPERTY_AUTOVACUUM_VACUUM_THRESHOLD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAutovacuumVacuumThreshold(Integer autovacuumVacuumThreshold) {
        this.autovacuumVacuumThreshold = autovacuumVacuumThreshold;
    }

    public Postgres autovacuumAnalyzeThreshold(Integer autovacuumAnalyzeThreshold) {
        this.autovacuumAnalyzeThreshold = autovacuumAnalyzeThreshold;
        return this;
    }

    /**
     * Specifies the minimum number of inserted, updated, or deleted tuples needed
     * to trigger an ANALYZE in any one table. The default is 50 tuples. minimum: 0
     * maximum: 2147483647
     *
     * @return autovacuumAnalyzeThreshold
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_AUTOVACUUM_ANALYZE_THRESHOLD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getAutovacuumAnalyzeThreshold() {
        return autovacuumAnalyzeThreshold;
    }

    @JsonProperty(JSON_PROPERTY_AUTOVACUUM_ANALYZE_THRESHOLD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAutovacuumAnalyzeThreshold(Integer autovacuumAnalyzeThreshold) {
        this.autovacuumAnalyzeThreshold = autovacuumAnalyzeThreshold;
    }

    public Postgres autovacuumVacuumScaleFactor(BigDecimal autovacuumVacuumScaleFactor) {
        this.autovacuumVacuumScaleFactor = autovacuumVacuumScaleFactor;
        return this;
    }

    /**
     * Specifies a fraction, in a decimal value, of the table size to add to
     * autovacuum_vacuum_threshold when deciding whether to trigger a VACUUM. The
     * default is 0.2 (20% of table size). minimum: 0 maximum: 1
     *
     * @return autovacuumVacuumScaleFactor
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_AUTOVACUUM_VACUUM_SCALE_FACTOR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public BigDecimal getAutovacuumVacuumScaleFactor() {
        return autovacuumVacuumScaleFactor;
    }

    @JsonProperty(JSON_PROPERTY_AUTOVACUUM_VACUUM_SCALE_FACTOR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAutovacuumVacuumScaleFactor(BigDecimal autovacuumVacuumScaleFactor) {
        this.autovacuumVacuumScaleFactor = autovacuumVacuumScaleFactor;
    }

    public Postgres autovacuumAnalyzeScaleFactor(BigDecimal autovacuumAnalyzeScaleFactor) {
        this.autovacuumAnalyzeScaleFactor = autovacuumAnalyzeScaleFactor;
        return this;
    }

    /**
     * Specifies a fraction, in a decimal value, of the table size to add to
     * autovacuum_analyze_threshold when deciding whether to trigger an ANALYZE. The
     * default is 0.2 (20% of table size). minimum: 0 maximum: 1
     *
     * @return autovacuumAnalyzeScaleFactor
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_AUTOVACUUM_ANALYZE_SCALE_FACTOR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public BigDecimal getAutovacuumAnalyzeScaleFactor() {
        return autovacuumAnalyzeScaleFactor;
    }

    @JsonProperty(JSON_PROPERTY_AUTOVACUUM_ANALYZE_SCALE_FACTOR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAutovacuumAnalyzeScaleFactor(BigDecimal autovacuumAnalyzeScaleFactor) {
        this.autovacuumAnalyzeScaleFactor = autovacuumAnalyzeScaleFactor;
    }

    public Postgres autovacuumVacuumCostDelay(Integer autovacuumVacuumCostDelay) {
        this.autovacuumVacuumCostDelay = autovacuumVacuumCostDelay;
        return this;
    }

    /**
     * Specifies the cost delay value, in milliseconds, that will be used in
     * automatic VACUUM operations. If -1, uses the regular vacuum_cost_delay value,
     * which is 20 milliseconds. minimum: -1 maximum: 100
     *
     * @return autovacuumVacuumCostDelay
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_AUTOVACUUM_VACUUM_COST_DELAY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getAutovacuumVacuumCostDelay() {
        return autovacuumVacuumCostDelay;
    }

    @JsonProperty(JSON_PROPERTY_AUTOVACUUM_VACUUM_COST_DELAY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAutovacuumVacuumCostDelay(Integer autovacuumVacuumCostDelay) {
        this.autovacuumVacuumCostDelay = autovacuumVacuumCostDelay;
    }

    public Postgres autovacuumVacuumCostLimit(Integer autovacuumVacuumCostLimit) {
        this.autovacuumVacuumCostLimit = autovacuumVacuumCostLimit;
        return this;
    }

    /**
     * Specifies the cost limit value that will be used in automatic VACUUM
     * operations. If -1 is specified (which is the default), the regular
     * vacuum_cost_limit value will be used. minimum: -1 maximum: 10000
     *
     * @return autovacuumVacuumCostLimit
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_AUTOVACUUM_VACUUM_COST_LIMIT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getAutovacuumVacuumCostLimit() {
        return autovacuumVacuumCostLimit;
    }

    @JsonProperty(JSON_PROPERTY_AUTOVACUUM_VACUUM_COST_LIMIT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAutovacuumVacuumCostLimit(Integer autovacuumVacuumCostLimit) {
        this.autovacuumVacuumCostLimit = autovacuumVacuumCostLimit;
    }

    public Postgres backupHour(Integer backupHour) {
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

    public Postgres backupMinute(Integer backupMinute) {
        this.backupMinute = backupMinute;
        return this;
    }

    /**
     * The minute of the backup hour when backup for the service starts. New backup
     * is only started if previous backup has already completed. minimum: 0 maximum:
     * 59
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

    public Postgres bgwriterDelay(Integer bgwriterDelay) {
        this.bgwriterDelay = bgwriterDelay;
        return this;
    }

    /**
     * Specifies the delay, in milliseconds, between activity rounds for the
     * background writer. Default is 200 ms. minimum: 10 maximum: 10000
     *
     * @return bgwriterDelay
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_BGWRITER_DELAY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getBgwriterDelay() {
        return bgwriterDelay;
    }

    @JsonProperty(JSON_PROPERTY_BGWRITER_DELAY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setBgwriterDelay(Integer bgwriterDelay) {
        this.bgwriterDelay = bgwriterDelay;
    }

    public Postgres bgwriterFlushAfter(Integer bgwriterFlushAfter) {
        this.bgwriterFlushAfter = bgwriterFlushAfter;
        return this;
    }

    /**
     * The amount of kilobytes that need to be written by the background writer
     * before attempting to force the OS to issue these writes to underlying
     * storage. Specified in kilobytes, default is 512. Setting of 0 disables forced
     * writeback. minimum: 0 maximum: 2048
     *
     * @return bgwriterFlushAfter
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_BGWRITER_FLUSH_AFTER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getBgwriterFlushAfter() {
        return bgwriterFlushAfter;
    }

    @JsonProperty(JSON_PROPERTY_BGWRITER_FLUSH_AFTER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setBgwriterFlushAfter(Integer bgwriterFlushAfter) {
        this.bgwriterFlushAfter = bgwriterFlushAfter;
    }

    public Postgres bgwriterLruMaxpages(Integer bgwriterLruMaxpages) {
        this.bgwriterLruMaxpages = bgwriterLruMaxpages;
        return this;
    }

    /**
     * The maximum number of buffers that the background writer can write. Setting
     * this to zero disables background writing. Default is 100. minimum: 0 maximum:
     * 1073741823
     *
     * @return bgwriterLruMaxpages
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_BGWRITER_LRU_MAXPAGES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getBgwriterLruMaxpages() {
        return bgwriterLruMaxpages;
    }

    @JsonProperty(JSON_PROPERTY_BGWRITER_LRU_MAXPAGES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setBgwriterLruMaxpages(Integer bgwriterLruMaxpages) {
        this.bgwriterLruMaxpages = bgwriterLruMaxpages;
    }

    public Postgres bgwriterLruMultiplier(BigDecimal bgwriterLruMultiplier) {
        this.bgwriterLruMultiplier = bgwriterLruMultiplier;
        return this;
    }

    /**
     * The average recent need for new buffers is multiplied by
     * bgwriter_lru_multiplier to arrive at an estimate of the number that will be
     * needed during the next round, (up to bgwriter_lru_maxpages). 1.0 represents a
     * “just in time” policy of writing exactly the number of buffers predicted to
     * be needed. Larger values provide some cushion against spikes in demand, while
     * smaller values intentionally leave writes to be done by server processes. The
     * default is 2.0. minimum: 0 maximum: 10
     *
     * @return bgwriterLruMultiplier
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_BGWRITER_LRU_MULTIPLIER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public BigDecimal getBgwriterLruMultiplier() {
        return bgwriterLruMultiplier;
    }

    @JsonProperty(JSON_PROPERTY_BGWRITER_LRU_MULTIPLIER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setBgwriterLruMultiplier(BigDecimal bgwriterLruMultiplier) {
        this.bgwriterLruMultiplier = bgwriterLruMultiplier;
    }

    public Postgres deadlockTimeout(Integer deadlockTimeout) {
        this.deadlockTimeout = deadlockTimeout;
        return this;
    }

    /**
     * The amount of time, in milliseconds, to wait on a lock before checking to see
     * if there is a deadlock condition. minimum: 500 maximum: 1800000
     *
     * @return deadlockTimeout
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DEADLOCK_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getDeadlockTimeout() {
        return deadlockTimeout;
    }

    @JsonProperty(JSON_PROPERTY_DEADLOCK_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDeadlockTimeout(Integer deadlockTimeout) {
        this.deadlockTimeout = deadlockTimeout;
    }

    public Postgres defaultToastCompression(DefaultToastCompressionEnum defaultToastCompression) {
        this.defaultToastCompression = defaultToastCompression;
        return this;
    }

    /**
     * Specifies the default TOAST compression method for values of compressible
     * columns (the default is lz4).
     *
     * @return defaultToastCompression
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DEFAULT_TOAST_COMPRESSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public DefaultToastCompressionEnum getDefaultToastCompression() {
        return defaultToastCompression;
    }

    @JsonProperty(JSON_PROPERTY_DEFAULT_TOAST_COMPRESSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDefaultToastCompression(DefaultToastCompressionEnum defaultToastCompression) {
        this.defaultToastCompression = defaultToastCompression;
    }

    public Postgres idleInTransactionSessionTimeout(Integer idleInTransactionSessionTimeout) {
        this.idleInTransactionSessionTimeout = idleInTransactionSessionTimeout;
        return this;
    }

    /**
     * Time out sessions with open transactions after this number of milliseconds
     * minimum: 0 maximum: 604800000
     *
     * @return idleInTransactionSessionTimeout
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_IDLE_IN_TRANSACTION_SESSION_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getIdleInTransactionSessionTimeout() {
        return idleInTransactionSessionTimeout;
    }

    @JsonProperty(JSON_PROPERTY_IDLE_IN_TRANSACTION_SESSION_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIdleInTransactionSessionTimeout(Integer idleInTransactionSessionTimeout) {
        this.idleInTransactionSessionTimeout = idleInTransactionSessionTimeout;
    }

    public Postgres jit(Boolean jit) {
        this.jit = jit;
        return this;
    }

    /**
     * Activates, in a boolean, the system-wide use of Just-in-Time Compilation
     * (JIT).
     *
     * @return jit
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_JIT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getJit() {
        return jit;
    }

    @JsonProperty(JSON_PROPERTY_JIT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setJit(Boolean jit) {
        this.jit = jit;
    }

    public Postgres logAutovacuumMinDuration(Integer logAutovacuumMinDuration) {
        this.logAutovacuumMinDuration = logAutovacuumMinDuration;
        return this;
    }

    /**
     * Causes each action executed by autovacuum to be logged if it ran for at least
     * the specified number of milliseconds. Setting this to zero logs all
     * autovacuum actions. Minus-one (the default) disables logging autovacuum
     * actions. minimum: -1 maximum: 2147483647
     *
     * @return logAutovacuumMinDuration
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LOG_AUTOVACUUM_MIN_DURATION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getLogAutovacuumMinDuration() {
        return logAutovacuumMinDuration;
    }

    @JsonProperty(JSON_PROPERTY_LOG_AUTOVACUUM_MIN_DURATION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLogAutovacuumMinDuration(Integer logAutovacuumMinDuration) {
        this.logAutovacuumMinDuration = logAutovacuumMinDuration;
    }

    public Postgres logErrorVerbosity(LogErrorVerbosityEnum logErrorVerbosity) {
        this.logErrorVerbosity = logErrorVerbosity;
        return this;
    }

    /**
     * Controls the amount of detail written in the server log for each message that
     * is logged.
     *
     * @return logErrorVerbosity
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LOG_ERROR_VERBOSITY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public LogErrorVerbosityEnum getLogErrorVerbosity() {
        return logErrorVerbosity;
    }

    @JsonProperty(JSON_PROPERTY_LOG_ERROR_VERBOSITY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLogErrorVerbosity(LogErrorVerbosityEnum logErrorVerbosity) {
        this.logErrorVerbosity = logErrorVerbosity;
    }

    public Postgres logLinePrefix(LogLinePrefixEnum logLinePrefix) {
        this.logLinePrefix = logLinePrefix;
        return this;
    }

    /**
     * Selects one of the available log-formats. These can support popular log
     * analyzers like pgbadger, pganalyze, etc.
     *
     * @return logLinePrefix
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LOG_LINE_PREFIX)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public LogLinePrefixEnum getLogLinePrefix() {
        return logLinePrefix;
    }

    @JsonProperty(JSON_PROPERTY_LOG_LINE_PREFIX)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLogLinePrefix(LogLinePrefixEnum logLinePrefix) {
        this.logLinePrefix = logLinePrefix;
    }

    public Postgres logMinDurationStatement(Integer logMinDurationStatement) {
        this.logMinDurationStatement = logMinDurationStatement;
        return this;
    }

    /**
     * Log statements that take more than this number of milliseconds to run. If -1,
     * disables. minimum: -1 maximum: 86400000
     *
     * @return logMinDurationStatement
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LOG_MIN_DURATION_STATEMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getLogMinDurationStatement() {
        return logMinDurationStatement;
    }

    @JsonProperty(JSON_PROPERTY_LOG_MIN_DURATION_STATEMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLogMinDurationStatement(Integer logMinDurationStatement) {
        this.logMinDurationStatement = logMinDurationStatement;
    }

    public Postgres maxFilesPerProcess(Integer maxFilesPerProcess) {
        this.maxFilesPerProcess = maxFilesPerProcess;
        return this;
    }

    /**
     * PostgreSQL maximum number of files that can be open per process. minimum:
     * 1000 maximum: 4096
     *
     * @return maxFilesPerProcess
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MAX_FILES_PER_PROCESS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getMaxFilesPerProcess() {
        return maxFilesPerProcess;
    }

    @JsonProperty(JSON_PROPERTY_MAX_FILES_PER_PROCESS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMaxFilesPerProcess(Integer maxFilesPerProcess) {
        this.maxFilesPerProcess = maxFilesPerProcess;
    }

    public Postgres maxPreparedTransactions(Integer maxPreparedTransactions) {
        this.maxPreparedTransactions = maxPreparedTransactions;
        return this;
    }

    /**
     * PostgreSQL maximum prepared transactions. minimum: 0 maximum: 10000
     *
     * @return maxPreparedTransactions
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MAX_PREPARED_TRANSACTIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getMaxPreparedTransactions() {
        return maxPreparedTransactions;
    }

    @JsonProperty(JSON_PROPERTY_MAX_PREPARED_TRANSACTIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMaxPreparedTransactions(Integer maxPreparedTransactions) {
        this.maxPreparedTransactions = maxPreparedTransactions;
    }

    public Postgres maxPredLocksPerTransaction(Integer maxPredLocksPerTransaction) {
        this.maxPredLocksPerTransaction = maxPredLocksPerTransaction;
        return this;
    }

    /**
     * PostgreSQL maximum predicate locks per transaction. minimum: 64 maximum: 640
     *
     * @return maxPredLocksPerTransaction
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MAX_PRED_LOCKS_PER_TRANSACTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getMaxPredLocksPerTransaction() {
        return maxPredLocksPerTransaction;
    }

    @JsonProperty(JSON_PROPERTY_MAX_PRED_LOCKS_PER_TRANSACTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMaxPredLocksPerTransaction(Integer maxPredLocksPerTransaction) {
        this.maxPredLocksPerTransaction = maxPredLocksPerTransaction;
    }

    public Postgres maxLocksPerTransaction(Integer maxLocksPerTransaction) {
        this.maxLocksPerTransaction = maxLocksPerTransaction;
        return this;
    }

    /**
     * PostgreSQL maximum locks per transaction. minimum: 64 maximum: 6400
     *
     * @return maxLocksPerTransaction
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MAX_LOCKS_PER_TRANSACTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getMaxLocksPerTransaction() {
        return maxLocksPerTransaction;
    }

    @JsonProperty(JSON_PROPERTY_MAX_LOCKS_PER_TRANSACTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMaxLocksPerTransaction(Integer maxLocksPerTransaction) {
        this.maxLocksPerTransaction = maxLocksPerTransaction;
    }

    public Postgres maxStackDepth(Integer maxStackDepth) {
        this.maxStackDepth = maxStackDepth;
        return this;
    }

    /**
     * Maximum depth of the stack in bytes. minimum: 2097152 maximum: 6291456
     *
     * @return maxStackDepth
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MAX_STACK_DEPTH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getMaxStackDepth() {
        return maxStackDepth;
    }

    @JsonProperty(JSON_PROPERTY_MAX_STACK_DEPTH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMaxStackDepth(Integer maxStackDepth) {
        this.maxStackDepth = maxStackDepth;
    }

    public Postgres maxStandbyArchiveDelay(Integer maxStandbyArchiveDelay) {
        this.maxStandbyArchiveDelay = maxStandbyArchiveDelay;
        return this;
    }

    /**
     * Max standby archive delay in milliseconds. minimum: 1 maximum: 43200000
     *
     * @return maxStandbyArchiveDelay
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MAX_STANDBY_ARCHIVE_DELAY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getMaxStandbyArchiveDelay() {
        return maxStandbyArchiveDelay;
    }

    @JsonProperty(JSON_PROPERTY_MAX_STANDBY_ARCHIVE_DELAY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMaxStandbyArchiveDelay(Integer maxStandbyArchiveDelay) {
        this.maxStandbyArchiveDelay = maxStandbyArchiveDelay;
    }

    public Postgres maxStandbyStreamingDelay(Integer maxStandbyStreamingDelay) {
        this.maxStandbyStreamingDelay = maxStandbyStreamingDelay;
        return this;
    }

    /**
     * Max standby streaming delay in milliseconds. minimum: 1 maximum: 43200000
     *
     * @return maxStandbyStreamingDelay
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MAX_STANDBY_STREAMING_DELAY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getMaxStandbyStreamingDelay() {
        return maxStandbyStreamingDelay;
    }

    @JsonProperty(JSON_PROPERTY_MAX_STANDBY_STREAMING_DELAY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMaxStandbyStreamingDelay(Integer maxStandbyStreamingDelay) {
        this.maxStandbyStreamingDelay = maxStandbyStreamingDelay;
    }

    public Postgres maxReplicationSlots(Integer maxReplicationSlots) {
        this.maxReplicationSlots = maxReplicationSlots;
        return this;
    }

    /**
     * PostgreSQL maximum replication slots. minimum: 8 maximum: 64
     *
     * @return maxReplicationSlots
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MAX_REPLICATION_SLOTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getMaxReplicationSlots() {
        return maxReplicationSlots;
    }

    @JsonProperty(JSON_PROPERTY_MAX_REPLICATION_SLOTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMaxReplicationSlots(Integer maxReplicationSlots) {
        this.maxReplicationSlots = maxReplicationSlots;
    }

    public Postgres maxLogicalReplicationWorkers(Integer maxLogicalReplicationWorkers) {
        this.maxLogicalReplicationWorkers = maxLogicalReplicationWorkers;
        return this;
    }

    /**
     * PostgreSQL maximum logical replication workers (taken from the pool of
     * max_parallel_workers). minimum: 4 maximum: 64
     *
     * @return maxLogicalReplicationWorkers
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MAX_LOGICAL_REPLICATION_WORKERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getMaxLogicalReplicationWorkers() {
        return maxLogicalReplicationWorkers;
    }

    @JsonProperty(JSON_PROPERTY_MAX_LOGICAL_REPLICATION_WORKERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMaxLogicalReplicationWorkers(Integer maxLogicalReplicationWorkers) {
        this.maxLogicalReplicationWorkers = maxLogicalReplicationWorkers;
    }

    public Postgres maxParallelWorkers(Integer maxParallelWorkers) {
        this.maxParallelWorkers = maxParallelWorkers;
        return this;
    }

    /**
     * Sets the maximum number of workers that the system can support for parallel
     * queries. minimum: 0 maximum: 96
     *
     * @return maxParallelWorkers
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MAX_PARALLEL_WORKERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getMaxParallelWorkers() {
        return maxParallelWorkers;
    }

    @JsonProperty(JSON_PROPERTY_MAX_PARALLEL_WORKERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMaxParallelWorkers(Integer maxParallelWorkers) {
        this.maxParallelWorkers = maxParallelWorkers;
    }

    public Postgres maxParallelWorkersPerGather(Integer maxParallelWorkersPerGather) {
        this.maxParallelWorkersPerGather = maxParallelWorkersPerGather;
        return this;
    }

    /**
     * Sets the maximum number of workers that can be started by a single Gather or
     * Gather Merge node. minimum: 0 maximum: 96
     *
     * @return maxParallelWorkersPerGather
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MAX_PARALLEL_WORKERS_PER_GATHER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getMaxParallelWorkersPerGather() {
        return maxParallelWorkersPerGather;
    }

    @JsonProperty(JSON_PROPERTY_MAX_PARALLEL_WORKERS_PER_GATHER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMaxParallelWorkersPerGather(Integer maxParallelWorkersPerGather) {
        this.maxParallelWorkersPerGather = maxParallelWorkersPerGather;
    }

    public Postgres maxWorkerProcesses(Integer maxWorkerProcesses) {
        this.maxWorkerProcesses = maxWorkerProcesses;
        return this;
    }

    /**
     * Sets the maximum number of background processes that the system can support.
     * minimum: 8 maximum: 96
     *
     * @return maxWorkerProcesses
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MAX_WORKER_PROCESSES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getMaxWorkerProcesses() {
        return maxWorkerProcesses;
    }

    @JsonProperty(JSON_PROPERTY_MAX_WORKER_PROCESSES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMaxWorkerProcesses(Integer maxWorkerProcesses) {
        this.maxWorkerProcesses = maxWorkerProcesses;
    }

    public Postgres pgPartmanBgwRole(String pgPartmanBgwRole) {
        this.pgPartmanBgwRole = pgPartmanBgwRole;
        return this;
    }

    /**
     * Controls which role to use for pg_partman&#39;s scheduled background tasks.
     * Must consist of alpha-numeric characters, dots, underscores, or dashes. May
     * not start with dash or dot. Maximum of 64 characters.
     *
     * @return pgPartmanBgwRole
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PG_PARTMAN_BGW_ROLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPgPartmanBgwRole() {
        return pgPartmanBgwRole;
    }

    @JsonProperty(JSON_PROPERTY_PG_PARTMAN_BGW_ROLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPgPartmanBgwRole(String pgPartmanBgwRole) {
        this.pgPartmanBgwRole = pgPartmanBgwRole;
    }

    public Postgres pgPartmanBgwInterval(Integer pgPartmanBgwInterval) {
        this.pgPartmanBgwInterval = pgPartmanBgwInterval;
        return this;
    }

    /**
     * Sets the time interval to run pg_partman&#39;s scheduled tasks. minimum: 3600
     * maximum: 604800
     *
     * @return pgPartmanBgwInterval
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PG_PARTMAN_BGW_INTERVAL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getPgPartmanBgwInterval() {
        return pgPartmanBgwInterval;
    }

    @JsonProperty(JSON_PROPERTY_PG_PARTMAN_BGW_INTERVAL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPgPartmanBgwInterval(Integer pgPartmanBgwInterval) {
        this.pgPartmanBgwInterval = pgPartmanBgwInterval;
    }

    public Postgres pgStatStatementsTrack(PgStatStatementsTrackEnum pgStatStatementsTrack) {
        this.pgStatStatementsTrack = pgStatStatementsTrack;
        return this;
    }

    /**
     * Controls which statements are counted. Specify &#39;top&#39; to track
     * top-level statements (those issued directly by clients), &#39;all&#39; to
     * also track nested statements (such as statements invoked within functions),
     * or &#39;none&#39; to disable statement statistics collection. The default
     * value is top.
     *
     * @return pgStatStatementsTrack
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PG_STAT_STATEMENTS_TRACK)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public PgStatStatementsTrackEnum getPgStatStatementsTrack() {
        return pgStatStatementsTrack;
    }

    @JsonProperty(JSON_PROPERTY_PG_STAT_STATEMENTS_TRACK)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPgStatStatementsTrack(PgStatStatementsTrackEnum pgStatStatementsTrack) {
        this.pgStatStatementsTrack = pgStatStatementsTrack;
    }

    public Postgres tempFileLimit(Integer tempFileLimit) {
        this.tempFileLimit = tempFileLimit;
        return this;
    }

    /**
     * PostgreSQL temporary file limit in KiB. If -1, sets to unlimited. minimum: -1
     * maximum: 2147483647
     *
     * @return tempFileLimit
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TEMP_FILE_LIMIT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getTempFileLimit() {
        return tempFileLimit;
    }

    @JsonProperty(JSON_PROPERTY_TEMP_FILE_LIMIT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTempFileLimit(Integer tempFileLimit) {
        this.tempFileLimit = tempFileLimit;
    }

    public Postgres timezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    /**
     * PostgreSQL service timezone
     *
     * @return timezone
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TIMEZONE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTimezone() {
        return timezone;
    }

    @JsonProperty(JSON_PROPERTY_TIMEZONE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Postgres trackActivityQuerySize(Integer trackActivityQuerySize) {
        this.trackActivityQuerySize = trackActivityQuerySize;
        return this;
    }

    /**
     * Specifies the number of bytes reserved to track the currently executing
     * command for each active session. minimum: 1024 maximum: 10240
     *
     * @return trackActivityQuerySize
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TRACK_ACTIVITY_QUERY_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getTrackActivityQuerySize() {
        return trackActivityQuerySize;
    }

    @JsonProperty(JSON_PROPERTY_TRACK_ACTIVITY_QUERY_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTrackActivityQuerySize(Integer trackActivityQuerySize) {
        this.trackActivityQuerySize = trackActivityQuerySize;
    }

    public Postgres trackCommitTimestamp(TrackCommitTimestampEnum trackCommitTimestamp) {
        this.trackCommitTimestamp = trackCommitTimestamp;
        return this;
    }

    /**
     * Record commit time of transactions.
     *
     * @return trackCommitTimestamp
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TRACK_COMMIT_TIMESTAMP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public TrackCommitTimestampEnum getTrackCommitTimestamp() {
        return trackCommitTimestamp;
    }

    @JsonProperty(JSON_PROPERTY_TRACK_COMMIT_TIMESTAMP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTrackCommitTimestamp(TrackCommitTimestampEnum trackCommitTimestamp) {
        this.trackCommitTimestamp = trackCommitTimestamp;
    }

    public Postgres trackFunctions(TrackFunctionsEnum trackFunctions) {
        this.trackFunctions = trackFunctions;
        return this;
    }

    /**
     * Enables tracking of function call counts and time used.
     *
     * @return trackFunctions
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TRACK_FUNCTIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public TrackFunctionsEnum getTrackFunctions() {
        return trackFunctions;
    }

    @JsonProperty(JSON_PROPERTY_TRACK_FUNCTIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTrackFunctions(TrackFunctionsEnum trackFunctions) {
        this.trackFunctions = trackFunctions;
    }

    public Postgres trackIoTiming(TrackIoTimingEnum trackIoTiming) {
        this.trackIoTiming = trackIoTiming;
        return this;
    }

    /**
     * Enables timing of database I/O calls. This parameter is off by default,
     * because it will repeatedly query the operating system for the current time,
     * which may cause significant overhead on some platforms.
     *
     * @return trackIoTiming
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TRACK_IO_TIMING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public TrackIoTimingEnum getTrackIoTiming() {
        return trackIoTiming;
    }

    @JsonProperty(JSON_PROPERTY_TRACK_IO_TIMING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTrackIoTiming(TrackIoTimingEnum trackIoTiming) {
        this.trackIoTiming = trackIoTiming;
    }

    public Postgres maxWalSenders(Integer maxWalSenders) {
        this.maxWalSenders = maxWalSenders;
        return this;
    }

    /**
     * PostgreSQL maximum WAL senders minimum: 8 maximum: 64
     *
     * @return maxWalSenders
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MAX_WAL_SENDERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getMaxWalSenders() {
        return maxWalSenders;
    }

    @JsonProperty(JSON_PROPERTY_MAX_WAL_SENDERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMaxWalSenders(Integer maxWalSenders) {
        this.maxWalSenders = maxWalSenders;
    }

    public Postgres walSenderTimeout(Integer walSenderTimeout) {
        this.walSenderTimeout = walSenderTimeout;
        return this;
    }

    /**
     * Terminate replication connections that are inactive for longer than this
     * amount of time, in milliseconds. Setting this value to zero disables the
     * timeout. Must be either 0 or between 5000 and 10800000. minimum: 0 maximum:
     * 10800000
     *
     * @return walSenderTimeout
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_WAL_SENDER_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getWalSenderTimeout() {
        return walSenderTimeout;
    }

    @JsonProperty(JSON_PROPERTY_WAL_SENDER_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setWalSenderTimeout(Integer walSenderTimeout) {
        this.walSenderTimeout = walSenderTimeout;
    }

    public Postgres walWriterDelay(Integer walWriterDelay) {
        this.walWriterDelay = walWriterDelay;
        return this;
    }

    /**
     * WAL flush interval in milliseconds. Note that setting this value to lower
     * than the default 200ms may negatively impact performance minimum: 10 maximum:
     * 200
     *
     * @return walWriterDelay
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_WAL_WRITER_DELAY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getWalWriterDelay() {
        return walWriterDelay;
    }

    @JsonProperty(JSON_PROPERTY_WAL_WRITER_DELAY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setWalWriterDelay(Integer walWriterDelay) {
        this.walWriterDelay = walWriterDelay;
    }

    public Postgres sharedBuffersPercentage(BigDecimal sharedBuffersPercentage) {
        this.sharedBuffersPercentage = sharedBuffersPercentage;
        return this;
    }

    /**
     * Percentage of total RAM that the database server uses for shared memory
     * buffers. Valid range is 20-60 (float), which corresponds to 20% - 60%. This
     * setting adjusts the shared_buffers configuration value. minimum: 20 maximum:
     * 60
     *
     * @return sharedBuffersPercentage
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SHARED_BUFFERS_PERCENTAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public BigDecimal getSharedBuffersPercentage() {
        return sharedBuffersPercentage;
    }

    @JsonProperty(JSON_PROPERTY_SHARED_BUFFERS_PERCENTAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSharedBuffersPercentage(BigDecimal sharedBuffersPercentage) {
        this.sharedBuffersPercentage = sharedBuffersPercentage;
    }

    public Postgres pgbouncer(Pgbouncer pgbouncer) {
        this.pgbouncer = pgbouncer;
        return this;
    }

    /**
     * Get pgbouncer
     *
     * @return pgbouncer
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PGBOUNCER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Pgbouncer getPgbouncer() {
        return pgbouncer;
    }

    @JsonProperty(JSON_PROPERTY_PGBOUNCER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPgbouncer(Pgbouncer pgbouncer) {
        this.pgbouncer = pgbouncer;
    }

    /**
     * Return true if this postgres object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Postgres postgres = (Postgres) o;
        return Objects.equals(this.autovacuumFreezeMaxAge, postgres.autovacuumFreezeMaxAge)
                && Objects.equals(this.autovacuumMaxWorkers, postgres.autovacuumMaxWorkers)
                && Objects.equals(this.autovacuumNaptime, postgres.autovacuumNaptime)
                && Objects.equals(this.autovacuumVacuumThreshold, postgres.autovacuumVacuumThreshold)
                && Objects.equals(this.autovacuumAnalyzeThreshold, postgres.autovacuumAnalyzeThreshold)
                && Objects.equals(this.autovacuumVacuumScaleFactor, postgres.autovacuumVacuumScaleFactor)
                && Objects.equals(this.autovacuumAnalyzeScaleFactor, postgres.autovacuumAnalyzeScaleFactor)
                && Objects.equals(this.autovacuumVacuumCostDelay, postgres.autovacuumVacuumCostDelay)
                && Objects.equals(this.autovacuumVacuumCostLimit, postgres.autovacuumVacuumCostLimit)
                && Objects.equals(this.backupHour, postgres.backupHour)
                && Objects.equals(this.backupMinute, postgres.backupMinute)
                && Objects.equals(this.bgwriterDelay, postgres.bgwriterDelay)
                && Objects.equals(this.bgwriterFlushAfter, postgres.bgwriterFlushAfter)
                && Objects.equals(this.bgwriterLruMaxpages, postgres.bgwriterLruMaxpages)
                && Objects.equals(this.bgwriterLruMultiplier, postgres.bgwriterLruMultiplier)
                && Objects.equals(this.deadlockTimeout, postgres.deadlockTimeout)
                && Objects.equals(this.defaultToastCompression, postgres.defaultToastCompression)
                && Objects.equals(this.idleInTransactionSessionTimeout, postgres.idleInTransactionSessionTimeout)
                && Objects.equals(this.jit, postgres.jit)
                && Objects.equals(this.logAutovacuumMinDuration, postgres.logAutovacuumMinDuration)
                && Objects.equals(this.logErrorVerbosity, postgres.logErrorVerbosity)
                && Objects.equals(this.logLinePrefix, postgres.logLinePrefix)
                && Objects.equals(this.logMinDurationStatement, postgres.logMinDurationStatement)
                && Objects.equals(this.maxFilesPerProcess, postgres.maxFilesPerProcess)
                && Objects.equals(this.maxPreparedTransactions, postgres.maxPreparedTransactions)
                && Objects.equals(this.maxPredLocksPerTransaction, postgres.maxPredLocksPerTransaction)
                && Objects.equals(this.maxLocksPerTransaction, postgres.maxLocksPerTransaction)
                && Objects.equals(this.maxStackDepth, postgres.maxStackDepth)
                && Objects.equals(this.maxStandbyArchiveDelay, postgres.maxStandbyArchiveDelay)
                && Objects.equals(this.maxStandbyStreamingDelay, postgres.maxStandbyStreamingDelay)
                && Objects.equals(this.maxReplicationSlots, postgres.maxReplicationSlots)
                && Objects.equals(this.maxLogicalReplicationWorkers, postgres.maxLogicalReplicationWorkers)
                && Objects.equals(this.maxParallelWorkers, postgres.maxParallelWorkers)
                && Objects.equals(this.maxParallelWorkersPerGather, postgres.maxParallelWorkersPerGather)
                && Objects.equals(this.maxWorkerProcesses, postgres.maxWorkerProcesses)
                && Objects.equals(this.pgPartmanBgwRole, postgres.pgPartmanBgwRole)
                && Objects.equals(this.pgPartmanBgwInterval, postgres.pgPartmanBgwInterval)
                && Objects.equals(this.pgStatStatementsTrack, postgres.pgStatStatementsTrack)
                && Objects.equals(this.tempFileLimit, postgres.tempFileLimit)
                && Objects.equals(this.timezone, postgres.timezone)
                && Objects.equals(this.trackActivityQuerySize, postgres.trackActivityQuerySize)
                && Objects.equals(this.trackCommitTimestamp, postgres.trackCommitTimestamp)
                && Objects.equals(this.trackFunctions, postgres.trackFunctions)
                && Objects.equals(this.trackIoTiming, postgres.trackIoTiming)
                && Objects.equals(this.maxWalSenders, postgres.maxWalSenders)
                && Objects.equals(this.walSenderTimeout, postgres.walSenderTimeout)
                && Objects.equals(this.walWriterDelay, postgres.walWriterDelay)
                && Objects.equals(this.sharedBuffersPercentage, postgres.sharedBuffersPercentage)
                && Objects.equals(this.pgbouncer, postgres.pgbouncer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autovacuumFreezeMaxAge, autovacuumMaxWorkers, autovacuumNaptime, autovacuumVacuumThreshold,
                autovacuumAnalyzeThreshold, autovacuumVacuumScaleFactor, autovacuumAnalyzeScaleFactor,
                autovacuumVacuumCostDelay, autovacuumVacuumCostLimit, backupHour, backupMinute, bgwriterDelay,
                bgwriterFlushAfter, bgwriterLruMaxpages, bgwriterLruMultiplier, deadlockTimeout,
                defaultToastCompression, idleInTransactionSessionTimeout, jit, logAutovacuumMinDuration,
                logErrorVerbosity, logLinePrefix, logMinDurationStatement, maxFilesPerProcess, maxPreparedTransactions,
                maxPredLocksPerTransaction, maxLocksPerTransaction, maxStackDepth, maxStandbyArchiveDelay,
                maxStandbyStreamingDelay, maxReplicationSlots, maxLogicalReplicationWorkers, maxParallelWorkers,
                maxParallelWorkersPerGather, maxWorkerProcesses, pgPartmanBgwRole, pgPartmanBgwInterval,
                pgStatStatementsTrack, tempFileLimit, timezone, trackActivityQuerySize, trackCommitTimestamp,
                trackFunctions, trackIoTiming, maxWalSenders, walSenderTimeout, walWriterDelay, sharedBuffersPercentage,
                pgbouncer);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Postgres {\n");
        sb.append("    autovacuumFreezeMaxAge: ").append(toIndentedString(autovacuumFreezeMaxAge)).append("\n");
        sb.append("    autovacuumMaxWorkers: ").append(toIndentedString(autovacuumMaxWorkers)).append("\n");
        sb.append("    autovacuumNaptime: ").append(toIndentedString(autovacuumNaptime)).append("\n");
        sb.append("    autovacuumVacuumThreshold: ").append(toIndentedString(autovacuumVacuumThreshold)).append("\n");
        sb.append("    autovacuumAnalyzeThreshold: ").append(toIndentedString(autovacuumAnalyzeThreshold)).append("\n");
        sb.append("    autovacuumVacuumScaleFactor: ").append(toIndentedString(autovacuumVacuumScaleFactor))
                .append("\n");
        sb.append("    autovacuumAnalyzeScaleFactor: ").append(toIndentedString(autovacuumAnalyzeScaleFactor))
                .append("\n");
        sb.append("    autovacuumVacuumCostDelay: ").append(toIndentedString(autovacuumVacuumCostDelay)).append("\n");
        sb.append("    autovacuumVacuumCostLimit: ").append(toIndentedString(autovacuumVacuumCostLimit)).append("\n");
        sb.append("    backupHour: ").append(toIndentedString(backupHour)).append("\n");
        sb.append("    backupMinute: ").append(toIndentedString(backupMinute)).append("\n");
        sb.append("    bgwriterDelay: ").append(toIndentedString(bgwriterDelay)).append("\n");
        sb.append("    bgwriterFlushAfter: ").append(toIndentedString(bgwriterFlushAfter)).append("\n");
        sb.append("    bgwriterLruMaxpages: ").append(toIndentedString(bgwriterLruMaxpages)).append("\n");
        sb.append("    bgwriterLruMultiplier: ").append(toIndentedString(bgwriterLruMultiplier)).append("\n");
        sb.append("    deadlockTimeout: ").append(toIndentedString(deadlockTimeout)).append("\n");
        sb.append("    defaultToastCompression: ").append(toIndentedString(defaultToastCompression)).append("\n");
        sb.append("    idleInTransactionSessionTimeout: ").append(toIndentedString(idleInTransactionSessionTimeout))
                .append("\n");
        sb.append("    jit: ").append(toIndentedString(jit)).append("\n");
        sb.append("    logAutovacuumMinDuration: ").append(toIndentedString(logAutovacuumMinDuration)).append("\n");
        sb.append("    logErrorVerbosity: ").append(toIndentedString(logErrorVerbosity)).append("\n");
        sb.append("    logLinePrefix: ").append(toIndentedString(logLinePrefix)).append("\n");
        sb.append("    logMinDurationStatement: ").append(toIndentedString(logMinDurationStatement)).append("\n");
        sb.append("    maxFilesPerProcess: ").append(toIndentedString(maxFilesPerProcess)).append("\n");
        sb.append("    maxPreparedTransactions: ").append(toIndentedString(maxPreparedTransactions)).append("\n");
        sb.append("    maxPredLocksPerTransaction: ").append(toIndentedString(maxPredLocksPerTransaction)).append("\n");
        sb.append("    maxLocksPerTransaction: ").append(toIndentedString(maxLocksPerTransaction)).append("\n");
        sb.append("    maxStackDepth: ").append(toIndentedString(maxStackDepth)).append("\n");
        sb.append("    maxStandbyArchiveDelay: ").append(toIndentedString(maxStandbyArchiveDelay)).append("\n");
        sb.append("    maxStandbyStreamingDelay: ").append(toIndentedString(maxStandbyStreamingDelay)).append("\n");
        sb.append("    maxReplicationSlots: ").append(toIndentedString(maxReplicationSlots)).append("\n");
        sb.append("    maxLogicalReplicationWorkers: ").append(toIndentedString(maxLogicalReplicationWorkers))
                .append("\n");
        sb.append("    maxParallelWorkers: ").append(toIndentedString(maxParallelWorkers)).append("\n");
        sb.append("    maxParallelWorkersPerGather: ").append(toIndentedString(maxParallelWorkersPerGather))
                .append("\n");
        sb.append("    maxWorkerProcesses: ").append(toIndentedString(maxWorkerProcesses)).append("\n");
        sb.append("    pgPartmanBgwRole: ").append(toIndentedString(pgPartmanBgwRole)).append("\n");
        sb.append("    pgPartmanBgwInterval: ").append(toIndentedString(pgPartmanBgwInterval)).append("\n");
        sb.append("    pgStatStatementsTrack: ").append(toIndentedString(pgStatStatementsTrack)).append("\n");
        sb.append("    tempFileLimit: ").append(toIndentedString(tempFileLimit)).append("\n");
        sb.append("    timezone: ").append(toIndentedString(timezone)).append("\n");
        sb.append("    trackActivityQuerySize: ").append(toIndentedString(trackActivityQuerySize)).append("\n");
        sb.append("    trackCommitTimestamp: ").append(toIndentedString(trackCommitTimestamp)).append("\n");
        sb.append("    trackFunctions: ").append(toIndentedString(trackFunctions)).append("\n");
        sb.append("    trackIoTiming: ").append(toIndentedString(trackIoTiming)).append("\n");
        sb.append("    maxWalSenders: ").append(toIndentedString(maxWalSenders)).append("\n");
        sb.append("    walSenderTimeout: ").append(toIndentedString(walSenderTimeout)).append("\n");
        sb.append("    walWriterDelay: ").append(toIndentedString(walWriterDelay)).append("\n");
        sb.append("    sharedBuffersPercentage: ").append(toIndentedString(sharedBuffersPercentage)).append("\n");
        sb.append("    pgbouncer: ").append(toIndentedString(pgbouncer)).append("\n");
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