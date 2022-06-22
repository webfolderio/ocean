package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * GetInvoiceByUuidResponse
 */
@JsonPropertyOrder({ GetInvoiceByUuidResponse.JSON_PROPERTY_INVOICE_ITEMS, GetInvoiceByUuidResponse.JSON_PROPERTY_LINKS,
        GetInvoiceByUuidResponse.JSON_PROPERTY_META })
public class GetInvoiceByUuidResponse {
    public static final String JSON_PROPERTY_INVOICE_ITEMS = "invoice_items";
    private List<InvoiceItem> invoiceItems = null;

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public GetInvoiceByUuidResponse() {
    }

    public GetInvoiceByUuidResponse invoiceItems(List<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
        return this;
    }

    public GetInvoiceByUuidResponse addInvoiceItemsItem(InvoiceItem invoiceItemsItem) {
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
    @ApiModelProperty(value = "")
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

    public GetInvoiceByUuidResponse links(PageLinks links) {
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

    public GetInvoiceByUuidResponse meta(MetaMeta meta) {
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
     * Return true if this get_invoice_by_uuid_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetInvoiceByUuidResponse getInvoiceByUuidResponse = (GetInvoiceByUuidResponse) o;
        return Objects.equals(this.invoiceItems, getInvoiceByUuidResponse.invoiceItems)
                && Objects.equals(this.links, getInvoiceByUuidResponse.links)
                && Objects.equals(this.meta, getInvoiceByUuidResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceItems, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetInvoiceByUuidResponse {\n");
        sb.append("    invoiceItems: ").append(toIndentedString(invoiceItems)).append("\n");
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
