package com.zedan.acare.supervisor.ui.addTask;

import androidx.recyclerview.selection.SelectionTracker;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"com/zedan/acare/supervisor/ui/addTask/AddTaskFragment$observeTrackerColor$1", "Landroidx/recyclerview/selection/SelectionTracker$SelectionObserver;", "", "onSelectionChanged", "", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: AddTaskFragment.kt */
public final class AddTaskFragment$observeTrackerColor$1 extends SelectionTracker.SelectionObserver<Long> {
    final /* synthetic */ AddTaskFragment this$0;

    AddTaskFragment$observeTrackerColor$1(AddTaskFragment this$02) {
        this.this$0 = this$02;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001d, code lost:
        r1 = kotlin.collections.CollectionsKt.toList((r1 = r1.getSelection()));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSelectionChanged() {
        /*
            r5 = this;
            super.onSelectionChanged()
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "Changed ."
            timber.log.Timber.e(r2, r1)
            com.zedan.acare.supervisor.ui.addTask.AddTaskFragment r1 = r5.this$0
            com.zedan.acare.supervisor.ui.addTask.AddTaskColorAdapter r1 = r1.adapterColor
            androidx.recyclerview.selection.SelectionTracker r1 = r1.getTracker()
            if (r1 == 0) goto L_0x002c
            androidx.recyclerview.selection.Selection r1 = r1.getSelection()
            if (r1 == 0) goto L_0x002c
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.List r1 = kotlin.collections.CollectionsKt.toList(r1)
            if (r1 == 0) goto L_0x002c
            java.lang.Object r0 = kotlin.collections.CollectionsKt.getOrNull(r1, r0)
            java.lang.Long r0 = (java.lang.Long) r0
            goto L_0x002d
        L_0x002c:
            r0 = 0
        L_0x002d:
            com.zedan.acare.supervisor.ui.addTask.AddTaskFragment r1 = r5.this$0
            com.zedan.acare.supervisor.ui.addTask.AddTaskViewModel r1 = r1.getViewModel()
            if (r0 == 0) goto L_0x0046
            com.zedan.acare.supervisor.ui.addTask.AddTaskFragment r2 = r5.this$0
            android.content.Context r2 = r2.requireContext()
            long r3 = r0.longValue()
            int r3 = (int) r3
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)
            goto L_0x0047
        L_0x0046:
            r2 = -1
        L_0x0047:
            r1.setSelectedColor(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zedan.acare.supervisor.ui.addTask.AddTaskFragment$observeTrackerColor$1.onSelectionChanged():void");
    }
}
