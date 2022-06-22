package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListBillingHistoryResponseAllOf
 */
@JsonPropertyOrder({ ListBillingHistoryResponseAllOf.JSON_PROPERTY_BILLING_HISTORY })
public class ListBillingHistoryResponseAllOf {
    public static final String JSON_PROPERTY_BILLING_HISTORY = "billing_history";
    private List<BillingHistory> billingHistory = null;

    public ListBillingHistoryResponseAllOf() {
    }

    public ListBillingHistoryResponseAllOf billingHistory(List<BillingHistory> billingHistory) {
        this.billingHistory = billingHistory;
        return this;
    }

    public ListBillingHistoryResponseAllOf addBillingHistoryItem(BillingHistory billingHistoryItem) {
        if (this.billingHistory == null) {
            this.billingHistory = new ArrayList<>();
        }
        this.billingHistory.add(billingHistoryItem);
        return this;
    }

    /**
     * Get billingHistory
     *
     * @return billingHistory
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_BILLING_HISTORY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<BillingHistory> getBillingHistory() {
        return billingHistory;
    }

    @JsonProperty(JSON_PROPERTY_BILLING_HISTORY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setBillingHistory(List<BillingHistory> billingHistory) {
        this.billingHistory = billingHistory;
    }

    /**
     * Return true if this list_billing_history_response_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListBillingHistoryResponseAllOf listBillingHistoryResponseAllOf = (ListBillingHistoryResponseAllOf) o;
        return Objects.equals(this.billingHistory, listBillingHistoryResponseAllOf.billingHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billingHistory);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListBillingHistoryResponseAllOf {\n");
        sb.append("    billingHistory: ").append(toIndentedString(billingHistory)).append("\n");
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
