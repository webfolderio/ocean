package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * BillingAddress
 */
@JsonPropertyOrder({ BillingAddress.JSON_PROPERTY_ADDRESS_LINE1, BillingAddress.JSON_PROPERTY_ADDRESS_LINE2,
        BillingAddress.JSON_PROPERTY_CITY, BillingAddress.JSON_PROPERTY_REGION,
        BillingAddress.JSON_PROPERTY_POSTAL_CODE, BillingAddress.JSON_PROPERTY_COUNTRY_ISO2_CODE,
        BillingAddress.JSON_PROPERTY_CREATED_AT, BillingAddress.JSON_PROPERTY_UPDATED_AT })
public class BillingAddress {
    public static final String JSON_PROPERTY_ADDRESS_LINE1 = "address_line1";
    private String addressLine1;

    public static final String JSON_PROPERTY_ADDRESS_LINE2 = "address_line2";
    private String addressLine2;

    public static final String JSON_PROPERTY_CITY = "city";
    private String city;

    public static final String JSON_PROPERTY_REGION = "region";
    private String region;

    public static final String JSON_PROPERTY_POSTAL_CODE = "postal_code";
    private String postalCode;

    public static final String JSON_PROPERTY_COUNTRY_ISO2_CODE = "country_iso2_code";
    private String countryIso2Code;

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    private String createdAt;

    public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
    private String updatedAt;

    public BillingAddress() {
    }

    public BillingAddress addressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    /**
     * Street address line 1
     *
     * @return addressLine1
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ADDRESS_LINE1)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getAddressLine1() {
        return addressLine1;
    }

    @JsonProperty(JSON_PROPERTY_ADDRESS_LINE1)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public BillingAddress addressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    /**
     * Street address line 2
     *
     * @return addressLine2
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ADDRESS_LINE2)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getAddressLine2() {
        return addressLine2;
    }

    @JsonProperty(JSON_PROPERTY_ADDRESS_LINE2)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public BillingAddress city(String city) {
        this.city = city;
        return this;
    }

    /**
     * City
     *
     * @return city
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CITY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getCity() {
        return city;
    }

    @JsonProperty(JSON_PROPERTY_CITY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCity(String city) {
        this.city = city;
    }

    public BillingAddress region(String region) {
        this.region = region;
        return this;
    }

    /**
     * Region
     *
     * @return region
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getRegion() {
        return region;
    }

    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRegion(String region) {
        this.region = region;
    }

    public BillingAddress postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    /**
     * Postal code
     *
     * @return postalCode
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_POSTAL_CODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPostalCode() {
        return postalCode;
    }

    @JsonProperty(JSON_PROPERTY_POSTAL_CODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public BillingAddress countryIso2Code(String countryIso2Code) {
        this.countryIso2Code = countryIso2Code;
        return this;
    }

    /**
     * Country (ISO2) code
     *
     * @return countryIso2Code
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_COUNTRY_ISO2_CODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCountryIso2Code() {
        return countryIso2Code;
    }

    @JsonProperty(JSON_PROPERTY_COUNTRY_ISO2_CODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCountryIso2Code(String countryIso2Code) {
        this.countryIso2Code = countryIso2Code;
    }

    public BillingAddress createdAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Timestamp billing address was created
     *
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public BillingAddress updatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * Timestamp billing address was updated
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
     * Return true if this billing_address object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BillingAddress billingAddress = (BillingAddress) o;
        return Objects.equals(this.addressLine1, billingAddress.addressLine1)
                && Objects.equals(this.addressLine2, billingAddress.addressLine2)
                && Objects.equals(this.city, billingAddress.city) && Objects.equals(this.region, billingAddress.region)
                && Objects.equals(this.postalCode, billingAddress.postalCode)
                && Objects.equals(this.countryIso2Code, billingAddress.countryIso2Code)
                && Objects.equals(this.createdAt, billingAddress.createdAt)
                && Objects.equals(this.updatedAt, billingAddress.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressLine1, addressLine2, city, region, postalCode, countryIso2Code, createdAt,
                updatedAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BillingAddress {\n");
        sb.append("    addressLine1: ").append(toIndentedString(addressLine1)).append("\n");
        sb.append("    addressLine2: ").append(toIndentedString(addressLine2)).append("\n");
        sb.append("    city: ").append(toIndentedString(city)).append("\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
        sb.append("    countryIso2Code: ").append(toIndentedString(countryIso2Code)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
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