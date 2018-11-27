package com.sicredidigitalpautas.eduardabrum.controller;

import com.sicredidigitalpautas.eduardabrum.util.ErrorPojo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Responsável por lançar as exceções nas requisições REST em tempo de execução.
 *
 * @author Eduarda de Brum Lucena
 */
@ControllerAdvice
public class RestResponseExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    protected ResponseEntity<Object> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex,
            WebRequest request) {

        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
        List<String> errors = new ArrayList<>();

        allErrors.forEach(error -> errors.add(error.getDefaultMessage()));

        ErrorPojo errorPojo = new ErrorPojo(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);

        return new ResponseEntity<>(errorPojo, new HttpHeaders(), errorPojo.getStatus());
    }
}