package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * InvoiceSummary
 */
@JsonPropertyOrder({ InvoiceSummary.JSON_PROPERTY_INVOICE_UUID, InvoiceSummary.JSON_PROPERTY_BILLING_PERIOD,
        InvoiceSummary.JSON_PROPERTY_AMOUNT, InvoiceSummary.JSON_PROPERTY_USER_NAME,
        InvoiceSummary.JSON_PROPERTY_USER_BILLING_ADDRESS, InvoiceSummary.JSON_PROPERTY_USER_COMPANY,
        InvoiceSummary.JSON_PROPERTY_USER_EMAIL, InvoiceSummary.JSON_PROPERTY_PRODUCT_CHARGES,
        InvoiceSummary.JSON_PROPERTY_OVERAGES, InvoiceSummary.JSON_PROPERTY_TAXES,
        InvoiceSummary.JSON_PROPERTY_CREDITS_AND_ADJUSTMENTS })
public class InvoiceSummary {
    public static final String JSON_PROPERTY_INVOICE_UUID = "invoice_uuid";
    private String invoiceUuid;

    public static final String JSON_PROPERTY_BILLING_PERIOD = "billing_period";
    private String billingPeriod;

    public static final String JSON_PROPERTY_AMOUNT = "amount";
    private String amount;

    public static final String JSON_PROPERTY_USER_NAME = "user_name";
    private String userName;

    public static final String JSON_PROPERTY_USER_BILLING_ADDRESS = "user_billing_address";
    private InvoiceSummaryUserBillingAddress userBillingAddress;

    public static final String JSON_PROPERTY_USER_COMPANY = "user_company";
    private String userCompany;

    public static final String JSON_PROPERTY_USER_EMAIL = "user_email";
    private String userEmail;

    public static final String JSON_PROPERTY_PRODUCT_CHARGES = "product_charges";
    private InvoiceSummaryProductCharges productCharges;

    public static final String JSON_PROPERTY_OVERAGES = "overages";
    private InvoiceSummaryOverages overages;

    public static final String JSON_PROPERTY_TAXES = "taxes";
    private InvoiceSummaryTaxes taxes;

    public static final String JSON_PROPERTY_CREDITS_AND_ADJUSTMENTS = "credits_and_adjustments";
    private InvoiceSummaryCreditsAndAdjustments creditsAndAdjustments;

    public InvoiceSummary() {
    }

    public InvoiceSummary invoiceUuid(String invoiceUuid) {
        this.invoiceUuid = invoiceUuid;
        return this;
    }

    /**
     * UUID of the invoice
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

    public InvoiceSummary billingPeriod(String billingPeriod) {
        this.billingPeriod = billingPeriod;
        return this;
    }

    /**
     * Billing period of usage for which the invoice is issued, in
     * &#x60;YYYY-MM&#x60; format.
     *
     * @return billingPeriod
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_BILLING_PERIOD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getBillingPeriod() {
        return billingPeriod;
    }

    @JsonProperty(JSON_PROPERTY_BILLING_PERIOD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setBillingPeriod(String billingPeriod) {
        this.billingPeriod = billingPeriod;
    }

    public InvoiceSummary amount(String amount) {
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

    public InvoiceSummary userName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * Name of the DigitalOcean customer being invoiced.
     *
     * @return userName
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_USER_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUserName() {
        return userName;
    }

    @JsonProperty(JSON_PROPERTY_USER_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public InvoiceSummary userBillingAddress(InvoiceSummaryUserBillingAddress userBillingAddress) {
        this.userBillingAddress = userBillingAddress;
        return this;
    }

    /**
     * Get userBillingAddress
     *
     * @return userBillingAddress
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_USER_BILLING_ADDRESS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public InvoiceSummaryUserBillingAddress getUserBillingAddress() {
        return userBillingAddress;
    }

    @JsonProperty(JSON_PROPERTY_USER_BILLING_ADDRESS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUserBillingAddress(InvoiceSummaryUserBillingAddress userBillingAddress) {
        this.userBillingAddress = userBillingAddress;
    }

    public InvoiceSummary userCompany(String userCompany) {
        this.userCompany = userCompany;
        return this;
    }

    /**
     * Company of the DigitalOcean customer being invoiced, if set.
     *
     * @return userCompany
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_USER_COMPANY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUserCompany() {
        return userCompany;
    }

    @JsonProperty(JSON_PROPERTY_USER_COMPANY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUserCompany(String userCompany) {
        this.userCompany = userCompany;
    }

    public InvoiceSummary userEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }

    /**
     * Email of the DigitalOcean customer being invoiced.
     *
     * @return userEmail
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_USER_EMAIL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUserEmail() {
        return userEmail;
    }

    @JsonProperty(JSON_PROPERTY_USER_EMAIL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public InvoiceSummary productCharges(InvoiceSummaryProductCharges productCharges) {
        this.productCharges = productCharges;
        return this;
    }

    /**
     * Get productCharges
     *
     * @return productCharges
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PRODUCT_CHARGES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public InvoiceSummaryProductCharges getProductCharges() {
        return productCharges;
    }

    @JsonProperty(JSON_PROPERTY_PRODUCT_CHARGES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProductCharges(InvoiceSummaryProductCharges productCharges) {
        this.productCharges = productCharges;
    }

    public InvoiceSummary overages(InvoiceSummaryOverages overages) {
        this.overages = overages;
        return this;
    }

    /**
     * Get overages
     *
     * @return overages
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_OVERAGES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public InvoiceSummaryOverages getOverages() {
        return overages;
    }

    @JsonProperty(JSON_PROPERTY_OVERAGES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setOverages(InvoiceSummaryOverages overages) {
        this.overages = overages;
    }

    public InvoiceSummary taxes(InvoiceSummaryTaxes taxes) {
        this.taxes = taxes;
        return this;
    }

    /**
     * Get taxes
     *
     * @return taxes
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TAXES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public InvoiceSummaryTaxes getTaxes() {
        return taxes;
    }

    @JsonProperty(JSON_PROPERTY_TAXES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTaxes(InvoiceSummaryTaxes taxes) {
        this.taxes = taxes;
    }

    public InvoiceSummary creditsAndAdjustments(InvoiceSummaryCreditsAndAdjustments creditsAndAdjustments) {
        this.creditsAndAdjustments = creditsAndAdjustments;
        return this;
    }

    /**
     * Get creditsAndAdjustments
     *
     * @return creditsAndAdjustments
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREDITS_AND_ADJUSTMENTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public InvoiceSummaryCreditsAndAdjustments getCreditsAndAdjustments() {
        return creditsAndAdjustments;
    }

    @JsonProperty(JSON_PROPERTY_CREDITS_AND_ADJUSTMENTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCreditsAndAdjustments(InvoiceSummaryCreditsAndAdjustments creditsAndAdjustments) {
        this.creditsAndAdjustments = creditsAndAdjustments;
    }

    /**
     * Return true if this invoice_summary object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InvoiceSummary invoiceSummary = (InvoiceSummary) o;
        return Objects.equals(this.invoiceUuid, invoiceSummary.invoiceUuid)
                && Objects.equals(this.billingPeriod, invoiceSummary.billingPeriod)
                && Objects.equals(this.amount, invoiceSummary.amount)
                && Objects.equals(this.userName, invoiceSummary.userName)
                && Objects.equals(this.userBillingAddress, invoiceSummary.userBillingAddress)
                && Objects.equals(this.userCompany, invoiceSummary.userCompany)
                && Objects.equals(this.userEmail, invoiceSummary.userEmail)
                && Objects.equals(this.productCharges, invoiceSummary.productCharges)
                && Objects.equals(this.overages, invoiceSummary.overages)
                && Objects.equals(this.taxes, invoiceSummary.taxes)
                && Objects.equals(this.creditsAndAdjustments, invoiceSummary.creditsAndAdjustments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceUuid, billingPeriod, amount, userName, userBillingAddress, userCompany, userEmail,
                productCharges, overages, taxes, creditsAndAdjustments);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InvoiceSummary {\n");
        sb.append("    invoiceUuid: ").append(toIndentedString(invoiceUuid)).append("\n");
        sb.append("    billingPeriod: ").append(toIndentedString(billingPeriod)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
        sb.append("    userBillingAddress: ").append(toIndentedString(userBillingAddress)).append("\n");
        sb.append("    userCompany: ").append(toIndentedString(userCompany)).append("\n");
        sb.append("    userEmail: ").append(toIndentedString(userEmail)).append("\n");
        sb.append("    productCharges: ").append(toIndentedString(productCharges)).append("\n");
        sb.append("    overages: ").append(toIndentedString(overages)).append("\n");
        sb.append("    taxes: ").append(toIndentedString(taxes)).append("\n");
        sb.append("    creditsAndAdjustments: ").append(toIndentedString(creditsAndAdjustments)).append("\n");
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
