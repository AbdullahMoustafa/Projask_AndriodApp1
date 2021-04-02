package com.zedan.acare.supervisor.ui.addTask;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"com/zedan/acare/supervisor/ui/addTask/AddTaskColorAdapterKt$DIFFUtil$1", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: AddTaskColorAdapter.kt */
public final class AddTaskColorAdapterKt$DIFFUtil$1 extends DiffUtil.ItemCallback<Integer> {
    AddTaskColorAdapterKt$DIFFUtil$1() {
    }

    public /* bridge */ /* synthetic */ boolean areContentsTheSame(Object obj, Object obj2) {
        return areContentsTheSame(((Number) obj).intValue(), ((Number) obj2).intValue());
    }

    public /* bridge */ /* synthetic */ boolean areItemsTheSame(Object obj, Object obj2) {
        return areItemsTheSame(((Number) obj).intValue(), ((Number) obj2).intValue());
    }

    public boolean areContentsTheSame(int oldItem, int newItem) {
        return oldItem == newItem;
    }

    public boolean areItemsTheSame(int oldItem, int newItem) {
        return oldItem == newItem;
    }
}
