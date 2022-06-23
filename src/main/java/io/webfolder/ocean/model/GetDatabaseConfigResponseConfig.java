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

@JsonDeserialize(using = GetDatabaseConfigResponseConfig.GetDatabaseConfigResponseConfigDeserializer.class)
@JsonSerialize(using = GetDatabaseConfigResponseConfig.GetDatabaseConfigResponseConfigSerializer.class)
public class GetDatabaseConfigResponseConfig extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(GetDatabaseConfigResponseConfig.class.getName());

    public static class GetDatabaseConfigResponseConfigSerializer
            extends StdSerializer<GetDatabaseConfigResponseConfig> {
        public GetDatabaseConfigResponseConfigSerializer(Class<GetDatabaseConfigResponseConfig> t) {
            super(t);
        }

        public GetDatabaseConfigResponseConfigSerializer() {
            this(null);
        }

        @Override
        public void serialize(GetDatabaseConfigResponseConfig value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class GetDatabaseConfigResponseConfigDeserializer
            extends StdDeserializer<GetDatabaseConfigResponseConfig> {
        public GetDatabaseConfigResponseConfigDeserializer() {
            this(GetDatabaseConfigResponseConfig.class);
        }

        public GetDatabaseConfigResponseConfigDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public GetDatabaseConfigResponseConfig deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();

            Object deserialized = null;
            // deserialize Mysql
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(Mysql.class);
                GetDatabaseConfigResponseConfig ret = new GetDatabaseConfigResponseConfig();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'GetDatabaseConfigResponseConfig'", e);
            }

            // deserialize Postgres
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(Postgres.class);
                GetDatabaseConfigResponseConfig ret = new GetDatabaseConfigResponseConfig();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'GetDatabaseConfigResponseConfig'", e);
            }

            // deserialize Redis
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(Redis.class);
                GetDatabaseConfigResponseConfig ret = new GetDatabaseConfigResponseConfig();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'GetDatabaseConfigResponseConfig'", e);
            }

            throw new IOException(
                    String.format("Failed deserialization for GetDatabaseConfigResponseConfig: no match found"));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public GetDatabaseConfigResponseConfig getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "GetDatabaseConfigResponseConfig cannot be null");
        }
    }

    // store a list of schema names defined in anyOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public GetDatabaseConfigResponseConfig() {
        super("anyOf", Boolean.FALSE);
    }

    public GetDatabaseConfigResponseConfig(Mysql o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public GetDatabaseConfigResponseConfig(Postgres o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public GetDatabaseConfigResponseConfig(Redis o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("Mysql", Mysql.class);
        schemas.put("Postgres", Postgres.class);
        schemas.put("Redis", Redis.class);
        JSON.registerDescendants(GetDatabaseConfigResponseConfig.class, Collections.unmodifiableMap(schemas));
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return GetDatabaseConfigResponseConfig.schemas;
    }

    /**
     * Set the instance that matches the anyOf child schema, check the instance
     * parameter is valid against the anyOf child schemas: Mysql, Postgres, Redis
     *
     * It could be an instance of the 'anyOf' schemas. The anyOf child schemas may
     * themselves be a composed schema (allOf, anyOf, anyOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(Mysql.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(Postgres.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(Redis.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be Mysql, Postgres, Redis");
    }

    /**
     * Get the actual instance, which can be the following: Mysql, Postgres, Redis
     *
     * @return The actual instance (Mysql, Postgres, Redis)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `Mysql`. If the actual instance is not `Mysql`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `Mysql`
     * @throws ClassCastException if the instance is not `Mysql`
     */
    public Mysql getMysql() throws ClassCastException {
        return (Mysql) super.getActualInstance();
    }

    /**
     * Get the actual instance of `Postgres`. If the actual instance is not
     * `Postgres`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `Postgres`
     * @throws ClassCastException if the instance is not `Postgres`
     */
    public Postgres getPostgres() throws ClassCastException {
        return (Postgres) super.getActualInstance();
    }

    /**
     * Get the actual instance of `Redis`. If the actual instance is not `Redis`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `Redis`
     * @throws ClassCastException if the instance is not `Redis`
     */
    public Redis getRedis() throws ClassCastException {
        return (Redis) super.getActualInstance();
    }
}