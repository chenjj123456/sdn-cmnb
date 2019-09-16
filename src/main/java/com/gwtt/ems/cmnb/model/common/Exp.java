package com.gwtt.ems.cmnb.model.common;

/**
 * Created by chenjj on 2019/9/16
 */
public enum Exp {
    /**
     * BE.
     *
     */
    BE(0, "BE"),

    /**
     * AF1.
     *
     */
    AF1(1, "AF1"),

    /**
     * AF2.
     *
     */
    AF2(2, "AF2"),

    /**
     * AF3.
     *
     */
    AF3(3, "AF3"),

    /**
     * AF4.
     *
     */
    AF4(4, "AF4"),

    /**
     * EF.
     *
     */
    EF(5, "EF"),

    /**
     * CS6.'
     *
     */
    CS6(6, "CS6"),

    /**
     * CS7.'
     *
     */
    CS7(7, "CS7")
    ;


    java.lang.String name;
    int value;
    private static final java.util.Map<java.lang.Integer, Exp> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, Exp> b = com.google.common.collect.ImmutableMap.builder();
        for (Exp enumItem : Exp.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private Exp(int value, java.lang.String name) {
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
     * @return corresponding Exp item
     */
    public static Exp forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
