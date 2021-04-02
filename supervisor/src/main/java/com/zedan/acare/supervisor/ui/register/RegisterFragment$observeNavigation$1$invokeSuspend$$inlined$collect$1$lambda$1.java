package com.zedan.acare.supervisor.ui.register;

import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "f", "Ljava/io/File;", "invoke", "com/zedan/acare/supervisor/ui/register/RegisterFragment$observeNavigation$1$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: RegisterFragment.kt */
final class RegisterFragment$observeNavigation$1$invokeSuspend$$inlined$collect$1$lambda$1 extends Lambda implements Function1<File, Unit> {
    final /* synthetic */ RegisterFragment$observeNavigation$1$invokeSuspend$$inlined$collect$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RegisterFragment$observeNavigation$1$invokeSuspend$$inlined$collect$1$lambda$1(RegisterFragment$observeNavigation$1$invokeSuspend$$inlined$collect$1 registerFragment$observeNavigation$1$invokeSuspend$$inlined$collect$1) {
        super(1);
        this.this$0 = registerFragment$observeNavigation$1$invokeSuspend$$inlined$collect$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((File) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(File f) {
        if (f != null) {
            File image = f;
            this.this$0.this$0.this$0.getViewModel().setImagePath(image.getAbsolutePath());
            RegisterFragment.access$getBinding$p(this.this$0.this$0.this$0).icAddPersonalPhoto.setImageURI(Uri.fromFile(image));
        }
    }
}
