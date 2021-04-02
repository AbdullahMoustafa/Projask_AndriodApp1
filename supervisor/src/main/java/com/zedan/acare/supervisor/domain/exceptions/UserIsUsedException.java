package com.zedan.acare.supervisor.domain.exceptions;

public class UserIsUsedException  extends Exception{

    public UserIsUsedException(){
        super("this user is used.");
    }
}
