package com.zedan.acare.supervisor.utils;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: ImageSelectorUtil.kt */
final class ImageSelectorUtil$showImageSelectorDialog$2 implements View.OnClickListener {
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ Function1 $onSuccess;
    final /* synthetic */ Activity $this_showImageSelectorDialog;

    ImageSelectorUtil$showImageSelectorDialog$2(Activity activity, Function1 function1, Dialog dialog) {
        this.$this_showImageSelectorDialog = activity;
        this.$onSuccess = function1;
        this.$dialog = dialog;
    }

    public final void onClick(View it) {
        ImageSelectorUtil.INSTANCE.pickImage(this.$this_showImageSelectorDialog, ImageSelectorUtil.GALLERY, new Function1<File, Unit>(this) {
            final /* synthetic */ ImageSelectorUtil$showImageSelectorDialog$2 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((File) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(File file) {
                this.this$0.$onSuccess.invoke(file);
            }
        });
        this.$dialog.dismiss();
    }
}
