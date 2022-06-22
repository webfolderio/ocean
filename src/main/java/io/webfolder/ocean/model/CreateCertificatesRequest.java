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
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import io.webfolder.ocean.JSON;

@JsonDeserialize(using = CreateCertificatesRequest.CreateCertificatesRequestDeserializer.class)
@JsonSerialize(using = CreateCertificatesRequest.CreateCertificatesRequestSerializer.class)
public class CreateCertificatesRequest extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(CreateCertificatesRequest.class.getName());

    public static class CreateCertificatesRequestSerializer extends StdSerializer<CreateCertificatesRequest> {
        public CreateCertificatesRequestSerializer(Class<CreateCertificatesRequest> t) {
            super(t);
        }

        public CreateCertificatesRequestSerializer() {
            this(null);
        }

        @Override
        public void serialize(CreateCertificatesRequest value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class CreateCertificatesRequestDeserializer extends StdDeserializer<CreateCertificatesRequest> {
        public CreateCertificatesRequestDeserializer() {
            this(CreateCertificatesRequest.class);
        }

        public CreateCertificatesRequestDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public CreateCertificatesRequest deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();
            Object deserialized = null;
            boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
            int match = 0;
            JsonToken token = tree.traverse(jp.getCodec()).nextToken();
            // deserialize CertificateRequestCustom
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (CertificateRequestCustom.class.equals(Integer.class)
                        || CertificateRequestCustom.class.equals(Long.class)
                        || CertificateRequestCustom.class.equals(Float.class)
                        || CertificateRequestCustom.class.equals(Double.class)
                        || CertificateRequestCustom.class.equals(Boolean.class)
                        || CertificateRequestCustom.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((CertificateRequestCustom.class.equals(Integer.class)
                                || CertificateRequestCustom.class.equals(Long.class))
                                && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((CertificateRequestCustom.class.equals(Float.class)
                                || CertificateRequestCustom.class.equals(Double.class))
                                && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (CertificateRequestCustom.class.equals(Boolean.class)
                                && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (CertificateRequestCustom.class.equals(String.class)
                                && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(CertificateRequestCustom.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'CertificateRequestCustom'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'CertificateRequestCustom'", e);
            }

            // deserialize CertificateRequestLetsEncrypt
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (CertificateRequestLetsEncrypt.class.equals(Integer.class)
                        || CertificateRequestLetsEncrypt.class.equals(Long.class)
                        || CertificateRequestLetsEncrypt.class.equals(Float.class)
                        || CertificateRequestLetsEncrypt.class.equals(Double.class)
                        || CertificateRequestLetsEncrypt.class.equals(Boolean.class)
                        || CertificateRequestLetsEncrypt.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((CertificateRequestLetsEncrypt.class.equals(Integer.class)
                                || CertificateRequestLetsEncrypt.class.equals(Long.class))
                                && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((CertificateRequestLetsEncrypt.class.equals(Float.class)
                                || CertificateRequestLetsEncrypt.class.equals(Double.class))
                                && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (CertificateRequestLetsEncrypt.class.equals(Boolean.class)
                                && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (CertificateRequestLetsEncrypt.class.equals(String.class)
                                && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(CertificateRequestLetsEncrypt.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'CertificateRequestLetsEncrypt'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'CertificateRequestLetsEncrypt'", e);
            }

            if (match == 1) {
                CreateCertificatesRequest ret = new CreateCertificatesRequest();
                ret.setActualInstance(deserialized);
                return ret;
            }
            throw new IOException(String.format(
                    "Failed deserialization for CreateCertificatesRequest: %d classes match result, expected 1",
                    match));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public CreateCertificatesRequest getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "CreateCertificatesRequest cannot be null");
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, Class<?>> schemas = new HashMap<>();

    public CreateCertificatesRequest() {
        super("oneOf", Boolean.FALSE);
    }

    public CreateCertificatesRequest(CertificateRequestCustom o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public CreateCertificatesRequest(CertificateRequestLetsEncrypt o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("CertificateRequestCustom", CertificateRequestCustom.class);
        schemas.put("CertificateRequestLetsEncrypt", CertificateRequestLetsEncrypt.class);
        JSON.registerDescendants(CreateCertificatesRequest.class, Collections.unmodifiableMap(schemas));
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return CreateCertificatesRequest.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check the instance
     * parameter is valid against the oneOf child schemas: CertificateRequestCustom,
     * CertificateRequestLetsEncrypt
     *
     * It could be an instance of the 'oneOf' schemas. The oneOf child schemas may
     * themselves be a composed schema (allOf, anyOf, oneOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(CertificateRequestCustom.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(CertificateRequestLetsEncrypt.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException(
                "Invalid instance type. Must be CertificateRequestCustom, CertificateRequestLetsEncrypt");
    }

    /**
     * Get the actual instance, which can be the following:
     * CertificateRequestCustom, CertificateRequestLetsEncrypt
     *
     * @return The actual instance (CertificateRequestCustom,
     *         CertificateRequestLetsEncrypt)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `CertificateRequestCustom`. If the actual instance
     * is not `CertificateRequestCustom`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `CertificateRequestCustom`
     * @throws ClassCastException if the instance is not `CertificateRequestCustom`
     */
    public CertificateRequestCustom getCertificateRequestCustom() throws ClassCastException {
        return (CertificateRequestCustom) super.getActualInstance();
    }

    /**
     * Get the actual instance of `CertificateRequestLetsEncrypt`. If the actual
     * instance is not `CertificateRequestLetsEncrypt`, the ClassCastException will
     * be thrown.
     *
     * @return The actual instance of `CertificateRequestLetsEncrypt`
     * @throws ClassCastException if the instance is not
     *                            `CertificateRequestLetsEncrypt`
     */
    public CertificateRequestLetsEncrypt getCertificateRequestLetsEncrypt() throws ClassCastException {
        return (CertificateRequestLetsEncrypt) super.getActualInstance();
    }

}
