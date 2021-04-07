package com.zedan.acare.supervisor.domain.profile;

import android.os.Parcel;
import android.os.Parcelable;

import com.zedan.acare.supervisor.domain.Param;

public class EditInputParam implements Parcelable, Param {

    private final String path;
    private final String hint;
    private String value;
    private final EditInputValidation validation;

    public EditInputParam(String path,
                           String hint, String value,
                           EditInputValidation validation) {
        this.path = path;
        this.hint = hint;
        this.value = value;
        this.validation = validation;
    }

    public void setValue(String value) {
        this.value = value;
    }

    protected EditInputParam(Parcel in) {
        path = in.readString();
        hint = in.readString();
        value = in.readString();
        validation = in.readParcelable(EditInputValidation.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(path);
        dest.writeString(hint);
        dest.writeString(value);
        dest.writeParcelable(validation, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<EditInputParam> CREATOR = new Parcelable.Creator<EditInputParam>() {
        @Override
        public EditInputParam createFromParcel(Parcel in) {
            return new EditInputParam(in);
        }

        @Override
        public EditInputParam[] newArray(int size) {
            return new EditInputParam[size];
        }
    };

    public String getPath() {
        return path;
    }


    public EditInputValidation getValidation() {
        return validation;
    }

    public String getHint() {
        return hint;
    }

    public String getValue() {
        return value;
    }
}
