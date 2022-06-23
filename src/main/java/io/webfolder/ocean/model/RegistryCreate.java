package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * RegistryCreate
 */
@JsonPropertyOrder({ RegistryCreate.JSON_PROPERTY_NAME, RegistryCreate.JSON_PROPERTY_SUBSCRIPTION_TIER_SLUG,
        RegistryCreate.JSON_PROPERTY_REGION })
public class RegistryCreate {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    /**
     * The slug of the subscription tier to sign up for. Valid values can be
     * retrieved using the options endpoint.
     */
    public enum SubscriptionTierSlugEnum {
        STARTER("starter"),

        BASIC("basic"),

        PROFESSIONAL("professional");

        private String value;

        SubscriptionTierSlugEnum(String value) {
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
        public static SubscriptionTierSlugEnum fromValue(String value) {
            for (SubscriptionTierSlugEnum b : SubscriptionTierSlugEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_SUBSCRIPTION_TIER_SLUG = "subscription_tier_slug";
    private SubscriptionTierSlugEnum subscriptionTierSlug;

    /**
     * Slug of the region where registry data is stored. When not provided, a region
     * will be selected.
     */
    public enum RegionEnum {
        NYC3("nyc3"),

        SFO3("sfo3"),

        AMS3("ams3"),

        SGP1("sgp1"),

        FRA1("fra1");

        private String value;

        RegionEnum(String value) {
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
        public static RegionEnum fromValue(String value) {
            for (RegionEnum b : RegionEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_REGION = "region";
    private RegionEnum region;

    public RegistryCreate() {
    }

    public RegistryCreate name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A globally unique name for the container registry. Must be lowercase and be
     * composed only of numbers, letters and &#x60;-&#x60;, up to a limit of 63
     * characters.
     *
     * @return name
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setName(String name) {
        this.name = name;
    }

    public RegistryCreate subscriptionTierSlug(SubscriptionTierSlugEnum subscriptionTierSlug) {
        this.subscriptionTierSlug = subscriptionTierSlug;
        return this;
    }

    /**
     * The slug of the subscription tier to sign up for. Valid values can be
     * retrieved using the options endpoint.
     *
     * @return subscriptionTierSlug
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_SUBSCRIPTION_TIER_SLUG)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public SubscriptionTierSlugEnum getSubscriptionTierSlug() {
        return subscriptionTierSlug;
    }

    @JsonProperty(JSON_PROPERTY_SUBSCRIPTION_TIER_SLUG)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSubscriptionTierSlug(SubscriptionTierSlugEnum subscriptionTierSlug) {
        this.subscriptionTierSlug = subscriptionTierSlug;
    }

    public RegistryCreate region(RegionEnum region) {
        this.region = region;
        return this;
    }

    /**
     * Slug of the region where registry data is stored. When not provided, a region
     * will be selected.
     *
     * @return region
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public RegionEnum getRegion() {
        return region;
    }

    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRegion(RegionEnum region) {
        this.region = region;
    }

    /**
     * Return true if this registry_create object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RegistryCreate registryCreate = (RegistryCreate) o;
        return Objects.equals(this.name, registryCreate.name)
                && Objects.equals(this.subscriptionTierSlug, registryCreate.subscriptionTierSlug)
                && Objects.equals(this.region, registryCreate.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subscriptionTierSlug, region);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RegistryCreate {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    subscriptionTierSlug: ").append(toIndentedString(subscriptionTierSlug)).append("\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
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