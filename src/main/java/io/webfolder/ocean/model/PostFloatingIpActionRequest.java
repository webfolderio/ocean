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

import io.webfolder.ocean.JSON;

@JsonDeserialize(using = PostFloatingIpActionRequest.PostFloatingIpActionRequestDeserializer.class)
@JsonSerialize(using = PostFloatingIpActionRequest.PostFloatingIpActionRequestSerializer.class)
public class PostFloatingIpActionRequest extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(PostFloatingIpActionRequest.class.getName());

    public static class PostFloatingIpActionRequestSerializer extends StdSerializer<PostFloatingIpActionRequest> {
        public PostFloatingIpActionRequestSerializer(Class<PostFloatingIpActionRequest> t) {
            super(t);
        }

        public PostFloatingIpActionRequestSerializer() {
            this(null);
        }

        @Override
        public void serialize(PostFloatingIpActionRequest value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class PostFloatingIpActionRequestDeserializer extends StdDeserializer<PostFloatingIpActionRequest> {
        public PostFloatingIpActionRequestDeserializer() {
            this(PostFloatingIpActionRequest.class);
        }

        public PostFloatingIpActionRequestDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public PostFloatingIpActionRequest deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();

            Object deserialized = null;
            Class<?> cls = JSON.getClassForElement(tree, PostFloatingIpActionRequest.class);
            if (cls != null) {
                // When the OAS schema includes a discriminator, use the discriminator value to
                // discriminate the anyOf schemas.
                // Get the discriminator mapping value to get the class.
                deserialized = tree.traverse(jp.getCodec()).readValueAs(cls);
                PostFloatingIpActionRequest ret = new PostFloatingIpActionRequest();
                ret.setActualInstance(deserialized);
                return ret;
            }
            // deserialize FloatingIpActionAssign
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(FloatingIpActionAssign.class);
                PostFloatingIpActionRequest ret = new PostFloatingIpActionRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'PostFloatingIpActionRequest'", e);
            }

            // deserialize FloatingIpActionUnassign
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(FloatingIpActionUnassign.class);
                PostFloatingIpActionRequest ret = new PostFloatingIpActionRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'PostFloatingIpActionRequest'", e);
            }

            throw new IOException(
                    String.format("Failed deserialization for PostFloatingIpActionRequest: no match found"));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public PostFloatingIpActionRequest getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "PostFloatingIpActionRequest cannot be null");
        }
    }

    // store a list of schema names defined in anyOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public PostFloatingIpActionRequest() {
        super("anyOf", Boolean.FALSE);
    }

    public PostFloatingIpActionRequest(FloatingIpActionAssign o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public PostFloatingIpActionRequest(FloatingIpActionUnassign o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("FloatingIpActionAssign", FloatingIpActionAssign.class);
        schemas.put("FloatingIpActionUnassign", FloatingIpActionUnassign.class);
        JSON.registerDescendants(PostFloatingIpActionRequest.class, Collections.unmodifiableMap(schemas));
        // Initialize and register the discriminator mappings.
        Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
        mappings.put("assign", FloatingIpActionAssign.class);
        mappings.put("floating_ip_action_assign", FloatingIpActionAssign.class);
        mappings.put("floating_ip_action_unassign", FloatingIpActionUnassign.class);
        mappings.put("unassign", FloatingIpActionUnassign.class);
        mappings.put("post_floating_ip_action_request", PostFloatingIpActionRequest.class);
        JSON.registerDiscriminator(PostFloatingIpActionRequest.class, "type", mappings);
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return PostFloatingIpActionRequest.schemas;
    }

    /**
     * Set the instance that matches the anyOf child schema, check the instance
     * parameter is valid against the anyOf child schemas: FloatingIpActionAssign,
     * FloatingIpActionUnassign
     *
     * It could be an instance of the 'anyOf' schemas. The anyOf child schemas may
     * themselves be a composed schema (allOf, anyOf, anyOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(FloatingIpActionAssign.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(FloatingIpActionUnassign.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be FloatingIpActionAssign, FloatingIpActionUnassign");
    }

    /**
     * Get the actual instance, which can be the following: FloatingIpActionAssign,
     * FloatingIpActionUnassign
     *
     * @return The actual instance (FloatingIpActionAssign,
     *         FloatingIpActionUnassign)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `FloatingIpActionAssign`. If the actual instance
     * is not `FloatingIpActionAssign`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `FloatingIpActionAssign`
     * @throws ClassCastException if the instance is not `FloatingIpActionAssign`
     */
    public FloatingIpActionAssign getFloatingIpActionAssign() throws ClassCastException {
        return (FloatingIpActionAssign) super.getActualInstance();
    }

    /**
     * Get the actual instance of `FloatingIpActionUnassign`. If the actual instance
     * is not `FloatingIpActionUnassign`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `FloatingIpActionUnassign`
     * @throws ClassCastException if the instance is not `FloatingIpActionUnassign`
     */
    public FloatingIpActionUnassign getFloatingIpActionUnassign() throws ClassCastException {
        return (FloatingIpActionUnassign) super.getActualInstance();
    }

}
