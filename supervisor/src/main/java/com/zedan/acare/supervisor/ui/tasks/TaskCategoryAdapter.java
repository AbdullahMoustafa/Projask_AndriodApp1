package com.zedan.acare.supervisor.ui.tasks;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.zedan.acare.supervisor.databinding.TaskCategoryBinding;
import com.zedan.acare.supervisor.domain.tasks.TaskEntity;

public final class TaskCategoryAdapter extends ListAdapter<TaskEntity, TaskCategoryAdapter.TaskCategoryViewHolder> {

    private final TaskCategoryListener listener;

    public TaskCategoryAdapter(TaskCategoryListener listener){
        super(TaskEntity.DIFFUtil);
        this.listener = listener;
    }

    @NonNull
    @Override
    public TaskCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return TaskCategoryViewHolder.from(parent, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskCategoryViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    static class TaskCategoryViewHolder extends RecyclerView.ViewHolder {

        private final TaskCategoryBinding binding;
        private final TaskCategoryListener listener;

        public TaskCategoryViewHolder(TaskCategoryBinding binding, TaskCategoryListener listener) {
            super(binding.getRoot());
            this.binding = binding;
            this.listener = listener;
        }

        public static TaskCategoryViewHolder from(
                ViewGroup parent,
                TaskCategoryListener listener
        ) {
            return new TaskCategoryViewHolder(
                    TaskCategoryBinding.inflate(LayoutInflater.from(
                            parent.getContext()
                            ),
                            parent,
                            false),
                    listener
            );
        }

        public void bind(TaskEntity item){
            binding.setData(item);
            binding.setListener(listener);
            binding.executePendingBindings();
        }
    }

    public interface TaskCategoryListener {
        public void onClick(TaskEntity taskEntity);
    }
}
