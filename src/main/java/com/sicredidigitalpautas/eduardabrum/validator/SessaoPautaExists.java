package com.sicredidigitalpautas.eduardabrum.validator;

import com.sicredidigitalpautas.eduardabrum.entity.Sessao;
import com.sicredidigitalpautas.eduardabrum.exception.CustomValidationException;
import com.sicredidigitalpautas.eduardabrum.util.SessionServeltDomain;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

/**
 * @author Eduarda de Brum Lucena
 */
@Component
public class SessaoPautaExists implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Sessao.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if (Objects.nonNull(new SessionServeltDomain().getSessao())) {
            throw new CustomValidationException("Existe uma sessão em andamento.");
        }
    }
}
