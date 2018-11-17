package com.web.shop.model.enums;

public enum CharacteristicType {

    BOOLEAN("BooleanCharacteristics"),
    INTEGER("IntegerCharacteristics"),
    DOUBLE("DoubleCharacteristics"),
    STRING("StringCharacteristics"),
    CHECKBOX("CheckboxCharacteristics");

    String characteristicType;

    CharacteristicType(String characteristicType){
        this.characteristicType = characteristicType;
    }

}
