package com.sicredidigitalpautas.eduardabrum.validator;

import com.sicredidigitalpautas.eduardabrum.domain.VotacaoDomain;
import com.sicredidigitalpautas.eduardabrum.exception.CustomValidationException;
import com.sicredidigitalpautas.eduardabrum.repository.VotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

/**
 * Classe que verifica se o eleitor já Votou na pauta na sessão.
 *
 * @author Eduarda de Brum Lucena
 */
@Component
public class VotacaoEleitorValidator implements Validator {

    private final VotacaoRepository votacaoRepository;

    @Autowired
    public VotacaoEleitorValidator(VotacaoRepository votacaoRepository) {
        this.votacaoRepository = votacaoRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return VotacaoDomain.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        VotacaoDomain votacaoDomain = (VotacaoDomain) target;
        //TODO Vv
        if (Objects.nonNull(votacaoDomain)
                && votacaoRepository.existsVotoAssociado(votacaoDomain.getCpfAssociado(), 1)) {

            throw new CustomValidationException("O Associado já votou nessa Pauta.");
        }
    }
}
