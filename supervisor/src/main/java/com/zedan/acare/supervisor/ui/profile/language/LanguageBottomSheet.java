package com.zedan.acare.supervisor.ui.profile.language;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.zedan.acare.common.local.KeyString;
import com.zedan.acare.common.local.LocalSharedPreference;
import com.zedan.acare.common.utils.LanguageUtils;
import com.zedan.acare.supervisor.R;
import com.zedan.acare.supervisor.SupervisorActivity;
import com.zedan.acare.supervisor.databinding.LanguageBottomSheetBinding;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public final class LanguageBottomSheet extends BottomSheetDialogFragment {

    private LanguageBottomSheetBinding binding;

    private String currentLang;

    private String selectedLanguage;

    @Inject
    public LocalSharedPreference preference;


    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = LanguageBottomSheetBinding
                .inflate(inflater, container, false);

        this.currentLang = LanguageUtils.INSTANCE.currentLanguage(preference);
        this.selectedLanguage = this.currentLang;

        selectedLanguage(this.selectedLanguage);


        return this.binding.getRoot();
    }

    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.arabic.setOnClickListener(v -> selectedLanguage("ar"));
        binding.english.setOnClickListener(v -> selectedLanguage("en"));
        binding.applyBtn.setOnClickListener(v -> {
            if (this.selectedLanguage.equalsIgnoreCase(this.currentLang))
                return;

            preference.setString(KeyString.Language, this.selectedLanguage);
            startActivity(new Intent(requireContext(), SupervisorActivity.class));
            requireActivity().finish();
        });
    }

    private void selectedLanguage(String language) {
        boolean isEnglish = language.equals("en");
        this.selectedLanguage = language;
        binding.english
                .setCompoundDrawablesRelativeWithIntrinsicBounds(
                        0, 0, isEnglish ? R.drawable.ic_check_right: 0 ,0
                );

        binding.arabic
                .setCompoundDrawablesRelativeWithIntrinsicBounds(
                        0, 0, !isEnglish ? R.drawable.ic_check_right : 0, 0
                );
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }
}
