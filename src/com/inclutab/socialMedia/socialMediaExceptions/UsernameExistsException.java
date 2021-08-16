package com.inclutab.socialMedia.socialMediaExceptions;

public class UsernameExistsException extends RuntimeException{
    public UsernameExistsException(String message){
        super(message);
    }
}
