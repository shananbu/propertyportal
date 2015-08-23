package com.ats.property.service.spring.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

/**
 * The JacksonJsonProvider.
 *
 * @author anbarasan.s
 */
public class JacksonJsonProvider extends JacksonJaxbJsonProvider {
    /**
     * The ObjectMapper.
     */
    private static ObjectMapper commonMapper = null;

    /**
     * Constructor.
     */
    public JacksonJsonProvider() {

        if(commonMapper == null){
            ObjectMapper mapper = new JodaObjectMapper();
            mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
            mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false);
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
            mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY) ;
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL) ;


            commonMapper = mapper;
        }
        super.setMapper(commonMapper);

    }

    class JodaObjectMapper extends ObjectMapper {

        public JodaObjectMapper() {
            super();
            registerModule(new JodaModule());
        }
    }
}
