package com.zedan.acare.supervisor.ui.addTask;

import android.view.View;
import com.zedan.acare.supervisor.ui.addTask.TimePickerACARE;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: AddTaskFragment.kt */
final class AddTaskFragment$addViewListener$4 implements View.OnClickListener {
    final /* synthetic */ AddTaskFragment this$0;

    AddTaskFragment$addViewListener$4(AddTaskFragment addTaskFragment) {
        this.this$0 = addTaskFragment;
    }

    public final void onClick(View it) {
        TimePickerACAREKt.showTime(this.this$0, new Function1<TimePickerACARE.TimeData, Unit>(this) {
            final /* synthetic */ AddTaskFragment$addViewListener$4 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((TimePickerACARE.TimeData) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(TimePickerACARE.TimeData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                AddTaskFragment.access$getBinding$p(this.this$0.this$0).inputEndHourDate.setText(new StringBuilder().append(it.getHourOfDay()).append(':').append(it.getMinute()).toString());
            }
        });
    }
}