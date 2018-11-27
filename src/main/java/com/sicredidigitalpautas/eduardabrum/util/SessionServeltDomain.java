package com.sicredidigitalpautas.eduardabrum.util;

import com.sicredidigitalpautas.eduardabrum.entity.Sessao;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

public class SessionServeltDomain {

    private ServletRequestAttributes servletRequestAttributes;

    private static final String SESSAO_ANDAMENTO = "SESSAO_ANDAMENTO";

    public SessionServeltDomain() {
        this.servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
    }

    public Sessao getSessao() {
        Object attribute = servletRequestAttributes.getAttribute(SESSAO_ANDAMENTO, 1);
        return Objects.nonNull(attribute) ? (Sessao) attribute : null;
    }

    public void createOrKillSessao(Sessao sessao) {
        servletRequestAttributes.setAttribute(SESSAO_ANDAMENTO, sessao, 1);
    }


}
