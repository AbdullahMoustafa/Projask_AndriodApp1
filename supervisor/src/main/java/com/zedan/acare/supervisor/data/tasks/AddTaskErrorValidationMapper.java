package com.zedan.acare.supervisor.data.tasks;

import com.zedan.acare.supervisor.domain.mapper.Mapper;
import com.zedan.acare.supervisor.domain.tasks.AddTaskResult;

import java.util.Map;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Singleton
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0004\u0012\u00020\u00050\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/zedan/acare/supervisor/data/tasks/AddTaskErrorValidationMapper;", "Lcom/zedan/acare/supervisor/domain/mapper/Mapper;", "", "", "", "Lcom/zedan/acare/supervisor/domain/tasks/AddTaskResult$Error$InputError;", "()V", "map", "data", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: AddTaskErrorValidationMapper.kt */
public final class AddTaskErrorValidationMapper extends Mapper<Map<String, ? extends Boolean>, AddTaskResult.Error.InputError> {
    public Object map(Map<String, Boolean> data, Continuation<? super AddTaskResult.Error.InputError> $completion) {
        return new AddTaskResult.Error.InputError(MapExtKt.fetch(data, "isNotTitle"), MapExtKt.fetch(data, "isNotDesc"), MapExtKt.fetch(data, "isNotStartDate"), MapExtKt.fetch(data, "isNotStartHour"), MapExtKt.fetch(data, "isNotEndDate"), MapExtKt.fetch(data, "isNotEndHour"), MapExtKt.fetch(data, "isNotColor"));
    }
}
