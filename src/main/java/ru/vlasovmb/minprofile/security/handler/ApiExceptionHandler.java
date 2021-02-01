package ru.vlasovmb.minprofile.security.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.vlasovmb.minprofile.exception.ErrorsDto;
import ru.vlasovmb.minprofile.exception.InputException;

@ControllerAdvice
public class ApiExceptionHandler {


    @ExceptionHandler(InputException.class)
    public ResponseEntity<ErrorsDto> getInputResponse(InputException e) {
        ResponseEntity<ErrorsDto> response = new ResponseEntity<>(e.getErrorsDto(),HttpStatus.FORBIDDEN);
        return response;
    }


}

