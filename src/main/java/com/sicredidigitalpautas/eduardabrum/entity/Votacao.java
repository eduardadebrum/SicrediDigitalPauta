package com.sicredidigitalpautas.eduardabrum.entity;

import com.sicredidigitalpautas.eduardabrum.enumerator.SimOrNaoEnum;
import com.sicredidigitalpautas.eduardabrum.enumerator.converter.SimOrNaoEnumConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Classe de Mapeamento para a tabela de Votação.
 *
 * @author Eduarda de Brum Lucena
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"pauta", "eleitor"})

@Entity
public class Votacao implements Serializable {

    private static final long serialVersionUID = 4225424809716012341L;
    private static final String ID_PAUTA = "ID_PAUTA";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VOTACAO")
    private Integer idVotacao;

    @NotBlank(message = "O Cpf do Eleitor é Obrigatório")
    @Column(name = "CPF")
    private String cpf;

    @NotNull(message = "A Pauta é Obrigatória")
    @Column(name = ID_PAUTA)
    private Integer idPauta;

    @Convert(converter = SimOrNaoEnumConverter.class)
    @Column(name = "VOTO")
    private SimOrNaoEnum simOrNaoEnum;

    @ManyToOne()
    @JoinColumn(referencedColumnName = ID_PAUTA, name = ID_PAUTA, insertable = false, updatable = false)
    private Pauta pauta;

    @OneToOne
    private Eleitor eleitor;
}
