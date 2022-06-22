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

@JsonDeserialize(using = FloatingIpCreate.FloatingIpCreateDeserializer.class)
@JsonSerialize(using = FloatingIpCreate.FloatingIpCreateSerializer.class)
public class FloatingIpCreate extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(FloatingIpCreate.class.getName());

    public static class FloatingIpCreateSerializer extends StdSerializer<FloatingIpCreate> {
        public FloatingIpCreateSerializer(Class<FloatingIpCreate> t) {
            super(t);
        }

        public FloatingIpCreateSerializer() {
            this(null);
        }

        @Override
        public void serialize(FloatingIpCreate value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class FloatingIpCreateDeserializer extends StdDeserializer<FloatingIpCreate> {
        public FloatingIpCreateDeserializer() {
            this(FloatingIpCreate.class);
        }

        public FloatingIpCreateDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public FloatingIpCreate deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();
            Object deserialized = null;
            boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
            int match = 0;
            JsonToken token = tree.traverse(jp.getCodec()).nextToken();
            // deserialize AssignToDroplet
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (AssignToDroplet.class.equals(Integer.class) || AssignToDroplet.class.equals(Long.class)
                        || AssignToDroplet.class.equals(Float.class) || AssignToDroplet.class.equals(Double.class)
                        || AssignToDroplet.class.equals(Boolean.class) || AssignToDroplet.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((AssignToDroplet.class.equals(Integer.class)
                                || AssignToDroplet.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((AssignToDroplet.class.equals(Float.class)
                                || AssignToDroplet.class.equals(Double.class))
                                && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (AssignToDroplet.class.equals(Boolean.class)
                                && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (AssignToDroplet.class.equals(String.class)
                                && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(AssignToDroplet.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'AssignToDroplet'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'AssignToDroplet'", e);
            }

            // deserialize ReserveToRegion
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (ReserveToRegion.class.equals(Integer.class) || ReserveToRegion.class.equals(Long.class)
                        || ReserveToRegion.class.equals(Float.class) || ReserveToRegion.class.equals(Double.class)
                        || ReserveToRegion.class.equals(Boolean.class) || ReserveToRegion.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((ReserveToRegion.class.equals(Integer.class)
                                || ReserveToRegion.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((ReserveToRegion.class.equals(Float.class)
                                || ReserveToRegion.class.equals(Double.class))
                                && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (ReserveToRegion.class.equals(Boolean.class)
                                && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (ReserveToRegion.class.equals(String.class)
                                && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(ReserveToRegion.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'ReserveToRegion'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'ReserveToRegion'", e);
            }

            if (match == 1) {
                FloatingIpCreate ret = new FloatingIpCreate();
                ret.setActualInstance(deserialized);
                return ret;
            }
            throw new IOException(String
                    .format("Failed deserialization for FloatingIpCreate: %d classes match result, expected 1", match));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public FloatingIpCreate getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "FloatingIpCreate cannot be null");
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, Class<?>> schemas = new HashMap<>();

    public FloatingIpCreate() {
        super("oneOf", Boolean.FALSE);
    }

    public FloatingIpCreate(AssignToDroplet o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public FloatingIpCreate(ReserveToRegion o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("AssignToDroplet", AssignToDroplet.class);
        schemas.put("ReserveToRegion", ReserveToRegion.class);
        JSON.registerDescendants(FloatingIpCreate.class, Collections.unmodifiableMap(schemas));
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return FloatingIpCreate.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check the instance
     * parameter is valid against the oneOf child schemas: AssignToDroplet,
     * ReserveToRegion
     *
     * It could be an instance of the 'oneOf' schemas. The oneOf child schemas may
     * themselves be a composed schema (allOf, anyOf, oneOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(AssignToDroplet.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(ReserveToRegion.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be AssignToDroplet, ReserveToRegion");
    }

    /**
     * Get the actual instance, which can be the following: AssignToDroplet,
     * ReserveToRegion
     *
     * @return The actual instance (AssignToDroplet, ReserveToRegion)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `AssignToDroplet`. If the actual instance is not
     * `AssignToDroplet`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `AssignToDroplet`
     * @throws ClassCastException if the instance is not `AssignToDroplet`
     */
    public AssignToDroplet getAssignToDroplet() throws ClassCastException {
        return (AssignToDroplet) super.getActualInstance();
    }

    /**
     * Get the actual instance of `ReserveToRegion`. If the actual instance is not
     * `ReserveToRegion`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `ReserveToRegion`
     * @throws ClassCastException if the instance is not `ReserveToRegion`
     */
    public ReserveToRegion getReserveToRegion() throws ClassCastException {
        return (ReserveToRegion) super.getActualInstance();
    }

}
