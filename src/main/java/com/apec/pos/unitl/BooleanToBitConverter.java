package com.apec.pos.unitl;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class BooleanToBitConverter implements AttributeConverter<Boolean, Byte> {

    @Override
    public Byte convertToDatabaseColumn(Boolean attribute) {
        if (attribute == null) {
            return null;
        }
        return (byte) (attribute ? 1 : 0);
    }

    @Override
    public Boolean convertToEntityAttribute(Byte dbData) {
        if (dbData == null) {
            return null;
        }
        return dbData == 1;
    }
}
