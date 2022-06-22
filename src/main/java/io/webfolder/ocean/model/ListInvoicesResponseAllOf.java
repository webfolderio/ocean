package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListInvoicesResponseAllOf
 */
@JsonPropertyOrder({ ListInvoicesResponseAllOf.JSON_PROPERTY_INVOICES,
        ListInvoicesResponseAllOf.JSON_PROPERTY_INVOICE_PREVIEW })
public class ListInvoicesResponseAllOf {
    public static final String JSON_PROPERTY_INVOICES = "invoices";
    private List<InvoicePreview> invoices = null;

    public static final String JSON_PROPERTY_INVOICE_PREVIEW = "invoice_preview";
    private InvoicePreview invoicePreview;

    public ListInvoicesResponseAllOf() {
    }

    public ListInvoicesResponseAllOf invoices(List<InvoicePreview> invoices) {
        this.invoices = invoices;
        return this;
    }

    public ListInvoicesResponseAllOf addInvoicesItem(InvoicePreview invoicesItem) {
        if (this.invoices == null) {
            this.invoices = new ArrayList<>();
        }
        this.invoices.add(invoicesItem);
        return this;
    }

    /**
     * Get invoices
     *
     * @return invoices
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_INVOICES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<InvoicePreview> getInvoices() {
        return invoices;
    }

    @JsonProperty(JSON_PROPERTY_INVOICES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInvoices(List<InvoicePreview> invoices) {
        this.invoices = invoices;
    }

    public ListInvoicesResponseAllOf invoicePreview(InvoicePreview invoicePreview) {
        this.invoicePreview = invoicePreview;
        return this;
    }

    /**
     * Get invoicePreview
     *
     * @return invoicePreview
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_INVOICE_PREVIEW)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public InvoicePreview getInvoicePreview() {
        return invoicePreview;
    }

    @JsonProperty(JSON_PROPERTY_INVOICE_PREVIEW)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInvoicePreview(InvoicePreview invoicePreview) {
        this.invoicePreview = invoicePreview;
    }

    /**
     * Return true if this list_invoices_response_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListInvoicesResponseAllOf listInvoicesResponseAllOf = (ListInvoicesResponseAllOf) o;
        return Objects.equals(this.invoices, listInvoicesResponseAllOf.invoices)
                && Objects.equals(this.invoicePreview, listInvoicesResponseAllOf.invoicePreview);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoices, invoicePreview);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListInvoicesResponseAllOf {\n");
        sb.append("    invoices: ").append(toIndentedString(invoices)).append("\n");
        sb.append("    invoicePreview: ").append(toIndentedString(invoicePreview)).append("\n");
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
