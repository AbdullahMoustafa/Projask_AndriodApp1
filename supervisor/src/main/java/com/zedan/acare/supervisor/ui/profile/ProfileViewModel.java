package com.zedan.acare.supervisor.ui.profile;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.zedan.acare.supervisor.domain.auth.RegisterParam;
import com.zedan.acare.supervisor.domain.auth.RegisterPatientParam;
import com.zedan.acare.supervisor.domain.profile.ProfileParam;
import com.zedan.acare.supervisor.domain.profile.ProfileResult;
import com.zedan.acare.supervisor.domain.profile.ProfileUseCase;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

@HiltViewModel
public final class ProfileViewModel extends ViewModel {

    private final MutableLiveData<ProfileResult> statusProfile = new MutableLiveData<>(ProfileResult.None.NONE);

    private final ProfileUseCase profileUseCase;

    private final CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    public ProfileViewModel(ProfileUseCase profileUseCase) {
        this.profileUseCase = profileUseCase;
        getUserInfo();
    }


    public final void getUserInfo() {
        Disposable d = this.profileUseCase
                .execute(new ProfileParam(supervisorListener(), patientListener()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError);

        this.disposable.add(d);
    }

    private void onSuccess(ProfileResult result){
        this.statusProfile.postValue(result);
    }

    private void onError(Throwable throwable){
        this.statusProfile.postValue(new ProfileResult.Error(throwable));
    }

    private ValueEventListener supervisorListener() {
        return new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
    }

    private ValueEventListener patientListener() {
        return new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
    }

    public LiveData<ProfileResult.Success> getData() {
        return Transformations.map(statusProfile, s -> {
            if (s instanceof ProfileResult.Success)
                return (ProfileResult.Success) s;
            else
                return null;
        });
    }

    public final LiveData<Boolean> isLoading() {
        return Transformations.map(statusProfile, s -> s instanceof ProfileResult.Loading);
    }

    public final LiveData<ProfileResult.Error> getError() {
        return Transformations
                .map(statusProfile, s -> {
                    if (s instanceof ProfileResult.Error)
                        return (ProfileResult.Error) s;
                    else
                        return null;
                });
    }

    public final LiveData<RegisterPatientParam> getPatient() {
        return Transformations.map(getData(), d ->
                d != null && d.getPatient() != null ? d.getPatient(): null
        );
    }

    public final LiveData<RegisterParam> getSupervisor() {
        return Transformations.map(getData(), d ->
                d != null && d.getSupervisor() != null ? d.getSupervisor(): null
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}
