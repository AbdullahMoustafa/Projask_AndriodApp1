package com.zedan.acare.supervisor.data.auth;

import android.util.ArrayMap;

import com.zedan.acare.supervisor.domain.auth.RegisterParam;
import com.zedan.acare.supervisor.domain.mapper.Mapper;
import com.zedan.acare.supervisor.utils.Validator;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

@Singleton
public final class RegisterParamValidationMapper extends Mapper<RegisterParam, Map<String,Boolean>> {

    @Inject
    public RegisterParamValidationMapper(){
        super();
    }


    @Override
    public Map<String, Boolean> map(RegisterParam data) {
        Map<String, Boolean> map = new ArrayMap<>();
        map.put("isNotName", Validator.isName(data.getFullName(), 2));
        map.put("isNotMobile", Validator.isPhone(data.getPhone()));
        map.put("isNotEmail", Validator.isEmail(data.getEmail()));
        map.put("isNotPassword", Validator.isLargeThan(data.getPassword(), 7));
        map.put("isNotKinship", Validator.isLargeThan(data.getKinship(), 2));
        map.put("isNotAddress", Validator.isLargeThan(data.getAddress(), 3));
        map.put("isNotCountry", Validator.isLargeThan(data.getCountry(), 3));
        return map;
    }

}
