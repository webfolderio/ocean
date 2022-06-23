package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * InvoiceItem
 */
@JsonPropertyOrder({ InvoiceItem.JSON_PROPERTY_PRODUCT, InvoiceItem.JSON_PROPERTY_RESOURCE_UUID,
        InvoiceItem.JSON_PROPERTY_RESOURCE_ID, InvoiceItem.JSON_PROPERTY_GROUP_DESCRIPTION,
        InvoiceItem.JSON_PROPERTY_DESCRIPTION, InvoiceItem.JSON_PROPERTY_AMOUNT, InvoiceItem.JSON_PROPERTY_DURATION,
        InvoiceItem.JSON_PROPERTY_DURATION_UNIT, InvoiceItem.JSON_PROPERTY_START_TIME,
        InvoiceItem.JSON_PROPERTY_END_TIME, InvoiceItem.JSON_PROPERTY_PROJECT_NAME })
public class InvoiceItem {
    public static final String JSON_PROPERTY_PRODUCT = "product";
    private String product;

    public static final String JSON_PROPERTY_RESOURCE_UUID = "resource_uuid";
    private String resourceUuid;

    public static final String JSON_PROPERTY_RESOURCE_ID = "resource_id";
    private String resourceId;

    public static final String JSON_PROPERTY_GROUP_DESCRIPTION = "group_description";
    private String groupDescription;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_AMOUNT = "amount";
    private String amount;

    public static final String JSON_PROPERTY_DURATION = "duration";
    private String duration;

    public static final String JSON_PROPERTY_DURATION_UNIT = "duration_unit";
    private String durationUnit;

    public static final String JSON_PROPERTY_START_TIME = "start_time";
    private String startTime;

    public static final String JSON_PROPERTY_END_TIME = "end_time";
    private String endTime;

    public static final String JSON_PROPERTY_PROJECT_NAME = "project_name";
    private String projectName;

    public InvoiceItem() {
    }

    public InvoiceItem product(String product) {
        this.product = product;
        return this;
    }

    /**
     * Name of the product being billed in the invoice item.
     *
     * @return product
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PRODUCT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getProduct() {
        return product;
    }

    @JsonProperty(JSON_PROPERTY_PRODUCT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProduct(String product) {
        this.product = product;
    }

    public InvoiceItem resourceUuid(String resourceUuid) {
        this.resourceUuid = resourceUuid;
        return this;
    }

    /**
     * UUID of the resource billing in the invoice item if available.
     *
     * @return resourceUuid
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_RESOURCE_UUID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getResourceUuid() {
        return resourceUuid;
    }

    @JsonProperty(JSON_PROPERTY_RESOURCE_UUID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setResourceUuid(String resourceUuid) {
        this.resourceUuid = resourceUuid;
    }

    public InvoiceItem resourceId(String resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    /**
     * ID of the resource billing in the invoice item if available.
     *
     * @return resourceId
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_RESOURCE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getResourceId() {
        return resourceId;
    }

    @JsonProperty(JSON_PROPERTY_RESOURCE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public InvoiceItem groupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
        return this;
    }

    /**
     * Description of the invoice item when it is a grouped set of usage, such as
     * DOKS or databases.
     *
     * @return groupDescription
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_GROUP_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getGroupDescription() {
        return groupDescription;
    }

    @JsonProperty(JSON_PROPERTY_GROUP_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public InvoiceItem description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Description of the invoice item.
     *
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDescription() {
        return description;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDescription(String description) {
        this.description = description;
    }

    public InvoiceItem amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Billed amount of this invoice item. Billed in USD.
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

    public InvoiceItem duration(String duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Duration of time this invoice item was used and subsequently billed.
     *
     * @return duration
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DURATION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDuration() {
        return duration;
    }

    @JsonProperty(JSON_PROPERTY_DURATION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDuration(String duration) {
        this.duration = duration;
    }

    public InvoiceItem durationUnit(String durationUnit) {
        this.durationUnit = durationUnit;
        return this;
    }

    /**
     * Unit of time for duration.
     *
     * @return durationUnit
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DURATION_UNIT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDurationUnit() {
        return durationUnit;
    }

    @JsonProperty(JSON_PROPERTY_DURATION_UNIT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDurationUnit(String durationUnit) {
        this.durationUnit = durationUnit;
    }

    public InvoiceItem startTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Time the invoice item began to be billed for usage.
     *
     * @return startTime
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_START_TIME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getStartTime() {
        return startTime;
    }

    @JsonProperty(JSON_PROPERTY_START_TIME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public InvoiceItem endTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    /**
     * Time the invoice item stoped being billed for usage.
     *
     * @return endTime
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_END_TIME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getEndTime() {
        return endTime;
    }

    @JsonProperty(JSON_PROPERTY_END_TIME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public InvoiceItem projectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    /**
     * Name of the DigitalOcean Project this resource belongs to.
     *
     * @return projectName
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PROJECT_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getProjectName() {
        return projectName;
    }

    @JsonProperty(JSON_PROPERTY_PROJECT_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * Return true if this invoice_item object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InvoiceItem invoiceItem = (InvoiceItem) o;
        return Objects.equals(this.product, invoiceItem.product)
                && Objects.equals(this.resourceUuid, invoiceItem.resourceUuid)
                && Objects.equals(this.resourceId, invoiceItem.resourceId)
                && Objects.equals(this.groupDescription, invoiceItem.groupDescription)
                && Objects.equals(this.description, invoiceItem.description)
                && Objects.equals(this.amount, invoiceItem.amount)
                && Objects.equals(this.duration, invoiceItem.duration)
                && Objects.equals(this.durationUnit, invoiceItem.durationUnit)
                && Objects.equals(this.startTime, invoiceItem.startTime)
                && Objects.equals(this.endTime, invoiceItem.endTime)
                && Objects.equals(this.projectName, invoiceItem.projectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, resourceUuid, resourceId, groupDescription, description, amount, duration,
                durationUnit, startTime, endTime, projectName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InvoiceItem {\n");
        sb.append("    product: ").append(toIndentedString(product)).append("\n");
        sb.append("    resourceUuid: ").append(toIndentedString(resourceUuid)).append("\n");
        sb.append("    resourceId: ").append(toIndentedString(resourceId)).append("\n");
        sb.append("    groupDescription: ").append(toIndentedString(groupDescription)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
        sb.append("    durationUnit: ").append(toIndentedString(durationUnit)).append("\n");
        sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
        sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
        sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
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