package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Subscription
 */
@JsonPropertyOrder({ Subscription.JSON_PROPERTY_TIER, Subscription.JSON_PROPERTY_CREATED_AT,
        Subscription.JSON_PROPERTY_UPDATED_AT })
public class Subscription {
    public static final String JSON_PROPERTY_TIER = "tier";
    private SubscriptionTierBase tier;

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    private OffsetDateTime createdAt;

    public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
    private OffsetDateTime updatedAt;

    public Subscription() {
    }

    @JsonCreator
    public Subscription(@JsonProperty(JSON_PROPERTY_CREATED_AT) OffsetDateTime createdAt,
            @JsonProperty(JSON_PROPERTY_UPDATED_AT) OffsetDateTime updatedAt) {
        this();
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Subscription tier(SubscriptionTierBase tier) {
        this.tier = tier;
        return this;
    }

    /**
     * Get tier
     *
     * @return tier
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TIER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public SubscriptionTierBase getTier() {
        return tier;
    }

    @JsonProperty(JSON_PROPERTY_TIER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTier(SubscriptionTierBase tier) {
        this.tier = tier;
    }

    /**
     * The time at which the subscription was created.
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
     * The time at which the subscription was last updated.
     *
     * @return updatedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Return true if this subscription object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Subscription subscription = (Subscription) o;
        return Objects.equals(this.tier, subscription.tier) && Objects.equals(this.createdAt, subscription.createdAt)
                && Objects.equals(this.updatedAt, subscription.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tier, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Subscription {\n");
        sb.append("    tier: ").append(toIndentedString(tier)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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