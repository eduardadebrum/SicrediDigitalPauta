package com.sicredidigitalpautas.eduardabrum.controller;

import com.sicredidigitalpautas.eduardabrum.domain.SessaoDomain;
import com.sicredidigitalpautas.eduardabrum.entity.Sessao;
import com.sicredidigitalpautas.eduardabrum.service.SessaoService;
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
 * Classe Rest Controller para os serviços relacionados ao {@link Sessao}.
 *
 * @author Eduarda de Brum Lucena
 */

@Api(description = "Esse é o Serviço Sessão.")

@RestController
public class SessaoController {

    private final SessaoService sessaoService;

    @Autowired
    public SessaoController(SessaoService sessaoService) {
        this.sessaoService = sessaoService;
    }

    @ApiOperation(
            value = "Cadastro da Sessão.",
            notes = "Todo cadastro de sessão precisa ter uma pauta associada.")

    @PostMapping("/sessao")
    public Sessao save(@Valid @RequestBody SessaoDomain sessaoDomain) {
        return sessaoService.save(sessaoDomain);
    }

    @ApiOperation(
            value = "Lista de Sessão.",
            notes = "Busca Todas as Sessão Cadastradas.")


    @GetMapping("/sessoes")
    public List<Sessao> findAll() {
        return sessaoService.findAllSessao();
    }

    @ApiOperation(
            value = "Abrir Sessão.",
            notes = "Abre uma Sessão para Votação")

    @PostMapping("/sessao/abertura/")
    public Sessao openSessao(@Valid @RequestBody Integer idSessao) {
        return sessaoService.abrirSessaoParaVotacao(idSessao);
    }
}
