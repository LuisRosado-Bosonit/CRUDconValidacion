package Persona.Errors;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;
@Data
public class CustomError {
    Date timestamp;
    int HttpCode;
    String mensaje;

    public CustomError(Date date, int value, String message) {
        this.timestamp = date;
        this.HttpCode = value;
        this.mensaje = message;
    }
}
