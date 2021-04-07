package com.zedan.acare.supervisor.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.zedan.acare.supervisor.domain.None;
import com.zedan.acare.supervisor.domain.auth.RegisterParam;
import com.zedan.acare.supervisor.domain.auth.RegisterPatientParam;
import com.zedan.acare.supervisor.domain.profile.ProfileResult;
import com.zedan.acare.supervisor.domain.profile.ProfileUseCase;
import com.zedan.acare.supervisor.domain.profile.UploadImageParam;
import com.zedan.acare.supervisor.domain.profile.UploadImageStatus;
import com.zedan.acare.supervisor.domain.profile.UploadImageUseCase;
import com.zedan.acare.supervisor.utils.SingleLiveEvent;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

@HiltViewModel
public final class ProfileViewModel extends ViewModel {

    private final MutableLiveData<ProfileResult> statusProfile = new MutableLiveData<>(ProfileResult.None.NONE);

    private final SingleLiveEvent<UploadImageStatus> uploadImageStatus = new SingleLiveEvent<>();

    private final ProfileUseCase profileUseCase;

    private final UploadImageUseCase uploadImageUseCase;

    private final CompositeDisposable disposable = new CompositeDisposable();

    private String supervisorPath = "";
    private String patientPath = "";

    @Inject
    public ProfileViewModel(ProfileUseCase profileUseCase, UploadImageUseCase uploadImageUseCase) {
        this.profileUseCase = profileUseCase;
        this.uploadImageUseCase = uploadImageUseCase;
        getUserInfo();
    }


    public final void getUserInfo() {
        Disposable d = this.profileUseCase
                .execute(new None())
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

    public LiveData<ProfileResult.Success> getData() {
        return Transformations.map(statusProfile, s -> {
            if (s instanceof ProfileResult.Success){
                ProfileResult.Success r =  (ProfileResult.Success) s;
                this.supervisorPath = r.getSupervisorPath();
                this.patientPath = r.getPatientPath();
                return r;
            }
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

    public String getPatientPath() {
        return patientPath;
    }

    public String getSupervisorPath() {
        return supervisorPath;
    }


    public void uploadImage(String path){
        Disposable d = uploadImageUseCase
                .execute(new UploadImageParam(path, getSupervisorPath() + "/profileImage"))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccessUploadImage, this::onErrorUploadImage);
        disposable.add(d);
    }

    private void onSuccessUploadImage(UploadImageStatus status){
        this.uploadImageStatus.postValue(status);
    }

    private void onErrorUploadImage(Throwable throwable){
        this.uploadImageStatus.postValue(new UploadImageStatus.Error(throwable));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}
