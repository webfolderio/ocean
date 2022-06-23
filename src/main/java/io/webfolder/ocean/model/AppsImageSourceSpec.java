package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * AppsImageSourceSpec
 */
@JsonPropertyOrder({ AppsImageSourceSpec.JSON_PROPERTY_REGISTRY, AppsImageSourceSpec.JSON_PROPERTY_REGISTRY_TYPE,
        AppsImageSourceSpec.JSON_PROPERTY_REPOSITORY, AppsImageSourceSpec.JSON_PROPERTY_TAG })
public class AppsImageSourceSpec {
    public static final String JSON_PROPERTY_REGISTRY = "registry";
    private String registry;

    /**
     * - DOCKER_HUB: The DockerHub container registry type. - DOCR: The DigitalOcean
     * container registry type.
     */
    public enum RegistryTypeEnum {
        DOCKER_HUB("DOCKER_HUB"),

        DOCR("DOCR");

        private String value;

        RegistryTypeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static RegistryTypeEnum fromValue(String value) {
            for (RegistryTypeEnum b : RegistryTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_REGISTRY_TYPE = "registry_type";
    private RegistryTypeEnum registryType;

    public static final String JSON_PROPERTY_REPOSITORY = "repository";
    private String repository;

    public static final String JSON_PROPERTY_TAG = "tag";
    private String tag = "latest";

    public AppsImageSourceSpec() {
    }

    public AppsImageSourceSpec registry(String registry) {
        this.registry = registry;
        return this;
    }

    /**
     * The registry name. Must be left empty for the &#x60;DOCR&#x60; registry type.
     *
     * @return registry
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REGISTRY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getRegistry() {
        return registry;
    }

    @JsonProperty(JSON_PROPERTY_REGISTRY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRegistry(String registry) {
        this.registry = registry;
    }

    public AppsImageSourceSpec registryType(RegistryTypeEnum registryType) {
        this.registryType = registryType;
        return this;
    }

    /**
     * - DOCKER_HUB: The DockerHub container registry type. - DOCR: The DigitalOcean
     * container registry type.
     *
     * @return registryType
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REGISTRY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public RegistryTypeEnum getRegistryType() {
        return registryType;
    }

    @JsonProperty(JSON_PROPERTY_REGISTRY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRegistryType(RegistryTypeEnum registryType) {
        this.registryType = registryType;
    }

    public AppsImageSourceSpec repository(String repository) {
        this.repository = repository;
        return this;
    }

    /**
     * The repository name.
     *
     * @return repository
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REPOSITORY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getRepository() {
        return repository;
    }

    @JsonProperty(JSON_PROPERTY_REPOSITORY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRepository(String repository) {
        this.repository = repository;
    }

    public AppsImageSourceSpec tag(String tag) {
        this.tag = tag;
        return this;
    }

    /**
     * The repository tag. Defaults to &#x60;latest&#x60; if not provided.
     *
     * @return tag
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TAG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTag() {
        return tag;
    }

    @JsonProperty(JSON_PROPERTY_TAG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * Return true if this apps_image_source_spec object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsImageSourceSpec appsImageSourceSpec = (AppsImageSourceSpec) o;
        return Objects.equals(this.registry, appsImageSourceSpec.registry)
                && Objects.equals(this.registryType, appsImageSourceSpec.registryType)
                && Objects.equals(this.repository, appsImageSourceSpec.repository)
                && Objects.equals(this.tag, appsImageSourceSpec.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registry, registryType, repository, tag);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsImageSourceSpec {\n");
        sb.append("    registry: ").append(toIndentedString(registry)).append("\n");
        sb.append("    registryType: ").append(toIndentedString(registryType)).append("\n");
        sb.append("    repository: ").append(toIndentedString(repository)).append("\n");
        sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
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