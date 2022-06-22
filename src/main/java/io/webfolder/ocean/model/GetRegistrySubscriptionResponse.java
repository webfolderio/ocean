package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * GetRegistrySubscriptionResponse
 */
@JsonPropertyOrder({ GetRegistrySubscriptionResponse.JSON_PROPERTY_SUBSCRIPTION })
public class GetRegistrySubscriptionResponse {
    public static final String JSON_PROPERTY_SUBSCRIPTION = "subscription";
    private Subscription subscription;

    public GetRegistrySubscriptionResponse() {
    }

    public GetRegistrySubscriptionResponse subscription(Subscription subscription) {
        this.subscription = subscription;
        return this;
    }

    /**
     * Get subscription
     *
     * @return subscription
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SUBSCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Subscription getSubscription() {
        return subscription;
    }

    @JsonProperty(JSON_PROPERTY_SUBSCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    /**
     * Return true if this get_registry_subscription_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetRegistrySubscriptionResponse getRegistrySubscriptionResponse = (GetRegistrySubscriptionResponse) o;
        return Objects.equals(this.subscription, getRegistrySubscriptionResponse.subscription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscription);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetRegistrySubscriptionResponse {\n");
        sb.append("    subscription: ").append(toIndentedString(subscription)).append("\n");
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
