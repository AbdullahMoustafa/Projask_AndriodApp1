package com.zedan.acare.supervisor.ui.addTask;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.fragment.app.DialogFragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0016B(\u0012!\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J*\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016R)\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/zedan/acare/supervisor/ui/addTask/DatePickerACARE;", "Landroidx/fragment/app/DialogFragment;", "Landroid/app/DatePickerDialog$OnDateSetListener;", "listener", "Lkotlin/Function1;", "Lcom/zedan/acare/supervisor/ui/addTask/DatePickerACARE$DateData;", "Lkotlin/ParameterName;", "name", "data", "", "(Lkotlin/jvm/functions/Function1;)V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDateSet", "view", "Landroid/widget/DatePicker;", "year", "", "month", "dayOfMonth", "DateData", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: DatePickerACARE.kt */
public final class DatePickerACARE extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    private final Function1<DateData, Unit> listener;

    public DatePickerACARE(Function1<? super DateData, Unit> listener2) {
        Intrinsics.checkNotNullParameter(listener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = listener2;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        return new DatePickerDialog(requireContext(), this, c.get(1), c.get(2), c.get(5));
    }

    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        this.listener.invoke(new DateData(new StringBuilder().append(dayOfMonth).append('/').append(month + 1).append('/').append(year).toString()));
        dismiss();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/zedan/acare/supervisor/ui/addTask/DatePickerACARE$DateData;", "", "date", "", "(Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DatePickerACARE.kt */
    public static final class DateData {
        private final String date;

        public static /* synthetic */ DateData copy$default(DateData dateData, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = dateData.date;
            }
            return dateData.copy(str);
        }

        public final String component1() {
            return this.date;
        }

        public final DateData copy(String str) {
            Intrinsics.checkNotNullParameter(str, "date");
            return new DateData(str);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof DateData) && Intrinsics.areEqual((Object) this.date, (Object) ((DateData) obj).date);
            }
            return true;
        }

        public int hashCode() {
            String str = this.date;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "DateData(date=" + this.date + ")";
        }

        public DateData(String date2) {
            Intrinsics.checkNotNullParameter(date2, "date");
            this.date = date2;
        }

        public final String getDate() {
            return this.date;
        }
    }
}
