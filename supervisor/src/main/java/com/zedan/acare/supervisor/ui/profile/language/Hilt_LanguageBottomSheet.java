package com.zedan.acare.supervisor.ui.profile.language;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.Preconditions;
import dagger.hilt.internal.UnsafeCasts;

public abstract class Hilt_LanguageBottomSheet extends BottomSheetDialogFragment implements GeneratedComponentManagerHolder {
    private ContextWrapper componentContext;
    private volatile FragmentComponentManager componentManager;
    private final Object componentManagerLock = new Object();
    private boolean injected = false;

    public void onAttach(Context context) {
        super.onAttach(context);
        initializeComponentContext();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ContextWrapper contextWrapper = this.componentContext;
        Preconditions.checkState(contextWrapper == null || FragmentComponentManager.findActivity(contextWrapper) == activity, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        initializeComponentContext();
    }

    private void initializeComponentContext() {
        if (this.componentContext == null) {
            this.componentContext = FragmentComponentManager.createContextWrapper(super.getContext(), (Fragment) this);
            inject();
        }
    }

    public Context getContext() {
        return this.componentContext;
    }

    public LayoutInflater onGetLayoutInflater(Bundle savedInstanceState) {
        return LayoutInflater.from(FragmentComponentManager.createContextWrapper(super.onGetLayoutInflater(savedInstanceState), (Fragment) this));
    }

    public final Object generatedComponent() {
        return componentManager().generatedComponent();
    }

    /* access modifiers changed from: protected */
    public FragmentComponentManager createComponentManager() {
        return new FragmentComponentManager(this);
    }

    public final FragmentComponentManager componentManager() {
        if (this.componentManager == null) {
            synchronized (this.componentManagerLock) {
                if (this.componentManager == null) {
                    this.componentManager = createComponentManager();
                }
            }
        }
        return this.componentManager;
    }

    /* access modifiers changed from: protected */
    public void inject() {
        if (!this.injected) {
            this.injected = true;
            ((LanguageBottomSheet_GeneratedInjector) generatedComponent()).injectLanguageBottomSheet((LanguageBottomSheet) UnsafeCasts.unsafeCast(this));
        }
    }

    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return DefaultViewModelFactories.getFragmentFactory(this);
    }
}
