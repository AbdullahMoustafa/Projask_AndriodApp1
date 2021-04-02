package com.zedan.acare.supervisor.data.auth;

import com.zedan.acare.supervisor.domain.auth.RegisterPatientResult;
import com.zedan.acare.supervisor.domain.mapper.Mapper;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class RegisterPatientErrorMapper extends Mapper<Map<String, Boolean>, RegisterPatientResult.Error.ErrorInputs> {
    
    @Inject
    public RegisterPatientErrorMapper(){    }
    
    @Override
    public RegisterPatientResult.Error.ErrorInputs map(Map<String, Boolean> data) {
        return new RegisterPatientResult.Error.ErrorInputs(
                get(data, "isNotName"),
                get(data,"isNotMobile"),
                get(data,"isNotPassword"),
                get(data,"isNotAge"),
                get(data,"isNotLocation"),
                get(data,"isNotStatus"),
                get(data,"isNotStatusType"),
                get(data,"isNotCountry")
        );
    }
    
}
