package com.sicredidigitalpautas.eduardabrum.service;

import com.sicredidigitalpautas.eduardabrum.domain.SessaoDomain;
import com.sicredidigitalpautas.eduardabrum.entity.Sessao;

import java.util.List;

/**
 * Interface do Serviço da Sessao.
 *
 * @author Eduarda de Brum Lucena
 */
public interface SessaoService {

    List<Sessao> findAllSessao();

    /**
     * Criar um
     *
     * @param sessaoDomain
     * @return
     */
    Sessao save(SessaoDomain sessaoDomain);

    Sessao abrirSessaoParaVotacao(Integer idSessao);

    void fecharSessaoDeVotacao();
}
