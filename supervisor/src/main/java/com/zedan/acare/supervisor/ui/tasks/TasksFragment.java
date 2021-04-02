package com.zedan.acare.supervisor.ui.tasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import com.zedan.acare.common.utils.StatusBar;
import com.zedan.acare.supervisor.databinding.TasksFragmentBinding;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/zedan/acare/supervisor/ui/tasks/TasksFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/zedan/acare/supervisor/databinding/TasksFragmentBinding;", "viewModel", "Lcom/zedan/acare/supervisor/ui/tasks/TasksViewModel;", "getViewModel", "()Lcom/zedan/acare/supervisor/ui/tasks/TasksViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setViewsListener", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
@AndroidEntryPoint
/* compiled from: TasksFragment.kt */
public final class TasksFragment extends Hilt_TasksFragment {
    private TasksFragmentBinding binding;
    private final Lazy viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(TasksViewModel.class), new TasksFragment$$special$$inlined$viewModels$2(new TasksFragment$$special$$inlined$viewModels$1(this)), (Function0<? extends ViewModelProvider.Factory>) null);

    private final TasksViewModel getViewModel() {
        return (TasksViewModel) this.viewModel$delegate.getValue();
    }

    public TasksFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        TasksFragmentBinding inflate = TasksFragmentBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "TasksFragmentBinding.inflate(inflater)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        inflate.setViewModel(getViewModel());
        TasksFragmentBinding tasksFragmentBinding = this.binding;
        if (tasksFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        tasksFragmentBinding.setLifecycleOwner(getViewLifecycleOwner());
        TasksFragmentBinding tasksFragmentBinding2 = this.binding;
        if (tasksFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        tasksFragmentBinding2.executePendingBindings();
        TasksFragmentBinding tasksFragmentBinding3 = this.binding;
        if (tasksFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = tasksFragmentBinding3.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        StatusBar.setStatusAsWhite(this);
        setViewsListener();
    }

    private final void setViewsListener() {
        TasksFragmentBinding tasksFragmentBinding = this.binding;
        if (tasksFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        tasksFragmentBinding.addTaskBtn.setOnClickListener(new TasksFragment$setViewsListener$1(this));
        TasksFragmentBinding tasksFragmentBinding2 = this.binding;
        if (tasksFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        tasksFragmentBinding2.icUser.setOnClickListener(new TasksFragment$setViewsListener$2(this));
    }
}
