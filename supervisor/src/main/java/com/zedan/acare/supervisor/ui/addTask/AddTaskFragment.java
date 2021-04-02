package com.zedan.acare.supervisor.ui.addTask;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.StorageStrategy;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputLayout;
import com.zedan.acare.supervisor.R;
import com.zedan.acare.supervisor.databinding.AddTaskFragmentBinding;
import com.zedan.acare.supervisor.domain.exceptions.UserNullException;
import com.zedan.acare.supervisor.domain.tasks.AddTaskResult;
import com.zedan.acare.supervisor.extension.NavigationExtensionKt;
import com.zedan.acare.supervisor.extension.ThrowableExtKt;
import com.zedan.acare.supervisor.extension.ViewExtKt;
import com.zedan.acare.supervisor.ui.loading.LoadingDialog;
import com.zedan.acare.supervisor.ui.messageDialogs.MessageArgs;
import com.zedan.acare.supervisor.ui.messageDialogs.MessageDialogsArgs;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0003J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u000eH\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0002J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u000eH\u0002J\b\u0010'\u001a\u00020\u000eH\u0002J\u001a\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006*"}, d2 = {"Lcom/zedan/acare/supervisor/ui/addTask/AddTaskFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapterColor", "Lcom/zedan/acare/supervisor/ui/addTask/AddTaskColorAdapter;", "binding", "Lcom/zedan/acare/supervisor/databinding/AddTaskFragmentBinding;", "viewModel", "Lcom/zedan/acare/supervisor/ui/addTask/AddTaskViewModel;", "getViewModel", "()Lcom/zedan/acare/supervisor/ui/addTask/AddTaskViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addViewListener", "", "errorException", "throwable", "", "errorInputs", "error", "Lcom/zedan/acare/supervisor/domain/tasks/AddTaskResult$Error$InputError;", "getTracker", "Landroidx/recyclerview/selection/SelectionTracker;", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "observeStatusAddTask", "observeTrackerColor", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onError", "Lcom/zedan/acare/supervisor/domain/tasks/AddTaskResult$Error;", "onLoading", "onSuccess", "onViewCreated", "view", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
@AndroidEntryPoint
/* compiled from: AddTaskFragment.kt */
public final class AddTaskFragment extends Hilt_AddTaskFragment {
    /* access modifiers changed from: private */
    public final AddTaskColorAdapter adapterColor = new AddTaskColorAdapter((SelectionTracker) null, 1, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public AddTaskFragmentBinding binding;
    private final Lazy viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AddTaskViewModel.class), new AddTaskFragment$$special$$inlined$viewModels$2(new AddTaskFragment$$special$$inlined$viewModels$1(this)), (Function0<? extends ViewModelProvider.Factory>) null);

    /* access modifiers changed from: private */
    public final AddTaskViewModel getViewModel() {
        return (AddTaskViewModel) this.viewModel$delegate.getValue();
    }

    public AddTaskFragment() {
    }

    public static final /* synthetic */ AddTaskFragmentBinding access$getBinding$p(AddTaskFragment $this) {
        AddTaskFragmentBinding addTaskFragmentBinding = $this.binding;
        if (addTaskFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return addTaskFragmentBinding;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        AddTaskFragmentBinding inflate = AddTaskFragmentBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "AddTaskFragmentBinding.i…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        inflate.setViewModel(getViewModel());
        AddTaskFragmentBinding addTaskFragmentBinding = this.binding;
        if (addTaskFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        addTaskFragmentBinding.setLifecycleOwner(getViewLifecycleOwner());
        AddTaskFragmentBinding addTaskFragmentBinding2 = this.binding;
        if (addTaskFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        addTaskFragmentBinding2.executePendingBindings();
        AddTaskFragmentBinding addTaskFragmentBinding3 = this.binding;
        if (addTaskFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = addTaskFragmentBinding3.groupColor;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.groupColor");
        recyclerView.setAdapter(this.adapterColor);
        AddTaskColorAdapter addTaskColorAdapter = this.adapterColor;
        AddTaskFragmentBinding addTaskFragmentBinding4 = this.binding;
        if (addTaskFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView2 = addTaskFragmentBinding4.groupColor;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.groupColor");
        addTaskColorAdapter.setTracker(getTracker(recyclerView2));
        this.adapterColor.submitList(CollectionsKt.listOf(Integer.valueOf(R.color.orangish), Integer.valueOf(R.color.purpley), Integer.valueOf(R.color.red_pink), Integer.valueOf(R.color.aqua_green), Integer.valueOf(R.color.light_gold), Integer.valueOf(R.color.bruise), Integer.valueOf(R.color.bright_cyan)));
        AddTaskFragmentBinding addTaskFragmentBinding5 = this.binding;
        if (addTaskFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = addTaskFragmentBinding5.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        observeTrackerColor();
        addViewListener();
        observeStatusAddTask();
    }

    private final void addViewListener() {
        AddTaskFragmentBinding addTaskFragmentBinding = this.binding;
        if (addTaskFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AppCompatImageView appCompatImageView = addTaskFragmentBinding.icBack;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "binding.icBack");
        NavigationExtensionKt.back((View) appCompatImageView, (Fragment) this);
        AddTaskFragmentBinding addTaskFragmentBinding2 = this.binding;
        if (addTaskFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        addTaskFragmentBinding2.inputStartTimeDate.setOnClickListener(new AddTaskFragment$addViewListener$1(this));
        AddTaskFragmentBinding addTaskFragmentBinding3 = this.binding;
        if (addTaskFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        addTaskFragmentBinding3.inputStartHourDate.setOnClickListener(new AddTaskFragment$addViewListener$2(this));
        AddTaskFragmentBinding addTaskFragmentBinding4 = this.binding;
        if (addTaskFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        addTaskFragmentBinding4.inputEndTimeDate.setOnClickListener(new AddTaskFragment$addViewListener$3(this));
        AddTaskFragmentBinding addTaskFragmentBinding5 = this.binding;
        if (addTaskFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        addTaskFragmentBinding5.inputEndHourDate.setOnClickListener(new AddTaskFragment$addViewListener$4(this));
    }

    private final SelectionTracker<Long> getTracker(RecyclerView recyclerView) {
        SelectionTracker<Long> build = new SelectionTracker.Builder("selection_task_color", recyclerView, new AddTaskColorSelectedItemKeyProvider(recyclerView), new AddTaskColorSelectedItemDetailsLookup(recyclerView), StorageStrategy.createLongStorage()).withSelectionPredicate(new AddTaskFragment$getTracker$1()).build();
        Intrinsics.checkNotNullExpressionValue(build, "SelectionTracker.Builder…   )\n            .build()");
        return build;
    }

    private final void observeTrackerColor() {
        SelectionTracker<Long> tracker = this.adapterColor.getTracker();
        if (tracker != null) {
            tracker.addObserver(new AddTaskFragment$observeTrackerColor$1(this));
        }
    }

    private final void observeStatusAddTask() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner).launchWhenStarted(new AddTaskFragment$observeStatusAddTask$1(this, (Continuation) null));
    }

    /* access modifiers changed from: private */
    public final void onLoading() {
        new LoadingDialog().show(getChildFragmentManager(), "loading_dialog");
        Unit unit = Unit.INSTANCE;
        FragmentKt.findNavController(this).navigate((int) R.id.loadingDialog);
    }

    /* access modifiers changed from: private */
    public final void onSuccess() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(requireActivity.getApplicationContext());
        Intent $this$apply = new Intent();
        $this$apply.setAction(LoadingDialog.LOCAL_ACTION);
        Unit unit = Unit.INSTANCE;
        instance.sendBroadcast($this$apply);
        NavController findNavController = FragmentKt.findNavController(this);
        String string = getString(R.string.success);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.success)");
        findNavController.navigate((int) R.id.message_nav, new MessageDialogsArgs(new MessageArgs(string, R.drawable.ic_checked)).toBundle(), new NavOptions.Builder().setPopUpTo(R.id.tasksFragment, false).build());
    }

    /* access modifiers changed from: private */
    public final void onError(AddTaskResult.Error error) {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(requireActivity.getApplicationContext());
        Intent $this$apply = new Intent(LoadingDialog.LOCAL_ACTION);
        $this$apply.setAction(LoadingDialog.LOCAL_ACTION);
        Unit unit = Unit.INSTANCE;
        instance.sendBroadcast($this$apply);
        if (error instanceof AddTaskResult.Error.InputError) {
            errorInputs((AddTaskResult.Error.InputError) error);
        } else if (error instanceof AddTaskResult.Error.Exception) {
            errorException(((AddTaskResult.Error.Exception) error).getThrowable());
        }
    }

    private final void errorInputs(AddTaskResult.Error.InputError error) {
        AddTaskFragmentBinding addTaskFragmentBinding = this.binding;
        if (addTaskFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputLayout textInputLayout = addTaskFragmentBinding.layoutTitle;
        Intrinsics.checkNotNullExpressionValue(textInputLayout, "binding.layoutTitle");
        ViewExtKt.shake(textInputLayout, error.isNotTitle());
        AddTaskFragmentBinding addTaskFragmentBinding2 = this.binding;
        if (addTaskFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputLayout textInputLayout2 = addTaskFragmentBinding2.layoutDesc;
        Intrinsics.checkNotNullExpressionValue(textInputLayout2, "binding.layoutDesc");
        ViewExtKt.shake(textInputLayout2, error.isNotDesc());
        AddTaskFragmentBinding addTaskFragmentBinding3 = this.binding;
        if (addTaskFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputLayout textInputLayout3 = addTaskFragmentBinding3.layoutStartTimeDate;
        Intrinsics.checkNotNullExpressionValue(textInputLayout3, "binding.layoutStartTimeDate");
        ViewExtKt.shake(textInputLayout3, error.isNotStartDate());
        AddTaskFragmentBinding addTaskFragmentBinding4 = this.binding;
        if (addTaskFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputLayout textInputLayout4 = addTaskFragmentBinding4.layoutStartHourDate;
        Intrinsics.checkNotNullExpressionValue(textInputLayout4, "binding.layoutStartHourDate");
        ViewExtKt.shake(textInputLayout4, error.isNotStartHour());
        AddTaskFragmentBinding addTaskFragmentBinding5 = this.binding;
        if (addTaskFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputLayout textInputLayout5 = addTaskFragmentBinding5.layoutEndTimeDate;
        Intrinsics.checkNotNullExpressionValue(textInputLayout5, "binding.layoutEndTimeDate");
        ViewExtKt.shake(textInputLayout5, error.isNotEndDate());
        AddTaskFragmentBinding addTaskFragmentBinding6 = this.binding;
        if (addTaskFragmentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputLayout textInputLayout6 = addTaskFragmentBinding6.layoutEndHourDate;
        Intrinsics.checkNotNullExpressionValue(textInputLayout6, "binding.layoutEndHourDate");
        ViewExtKt.shake(textInputLayout6, error.isNotEndHour());
        AddTaskFragmentBinding addTaskFragmentBinding7 = this.binding;
        if (addTaskFragmentBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = addTaskFragmentBinding7.groupColor;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.groupColor");
        ViewExtKt.shake((View) recyclerView, error.isNotColor());
    }

    private final void errorException(Throwable throwable) {
        throwable.printStackTrace();
        if (throwable instanceof UserNullException) {
            FragmentKt.findNavController(this).setGraph((int) R.navigation.supervisor_nav_graph);
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        FragmentKt.findNavController(this).navigate((int) R.id.message_nav, new MessageDialogsArgs(ThrowableExtKt.getCommonMessage(throwable, requireContext)).toBundle());
    }
}
