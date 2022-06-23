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

@JsonDeserialize(using = CreateDropletRequest.CreateDropletRequestDeserializer.class)
@JsonSerialize(using = CreateDropletRequest.CreateDropletRequestSerializer.class)
public class CreateDropletRequest extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(CreateDropletRequest.class.getName());

    public static class CreateDropletRequestSerializer extends StdSerializer<CreateDropletRequest> {
        public CreateDropletRequestSerializer(Class<CreateDropletRequest> t) {
            super(t);
        }

        public CreateDropletRequestSerializer() {
            this(null);
        }

        @Override
        public void serialize(CreateDropletRequest value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class CreateDropletRequestDeserializer extends StdDeserializer<CreateDropletRequest> {
        public CreateDropletRequestDeserializer() {
            this(CreateDropletRequest.class);
        }

        public CreateDropletRequestDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public CreateDropletRequest deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();
            Object deserialized = null;
            boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
            int match = 0;
            JsonToken token = tree.traverse(jp.getCodec()).nextToken();
            // deserialize DropletMultiCreate
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (DropletMultiCreate.class.equals(Integer.class) || DropletMultiCreate.class.equals(Long.class)
                        || DropletMultiCreate.class.equals(Float.class) || DropletMultiCreate.class.equals(Double.class)
                        || DropletMultiCreate.class.equals(Boolean.class)
                        || DropletMultiCreate.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((DropletMultiCreate.class.equals(Integer.class)
                                || DropletMultiCreate.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((DropletMultiCreate.class.equals(Float.class)
                                || DropletMultiCreate.class.equals(Double.class))
                                && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (DropletMultiCreate.class.equals(Boolean.class)
                                && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (DropletMultiCreate.class.equals(String.class)
                                && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(DropletMultiCreate.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'DropletMultiCreate'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'DropletMultiCreate'", e);
            }

            // deserialize DropletSingleCreate
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (DropletSingleCreate.class.equals(Integer.class) || DropletSingleCreate.class.equals(Long.class)
                        || DropletSingleCreate.class.equals(Float.class)
                        || DropletSingleCreate.class.equals(Double.class)
                        || DropletSingleCreate.class.equals(Boolean.class)
                        || DropletSingleCreate.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((DropletSingleCreate.class.equals(Integer.class)
                                || DropletSingleCreate.class.equals(Long.class))
                                && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((DropletSingleCreate.class.equals(Float.class)
                                || DropletSingleCreate.class.equals(Double.class))
                                && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (DropletSingleCreate.class.equals(Boolean.class)
                                && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (DropletSingleCreate.class.equals(String.class)
                                && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(DropletSingleCreate.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'DropletSingleCreate'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'DropletSingleCreate'", e);
            }

            if (match == 1) {
                CreateDropletRequest ret = new CreateDropletRequest();
                ret.setActualInstance(deserialized);
                return ret;
            }
            throw new IOException(String.format(
                    "Failed deserialization for CreateDropletRequest: %d classes match result, expected 1", match));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public CreateDropletRequest getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "CreateDropletRequest cannot be null");
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, Class<?>> schemas = new HashMap<>();

    public CreateDropletRequest() {
        super("oneOf", Boolean.FALSE);
    }

    public CreateDropletRequest(DropletMultiCreate o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public CreateDropletRequest(DropletSingleCreate o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("DropletMultiCreate", DropletMultiCreate.class);
        schemas.put("DropletSingleCreate", DropletSingleCreate.class);
        JSON.registerDescendants(CreateDropletRequest.class, Collections.unmodifiableMap(schemas));
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return CreateDropletRequest.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check the instance
     * parameter is valid against the oneOf child schemas: DropletMultiCreate,
     * DropletSingleCreate
     *
     * It could be an instance of the 'oneOf' schemas. The oneOf child schemas may
     * themselves be a composed schema (allOf, anyOf, oneOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(DropletMultiCreate.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(DropletSingleCreate.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be DropletMultiCreate, DropletSingleCreate");
    }

    /**
     * Get the actual instance, which can be the following: DropletMultiCreate,
     * DropletSingleCreate
     *
     * @return The actual instance (DropletMultiCreate, DropletSingleCreate)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `DropletMultiCreate`. If the actual instance is
     * not `DropletMultiCreate`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `DropletMultiCreate`
     * @throws ClassCastException if the instance is not `DropletMultiCreate`
     */
    public DropletMultiCreate getDropletMultiCreate() throws ClassCastException {
        return (DropletMultiCreate) super.getActualInstance();
    }

    /**
     * Get the actual instance of `DropletSingleCreate`. If the actual instance is
     * not `DropletSingleCreate`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `DropletSingleCreate`
     * @throws ClassCastException if the instance is not `DropletSingleCreate`
     */
    public DropletSingleCreate getDropletSingleCreate() throws ClassCastException {
        return (DropletSingleCreate) super.getActualInstance();
    }
}