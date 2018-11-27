package com.sicredidigitalpautas.eduardabrum.service;

import com.sicredidigitalpautas.eduardabrum.domain.PautaDomain;
import com.sicredidigitalpautas.eduardabrum.entity.Pauta;

import java.util.List;

/**
 * Interface do Serviço da Pauta.
 *
 * @author Eduarda de Brum Lucena
 */
public interface PautaService {

    /**
     * @return todos as pautas cadastradas.
     */
    List<Pauta> findAllPauta();

    /**
     * Método que faz a persistência eleitor no banco.
     *
     * @param pautaDomain Objecto de dominio com as informações da pauta
     * @return o {@link Pauta} salvo na base
     */
    Pauta save(PautaDomain pautaDomain);

    /**
     * Método que atualiza a {@link Pauta} atribuindo uma nova sessão.
     *
     * @param idPauta Identificação da Pauta
     * @param idSessao Identificação da Sessão
     */
    void updateSessaoById(Integer idPauta, Integer idSessao);
}
