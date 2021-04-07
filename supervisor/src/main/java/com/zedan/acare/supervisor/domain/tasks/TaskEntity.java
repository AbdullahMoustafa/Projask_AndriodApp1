package com.zedan.acare.supervisor.domain.tasks;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class TaskEntity {
    private final String date;
    private final List<AddTaskParam> tasks;

    public TaskEntity(){
        this.date = "";
        this.tasks = new ArrayList<>(0);
    }

    public TaskEntity(String date, List<AddTaskParam> tasks){
        this.date = date;
        this.tasks = tasks;
    }

    public String getNameDay(){
        return "";
    }

    public String getDay(){
        return "";
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
