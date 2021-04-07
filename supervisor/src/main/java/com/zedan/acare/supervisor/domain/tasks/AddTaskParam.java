package com.zedan.acare.supervisor.domain.tasks;

import android.util.ArrayMap;

import androidx.annotation.NonNull;
import androidx.core.app.FrameMetricsAggregator;
import androidx.recyclerview.widget.DiffUtil;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;
import com.zedan.acare.supervisor.domain.Param;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

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

    private final String day;

    public AddTaskParam(){
        this("", "", "", "", "", "", "", "", -1);
    }

    public AddTaskParam(String title, String description, String startTime, String endTime, String startTimeDate, String startTimeHour, String endTimeDate, String endTimeHour, Integer taskColor) {
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startTimeDate = startTimeDate;
        this.startTimeHour = startTimeHour;
        this.endTimeDate = endTimeDate;
        this.endTimeHour = endTimeHour;
        this.taskColor = taskColor;
        String day;
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        try {
            Date d = format.parse(startTimeDate);
            if (d == null)
                throw new ParseException("date is Null.", 1);
            day = new SimpleDateFormat("EEEE", Locale.getDefault())
                    .format(d);
        } catch (ParseException e){
            e.printStackTrace();
            day = "";
        }
        this.day = day;
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

    public final String getDayWithTime(){
        return day + "  " + startTimeHour;
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

    @Override
    public String toString() {
        return "AddTaskParam{" +
                "description='" + description + '\'' +
                ", endTime='" + endTime + '\'' +
                ", endTimeDate='" + endTimeDate + '\'' +
                ", endTimeHour='" + endTimeHour + '\'' +
                ", startTime='" + startTime + '\'' +
                ", startTimeDate='" + startTimeDate + '\'' +
                ", startTimeHour='" + startTimeHour + '\'' +
                ", taskColor=" + taskColor +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddTaskParam)) return false;
        AddTaskParam that = (AddTaskParam) o;
        return Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getEndTime(), that.getEndTime()) &&
                Objects.equals(getEndTimeDate(), that.getEndTimeDate()) &&
                Objects.equals(getEndTimeHour(), that.getEndTimeHour()) &&
                Objects.equals(getStartTime(), that.getStartTime()) &&
                Objects.equals(getStartTimeDate(), that.getStartTimeDate()) &&
                Objects.equals(getStartTimeHour(), that.getStartTimeHour()) &&
                Objects.equals(getTaskColor(), that.getTaskColor()) &&
                Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), getEndTime(), getEndTimeDate(), getEndTimeHour(), getStartTime(), getStartTimeDate(), getStartTimeHour(), getTaskColor(), getTitle());
    }

    public static final DiffUtil.ItemCallback<AddTaskParam> DIFFUtil = new DiffUtil.ItemCallback<AddTaskParam>(){

        @Override
        public boolean areItemsTheSame(@NonNull AddTaskParam oldItem, @NonNull AddTaskParam newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull AddTaskParam oldItem, @NonNull AddTaskParam newItem) {
            return oldItem.equals(newItem);
        }
    };
}
