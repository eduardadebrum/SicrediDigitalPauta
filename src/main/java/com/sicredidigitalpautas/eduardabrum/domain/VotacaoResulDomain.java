package com.sicredidigitalpautas.eduardabrum.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

/**
 * Classe de Dominio para os dados consulta
 *
 * @author Eduarda de Brum Lucena
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VotacaoResulDomain {

    private String temaPauta;

    private BigInteger nao;

    private BigInteger sim;

}
