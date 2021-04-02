package com.zedan.acare.supervisor.ui.addTask;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateFormat;
import android.widget.TimePicker;
import androidx.fragment.app.DialogFragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0015B(\u0012!\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R)\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/zedan/acare/supervisor/ui/addTask/TimePickerACARE;", "Landroidx/fragment/app/DialogFragment;", "Landroid/app/TimePickerDialog$OnTimeSetListener;", "listener", "Lkotlin/Function1;", "Lcom/zedan/acare/supervisor/ui/addTask/TimePickerACARE$TimeData;", "Lkotlin/ParameterName;", "name", "time", "", "(Lkotlin/jvm/functions/Function1;)V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onTimeSet", "view", "Landroid/widget/TimePicker;", "hourOfDay", "", "minute", "TimeData", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: TimePickerACARE.kt */
public final class TimePickerACARE extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    private final Function1<TimeData, Unit> listener;

    public TimePickerACARE(Function1<? super TimeData, Unit> listener2) {
        Intrinsics.checkNotNullParameter(listener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = listener2;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        int hour = c.get(11);
        return new TimePickerDialog(getActivity(), this, hour, c.get(12), DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        this.listener.invoke(new TimeData(hourOfDay, minute));
        dismiss();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/zedan/acare/supervisor/ui/addTask/TimePickerACARE$TimeData;", "Landroid/os/Parcelable;", "hourOfDay", "", "minute", "(II)V", "getHourOfDay", "()I", "getMinute", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TimePickerACARE.kt */
    public static final class TimeData implements Parcelable {
        public static final Parcelable.Creator<TimeData> CREATOR = new Creator();
        private final int hourOfDay;
        private final int minute;

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<TimeData> {
            public final TimeData createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new TimeData(parcel.readInt(), parcel.readInt());
            }

            public final TimeData[] newArray(int i) {
                return new TimeData[i];
            }
        }

        public static /* synthetic */ TimeData copy$default(TimeData timeData, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = timeData.hourOfDay;
            }
            if ((i3 & 2) != 0) {
                i2 = timeData.minute;
            }
            return timeData.copy(i, i2);
        }

        public final int component1() {
            return this.hourOfDay;
        }

        public final int component2() {
            return this.minute;
        }

        public final TimeData copy(int i, int i2) {
            return new TimeData(i, i2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TimeData)) {
                return false;
            }
            TimeData timeData = (TimeData) obj;
            return this.hourOfDay == timeData.hourOfDay && this.minute == timeData.minute;
        }

        public int hashCode() {
            return (Integer.hashCode(this.hourOfDay) * 31) + Integer.hashCode(this.minute);
        }

        public String toString() {
            return "TimeData(hourOfDay=" + this.hourOfDay + ", minute=" + this.minute + ")";
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.hourOfDay);
            parcel.writeInt(this.minute);
        }

        public TimeData(int hourOfDay2, int minute2) {
            this.hourOfDay = hourOfDay2;
            this.minute = minute2;
        }

        public final int getHourOfDay() {
            return this.hourOfDay;
        }

        public final int getMinute() {
            return this.minute;
        }
    }
}
