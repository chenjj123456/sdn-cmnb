package com.gwtt.ems.cmnb.model.common;

/**
 * Created by chenjj on 2019/9/4
 */
public enum SubLayerRate {
    /**
     * lsp
     */
    Lsp(201, "lsp"),

    /**
     * pw
     */
    Pw(202, "pw"),

    /**
     * ethernet
     */
    Ethernet(203, "ethernet");


    java.lang.String name;
    int value;
    private static final java.util.Map<java.lang.Integer, SubLayerRate> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, SubLayerRate> b = com.google.common.collect.ImmutableMap.builder();
        for (SubLayerRate enumItem : SubLayerRate.values()) {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private SubLayerRate(int value, java.lang.String name) {
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
     * @return corresponding SubLayerRate item
     */
    public static SubLayerRate forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
