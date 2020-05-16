package net.skillfactory;

public class NullStringException extends RuntimeException {

    public NullStringException(){
        super("The string parameter shouldn't be null");
    }
}
