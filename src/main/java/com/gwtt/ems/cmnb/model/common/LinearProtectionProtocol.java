package com.gwtt.ems.cmnb.model.common;

/**
 * Created by chenjj on 2019/9/16
 */
public enum LinearProtectionProtocol {
    /**
     * APS.
     *
     */
    APS(0, "APS"),

    /**
     * PSC.
     *
     */
    PSC(1, "PSC")
    ;


    java.lang.String name;
    int value;
    private static final java.util.Map<java.lang.Integer, LinearProtectionProtocol> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, LinearProtectionProtocol> b = com.google.common.collect.ImmutableMap.builder();
        for (LinearProtectionProtocol enumItem : LinearProtectionProtocol.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private LinearProtectionProtocol(int value, java.lang.String name) {
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
     * @return corresponding LinearProtectionProtocol item
     */
    public static LinearProtectionProtocol forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
