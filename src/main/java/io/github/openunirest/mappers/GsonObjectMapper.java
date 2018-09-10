package io.github.openunirest.mappers;

import com.google.gson.Gson;
import io.github.openunirest.http.ObjectMapper;
import io.github.openunirest.request.GenericType;

public class GsonObjectMapper implements ObjectMapper {
    private Gson om;

    public GsonObjectMapper() {
        this(new Gson());
    }

    public GsonObjectMapper(Gson om) {
        this.om = om;
    }

    @Override
    public <T> T readValue(String value, Class<T> valueType) {
        return om.fromJson(value, valueType);
    }

    @Override
    public <T> T readValue(String value, GenericType<T> genericType) {
        return om.fromJson(value, genericType.getType());
    }

    @Override
    public String writeValue(Object value) {
        return om.toJson(value);
    }
}
