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

@JsonDeserialize(using = PageLinksPages.PageLinksPagesDeserializer.class)
@JsonSerialize(using = PageLinksPages.PageLinksPagesSerializer.class)
public class PageLinksPages extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(PageLinksPages.class.getName());

    public static class PageLinksPagesSerializer extends StdSerializer<PageLinksPages> {
        public PageLinksPagesSerializer(Class<PageLinksPages> t) {
            super(t);
        }

        public PageLinksPagesSerializer() {
            this(null);
        }

        @Override
        public void serialize(PageLinksPages value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class PageLinksPagesDeserializer extends StdDeserializer<PageLinksPages> {
        public PageLinksPagesDeserializer() {
            this(PageLinksPages.class);
        }

        public PageLinksPagesDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public PageLinksPages deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();

            Object deserialized = null;
            // deserialize BackwardLinks
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(BackwardLinks.class);
                PageLinksPages ret = new PageLinksPages();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'PageLinksPages'", e);
            }

            // deserialize ForwardLinks
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(ForwardLinks.class);
                PageLinksPages ret = new PageLinksPages();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'PageLinksPages'", e);
            }

            // deserialize Object
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(Object.class);
                PageLinksPages ret = new PageLinksPages();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'PageLinksPages'", e);
            }

            throw new IOException(String.format("Failed deserialization for PageLinksPages: no match found"));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public PageLinksPages getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "PageLinksPages cannot be null");
        }
    }

    // store a list of schema names defined in anyOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public PageLinksPages() {
        super("anyOf", Boolean.FALSE);
    }

    public PageLinksPages(BackwardLinks o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public PageLinksPages(ForwardLinks o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public PageLinksPages(Object o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("BackwardLinks", BackwardLinks.class);
        schemas.put("ForwardLinks", ForwardLinks.class);
        schemas.put("Object", Object.class);
        JSON.registerDescendants(PageLinksPages.class, Collections.unmodifiableMap(schemas));
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return PageLinksPages.schemas;
    }

    /**
     * Set the instance that matches the anyOf child schema, check the instance
     * parameter is valid against the anyOf child schemas: BackwardLinks,
     * ForwardLinks, Object
     *
     * It could be an instance of the 'anyOf' schemas. The anyOf child schemas may
     * themselves be a composed schema (allOf, anyOf, anyOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(BackwardLinks.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(ForwardLinks.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(Object.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be BackwardLinks, ForwardLinks, Object");
    }

    /**
     * Get the actual instance, which can be the following: BackwardLinks,
     * ForwardLinks, Object
     *
     * @return The actual instance (BackwardLinks, ForwardLinks, Object)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `BackwardLinks`. If the actual instance is not
     * `BackwardLinks`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `BackwardLinks`
     * @throws ClassCastException if the instance is not `BackwardLinks`
     */
    public BackwardLinks getBackwardLinks() throws ClassCastException {
        return (BackwardLinks) super.getActualInstance();
    }

    /**
     * Get the actual instance of `ForwardLinks`. If the actual instance is not
     * `ForwardLinks`, the ClassCastException will be thrown.
     *
     * @return The actual instance of `ForwardLinks`
     * @throws ClassCastException if the instance is not `ForwardLinks`
     */
    public ForwardLinks getForwardLinks() throws ClassCastException {
        return (ForwardLinks) super.getActualInstance();
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
