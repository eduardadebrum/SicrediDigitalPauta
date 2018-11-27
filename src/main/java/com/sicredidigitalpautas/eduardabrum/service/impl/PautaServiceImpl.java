package com.sicredidigitalpautas.eduardabrum.service.impl;

import com.sicredidigitalpautas.eduardabrum.domain.PautaDomain;
import com.sicredidigitalpautas.eduardabrum.entity.Pauta;
import com.sicredidigitalpautas.eduardabrum.entity.Sessao;
import com.sicredidigitalpautas.eduardabrum.enumerator.SimOrNaoEnum;
import com.sicredidigitalpautas.eduardabrum.enumerator.StatusSessaoEnum;
import com.sicredidigitalpautas.eduardabrum.repository.PautaRepository;
import com.sicredidigitalpautas.eduardabrum.repository.SessaoRepository;
import com.sicredidigitalpautas.eduardabrum.service.PautaService;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementação do Serviço das funcionalidades da {@link com.sicredidigitalpautas.eduardabrum.entity.Pauta}.
 *
 * @author Eduarda de Brum Lucena
 */
@Service
public class PautaServiceImpl implements PautaService {

    private final SessaoRepository sessaoRepository;
    private final PautaRepository repository;

    @Autowired
    public PautaServiceImpl(SessaoRepository sessaoRepository, PautaRepository repository) {
        this.sessaoRepository = sessaoRepository;
        this.repository = repository;
    }

    @Override
    public List<Pauta> findAllPauta() {
        return new ArrayList<>(IterableUtils.toList(repository.findAll()));
    }

    @Override
    @Transactional
    public Pauta save(PautaDomain pautaDomain) {

        Sessao sessaoSaved = createSessao(pautaDomain);

        Pauta pauta = Pauta
                .builder()
                .descricao(pautaDomain.getDescricao())
                .tema(pautaDomain.getTema())
                .idSessao(sessaoSaved.getIdSessao())
                .build();

        return repository.save(pauta);
    }

    @Override
    public void updateSessaoById(Integer idPauta, Integer idSessao) {
        Optional<Pauta> pauta = repository.findById(idPauta);
        pauta.ifPresent(p -> p.setIdSessao(idSessao));
    }

    private Sessao createSessao(PautaDomain pautaDomain) {

        if (SimOrNaoEnum.SIM.equals(pautaDomain.getAbrirSessao())) {

            Sessao sessao = Sessao
                    .builder()
                    .duracao(pautaDomain.getDuracao())
                    .statusSessaoEnum(StatusSessaoEnum.ABERTO)
                    .build();

            return sessaoRepository.save(sessao);

        }
        return new Sessao();
    }
}
