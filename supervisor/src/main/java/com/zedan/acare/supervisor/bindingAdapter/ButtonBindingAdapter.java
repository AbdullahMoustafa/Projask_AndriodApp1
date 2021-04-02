package com.zedan.acare.supervisor.bindingAdapter;

import android.graphics.Color;
import android.widget.Button;

import androidx.annotation.StringRes;

import com.github.razir.progressbutton.ProgressButtonUtils;
import com.github.razir.progressbutton.ProgressParams;

public final class ButtonBindingAdapter {

    public static void showWhiteProgress(Button button){
        ProgressParams params = new ProgressParams();
        params.setProgressColor(Color.WHITE);
        ProgressButtonUtils
                .showProgress(
                        button,
                        params
                );
    }

    public static void hideProgress(Button button, @StringRes int text){
        ProgressButtonUtils.hideProgress(button, text);
    }
}
