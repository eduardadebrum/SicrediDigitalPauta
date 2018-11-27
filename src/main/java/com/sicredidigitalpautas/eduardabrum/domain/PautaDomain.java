package com.sicredidigitalpautas.eduardabrum.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sicredidigitalpautas.eduardabrum.enumerator.SimOrNaoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe de Dominio que visa gerenciar os dados das requisições.
 *
 * @author Eduarda de Brum Lucena
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PautaDomain {

    private String tema;

    private String descricao;

    private SimOrNaoEnum abrirSessao;

    private Integer duracao;
}
