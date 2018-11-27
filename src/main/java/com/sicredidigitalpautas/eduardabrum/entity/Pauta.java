package com.sicredidigitalpautas.eduardabrum.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

/**
 * Classe de Mapeamento para a tabela de Pauta.
 *
 * @author Eduarda de Brum Lucena
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"sessao"})
@Entity
public class Pauta implements Serializable {

    private static final long serialVersionUID = 7018031208746134720L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAUTA")
    private Integer idPauta;

    @NotBlank(message = "O Tema é Obrigatório")
    @Column(name = "TEMA")
    private String tema;

    @NotBlank(message = "A Descrição é Obrigatória")
    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "ID_SESSAO")
    private Integer idSessao;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Sessao sessao;
}
