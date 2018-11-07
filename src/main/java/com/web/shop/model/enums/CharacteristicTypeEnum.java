package com.web.shop.model.enums;

public enum CharacteristicTypeEnum {

    BOOLEAN("BooleanCharacteristics"),
    INTEGER("IntegerCharacteristics"),
    DOUBLE("DoubleCharacteristics"),
    STRING("StringCharacteristics"),
    CHECKBOX("CheckboxCharacteristics");

    String characteristicType;

    CharacteristicTypeEnum(String characteristicType){
        this.characteristicType = characteristicType;
    }

}
