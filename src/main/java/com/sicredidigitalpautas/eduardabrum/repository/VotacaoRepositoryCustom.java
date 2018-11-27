package com.sicredidigitalpautas.eduardabrum.repository;

import java.util.List;

/**
 * Interface para customizar as consultas na base
 */
public interface VotacaoRepositoryCustom {

    /**
     * Verifica se ja existe voto com os valores informados.
     *
     * @param cpfAssociado dados cpf
     * @param idPauta      identificacao pauta
     * @return se ja existe voto com os valores informados.
     */
    boolean existsVotoAssociado(String cpfAssociado, Integer idPauta);

    /**
     * Busca resultado
     *
     * @return se ja existe voto com os valores informados.
     */
    List findAllResultadoVotacao();
}
