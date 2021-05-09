package dk.nine.academy.modernejava.util;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonHelper {

    static public final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    static {
        OBJECT_MAPPER.disable(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS, MapperFeature.AUTO_DETECT_GETTERS,
                MapperFeature.AUTO_DETECT_IS_GETTERS);
        OBJECT_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
    }

}
