package com.br.EAD.exceptions;

import com.br.EAD.exceptions.dto.ErrorResponse;
import com.br.EAD.exceptions.ex.UserEmailAlreadyExists;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserEmailAlreadyExists.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse userEmailAlreadyExistsHandler(String message){
        return ErrorResponse.conflict(message);
    }

}
