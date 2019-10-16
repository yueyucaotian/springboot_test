package com.example.demo.framework.support;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import java.io.IOException;

/**
 * @author Cao
 * @version 1.0
 * @date 2019/10/12 13:53
 */
public class JacksonUtil {

    public static ObjectMapper mapper = new ObjectMapper();

    public static String toJson(Object obj){
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return "";
        }
    }
    /**
     * 把对象转成json，并过滤字段
     * @param obj
     * @param fields
     * @return
     */
    public static String toJsonExclude(Object obj,String... fields){
        ObjectMapper filtermapper = new ObjectMapper();
        filtermapper.setFilterProvider(filter(fields));
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    private static FilterProvider filter(String... propertyes) {
        // 过滤不想要的
        FilterProvider filter = new SimpleFilterProvider().addFilter(
                "ObjectFilter",
                SimpleBeanPropertyFilter.serializeAllExcept(propertyes));
        // 过滤想要的
        /*
         * FilterProvider filter = new SimpleFilterProvider().addFilter(
         * filterName, SimpleBeanPropertyFilter.filterOutAllExcept(propertyes);
         */
        return filter;
    }

    public static <T> T toObject(String jsonStr,Class<T> type) {

        try {
            return mapper.readValue(jsonStr, type);
        } catch (IOException e) {
            return null;
        }
    }
    public static <T> T toObject(String jsonStr, TypeReference<T> type) {

        try {
            return mapper.readValue(jsonStr, type);
        } catch (IOException e) {
            return null;
        }
    }
}
