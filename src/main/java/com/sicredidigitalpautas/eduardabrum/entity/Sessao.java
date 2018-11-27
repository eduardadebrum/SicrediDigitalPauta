package com.sicredidigitalpautas.eduardabrum.entity;

import com.sicredidigitalpautas.eduardabrum.enumerator.StatusSessaoEnum;
import com.sicredidigitalpautas.eduardabrum.enumerator.converter.StatusSessaoEnumConverter;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * Classe de Mapeamento para a tabela de Sessão.
 *
 * @author Eduarda de Brum Lucena
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sessao implements Serializable {

    private static final long serialVersionUID = 2994313036099064656L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SESSAO")
    private Integer idSessao;

    @Column(name = "DATA_INICIO_SESSAO")
    private LocalDateTime dataInicioSessao;

    @Column(name = "DATA_FIM_SESSAO")
    private LocalDateTime dataFimSessao;

    @NotNull(message = "Duração é Obrigatória")
    @Column(name = "DURACAO")
    private Integer duracao;

    @NotNull()
    @Convert(converter = StatusSessaoEnumConverter.class)
    @Column(name = "STATUS_SESSAO")
    private StatusSessaoEnum statusSessaoEnum;

}
