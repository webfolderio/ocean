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

@JsonDeserialize(using = PostDropletActionByTagRequest.PostDropletActionByTagRequestDeserializer.class)
@JsonSerialize(using = PostDropletActionByTagRequest.PostDropletActionByTagRequestSerializer.class)
public class PostDropletActionByTagRequest extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(PostDropletActionByTagRequest.class.getName());

    public static class PostDropletActionByTagRequestSerializer extends StdSerializer<PostDropletActionByTagRequest> {
        public PostDropletActionByTagRequestSerializer(Class<PostDropletActionByTagRequest> t) {
            super(t);
        }

        public PostDropletActionByTagRequestSerializer() {
            this(null);
        }

        @Override
        public void serialize(PostDropletActionByTagRequest value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class PostDropletActionByTagRequestDeserializer
            extends StdDeserializer<PostDropletActionByTagRequest> {
        public PostDropletActionByTagRequestDeserializer() {
            this(PostDropletActionByTagRequest.class);
        }

        public PostDropletActionByTagRequestDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public PostDropletActionByTagRequest deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();
            Object deserialized = null;
            boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
            int match = 0;
            JsonToken token = tree.traverse(jp.getCodec()).nextToken();
            // deserialize DropletActionSnapshot
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (DropletActionSnapshot.class.equals(Integer.class) || DropletActionSnapshot.class.equals(Long.class)
                        || DropletActionSnapshot.class.equals(Float.class)
                        || DropletActionSnapshot.class.equals(Double.class)
                        || DropletActionSnapshot.class.equals(Boolean.class)
                        || DropletActionSnapshot.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((DropletActionSnapshot.class.equals(Integer.class)
                                || DropletActionSnapshot.class.equals(Long.class))
                                && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((DropletActionSnapshot.class.equals(Float.class)
                                || DropletActionSnapshot.class.equals(Double.class))
                                && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (DropletActionSnapshot.class.equals(Boolean.class)
                                && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (DropletActionSnapshot.class.equals(String.class)
                                && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(DropletActionSnapshot.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'DropletActionSnapshot'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'DropletActionSnapshot'", e);
            }

            // deserialize DropletActionType
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (DropletActionType.class.equals(Integer.class) || DropletActionType.class.equals(Long.class)
                        || DropletActionType.class.equals(Float.class) || DropletActionType.class.equals(Double.class)
                        || DropletActionType.class.equals(Boolean.class)
                        || DropletActionType.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((DropletActionType.class.equals(Integer.class)
                                || DropletActionType.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((DropletActionType.class.equals(Float.class)
                                || DropletActionType.class.equals(Double.class))
                                && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (DropletActionType.class.equals(Boolean.class)
                                && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (DropletActionType.class.equals(String.class)
                                && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(DropletActionType.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'DropletActionType'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'DropletActionType'", e);
            }

            if (match == 1) {
                PostDropletActionByTagRequest ret = new PostDropletActionByTagRequest();
                ret.setActualInstance(deserialized);
                return ret;
            }
            throw new IOException(String.format(
                    "Failed deserialization for PostDropletActionByTagRequest: %d classes match result, expected 1",
                    match));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public PostDropletActionByTagRequest getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "PostDropletActionByTagRequest cannot be null");
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, Class<?>> schemas = new HashMap<>();

    public PostDropletActionByTagRequest() {
        super("oneOf", Boolean.FALSE);
    }

    public PostDropletActionByTagRequest(DropletActionSnapshot o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public PostDropletActionByTagRequest(DropletActionType o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("DropletActionSnapshot", DropletActionSnapshot.class);
        schemas.put("DropletActionType", DropletActionType.class);
        JSON.registerDescendants(PostDropletActionByTagRequest.class, Collections.unmodifiableMap(schemas));
        // Initialize and register the discriminator mappings.
        Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
        mappings.put("disable_backups", DropletActionType.class);
        mappings.put("droplet_action_snapshot", DropletActionSnapshot.class);
        mappings.put("droplet_action_type", DropletActionType.class);
        mappings.put("enable_backups", DropletActionType.class);
        mappings.put("enable_ipv6", DropletActionType.class);
        mappings.put("power_cycle", DropletActionType.class);
        mappings.put("power_off", DropletActionType.class);
        mappings.put("power_on", DropletActionType.class);
        mappings.put("shutdown", DropletActionType.class);
        mappings.put("snapshot", DropletActionSnapshot.class);
        mappings.put("post_droplet_action_by_tag_request", PostDropletActionByTagRequest.class);
        JSON.registerDiscriminator(PostDropletActionByTagRequest.class, "type", mappings);
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return PostDropletActionByTagRequest.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check the instance
     * parameter is valid against the oneOf child schemas: DropletActionSnapshot,
     * DropletActionType
     *
     * It could be an instance of the 'oneOf' schemas. The oneOf child schemas may
     * themselves be a composed schema (allOf, anyOf, oneOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(DropletActionSnapshot.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(DropletActionType.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be DropletActionSnapshot, DropletActionType");
    }

    /**
     * Get the actual instance, which can be the following: DropletActionSnapshot,
     * DropletActionType
     *
     * @return The actual instance (DropletActionSnapshot, DropletActionType)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `DropletActionSnapshot`. If the actual instance is
     * not `DropletActionSnapshot`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `DropletActionSnapshot`
     * @throws ClassCastException if the instance is not `DropletActionSnapshot`
     */
    public DropletActionSnapshot getDropletActionSnapshot() throws ClassCastException {
        return (DropletActionSnapshot) super.getActualInstance();
    }

    /**
     * Get the actual instance of `DropletActionType`. If the actual instance is not
     * `DropletActionType`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `DropletActionType`
     * @throws ClassCastException if the instance is not `DropletActionType`
     */
    public DropletActionType getDropletActionType() throws ClassCastException {
        return (DropletActionType) super.getActualInstance();
    }

}
