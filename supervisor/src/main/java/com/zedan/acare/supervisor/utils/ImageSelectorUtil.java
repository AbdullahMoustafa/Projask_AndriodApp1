package com.zedan.acare.supervisor.utils;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.github.dhaval2404.imagepicker.constant.ImageProvider;
import com.zedan.acare.supervisor.R;
import com.zedan.acare.supervisor.databinding.DialogImageSelectorBinding;

import java.io.File;

public final class ImageSelectorUtil {

    public static void showImageSelectorDialog(Activity activity, Listener listener) {
        Dialog dialog = new Dialog(activity, R.style.Theme_ACARE_Dialog);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        DialogImageSelectorBinding binding = DialogImageSelectorBinding
                .inflate(
                        LayoutInflater.from(activity),
                        null,
                        false
                );


        binding.cameraIcon.setOnClickListener(v ->
                getImagePicker(activity, ImageProvider.CAMERA, file -> {
                    listener.onSuccess(file);
                    dialog.dismiss();
                })
        );

        binding.galleryIcon.setOnClickListener(v ->
                getImagePicker(activity, ImageProvider.GALLERY, file -> {
                    listener.onSuccess(file);
                    dialog.dismiss();
                })
        );

        dialog.setContentView(binding.getRoot());

        if (dialog.getWindow() != null){
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            int width = (int) (((double) activity.getResources()
                    .getDisplayMetrics().widthPixels) * 0.9d);
            dialog.getWindow()
                    .setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        dialog.show();
    }

    private static void getImagePicker(
            Activity activity,
            ImageProvider provider,
            Listener listener
    ){
        ImagePicker.Companion.with(activity)
                .provider(provider)
                .compress(1024)
                .start((integer, intent) -> {
                    File file = ImagePicker.Companion.getFile(intent);
                    listener.onSuccess(file);
                    return null;
                });
    }

    public interface Listener {
        void onSuccess(File file);
    }
}
