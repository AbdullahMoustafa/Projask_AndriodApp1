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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J`\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042#\u0010\u000b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00070\f2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00070\fH\u0002J9\u0010\u0014\u001a\u00020\u0007*\u00020\t2\u0006\u0010\n\u001a\u00020\u00042#\u0010\u000b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00070\fH\u0002J/\u0010\u0015\u001a\u00020\u0007*\u00020\t2#\u0010\u000b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00070\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/zedan/acare/supervisor/utils/ImageSelectorUtil;", "", "()V", "CAMERA", "Lcom/github/dhaval2404/imagepicker/constant/ImageProvider;", "GALLERY", "getImagePicker", "", "activity", "Landroid/app/Activity;", "provider", "onSuccess", "Lkotlin/Function1;", "Ljava/io/File;", "Lkotlin/ParameterName;", "name", "file", "onError", "", "errorMessage", "pickImage", "showImageSelectorDialog", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: ImageSelectorUtil.kt */
public final class ImageSelectorUtil {
    /* access modifiers changed from: private */
    public static final ImageProvider CAMERA = ImageProvider.CAMERA;
    /* access modifiers changed from: private */
    public static final ImageProvider GALLERY = ImageProvider.GALLERY;
    public static final ImageSelectorUtil INSTANCE = new ImageSelectorUtil();

    private ImageSelectorUtil() {
    }

    public final void showImageSelectorDialog(Activity $this$showImageSelectorDialog, Function1<? super File, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter($this$showImageSelectorDialog, "$this$showImageSelectorDialog");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Dialog dialog = new Dialog($this$showImageSelectorDialog, 2131886480);
        dialog.requestWindowFeature(1);
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from($this$showImageSelectorDialog), R.layout.dialog_image_selector, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…          false\n        )");
        DialogImageSelectorBinding binding = (DialogImageSelectorBinding) inflate;
        binding.cameraIcon.setOnClickListener(new ImageSelectorUtil$showImageSelectorDialog$1($this$showImageSelectorDialog, onSuccess, dialog));
        binding.galleryIcon.setOnClickListener(new ImageSelectorUtil$showImageSelectorDialog$2($this$showImageSelectorDialog, onSuccess, dialog));
        dialog.setContentView(binding.getRoot());
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Resources resources = $this$showImageSelectorDialog.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "this.resources");
        int width = (int) (((double) resources.getDisplayMetrics().widthPixels) * 0.9d);
        Window window2 = dialog.getWindow();
        if (window2 != null) {
            window2.setLayout(width, -2);
        }
        dialog.show();
    }

    /* access modifiers changed from: private */
    public final void pickImage(Activity $this$pickImage, ImageProvider provider, Function1<? super File, Unit> onSuccess) {
        getImagePicker($this$pickImage, provider, new ImageSelectorUtil$pickImage$1(onSuccess), ImageSelectorUtil$pickImage$2.INSTANCE);
    }

    private final void getImagePicker(Activity activity, ImageProvider provider, Function1<? super File, Unit> onSuccess, Function1<? super String, Unit> onError) {
        ImagePicker.Companion.with(activity).provider(provider).compress(1024).start((Function2<? super Integer, ? super Intent, Unit>) new ImageSelectorUtil$getImagePicker$1(onSuccess, onError));
    }
}
