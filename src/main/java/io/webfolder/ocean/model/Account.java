package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Account
 */
@JsonPropertyOrder({ Account.JSON_PROPERTY_DROPLET_LIMIT, Account.JSON_PROPERTY_FLOATING_IP_LIMIT,
        Account.JSON_PROPERTY_EMAIL, Account.JSON_PROPERTY_UUID, Account.JSON_PROPERTY_EMAIL_VERIFIED,
        Account.JSON_PROPERTY_STATUS, Account.JSON_PROPERTY_STATUS_MESSAGE, Account.JSON_PROPERTY_TEAM })
public class Account {
    public static final String JSON_PROPERTY_DROPLET_LIMIT = "droplet_limit";
    private Integer dropletLimit;

    public static final String JSON_PROPERTY_FLOATING_IP_LIMIT = "floating_ip_limit";
    private Integer floatingIpLimit;

    public static final String JSON_PROPERTY_EMAIL = "email";
    private String email;

    public static final String JSON_PROPERTY_UUID = "uuid";
    private String uuid;

    public static final String JSON_PROPERTY_EMAIL_VERIFIED = "email_verified";
    private Boolean emailVerified = false;

    /**
     * This value is one of \&quot;active\&quot;, \&quot;warning\&quot; or
     * \&quot;locked\&quot;.
     */
    public enum StatusEnum {
        ACTIVE("active"),

        WARNING("warning"),

        LOCKED("locked");

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
    private StatusEnum status = StatusEnum.ACTIVE;

    public static final String JSON_PROPERTY_STATUS_MESSAGE = "status_message";
    private String statusMessage;

    public static final String JSON_PROPERTY_TEAM = "team";
    private AccountTeam team;

    public Account() {
    }

    public Account dropletLimit(Integer dropletLimit) {
        this.dropletLimit = dropletLimit;
        return this;
    }

    /**
     * The total number of Droplets current user or team may have active at one
     * time.
     *
     * @return dropletLimit
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DROPLET_LIMIT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Integer getDropletLimit() {
        return dropletLimit;
    }

    @JsonProperty(JSON_PROPERTY_DROPLET_LIMIT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDropletLimit(Integer dropletLimit) {
        this.dropletLimit = dropletLimit;
    }

    public Account floatingIpLimit(Integer floatingIpLimit) {
        this.floatingIpLimit = floatingIpLimit;
        return this;
    }

    /**
     * The total number of Floating IPs the current user or team may have.
     *
     * @return floatingIpLimit
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_FLOATING_IP_LIMIT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Integer getFloatingIpLimit() {
        return floatingIpLimit;
    }

    @JsonProperty(JSON_PROPERTY_FLOATING_IP_LIMIT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setFloatingIpLimit(Integer floatingIpLimit) {
        this.floatingIpLimit = floatingIpLimit;
    }

    public Account email(String email) {
        this.email = email;
        return this;
    }

    /**
     * The email address used by the current user to register for DigitalOcean.
     *
     * @return email
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_EMAIL)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getEmail() {
        return email;
    }

    @JsonProperty(JSON_PROPERTY_EMAIL)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setEmail(String email) {
        this.email = email;
    }

    public Account uuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    /**
     * The unique universal identifier for the current user.
     *
     * @return uuid
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_UUID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getUuid() {
        return uuid;
    }

    @JsonProperty(JSON_PROPERTY_UUID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Account emailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
        return this;
    }

    /**
     * If true, the user has verified their account via email. False otherwise.
     *
     * @return emailVerified
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_EMAIL_VERIFIED)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    @JsonProperty(JSON_PROPERTY_EMAIL_VERIFIED)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public Account status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * This value is one of \&quot;active\&quot;, \&quot;warning\&quot; or
     * \&quot;locked\&quot;.
     *
     * @return status
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public StatusEnum getStatus() {
        return status;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Account statusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
        return this;
    }

    /**
     * A human-readable message giving more details about the status of the account.
     *
     * @return statusMessage
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_STATUS_MESSAGE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getStatusMessage() {
        return statusMessage;
    }

    @JsonProperty(JSON_PROPERTY_STATUS_MESSAGE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Account team(AccountTeam team) {
        this.team = team;
        return this;
    }

    /**
     * Get team
     *
     * @return team
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TEAM)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public AccountTeam getTeam() {
        return team;
    }

    @JsonProperty(JSON_PROPERTY_TEAM)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTeam(AccountTeam team) {
        this.team = team;
    }

    /**
     * Return true if this account object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(this.dropletLimit, account.dropletLimit)
                && Objects.equals(this.floatingIpLimit, account.floatingIpLimit)
                && Objects.equals(this.email, account.email) && Objects.equals(this.uuid, account.uuid)
                && Objects.equals(this.emailVerified, account.emailVerified)
                && Objects.equals(this.status, account.status)
                && Objects.equals(this.statusMessage, account.statusMessage) && Objects.equals(this.team, account.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dropletLimit, floatingIpLimit, email, uuid, emailVerified, status, statusMessage, team);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Account {\n");
        sb.append("    dropletLimit: ").append(toIndentedString(dropletLimit)).append("\n");
        sb.append("    floatingIpLimit: ").append(toIndentedString(floatingIpLimit)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    emailVerified: ").append(toIndentedString(emailVerified)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    statusMessage: ").append(toIndentedString(statusMessage)).append("\n");
        sb.append("    team: ").append(toIndentedString(team)).append("\n");
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