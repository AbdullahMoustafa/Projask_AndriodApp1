package com.zedan.acare.supervisor.ui.addTask;

import android.view.ViewGroup;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.ListAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/zedan/acare/supervisor/ui/addTask/AddTaskColorAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "", "Lcom/zedan/acare/supervisor/ui/addTask/AddTaskColorViewHolder;", "tracker", "Landroidx/recyclerview/selection/SelectionTracker;", "", "(Landroidx/recyclerview/selection/SelectionTracker;)V", "getTracker", "()Landroidx/recyclerview/selection/SelectionTracker;", "setTracker", "getItemId", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: AddTaskColorAdapter.kt */
public final class AddTaskColorAdapter extends ListAdapter<Integer, AddTaskColorViewHolder> {
    private SelectionTracker<Long> tracker;

    public AddTaskColorAdapter() {
        this((SelectionTracker) null, 1, (DefaultConstructorMarker) null);
    }

    public AddTaskColorAdapter(SelectionTracker<Long> tracker2) {
        super(AddTaskColorAdapterKt.asyncDifferConfig);
        this.tracker = tracker2;
        setHasStableIds(true);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AddTaskColorAdapter(SelectionTracker selectionTracker, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : selectionTracker);
    }

    public final SelectionTracker<Long> getTracker() {
        return this.tracker;
    }

    public final void setTracker(SelectionTracker<Long> selectionTracker) {
        this.tracker = selectionTracker;
    }

    public AddTaskColorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return AddTaskColorViewHolder.Companion.from(parent);
    }

    public void onBindViewHolder(AddTaskColorViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Integer item = (Integer) getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "item");
        int intValue = item.intValue();
        SelectionTracker<Long> selectionTracker = this.tracker;
        holder.bind(intValue, selectionTracker != null ? selectionTracker.isSelected(Long.valueOf((long) item.intValue())) : false);
    }

    public long getItemId(int position) {
        return (long) ((Number) getItem(position)).intValue();
    }
}
