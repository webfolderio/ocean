package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * PostRegistrySubscriptionRequest
 */
@JsonPropertyOrder({ PostRegistrySubscriptionRequest.JSON_PROPERTY_TIER_SLUG })
public class PostRegistrySubscriptionRequest {
    /**
     * The slug of the subscription tier to sign up for.
     */
    public enum TierSlugEnum {
        STARTER("starter"),

        BASIC("basic"),

        PROFESSIONAL("professional");

        private String value;

        TierSlugEnum(String value) {
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
        public static TierSlugEnum fromValue(String value) {
            for (TierSlugEnum b : TierSlugEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_TIER_SLUG = "tier_slug";
    private TierSlugEnum tierSlug;

    public PostRegistrySubscriptionRequest() {
    }

    public PostRegistrySubscriptionRequest tierSlug(TierSlugEnum tierSlug) {
        this.tierSlug = tierSlug;
        return this;
    }

    /**
     * The slug of the subscription tier to sign up for.
     *
     * @return tierSlug
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TIER_SLUG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public TierSlugEnum getTierSlug() {
        return tierSlug;
    }

    @JsonProperty(JSON_PROPERTY_TIER_SLUG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTierSlug(TierSlugEnum tierSlug) {
        this.tierSlug = tierSlug;
    }

    /**
     * Return true if this post_registry_subscription_request object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PostRegistrySubscriptionRequest postRegistrySubscriptionRequest = (PostRegistrySubscriptionRequest) o;
        return Objects.equals(this.tierSlug, postRegistrySubscriptionRequest.tierSlug);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tierSlug);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PostRegistrySubscriptionRequest {\n");
        sb.append("    tierSlug: ").append(toIndentedString(tierSlug)).append("\n");
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
