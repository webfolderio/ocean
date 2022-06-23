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

@JsonDeserialize(using = ReservedIpCreate.ReservedIpCreateDeserializer.class)
@JsonSerialize(using = ReservedIpCreate.ReservedIpCreateSerializer.class)
public class ReservedIpCreate extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(ReservedIpCreate.class.getName());

    public static class ReservedIpCreateSerializer extends StdSerializer<ReservedIpCreate> {
        public ReservedIpCreateSerializer(Class<ReservedIpCreate> t) {
            super(t);
        }

        public ReservedIpCreateSerializer() {
            this(null);
        }

        @Override
        public void serialize(ReservedIpCreate value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class ReservedIpCreateDeserializer extends StdDeserializer<ReservedIpCreate> {
        public ReservedIpCreateDeserializer() {
            this(ReservedIpCreate.class);
        }

        public ReservedIpCreateDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public ReservedIpCreate deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();
            Object deserialized = null;
            boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
            int match = 0;
            JsonToken token = tree.traverse(jp.getCodec()).nextToken();
            // deserialize AssignToDroplet1
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (AssignToDroplet1.class.equals(Integer.class) || AssignToDroplet1.class.equals(Long.class)
                        || AssignToDroplet1.class.equals(Float.class) || AssignToDroplet1.class.equals(Double.class)
                        || AssignToDroplet1.class.equals(Boolean.class)
                        || AssignToDroplet1.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((AssignToDroplet1.class.equals(Integer.class)
                                || AssignToDroplet1.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((AssignToDroplet1.class.equals(Float.class)
                                || AssignToDroplet1.class.equals(Double.class))
                                && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (AssignToDroplet1.class.equals(Boolean.class)
                                && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (AssignToDroplet1.class.equals(String.class)
                                && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(AssignToDroplet1.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'AssignToDroplet1'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'AssignToDroplet1'", e);
            }

            // deserialize ReserveToRegion1
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (ReserveToRegion1.class.equals(Integer.class) || ReserveToRegion1.class.equals(Long.class)
                        || ReserveToRegion1.class.equals(Float.class) || ReserveToRegion1.class.equals(Double.class)
                        || ReserveToRegion1.class.equals(Boolean.class)
                        || ReserveToRegion1.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((ReserveToRegion1.class.equals(Integer.class)
                                || ReserveToRegion1.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((ReserveToRegion1.class.equals(Float.class)
                                || ReserveToRegion1.class.equals(Double.class))
                                && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (ReserveToRegion1.class.equals(Boolean.class)
                                && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (ReserveToRegion1.class.equals(String.class)
                                && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(ReserveToRegion1.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'ReserveToRegion1'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'ReserveToRegion1'", e);
            }

            if (match == 1) {
                ReservedIpCreate ret = new ReservedIpCreate();
                ret.setActualInstance(deserialized);
                return ret;
            }
            throw new IOException(String
                    .format("Failed deserialization for ReservedIpCreate: %d classes match result, expected 1", match));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public ReservedIpCreate getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "ReservedIpCreate cannot be null");
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, Class<?>> schemas = new HashMap<>();

    public ReservedIpCreate() {
        super("oneOf", Boolean.FALSE);
    }

    public ReservedIpCreate(AssignToDroplet1 o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public ReservedIpCreate(ReserveToRegion1 o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("AssignToDroplet1", AssignToDroplet1.class);
        schemas.put("ReserveToRegion1", ReserveToRegion1.class);
        JSON.registerDescendants(ReservedIpCreate.class, Collections.unmodifiableMap(schemas));
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return ReservedIpCreate.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check the instance
     * parameter is valid against the oneOf child schemas: AssignToDroplet1,
     * ReserveToRegion1
     *
     * It could be an instance of the 'oneOf' schemas. The oneOf child schemas may
     * themselves be a composed schema (allOf, anyOf, oneOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(AssignToDroplet1.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(ReserveToRegion1.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be AssignToDroplet1, ReserveToRegion1");
    }

    /**
     * Get the actual instance, which can be the following: AssignToDroplet1,
     * ReserveToRegion1
     *
     * @return The actual instance (AssignToDroplet1, ReserveToRegion1)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `AssignToDroplet1`. If the actual instance is not
     * `AssignToDroplet1`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `AssignToDroplet1`
     * @throws ClassCastException if the instance is not `AssignToDroplet1`
     */
    public AssignToDroplet1 getAssignToDroplet1() throws ClassCastException {
        return (AssignToDroplet1) super.getActualInstance();
    }

    /**
     * Get the actual instance of `ReserveToRegion1`. If the actual instance is not
     * `ReserveToRegion1`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `ReserveToRegion1`
     * @throws ClassCastException if the instance is not `ReserveToRegion1`
     */
    public ReserveToRegion1 getReserveToRegion1() throws ClassCastException {
        return (ReserveToRegion1) super.getActualInstance();
    }
}