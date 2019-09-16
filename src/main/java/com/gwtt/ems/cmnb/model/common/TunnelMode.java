package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/16
 */
public enum TunnelMode {
    /**
     * pipeline.
     *
     */
    @XmlElement(name = "pipeline")
    Pipeline(1, "pipeline"),

    /**
     * short pipeline.
     *
     */
    @XmlElement(name = "short-pipeline")
    ShortPipeline(2, "short-pipeline"),

    /**
     * unified pattern.
     *
     */
    @XmlElement(name = "unified-pattern")
    UnifiedPattern(3, "unified-pattern")
    ;


    java.lang.String name;
    int value;
    private static final java.util.Map<java.lang.Integer, TunnelMode> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, TunnelMode> b = com.google.common.collect.ImmutableMap.builder();
        for (TunnelMode enumItem : TunnelMode.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private TunnelMode(int value, java.lang.String name) {
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
     * @return corresponding TunnelMode item
     */
    public static TunnelMode forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
