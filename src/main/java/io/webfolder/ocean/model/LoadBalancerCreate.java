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

import io.webfolder.ocean.client.internal.JSON;

@JsonDeserialize(using = LoadBalancerCreate.LoadBalancerCreateDeserializer.class)
@JsonSerialize(using = LoadBalancerCreate.LoadBalancerCreateSerializer.class)
public class LoadBalancerCreate extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(LoadBalancerCreate.class.getName());

    public static class LoadBalancerCreateSerializer extends StdSerializer<LoadBalancerCreate> {
        public LoadBalancerCreateSerializer(Class<LoadBalancerCreate> t) {
            super(t);
        }

        public LoadBalancerCreateSerializer() {
            this(null);
        }

        @Override
        public void serialize(LoadBalancerCreate value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class LoadBalancerCreateDeserializer extends StdDeserializer<LoadBalancerCreate> {
        public LoadBalancerCreateDeserializer() {
            this(LoadBalancerCreate.class);
        }

        public LoadBalancerCreateDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public LoadBalancerCreate deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();
            Object deserialized = null;
            boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
            int match = 0;
            JsonToken token = tree.traverse(jp.getCodec()).nextToken();
            // deserialize Object
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (Object.class.equals(Integer.class) || Object.class.equals(Long.class)
                        || Object.class.equals(Float.class) || Object.class.equals(Double.class)
                        || Object.class.equals(Boolean.class) || Object.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((Object.class.equals(Integer.class) || Object.class.equals(Long.class))
                                && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((Object.class.equals(Float.class) || Object.class.equals(Double.class))
                                && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (Object.class.equals(Boolean.class)
                                && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (Object.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(Object.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'Object'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'Object'", e);
            }

            if (match == 1) {
                LoadBalancerCreate ret = new LoadBalancerCreate();
                ret.setActualInstance(deserialized);
                return ret;
            }
            throw new IOException(String.format(
                    "Failed deserialization for LoadBalancerCreate: %d classes match result, expected 1", match));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public LoadBalancerCreate getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "LoadBalancerCreate cannot be null");
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, Class<?>> schemas = new HashMap<>();

    public LoadBalancerCreate() {
        super("oneOf", Boolean.FALSE);
    }

    public LoadBalancerCreate(Object o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("Object", Object.class);
        JSON.registerDescendants(LoadBalancerCreate.class, Collections.unmodifiableMap(schemas));
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return LoadBalancerCreate.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check the instance
     * parameter is valid against the oneOf child schemas: Object
     *
     * It could be an instance of the 'oneOf' schemas. The oneOf child schemas may
     * themselves be a composed schema (allOf, anyOf, oneOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(Object.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be Object");
    }

    /**
     * Get the actual instance, which can be the following: Object
     *
     * @return The actual instance (Object)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `Object`. If the actual instance is not `Object`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `Object`
     * @throws ClassCastException if the instance is not `Object`
     */
    public Object getObject() throws ClassCastException {
        return (Object) super.getActualInstance();
    }
}