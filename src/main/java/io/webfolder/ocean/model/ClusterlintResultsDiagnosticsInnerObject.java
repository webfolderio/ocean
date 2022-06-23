package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Metadata about the Kubernetes API object the diagnostic is reported on.
 */
@JsonPropertyOrder({ ClusterlintResultsDiagnosticsInnerObject.JSON_PROPERTY_NAME,
        ClusterlintResultsDiagnosticsInnerObject.JSON_PROPERTY_KIND,
        ClusterlintResultsDiagnosticsInnerObject.JSON_PROPERTY_NAMESPACE })
public class ClusterlintResultsDiagnosticsInnerObject {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_KIND = "kind";
    private String kind;

    public static final String JSON_PROPERTY_NAMESPACE = "namespace";
    private String namespace;

    public ClusterlintResultsDiagnosticsInnerObject() {
    }

    public ClusterlintResultsDiagnosticsInnerObject name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Name of the object
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

    public ClusterlintResultsDiagnosticsInnerObject kind(String kind) {
        this.kind = kind;
        return this;
    }

    /**
     * The kind of Kubernetes API object
     *
     * @return kind
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_KIND)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getKind() {
        return kind;
    }

    @JsonProperty(JSON_PROPERTY_KIND)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setKind(String kind) {
        this.kind = kind;
    }

    public ClusterlintResultsDiagnosticsInnerObject namespace(String namespace) {
        this.namespace = namespace;
        return this;
    }

    /**
     * The namespace the object resides in the cluster.
     *
     * @return namespace
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NAMESPACE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getNamespace() {
        return namespace;
    }

    @JsonProperty(JSON_PROPERTY_NAMESPACE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * Return true if this clusterlint_results_diagnostics_inner_object object is
     * equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClusterlintResultsDiagnosticsInnerObject clusterlintResultsDiagnosticsInnerObject = (ClusterlintResultsDiagnosticsInnerObject) o;
        return Objects.equals(this.name, clusterlintResultsDiagnosticsInnerObject.name)
                && Objects.equals(this.kind, clusterlintResultsDiagnosticsInnerObject.kind)
                && Objects.equals(this.namespace, clusterlintResultsDiagnosticsInnerObject.namespace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, kind, namespace);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ClusterlintResultsDiagnosticsInnerObject {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
        sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
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