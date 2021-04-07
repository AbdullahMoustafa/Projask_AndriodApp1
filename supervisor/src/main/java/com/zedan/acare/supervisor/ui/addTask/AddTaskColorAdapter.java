package com.zedan.acare.supervisor.ui.addTask;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.ListAdapter;

import org.jetbrains.annotations.NotNull;

public final class AddTaskColorAdapter extends ListAdapter<Integer, AddTaskColorViewHolder> {

    private SelectionTracker<Long> tracker;

    public AddTaskColorAdapter(){
        super(AddTaskColorDiffUtil.DIFFUtil);
        setHasStableIds(true);
    }

    public AddTaskColorAdapter(SelectionTracker<Long> tracker) {
        super(AddTaskColorDiffUtil.DIFFUtil);
        this.tracker = tracker;
        setHasStableIds(true);
    }

    public final void setTracker(SelectionTracker<Long> selectionTracker) {
        this.tracker = selectionTracker;
    }

    public final SelectionTracker<Long> getTracker() {
        return this.tracker;
    }

    @NonNull
    @Override
    public AddTaskColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return AddTaskColorViewHolder.from(parent);
    }

    public void onBindViewHolder(@NotNull AddTaskColorViewHolder holder, int position) {
        Integer item = getItem(position);
        holder.bind(item, tracker != null && tracker.isSelected(item.longValue()));
    }

    public long getItemId(int position) {
        return getItem(position);
    }
}
