package com.zedan.acare.supervisor.ui.addTask;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;
import com.zedan.acare.supervisor.databinding.AddTaskColorItemRawBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/zedan/acare/supervisor/ui/addTask/AddTaskColorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/zedan/acare/supervisor/databinding/AddTaskColorItemRawBinding;", "(Lcom/zedan/acare/supervisor/databinding/AddTaskColorItemRawBinding;)V", "bind", "", "item", "", "checked", "", "getItemDetails", "Landroidx/recyclerview/selection/ItemDetailsLookup$ItemDetails;", "", "Companion", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: AddTaskColorAdapter.kt */
public final class AddTaskColorViewHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final AddTaskColorItemRawBinding binding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddTaskColorViewHolder(AddTaskColorItemRawBinding binding2) {
        super(binding2.getRoot());
        Intrinsics.checkNotNullParameter(binding2, "binding");
        this.binding = binding2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/zedan/acare/supervisor/ui/addTask/AddTaskColorViewHolder$Companion;", "", "()V", "from", "Lcom/zedan/acare/supervisor/ui/addTask/AddTaskColorViewHolder;", "parent", "Landroid/view/ViewGroup;", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AddTaskColorAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final AddTaskColorViewHolder from(ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            AddTaskColorItemRawBinding inflate = AddTaskColorItemRawBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "AddTaskColorItemRawBindi…  false\n                )");
            return new AddTaskColorViewHolder(inflate);
        }
    }

    public final void bind(int item, boolean checked) {
        this.binding.setColor(Integer.valueOf(item));
        this.binding.setChecked(Boolean.valueOf(checked));
        this.binding.executePendingBindings();
    }

    public final ItemDetailsLookup.ItemDetails<Long> getItemDetails() {
        return new AddTaskColorViewHolder$getItemDetails$1(this);
    }
}
