package com.zedan.acare.supervisor.domain.profile;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class EditInputValidation  implements Parcelable {
    public abstract boolean validateInput(String input);

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
