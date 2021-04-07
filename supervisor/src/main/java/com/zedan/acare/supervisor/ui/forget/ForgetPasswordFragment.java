package com.zedan.acare.supervisor.ui.forget;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.zedan.acare.supervisor.R;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public final class ForgetPasswordFragment extends Fragment {
    private ForgetPasswordViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this)
                .get(ForgetPasswordViewModel.class);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.forget_password_fragment, container, false);
    }
}
