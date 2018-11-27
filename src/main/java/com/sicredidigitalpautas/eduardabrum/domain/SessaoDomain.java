package com.sicredidigitalpautas.eduardabrum.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

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
public class SessaoDomain {

    @NotNull(message = "A Pauta deve ser informada")
    private Integer idPauta;

    private Integer duracao;
}
