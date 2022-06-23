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

@JsonDeserialize(using = GetSshKeySshKeyIdentifierParameter.GetSshKeySshKeyIdentifierParameterDeserializer.class)
@JsonSerialize(using = GetSshKeySshKeyIdentifierParameter.GetSshKeySshKeyIdentifierParameterSerializer.class)
public class GetSshKeySshKeyIdentifierParameter extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(GetSshKeySshKeyIdentifierParameter.class.getName());

    public static class GetSshKeySshKeyIdentifierParameterSerializer
            extends StdSerializer<GetSshKeySshKeyIdentifierParameter> {
        public GetSshKeySshKeyIdentifierParameterSerializer(Class<GetSshKeySshKeyIdentifierParameter> t) {
            super(t);
        }

        public GetSshKeySshKeyIdentifierParameterSerializer() {
            this(null);
        }

        @Override
        public void serialize(GetSshKeySshKeyIdentifierParameter value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class GetSshKeySshKeyIdentifierParameterDeserializer
            extends StdDeserializer<GetSshKeySshKeyIdentifierParameter> {
        public GetSshKeySshKeyIdentifierParameterDeserializer() {
            this(GetSshKeySshKeyIdentifierParameter.class);
        }

        public GetSshKeySshKeyIdentifierParameterDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public GetSshKeySshKeyIdentifierParameter deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();

            Object deserialized = null;
            // deserialize Integer
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(Integer.class);
                GetSshKeySshKeyIdentifierParameter ret = new GetSshKeySshKeyIdentifierParameter();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'GetSshKeySshKeyIdentifierParameter'", e);
            }

            // deserialize String
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(String.class);
                GetSshKeySshKeyIdentifierParameter ret = new GetSshKeySshKeyIdentifierParameter();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'GetSshKeySshKeyIdentifierParameter'", e);
            }

            throw new IOException(
                    String.format("Failed deserialization for GetSshKeySshKeyIdentifierParameter: no match found"));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public GetSshKeySshKeyIdentifierParameter getNullValue(DeserializationContext ctxt)
                throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "GetSshKeySshKeyIdentifierParameter cannot be null");
        }
    }

    // store a list of schema names defined in anyOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public GetSshKeySshKeyIdentifierParameter() {
        super("anyOf", Boolean.FALSE);
    }

    public GetSshKeySshKeyIdentifierParameter(Integer o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public GetSshKeySshKeyIdentifierParameter(String o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("Integer", Integer.class);
        schemas.put("String", String.class);
        JSON.registerDescendants(GetSshKeySshKeyIdentifierParameter.class, Collections.unmodifiableMap(schemas));
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return GetSshKeySshKeyIdentifierParameter.schemas;
    }

    /**
     * Set the instance that matches the anyOf child schema, check the instance
     * parameter is valid against the anyOf child schemas: Integer, String
     *
     * It could be an instance of the 'anyOf' schemas. The anyOf child schemas may
     * themselves be a composed schema (allOf, anyOf, anyOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(Integer.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(String.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be Integer, String");
    }

    /**
     * Get the actual instance, which can be the following: Integer, String
     *
     * @return The actual instance (Integer, String)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `Integer`. If the actual instance is not
     * `Integer`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `Integer`
     * @throws ClassCastException if the instance is not `Integer`
     */
    public Integer getInteger() throws ClassCastException {
        return (Integer) super.getActualInstance();
    }

    /**
     * Get the actual instance of `String`. If the actual instance is not `String`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `String`
     * @throws ClassCastException if the instance is not `String`
     */
    public String getString() throws ClassCastException {
        return (String) super.getActualInstance();
    }
}