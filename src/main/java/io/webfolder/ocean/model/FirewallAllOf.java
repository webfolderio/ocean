package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * FirewallAllOf
 */
@JsonPropertyOrder({ FirewallAllOf.JSON_PROPERTY_ID, FirewallAllOf.JSON_PROPERTY_STATUS,
        FirewallAllOf.JSON_PROPERTY_CREATED_AT, FirewallAllOf.JSON_PROPERTY_PENDING_CHANGES,
        FirewallAllOf.JSON_PROPERTY_NAME, FirewallAllOf.JSON_PROPERTY_DROPLET_IDS, FirewallAllOf.JSON_PROPERTY_TAGS })
public class FirewallAllOf {
    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    /**
     * A status string indicating the current state of the firewall. This can be
     * \&quot;waiting\&quot;, \&quot;succeeded\&quot;, or \&quot;failed\&quot;.
     */
    public enum StatusEnum {
        WAITING("waiting"),

        SUCCEEDED("succeeded"),

        FAILED("failed");

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

    public static final String JSON_PROPERTY_PENDING_CHANGES = "pending_changes";
    private List<FirewallAllOfPendingChanges> pendingChanges = null;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_DROPLET_IDS = "droplet_ids";
    private List<Integer> dropletIds = null;

    public static final String JSON_PROPERTY_TAGS = "tags";
    private List<Tag> tags;

    public FirewallAllOf() {
    }

    @JsonCreator
    public FirewallAllOf(@JsonProperty(JSON_PROPERTY_ID) String id,
            @JsonProperty(JSON_PROPERTY_STATUS) StatusEnum status,
            @JsonProperty(JSON_PROPERTY_CREATED_AT) OffsetDateTime createdAt,
            @JsonProperty(JSON_PROPERTY_PENDING_CHANGES) List<FirewallAllOfPendingChanges> pendingChanges) {
        this();
        this.id = id;
        this.status = status;
        this.createdAt = createdAt;
        this.pendingChanges = pendingChanges;
    }

    /**
     * A unique ID that can be used to identify and reference a firewall.
     *
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getId() {
        return id;
    }

    /**
     * A status string indicating the current state of the firewall. This can be
     * \&quot;waiting\&quot;, \&quot;succeeded\&quot;, or \&quot;failed\&quot;.
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
     * when the firewall was created.
     *
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * An array of objects each containing the fields \&quot;droplet_id\&quot;,
     * \&quot;removing\&quot;, and \&quot;status\&quot;. It is provided to detail
     * exactly which Droplets are having their security policies updated. When
     * empty, all changes have been successfully applied.
     *
     * @return pendingChanges
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PENDING_CHANGES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<FirewallAllOfPendingChanges> getPendingChanges() {
        return pendingChanges;
    }

    public FirewallAllOf name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A human-readable name for a firewall. The name must begin with an
     * alphanumeric character. Subsequent characters must either be alphanumeric
     * characters, a period (.), or a dash (-).
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

    public FirewallAllOf dropletIds(List<Integer> dropletIds) {
        this.dropletIds = dropletIds;
        return this;
    }

    public FirewallAllOf addDropletIdsItem(Integer dropletIdsItem) {
        if (this.dropletIds == null) {
            this.dropletIds = new ArrayList<>();
        }
        this.dropletIds.add(dropletIdsItem);
        return this;
    }

    /**
     * An array containing the IDs of the Droplets assigned to the firewall.
     *
     * @return dropletIds
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DROPLET_IDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Integer> getDropletIds() {
        return dropletIds;
    }

    @JsonProperty(JSON_PROPERTY_DROPLET_IDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDropletIds(List<Integer> dropletIds) {
        this.dropletIds = dropletIds;
    }

    public FirewallAllOf tags(List<Tag> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Get tags
     *
     * @return tags
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Tag> getTags() {
        return tags;
    }

    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    /**
     * Return true if this firewall_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FirewallAllOf firewallAllOf = (FirewallAllOf) o;
        return Objects.equals(this.id, firewallAllOf.id) && Objects.equals(this.status, firewallAllOf.status)
                && Objects.equals(this.createdAt, firewallAllOf.createdAt)
                && Objects.equals(this.pendingChanges, firewallAllOf.pendingChanges)
                && Objects.equals(this.name, firewallAllOf.name)
                && Objects.equals(this.dropletIds, firewallAllOf.dropletIds)
                && Objects.equals(this.tags, firewallAllOf.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, createdAt, pendingChanges, name, dropletIds, tags);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FirewallAllOf {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    pendingChanges: ").append(toIndentedString(pendingChanges)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    dropletIds: ").append(toIndentedString(dropletIds)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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