package com.zedan.acare.supervisor.ui.addTask;

import androidx.recyclerview.selection.SelectionTracker;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016¨\u0006\u000b"}, d2 = {"com/zedan/acare/supervisor/ui/addTask/AddTaskFragment$getTracker$1", "Landroidx/recyclerview/selection/SelectionTracker$SelectionPredicate;", "", "canSelectMultiple", "", "canSetStateAtPosition", "position", "", "nextState", "canSetStateForKey", "key", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: AddTaskFragment.kt */
public final class AddTaskFragment$getTracker$1 extends SelectionTracker.SelectionPredicate<Long> {
    AddTaskFragment$getTracker$1() {
    }

    public /* bridge */ /* synthetic */ boolean canSetStateForKey(Object obj, boolean z) {
        return canSetStateForKey(((Number) obj).longValue(), z);
    }

    public boolean canSetStateForKey(long key, boolean nextState) {
        return true;
    }

    public boolean canSetStateAtPosition(int position, boolean nextState) {
        return true;
    }

    public boolean canSelectMultiple() {
        return false;
    }
}
