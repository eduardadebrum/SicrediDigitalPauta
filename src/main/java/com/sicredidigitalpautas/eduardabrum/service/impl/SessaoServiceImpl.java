package com.sicredidigitalpautas.eduardabrum.service.impl;

import com.sicredidigitalpautas.eduardabrum.domain.SessaoDomain;
import com.sicredidigitalpautas.eduardabrum.entity.Sessao;
import com.sicredidigitalpautas.eduardabrum.enumerator.StatusSessaoEnum;
import com.sicredidigitalpautas.eduardabrum.repository.SessaoRepository;
import com.sicredidigitalpautas.eduardabrum.service.PautaService;
import com.sicredidigitalpautas.eduardabrum.service.SessaoService;
import com.sicredidigitalpautas.eduardabrum.util.SessionServeltDomain;
import com.sicredidigitalpautas.eduardabrum.validator.PautaIdentificacaoExistsValidator;
import com.sicredidigitalpautas.eduardabrum.validator.SessaoPautaExists;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Eduarda de Brum Lucena
 */
@Service
public class SessaoServiceImpl implements SessaoService {

    private static final Integer MINUTO = 1;

    private final PautaService pautaService;
    private final PautaIdentificacaoExistsValidator pautaIdentificacaoExistsValidator;
    private final SessaoPautaExists sessaoPautaExists;
    private final SessaoRepository sessaoRepository;

    @Autowired
    public SessaoServiceImpl(
            SessaoRepository sessaoRepository,
            PautaService pautaService,
            PautaIdentificacaoExistsValidator pautaIdentificacaoExistsValidator,
            SessaoPautaExists sessaoPautaExists) {
        this.sessaoRepository = sessaoRepository;
        this.pautaService = pautaService;
        this.pautaIdentificacaoExistsValidator = pautaIdentificacaoExistsValidator;
        this.sessaoPautaExists = sessaoPautaExists;
    }

    @Override
    public List<Sessao> findAllSessao() {
        return new ArrayList<>(IterableUtils.toList(sessaoRepository.findAll()));
    }

    @Override
    @Transactional
    public Sessao save(SessaoDomain sessaoDomain) {

        pautaIdentificacaoExistsValidator.validate(sessaoDomain, null);

        Sessao sessao = Sessao
                .builder()
                .duracao(Objects.isNull(sessaoDomain.getDuracao()) ? MINUTO : sessaoDomain.getDuracao())
                .statusSessaoEnum(StatusSessaoEnum.ABERTO)
                .build();

        Sessao sessaoSaved = sessaoRepository.save(sessao);

        pautaService.updateSessaoById(sessaoDomain.getIdPauta(), sessaoSaved.getIdSessao());

        return sessaoSaved;
    }

    @Override
    @Transactional
    public Sessao abrirSessaoParaVotacao(Integer idSessao) {

        sessaoPautaExists.validate(new Sessao(), null);

        Optional<Sessao> sessaoOptional = sessaoRepository.findById(idSessao);

        if (sessaoOptional.isPresent()) {

            Sessao sessao = sessaoOptional.get();
            sessao.setStatusSessaoEnum(StatusSessaoEnum.ANDAMENTO);
            sessao.setDataInicioSessao(LocalDateTime.now());
            Sessao save = sessaoRepository.save(sessao);

            new SessionServeltDomain().createOrKillSessao(save);

            try {
                Thread.sleep(save.getDuracao() * 60 * 1000);
                fecharSessaoDeVotacao();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return save;
        }

        return new Sessao();
    }

    @Override
    public void fecharSessaoDeVotacao() {
        SessionServeltDomain sessionServeltDomain = new SessionServeltDomain();
        Sessao sessao = sessionServeltDomain.getSessao();

        Optional<Sessao> sessaoOptional = sessaoRepository.findById(sessao.getIdSessao());

        if (sessaoOptional.isPresent()) {
            sessao.setDataFimSessao(LocalDateTime.now());
            sessao.setStatusSessaoEnum(StatusSessaoEnum.FECHADA);
            sessaoRepository.save(sessao);

            sessionServeltDomain.createOrKillSessao(null);
        }
    }
}
