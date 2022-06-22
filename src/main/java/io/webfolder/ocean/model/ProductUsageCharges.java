package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * ProductUsageCharges
 */
@JsonPropertyOrder({ ProductUsageCharges.JSON_PROPERTY_NAME, ProductUsageCharges.JSON_PROPERTY_AMOUNT,
        ProductUsageCharges.JSON_PROPERTY_ITEMS })
public class ProductUsageCharges {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_AMOUNT = "amount";
    private String amount;

    public static final String JSON_PROPERTY_ITEMS = "items";
    private List<ProductChargeItem> items = null;

    public ProductUsageCharges() {
    }

    public ProductUsageCharges name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Description of usage charges
     *
     * @return name
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "Product usage charges", value = "Description of usage charges")
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

    public ProductUsageCharges amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Total amount charged
     *
     * @return amount
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "12.34", value = "Total amount charged")
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

    public ProductUsageCharges items(List<ProductChargeItem> items) {
        this.items = items;
        return this;
    }

    public ProductUsageCharges addItemsItem(ProductChargeItem itemsItem) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(itemsItem);
        return this;
    }

    /**
     * List of amount, and grouped aggregates by resource type.
     *
     * @return items
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "[{\"amount\":\"10.00\",\"name\":\"Spaces Subscription\",\"count\":\"1\"},{\"amount\":\"2.34\",\"name\":\"Database Clusters\",\"count\":\"1\"}]", value = "List of amount, and grouped aggregates by resource type.")
    @JsonProperty(JSON_PROPERTY_ITEMS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<ProductChargeItem> getItems() {
        return items;
    }

    @JsonProperty(JSON_PROPERTY_ITEMS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setItems(List<ProductChargeItem> items) {
        this.items = items;
    }

    /**
     * Return true if this product_usage_charges object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductUsageCharges productUsageCharges = (ProductUsageCharges) o;
        return Objects.equals(this.name, productUsageCharges.name)
                && Objects.equals(this.amount, productUsageCharges.amount)
                && Objects.equals(this.items, productUsageCharges.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount, items);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProductUsageCharges {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    items: ").append(toIndentedString(items)).append("\n");
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
