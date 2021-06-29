package pl.polsl.hotelmanagementsystem.utils.exception;

public class ObjectExistsException extends RuntimeException {
    private final String message;
    public ObjectExistsException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
