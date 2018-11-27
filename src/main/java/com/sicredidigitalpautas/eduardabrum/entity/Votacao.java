package com.sicredidigitalpautas.eduardabrum.entity;

import com.sicredidigitalpautas.eduardabrum.enumerator.SimOrNaoEnum;
import com.sicredidigitalpautas.eduardabrum.enumerator.converter.SimOrNaoEnumConverter;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Classe de Mapeamento para a tabela de Votação.
 *
 * @author Eduarda de Brum Lucena
 */
@Getter
@Setter
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
    private SimOrNaoEnum simOrNaoEnum;

    @ManyToOne()
    @JoinColumn(referencedColumnName = ID_PAUTA, name = ID_PAUTA, insertable = false, updatable = false)
    private Pauta pauta;

    @OneToOne
    private Eleitor eleitor;
}
