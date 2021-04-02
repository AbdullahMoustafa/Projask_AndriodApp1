package com.zedan.acare.supervisor.ui.addTask;

import androidx.recyclerview.selection.ItemKeyProvider;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/zedan/acare/supervisor/ui/addTask/AddTaskColorSelectedItemKeyProvider;", "Landroidx/recyclerview/selection/ItemKeyProvider;", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/RecyclerView;)V", "getKey", "position", "", "(I)Ljava/lang/Long;", "getPosition", "key", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: AddTaskColorAdapter.kt */
public final class AddTaskColorSelectedItemKeyProvider extends ItemKeyProvider<Long> {
    private final RecyclerView recyclerView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddTaskColorSelectedItemKeyProvider(RecyclerView recyclerView2) {
        super(0);
        Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
        this.recyclerView = recyclerView2;
    }

    public /* bridge */ /* synthetic */ int getPosition(Object obj) {
        return getPosition(((Number) obj).longValue());
    }

    public Long getKey(int position) {
        RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
        if (adapter != null) {
            return Long.valueOf(adapter.getItemId(position));
        }
        return null;
    }

    public int getPosition(long key) {
        RecyclerView.ViewHolder viewHolder = this.recyclerView.findViewHolderForItemId(key);
        if (viewHolder != null) {
            return viewHolder.getLayoutPosition();
        }
        return -1;
    }
}
