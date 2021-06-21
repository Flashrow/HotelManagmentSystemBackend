package pl.polsl.hotelmanagementsystem.utils.exception;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {
    @Bean
    public ErrorAttributes errorAttributes(){
        return new DefaultErrorAttributes(){
            @Override
            public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
                Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
                //errorAttributes.remove("trace");
                return errorAttributes;
            }
        };
    }

    @ExceptionHandler(ObjectExistsException.class)
    protected ResponseEntity<Object> handleObjectExistsException(ObjectExistsException objectExistsException){
        return new ResponseEntity<Object>(objectExistsException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DateAlreadyBookedException.class)
    protected ResponseEntity<Object> handleDateAlreadyBookedException(DateAlreadyBookedException dateAlreadyBookedException){
        return new ResponseEntity<Object>(dateAlreadyBookedException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessException.class)
    protected ResponseEntity<Object> handleDateAlreadyBookedException(AccessException accessException){
        return new ResponseEntity<Object>(accessException.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
