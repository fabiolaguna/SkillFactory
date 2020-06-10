package net.skillfactory.springPractice.controllers;

import net.skillfactory.springPractice.dtos.ErrorResponseDto;
import net.skillfactory.springPractice.dtos.InvalidFieldResponse;
import net.skillfactory.springPractice.exceptions.DuplicatedDniException;
import net.skillfactory.springPractice.exceptions.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = DuplicatedDniException.class)
    public ResponseEntity<ErrorResponseDto> duplicatedDniHandling(DuplicatedDniException ex){

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ErrorResponseDto.builder()
                .message(ex.getMessage())
                .errorCode(1)
                .build());
    }

    @ExceptionHandler(value = UserNotExistException.class)
    public ResponseEntity<ErrorResponseDto> userNotExistHandling(UserNotExistException ex){

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponseDto.builder()
                        .message(ex.getMessage())
                        .errorCode(2)
                        .build());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<List<InvalidFieldResponse>> notValidArgumentHandling(MethodArgumentNotValidException ex){

        List<InvalidFieldResponse> errors = ex.getBindingResult().getAllErrors()
                .stream()
                .map(error -> (FieldError) error)
                .map(error -> new InvalidFieldResponse(error.getField(), error.getRejectedValue(), error.getDefaultMessage()))
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errors);

    }
}
