package com.zedan.acare.supervisor.domain.mapper;

import java.util.Map;

public abstract class Mapper<T, R> {
    public abstract R map(T data);

    protected Boolean get(Map<String, Boolean> map, String key){
        Boolean value = map.get(key);
        if (value == null)
            return false;
        return value;
    }
}
