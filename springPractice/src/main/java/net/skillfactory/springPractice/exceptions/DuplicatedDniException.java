package net.skillfactory.springPractice.exceptions;

public class DuplicatedDniException extends RuntimeException {

    public DuplicatedDniException(String message){
        super(message);
    }
}
