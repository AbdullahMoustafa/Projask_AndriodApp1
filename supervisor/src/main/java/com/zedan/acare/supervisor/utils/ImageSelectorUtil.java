package com.zedan.acare.supervisor.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.github.dhaval2404.imagepicker.constant.ImageProvider;
import com.zedan.acare.supervisor.R;
import com.zedan.acare.supervisor.databinding.DialogImageSelectorBinding;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;


public final class ImageSelectorUtil {
    
    public final void showImageSelectorDialog(Activity activity, Function1<? super File, Unit> onSuccess) {
        Dialog dialog = new Dialog(activity, R.style.Theme_ACARE_Dialog);
        dialog.requestWindowFeature(1);
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.dialog_image_selector,  null, false);
        DialogImageSelectorBinding binding = (DialogImageSelectorBinding) inflate;
        //binding.cameraIcon.setOnClickListener(new ImageSelectorUtil$showImageSelectorDialog$1(activity, onSuccess, dialog));
        //binding.galleryIcon.setOnClickListener(new ImageSelectorUtil$showImageSelectorDialog$2(activity, onSuccess, dialog));
        dialog.setContentView(binding.getRoot());
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Resources resources = activity.getResources();
        int width = (int) (((double) resources.getDisplayMetrics().widthPixels) * 0.9d);
        Window window2 = dialog.getWindow();
        if (window2 != null) {
            window2.setLayout(width, -2);
        }
        dialog.show();
    }

    interface Listener{
        void onSuccess();
    }

//    /* access modifiers changed from: private */
//    public final void pickImage(Activity $this$pickImage, ImageProvider provider, Function1<? super File, Unit> onSuccess) {
//        getImagePicker($this$pickImage, provider, new ImageSelectorUtil$pickImage$1(onSuccess), ImageSelectorUtil$pickImage$2.INSTANCE);
//    }
//
//    private void getImagePicker(Activity activity, ImageProvider provider, Function1<? super File, Unit> onSuccess, Function1<? super String, Unit> onError) {
//        ImagePicker.Companion.with(activity).provider(provider).compress(1024).start((Function2<? super Integer, ? super Intent, Unit>) new ImageSelectorUtil$getImagePicker$1(onSuccess, onError));
//    }
}
