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

@JsonDeserialize(using = CreateDropletResponse.CreateDropletResponseDeserializer.class)
@JsonSerialize(using = CreateDropletResponse.CreateDropletResponseSerializer.class)
public class CreateDropletResponse extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(CreateDropletResponse.class.getName());

    public static class CreateDropletResponseSerializer extends StdSerializer<CreateDropletResponse> {
        public CreateDropletResponseSerializer(Class<CreateDropletResponse> t) {
            super(t);
        }

        public CreateDropletResponseSerializer() {
            this(null);
        }

        @Override
        public void serialize(CreateDropletResponse value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class CreateDropletResponseDeserializer extends StdDeserializer<CreateDropletResponse> {
        public CreateDropletResponseDeserializer() {
            this(CreateDropletResponse.class);
        }

        public CreateDropletResponseDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public CreateDropletResponse deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();
            Object deserialized = null;
            boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
            int match = 0;
            JsonToken token = tree.traverse(jp.getCodec()).nextToken();
            // deserialize MultipleDropletResponse
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (MultipleDropletResponse.class.equals(Integer.class)
                        || MultipleDropletResponse.class.equals(Long.class)
                        || MultipleDropletResponse.class.equals(Float.class)
                        || MultipleDropletResponse.class.equals(Double.class)
                        || MultipleDropletResponse.class.equals(Boolean.class)
                        || MultipleDropletResponse.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((MultipleDropletResponse.class.equals(Integer.class)
                                || MultipleDropletResponse.class.equals(Long.class))
                                && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((MultipleDropletResponse.class.equals(Float.class)
                                || MultipleDropletResponse.class.equals(Double.class))
                                && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (MultipleDropletResponse.class.equals(Boolean.class)
                                && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (MultipleDropletResponse.class.equals(String.class)
                                && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(MultipleDropletResponse.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'MultipleDropletResponse'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'MultipleDropletResponse'", e);
            }

            // deserialize SingleDropletResponse
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (SingleDropletResponse.class.equals(Integer.class) || SingleDropletResponse.class.equals(Long.class)
                        || SingleDropletResponse.class.equals(Float.class)
                        || SingleDropletResponse.class.equals(Double.class)
                        || SingleDropletResponse.class.equals(Boolean.class)
                        || SingleDropletResponse.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((SingleDropletResponse.class.equals(Integer.class)
                                || SingleDropletResponse.class.equals(Long.class))
                                && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((SingleDropletResponse.class.equals(Float.class)
                                || SingleDropletResponse.class.equals(Double.class))
                                && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (SingleDropletResponse.class.equals(Boolean.class)
                                && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (SingleDropletResponse.class.equals(String.class)
                                && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(SingleDropletResponse.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'SingleDropletResponse'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'SingleDropletResponse'", e);
            }

            if (match == 1) {
                CreateDropletResponse ret = new CreateDropletResponse();
                ret.setActualInstance(deserialized);
                return ret;
            }
            throw new IOException(String.format(
                    "Failed deserialization for CreateDropletResponse: %d classes match result, expected 1", match));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public CreateDropletResponse getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "CreateDropletResponse cannot be null");
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, Class<?>> schemas = new HashMap<>();

    public CreateDropletResponse() {
        super("oneOf", Boolean.FALSE);
    }

    public CreateDropletResponse(MultipleDropletResponse o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public CreateDropletResponse(SingleDropletResponse o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("MultipleDropletResponse", MultipleDropletResponse.class);
        schemas.put("SingleDropletResponse", SingleDropletResponse.class);
        JSON.registerDescendants(CreateDropletResponse.class, Collections.unmodifiableMap(schemas));
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return CreateDropletResponse.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check the instance
     * parameter is valid against the oneOf child schemas: MultipleDropletResponse,
     * SingleDropletResponse
     *
     * It could be an instance of the 'oneOf' schemas. The oneOf child schemas may
     * themselves be a composed schema (allOf, anyOf, oneOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(MultipleDropletResponse.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(SingleDropletResponse.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be MultipleDropletResponse, SingleDropletResponse");
    }

    /**
     * Get the actual instance, which can be the following: MultipleDropletResponse,
     * SingleDropletResponse
     *
     * @return The actual instance (MultipleDropletResponse, SingleDropletResponse)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `MultipleDropletResponse`. If the actual instance
     * is not `MultipleDropletResponse`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `MultipleDropletResponse`
     * @throws ClassCastException if the instance is not `MultipleDropletResponse`
     */
    public MultipleDropletResponse getMultipleDropletResponse() throws ClassCastException {
        return (MultipleDropletResponse) super.getActualInstance();
    }

    /**
     * Get the actual instance of `SingleDropletResponse`. If the actual instance is
     * not `SingleDropletResponse`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `SingleDropletResponse`
     * @throws ClassCastException if the instance is not `SingleDropletResponse`
     */
    public SingleDropletResponse getSingleDropletResponse() throws ClassCastException {
        return (SingleDropletResponse) super.getActualInstance();
    }
}