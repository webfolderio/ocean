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

@JsonDeserialize(using = ReservedIpDroplet.ReservedIpDropletDeserializer.class)
@JsonSerialize(using = ReservedIpDroplet.ReservedIpDropletSerializer.class)
public class ReservedIpDroplet extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(ReservedIpDroplet.class.getName());

    public static class ReservedIpDropletSerializer extends StdSerializer<ReservedIpDroplet> {
        public ReservedIpDropletSerializer(Class<ReservedIpDroplet> t) {
            super(t);
        }

        public ReservedIpDropletSerializer() {
            this(null);
        }

        @Override
        public void serialize(ReservedIpDroplet value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class ReservedIpDropletDeserializer extends StdDeserializer<ReservedIpDroplet> {
        public ReservedIpDropletDeserializer() {
            this(ReservedIpDroplet.class);
        }

        public ReservedIpDropletDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public ReservedIpDroplet deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();

            Object deserialized = null;
            // deserialize Droplet
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(Droplet.class);
                ReservedIpDroplet ret = new ReservedIpDroplet();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'ReservedIpDroplet'", e);
            }

            // deserialize Object
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(Object.class);
                ReservedIpDroplet ret = new ReservedIpDroplet();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'ReservedIpDroplet'", e);
            }

            throw new IOException(String.format("Failed deserialization for ReservedIpDroplet: no match found"));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public ReservedIpDroplet getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "ReservedIpDroplet cannot be null");
        }
    }

    // store a list of schema names defined in anyOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public ReservedIpDroplet() {
        super("anyOf", Boolean.FALSE);
    }

    public ReservedIpDroplet(Droplet o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public ReservedIpDroplet(Object o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("Droplet", Droplet.class);
        schemas.put("Object", Object.class);
        JSON.registerDescendants(ReservedIpDroplet.class, Collections.unmodifiableMap(schemas));
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return ReservedIpDroplet.schemas;
    }

    /**
     * Set the instance that matches the anyOf child schema, check the instance
     * parameter is valid against the anyOf child schemas: Droplet, Object
     *
     * It could be an instance of the 'anyOf' schemas. The anyOf child schemas may
     * themselves be a composed schema (allOf, anyOf, anyOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(Droplet.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(Object.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be Droplet, Object");
    }

    /**
     * Get the actual instance, which can be the following: Droplet, Object
     *
     * @return The actual instance (Droplet, Object)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `Droplet`. If the actual instance is not
     * `Droplet`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `Droplet`
     * @throws ClassCastException if the instance is not `Droplet`
     */
    public Droplet getDroplet() throws ClassCastException {
        return (Droplet) super.getActualInstance();
    }

    /**
     * Get the actual instance of `Object`. If the actual instance is not `Object`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `Object`
     * @throws ClassCastException if the instance is not `Object`
     */
    public Object getObject() throws ClassCastException {
        return (Object) super.getActualInstance();
    }
}