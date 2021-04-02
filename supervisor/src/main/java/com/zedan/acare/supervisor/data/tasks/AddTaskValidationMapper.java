package com.zedan.acare.supervisor.data.tasks;

import com.zedan.acare.supervisor.domain.mapper.Mapper;
import com.zedan.acare.supervisor.domain.tasks.AddTaskParam;
import com.zedan.acare.supervisor.utils.Validator;
import java.util.Map;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

@Singleton
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\b\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0011\u0010\n\u001a\u00020\u0005*\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/zedan/acare/supervisor/data/tasks/AddTaskValidationMapper;", "Lcom/zedan/acare/supervisor/domain/mapper/Mapper;", "Lcom/zedan/acare/supervisor/domain/tasks/AddTaskParam;", "", "", "", "()V", "map", "data", "(Lcom/zedan/acare/supervisor/domain/tasks/AddTaskParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isColor", "", "(Ljava/lang/Integer;)Z", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: AddTaskValidationMapper.kt */
public final class AddTaskValidationMapper extends Mapper<AddTaskParam, Map<String, ? extends Boolean>> {
    public Object map(AddTaskParam data, Continuation<? super Map<String, Boolean>> $completion) {
        return MapsKt.mapOf(TuplesKt.to("isNotTitle", Boxing.boxBoolean(Validator.isName$default(data.getTitle(), 0, 1, (Object) null))), TuplesKt.to("isNotDesc", Boxing.boxBoolean(Validator.isName$default(data.getDescription(), 0, 1, (Object) null))), TuplesKt.to("isNotStartDate", Boxing.boxBoolean(Validator.isDate(data.getStartTimeDate()))), TuplesKt.to("isNotStartHour", Boxing.boxBoolean(Validator.isHour(data.getStartTimeHour()))), TuplesKt.to("isNotEndDate", Boxing.boxBoolean(Validator.isDate(data.getEndTimeDate()))), TuplesKt.to("isNotEndHour", Boxing.boxBoolean(Validator.isHour(data.getEndTimeHour()))), TuplesKt.to("isNotColor", Boxing.boxBoolean(isColor(data.getTaskColor()))));
    }

    public final boolean isColor(Integer $this$isColor) {
        return ($this$isColor == null || $this$isColor.intValue() == -1) ? false : true;
    }
}
