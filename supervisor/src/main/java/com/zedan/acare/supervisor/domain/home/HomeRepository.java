package com.zedan.acare.supervisor.domain.home;

import io.reactivex.rxjava3.core.Flowable;

public abstract class HomeRepository {

    abstract Flowable<FillPatientResult> hasFillPatient();

}
