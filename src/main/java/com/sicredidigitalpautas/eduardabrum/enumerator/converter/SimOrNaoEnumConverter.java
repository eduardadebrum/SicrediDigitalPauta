package com.sicredidigitalpautas.eduardabrum.enumerator.converter;

import com.sicredidigitalpautas.eduardabrum.enumerator.SimOrNaoEnum;
import com.sicredidigitalpautas.eduardabrum.enumerator.StatusSessaoEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

/**
 * Classe que converter o valor do banco para o enum ou o enum para o valor a ser persistido no banco.
 *
 * @author Eduarda de Brum Lucena
 */
@Converter
public class SimOrNaoEnumConverter implements AttributeConverter<SimOrNaoEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(SimOrNaoEnum simOrNaoEnum) {
        return Objects.isNull(simOrNaoEnum) ? null : simOrNaoEnum.getValue();
    }

    @Override
    public SimOrNaoEnum convertToEntityAttribute(Integer codeStatus) {
        return Objects.isNull(codeStatus) ? null : SimOrNaoEnum.getValue(codeStatus);
    }
}
