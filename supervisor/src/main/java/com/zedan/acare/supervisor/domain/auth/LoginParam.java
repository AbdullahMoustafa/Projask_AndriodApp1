package com.zedan.acare.supervisor.domain.auth;

import com.zedan.acare.supervisor.domain.Param;

import java.util.Objects;

public final class LoginParam implements Param {

    private final String email;
    private final String password;

    public LoginParam() {
        this(null, null);
    }

    public LoginParam(String email2, String password2) {
        this.email = email2;
        this.password = password2;
    }


    public final String getEmail() {
        return this.email;
    }

    public final String getPassword() {
        return this.password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoginParam)) return false;
        LoginParam that = (LoginParam) o;
        return Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getPassword(), that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getPassword());
    }
}
