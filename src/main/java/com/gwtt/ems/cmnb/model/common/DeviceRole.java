package com.gwtt.ems.cmnb.model.common;

/**
 * Created by chenjj on 2019/9/20
 */
public enum DeviceRole {

    /**
     * PE node.
     *
     */
    PE(0, "PE"),

    /**
     * P node.
     *
     */
    P(1, "P")
    ;


    java.lang.String name;
    int value;
    private static final java.util.Map<java.lang.Integer, DeviceRole> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, DeviceRole> b = com.google.common.collect.ImmutableMap.builder();
        for (DeviceRole enumItem : DeviceRole.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private DeviceRole(int value, java.lang.String name) {
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
     * @return corresponding Role item
     */
    public static DeviceRole forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
