package net.skillfactory;

public class IncorrectRomanNumberException extends RuntimeException {

    public IncorrectRomanNumberException(){
        super("The roman number doesn't exist");
    }
}
