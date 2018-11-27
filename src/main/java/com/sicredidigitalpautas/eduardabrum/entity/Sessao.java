package com.sicredidigitalpautas.eduardabrum.entity;

import com.sicredidigitalpautas.eduardabrum.enumerator.StatusSessaoEnum;
import com.sicredidigitalpautas.eduardabrum.enumerator.converter.StatusSessaoEnumConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;


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
@EqualsAndHashCode(exclude = {"pauta"})
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

    @Convert(converter = StatusSessaoEnumConverter.class)
    @Column(name = "STATUS_SESSAO")
    private StatusSessaoEnum statusSessaoEnum;

    @OneToOne(mappedBy = "sessao", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Pauta pauta;
}
