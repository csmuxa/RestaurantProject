package com.restaurantsProject.project.exceptions.handler;

import com.restaurantsProject.project.exceptions.AlreadyExistException;
import com.restaurantsProject.project.exceptions.DataNotFoundException;
import com.restaurantsProject.project.models.ErrorMesageModel.ExceptionMessage;
import com.restaurantsProject.project.models.ErrorMesageModel.ExceptionMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionHandlerClass extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AlreadyExistException.class)
    protected ResponseEntity<ExceptionMessage> handleAlreadyExistException() {
        return new ResponseEntity<>(new ExceptionMessage(ExceptionMessages.RECORD_ALREADY_EXISTS.getErrorMessage(),new Date()), HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(DataNotFoundException.class)
    protected ResponseEntity<ExceptionMessage> handleAuthenticationFailedException(){

        return new ResponseEntity<>(new ExceptionMessage(ExceptionMessages.AUTHENTICATION_FAILED.getErrorMessage(),new Date()), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(DataNotFoundException.class)
    protected ResponseEntity<ExceptionMessage> handleCouldNotDeleteDataException(){

        return new ResponseEntity<>(new ExceptionMessage(ExceptionMessages.COULD_NOT_DELETE_RECORD.getErrorMessage(),new Date()), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(DataNotFoundException.class)
    protected ResponseEntity<ExceptionMessage> handleCouldNotUpdateDataException(){

        return new ResponseEntity<>(new ExceptionMessage(ExceptionMessages.COULD_NOT_UPDATE_RECORD.getErrorMessage(),new Date()), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(DataNotFoundException.class)
    protected ResponseEntity<ExceptionMessage> handleInternalServerErrorException(){

        return new ResponseEntity<>(new ExceptionMessage(ExceptionMessages.INTERNAL_SERVER_ERROR.getErrorMessage(),new Date()), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(DataNotFoundException.class)
    protected ResponseEntity<ExceptionMessage> handleDataNotFoundException(){

        return new ResponseEntity<>(new ExceptionMessage(ExceptionMessages.NO_RECORD_FOUND.getErrorMessage(),new Date()), HttpStatus.NOT_FOUND);

    }
}
