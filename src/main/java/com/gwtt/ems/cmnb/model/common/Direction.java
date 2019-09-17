package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/4
 */
public enum Direction {
    /**
     * unidirectional
     *
     */
    @XmlElement(name = "unidirectional")
    Unidirectional(0, "unidirectional"),

    /**
     * bidirectional,default "bidirection"
     *
     */
    @XmlElement(name = "bidirectional")
    Bidirectional(1, "bidirectional")
    ;


    java.lang.String name;
    int value;
    private static final java.util.Map<java.lang.Integer, Direction> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, Direction> b = com.google.common.collect.ImmutableMap.builder();
        for (Direction enumItem : Direction.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private Direction(int value, java.lang.String name) {
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
     * @return corresponding Direction item
     */
    public static Direction forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
