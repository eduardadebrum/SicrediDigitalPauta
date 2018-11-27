package com.sicredidigitalpautas.eduardabrum.enumerator;


import java.util.Arrays;
import java.util.Objects;

/**
 * Enumerador contendo os possíveis Status da Sessão.
 *
 * @author Eduarda de Brum Lucena
 */
public enum StatusSessaoEnum {

    ABERTO(1, "Aberto"),
    ANDAMENTO(2, "Andamento"),
    FECHADA(3, "Fechada");

    private Integer code;
    private String status;

    StatusSessaoEnum(Integer code, String status) {
        this.code = code;
        this.status = status;
    }

    /**
     * Busca o enumerator conforme o código informado.
     *
     * @param code Código Informado.
     * @return o objeto {@link StatusSessaoEnum}
     */
    public static StatusSessaoEnum getValue(Integer code) {
        return Arrays.stream(StatusSessaoEnum.values())
                .filter(statusSessao -> Objects.equals(statusSessao.getCode(), code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Código Sessão não existe" + code));
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
