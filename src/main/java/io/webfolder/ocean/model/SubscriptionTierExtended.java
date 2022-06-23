package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * SubscriptionTierExtended
 */
@JsonPropertyOrder({ SubscriptionTierExtended.JSON_PROPERTY_ELIGIBLE,
        SubscriptionTierExtended.JSON_PROPERTY_ELIGIBILITY_REASONS })
public class SubscriptionTierExtended {
    public static final String JSON_PROPERTY_ELIGIBLE = "eligible";
    private Boolean eligible;

    /**
     * Gets or Sets eligibilityReasons
     */
    public enum EligibilityReasonsEnum {
        OVERREPOSITORYLIMIT("OverRepositoryLimit"),

        OVERSTORAGELIMIT("OverStorageLimit");

        private String value;

        EligibilityReasonsEnum(String value) {
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
        public static EligibilityReasonsEnum fromValue(String value) {
            for (EligibilityReasonsEnum b : EligibilityReasonsEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_ELIGIBILITY_REASONS = "eligibility_reasons";
    private List<EligibilityReasonsEnum> eligibilityReasons = null;

    public SubscriptionTierExtended() {
    }

    public SubscriptionTierExtended eligible(Boolean eligible) {
        this.eligible = eligible;
        return this;
    }

    /**
     * A boolean indicating whether your account it eligible to use a certain
     * subscription tier.
     *
     * @return eligible
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ELIGIBLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Boolean getEligible() {
        return eligible;
    }

    @JsonProperty(JSON_PROPERTY_ELIGIBLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEligible(Boolean eligible) {
        this.eligible = eligible;
    }

    public SubscriptionTierExtended eligibilityReasons(List<EligibilityReasonsEnum> eligibilityReasons) {
        this.eligibilityReasons = eligibilityReasons;
        return this;
    }

    public SubscriptionTierExtended addEligibilityReasonsItem(EligibilityReasonsEnum eligibilityReasonsItem) {
        if (this.eligibilityReasons == null) {
            this.eligibilityReasons = new ArrayList<>();
        }
        this.eligibilityReasons.add(eligibilityReasonsItem);
        return this;
    }

    /**
     * If your account is not eligible to use a certain subscription tier, this will
     * include a list of reasons that prevent you from using the tier.
     *
     * @return eligibilityReasons
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ELIGIBILITY_REASONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<EligibilityReasonsEnum> getEligibilityReasons() {
        return eligibilityReasons;
    }

    @JsonProperty(JSON_PROPERTY_ELIGIBILITY_REASONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEligibilityReasons(List<EligibilityReasonsEnum> eligibilityReasons) {
        this.eligibilityReasons = eligibilityReasons;
    }

    /**
     * Return true if this subscription_tier_extended object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SubscriptionTierExtended subscriptionTierExtended = (SubscriptionTierExtended) o;
        return Objects.equals(this.eligible, subscriptionTierExtended.eligible)
                && Objects.equals(this.eligibilityReasons, subscriptionTierExtended.eligibilityReasons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eligible, eligibilityReasons);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SubscriptionTierExtended {\n");
        sb.append("    eligible: ").append(toIndentedString(eligible)).append("\n");
        sb.append("    eligibilityReasons: ").append(toIndentedString(eligibilityReasons)).append("\n");
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