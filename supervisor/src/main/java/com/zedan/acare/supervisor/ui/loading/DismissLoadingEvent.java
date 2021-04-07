package com.zedan.acare.supervisor.ui.loading;

import android.os.Parcel;
import android.os.Parcelable;

public final class DismissLoadingEvent implements Parcelable {

    private final boolean dismiss;

    public DismissLoadingEvent(){
        this.dismiss = true;
    }

   public DismissLoadingEvent(boolean dismiss){
       this.dismiss = dismiss;
   }

    protected DismissLoadingEvent(Parcel in) {
        dismiss = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (dismiss ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DismissLoadingEvent> CREATOR = new Creator<DismissLoadingEvent>() {
        @Override
        public DismissLoadingEvent createFromParcel(Parcel in) {
            return new DismissLoadingEvent(in);
        }

        @Override
        public DismissLoadingEvent[] newArray(int size) {
            return new DismissLoadingEvent[size];
        }
    };

    public final boolean getDismiss() {
        return this.dismiss;
    }
}
