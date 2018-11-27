package com.sicredidigitalpautas.eduardabrum.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Classe de Mapeamento para a tabela de Eleitor.
 *
 * @author Eduarda de Brum Lucena
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Eleitor implements Serializable {

    private static final long serialVersionUID = -580732599985538225L;

    @Id
    @CPF(message = "Cpf Inválido")
    @Column(name = "CPF")
    @NotBlank(message = "O Cpf é Obrigatório")
    private String cpf;

    @NotBlank(message = "O Nome é Obrigatório")
    @Column(name = "NOME")
    private String nome;

}
