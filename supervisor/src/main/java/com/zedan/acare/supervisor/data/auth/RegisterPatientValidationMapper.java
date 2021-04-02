package com.zedan.acare.supervisor.data.auth;

import android.util.ArrayMap;

import com.zedan.acare.supervisor.domain.auth.RegisterPatientParam;
import com.zedan.acare.supervisor.domain.mapper.Mapper;
import com.zedan.acare.supervisor.utils.Validator;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class RegisterPatientValidationMapper extends Mapper<RegisterPatientParam, Map<String, Boolean>> {

    @Inject
    public RegisterPatientValidationMapper(){
        super();
    }

    @Override
    public Map<String, Boolean> map(RegisterPatientParam data) {
        Map<String, Boolean> map = new ArrayMap<>();
        map.put("isNotName", Validator.isName(data.getName(), 2));
        map.put("isNotMobile", Validator.isPhone(data.getMobile()));
        map.put("isNotPassword", Validator.isLargeThan(data.getPassword(), 7));
        map.put("isNotAge", Validator.isAge(data.getAge()));
        map.put("isNotLocation", Validator.isLargeThan(data.getHomeLocation(), 3));
        map.put("isNotStatus", Validator.isStatus(data.getStatus()));
        map.put("isNotStatusType", Validator.isLargeThan(data.getStatusType(), 2));
        map.put("isNotCountry", Validator.isLargeThan(data.getCountry(), 3));
        return map;
    }

}
