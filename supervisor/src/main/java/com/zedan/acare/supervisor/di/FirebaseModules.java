package com.zedan.acare.supervisor.di;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.zedan.acare.supervisor.di.qulifier.FirebaseStorageReference;
import com.zedan.acare.supervisor.di.qulifier.PatientDatabaseReference;
import com.zedan.acare.supervisor.di.qulifier.PatientUnderSupervisorKey;
import com.zedan.acare.supervisor.di.qulifier.PersonalPhotoStorageReference;
import com.zedan.acare.supervisor.di.qulifier.SupervisorDatabaseReference;
import com.zedan.acare.supervisor.di.qulifier.UserDatabaseReference;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

import static com.zedan.acare.common.FirebaseDatabaseReferenceNames.PATIENT;
import static com.zedan.acare.common.FirebaseDatabaseReferenceNames.PERSONAL_PHOTO;
import static com.zedan.acare.common.FirebaseDatabaseReferenceNames.SUPERVISOR;
import static com.zedan.acare.common.FirebaseDatabaseReferenceNames.USERS;

@InstallIn(SingletonComponent.class)
@Module
public class FirebaseModules {

    @Singleton
    @Provides
    public static FirebaseAuth provideFirebaseAuth() {
        return FirebaseAuth.getInstance();
    }

    @Singleton
    @Provides
    public static FirebaseStorage provideFirebaseStorage() {
        return FirebaseStorage.getInstance();
    }


    @FirebaseStorageReference
    @Singleton
    @Provides
    public static StorageReference provideFirebaseStorageReference(
            FirebaseStorage firebaseStorage
    ) {
        return firebaseStorage.getReference();
    }


    @PersonalPhotoStorageReference
    @Singleton
    @Provides
    public static StorageReference provideFirebaseStoragePersonal(
            @FirebaseStorageReference StorageReference storageReference
    ){
        return storageReference.child(PERSONAL_PHOTO);
    }


    @Singleton
    @Provides
    public static FirebaseDatabase provideFirebaseDataBase(){
        return FirebaseDatabase.getInstance();
    }

    @UserDatabaseReference
    @Singleton
    @Provides
    public static DatabaseReference provideUserDatabaseReference(
            FirebaseDatabase firebaseDatabase
    ) {
        return firebaseDatabase.getReference(USERS);
    }

    @SupervisorDatabaseReference
    @Singleton
    @Provides
    public static DatabaseReference provideSupervisorDatabaseReference(
            @UserDatabaseReference DatabaseReference userRef
    ){
        return userRef.child(SUPERVISOR);
    }

    @PatientDatabaseReference
    @Singleton
    @Provides
    public static DatabaseReference providePatientDatabaseReference(
            @UserDatabaseReference DatabaseReference userRef
    ){
        return userRef.child(PATIENT);
    }

    @PatientUnderSupervisorKey
    @Singleton
    @Provides
    public static String providePatientUnderSupervisorKey() {
        return "patients";
    }
}
