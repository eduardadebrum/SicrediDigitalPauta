package com.sicredidigitalpautas.eduardabrum.controller;

import com.sicredidigitalpautas.eduardabrum.domain.VotacaoDomain;
import com.sicredidigitalpautas.eduardabrum.domain.VotacaoResulDomain;
import com.sicredidigitalpautas.eduardabrum.entity.Votacao;
import com.sicredidigitalpautas.eduardabrum.service.VotacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.validation.Valid;

/**
 * Classe Rest Controller para os serviços relacionados ao {@link com.sicredidigitalpautas.eduardabrum.entity.Votacao}.
 *
 * @author Eduarda de Brum Lucena
 */
@Api(description = "Esse é o Serviço para Votação.")

@RestController
public class VotacaoController {


    private final VotacaoService votacaoService;

    @Autowired
    public VotacaoController(VotacaoService votacaoService) {
        this.votacaoService = votacaoService;
    }

    @ApiOperation(
            value = "Cadastro da Votação.",
            notes = "Executa o processo de voto.")

    @PostMapping("/votar")
    public Votacao votarSessao(@Valid @RequestBody VotacaoDomain votacaoDomain) {
        return votacaoService.votarSessao(votacaoDomain);
    }


    @ApiOperation(
            value = "Lista de Sessão.",
            notes = "Busca Todas as Sessão Cadastradas.")

    @GetMapping("/votacao")
    public List<VotacaoResulDomain> findAll() {
        return votacaoService.findAllVotacao();
    }
}
