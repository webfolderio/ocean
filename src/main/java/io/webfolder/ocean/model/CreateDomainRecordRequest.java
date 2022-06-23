package io.webfolder.ocean.model;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import io.webfolder.ocean.client.internal.JSON;

@JsonDeserialize(using = CreateDomainRecordRequest.CreateDomainRecordRequestDeserializer.class)
@JsonSerialize(using = CreateDomainRecordRequest.CreateDomainRecordRequestSerializer.class)
public class CreateDomainRecordRequest extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(CreateDomainRecordRequest.class.getName());

    public static class CreateDomainRecordRequestSerializer extends StdSerializer<CreateDomainRecordRequest> {
        public CreateDomainRecordRequestSerializer(Class<CreateDomainRecordRequest> t) {
            super(t);
        }

        public CreateDomainRecordRequestSerializer() {
            this(null);
        }

        @Override
        public void serialize(CreateDomainRecordRequest value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class CreateDomainRecordRequestDeserializer extends StdDeserializer<CreateDomainRecordRequest> {
        public CreateDomainRecordRequestDeserializer() {
            this(CreateDomainRecordRequest.class);
        }

        public CreateDomainRecordRequestDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public CreateDomainRecordRequest deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();

            Object deserialized = null;
            Class<?> cls = JSON.getClassForElement(tree, CreateDomainRecordRequest.class);
            if (cls != null) {
                // When the OAS schema includes a discriminator, use the discriminator value to
                // discriminate the anyOf schemas.
                // Get the discriminator mapping value to get the class.
                deserialized = tree.traverse(jp.getCodec()).readValueAs(cls);
                CreateDomainRecordRequest ret = new CreateDomainRecordRequest();
                ret.setActualInstance(deserialized);
                return ret;
            }
            // deserialize DomainRecordA
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(DomainRecordA.class);
                CreateDomainRecordRequest ret = new CreateDomainRecordRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'CreateDomainRecordRequest'", e);
            }

            // deserialize DomainRecordAaaa
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(DomainRecordAaaa.class);
                CreateDomainRecordRequest ret = new CreateDomainRecordRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'CreateDomainRecordRequest'", e);
            }

            // deserialize DomainRecordCaa
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(DomainRecordCaa.class);
                CreateDomainRecordRequest ret = new CreateDomainRecordRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'CreateDomainRecordRequest'", e);
            }

            // deserialize DomainRecordCname
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(DomainRecordCname.class);
                CreateDomainRecordRequest ret = new CreateDomainRecordRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'CreateDomainRecordRequest'", e);
            }

            // deserialize DomainRecordMx
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(DomainRecordMx.class);
                CreateDomainRecordRequest ret = new CreateDomainRecordRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'CreateDomainRecordRequest'", e);
            }

            // deserialize DomainRecordNs
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(DomainRecordNs.class);
                CreateDomainRecordRequest ret = new CreateDomainRecordRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'CreateDomainRecordRequest'", e);
            }

            // deserialize DomainRecordSoa
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(DomainRecordSoa.class);
                CreateDomainRecordRequest ret = new CreateDomainRecordRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'CreateDomainRecordRequest'", e);
            }

            // deserialize DomainRecordSrv
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(DomainRecordSrv.class);
                CreateDomainRecordRequest ret = new CreateDomainRecordRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'CreateDomainRecordRequest'", e);
            }

            // deserialize DomainRecordTxt
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(DomainRecordTxt.class);
                CreateDomainRecordRequest ret = new CreateDomainRecordRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'CreateDomainRecordRequest'", e);
            }

            throw new IOException(
                    String.format("Failed deserialization for CreateDomainRecordRequest: no match found"));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public CreateDomainRecordRequest getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "CreateDomainRecordRequest cannot be null");
        }
    }

    // store a list of schema names defined in anyOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public CreateDomainRecordRequest() {
        super("anyOf", Boolean.FALSE);
    }

    public CreateDomainRecordRequest(DomainRecordA o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public CreateDomainRecordRequest(DomainRecordAaaa o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public CreateDomainRecordRequest(DomainRecordCaa o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public CreateDomainRecordRequest(DomainRecordCname o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public CreateDomainRecordRequest(DomainRecordMx o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public CreateDomainRecordRequest(DomainRecordNs o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public CreateDomainRecordRequest(DomainRecordSoa o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public CreateDomainRecordRequest(DomainRecordSrv o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public CreateDomainRecordRequest(DomainRecordTxt o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("DomainRecordA", DomainRecordA.class);
        schemas.put("DomainRecordAaaa", DomainRecordAaaa.class);
        schemas.put("DomainRecordCaa", DomainRecordCaa.class);
        schemas.put("DomainRecordCname", DomainRecordCname.class);
        schemas.put("DomainRecordMx", DomainRecordMx.class);
        schemas.put("DomainRecordNs", DomainRecordNs.class);
        schemas.put("DomainRecordSoa", DomainRecordSoa.class);
        schemas.put("DomainRecordSrv", DomainRecordSrv.class);
        schemas.put("DomainRecordTxt", DomainRecordTxt.class);
        JSON.registerDescendants(CreateDomainRecordRequest.class, Collections.unmodifiableMap(schemas));
        // Initialize and register the discriminator mappings.
        Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
        mappings.put("A", DomainRecordA.class);
        mappings.put("AAAA", DomainRecordAaaa.class);
        mappings.put("CAA", DomainRecordCaa.class);
        mappings.put("CNAME", DomainRecordCname.class);
        mappings.put("MX", DomainRecordMx.class);
        mappings.put("NS", DomainRecordNs.class);
        mappings.put("SOA", DomainRecordSoa.class);
        mappings.put("SRV", DomainRecordSrv.class);
        mappings.put("TXT", DomainRecordTxt.class);
        mappings.put("domain_record_a", DomainRecordA.class);
        mappings.put("domain_record_aaaa", DomainRecordAaaa.class);
        mappings.put("domain_record_caa", DomainRecordCaa.class);
        mappings.put("domain_record_cname", DomainRecordCname.class);
        mappings.put("domain_record_mx", DomainRecordMx.class);
        mappings.put("domain_record_ns", DomainRecordNs.class);
        mappings.put("domain_record_soa", DomainRecordSoa.class);
        mappings.put("domain_record_srv", DomainRecordSrv.class);
        mappings.put("domain_record_txt", DomainRecordTxt.class);
        mappings.put("create_domain_record_request", CreateDomainRecordRequest.class);
        JSON.registerDiscriminator(CreateDomainRecordRequest.class, "type", mappings);
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return CreateDomainRecordRequest.schemas;
    }

    /**
     * Set the instance that matches the anyOf child schema, check the instance
     * parameter is valid against the anyOf child schemas: DomainRecordA,
     * DomainRecordAaaa, DomainRecordCaa, DomainRecordCname, DomainRecordMx,
     * DomainRecordNs, DomainRecordSoa, DomainRecordSrv, DomainRecordTxt
     *
     * It could be an instance of the 'anyOf' schemas. The anyOf child schemas may
     * themselves be a composed schema (allOf, anyOf, anyOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(DomainRecordA.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(DomainRecordAaaa.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(DomainRecordCaa.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(DomainRecordCname.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(DomainRecordMx.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(DomainRecordNs.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(DomainRecordSoa.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(DomainRecordSrv.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(DomainRecordTxt.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException(
                "Invalid instance type. Must be DomainRecordA, DomainRecordAaaa, DomainRecordCaa, DomainRecordCname, DomainRecordMx, DomainRecordNs, DomainRecordSoa, DomainRecordSrv, DomainRecordTxt");
    }

    /**
     * Get the actual instance, which can be the following: DomainRecordA,
     * DomainRecordAaaa, DomainRecordCaa, DomainRecordCname, DomainRecordMx,
     * DomainRecordNs, DomainRecordSoa, DomainRecordSrv, DomainRecordTxt
     *
     * @return The actual instance (DomainRecordA, DomainRecordAaaa,
     *         DomainRecordCaa, DomainRecordCname, DomainRecordMx, DomainRecordNs,
     *         DomainRecordSoa, DomainRecordSrv, DomainRecordTxt)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `DomainRecordA`. If the actual instance is not
     * `DomainRecordA`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `DomainRecordA`
     * @throws ClassCastException if the instance is not `DomainRecordA`
     */
    public DomainRecordA getDomainRecordA() throws ClassCastException {
        return (DomainRecordA) super.getActualInstance();
    }

    /**
     * Get the actual instance of `DomainRecordAaaa`. If the actual instance is not
     * `DomainRecordAaaa`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `DomainRecordAaaa`
     * @throws ClassCastException if the instance is not `DomainRecordAaaa`
     */
    public DomainRecordAaaa getDomainRecordAaaa() throws ClassCastException {
        return (DomainRecordAaaa) super.getActualInstance();
    }

    /**
     * Get the actual instance of `DomainRecordCaa`. If the actual instance is not
     * `DomainRecordCaa`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `DomainRecordCaa`
     * @throws ClassCastException if the instance is not `DomainRecordCaa`
     */
    public DomainRecordCaa getDomainRecordCaa() throws ClassCastException {
        return (DomainRecordCaa) super.getActualInstance();
    }

    /**
     * Get the actual instance of `DomainRecordCname`. If the actual instance is not
     * `DomainRecordCname`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `DomainRecordCname`
     * @throws ClassCastException if the instance is not `DomainRecordCname`
     */
    public DomainRecordCname getDomainRecordCname() throws ClassCastException {
        return (DomainRecordCname) super.getActualInstance();
    }

    /**
     * Get the actual instance of `DomainRecordMx`. If the actual instance is not
     * `DomainRecordMx`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `DomainRecordMx`
     * @throws ClassCastException if the instance is not `DomainRecordMx`
     */
    public DomainRecordMx getDomainRecordMx() throws ClassCastException {
        return (DomainRecordMx) super.getActualInstance();
    }

    /**
     * Get the actual instance of `DomainRecordNs`. If the actual instance is not
     * `DomainRecordNs`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `DomainRecordNs`
     * @throws ClassCastException if the instance is not `DomainRecordNs`
     */
    public DomainRecordNs getDomainRecordNs() throws ClassCastException {
        return (DomainRecordNs) super.getActualInstance();
    }

    /**
     * Get the actual instance of `DomainRecordSoa`. If the actual instance is not
     * `DomainRecordSoa`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `DomainRecordSoa`
     * @throws ClassCastException if the instance is not `DomainRecordSoa`
     */
    public DomainRecordSoa getDomainRecordSoa() throws ClassCastException {
        return (DomainRecordSoa) super.getActualInstance();
    }

    /**
     * Get the actual instance of `DomainRecordSrv`. If the actual instance is not
     * `DomainRecordSrv`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `DomainRecordSrv`
     * @throws ClassCastException if the instance is not `DomainRecordSrv`
     */
    public DomainRecordSrv getDomainRecordSrv() throws ClassCastException {
        return (DomainRecordSrv) super.getActualInstance();
    }

    /**
     * Get the actual instance of `DomainRecordTxt`. If the actual instance is not
     * `DomainRecordTxt`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `DomainRecordTxt`
     * @throws ClassCastException if the instance is not `DomainRecordTxt`
     */
    public DomainRecordTxt getDomainRecordTxt() throws ClassCastException {
        return (DomainRecordTxt) super.getActualInstance();
    }
}