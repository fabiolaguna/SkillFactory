package net.skillfactory.springPractice.controllers;

import net.skillfactory.springPractice.dtos.ErrorResponseDto;
import net.skillfactory.springPractice.exceptions.DuplicatedDniException;
import net.skillfactory.springPractice.exceptions.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationHandler {

    @ExceptionHandler(value = DuplicatedDniException.class)
    public ResponseEntity<ErrorResponseDto> duplicatedDniHandling(DuplicatedDniException ex){

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ErrorResponseDto.builder()
                .message(ex.getMessage())
                .errorCode(1)
                .build());
    }

    @ExceptionHandler(value = UserNotExistException.class)
    public ResponseEntity<ErrorResponseDto> UserNotExistHandling(UserNotExistException ex){

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponseDto.builder()
                        .message(ex.getMessage())
                        .errorCode(2)
                        .build());
    }
}
