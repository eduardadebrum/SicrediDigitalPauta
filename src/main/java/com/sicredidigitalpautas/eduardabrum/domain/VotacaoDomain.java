package com.sicredidigitalpautas.eduardabrum.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sicredidigitalpautas.eduardabrum.enumerator.SimOrNaoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
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
public class VotacaoDomain {

    @NotNull(message = "O Voto é Obrigatório")
    private SimOrNaoEnum voto;

    @NotBlank(message = "A Identificação do Associado é obrigatório")
    private String cpfAssociado;
}
