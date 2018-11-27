package com.sicredidigitalpautas.eduardabrum.service.impl;

import com.sicredidigitalpautas.eduardabrum.entity.Eleitor;
import com.sicredidigitalpautas.eduardabrum.repository.EleitorRepository;
import com.sicredidigitalpautas.eduardabrum.service.EleitorService;
import com.sicredidigitalpautas.eduardabrum.validator.EleitorCpfExistsValidator;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementação do Serviço das funcionalidades do {@link com.sicredidigitalpautas.eduardabrum.entity.Eleitor}.
 *
 * @author Eduarda de Brum Lucena
 */
@Service
public class EleitorServiceImpl implements EleitorService {

    private final EleitorRepository eleitorRepository;
    private final EleitorCpfExistsValidator eleitorCpfExistsValidator;

    @Autowired
    public EleitorServiceImpl(EleitorRepository eleitorRepository, EleitorCpfExistsValidator eleitorCpfExistsValidator) {
        this.eleitorRepository = eleitorRepository;
        this.eleitorCpfExistsValidator = eleitorCpfExistsValidator;
    }

    @Override
    public Eleitor save( Eleitor eleitor) {
        eleitorCpfExistsValidator.validate(eleitor, null);
        return eleitorRepository.save(eleitor);
    }

    @Override
    public List<Eleitor> findAllEleitor() {
        return new ArrayList<>(IterableUtils.toList(eleitorRepository.findAll()));
    }
}
