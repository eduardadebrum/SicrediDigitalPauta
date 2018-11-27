package com.sicredidigitalpautas.eduardabrum.service.impl;

import com.sicredidigitalpautas.eduardabrum.domain.VotacaoDomain;
import com.sicredidigitalpautas.eduardabrum.domain.VotacaoResulDomain;
import com.sicredidigitalpautas.eduardabrum.entity.Votacao;
import com.sicredidigitalpautas.eduardabrum.repository.VotacaoRepository;
import com.sicredidigitalpautas.eduardabrum.service.VotacaoService;
import com.sicredidigitalpautas.eduardabrum.util.SessionServeltDomain;
import com.sicredidigitalpautas.eduardabrum.validator.VotacaoStatusSessaoValidator;
import com.sicredidigitalpautas.eduardabrum.validator.VotacaoEleitorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementação do Serviço das funcionalidades do {@link com.sicredidigitalpautas.eduardabrum.entity.Eleitor}.
 *
 * @author Eduarda de Brum Lucena
 */
@Service
public class VotacaoServiceImpl implements VotacaoService {

    private final VotacaoRepository votacaoRepository;
    private final VotacaoStatusSessaoValidator votacaoStatusSessaoValidator;
    private final VotacaoEleitorValidator votacaoEleitorValidator;

    @Autowired
    public VotacaoServiceImpl(
            VotacaoRepository votacaoRepository,
            VotacaoStatusSessaoValidator votacaoStatusSessaoValidator,
            VotacaoEleitorValidator votacaoEleitorValidator) {
        this.votacaoRepository = votacaoRepository;
        this.votacaoStatusSessaoValidator = votacaoStatusSessaoValidator;
        this.votacaoEleitorValidator = votacaoEleitorValidator;
    }

    @Override
    @Transactional
    public Votacao votarSessao(VotacaoDomain votacaoDomain) {

        validateVotarSessao(votacaoDomain);

        new SessionServeltDomain().getSessao();
        //TODO eager pauta
        Votacao votacao = Votacao.builder()
                .cpf(votacaoDomain.getCpfAssociado())
                .idPauta(1)
                .simOrNaoEnum(votacaoDomain.getVoto())
                .build();

        return votacaoRepository.save(votacao);
    }

    @Override
    public List<VotacaoResulDomain> findAllVotacao() {
        return votacaoRepository.findAllResultadoVotacao();
    }

    private void validateVotarSessao(VotacaoDomain votacaoDomain) {
        votacaoStatusSessaoValidator.validate(votacaoDomain, null);
        votacaoEleitorValidator.validate(votacaoDomain, null);
    }
}
