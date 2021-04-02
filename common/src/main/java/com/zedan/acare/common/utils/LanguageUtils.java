package com.zedan.acare.common.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import androidx.annotation.NonNull;

import com.zedan.acare.common.local.KeyString;
import com.zedan.acare.common.local.LocalSharedPreference;

import java.util.Locale;

public final class LanguageUtils {
    @NonNull
    public static final LanguageUtils INSTANCE = new LanguageUtils();

    private LanguageUtils() {
    }

    @NonNull
    public final String currentLanguage(@NonNull LocalSharedPreference local) {
        String string = local.getString(KeyString.Language);
        return string != null ? string : "ar";
    }

    @NonNull
    public final Context setLocale(@NonNull Context context, @NonNull LocalSharedPreference preference) {
        String string = preference.getString(KeyString.Language);
        if (string == null) {
            string = "ar";
        }
        return updateResources(context, string);
    }

    private Context updateResources(Context _context, String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Resources res = _context.getResources();
        Configuration config = new Configuration(res.getConfiguration());
        config.setLocale(locale);
        return _context.createConfigurationContext(config);
    }
}

