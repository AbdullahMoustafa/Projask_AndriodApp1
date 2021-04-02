package com.zedan.acare.supervisor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.zedan.acare.common.local.LocalSharedPreference;
import com.zedan.acare.common.utils.LanguageUtils;
import com.zedan.acare.supervisor.databinding.ActivitySupervisorBinding;
import com.zedan.acare.supervisor.di.LocalShared;

import java.util.Locale;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SupervisorActivity extends AppCompatActivity {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Inject
    public FirebaseAuth auth;
    @Inject
    public LocalSharedPreference sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LanguageUtils.INSTANCE.setLocale(
                this.getBaseContext(),
                LocalShared.provideLocalPreference(getApplicationContext())
        );

        super.onCreate(savedInstanceState);

        ActivitySupervisorBinding binding = ActivitySupervisorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_supervisor);
        NavController navController = navHostFragment != null ? navHostFragment.getNavController() : null;

        int navGraph;
        if (auth.getCurrentUser() == null){
            navGraph = R.navigation.supervisor_nav_graph;
        } else {
            navGraph = R.navigation.supervisor_nav_graph_home;
        }

        if (navController != null) {
            navController.setGraph(navGraph);
        } else {
            finish();
        }
    }


    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(
                LanguageUtils.INSTANCE.setLocale(
                        newBase,
                        LocalShared.provideLocalPreference(newBase)
                )
        );
    }

    public void applyOverrideConfiguration(Configuration overrideConfiguration) {
        int i = Build.VERSION.SDK_INT;
        if (19 <= i && 25 >= i) {
            Locale locale = Locale.getDefault();
            if (overrideConfiguration != null) {
                overrideConfiguration.setLocale(locale);
            }
        }
        super.applyOverrideConfiguration(overrideConfiguration);
    }
}