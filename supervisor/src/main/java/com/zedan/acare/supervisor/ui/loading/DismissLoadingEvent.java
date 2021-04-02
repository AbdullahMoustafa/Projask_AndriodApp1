package com.zedan.acare.supervisor.ui.loading;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\nHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/zedan/acare/supervisor/ui/loading/DismissLoadingEvent;", "Landroid/os/Parcelable;", "dismiss", "", "(Z)V", "getDismiss", "()Z", "component1", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: DismissLoadingEvent.kt */
public final class DismissLoadingEvent implements Parcelable {
    public static final Parcelable.Creator<DismissLoadingEvent> CREATOR = new Creator();
    private final boolean dismiss;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DismissLoadingEvent> {
        public final DismissLoadingEvent createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DismissLoadingEvent(parcel.readInt() != 0);
        }

        public final DismissLoadingEvent[] newArray(int i) {
            return new DismissLoadingEvent[i];
        }
    }

    public DismissLoadingEvent() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DismissLoadingEvent copy$default(DismissLoadingEvent dismissLoadingEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = dismissLoadingEvent.dismiss;
        }
        return dismissLoadingEvent.copy(z);
    }

    public final boolean component1() {
        return this.dismiss;
    }

    public final DismissLoadingEvent copy(boolean z) {
        return new DismissLoadingEvent(z);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof DismissLoadingEvent) && this.dismiss == ((DismissLoadingEvent) obj).dismiss;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.dismiss;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "DismissLoadingEvent(dismiss=" + this.dismiss + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.dismiss ? 1 : 0);
    }

    public DismissLoadingEvent(boolean dismiss2) {
        this.dismiss = dismiss2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DismissLoadingEvent(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    public final boolean getDismiss() {
        return this.dismiss;
    }
}
