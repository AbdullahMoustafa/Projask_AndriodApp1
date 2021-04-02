package com.zedan.acare.supervisor.domain.tasks;

import android.util.ArrayMap;

import androidx.core.app.FrameMetricsAggregator;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;
import com.zedan.acare.supervisor.domain.Param;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@IgnoreExtraProperties
public final class AddTaskParam implements Param {
    private final String description;
    private final String endTime;
    private final String endTimeDate;
    private final String endTimeHour;
    private final String startTime;
    private final String startTimeDate;
    private final String startTimeHour;
    private final Integer taskColor;
    private final String title;

    public AddTaskParam() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public AddTaskParam(String title2, String description2, String startTime2, String endTime2, String startTimeDate2, String startTimeHour2, String endTimeDate2, String endTimeHour2, Integer taskColor2) {
        this.title = title2;
        this.description = description2;
        this.startTime = startTime2;
        this.endTime = endTime2;
        this.startTimeDate = startTimeDate2;
        this.startTimeHour = startTimeHour2;
        this.endTimeDate = endTimeDate2;
        this.endTimeHour = endTimeHour2;
        this.taskColor = taskColor2;
    }


    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getStartTimeDate() {
        return this.startTimeDate;
    }

    public final String getStartTimeHour() {
        return this.startTimeHour;
    }

    public final String getEndTimeDate() {
        return this.endTimeDate;
    }

    public final String getEndTimeHour() {
        return this.endTimeHour;
    }

    public final Integer getTaskColor() {
        return this.taskColor;
    }

    @Exclude
    public final Map<String, Object> toMap() {
        Map<String, Object> map = new ArrayMap<>();
        map.put("title", title);
        map.put("description", description);
        map.put("startTime", startTime);
        map.put("endTime", endTime);
        map.put("startTimeDate", startTimeDate);
        map.put("startTimeHour", startTimeHour);
        map.put("endTimeDate", endTimeDate);
        map.put("endTimeHour", endTimeHour);
        map.put("taskColor", taskColor);
        return map;
    }
}
