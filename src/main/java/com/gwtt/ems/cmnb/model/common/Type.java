package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/16
 */
public enum Type {
    /**
     * PE-PE.default "PE-PE"
     *
     */
    @XmlElement(name = "PE-PE")
    PEPE(0, "PE-PE"),

    /**
     * PE-P.
     *
     */
    @XmlElement(name = "PE-P")
    PEP(1, "PE-P"),

    /**
     * P-P.
     *
     */
    @XmlElement(name = "P-P")
    PP(2, "P-P"),

    /**
     * P-PE.
     *
     */
    @XmlElement(name = "P-PE")
    PPE(3, "P-PE")
    ;


    java.lang.String name;
    int value;
    private static final java.util.Map<java.lang.Integer, Type> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, Type> b = com.google.common.collect.ImmutableMap.builder();
        for (Type enumItem : Type.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private Type(int value, java.lang.String name) {
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
     * @return corresponding Type item
     */
    public static Type forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
