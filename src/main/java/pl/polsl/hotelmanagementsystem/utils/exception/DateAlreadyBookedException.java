package pl.polsl.hotelmanagementsystem.utils.exception;

public class DateAlreadyBookedException extends RuntimeException{
    public DateAlreadyBookedException(String message){
        super(message);
    }
}
