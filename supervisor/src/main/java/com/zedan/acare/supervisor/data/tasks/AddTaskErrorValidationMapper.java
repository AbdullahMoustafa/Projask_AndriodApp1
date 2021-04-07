package com.zedan.acare.supervisor.data.tasks;

import com.zedan.acare.supervisor.domain.mapper.Mapper;
import com.zedan.acare.supervisor.domain.tasks.AddTaskResult;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Singleton
public final class AddTaskErrorValidationMapper extends Mapper<Map<String,Boolean>, AddTaskResult.Error.InputError> {

    @Inject
    public AddTaskErrorValidationMapper(){
        super();
    }

    @Override
    public AddTaskResult.Error.InputError map(Map<String, Boolean> data) {
        return new AddTaskResult.Error.InputError(
                get(data, "isNotTitle"),
                get(data, "isNotDesc"),
                get(data, "isNotStartDate"),
                get(data, "isNotStartHour"),
                get(data, "isNotEndDate"),
                get(data, "isNotEndHour"),
                get(data, "isNotColor")
        );
    }
}
