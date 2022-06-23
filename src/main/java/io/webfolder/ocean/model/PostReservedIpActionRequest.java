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

@JsonDeserialize(using = PostReservedIpActionRequest.PostReservedIpActionRequestDeserializer.class)
@JsonSerialize(using = PostReservedIpActionRequest.PostReservedIpActionRequestSerializer.class)
public class PostReservedIpActionRequest extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(PostReservedIpActionRequest.class.getName());

    public static class PostReservedIpActionRequestSerializer extends StdSerializer<PostReservedIpActionRequest> {
        public PostReservedIpActionRequestSerializer(Class<PostReservedIpActionRequest> t) {
            super(t);
        }

        public PostReservedIpActionRequestSerializer() {
            this(null);
        }

        @Override
        public void serialize(PostReservedIpActionRequest value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class PostReservedIpActionRequestDeserializer extends StdDeserializer<PostReservedIpActionRequest> {
        public PostReservedIpActionRequestDeserializer() {
            this(PostReservedIpActionRequest.class);
        }

        public PostReservedIpActionRequestDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public PostReservedIpActionRequest deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();

            Object deserialized = null;
            Class<?> cls = JSON.getClassForElement(tree, PostReservedIpActionRequest.class);
            if (cls != null) {
                // When the OAS schema includes a discriminator, use the discriminator value to
                // discriminate the anyOf schemas.
                // Get the discriminator mapping value to get the class.
                deserialized = tree.traverse(jp.getCodec()).readValueAs(cls);
                PostReservedIpActionRequest ret = new PostReservedIpActionRequest();
                ret.setActualInstance(deserialized);
                return ret;
            }
            // deserialize ReservedIpActionAssign
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(ReservedIpActionAssign.class);
                PostReservedIpActionRequest ret = new PostReservedIpActionRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'PostReservedIpActionRequest'", e);
            }

            // deserialize ReservedIpActionUnassign
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(ReservedIpActionUnassign.class);
                PostReservedIpActionRequest ret = new PostReservedIpActionRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'PostReservedIpActionRequest'", e);
            }

            throw new IOException(
                    String.format("Failed deserialization for PostReservedIpActionRequest: no match found"));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public PostReservedIpActionRequest getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "PostReservedIpActionRequest cannot be null");
        }
    }

    // store a list of schema names defined in anyOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public PostReservedIpActionRequest() {
        super("anyOf", Boolean.FALSE);
    }

    public PostReservedIpActionRequest(ReservedIpActionAssign o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public PostReservedIpActionRequest(ReservedIpActionUnassign o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("ReservedIpActionAssign", ReservedIpActionAssign.class);
        schemas.put("ReservedIpActionUnassign", ReservedIpActionUnassign.class);
        JSON.registerDescendants(PostReservedIpActionRequest.class, Collections.unmodifiableMap(schemas));
        // Initialize and register the discriminator mappings.
        Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
        mappings.put("assign", ReservedIpActionAssign.class);
        mappings.put("reserved_ip_action_assign", ReservedIpActionAssign.class);
        mappings.put("reserved_ip_action_unassign", ReservedIpActionUnassign.class);
        mappings.put("unassign", ReservedIpActionUnassign.class);
        mappings.put("post_reserved_ip_action_request", PostReservedIpActionRequest.class);
        JSON.registerDiscriminator(PostReservedIpActionRequest.class, "type", mappings);
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return PostReservedIpActionRequest.schemas;
    }

    /**
     * Set the instance that matches the anyOf child schema, check the instance
     * parameter is valid against the anyOf child schemas: ReservedIpActionAssign,
     * ReservedIpActionUnassign
     *
     * It could be an instance of the 'anyOf' schemas. The anyOf child schemas may
     * themselves be a composed schema (allOf, anyOf, anyOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(ReservedIpActionAssign.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(ReservedIpActionUnassign.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be ReservedIpActionAssign, ReservedIpActionUnassign");
    }

    /**
     * Get the actual instance, which can be the following: ReservedIpActionAssign,
     * ReservedIpActionUnassign
     *
     * @return The actual instance (ReservedIpActionAssign,
     *         ReservedIpActionUnassign)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `ReservedIpActionAssign`. If the actual instance
     * is not `ReservedIpActionAssign`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `ReservedIpActionAssign`
     * @throws ClassCastException if the instance is not `ReservedIpActionAssign`
     */
    public ReservedIpActionAssign getReservedIpActionAssign() throws ClassCastException {
        return (ReservedIpActionAssign) super.getActualInstance();
    }

    /**
     * Get the actual instance of `ReservedIpActionUnassign`. If the actual instance
     * is not `ReservedIpActionUnassign`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `ReservedIpActionUnassign`
     * @throws ClassCastException if the instance is not `ReservedIpActionUnassign`
     */
    public ReservedIpActionUnassign getReservedIpActionUnassign() throws ClassCastException {
        return (ReservedIpActionUnassign) super.getActualInstance();
    }
}