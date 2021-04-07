package com.zedan.acare.supervisor.ui.messageDialogs;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;

public final class MessageArgs implements Parcelable {

    @DrawableRes
    private final int icon;
    private final String message;

    public MessageArgs(
            String message,
            @DrawableRes int icon) {
        this.message = message;
        this.icon = icon;
    }

    protected MessageArgs(Parcel in) {
        icon = in.readInt();
        message = in.readString();
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

    public final String getMessage() {
        return this.message;
    }

    public final int getIcon() {
        return this.icon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(icon);
        dest.writeString(message);
    }
}
