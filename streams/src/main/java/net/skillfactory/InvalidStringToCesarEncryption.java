package net.skillfactory;

public class InvalidStringToCesarEncryption extends RuntimeException {

    public InvalidStringToCesarEncryption(){
        super("The specified string cannot be encrypted");
    }
}
