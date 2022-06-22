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

@JsonDeserialize(using = PostImageActionRequest.PostImageActionRequestDeserializer.class)
@JsonSerialize(using = PostImageActionRequest.PostImageActionRequestSerializer.class)
public class PostImageActionRequest extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(PostImageActionRequest.class.getName());

    public static class PostImageActionRequestSerializer extends StdSerializer<PostImageActionRequest> {
        public PostImageActionRequestSerializer(Class<PostImageActionRequest> t) {
            super(t);
        }

        public PostImageActionRequestSerializer() {
            this(null);
        }

        @Override
        public void serialize(PostImageActionRequest value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class PostImageActionRequestDeserializer extends StdDeserializer<PostImageActionRequest> {
        public PostImageActionRequestDeserializer() {
            this(PostImageActionRequest.class);
        }

        public PostImageActionRequestDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public PostImageActionRequest deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();

            Object deserialized = null;
            Class<?> cls = JSON.getClassForElement(tree, PostImageActionRequest.class);
            if (cls != null) {
                // When the OAS schema includes a discriminator, use the discriminator value to
                // discriminate the anyOf schemas.
                // Get the discriminator mapping value to get the class.
                deserialized = tree.traverse(jp.getCodec()).readValueAs(cls);
                PostImageActionRequest ret = new PostImageActionRequest();
                ret.setActualInstance(deserialized);
                return ret;
            }
            // deserialize ImageActionBase
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(ImageActionBase.class);
                PostImageActionRequest ret = new PostImageActionRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'PostImageActionRequest'", e);
            }

            // deserialize ImageActionTransfer
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(ImageActionTransfer.class);
                PostImageActionRequest ret = new PostImageActionRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'PostImageActionRequest'", e);
            }

            throw new IOException(String.format("Failed deserialization for PostImageActionRequest: no match found"));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public PostImageActionRequest getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "PostImageActionRequest cannot be null");
        }
    }

    // store a list of schema names defined in anyOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public PostImageActionRequest() {
        super("anyOf", Boolean.FALSE);
    }

    public PostImageActionRequest(ImageActionBase o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public PostImageActionRequest(ImageActionTransfer o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("ImageActionBase", ImageActionBase.class);
        schemas.put("ImageActionTransfer", ImageActionTransfer.class);
        JSON.registerDescendants(PostImageActionRequest.class, Collections.unmodifiableMap(schemas));
        // Initialize and register the discriminator mappings.
        Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
        mappings.put("convert", ImageActionBase.class);
        mappings.put("image_action_base", ImageActionBase.class);
        mappings.put("image_action_transfer", ImageActionTransfer.class);
        mappings.put("transfer", ImageActionTransfer.class);
        mappings.put("post_image_action_request", PostImageActionRequest.class);
        JSON.registerDiscriminator(PostImageActionRequest.class, "type", mappings);
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return PostImageActionRequest.schemas;
    }

    /**
     * Set the instance that matches the anyOf child schema, check the instance
     * parameter is valid against the anyOf child schemas: ImageActionBase,
     * ImageActionTransfer
     *
     * It could be an instance of the 'anyOf' schemas. The anyOf child schemas may
     * themselves be a composed schema (allOf, anyOf, anyOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(ImageActionBase.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(ImageActionTransfer.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be ImageActionBase, ImageActionTransfer");
    }

    /**
     * Get the actual instance, which can be the following: ImageActionBase,
     * ImageActionTransfer
     *
     * @return The actual instance (ImageActionBase, ImageActionTransfer)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `ImageActionBase`. If the actual instance is not
     * `ImageActionBase`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `ImageActionBase`
     * @throws ClassCastException if the instance is not `ImageActionBase`
     */
    public ImageActionBase getImageActionBase() throws ClassCastException {
        return (ImageActionBase) super.getActualInstance();
    }

    /**
     * Get the actual instance of `ImageActionTransfer`. If the actual instance is
     * not `ImageActionTransfer`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `ImageActionTransfer`
     * @throws ClassCastException if the instance is not `ImageActionTransfer`
     */
    public ImageActionTransfer getImageActionTransfer() throws ClassCastException {
        return (ImageActionTransfer) super.getActualInstance();
    }

}
