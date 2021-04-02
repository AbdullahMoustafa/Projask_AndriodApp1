package com.zedan.acare.supervisor.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.zedan.acare.supervisor.databinding.ProfileFragmentBinding;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/zedan/acare/supervisor/ui/profile/ProfileFragment;", "Landroidx/fragment/app/Fragment;", "()V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "getAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "setAuth", "(Lcom/google/firebase/auth/FirebaseAuth;)V", "binding", "Lcom/zedan/acare/supervisor/databinding/ProfileFragmentBinding;", "viewModel", "Lcom/zedan/acare/supervisor/ui/profile/ProfileViewModel;", "getViewModel", "()Lcom/zedan/acare/supervisor/ui/profile/ProfileViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setViewsListener", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
@AndroidEntryPoint
/* compiled from: ProfileFragment.kt */
public final class ProfileFragment extends Hilt_ProfileFragment {
    @Inject
    public FirebaseAuth auth;
    private ProfileFragmentBinding binding;
    private final Lazy viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new ProfileFragment$$special$$inlined$viewModels$2(new ProfileFragment$$special$$inlined$viewModels$1(this)), (Function0<? extends ViewModelProvider.Factory>) null);

    private final ProfileViewModel getViewModel() {
        return (ProfileViewModel) this.viewModel$delegate.getValue();
    }

    public ProfileFragment() {
    }

    public final FirebaseAuth getAuth() {
        FirebaseAuth firebaseAuth = this.auth;
        if (firebaseAuth == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auth");
        }
        return firebaseAuth;
    }

    public final void setAuth(FirebaseAuth firebaseAuth) {
        Intrinsics.checkNotNullParameter(firebaseAuth, "<set-?>");
        this.auth = firebaseAuth;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ProfileFragmentBinding inflate = ProfileFragmentBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "ProfileFragmentBinding.inflate(inflater)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        inflate.setViewModel(getViewModel());
        ProfileFragmentBinding profileFragmentBinding = this.binding;
        if (profileFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        profileFragmentBinding.setLifecycleOwner(getViewLifecycleOwner());
        ProfileFragmentBinding profileFragmentBinding2 = this.binding;
        if (profileFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        profileFragmentBinding2.executePendingBindings();
        ProfileFragmentBinding profileFragmentBinding3 = this.binding;
        if (profileFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = profileFragmentBinding3.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setViewsListener();
    }

    private final void setViewsListener() {
        ProfileFragmentBinding profileFragmentBinding = this.binding;
        if (profileFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        profileFragmentBinding.icBack.setOnClickListener(new ProfileFragment$setViewsListener$1(this));
        ProfileFragmentBinding profileFragmentBinding2 = this.binding;
        if (profileFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        profileFragmentBinding2.profileData.language.setOnClickListener(new ProfileFragment$setViewsListener$2(this));
        ProfileFragmentBinding profileFragmentBinding3 = this.binding;
        if (profileFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        profileFragmentBinding3.profileData.signOut.setOnClickListener(new ProfileFragment$setViewsListener$3(this));
    }
}
