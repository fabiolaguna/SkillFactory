package net.skillfactory.springPractice.exceptions;

public class UserNotExistException extends RuntimeException {

    public UserNotExistException(String message){
        super(message);
    }
}
