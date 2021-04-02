package com.zedan.acare.supervisor.ui.tasks;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.zedan.acare.supervisor.domain.None;
import com.zedan.acare.supervisor.domain.profile.UserDataBasic;
import com.zedan.acare.supervisor.domain.profile.UserInfoBasicUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/zedan/acare/supervisor/ui/tasks/TasksViewModel;", "Landroidx/lifecycle/ViewModel;", "basicUserInfo", "Lcom/zedan/acare/supervisor/domain/profile/UserInfoBasicUseCase;", "(Lcom/zedan/acare/supervisor/domain/profile/UserInfoBasicUseCase;)V", "_userInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/zedan/acare/supervisor/domain/profile/UserDataBasic;", "userInfo", "Landroidx/lifecycle/LiveData;", "getUserInfo", "()Landroidx/lifecycle/LiveData;", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: TasksViewModel.kt */
public final class TasksViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<UserDataBasic> _userInfo;
    /* access modifiers changed from: private */
    public final UserInfoBasicUseCase basicUserInfo;
    private final LiveData<UserDataBasic> userInfo;

    @Inject
    public TasksViewModel(UserInfoBasicUseCase basicUserInfo2) {
        Intrinsics.checkNotNullParameter(basicUserInfo2, "basicUserInfo");
        this.basicUserInfo = basicUserInfo2;
        MutableLiveData<UserDataBasic> mutableLiveData = new MutableLiveData<>();
        this._userInfo = mutableLiveData;
        this.userInfo = mutableLiveData;
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation) null), 3, (Object) null);
    }

    public final LiveData<UserDataBasic> getUserInfo() {
        return this.userInfo;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
    @DebugMetadata(c = "com.zedan.acare.supervisor.ui.tasks.TasksViewModel$1", f = "TasksViewModel.kt", i = {}, l = {26, 34}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.zedan.acare.supervisor.ui.tasks.TasksViewModel$1  reason: invalid class name */
    /* compiled from: TasksViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ TasksViewModel this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            AnonymousClass1 r3;
            Object $result2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object execute = this.this$0.basicUserInfo.execute(new None(), this);
                if (execute == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result2 = $result;
                $result = execute;
                r3 = this;
            } else if (i == 1) {
                ResultKt.throwOnFailure($result);
                r3 = this;
                $result2 = $result;
            } else if (i == 2) {
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r3.label = 2;
            if (((Flow) $result).collect(new TasksViewModel$1$invokeSuspend$$inlined$collect$1(r3), r3) == coroutine_suspended) {
                return coroutine_suspended;
            }
            Object obj = $result2;
            AnonymousClass1 r0 = r3;
            return Unit.INSTANCE;
        }
    }
}
