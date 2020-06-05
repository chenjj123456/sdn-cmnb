package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/8/5
 */
public enum OperateStatus {
    /**
     * operate up.
     *
     */
    @XmlElement(name ="operate-up" )
    OperateUp(0, "operate-up"),

    /**
     * operate down.
     *
     */
    @XmlElement(name = "operate-down")
    OperateDown(1, "operate-down")
    ;


    java.lang.String name;
    int value;
    private static final java.util.Map<java.lang.Integer, OperateStatus> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, OperateStatus> b = com.google.common.collect.ImmutableMap.builder();
        for (OperateStatus enumItem : OperateStatus.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private OperateStatus(int value, java.lang.String name) {
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
     * @return corresponding OperateStatus item
     */
    public static OperateStatus forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
