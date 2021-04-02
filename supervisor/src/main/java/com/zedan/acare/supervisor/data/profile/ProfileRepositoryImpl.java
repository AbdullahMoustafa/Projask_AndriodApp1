package com.zedan.acare.supervisor.data.profile;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.zedan.acare.supervisor.domain.profile.ProfileParam;
import com.zedan.acare.supervisor.domain.profile.ProfileRepository;
import com.zedan.acare.supervisor.domain.profile.ProfileResult;
import com.zedan.acare.supervisor.domain.profile.UserDataBasic;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Singleton
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t2\u0006\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/zedan/acare/supervisor/data/profile/ProfileRepositoryImpl;", "Lcom/zedan/acare/supervisor/domain/profile/ProfileRepository;", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "supervisorReference", "Lcom/google/firebase/database/DatabaseReference;", "patientReference", "(Lcom/google/firebase/auth/FirebaseAuth;Lcom/google/firebase/database/DatabaseReference;Lcom/google/firebase/database/DatabaseReference;)V", "getBasicUserInfo", "Lkotlinx/coroutines/flow/Flow;", "Lcom/zedan/acare/supervisor/domain/profile/UserDataBasic;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserInfo", "Lcom/zedan/acare/supervisor/domain/profile/ProfileResult;", "param", "Lcom/zedan/acare/supervisor/domain/profile/ProfileParam;", "(Lcom/zedan/acare/supervisor/domain/profile/ProfileParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProfileRepositoryImpl.kt */
public final class ProfileRepositoryImpl extends ProfileRepository {
    /* access modifiers changed from: private */
    public final FirebaseAuth firebaseAuth;
    /* access modifiers changed from: private */
    public final DatabaseReference patientReference;
    /* access modifiers changed from: private */
    public final DatabaseReference supervisorReference;

    @Inject
    public ProfileRepositoryImpl(FirebaseAuth firebaseAuth2, DatabaseReference supervisorReference2, DatabaseReference patientReference2) {
        Intrinsics.checkNotNullParameter(firebaseAuth2, "firebaseAuth");
        Intrinsics.checkNotNullParameter(supervisorReference2, "supervisorReference");
        Intrinsics.checkNotNullParameter(patientReference2, "patientReference");
        this.firebaseAuth = firebaseAuth2;
        this.supervisorReference = supervisorReference2;
        this.patientReference = patientReference2;
    }

    public Object getBasicUserInfo(Continuation<? super Flow<UserDataBasic>> $completion) {
        return FlowKt.flow(new ProfileRepositoryImpl$getBasicUserInfo$2(this, (Continuation) null));
    }

    public Object getUserInfo(ProfileParam param, Continuation<? super Flow<? extends ProfileResult>> $completion) {
        return FlowKt.flow(new ProfileRepositoryImpl$getUserInfo$2(this, (Continuation) null));
    }
}
