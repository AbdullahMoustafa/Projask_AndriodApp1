package com.zedan.acare.supervisor.ui.profile.language;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.zedan.acare.common.local.C0009LocalSharedPreference;
import com.zedan.acare.common.utils.C0011LanguageUtils;
import com.zedan.acare.supervisor.R;
import com.zedan.acare.supervisor.databinding.LanguageBottomSheetBinding;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\tH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/zedan/acare/supervisor/ui/profile/language/LanguageBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "_binding", "Lcom/zedan/acare/supervisor/databinding/LanguageBottomSheetBinding;", "binding", "getBinding", "()Lcom/zedan/acare/supervisor/databinding/LanguageBottomSheetBinding;", "currentLang", "", "preference", "Lcom/zedan/acare/common/local/LocalSharedPreference;", "getPreference", "()Lcom/zedan/acare/common/local/LocalSharedPreference;", "setPreference", "(Lcom/zedan/acare/common/local/LocalSharedPreference;)V", "selectedLangage", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "selectedLanguage", "language", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
@AndroidEntryPoint
/* compiled from: LanguageBottomSheet.kt */
public final class LanguageBottomSheet extends Hilt_LanguageBottomSheet {
    private LanguageBottomSheetBinding _binding;
    /* access modifiers changed from: private */
    public String currentLang;
    @Inject
    public C0009LocalSharedPreference preference;
    /* access modifiers changed from: private */
    public String selectedLangage;

    public static final /* synthetic */ String access$getCurrentLang$p(LanguageBottomSheet $this) {
        String str = $this.currentLang;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentLang");
        }
        return str;
    }

    public static final /* synthetic */ String access$getSelectedLangage$p(LanguageBottomSheet $this) {
        String str = $this.selectedLangage;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedLangage");
        }
        return str;
    }

    private final LanguageBottomSheetBinding getBinding() {
        LanguageBottomSheetBinding languageBottomSheetBinding = this._binding;
        Intrinsics.checkNotNull(languageBottomSheetBinding);
        return languageBottomSheetBinding;
    }

    public final C0009LocalSharedPreference getPreference() {
        C0009LocalSharedPreference localSharedPreference = this.preference;
        if (localSharedPreference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preference");
        }
        return localSharedPreference;
    }

    public final void setPreference(C0009LocalSharedPreference localSharedPreference) {
        Intrinsics.checkNotNullParameter(localSharedPreference, "<set-?>");
        this.preference = localSharedPreference;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = LanguageBottomSheetBinding.inflate(inflater, container, false);
        C0011LanguageUtils languageUtils = C0011LanguageUtils.INSTANCE;
        C0009LocalSharedPreference localSharedPreference = this.preference;
        if (localSharedPreference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preference");
        }
        String currentLanguage = languageUtils.currentLanguage(localSharedPreference);
        this.currentLang = currentLanguage;
        if (currentLanguage == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentLang");
        }
        this.selectedLangage = currentLanguage;
        String str = this.currentLang;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentLang");
        }
        selectedLanguage(str);
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().arabic.setOnClickListener(new LanguageBottomSheet$onViewCreated$1(this));
        getBinding().english.setOnClickListener(new LanguageBottomSheet$onViewCreated$2(this));
        getBinding().applyBtn.setOnClickListener(new LanguageBottomSheet$onViewCreated$3(this));
    }

    /* access modifiers changed from: private */
    public final void selectedLanguage(String language) {
        boolean isEnglish = Intrinsics.areEqual((Object) language, (Object) "en");
        AppCompatTextView appCompatTextView = getBinding().arabic;
        int i = R.drawable.ic_check_right;
        appCompatTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, !isEnglish ? R.drawable.ic_check_right : 0, 0);
        AppCompatTextView appCompatTextView2 = getBinding().english;
        if (!isEnglish) {
            i = 0;
        }
        appCompatTextView2.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, i, 0);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }
}
