package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/18
 */
public enum TunnelUsePolicy {
    /**
     * monopolize tunnel,default monopolize
     *
     */
    @XmlElement(name = "monopolize")
    Monopolize(0, "monopolize"),

    /**
     * dni share tunnel
     *
     */
    @XmlElement(name = "dni-share")
    DniShare(1, "dni-share")
    ;


    java.lang.String name;
    int value;
    private static final java.util.Map<java.lang.Integer, TunnelUsePolicy> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, TunnelUsePolicy> b = com.google.common.collect.ImmutableMap.builder();
        for (TunnelUsePolicy enumItem : TunnelUsePolicy.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private TunnelUsePolicy(int value, java.lang.String name) {
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
     * @return corresponding TunnelUsePolicy item
     */
    public static TunnelUsePolicy forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
