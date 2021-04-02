package com.zedan.acare.supervisor.ui.messageDialogs;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavArgs;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/zedan/acare/supervisor/ui/messageDialogs/MessageDialogsArgs;", "Landroidx/navigation/NavArgs;", "message", "Lcom/zedan/acare/supervisor/ui/messageDialogs/MessageArgs;", "(Lcom/zedan/acare/supervisor/ui/messageDialogs/MessageArgs;)V", "getMessage", "()Lcom/zedan/acare/supervisor/ui/messageDialogs/MessageArgs;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toString", "", "Companion", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: MessageDialogsArgs.kt */
public final class MessageDialogsArgs implements NavArgs {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final MessageArgs message;

    public static /* synthetic */ MessageDialogsArgs copy$default(MessageDialogsArgs messageDialogsArgs, MessageArgs messageArgs, int i, Object obj) {
        if ((i & 1) != 0) {
            messageArgs = messageDialogsArgs.message;
        }
        return messageDialogsArgs.copy(messageArgs);
    }

    @JvmStatic
    public static final MessageDialogsArgs fromBundle(Bundle bundle) {
        return Companion.fromBundle(bundle);
    }

    public final MessageArgs component1() {
        return this.message;
    }

    public final MessageDialogsArgs copy(MessageArgs messageArgs) {
        Intrinsics.checkNotNullParameter(messageArgs, "message");
        return new MessageDialogsArgs(messageArgs);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof MessageDialogsArgs) && Intrinsics.areEqual((Object) this.message, (Object) ((MessageDialogsArgs) obj).message);
        }
        return true;
    }

    public int hashCode() {
        MessageArgs messageArgs = this.message;
        if (messageArgs != null) {
            return messageArgs.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "MessageDialogsArgs(message=" + this.message + ")";
    }

    public MessageDialogsArgs(MessageArgs message2) {
        Intrinsics.checkNotNullParameter(message2, "message");
        this.message = message2;
    }

    public final MessageArgs getMessage() {
        return this.message;
    }

    public final Bundle toBundle() {
        Bundle result = new Bundle();
        if (Parcelable.class.isAssignableFrom(MessageArgs.class)) {
            MessageArgs messageArgs = this.message;
            if (messageArgs != null) {
                result.putParcelable("message", messageArgs);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.os.Parcelable");
            }
        } else if (Serializable.class.isAssignableFrom(MessageArgs.class)) {
            MessageArgs messageArgs2 = this.message;
            if (messageArgs2 != null) {
                result.putSerializable("message", (Serializable) messageArgs2);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.io.Serializable");
            }
        } else {
            throw new UnsupportedOperationException(MessageArgs.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
        return result;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/zedan/acare/supervisor/ui/messageDialogs/MessageDialogsArgs$Companion;", "", "()V", "fromBundle", "Lcom/zedan/acare/supervisor/ui/messageDialogs/MessageDialogsArgs;", "bundle", "Landroid/os/Bundle;", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MessageDialogsArgs.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @JvmStatic
        public final MessageDialogsArgs fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(MessageDialogsArgs.class.getClassLoader());
            if (!bundle.containsKey("message")) {
                throw new IllegalArgumentException("Required argument \"message\" is missing and does not have an android:defaultValue");
            } else if (Parcelable.class.isAssignableFrom(MessageArgs.class) || Serializable.class.isAssignableFrom(MessageArgs.class)) {
                MessageArgs __message = (MessageArgs) bundle.get("message");
                if (__message != null) {
                    return new MessageDialogsArgs(__message);
                }
                throw new IllegalArgumentException("Argument \"message\" is marked as non-null but was passed a null value.");
            } else {
                throw new UnsupportedOperationException(MessageArgs.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
            }
        }
    }
}
