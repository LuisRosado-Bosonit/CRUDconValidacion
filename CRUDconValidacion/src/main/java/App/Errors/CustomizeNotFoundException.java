package App.Errors;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class CustomizeNotFoundException extends ChangeSetPersister.NotFoundException {
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public final ResponseEntity<CustomError> handleNotFoundException(ChangeSetPersister.NotFoundException er, WebRequest request) {
       CustomError error = new CustomError(new Date(), HttpStatus.NOT_FOUND.value(), er.getMessage());
       return new ResponseEntity<CustomError>(error,HttpStatus.NOT_FOUND) ;
    }


}
