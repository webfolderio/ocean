package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * InvoiceSummaryCreditsAndAdjustments
 */
@JsonPropertyOrder({ InvoiceSummaryCreditsAndAdjustments.JSON_PROPERTY_NAME,
        InvoiceSummaryCreditsAndAdjustments.JSON_PROPERTY_AMOUNT })
public class InvoiceSummaryCreditsAndAdjustments {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_AMOUNT = "amount";
    private String amount;

    public InvoiceSummaryCreditsAndAdjustments() {
    }

    public InvoiceSummaryCreditsAndAdjustments name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Name of the charge
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

    public InvoiceSummaryCreditsAndAdjustments amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Total amount charged in USD
     *
     * @return amount
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_AMOUNT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getAmount() {
        return amount;
    }

    @JsonProperty(JSON_PROPERTY_AMOUNT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * Return true if this invoice_summary_credits_and_adjustments object is equal
     * to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InvoiceSummaryCreditsAndAdjustments invoiceSummaryCreditsAndAdjustments = (InvoiceSummaryCreditsAndAdjustments) o;
        return Objects.equals(this.name, invoiceSummaryCreditsAndAdjustments.name)
                && Objects.equals(this.amount, invoiceSummaryCreditsAndAdjustments.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InvoiceSummaryCreditsAndAdjustments {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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