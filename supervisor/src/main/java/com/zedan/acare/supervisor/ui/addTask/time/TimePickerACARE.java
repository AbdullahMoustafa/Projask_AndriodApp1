package com.zedan.acare.supervisor.ui.addTask.time;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

import static android.text.format.DateFormat.is24HourFormat;

public class TimePickerACARE extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    private final TimeListener listener;

    public TimePickerACARE(TimeListener listener){
        this.listener = listener;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        return new TimePickerDialog(
                requireContext(),
                this,
                hour,
                minute,
                is24HourFormat(getActivity())
        );
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        listener.onDone(new TimeData(hourOfDay, minute));
        dismiss();
    }
}
