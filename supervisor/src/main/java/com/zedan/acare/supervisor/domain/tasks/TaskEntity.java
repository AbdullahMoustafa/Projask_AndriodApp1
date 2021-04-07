package com.zedan.acare.supervisor.domain.tasks;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public final class TaskEntity {
    private final String date;
    private final List<AddTaskParam> tasks;
    private final String nameDay;
    private final String day;

    public TaskEntity(){
        this.date = "";
        this.tasks = new ArrayList<>(0);
        this.nameDay = "";
        this.day = "";

    }

    public TaskEntity(String date, List<AddTaskParam> tasks){
        String nameDay;
        String day;
        this.date = date;
        this.tasks = tasks;
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        try {
            Date d = format.parse(date);
            if (d == null)
                throw new ParseException("date is Null.", 1);
            nameDay = new SimpleDateFormat("EEEE", Locale.getDefault())
                    .format(d);
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            day = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        } catch (ParseException e) {
            e.printStackTrace();
            nameDay = "";
            day = "";
        }
        this.nameDay = nameDay;
        this.day = day;
    }

    public String getNameDay(){
        return this.nameDay;
    }

    public String getDay(){
        return this.day;
    }

    public List<AddTaskParam> getTasks() {
        return tasks;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "TaskEntity{" +
                "date='" + date + '\'' +
                ", tasks=" + tasks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskEntity)) return false;
        TaskEntity that = (TaskEntity) o;
        return Objects.equals(getDate(), that.getDate()) &&
                Objects.equals(getTasks(), that.getTasks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getTasks());
    }

    public static DiffUtil.ItemCallback<TaskEntity> DIFFUtil = new DiffUtil.ItemCallback<TaskEntity>() {
        @Override
        public boolean areItemsTheSame(@NonNull TaskEntity oldItem, @NonNull TaskEntity newItem) {
            return oldItem.date.equals(newItem.date);
        }

        @Override
        public boolean areContentsTheSame(@NonNull TaskEntity oldItem, @NonNull TaskEntity newItem) {
            return oldItem.equals(newItem);
        }
    };
}
