package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * **Note**: All Droplets created after March 2017 use internal kernels by
 * default. These Droplets will have this attribute set to &#x60;null&#x60;. The
 * current [kernel](https://www.digitalocean.com/docs/droplets/how-to/kernel/)
 * for Droplets with externally managed kernels. This will initially be set to
 * the kernel of the base image when the Droplet is created.
 *
 * @deprecated
 */
@Deprecated
@JsonPropertyOrder({ Kernel.JSON_PROPERTY_ID, Kernel.JSON_PROPERTY_NAME, Kernel.JSON_PROPERTY_VERSION })
public class Kernel {
    public static final String JSON_PROPERTY_ID = "id";
    private Integer id;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_VERSION = "version";
    private String version;

    public Kernel() {
    }

    public Kernel id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * A unique number used to identify and reference a specific kernel.
     *
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getId() {
        return id;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setId(Integer id) {
        this.id = id;
    }

    public Kernel name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The display name of the kernel. This is shown in the web UI and is generally
     * a descriptive title for the kernel in question.
     *
     * @return name
     **/
    @javax.annotation.Nullable
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

    public Kernel version(String version) {
        this.version = version;
        return this;
    }

    /**
     * A standard kernel version string representing the version, patch, and release
     * information.
     *
     * @return version
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getVersion() {
        return version;
    }

    @JsonProperty(JSON_PROPERTY_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Return true if this kernel object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Kernel kernel = (Kernel) o;
        return Objects.equals(this.id, kernel.id) && Objects.equals(this.name, kernel.name)
                && Objects.equals(this.version, kernel.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, version);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Kernel {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
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
