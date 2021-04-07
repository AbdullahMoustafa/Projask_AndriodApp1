package com.zedan.acare.supervisor.ui.addTask.time;

public class TimeData {
    private final int hourOfDay;
    private final int minute;

    public TimeData(int hourOfDay, int minute) {
        this.hourOfDay = hourOfDay;
        this.minute = minute;
    }

    public int getHourOfDay() {
        return hourOfDay;
    }

    public int getMinute() {
        return minute;
    }
}
