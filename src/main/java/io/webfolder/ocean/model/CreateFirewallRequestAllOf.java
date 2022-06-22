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

@JsonDeserialize(using = CreateFirewallRequestAllOf.CreateFirewallRequestAllOfDeserializer.class)
@JsonSerialize(using = CreateFirewallRequestAllOf.CreateFirewallRequestAllOfSerializer.class)
public class CreateFirewallRequestAllOf extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(CreateFirewallRequestAllOf.class.getName());

    public static class CreateFirewallRequestAllOfSerializer extends StdSerializer<CreateFirewallRequestAllOf> {
        public CreateFirewallRequestAllOfSerializer(Class<CreateFirewallRequestAllOf> t) {
            super(t);
        }

        public CreateFirewallRequestAllOfSerializer() {
            this(null);
        }

        @Override
        public void serialize(CreateFirewallRequestAllOf value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class CreateFirewallRequestAllOfDeserializer extends StdDeserializer<CreateFirewallRequestAllOf> {
        public CreateFirewallRequestAllOfDeserializer() {
            this(CreateFirewallRequestAllOf.class);
        }

        public CreateFirewallRequestAllOfDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public CreateFirewallRequestAllOf deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();

            Object deserialized = null;
            // deserialize Object
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(Object.class);
                CreateFirewallRequestAllOf ret = new CreateFirewallRequestAllOf();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'CreateFirewallRequestAllOf'", e);
            }

            throw new IOException(
                    String.format("Failed deserialization for CreateFirewallRequestAllOf: no match found"));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public CreateFirewallRequestAllOf getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "CreateFirewallRequestAllOf cannot be null");
        }
    }

    // store a list of schema names defined in anyOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public CreateFirewallRequestAllOf() {
        super("anyOf", Boolean.FALSE);
    }

    public CreateFirewallRequestAllOf(Object o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("Object", Object.class);
        JSON.registerDescendants(CreateFirewallRequestAllOf.class, Collections.unmodifiableMap(schemas));
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return CreateFirewallRequestAllOf.schemas;
    }

    /**
     * Set the instance that matches the anyOf child schema, check the instance
     * parameter is valid against the anyOf child schemas: Object
     *
     * It could be an instance of the 'anyOf' schemas. The anyOf child schemas may
     * themselves be a composed schema (allOf, anyOf, anyOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(Object.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be Object");
    }

    /**
     * Get the actual instance, which can be the following: Object
     *
     * @return The actual instance (Object)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
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
