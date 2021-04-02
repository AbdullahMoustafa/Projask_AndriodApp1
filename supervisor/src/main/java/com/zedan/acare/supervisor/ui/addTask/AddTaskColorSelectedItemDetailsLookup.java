package com.zedan.acare.supervisor.ui.addTask;

import android.view.MotionEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/zedan/acare/supervisor/ui/addTask/AddTaskColorSelectedItemDetailsLookup;", "Landroidx/recyclerview/selection/ItemDetailsLookup;", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/RecyclerView;)V", "getItemDetails", "Landroidx/recyclerview/selection/ItemDetailsLookup$ItemDetails;", "event", "Landroid/view/MotionEvent;", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: AddTaskColorAdapter.kt */
public final class AddTaskColorSelectedItemDetailsLookup extends ItemDetailsLookup<Long> {
    private final RecyclerView recyclerView;

    public AddTaskColorSelectedItemDetailsLookup(RecyclerView recyclerView2) {
        Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
        this.recyclerView = recyclerView2;
    }

    public ItemDetailsLookup.ItemDetails<Long> getItemDetails(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        View view = this.recyclerView.findChildViewUnder(event.getX(), event.getY());
        RecyclerView recyclerView2 = this.recyclerView;
        if (view == null) {
            return null;
        }
        RecyclerView.ViewHolder childViewHolder = recyclerView2.getChildViewHolder(view);
        if (childViewHolder != null) {
            return ((AddTaskColorViewHolder) childViewHolder).getItemDetails();
        }
        throw new NullPointerException("null cannot be cast to non-null type com.zedan.acare.supervisor.ui.addTask.AddTaskColorViewHolder");
    }
}
