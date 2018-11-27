package com.sicredidigitalpautas.eduardabrum.enumerator.converter;

import com.sicredidigitalpautas.eduardabrum.enumerator.StatusSessaoEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import javax.persistence.Converter;
import java.util.Objects;

/**
 * Classe que converter o valor do banco para o enum ou o enum para o valor a ser persistido no banco.
 *
 * @author Eduarda de Brum Lucena
 */
@Converter
public class StatusSessaoEnumConverter implements AttributeConverter<StatusSessaoEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(StatusSessaoEnum statusSessaoEnum) {
        return Objects.isNull(statusSessaoEnum) ? null : statusSessaoEnum.getCode();
    }

    @Override
    public StatusSessaoEnum convertToEntityAttribute(Integer codeStatus) {
        return Objects.isNull(codeStatus) ? null : StatusSessaoEnum.getValue(codeStatus);
    }
}
