package net.skillfactory.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(){
        super("The product with the specified id doesn't exist");
    }
}
