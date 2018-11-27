package com.sicredidigitalpautas.eduardabrum.controller;

import com.sicredidigitalpautas.eduardabrum.domain.PautaDomain;
import com.sicredidigitalpautas.eduardabrum.entity.Pauta;
import com.sicredidigitalpautas.eduardabrum.service.PautaService;
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
 * Classe Rest Controller para os serviços relacionados ao {@link Pauta}.
 *
 * @author Eduarda de Brum Lucena
 */
@Api(description = "Esse é o Serviço da Pauta.")

@RestController
public class PautaController {

    private final PautaService pautaService;

    @Autowired
    public PautaController(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @ApiOperation(
            value = "Cadastro da Pauta.",
            notes = "Cadastra as informações relacionadas a Pauta.")

    @PostMapping("/pauta")
    public Pauta save(@Valid @RequestBody PautaDomain pautaDomain) {
        return pautaService.save(pautaDomain);
    }

    @ApiOperation(
            value = "Lista de Pautas.",
            notes = "Busca Todas as Pautas Cadastradas.")

    @GetMapping("/pautas")
    public List<Pauta> findAllPauta() {
        return pautaService.findAllPauta();
    }

}
