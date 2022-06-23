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

@JsonDeserialize(using = PostVolumeActionByIdRequest.PostVolumeActionByIdRequestDeserializer.class)
@JsonSerialize(using = PostVolumeActionByIdRequest.PostVolumeActionByIdRequestSerializer.class)
public class PostVolumeActionByIdRequest extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(PostVolumeActionByIdRequest.class.getName());

    public static class PostVolumeActionByIdRequestSerializer extends StdSerializer<PostVolumeActionByIdRequest> {
        public PostVolumeActionByIdRequestSerializer(Class<PostVolumeActionByIdRequest> t) {
            super(t);
        }

        public PostVolumeActionByIdRequestSerializer() {
            this(null);
        }

        @Override
        public void serialize(PostVolumeActionByIdRequest value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class PostVolumeActionByIdRequestDeserializer extends StdDeserializer<PostVolumeActionByIdRequest> {
        public PostVolumeActionByIdRequestDeserializer() {
            this(PostVolumeActionByIdRequest.class);
        }

        public PostVolumeActionByIdRequestDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public PostVolumeActionByIdRequest deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();

            Object deserialized = null;
            Class<?> cls = JSON.getClassForElement(tree, PostVolumeActionByIdRequest.class);
            if (cls != null) {
                // When the OAS schema includes a discriminator, use the discriminator value to
                // discriminate the anyOf schemas.
                // Get the discriminator mapping value to get the class.
                deserialized = tree.traverse(jp.getCodec()).readValueAs(cls);
                PostVolumeActionByIdRequest ret = new PostVolumeActionByIdRequest();
                ret.setActualInstance(deserialized);
                return ret;
            }
            // deserialize VolumeActionPostAttach
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(VolumeActionPostAttach.class);
                PostVolumeActionByIdRequest ret = new PostVolumeActionByIdRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'PostVolumeActionByIdRequest'", e);
            }

            // deserialize VolumeActionPostDetach
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(VolumeActionPostDetach.class);
                PostVolumeActionByIdRequest ret = new PostVolumeActionByIdRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'PostVolumeActionByIdRequest'", e);
            }

            // deserialize VolumeActionPostResize
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(VolumeActionPostResize.class);
                PostVolumeActionByIdRequest ret = new PostVolumeActionByIdRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'PostVolumeActionByIdRequest'", e);
            }

            throw new IOException(
                    String.format("Failed deserialization for PostVolumeActionByIdRequest: no match found"));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public PostVolumeActionByIdRequest getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "PostVolumeActionByIdRequest cannot be null");
        }
    }

    // store a list of schema names defined in anyOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public PostVolumeActionByIdRequest() {
        super("anyOf", Boolean.FALSE);
    }

    public PostVolumeActionByIdRequest(VolumeActionPostAttach o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public PostVolumeActionByIdRequest(VolumeActionPostDetach o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public PostVolumeActionByIdRequest(VolumeActionPostResize o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("VolumeActionPostAttach", VolumeActionPostAttach.class);
        schemas.put("VolumeActionPostDetach", VolumeActionPostDetach.class);
        schemas.put("VolumeActionPostResize", VolumeActionPostResize.class);
        JSON.registerDescendants(PostVolumeActionByIdRequest.class, Collections.unmodifiableMap(schemas));
        // Initialize and register the discriminator mappings.
        Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
        mappings.put("attach", VolumeActionPostAttach.class);
        mappings.put("detach", VolumeActionPostDetach.class);
        mappings.put("resize", VolumeActionPostResize.class);
        mappings.put("volume_action_post_attach", VolumeActionPostAttach.class);
        mappings.put("volume_action_post_detach", VolumeActionPostDetach.class);
        mappings.put("volume_action_post_resize", VolumeActionPostResize.class);
        mappings.put("post_volume_action_by_id_request", PostVolumeActionByIdRequest.class);
        JSON.registerDiscriminator(PostVolumeActionByIdRequest.class, "type", mappings);
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return PostVolumeActionByIdRequest.schemas;
    }

    /**
     * Set the instance that matches the anyOf child schema, check the instance
     * parameter is valid against the anyOf child schemas: VolumeActionPostAttach,
     * VolumeActionPostDetach, VolumeActionPostResize
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

        if (JSON.isInstanceOf(VolumeActionPostResize.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException(
                "Invalid instance type. Must be VolumeActionPostAttach, VolumeActionPostDetach, VolumeActionPostResize");
    }

    /**
     * Get the actual instance, which can be the following: VolumeActionPostAttach,
     * VolumeActionPostDetach, VolumeActionPostResize
     *
     * @return The actual instance (VolumeActionPostAttach, VolumeActionPostDetach,
     *         VolumeActionPostResize)
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

    /**
     * Get the actual instance of `VolumeActionPostResize`. If the actual instance
     * is not `VolumeActionPostResize`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `VolumeActionPostResize`
     * @throws ClassCastException if the instance is not `VolumeActionPostResize`
     */
    public VolumeActionPostResize getVolumeActionPostResize() throws ClassCastException {
        return (VolumeActionPostResize) super.getActualInstance();
    }
}