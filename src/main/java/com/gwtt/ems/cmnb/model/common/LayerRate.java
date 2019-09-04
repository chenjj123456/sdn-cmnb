package com.gwtt.ems.cmnb.model.common;

/**
 * Created by chenjj on 2019/9/4
 */
public enum LayerRate {
    /**
     * optical
     */
    Optical(0, "optical"),

    /**
     * physical
     */
    Physical(1, "physical"),

    /**
     * datalink
     */
    Datalink(2, "datalink"),

    /**
     * ip
     */
    Ip(3, "ip");

    java.lang.String name;
    int value;
    private static final java.util.Map<java.lang.Integer, LayerRate> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, LayerRate> b = com.google.common.collect.ImmutableMap.builder();
        for (LayerRate enumItem : LayerRate.values()) {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private LayerRate(int value, java.lang.String name) {
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
     * @return corresponding LayerRate item
     */
    public static LayerRate forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
