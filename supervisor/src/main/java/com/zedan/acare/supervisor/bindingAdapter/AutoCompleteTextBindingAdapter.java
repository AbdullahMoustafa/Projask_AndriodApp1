package com.zedan.acare.supervisor.bindingAdapter;

import androidx.annotation.Nullable;

import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.zedan.acare.common.autoComplete.AutoCompleteAdapter;
import com.zedan.acare.common.autoComplete.AutoCompleteListener;
import com.zedan.acare.common.entities.SelectEntity;

public final class AutoCompleteTextBindingAdapter {

    public static void addOnSelectedListener(
            MaterialAutoCompleteTextView view,
            AutoCompleteListener listener
    ){
        view.setOnItemClickListener((adapterView, view1, position, id) -> {
            SelectEntity item = (SelectEntity) adapterView.getItemAtPosition(position);
            listener.onSelected(item);
            view.setText(item.getName());
        });

    }

    public static void setAdapter(
            MaterialAutoCompleteTextView view,
            @Nullable AutoCompleteAdapter adapter
    ){
        if (adapter == null)
            return;

        view.setAdapter(adapter);
        view.setThreshold(1);
    }
}
