package com.sicredidigitalpautas.eduardabrum.validator;

import com.sicredidigitalpautas.eduardabrum.entity.Eleitor;
import com.sicredidigitalpautas.eduardabrum.exception.CustomValidationException;
import com.sicredidigitalpautas.eduardabrum.repository.EleitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

/**
 * Verifica se já existe cpf cadastrado
 *
 * @author Eduarda de Brum Lucena
 */
@Component
public class EleitorCpfExistsValidator implements Validator {

    private final EleitorRepository eleitorRepository;

    @Autowired
    public EleitorCpfExistsValidator(EleitorRepository eleitorRepository) {
        this.eleitorRepository = eleitorRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Eleitor.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Eleitor eleitor = (Eleitor) object;
        if (Objects.nonNull(eleitor) && eleitorRepository.existsById(eleitor.getCpf())) {
            throw new CustomValidationException("Cpf Já Cadastrado.");
        }
    }
}
