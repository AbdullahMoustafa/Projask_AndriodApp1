package com.zedan.acare.supervisor.ui.addTask.time;

import androidx.fragment.app.Fragment;

public final class TimePickerShow {

    public static void showTimePicker(
            Fragment fragment,
            TimeListener listener
    ){
        new TimePickerACARE(listener)
        .show(fragment.getChildFragmentManager(), "select_time");
    }
}
