package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/8/5
 */
public enum AdminStatus {
    /**
     * admin up.
     *
     */
    @XmlElement(name = "admin-up")
    AdminUp(0, "admin-up"),

    /**
     * admin down.
     *
     */
    @XmlElement(name = "admin-down")
    AdminDown(1, "admin-down")
    ;


    java.lang.String name;
    int value;
    private static final java.util.Map<java.lang.Integer, AdminStatus> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, AdminStatus> b = com.google.common.collect.ImmutableMap.builder();
        for (AdminStatus enumItem : AdminStatus.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private AdminStatus(int value, java.lang.String name) {
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
     * @return corresponding AdminStatus item
     */
    public static AdminStatus forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }

}
