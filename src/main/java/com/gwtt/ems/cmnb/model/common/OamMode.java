package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/16
 */
public enum OamMode {
    /**
     * disable.
     *
     */
    @XmlElement(name = "disable")
    Disable(0, "disable"),

    /**
     * preactive.
     *
     */
    @XmlElement(name = "preactive")
    Preactive(1, "preactive"),

    /**
     * on-demand.
     *
     */
    @XmlElement(name = "on-demand")
    OnDemand(2, "on-demand")
    ;


    java.lang.String name;
    int value;
    private static final java.util.Map<java.lang.Integer, OamMode> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, OamMode> b = com.google.common.collect.ImmutableMap.builder();
        for (OamMode enumItem : OamMode.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private OamMode(int value, java.lang.String name) {
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
     * @return corresponding OamMode item
     */
    public static OamMode forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
