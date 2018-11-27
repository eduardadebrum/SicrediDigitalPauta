package com.sicredidigitalpautas.eduardabrum.controller;

import com.sicredidigitalpautas.eduardabrum.entity.Eleitor;
import com.sicredidigitalpautas.eduardabrum.service.EleitorService;
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
 * Classe Rest Controller para os serviços relacionados ao {@link Eleitor}.
 *
 * @author Eduarda de Brum Lucena
 */
@Api(description = "Esse é o Serviço do Eleitor.")

@RestController
public class EleitorController {

    private final EleitorService eleitorService;

    @Autowired
    public EleitorController(EleitorService eleitorService) {
        this.eleitorService = eleitorService;
    }

    @ApiOperation(
            value = "Cadastro de Eleitor.",
            notes = "Cadastra as informações relacionadas ao Associado.")

    @PostMapping("/eleitor")
    public Eleitor save(@Valid @RequestBody Eleitor eleitor) {
        return eleitorService.save(eleitor);
    }

    @ApiOperation(
            value = "Lista de Associados.",
            notes = "Busca todos os associados cadastrados.")

    @GetMapping("/associados")
    public List<Eleitor> findAllEleitor() {
        return eleitorService.findAllEleitor();
    }
}
