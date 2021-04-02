package com.zedan.acare.supervisor.data.auth;

import com.zedan.acare.supervisor.domain.auth.RegisterResult;
import com.zedan.acare.supervisor.domain.mapper.Mapper;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Singleton
public final class RegisterValidationErrorMapper extends Mapper<Map<String, Boolean>, RegisterResult.Error.InputError> {

    @Inject
    public RegisterValidationErrorMapper() {
        super();
    }

    @Override
    public RegisterResult.Error.InputError map(Map<String, Boolean> data) {
        return new RegisterResult.Error.InputError(
                get(data, "isNotName"),
                get(data, "isNotMobile"),
                get(data, "isNotEmail"),
                get(data, "isNotPassword"),
                get(data, "isNotKinship"),
                get(data, "isNotAddress"),
                get(data, "isNotCountry")
        );
    }

}
