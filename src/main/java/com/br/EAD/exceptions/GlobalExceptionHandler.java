package com.br.EAD.exceptions;

import com.br.EAD.exceptions.dto.ErrorResponse;
import com.br.EAD.exceptions.ex.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserEmailAlreadyExists.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse userEmailAlreadyExistsHandler(UserEmailAlreadyExists userEmailAlreadyExists){
        return ErrorResponse.conflict(userEmailAlreadyExists.getMessage());
    }

    @ExceptionHandler(UserNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse userNotFoundHandler(UserNotFound userNotFound){
        return ErrorResponse.notFound(userNotFound.getMessage());
    }

    @ExceptionHandler(CourseNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse courseNotFoundHandler(CourseNotFound courseNotFound){
        return ErrorResponse.notFound(courseNotFound.getMessage());
    }

    @ExceptionHandler(CourseTittleAlreadyExists.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse courseTittleAlreadyExistsHandler(CourseTittleAlreadyExists courseTittleAlreadyExists){
        return ErrorResponse.conflict(courseTittleAlreadyExists.getMessage());
    }

    @ExceptionHandler(ClassroomNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse classroomNotFoundHandler(ClassroomNotFound classroomNotFound){
        return ErrorResponse.notFound(classroomNotFound.getMessage());
    }

    @ExceptionHandler(ClassroomTittleAlreadyExists.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse classroomTittleAlreadyExistsHandler(ClassroomTittleAlreadyExists classroomTittleAlreadyExists){
        return ErrorResponse.conflict(classroomTittleAlreadyExists.getMessage());
    }

}
