package com.zedan.acare.supervisor.ui.addTask;

import android.view.MotionEvent;
import androidx.recyclerview.selection.ItemDetailsLookup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\r\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/zedan/acare/supervisor/ui/addTask/AddTaskColorViewHolder$getItemDetails$1", "Landroidx/recyclerview/selection/ItemDetailsLookup$ItemDetails;", "", "getPosition", "", "getSelectionKey", "()Ljava/lang/Long;", "inSelectionHotspot", "", "e", "Landroid/view/MotionEvent;", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: AddTaskColorAdapter.kt */
public final class AddTaskColorViewHolder$getItemDetails$1 extends ItemDetailsLookup.ItemDetails<Long> {
    final /* synthetic */ AddTaskColorViewHolder this$0;

    AddTaskColorViewHolder$getItemDetails$1(AddTaskColorViewHolder this$02) {
        this.this$0 = this$02;
    }

    public int getPosition() {
        return this.this$0.getAdapterPosition();
    }

    public Long getSelectionKey() {
        return Long.valueOf(this.this$0.getItemId());
    }

    public boolean inSelectionHotspot(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        return true;
    }
}
