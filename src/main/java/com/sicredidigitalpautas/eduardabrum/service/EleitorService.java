package com.sicredidigitalpautas.eduardabrum.service;

import com.sicredidigitalpautas.eduardabrum.entity.Eleitor;

import java.util.List;

/**
 * Interface do Serviço Eleitor.
 *
 * @author Eduarda de Brum Lucena
 */
public interface EleitorService {

    /**
     * Método que faz a persistência eleitor no banco.
     *
     * @param eleitor Objecto com as informações do associado
     * @return o eleitor salvo na base
     */
    Eleitor save(Eleitor eleitor);

    /**
     * @return todos os eleitores cadastrados.
     */
    List<Eleitor> findAllEleitor();
}
