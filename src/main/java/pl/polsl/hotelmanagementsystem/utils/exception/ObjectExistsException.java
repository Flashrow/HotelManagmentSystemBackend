package pl.polsl.hotelmanagementsystem.utils.exception;

public class ObjectExistsException extends RuntimeException {
    public ObjectExistsException(String message){
        super(message);
    }
}
