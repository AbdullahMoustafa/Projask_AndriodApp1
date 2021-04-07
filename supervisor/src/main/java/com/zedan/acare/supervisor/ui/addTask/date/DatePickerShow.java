package com.zedan.acare.supervisor.ui.addTask.date;

import androidx.fragment.app.Fragment;

public final class DatePickerShow {
    public static void showDatePicker(
            Fragment fragment,
            DatePickerListener listener
    ){
        new DatePickerACARE(listener)
                .show(fragment.getChildFragmentManager(), "select_date");
    }
}
