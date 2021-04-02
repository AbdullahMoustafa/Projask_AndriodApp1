package com.zedan.acare.common.autoComplete;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zedan.acare.common.R;
import com.zedan.acare.common.entities.SelectEntity;

import java.util.List;

public final class AutoCompleteAdapter extends ArrayAdapter<SelectEntity> {
    private final List<SelectEntity> data;


    public AutoCompleteAdapter(@NonNull Context context, @NonNull List<SelectEntity> data2) {
        super(context, R.layout.auto_complete_item, data2);
        this.data = data2;
    }

    @Nullable
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String str;
        View view = convertView;
        try {
            if (convertView == null) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.auto_complete_item, parent, false);
            }
            SelectEntity item = getItem(position);
            TextView text = view.findViewById(R.id.auto_complete_item);
            if (item == null) {
                str = getContext().getString(R.string.unknown);
            } else {
                str = item.getName();
            }
            text.setText(str);
        } catch (Exception e){
            e.printStackTrace();
        }
        return view;
    }

    @Nullable
    public SelectEntity getItem(int position) {
        return this.data.get(position);
    }

    public int getCount() {
        return this.data.size();
    }

    public long getItemId(int position) {
        return this.data.get(position).getId();
    }
}
