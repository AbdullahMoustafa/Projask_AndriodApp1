package com.zedan.acare.supervisor.extension;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.CycleInterpolator;

import com.google.android.material.textfield.TextInputLayout;

public final class ViewExtension {

    public static void show(View view) {
        view.setVisibility(View.VISIBLE);
    }

    public static void hide(View view) {
        view.setVisibility(View.GONE);
    }

    public static void shake(TextInputLayout layout, Boolean shake) {
        if (!shake && layout.getEditText() == null)
            return;

        shake(layout.getEditText());
    }

    public static void shake(View view, Boolean shake) {
        if (!shake)
            return;

        shake(view);
    }

    public static void shake(View view) {
        ObjectAnimator animator = ObjectAnimator
                .ofFloat(view, "translationX", 0f, 10f);

        animator.setInterpolator(new CycleInterpolator(6f));
        animator.setDuration(800);
        animator.start();
    }
}
