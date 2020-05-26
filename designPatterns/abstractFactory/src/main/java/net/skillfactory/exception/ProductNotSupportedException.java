package net.skillfactory.exception;

public class ProductNotSupportedException extends Exception {

    public ProductNotSupportedException(){
    }

    public ProductNotSupportedException(String message){
        super(message);
    }
}
