package com.sicredidigitalpautas.eduardabrum.validator;

import com.sicredidigitalpautas.eduardabrum.domain.SessaoDomain;
import com.sicredidigitalpautas.eduardabrum.exception.CustomValidationException;
import com.sicredidigitalpautas.eduardabrum.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

/**
 * Verifica se a identificação da pauta informada existe para poder cadastrar uma sessão com uma pauta.
 *
 * @author Eduarda de Brum Lucena
 */
@Component
public class PautaIdentificacaoExistsValidator implements Validator {

    private final PautaRepository pautaRepository;

    @Autowired
    public PautaIdentificacaoExistsValidator(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return SessaoDomain.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        SessaoDomain sessaoDomain = (SessaoDomain) object;

        if (Objects.nonNull(sessaoDomain) && !pautaRepository.existsById(sessaoDomain.getIdPauta())) {
            throw new CustomValidationException("Pauta Informada não existe.");
        }
    }
}
