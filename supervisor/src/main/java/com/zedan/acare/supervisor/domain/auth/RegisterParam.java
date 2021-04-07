package com.zedan.acare.supervisor.domain.auth;

import androidx.collection.ArrayMap;

import com.google.firebase.database.Exclude;
import com.zedan.acare.supervisor.domain.Param;
import com.zedan.acare.supervisor.domain.Result;

import java.util.Map;

public final class RegisterParam implements Param, Result {
    private final String address;
    private final String country;
    private final String email;
    private boolean enterPatientData;
    private final String fullName;
    private final String kinship;
    private final String password;
    private final String patients;
    private final String phone;
    private String profileImage;

    public RegisterParam() {
        this("", "", "", "", "", "", "", "", false, "");
    }

    public RegisterParam(String fullName, String phone, String email, String password, String kinship, String address, String country, String profileImage, boolean enterPatientData, String patients) {
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.kinship = kinship;
        this.address = address;
        this.country = country;
        this.profileImage = profileImage;
        this.enterPatientData = enterPatientData;
        this.patients = patients;
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getKinship() {
        return this.kinship;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getProfileImage() {
        return this.profileImage;
    }

    public final void setProfileImage(String str) {
        this.profileImage = str;
    }

    public final boolean getEnterPatientData() {
        return this.enterPatientData;
    }

    public final void setEnterPatientData(boolean z) {
        this.enterPatientData = z;
    }

    public final String getPatients() {
        return this.patients;
    }

    @Exclude
    public final Map<String, Object> toMap() {
        Map<String, Object> map = new ArrayMap<>();

        map.put("fullName", fullName);
        map.put("phone", phone);
        map.put("email", email);
        map.put("password", password);
        map.put("kinship", kinship);
        map.put("address", address);
        map.put("country", country);
        map.put("profileImage", profileImage);
        map.put("enterPatientData", enterPatientData);
        map.put("patients", patients);

        return map;
    }
}
