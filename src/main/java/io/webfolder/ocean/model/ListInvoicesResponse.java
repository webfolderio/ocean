package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListInvoicesResponse
 */
@JsonPropertyOrder({ ListInvoicesResponse.JSON_PROPERTY_INVOICES, ListInvoicesResponse.JSON_PROPERTY_INVOICE_PREVIEW,
        ListInvoicesResponse.JSON_PROPERTY_LINKS, ListInvoicesResponse.JSON_PROPERTY_META })
public class ListInvoicesResponse {
    public static final String JSON_PROPERTY_INVOICES = "invoices";
    private List<InvoicePreview> invoices = null;

    public static final String JSON_PROPERTY_INVOICE_PREVIEW = "invoice_preview";
    private InvoicePreview invoicePreview;

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public ListInvoicesResponse() {
    }

    public ListInvoicesResponse invoices(List<InvoicePreview> invoices) {
        this.invoices = invoices;
        return this;
    }

    public ListInvoicesResponse addInvoicesItem(InvoicePreview invoicesItem) {
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

    public ListInvoicesResponse invoicePreview(InvoicePreview invoicePreview) {
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

    public ListInvoicesResponse links(PageLinks links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     *
     * @return links
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_LINKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public PageLinks getLinks() {
        return links;
    }

    @JsonProperty(JSON_PROPERTY_LINKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLinks(PageLinks links) {
        this.links = links;
    }

    public ListInvoicesResponse meta(MetaMeta meta) {
        this.meta = meta;
        return this;
    }

    /**
     * Get meta
     *
     * @return meta
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_META)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public MetaMeta getMeta() {
        return meta;
    }

    @JsonProperty(JSON_PROPERTY_META)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setMeta(MetaMeta meta) {
        this.meta = meta;
    }

    /**
     * Return true if this list_invoices_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListInvoicesResponse listInvoicesResponse = (ListInvoicesResponse) o;
        return Objects.equals(this.invoices, listInvoicesResponse.invoices)
                && Objects.equals(this.invoicePreview, listInvoicesResponse.invoicePreview)
                && Objects.equals(this.links, listInvoicesResponse.links)
                && Objects.equals(this.meta, listInvoicesResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoices, invoicePreview, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListInvoicesResponse {\n");
        sb.append("    invoices: ").append(toIndentedString(invoices)).append("\n");
        sb.append("    invoicePreview: ").append(toIndentedString(invoicePreview)).append("\n");
        sb.append("    links: ").append(toIndentedString(links)).append("\n");
        sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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
