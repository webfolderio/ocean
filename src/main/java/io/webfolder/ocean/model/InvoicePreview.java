package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The invoice preview.
 */
@JsonPropertyOrder({ InvoicePreview.JSON_PROPERTY_INVOICE_UUID, InvoicePreview.JSON_PROPERTY_AMOUNT,
        InvoicePreview.JSON_PROPERTY_INVOICE_PERIOD, InvoicePreview.JSON_PROPERTY_UPDATED_AT })
public class InvoicePreview {
    public static final String JSON_PROPERTY_INVOICE_UUID = "invoice_uuid";
    private String invoiceUuid;

    public static final String JSON_PROPERTY_AMOUNT = "amount";
    private String amount;

    public static final String JSON_PROPERTY_INVOICE_PERIOD = "invoice_period";
    private String invoicePeriod;

    public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
    private String updatedAt;

    public InvoicePreview() {
    }

    public InvoicePreview invoiceUuid(String invoiceUuid) {
        this.invoiceUuid = invoiceUuid;
        return this;
    }

    /**
     * The UUID of the invoice. The canonical reference for the invoice.
     *
     * @return invoiceUuid
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INVOICE_UUID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getInvoiceUuid() {
        return invoiceUuid;
    }

    @JsonProperty(JSON_PROPERTY_INVOICE_UUID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInvoiceUuid(String invoiceUuid) {
        this.invoiceUuid = invoiceUuid;
    }

    public InvoicePreview amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Total amount of the invoice, in USD. This will reflect month-to-date usage in
     * the invoice preview.
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

    public InvoicePreview invoicePeriod(String invoicePeriod) {
        this.invoicePeriod = invoicePeriod;
        return this;
    }

    /**
     * Billing period of usage for which the invoice is issued, in
     * &#x60;YYYY-MM&#x60; format.
     *
     * @return invoicePeriod
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INVOICE_PERIOD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getInvoicePeriod() {
        return invoicePeriod;
    }

    @JsonProperty(JSON_PROPERTY_INVOICE_PERIOD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInvoicePeriod(String invoicePeriod) {
        this.invoicePeriod = invoicePeriod;
    }

    public InvoicePreview updatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * Time the invoice was last updated. This is only included with the invoice
     * preview.
     *
     * @return updatedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Return true if this invoice_preview object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InvoicePreview invoicePreview = (InvoicePreview) o;
        return Objects.equals(this.invoiceUuid, invoicePreview.invoiceUuid)
                && Objects.equals(this.amount, invoicePreview.amount)
                && Objects.equals(this.invoicePeriod, invoicePreview.invoicePeriod)
                && Objects.equals(this.updatedAt, invoicePreview.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceUuid, amount, invoicePeriod, updatedAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InvoicePreview {\n");
        sb.append("    invoiceUuid: ").append(toIndentedString(invoiceUuid)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    invoicePeriod: ").append(toIndentedString(invoicePeriod)).append("\n");
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