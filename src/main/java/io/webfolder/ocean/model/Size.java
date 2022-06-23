package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Size
 */
@JsonPropertyOrder({ Size.JSON_PROPERTY_SLUG, Size.JSON_PROPERTY_MEMORY, Size.JSON_PROPERTY_VCPUS,
        Size.JSON_PROPERTY_DISK, Size.JSON_PROPERTY_TRANSFER, Size.JSON_PROPERTY_PRICE_MONTHLY,
        Size.JSON_PROPERTY_PRICE_HOURLY, Size.JSON_PROPERTY_REGIONS, Size.JSON_PROPERTY_AVAILABLE,
        Size.JSON_PROPERTY_DESCRIPTION })
public class Size {
    public static final String JSON_PROPERTY_SLUG = "slug";
    private String slug;

    public static final String JSON_PROPERTY_MEMORY = "memory";
    private Integer memory;

    public static final String JSON_PROPERTY_VCPUS = "vcpus";
    private Integer vcpus;

    public static final String JSON_PROPERTY_DISK = "disk";
    private Integer disk;

    public static final String JSON_PROPERTY_TRANSFER = "transfer";
    private Float transfer;

    public static final String JSON_PROPERTY_PRICE_MONTHLY = "price_monthly";
    private Float priceMonthly;

    public static final String JSON_PROPERTY_PRICE_HOURLY = "price_hourly";
    private Float priceHourly;

    public static final String JSON_PROPERTY_REGIONS = "regions";
    private List<String> regions = new ArrayList<>();

    public static final String JSON_PROPERTY_AVAILABLE = "available";
    private Boolean available = true;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public Size() {
    }

    public Size slug(String slug) {
        this.slug = slug;
        return this;
    }

    /**
     * A human-readable string that is used to uniquely identify each size.
     *
     * @return slug
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_SLUG)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getSlug() {
        return slug;
    }

    @JsonProperty(JSON_PROPERTY_SLUG)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Size memory(Integer memory) {
        this.memory = memory;
        return this;
    }

    /**
     * The amount of RAM allocated to Droplets created of this size. The value is
     * represented in megabytes. minimum: 8
     *
     * @return memory
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_MEMORY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Integer getMemory() {
        return memory;
    }

    @JsonProperty(JSON_PROPERTY_MEMORY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public Size vcpus(Integer vcpus) {
        this.vcpus = vcpus;
        return this;
    }

    /**
     * The integer of number CPUs allocated to Droplets of this size.
     *
     * @return vcpus
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_VCPUS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Integer getVcpus() {
        return vcpus;
    }

    @JsonProperty(JSON_PROPERTY_VCPUS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setVcpus(Integer vcpus) {
        this.vcpus = vcpus;
    }

    public Size disk(Integer disk) {
        this.disk = disk;
        return this;
    }

    /**
     * The amount of disk space set aside for Droplets of this size. The value is
     * represented in gigabytes.
     *
     * @return disk
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DISK)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Integer getDisk() {
        return disk;
    }

    @JsonProperty(JSON_PROPERTY_DISK)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDisk(Integer disk) {
        this.disk = disk;
    }

    public Size transfer(Float transfer) {
        this.transfer = transfer;
        return this;
    }

    /**
     * The amount of transfer bandwidth that is available for Droplets created in
     * this size. This only counts traffic on the public interface. The value is
     * given in terabytes.
     *
     * @return transfer
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_TRANSFER)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Float getTransfer() {
        return transfer;
    }

    @JsonProperty(JSON_PROPERTY_TRANSFER)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setTransfer(Float transfer) {
        this.transfer = transfer;
    }

    public Size priceMonthly(Float priceMonthly) {
        this.priceMonthly = priceMonthly;
        return this;
    }

    /**
     * This attribute describes the monthly cost of this Droplet size if the Droplet
     * is kept for an entire month. The value is measured in US dollars.
     *
     * @return priceMonthly
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_PRICE_MONTHLY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Float getPriceMonthly() {
        return priceMonthly;
    }

    @JsonProperty(JSON_PROPERTY_PRICE_MONTHLY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setPriceMonthly(Float priceMonthly) {
        this.priceMonthly = priceMonthly;
    }

    public Size priceHourly(Float priceHourly) {
        this.priceHourly = priceHourly;
        return this;
    }

    /**
     * This describes the price of the Droplet size as measured hourly. The value is
     * measured in US dollars.
     *
     * @return priceHourly
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_PRICE_HOURLY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Float getPriceHourly() {
        return priceHourly;
    }

    @JsonProperty(JSON_PROPERTY_PRICE_HOURLY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setPriceHourly(Float priceHourly) {
        this.priceHourly = priceHourly;
    }

    public Size regions(List<String> regions) {
        this.regions = regions;
        return this;
    }

    public Size addRegionsItem(String regionsItem) {
        this.regions.add(regionsItem);
        return this;
    }

    /**
     * An array containing the region slugs where this size is available for Droplet
     * creates.
     *
     * @return regions
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_REGIONS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<String> getRegions() {
        return regions;
    }

    @JsonProperty(JSON_PROPERTY_REGIONS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setRegions(List<String> regions) {
        this.regions = regions;
    }

    public Size available(Boolean available) {
        this.available = available;
        return this;
    }

    /**
     * This is a boolean value that represents whether new Droplets can be created
     * with this size.
     *
     * @return available
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_AVAILABLE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Boolean getAvailable() {
        return available;
    }

    @JsonProperty(JSON_PROPERTY_AVAILABLE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Size description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A string describing the class of Droplets created from this size. For
     * example: Basic, General Purpose, CPU-Optimized, Memory-Optimized, or
     * Storage-Optimized.
     *
     * @return description
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getDescription() {
        return description;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Return true if this size object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Size size = (Size) o;
        return Objects.equals(this.slug, size.slug) && Objects.equals(this.memory, size.memory)
                && Objects.equals(this.vcpus, size.vcpus) && Objects.equals(this.disk, size.disk)
                && Objects.equals(this.transfer, size.transfer) && Objects.equals(this.priceMonthly, size.priceMonthly)
                && Objects.equals(this.priceHourly, size.priceHourly) && Objects.equals(this.regions, size.regions)
                && Objects.equals(this.available, size.available) && Objects.equals(this.description, size.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(slug, memory, vcpus, disk, transfer, priceMonthly, priceHourly, regions, available,
                description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Size {\n");
        sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
        sb.append("    memory: ").append(toIndentedString(memory)).append("\n");
        sb.append("    vcpus: ").append(toIndentedString(vcpus)).append("\n");
        sb.append("    disk: ").append(toIndentedString(disk)).append("\n");
        sb.append("    transfer: ").append(toIndentedString(transfer)).append("\n");
        sb.append("    priceMonthly: ").append(toIndentedString(priceMonthly)).append("\n");
        sb.append("    priceHourly: ").append(toIndentedString(priceHourly)).append("\n");
        sb.append("    regions: ").append(toIndentedString(regions)).append("\n");
        sb.append("    available: ").append(toIndentedString(available)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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