package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/16
 */
public enum SwitchMode {
    /**
     * Single-ended switch.
     *
     */
    @XmlElement(name = "single-ended-switch")
    SingleEndedSwitch(0, "single-ended-switch"),

    /**
     * double end switch.
     *
     */
    @XmlElement(name = "double-end-switch")
    DoubleEndSwitch(1, "double-end-switch")
    ;


    java.lang.String name;
    int value;
    private static final java.util.Map<java.lang.Integer, SwitchMode> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, SwitchMode> b = com.google.common.collect.ImmutableMap.builder();
        for (SwitchMode enumItem : SwitchMode.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private SwitchMode(int value, java.lang.String name) {
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
     * @return corresponding SwitchMode item
     */
    public static SwitchMode forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
