package com.zedan.acare.supervisor.ui.tasks;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.zedan.acare.supervisor.databinding.TaskItemRawBinding;
import com.zedan.acare.supervisor.domain.tasks.AddTaskParam;

public final class TaskItemAdapter extends ListAdapter<AddTaskParam, TaskItemAdapter.TaskItemViewHolder> {

    public TaskItemAdapter(){
        super(AddTaskParam.DIFFUtil);
    }

    @NonNull
    @Override
    public TaskItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return TaskItemViewHolder.from(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskItemViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    static final class TaskItemViewHolder extends RecyclerView.ViewHolder{

        private final TaskItemRawBinding binding;

        public TaskItemViewHolder(TaskItemRawBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }

        public static TaskItemViewHolder from(ViewGroup parent){
            return new TaskItemViewHolder(
                    TaskItemRawBinding.inflate(
                            LayoutInflater.from(parent.getContext()),
                            parent,
                            false
                    )
            );
        }

        public void bind(AddTaskParam item){
            binding.setData(item);
            binding.executePendingBindings();
        }
    }
}
