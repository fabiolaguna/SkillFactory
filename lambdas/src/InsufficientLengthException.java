public class InsufficientLengthException extends RuntimeException {

    public InsufficientLengthException(){
        super("String length is less than 1");
    }
}
