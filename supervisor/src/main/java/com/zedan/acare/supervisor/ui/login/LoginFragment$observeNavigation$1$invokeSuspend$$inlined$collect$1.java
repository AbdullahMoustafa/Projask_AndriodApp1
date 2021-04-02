package com.zedan.acare.supervisor.ui.login;

import androidx.navigation.NavDirections;
import androidx.navigation.NavOptions;
import com.zedan.acare.supervisor.extension.NavigationExtensionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
/* compiled from: Collect.kt */
public final class LoginFragment$observeNavigation$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<NavDirections> {
    final /* synthetic */ LoginFragment$observeNavigation$1 this$0;

    public LoginFragment$observeNavigation$1$invokeSuspend$$inlined$collect$1(LoginFragment$observeNavigation$1 loginFragment$observeNavigation$1) {
        this.this$0 = loginFragment$observeNavigation$1;
    }

    public Object emit(Object value, Continuation $completion) {
        Continuation continuation = $completion;
        NavigationExtensionKt.navigate$default(this.this$0.this$0, (NavDirections) value, (NavOptions) null, 2, (Object) null);
        return Unit.INSTANCE;
    }
}
