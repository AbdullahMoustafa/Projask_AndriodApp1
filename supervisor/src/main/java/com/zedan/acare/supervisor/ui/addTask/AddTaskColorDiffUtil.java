package com.zedan.acare.supervisor.ui.addTask;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

class AddTaskColorDiffUtil extends DiffUtil.ItemCallback<Integer>{

    public static AddTaskColorDiffUtil DIFFUtil = new AddTaskColorDiffUtil();

    public AddTaskColorDiffUtil(){
        super();
    }

    @Override
    public boolean areItemsTheSame(@NonNull Integer oldItem, @NonNull Integer newItem) {
        return oldItem.equals(newItem);
    }

    @Override
    public boolean areContentsTheSame(@NonNull Integer oldItem, @NonNull Integer newItem) {
        return oldItem.equals(newItem);
    }
}
