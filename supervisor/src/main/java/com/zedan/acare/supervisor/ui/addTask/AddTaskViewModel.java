package com.zedan.acare.supervisor.ui.addTask;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.zedan.acare.supervisor.domain.tasks.AddTaskResult;
import com.zedan.acare.supervisor.domain.tasks.AddTaskUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J6\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/zedan/acare/supervisor/ui/addTask/AddTaskViewModel;", "Landroidx/lifecycle/ViewModel;", "addTaskUseCase", "Lcom/zedan/acare/supervisor/domain/tasks/AddTaskUseCase;", "(Lcom/zedan/acare/supervisor/domain/tasks/AddTaskUseCase;)V", "_statusAddTask", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/zedan/acare/supervisor/domain/tasks/AddTaskResult;", "selectedColor", "", "getSelectedColor", "()I", "setSelectedColor", "(I)V", "statusAddTask", "Lkotlinx/coroutines/flow/StateFlow;", "getStatusAddTask", "()Lkotlinx/coroutines/flow/StateFlow;", "addNewTask", "", "title", "", "desc", "startDate", "startHour", "endDate", "endHour", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: AddTaskViewModel.kt */
public final class AddTaskViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final MutableStateFlow<AddTaskResult> _statusAddTask = StateFlowKt.MutableStateFlow(AddTaskResult.None.INSTANCE);
    /* access modifiers changed from: private */
    public final AddTaskUseCase addTaskUseCase;
    private int selectedColor = -1;

    @Inject
    public AddTaskViewModel(AddTaskUseCase addTaskUseCase2) {
        Intrinsics.checkNotNullParameter(addTaskUseCase2, "addTaskUseCase");
        this.addTaskUseCase = addTaskUseCase2;
    }

    public final StateFlow<AddTaskResult> getStatusAddTask() {
        return this._statusAddTask;
    }

    public final int getSelectedColor() {
        return this.selectedColor;
    }

    public final void setSelectedColor(int i) {
        this.selectedColor = i;
    }

    public final void addNewTask(String title, String desc, String startDate, String startHour, String endDate, String endHour) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(startHour, "startHour");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        Intrinsics.checkNotNullParameter(endHour, "endHour");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AddTaskViewModel$addNewTask$1(this, title, desc, startDate, startHour, endDate, endHour, (Continuation) null), 3, (Object) null);
    }
}
