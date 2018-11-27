package com.sicredidigitalpautas.eduardabrum.repository;

import com.sicredidigitalpautas.eduardabrum.entity.Eleitor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface para chamadas de consulta no banco de dados.
 *
 * @author Eduarda de Brum Lucena
 */
@Repository
public interface EleitorRepository extends CrudRepository<Eleitor, String> {
}
