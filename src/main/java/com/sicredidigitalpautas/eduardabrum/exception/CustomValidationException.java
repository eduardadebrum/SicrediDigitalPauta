package com.sicredidigitalpautas.eduardabrum.exception;

import javax.validation.ValidationException;

/**
 * Classe que extende {@link ValidationException} para lançamento das exceções.
 *
 * @author Eduarda de Brum Lucena
 */
public class CustomValidationException extends ValidationException {

    public CustomValidationException() {

    }

    public CustomValidationException(String message) {
        super(message);
    }

    public CustomValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomValidationException(Throwable cause) {
        super(cause);
    }
}
