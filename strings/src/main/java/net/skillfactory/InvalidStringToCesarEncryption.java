package net.skillfactory;

public class InvalidStringToCesarEncryption extends Exception {

    public InvalidStringToCesarEncryption(){
        super("The specified string cannot be encrypted");
    }
}
