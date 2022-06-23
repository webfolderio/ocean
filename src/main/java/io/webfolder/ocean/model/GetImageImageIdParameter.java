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

@JsonDeserialize(using = GetImageImageIdParameter.GetImageImageIdParameterDeserializer.class)
@JsonSerialize(using = GetImageImageIdParameter.GetImageImageIdParameterSerializer.class)
public class GetImageImageIdParameter extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(GetImageImageIdParameter.class.getName());

    public static class GetImageImageIdParameterSerializer extends StdSerializer<GetImageImageIdParameter> {
        public GetImageImageIdParameterSerializer(Class<GetImageImageIdParameter> t) {
            super(t);
        }

        public GetImageImageIdParameterSerializer() {
            this(null);
        }

        @Override
        public void serialize(GetImageImageIdParameter value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class GetImageImageIdParameterDeserializer extends StdDeserializer<GetImageImageIdParameter> {
        public GetImageImageIdParameterDeserializer() {
            this(GetImageImageIdParameter.class);
        }

        public GetImageImageIdParameterDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public GetImageImageIdParameter deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();

            Object deserialized = null;
            // deserialize Integer
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(Integer.class);
                GetImageImageIdParameter ret = new GetImageImageIdParameter();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'GetImageImageIdParameter'", e);
            }

            // deserialize String
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(String.class);
                GetImageImageIdParameter ret = new GetImageImageIdParameter();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'GetImageImageIdParameter'", e);
            }

            throw new IOException(String.format("Failed deserialization for GetImageImageIdParameter: no match found"));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public GetImageImageIdParameter getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "GetImageImageIdParameter cannot be null");
        }
    }

    // store a list of schema names defined in anyOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public GetImageImageIdParameter() {
        super("anyOf", Boolean.FALSE);
    }

    public GetImageImageIdParameter(Integer o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public GetImageImageIdParameter(String o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("Integer", Integer.class);
        schemas.put("String", String.class);
        JSON.registerDescendants(GetImageImageIdParameter.class, Collections.unmodifiableMap(schemas));
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return GetImageImageIdParameter.schemas;
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