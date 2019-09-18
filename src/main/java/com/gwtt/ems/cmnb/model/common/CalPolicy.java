package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/18
 */
public enum CalPolicy {
    /**
     * Minimum Hop,default min-hop
     *
     */
    @XmlElement(name = "min-hop")
    MinHop(0, "min-hop"),

    /**
     * bandwidth balancing
     *
     */
    @XmlElement(name = "bandwidth-balancing")
    BandwidthBalancing(1, "bandwidth-balancing"),

    /**
     * Minimum Latency
     *
     */
    @XmlElement(name = "min-latency")
    MinLatency(2, "min-latency")
    ;


    java.lang.String name;
    int value;
    private static final java.util.Map<java.lang.Integer, CalPolicy> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, CalPolicy> b = com.google.common.collect.ImmutableMap.builder();
        for (CalPolicy enumItem : CalPolicy.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private CalPolicy(int value, java.lang.String name) {
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
     * @return corresponding CalPolicy item
     */
    public static CalPolicy forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
