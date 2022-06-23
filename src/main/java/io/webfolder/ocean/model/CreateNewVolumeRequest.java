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

@JsonDeserialize(using = CreateNewVolumeRequest.CreateNewVolumeRequestDeserializer.class)
@JsonSerialize(using = CreateNewVolumeRequest.CreateNewVolumeRequestSerializer.class)
public class CreateNewVolumeRequest extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(CreateNewVolumeRequest.class.getName());

    public static class CreateNewVolumeRequestSerializer extends StdSerializer<CreateNewVolumeRequest> {
        public CreateNewVolumeRequestSerializer(Class<CreateNewVolumeRequest> t) {
            super(t);
        }

        public CreateNewVolumeRequestSerializer() {
            this(null);
        }

        @Override
        public void serialize(CreateNewVolumeRequest value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class CreateNewVolumeRequestDeserializer extends StdDeserializer<CreateNewVolumeRequest> {
        public CreateNewVolumeRequestDeserializer() {
            this(CreateNewVolumeRequest.class);
        }

        public CreateNewVolumeRequestDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public CreateNewVolumeRequest deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();

            Object deserialized = null;
            Class<?> cls = JSON.getClassForElement(tree, CreateNewVolumeRequest.class);
            if (cls != null) {
                // When the OAS schema includes a discriminator, use the discriminator value to
                // discriminate the anyOf schemas.
                // Get the discriminator mapping value to get the class.
                deserialized = tree.traverse(jp.getCodec()).readValueAs(cls);
                CreateNewVolumeRequest ret = new CreateNewVolumeRequest();
                ret.setActualInstance(deserialized);
                return ret;
            }
            // deserialize NewVolumeExt4
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(NewVolumeExt4.class);
                CreateNewVolumeRequest ret = new CreateNewVolumeRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'CreateNewVolumeRequest'", e);
            }

            // deserialize NewVolumeXfs
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(NewVolumeXfs.class);
                CreateNewVolumeRequest ret = new CreateNewVolumeRequest();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'CreateNewVolumeRequest'", e);
            }

            throw new IOException(String.format("Failed deserialization for CreateNewVolumeRequest: no match found"));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public CreateNewVolumeRequest getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "CreateNewVolumeRequest cannot be null");
        }
    }

    // store a list of schema names defined in anyOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public CreateNewVolumeRequest() {
        super("anyOf", Boolean.FALSE);
    }

    public CreateNewVolumeRequest(NewVolumeExt4 o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public CreateNewVolumeRequest(NewVolumeXfs o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("NewVolumeExt4", NewVolumeExt4.class);
        schemas.put("NewVolumeXfs", NewVolumeXfs.class);
        JSON.registerDescendants(CreateNewVolumeRequest.class, Collections.unmodifiableMap(schemas));
        // Initialize and register the discriminator mappings.
        Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
        mappings.put("ext4", NewVolumeExt4.class);
        mappings.put("new_volume_ext4", NewVolumeExt4.class);
        mappings.put("new_volume_xfs", NewVolumeXfs.class);
        mappings.put("xfs", NewVolumeXfs.class);
        mappings.put("create_new_volume_request", CreateNewVolumeRequest.class);
        JSON.registerDiscriminator(CreateNewVolumeRequest.class, "filesystem_type", mappings);
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return CreateNewVolumeRequest.schemas;
    }

    /**
     * Set the instance that matches the anyOf child schema, check the instance
     * parameter is valid against the anyOf child schemas: NewVolumeExt4,
     * NewVolumeXfs
     *
     * It could be an instance of the 'anyOf' schemas. The anyOf child schemas may
     * themselves be a composed schema (allOf, anyOf, anyOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(NewVolumeExt4.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(NewVolumeXfs.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be NewVolumeExt4, NewVolumeXfs");
    }

    /**
     * Get the actual instance, which can be the following: NewVolumeExt4,
     * NewVolumeXfs
     *
     * @return The actual instance (NewVolumeExt4, NewVolumeXfs)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `NewVolumeExt4`. If the actual instance is not
     * `NewVolumeExt4`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `NewVolumeExt4`
     * @throws ClassCastException if the instance is not `NewVolumeExt4`
     */
    public NewVolumeExt4 getNewVolumeExt4() throws ClassCastException {
        return (NewVolumeExt4) super.getActualInstance();
    }

    /**
     * Get the actual instance of `NewVolumeXfs`. If the actual instance is not
     * `NewVolumeXfs`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `NewVolumeXfs`
     * @throws ClassCastException if the instance is not `NewVolumeXfs`
     */
    public NewVolumeXfs getNewVolumeXfs() throws ClassCastException {
        return (NewVolumeXfs) super.getActualInstance();
    }
}