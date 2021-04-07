package com.zedan.acare.supervisor.ui.tasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.zedan.acare.common.utils.StatusBar;
import com.zedan.acare.supervisor.databinding.TasksFragmentBinding;
import com.zedan.acare.supervisor.domain.tasks.TaskEntity;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;
import timber.log.Timber;

@AndroidEntryPoint
public final class TasksFragment extends Fragment implements TaskCategoryAdapter.TaskCategoryListener {

    private TasksFragmentBinding binding;

    private TasksViewModel viewModel;

    private final TaskItemAdapter itemAdapter = new TaskItemAdapter();

    private final TaskCategoryAdapter categoryAdapter = new TaskCategoryAdapter(this);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this)
                .get(TasksViewModel.class);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = TasksFragmentBinding.inflate(inflater);

        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.executePendingBindings();

        binding.recyclerCategory.setAdapter(categoryAdapter);
        binding.recyclerTasks.setAdapter(itemAdapter);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        StatusBar.setStatusAsWhite(this);

        setViewsListener();

        viewModel.taskData().observe(getViewLifecycleOwner(), this::tasksObserve);
    }

    private void setViewsListener() {
        binding.addTaskBtn.setOnClickListener(v -> Navigation.findNavController(binding.getRoot())
                .navigate(TasksFragmentDirections.actionTasksFragmentToAddTaskFragment()));

        binding.icUser.setOnClickListener(v -> Navigation.findNavController(binding.getRoot())
                .navigate(TasksFragmentDirections.actionTasksFragmentToProfileFragment()));
    }

    private void tasksObserve(List<TaskEntity> tasks){
        if (tasks == null)
            return;


        categoryAdapter.submitList(tasks);
        if (tasks.size() >= 1 && tasks.get(0) != null)
            onClick(tasks.get(0));
    }

    @Override
    public void onClick(TaskEntity taskEntity) {
        itemAdapter.submitList(taskEntity.getTasks());
    }
}
