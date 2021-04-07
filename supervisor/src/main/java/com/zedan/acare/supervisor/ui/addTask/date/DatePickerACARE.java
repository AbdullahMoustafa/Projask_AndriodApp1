package com.zedan.acare.supervisor.ui.addTask.date;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerACARE extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private final DatePickerListener listener;

    public DatePickerACARE(DatePickerListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(
                requireContext(),
                this,
                year,
                month,
                day
        );
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        listener.onDone(new DatePickerData(dayOfMonth + "-" + (month + 1) + "-" + year));
        dismiss();
    }
}
