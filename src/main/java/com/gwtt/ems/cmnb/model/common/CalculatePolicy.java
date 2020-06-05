package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/18
 */
public enum CalculatePolicy {
    @XmlElement(name = "master")
    Master(0, "master"),

    @XmlElement(name = "master-and-slave")
    MasterAndSlave(1, "master-and-slave")
    ;


    java.lang.String name;
    int value;
    private static final java.util.Map<java.lang.Integer, CalculatePolicy> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, CalculatePolicy> b = com.google.common.collect.ImmutableMap.builder();
        for (CalculatePolicy enumItem : CalculatePolicy.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private CalculatePolicy(int value, java.lang.String name) {
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
     * @return corresponding CalculatePolicy item
     */
    public static CalculatePolicy forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
