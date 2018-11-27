package com.sicredidigitalpautas.eduardabrum.validator;

import com.sicredidigitalpautas.eduardabrum.domain.VotacaoDomain;
import com.sicredidigitalpautas.eduardabrum.exception.CustomValidationException;
import com.sicredidigitalpautas.eduardabrum.util.SessionServeltDomain;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

/**
 * Classe que verifica se a sessão ainda está em andamento para poder votar.
 *
 * @author Eduarda de Brum Lucena
 */
@Component
public class VotacaoStatusSessaoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return VotacaoDomain.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (Objects.isNull(new SessionServeltDomain().getSessao())) {
            throw new CustomValidationException("Votação encerrada");
        }
    }
}
