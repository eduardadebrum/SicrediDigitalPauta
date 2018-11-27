package com.sicredidigitalpautas.eduardabrum.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

/**
 * @author Eduarda de Brum Lucena
 */
@Getter
@Setter
public class ErrorPojo {

    private HttpStatus status;
    private String message;
    private List<String> errors;


    public ErrorPojo(HttpStatus status, String message, List<String> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ErrorPojo(HttpStatus status, String message, String errors) {
        this.status = status;
        this.message = message;
        this.errors = Arrays.asList(errors);
    }


}
