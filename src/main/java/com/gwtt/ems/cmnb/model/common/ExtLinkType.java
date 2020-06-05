package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/4
 */
public enum ExtLinkType {
    /**
     * nni-nni
     *
     */
    @XmlElement(name = "nni")
    Nni(1, "nni"),

    /**
     * uni-uni
     *
     */
    @XmlElement(name = "uni")
    Uni(2, "uni"),

    /**
     * nni-nni and uni-uni
     *
     */
    @XmlElement(name = "nni-and-uni")
    NniAndUni(3, "nni-and-uni")
    ;


    java.lang.String name;
    int value;
    private static final java.util.Map<java.lang.Integer, ExtLinkType> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, ExtLinkType> b = com.google.common.collect.ImmutableMap.builder();
        for (ExtLinkType enumItem : ExtLinkType.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private ExtLinkType(int value, java.lang.String name) {
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
     * @return corresponding ExtLinkType item
     */
    public static ExtLinkType forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
