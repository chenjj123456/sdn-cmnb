package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/16
 */
public enum RerouteRevertiveMode {
    /**
     * no revertive.
     *
     */
    @XmlElement(name = "no-revertive")
    NoRevertive(0, "no-revertive"),

    /**
     * revertive.
     *
     */
    @XmlElement(name = "revertive")
    Revertive(1, "revertive")
    ;


    java.lang.String name;
    int value;
    private static final java.util.Map<java.lang.Integer, RerouteRevertiveMode> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, RerouteRevertiveMode> b = com.google.common.collect.ImmutableMap.builder();
        for (RerouteRevertiveMode enumItem : RerouteRevertiveMode.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private RerouteRevertiveMode(int value, java.lang.String name) {
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
     * @return corresponding RerouteRevertiveMode item
     */
    public static RerouteRevertiveMode forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
