package com.zedan.acare.supervisor.ui.addTask;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;

import com.zedan.acare.supervisor.databinding.AddTaskColorItemRawBinding;


public final class AddTaskColorViewHolder extends RecyclerView.ViewHolder {

    private final AddTaskColorItemRawBinding binding;

    public AddTaskColorViewHolder(AddTaskColorItemRawBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public static AddTaskColorViewHolder from(ViewGroup parent){
        return new AddTaskColorViewHolder(
                AddTaskColorItemRawBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }

    public final void bind(Integer item, boolean checked) {
        this.binding.setColor(item);
        this.binding.setChecked(checked);
        this.binding.executePendingBindings();
    }

    public final ItemDetailsLookup.ItemDetails<Long> getItemDetails() {
        return new ItemDetailsLookup.ItemDetails<Long>() {
            @Override
            public int getPosition() {
                return getAdapterPosition();
            }

            @Override
            public @NonNull Long getSelectionKey() {
                return getItemId();
            }

            @Override
            public boolean inSelectionHotspot(@NonNull MotionEvent e) {
                return true;
            }
        };
    }
}
