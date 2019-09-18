package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/18
 */
public enum CalculateMode {
    /**
     * one-one
     *
     */
    @XmlElement(name = "simple")
    Simple(0, "simple"),

    /**
     * one-two
     *
     */
    @XmlElement(name = "add-drop")
    AddDrop(1, "add-drop"),

    /**
     * two-two
     *
     */
    @XmlElement(name = "double-drop")
    DoubleDrop(2, "double-drop")
    ;


    java.lang.String name;
    int value;
    private static final java.util.Map<java.lang.Integer, CalculateMode> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, CalculateMode> b = com.google.common.collect.ImmutableMap.builder();
        for (CalculateMode enumItem : CalculateMode.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private CalculateMode(int value, java.lang.String name) {
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
     * @return corresponding CalculateMode item
     */
    public static CalculateMode forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
