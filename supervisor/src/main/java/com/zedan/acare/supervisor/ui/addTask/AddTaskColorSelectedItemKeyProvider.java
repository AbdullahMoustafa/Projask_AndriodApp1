package com.zedan.acare.supervisor.ui.addTask;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemKeyProvider;
import androidx.recyclerview.widget.RecyclerView;

public final class AddTaskColorSelectedItemKeyProvider extends ItemKeyProvider<Long> {
    private final RecyclerView recyclerView;

    public AddTaskColorSelectedItemKeyProvider(RecyclerView recyclerView) {
        super(SCOPE_MAPPED);
        this.recyclerView = recyclerView;
    }

    @Nullable
    @Override
    public Long getKey(int position) {
        if (recyclerView.getAdapter() != null)
            return recyclerView.getAdapter().getItemId(position);
        return null;
    }

    @Override
    public int getPosition(@NonNull Long key) {
        RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForItemId(key);
        if (viewHolder != null)
            return viewHolder.getLayoutPosition();
        return RecyclerView.NO_POSITION;
    }
}
