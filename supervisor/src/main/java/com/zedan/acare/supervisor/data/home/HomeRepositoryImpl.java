package com.zedan.acare.supervisor.data.home;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.zedan.acare.supervisor.domain.home.FillPatientResult;
import com.zedan.acare.supervisor.domain.home.HomeRepository;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Singleton
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH@ø\u0001\u0000¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/zedan/acare/supervisor/data/home/HomeRepositoryImpl;", "Lcom/zedan/acare/supervisor/domain/home/HomeRepository;", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "supervisorReference", "Lcom/google/firebase/database/DatabaseReference;", "(Lcom/google/firebase/auth/FirebaseAuth;Lcom/google/firebase/database/DatabaseReference;)V", "hasFillPatient", "Lkotlinx/coroutines/flow/Flow;", "Lcom/zedan/acare/supervisor/domain/home/FillPatientResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: HomeRepositoryImpl.kt */
public final class HomeRepositoryImpl extends HomeRepository {
    /* access modifiers changed from: private */
    public final FirebaseAuth firebaseAuth;
    /* access modifiers changed from: private */
    public final DatabaseReference supervisorReference;

    @Inject
    public HomeRepositoryImpl(FirebaseAuth firebaseAuth2, DatabaseReference supervisorReference2) {
        Intrinsics.checkNotNullParameter(firebaseAuth2, "firebaseAuth");
        Intrinsics.checkNotNullParameter(supervisorReference2, "supervisorReference");
        this.firebaseAuth = firebaseAuth2;
        this.supervisorReference = supervisorReference2;
    }

    public Object hasFillPatient(Continuation<? super Flow<? extends FillPatientResult>> $completion) {
        return FlowKt.flow(new HomeRepositoryImpl$hasFillPatient$2(this, (Continuation) null));
    }
}
