package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/18
 */
public enum CalculateType {

    @XmlElement(name = "strict-separate")
    StrictSeparate(0, "strict-separate"),

    @XmlElement(name = "besteffort-separate")
    BesteffortSeparate(1, "besteffort-separate")
    ;


    java.lang.String name;
    int value;
    private static final java.util.Map<java.lang.Integer, CalculateType> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, CalculateType> b = com.google.common.collect.ImmutableMap.builder();
        for (CalculateType enumItem : CalculateType.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private CalculateType(int value, java.lang.String name) {
        this.value = value;
        this.name = name;
    }

    /**
     * Returns the name of the enumeration item as it is specified in the input yang.
     *
     * @return the name of the enumeration item as it is specified in the input yang
     */
    public java.lang.String getName() {
        return name;
    }

    /**
     * @return integer value
     */
    public int getIntValue() {
        return value;
    }

    /**
     * @param valueArg
     * @return corresponding CalculateType item
     */
    public static CalculateType forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
