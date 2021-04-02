package com.zedan.acare.supervisor.utils;

import android.content.Intent;
import com.github.dhaval2404.imagepicker.ImagePicker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "resultCode", "", "data", "Landroid/content/Intent;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ImageSelectorUtil.kt */
final class ImageSelectorUtil$getImagePicker$1 extends Lambda implements Function2<Integer, Intent, Unit> {
    final /* synthetic */ Function1 $onError;
    final /* synthetic */ Function1 $onSuccess;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageSelectorUtil$getImagePicker$1(Function1 function1, Function1 function12) {
        super(2);
        this.$onSuccess = function1;
        this.$onError = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (Intent) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(int resultCode, Intent data) {
        if (resultCode == -1) {
            this.$onSuccess.invoke(ImagePicker.Companion.getFile(data));
        } else if (resultCode == 64) {
            this.$onError.invoke(ImagePicker.Companion.getError(data));
        }
    }
}
