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

@JsonDeserialize(using = PostVolumeActionByNameRequest.PostVolumeActionByNameRequestDeserializer.class)
@JsonSerialize(using = PostVolumeActionByNameRequest.PostVolumeActionByNameRequestSerializer.class)
public class PostVolumeActionByNameRequest extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(PostVolumeActionByNameRequest.class.getName());

    public static class PostVolumeActionByNameRequestSerializer extends StdSerializer<PostVolumeActionByNameRequest> {
        public PostVolumeActionByNameRequestSerializer(Class<PostVolumeActionByNameRequest> t) {
            super(t);
        }

        public PostVolumeActionByNameRequestSerializer() {
            this(null);
        }

        @Override
        public void serialize(PostVolumeActionByNameRequest value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class PostVolumeActionByNameRequestDeserializer
            extends StdDeserializer<PostVolumeActionByNameRequest> {
        public PostVolumeActionByNameRequestDeserializer() {
            this(PostVolumeActionByNameRequest.class);
        }

        public PostVolumeActionByNameRequestDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public PostVolumeActionByNameRequest deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();

            Object deserialized = null;
            Class<?> cls = JSON.getClassForElement(tree, PostVolumeActionByNameRequest.class);
            if (cls != null) {
                // When the OAS schema includes a discriminator, use the discriminator value to
                // discriminate the anyOf schemas.
                // Get the discriminator mapping value to get the class.
                deserialized = tree.traverse(jp.getCodec()).readValueAs(cls);
                PostVolumeActionByNameRequest ret = new PostVolumeActionByNameRequest();
                ret.setActualInstance(deserialized);
                return ret;
            }
            // deserialize VolumeActionPostAttach
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(VolumeActionPostAttach.class);
                PostVolumeActionByNameRequest ret = new PostVolumeActionByNameRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'PostVolumeActionByNameRequest'", e);
            }

            // deserialize VolumeActionPostDetach
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(VolumeActionPostDetach.class);
                PostVolumeActionByNameRequest ret = new PostVolumeActionByNameRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'PostVolumeActionByNameRequest'", e);
            }

            throw new IOException(
                    String.format("Failed deserialization for PostVolumeActionByNameRequest: no match found"));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public PostVolumeActionByNameRequest getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "PostVolumeActionByNameRequest cannot be null");
        }
    }

    // store a list of schema names defined in anyOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public PostVolumeActionByNameRequest() {
        super("anyOf", Boolean.FALSE);
    }

    public PostVolumeActionByNameRequest(VolumeActionPostAttach o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public PostVolumeActionByNameRequest(VolumeActionPostDetach o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("VolumeActionPostAttach", VolumeActionPostAttach.class);
        schemas.put("VolumeActionPostDetach", VolumeActionPostDetach.class);
        JSON.registerDescendants(PostVolumeActionByNameRequest.class, Collections.unmodifiableMap(schemas));
        // Initialize and register the discriminator mappings.
        Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
        mappings.put("attach", VolumeActionPostAttach.class);
        mappings.put("detach", VolumeActionPostDetach.class);
        mappings.put("volume_action_post_attach", VolumeActionPostAttach.class);
        mappings.put("volume_action_post_detach", VolumeActionPostDetach.class);
        mappings.put("post_volume_action_by_name_request", PostVolumeActionByNameRequest.class);
        JSON.registerDiscriminator(PostVolumeActionByNameRequest.class, "type", mappings);
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return PostVolumeActionByNameRequest.schemas;
    }

    /**
     * Set the instance that matches the anyOf child schema, check the instance
     * parameter is valid against the anyOf child schemas: VolumeActionPostAttach,
     * VolumeActionPostDetach
     *
     * It could be an instance of the 'anyOf' schemas. The anyOf child schemas may
     * themselves be a composed schema (allOf, anyOf, anyOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(VolumeActionPostAttach.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(VolumeActionPostDetach.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be VolumeActionPostAttach, VolumeActionPostDetach");
    }

    /**
     * Get the actual instance, which can be the following: VolumeActionPostAttach,
     * VolumeActionPostDetach
     *
     * @return The actual instance (VolumeActionPostAttach, VolumeActionPostDetach)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `VolumeActionPostAttach`. If the actual instance
     * is not `VolumeActionPostAttach`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `VolumeActionPostAttach`
     * @throws ClassCastException if the instance is not `VolumeActionPostAttach`
     */
    public VolumeActionPostAttach getVolumeActionPostAttach() throws ClassCastException {
        return (VolumeActionPostAttach) super.getActualInstance();
    }

    /**
     * Get the actual instance of `VolumeActionPostDetach`. If the actual instance
     * is not `VolumeActionPostDetach`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `VolumeActionPostDetach`
     * @throws ClassCastException if the instance is not `VolumeActionPostDetach`
     */
    public VolumeActionPostDetach getVolumeActionPostDetach() throws ClassCastException {
        return (VolumeActionPostDetach) super.getActualInstance();
    }
}