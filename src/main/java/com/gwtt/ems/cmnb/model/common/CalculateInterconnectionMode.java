package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/18
 */
public enum CalculateInterconnectionMode {
    /**
     * nni-nni
     *
     */
    @XmlElement(name = "nni-nni")
    NniNni(1, "nni-nni"),

    /**
     * uni-uni
     *
     */
    @XmlElement(name = "uni-uni")
    UniUni(2, "uni-uni")
    ;


    java.lang.String name;
    int value;
    private static final java.util.Map<java.lang.Integer, CalculateInterconnectionMode> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, CalculateInterconnectionMode> b = com.google.common.collect.ImmutableMap.builder();
        for (CalculateInterconnectionMode enumItem : CalculateInterconnectionMode.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private CalculateInterconnectionMode(int value, java.lang.String name) {
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
     * @return corresponding CalculateInterconnectionMode item
     */
    public static CalculateInterconnectionMode forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
