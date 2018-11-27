package com.sicredidigitalpautas.eduardabrum.enumerator;

import java.util.Arrays;
import java.util.Objects;

/**
 * Enumerador contendo as informações de Sim ou Não.
 *
 * @author Eduarda de Brum Lucena
 */
public enum SimOrNaoEnum {

    SIM(1, "Sim"),
    NAO(0, "Não");

    private Integer value;
    private String descricao;

    SimOrNaoEnum(Integer value, String descricao) {
        this.value = value;
        this.descricao = descricao;
    }

    /**
     * Busca o enumerator conforme o código informado.
     *
     * @param code Código Informado.
     * @return o objeto {@link SimOrNaoEnum}
     */
    public static SimOrNaoEnum getValue(Integer code) {
        return Arrays.stream(SimOrNaoEnum.values())
                .filter(statusSessao -> Objects.equals(statusSessao.getValue(), code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Código não existe" + code));
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
