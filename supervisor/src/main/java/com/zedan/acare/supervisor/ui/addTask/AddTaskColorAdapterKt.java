package com.zedan.acare.supervisor.ui.addTask;

import androidx.recyclerview.widget.AsyncDifferConfig;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0001\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"DIFFUtil", "com/zedan/acare/supervisor/ui/addTask/AddTaskColorAdapterKt$DIFFUtil$1", "Lcom/zedan/acare/supervisor/ui/addTask/AddTaskColorAdapterKt$DIFFUtil$1;", "asyncDifferConfig", "Landroidx/recyclerview/widget/AsyncDifferConfig;", "", "kotlin.jvm.PlatformType", "supervisor_debug"}, k = 2, mv = {1, 4, 2})
/* compiled from: AddTaskColorAdapter.kt */
public final class AddTaskColorAdapterKt {
    private static final AddTaskColorAdapterKt$DIFFUtil$1 DIFFUtil;
    /* access modifiers changed from: private */
    public static final AsyncDifferConfig<Integer> asyncDifferConfig;

    static {
        AddTaskColorAdapterKt$DIFFUtil$1 addTaskColorAdapterKt$DIFFUtil$1 = new AddTaskColorAdapterKt$DIFFUtil$1();
        DIFFUtil = addTaskColorAdapterKt$DIFFUtil$1;
        AsyncDifferConfig<Integer> build = new AsyncDifferConfig.Builder(addTaskColorAdapterKt$DIFFUtil$1).setBackgroundThreadExecutor(Executors.newSingleThreadExecutor()).build();
        Intrinsics.checkNotNullExpressionValue(build, "AsyncDifferConfig.Builde…dExecutor())\n    .build()");
        asyncDifferConfig = build;
    }
}
