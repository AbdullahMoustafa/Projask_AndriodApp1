package com.zedan.acare.common.entities;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;

public class MessageArgs implements Parcelable {
    private final String message;

    @DrawableRes
    private final int icon;

    public MessageArgs(String message, @DrawableRes int icon){
        this.message = message;
        this.icon = icon;
    }

    protected MessageArgs(Parcel in) {
        message = in.readString();
        icon = in.readInt();
    }

    public static final Creator<MessageArgs> CREATOR = new Creator<MessageArgs>() {
        @Override
        public MessageArgs createFromParcel(Parcel in) {
            return new MessageArgs(in);
        }

        @Override
        public MessageArgs[] newArray(int size) {
            return new MessageArgs[size];
        }
    };

    public int getIcon() {
        return icon;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(message);
        dest.writeInt(icon);
    }
}
