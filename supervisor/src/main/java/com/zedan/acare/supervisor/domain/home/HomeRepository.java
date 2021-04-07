package com.zedan.acare.supervisor.domain.home;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public abstract class HomeRepository {

    public abstract Observable<FillPatientResult> hasFillPatient();

}
