package com.sicredidigitalpautas.eduardabrum.service;

import com.sicredidigitalpautas.eduardabrum.domain.VotacaoDomain;
import com.sicredidigitalpautas.eduardabrum.entity.Votacao;

import java.util.List;

public interface VotacaoService {

    Votacao votarSessao(VotacaoDomain votacaoDomain);

    List findAllVotacao();
}
