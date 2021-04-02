package com.zedan.acare.supervisor.domain.auth;

import android.util.ArrayMap;

import com.google.firebase.database.Exclude;
import com.zedan.acare.supervisor.domain.Param;

import java.util.Map;

public final class RegisterPatientParam implements Param {
    private final String age;
    private final String country;
    private final String homeLocation;
    private final String mobile;
    private final String name;
    private final String password;
    private final String status;
    private final String statusType;
    private String supervisorKey;


    public RegisterPatientParam(String name2, String mobile2, String password2, String age2, String homeLocation2, String status2, String statusType2, String country2) {
        this.name = name2;
        this.mobile = mobile2;
        this.password = password2;
        this.age = age2;
        this.homeLocation = homeLocation2;
        this.status = status2;
        this.statusType = statusType2;
        this.country = country2;
    }

    public RegisterPatientParam(String name2, String mobile2, String password2, String age2, String homeLocation2, String status2, String statusType2, String country2, String supervisorKey2) {
        this.name = name2;
        this.mobile = mobile2;
        this.password = password2;
        this.age = age2;
        this.homeLocation = homeLocation2;
        this.status = status2;
        this.statusType = statusType2;
        this.country = country2;
        this.supervisorKey = supervisorKey2;
    }


    public final String getName() {
        return this.name;
    }

    public final String getMobile() {
        return this.mobile;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getAge() {
        return this.age;
    }

    public final String getHomeLocation() {
        return this.homeLocation;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getStatusType() {
        return this.statusType;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getSupervisorKey() {
        return this.supervisorKey;
    }

    public final void setSupervisorKey(String str) {
        this.supervisorKey = str;
    }

    @Exclude
    public final Map<String, Object> toMap() {
        Map<String, Object> map = new ArrayMap<>();
        map.put("name", name);
        map.put("mobile", mobile);
        map.put("password", password);
        map.put("age", age);
        map.put("homeLocation", homeLocation);
        map.put("status", status);
        map.put("statusType", statusType);
        map.put("country", country);
        map.put("supervisorKey", supervisorKey);
        return map;
    }
}
