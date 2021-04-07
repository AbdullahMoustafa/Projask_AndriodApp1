package com.zedan.acare.supervisor.data.tasks;

import android.util.ArrayMap;

import com.zedan.acare.supervisor.domain.mapper.Mapper;
import com.zedan.acare.supervisor.domain.tasks.AddTaskParam;
import com.zedan.acare.supervisor.utils.Validator;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

@Singleton
public final class AddTaskValidationMapper extends Mapper<AddTaskParam, Map<String, Boolean>> {

    @Inject
    public AddTaskValidationMapper(){
        super();
    }

    @Override
    public Map<String, Boolean> map(AddTaskParam data) {
        Map<String, Boolean> map = new ArrayMap<>();
        map.put("isNotTitle", Validator.isName(data.getTitle(), 2));
        map.put("isNotDesc", Validator.isName(data.getDescription(), 2));
        map.put("isNotStartDate", Validator.isDate(data.getStartTimeDate()));
        map.put("isNotStartHour", Validator.isHour(data.getStartTimeHour()));
        map.put("isNotEndDate", Validator.isDate(data.getEndTimeDate()));
        map.put("isNotEndHour", Validator.isHour(data.getEndTimeHour()));
        map.put("isNotColor", isColor(data.getTaskColor()));
        return map;
    }

    public  boolean isColor(Integer color) {
        return color != null && color != -1;
    }
}
