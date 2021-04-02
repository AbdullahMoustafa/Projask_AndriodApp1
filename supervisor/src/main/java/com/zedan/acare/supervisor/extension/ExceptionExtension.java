package com.zedan.acare.supervisor.extension;

import android.content.Context;

import com.google.firebase.FirebaseNetworkException;
import com.zedan.acare.common.entities.MessageArgs;
import com.zedan.acare.supervisor.R;

public final class ExceptionExtension {

    public static MessageArgs getCommonMessage(Exception exception, Context context) {
        MessageArgs args;
        if (exception instanceof FirebaseNetworkException) {
            args = new MessageArgs(
                    context.getString(R.string.error_connection),
                    R.drawable.ic_exclamation_mark
            );
        } else {
            args = new MessageArgs(
                    context.getString(R.string.error),
                    R.drawable.ic_exclamation_mark
            );
        }

        return args;
    }
}
