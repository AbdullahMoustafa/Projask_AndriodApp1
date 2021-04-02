package com.zedan.acare.supervisor.ui.addTask;

import androidx.fragment.app.Fragment;
import com.zedan.acare.supervisor.ui.addTask.DatePickerACARE;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00022!\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00010\u0004¨\u0006\t"}, d2 = {"showDate", "", "Landroidx/fragment/app/Fragment;", "onDone", "Lkotlin/Function1;", "Lcom/zedan/acare/supervisor/ui/addTask/DatePickerACARE$DateData;", "Lkotlin/ParameterName;", "name", "data", "supervisor_debug"}, k = 2, mv = {1, 4, 2})
/* compiled from: DatePickerACARE.kt */
public final class DatePickerACAREKt {
    public static final void showDate(Fragment $this$showDate, Function1<? super DatePickerACARE.DateData, Unit> onDone) {
        Intrinsics.checkNotNullParameter($this$showDate, "$this$showDate");
        Intrinsics.checkNotNullParameter(onDone, "onDone");
        new DatePickerACARE(onDone).show($this$showDate.getChildFragmentManager(), "select_date");
    }
}
