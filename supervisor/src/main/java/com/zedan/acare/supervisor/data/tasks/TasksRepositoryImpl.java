package com.zedan.acare.supervisor.data.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.zedan.acare.supervisor.data.utils.ReplaceKeys;
import com.zedan.acare.supervisor.di.qulifier.PatientDatabaseReference;
import com.zedan.acare.supervisor.di.qulifier.SupervisorDatabaseReference;
import com.zedan.acare.supervisor.domain.auth.RegisterParam;
import com.zedan.acare.supervisor.domain.exceptions.HaveNotPatient;
import com.zedan.acare.supervisor.domain.exceptions.UserNullException;
import com.zedan.acare.supervisor.domain.tasks.AddTaskParam;
import com.zedan.acare.supervisor.domain.tasks.AddTaskResult;
import com.zedan.acare.supervisor.domain.tasks.GetTasksResult;
import com.zedan.acare.supervisor.domain.tasks.TaskEntity;
import com.zedan.acare.supervisor.domain.tasks.TaskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import timber.log.Timber;

@Singleton
public final class TasksRepositoryImpl extends TaskRepository {

    public final AddTaskErrorValidationMapper addTaskErrorValidation;

    public final AddTaskValidationMapper addTaskValidationMapper;

    private final FirebaseAuth firebaseAuth;

    private final DatabaseReference patientReference;

    private final DatabaseReference supervisorReference;

    @Inject
    public TasksRepositoryImpl(
            FirebaseAuth firebaseAuth,
            AddTaskValidationMapper addTaskValidationMapper,
            AddTaskErrorValidationMapper addTaskErrorValidation,
            @PatientDatabaseReference DatabaseReference patientReference,
            @SupervisorDatabaseReference DatabaseReference supervisorReference
    ) {
        this.addTaskValidationMapper = addTaskValidationMapper;
        this.addTaskErrorValidation = addTaskErrorValidation;
        this.patientReference = patientReference;
        this.supervisorReference = supervisorReference;
        this.firebaseAuth = firebaseAuth;
    }

    @Override
    public Observable<AddTaskResult> addTask(AddTaskParam param) {
        Observable<AddTaskResult> observable = Observable.create(emitter -> {
            Map<String, Boolean> validations = addTaskValidationMapper.map(param);
            if (!validations.values().stream().allMatch(t -> t)) {
                emitter.onNext(addTaskErrorValidation.map(validations));
                emitter.onComplete();
                return;
            }

            emitter.onNext(AddTaskResult.Success.SUCCESS);
            emitter.onComplete();
        });
        return observable.flatMap((Function<AddTaskResult, ObservableSource<AddTaskResult>>) result -> {

            if (result instanceof AddTaskResult.Error) {
                return Observable.just(result);
            }

            return getSupervisorKey()
                    .flatMap((Function<String, ObservableSource<AddTaskResult>>) email -> {
                        if (email == null || email.isEmpty())
                            return Observable.just(new AddTaskResult.Error.Exception(new UserNullException()));

                        String supervisorKey = ReplaceKeys.toValidKey(email);

                        return getPatientKey(supervisorKey)
                                .flatMap((Function<String, ObservableSource<AddTaskResult>>) s -> {
                                    if (s == null || s.isEmpty()) {
                                        return Observable.just(new AddTaskResult.Error.Exception(new HaveNotPatient()));
                                    }
                                    return addTaskToPatient(s, param);
                                });
                    });
        });
    }

    private Observable<String> getSupervisorKey() {
        return Observable.create(emitter -> {
            String email = firebaseAuth.getCurrentUser() != null &&
                    firebaseAuth.getCurrentUser().getEmail() != null
                    ? firebaseAuth.getCurrentUser().getEmail() : null;
            emitter.onNext(email);
            emitter.onComplete();
        });
    }

    private Observable<String> getPatientKey(String supervisorKey) {
        return Observable.create(emitter -> supervisorReference
                .child(supervisorKey)
                .get()
                .addOnSuccessListener(r -> {
                    RegisterParam param = r.getValue(RegisterParam.class);
                    emitter.onNext(param != null ? param.getPatients() : "");
                    emitter.onComplete();
                })
                .addOnFailureListener(emitter::onError));
    }

    private Observable<AddTaskResult> addTaskToPatient(
            String patientKey,
            AddTaskParam param
    ) {
        return Observable.create(emitter -> patientReference
                .child(patientKey)
                .child("tasks")
                .child(ReplaceKeys.toValidKey(param.getStartTimeDate()))
                .push()
                .setValue(param.toMap())
                .addOnSuccessListener(r -> {
                    emitter.onNext(AddTaskResult.Success.SUCCESS);
                    emitter.onComplete();
                })
                .addOnFailureListener(emitter::onError));
    }

    @Override
    public Observable<GetTasksResult> getTasks() {
        return getSupervisorKey()
                .flatMap((Function<String, ObservableSource<GetTasksResult>>) email -> {
                    if (email == null || email.isEmpty())
                        return Observable.just(new GetTasksResult.Error(new UserNullException()));

                    String supervisorKey = ReplaceKeys.toValidKey(email);
                    return getPatientKey(supervisorKey)
                            .flatMap((Function<String, ObservableSource<GetTasksResult>>) patientKey -> {
                                if (patientKey == null || patientKey.isEmpty())
                                    return Observable.just(new GetTasksResult.Error(new HaveNotPatient()));

                                return listenToTask(patientKey);
                            });
                });
    }

    private Observable<GetTasksResult> listenToTask(String patientKey) {
        List<TaskEntity> tasks = new ArrayList<>();
        return Observable.create(emitter -> patientReference
                .child(patientKey)
                .child("tasks")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        emitter.onNext(GetTasksResult.Loading.LOADING);
                        tasks.clear();
                        Timber.e("Values is %s", snapshot.getValue());
                        Timber.e("value changed %s" , snapshot.getChildrenCount());
                        snapshot.getChildren().forEach(d -> {
                            List<AddTaskParam> tasksParam = new ArrayList<>();
                            d.getChildren().forEach(t -> {
                                AddTaskParam task = t.getValue(AddTaskParam.class);
                                tasksParam.add(task);
                            });
                            tasks.add(new TaskEntity(d.getKey(), tasksParam));
                            Timber.e("Child co");
                        });

                        emitter.onNext(new GetTasksResult.Success(tasks));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        emitter.onNext(new GetTasksResult.Error(error.toException()));
                    }
                })
            );
    }
}
