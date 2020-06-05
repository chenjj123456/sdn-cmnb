package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/4
 */
public enum NodeType {
    /**
     * physical
     *
     */
    @XmlElement(name = "physical")
    Physical(0, "physical"),

    /**
     * virtual
     *
     */

    @XmlElement(name = "virtual")
    Virtual(1, "virtual"),

    /**
     * container
     *
     */
    @XmlElement(name = "container")
    Container(2, "container")
    ;


    java.lang.String name;
    int value;
    private static final java.util.Map<java.lang.Integer, NodeType> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, NodeType> b = com.google.common.collect.ImmutableMap.builder();
        for (NodeType enumItem : NodeType.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private NodeType(int value, java.lang.String name) {
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
     * @return corresponding NodeType item
     */
    public static NodeType forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
