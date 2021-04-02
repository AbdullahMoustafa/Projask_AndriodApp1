package com.zedan.acare.supervisor.ui.messageDialogs;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/zedan/acare/supervisor/ui/messageDialogs/MessageArgs;", "Landroid/os/Parcelable;", "message", "", "icon", "", "(Ljava/lang/String;I)V", "getIcon", "()I", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: MessageArgs.kt */
public final class MessageArgs implements Parcelable {
    public static final Parcelable.Creator<MessageArgs> CREATOR = new Creator();
    private final int icon;
    private final String message;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MessageArgs> {
        public final MessageArgs createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new MessageArgs(parcel.readString(), parcel.readInt());
        }

        public final MessageArgs[] newArray(int i) {
            return new MessageArgs[i];
        }
    }

    public static /* synthetic */ MessageArgs copy$default(MessageArgs messageArgs, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = messageArgs.message;
        }
        if ((i2 & 2) != 0) {
            i = messageArgs.icon;
        }
        return messageArgs.copy(str, i);
    }

    public final String component1() {
        return this.message;
    }

    public final int component2() {
        return this.icon;
    }

    public final MessageArgs copy(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "message");
        return new MessageArgs(str, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageArgs)) {
            return false;
        }
        MessageArgs messageArgs = (MessageArgs) obj;
        return Intrinsics.areEqual((Object) this.message, (Object) messageArgs.message) && this.icon == messageArgs.icon;
    }

    public int hashCode() {
        String str = this.message;
        return ((str != null ? str.hashCode() : 0) * 31) + Integer.hashCode(this.icon);
    }

    public String toString() {
        return "MessageArgs(message=" + this.message + ", icon=" + this.icon + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.message);
        parcel.writeInt(this.icon);
    }

    public MessageArgs(String message2, int icon2) {
        Intrinsics.checkNotNullParameter(message2, "message");
        this.message = message2;
        this.icon = icon2;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getIcon() {
        return this.icon;
    }
}
