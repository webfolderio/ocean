package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * GetInvoiceByUuidResponseAllOf
 */
@JsonPropertyOrder({ GetInvoiceByUuidResponseAllOf.JSON_PROPERTY_INVOICE_ITEMS })
public class GetInvoiceByUuidResponseAllOf {
    public static final String JSON_PROPERTY_INVOICE_ITEMS = "invoice_items";
    private List<InvoiceItem> invoiceItems = null;

    public GetInvoiceByUuidResponseAllOf() {
    }

    public GetInvoiceByUuidResponseAllOf invoiceItems(List<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
        return this;
    }

    public GetInvoiceByUuidResponseAllOf addInvoiceItemsItem(InvoiceItem invoiceItemsItem) {
        if (this.invoiceItems == null) {
            this.invoiceItems = new ArrayList<>();
        }
        this.invoiceItems.add(invoiceItemsItem);
        return this;
    }

    /**
     * Get invoiceItems
     *
     * @return invoiceItems
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INVOICE_ITEMS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    @JsonProperty(JSON_PROPERTY_INVOICE_ITEMS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    /**
     * Return true if this get_invoice_by_uuid_response_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetInvoiceByUuidResponseAllOf getInvoiceByUuidResponseAllOf = (GetInvoiceByUuidResponseAllOf) o;
        return Objects.equals(this.invoiceItems, getInvoiceByUuidResponseAllOf.invoiceItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceItems);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetInvoiceByUuidResponseAllOf {\n");
        sb.append("    invoiceItems: ").append(toIndentedString(invoiceItems)).append("\n");
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
