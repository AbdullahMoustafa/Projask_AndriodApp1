package com.zedan.acare.supervisor.ui.addTask;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.StorageStrategy;
import androidx.recyclerview.widget.RecyclerView;

import com.zedan.acare.supervisor.R;
import com.zedan.acare.supervisor.databinding.AddTaskFragmentBinding;
import com.zedan.acare.supervisor.domain.exceptions.UserNullException;
import com.zedan.acare.supervisor.domain.tasks.AddTaskResult;
import com.zedan.acare.supervisor.extension.ViewExtension;
import com.zedan.acare.supervisor.ui.addTask.date.DatePickerShow;
import com.zedan.acare.supervisor.ui.addTask.time.TimePickerShow;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;
import timber.log.Timber;

@AndroidEntryPoint
public final class AddTaskFragment extends Fragment {

    private final AddTaskColorAdapter adapterColor = new AddTaskColorAdapter();

    private AddTaskFragmentBinding binding;

    private AddTaskViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this)
                .get(AddTaskViewModel.class);
    }

    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = AddTaskFragmentBinding.inflate(inflater, container, false);

        this.binding.setViewModel(viewModel);
        this.binding.setLifecycleOwner(getViewLifecycleOwner());
        this.binding.executePendingBindings();


        this.binding.groupColor.setAdapter(adapterColor);

        adapterColor.setTracker(getTracker(binding.groupColor));

        this.adapterColor.submitList(
                Arrays.asList(R.color.orangish, R.color.purpley, R.color.red_pink,
                        R.color.aqua_green, R.color.light_gold,
                        R.color.bruise, R.color.bright_cyan
                )
        );

        return binding.getRoot();
    }

    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        observeTrackerColor();

        addViewListener();

        observeStatusAddTask();
    }

    @SuppressLint("SetTextI18n")
    private void addViewListener() {
        binding.icBack.setOnClickListener(v -> {
            Navigation.findNavController(binding.getRoot())
                    .popBackStack();
        });


        binding.inputStartTimeDate.setOnClickListener(v ->
                DatePickerShow
                        .showDatePicker(
                                this,
                                datePickerData ->
                                        binding.inputStartTimeDate
                                                .setText(datePickerData.getDate())
                        )
        );

        binding.inputStartHourDate.setOnClickListener(v ->
                TimePickerShow
                        .showTimePicker(
                                this,
                                time ->
                                        binding.inputStartHourDate
                                                .setText(time.getHourOfDay() + ":" + time.getMinute())
                        )
        );

        binding.inputEndTimeDate.setOnClickListener(v ->
                DatePickerShow
                        .showDatePicker(
                                this,
                                datePickerData ->
                                        binding.inputEndTimeDate
                                                .setText(datePickerData.getDate())
                        )
        );

        binding.inputEndHourDate.setOnClickListener(v ->
                TimePickerShow
                        .showTimePicker(
                                this,
                                time ->
                                        binding.inputEndHourDate
                                                .setText(time.getHourOfDay() + ":" + time.getMinute())
                        )
        );
    }

    private SelectionTracker<Long> getTracker(RecyclerView recyclerView) {
        return new SelectionTracker.Builder<>(
                "selection_task_color",
                recyclerView,
                new AddTaskColorSelectedItemKeyProvider(recyclerView),
                new AddTaskColorSelectedItemDetailsLookup(recyclerView),
                StorageStrategy.createLongStorage()
        )
                .withSelectionPredicate(new SelectionTracker.SelectionPredicate<Long>() {
                    @Override
                    public boolean canSetStateForKey(@NonNull Long key, boolean nextState) {
                        return true;
                    }

                    @Override
                    public boolean canSetStateAtPosition(int position, boolean nextState) {
                        return true;
                    }

                    @Override
                    public boolean canSelectMultiple() {
                        return false;
                    }
                })
                .build();
    }

    private void observeTrackerColor() {
        if (this.adapterColor.getTracker() != null) {
            this.adapterColor.getTracker()
                    .addObserver(new SelectionTracker.SelectionObserver<Long>() {
                        @Override
                        public void onSelectionChanged() {
                            super.onSelectionChanged();
                            List<Long> selected = new ArrayList<>();
                            adapterColor.getTracker().getSelection().iterator().forEachRemaining(selected::add);
                            viewModel.setSelectedColor(
                                    selected.size() >= 1 && selected.get(0) != null ?
                                            ContextCompat.getColor(requireContext(), selected.get(0).intValue()) :
                                            -1
                            );
                        }
                    });
        }
    }

    private void observeStatusAddTask() {
        viewModel.getStatusAddTask().observe(getViewLifecycleOwner(), this::observeStatusAdd);
    }

    private void observeStatusAdd(AddTaskResult result) {
        if (result instanceof AddTaskResult.Loading) {
            onLoading();
        } else if (result instanceof AddTaskResult.Success) {
            onSuccess();
        } else if (result instanceof AddTaskResult.Error) {
            onError((AddTaskResult.Error) result);
        }
    }

    private void onLoading() {
        // TODO: Change To Loading.
        //new LoadingDialog().show(getChildFragmentManager(), "loading_dialog");

    }

    private void onSuccess() {
        // TODO: Hide Loading Dialog ad show message success nd back

    }

    private void onError(AddTaskResult.Error error) {
        // TODO: Hide Loading Dialog.
        if (error instanceof AddTaskResult.Error.InputError) {
            errorInputs((AddTaskResult.Error.InputError) error);
        } else if (error instanceof AddTaskResult.Error.Exception) {
            errorException(((AddTaskResult.Error.Exception) error).getThrowable());
        }
    }

    private void errorInputs(AddTaskResult.Error.InputError error) {
        ViewExtension.shake(binding.layoutTitle, error.isNotTitle());
        ViewExtension.shake(binding.layoutDesc, error.isNotDesc());
        ViewExtension.shake(binding.layoutStartTimeDate, error.isNotStartDate());
        ViewExtension.shake(binding.layoutStartHourDate, error.isNotStartHour());
        ViewExtension.shake(binding.layoutEndTimeDate, error.isNotEndDate());
        ViewExtension.shake(binding.layoutEndHourDate, error.isNotEndHour());
        ViewExtension.shake(binding.groupColor, error.isNotColor());
    }

    private void errorException(Throwable throwable) {
        throwable.printStackTrace();
        if (throwable instanceof UserNullException) {
            Navigation.findNavController(binding.getRoot())
                    .setGraph(R.navigation.supervisor_nav_graph);
        }
        // TODO: Show Error Message
    }
}
