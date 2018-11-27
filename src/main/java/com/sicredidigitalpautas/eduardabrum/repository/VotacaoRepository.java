package com.sicredidigitalpautas.eduardabrum.repository;

import com.sicredidigitalpautas.eduardabrum.entity.Votacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface para chamadas de consulta no banco de dados.
 *
 * @author Eduarda de Brum Lucena
 */
@Repository
public interface VotacaoRepository extends CrudRepository<Votacao, Integer>, VotacaoRepositoryCustom {
}
