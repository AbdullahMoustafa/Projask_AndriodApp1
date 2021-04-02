package com.zedan.acare.supervisor.utils;

import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "file", "Ljava/io/File;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ImageSelectorUtil.kt */
final class ImageSelectorUtil$pickImage$1 extends Lambda implements Function1<File, Unit> {
    final /* synthetic */ Function1 $onSuccess;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageSelectorUtil$pickImage$1(Function1 function1) {
        super(1);
        this.$onSuccess = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((File) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(File file) {
        this.$onSuccess.invoke(file);
    }
}
