package com.zedan.acare.supervisor.domain.exceptions;

public class UserNullException extends Exception{

    public UserNullException(){
        super("User is Empty");
    }
}
