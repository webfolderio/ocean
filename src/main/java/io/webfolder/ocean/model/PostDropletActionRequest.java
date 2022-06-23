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

@JsonDeserialize(using = PostDropletActionRequest.PostDropletActionRequestDeserializer.class)
@JsonSerialize(using = PostDropletActionRequest.PostDropletActionRequestSerializer.class)
public class PostDropletActionRequest extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(PostDropletActionRequest.class.getName());

    public static class PostDropletActionRequestSerializer extends StdSerializer<PostDropletActionRequest> {
        public PostDropletActionRequestSerializer(Class<PostDropletActionRequest> t) {
            super(t);
        }

        public PostDropletActionRequestSerializer() {
            this(null);
        }

        @Override
        public void serialize(PostDropletActionRequest value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class PostDropletActionRequestDeserializer extends StdDeserializer<PostDropletActionRequest> {
        public PostDropletActionRequestDeserializer() {
            this(PostDropletActionRequest.class);
        }

        public PostDropletActionRequestDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public PostDropletActionRequest deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();

            Object deserialized = null;
            Class<?> cls = JSON.getClassForElement(tree, PostDropletActionRequest.class);
            if (cls != null) {
                // When the OAS schema includes a discriminator, use the discriminator value to
                // discriminate the anyOf schemas.
                // Get the discriminator mapping value to get the class.
                deserialized = tree.traverse(jp.getCodec()).readValueAs(cls);
                PostDropletActionRequest ret = new PostDropletActionRequest();
                ret.setActualInstance(deserialized);
                return ret;
            }
            // deserialize DropletActionChangeKernel
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(DropletActionChangeKernel.class);
                PostDropletActionRequest ret = new PostDropletActionRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'PostDropletActionRequest'", e);
            }

            // deserialize DropletActionRebuild
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(DropletActionRebuild.class);
                PostDropletActionRequest ret = new PostDropletActionRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'PostDropletActionRequest'", e);
            }

            // deserialize DropletActionRename
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(DropletActionRename.class);
                PostDropletActionRequest ret = new PostDropletActionRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'PostDropletActionRequest'", e);
            }

            // deserialize DropletActionResize
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(DropletActionResize.class);
                PostDropletActionRequest ret = new PostDropletActionRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'PostDropletActionRequest'", e);
            }

            // deserialize DropletActionRestore
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(DropletActionRestore.class);
                PostDropletActionRequest ret = new PostDropletActionRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'PostDropletActionRequest'", e);
            }

            // deserialize DropletActionSnapshot
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(DropletActionSnapshot.class);
                PostDropletActionRequest ret = new PostDropletActionRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'PostDropletActionRequest'", e);
            }

            // deserialize DropletActionType
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(DropletActionType.class);
                PostDropletActionRequest ret = new PostDropletActionRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'PostDropletActionRequest'", e);
            }

            throw new IOException(String.format("Failed deserialization for PostDropletActionRequest: no match found"));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public PostDropletActionRequest getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "PostDropletActionRequest cannot be null");
        }
    }

    // store a list of schema names defined in anyOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public PostDropletActionRequest() {
        super("anyOf", Boolean.FALSE);
    }

    public PostDropletActionRequest(DropletActionChangeKernel o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public PostDropletActionRequest(DropletActionRebuild o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public PostDropletActionRequest(DropletActionRename o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public PostDropletActionRequest(DropletActionResize o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public PostDropletActionRequest(DropletActionRestore o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public PostDropletActionRequest(DropletActionSnapshot o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public PostDropletActionRequest(DropletActionType o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("DropletActionChangeKernel", DropletActionChangeKernel.class);
        schemas.put("DropletActionRebuild", DropletActionRebuild.class);
        schemas.put("DropletActionRename", DropletActionRename.class);
        schemas.put("DropletActionResize", DropletActionResize.class);
        schemas.put("DropletActionRestore", DropletActionRestore.class);
        schemas.put("DropletActionSnapshot", DropletActionSnapshot.class);
        schemas.put("DropletActionType", DropletActionType.class);
        JSON.registerDescendants(PostDropletActionRequest.class, Collections.unmodifiableMap(schemas));
        // Initialize and register the discriminator mappings.
        Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
        mappings.put("change_kernel", DropletActionChangeKernel.class);
        mappings.put("disable_backups", DropletActionType.class);
        mappings.put("droplet_action_change_kernel", DropletActionChangeKernel.class);
        mappings.put("droplet_action_rebuild", DropletActionRebuild.class);
        mappings.put("droplet_action_rename", DropletActionRename.class);
        mappings.put("droplet_action_resize", DropletActionResize.class);
        mappings.put("droplet_action_restore", DropletActionRestore.class);
        mappings.put("droplet_action_snapshot", DropletActionSnapshot.class);
        mappings.put("droplet_action_type", DropletActionType.class);
        mappings.put("enable_backups", DropletActionType.class);
        mappings.put("enable_ipv6", DropletActionType.class);
        mappings.put("password_reset", DropletActionType.class);
        mappings.put("power_cycle", DropletActionType.class);
        mappings.put("power_off", DropletActionType.class);
        mappings.put("power_on", DropletActionType.class);
        mappings.put("reboot", DropletActionType.class);
        mappings.put("rebuild", DropletActionRebuild.class);
        mappings.put("rename", DropletActionRename.class);
        mappings.put("resize", DropletActionResize.class);
        mappings.put("restore", DropletActionRestore.class);
        mappings.put("shutdown", DropletActionType.class);
        mappings.put("snapshot", DropletActionSnapshot.class);
        mappings.put("post_droplet_action_request", PostDropletActionRequest.class);
        JSON.registerDiscriminator(PostDropletActionRequest.class, "type", mappings);
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return PostDropletActionRequest.schemas;
    }

    /**
     * Set the instance that matches the anyOf child schema, check the instance
     * parameter is valid against the anyOf child schemas:
     * DropletActionChangeKernel, DropletActionRebuild, DropletActionRename,
     * DropletActionResize, DropletActionRestore, DropletActionSnapshot,
     * DropletActionType
     *
     * It could be an instance of the 'anyOf' schemas. The anyOf child schemas may
     * themselves be a composed schema (allOf, anyOf, anyOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(DropletActionChangeKernel.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(DropletActionRebuild.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(DropletActionRename.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(DropletActionResize.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(DropletActionRestore.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(DropletActionSnapshot.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(DropletActionType.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException(
                "Invalid instance type. Must be DropletActionChangeKernel, DropletActionRebuild, DropletActionRename, DropletActionResize, DropletActionRestore, DropletActionSnapshot, DropletActionType");
    }

    /**
     * Get the actual instance, which can be the following:
     * DropletActionChangeKernel, DropletActionRebuild, DropletActionRename,
     * DropletActionResize, DropletActionRestore, DropletActionSnapshot,
     * DropletActionType
     *
     * @return The actual instance (DropletActionChangeKernel, DropletActionRebuild,
     *         DropletActionRename, DropletActionResize, DropletActionRestore,
     *         DropletActionSnapshot, DropletActionType)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `DropletActionChangeKernel`. If the actual
     * instance is not `DropletActionChangeKernel`, the ClassCastException will be
     * thrown.
     *
     * @return The actual instance of `DropletActionChangeKernel`
     * @throws ClassCastException if the instance is not `DropletActionChangeKernel`
     */
    public DropletActionChangeKernel getDropletActionChangeKernel() throws ClassCastException {
        return (DropletActionChangeKernel) super.getActualInstance();
    }

    /**
     * Get the actual instance of `DropletActionRebuild`. If the actual instance is
     * not `DropletActionRebuild`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `DropletActionRebuild`
     * @throws ClassCastException if the instance is not `DropletActionRebuild`
     */
    public DropletActionRebuild getDropletActionRebuild() throws ClassCastException {
        return (DropletActionRebuild) super.getActualInstance();
    }

    /**
     * Get the actual instance of `DropletActionRename`. If the actual instance is
     * not `DropletActionRename`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `DropletActionRename`
     * @throws ClassCastException if the instance is not `DropletActionRename`
     */
    public DropletActionRename getDropletActionRename() throws ClassCastException {
        return (DropletActionRename) super.getActualInstance();
    }

    /**
     * Get the actual instance of `DropletActionResize`. If the actual instance is
     * not `DropletActionResize`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `DropletActionResize`
     * @throws ClassCastException if the instance is not `DropletActionResize`
     */
    public DropletActionResize getDropletActionResize() throws ClassCastException {
        return (DropletActionResize) super.getActualInstance();
    }

    /**
     * Get the actual instance of `DropletActionRestore`. If the actual instance is
     * not `DropletActionRestore`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `DropletActionRestore`
     * @throws ClassCastException if the instance is not `DropletActionRestore`
     */
    public DropletActionRestore getDropletActionRestore() throws ClassCastException {
        return (DropletActionRestore) super.getActualInstance();
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