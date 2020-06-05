package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/16
 */
public enum Role {
    /**
     * master.default "master"
     *
     */
    @XmlElement(name = "master")
    Master(0, "master"),

    /**
     * slave.
     *
     */
    @XmlElement(name = "slave")
    Slave(1, "slave"),

    /**
     * restore.
     *
     */
    @XmlElement(name = "restore")
    Restore(2, "restore"),

    /**
     * master-restore.
     *
     */
    @XmlElement(name = "master-restore")
    MasterRestore(3, "master-restore"),

    /**
     * slave-restore.
     *
     */
    @XmlElement(name = "slave-restore")
    SlaveRestore(4, "slave-restore")
    ;


    java.lang.String name;
    int value;
    private static final java.util.Map<java.lang.Integer, Role> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, Role> b = com.google.common.collect.ImmutableMap.builder();
        for (Role enumItem : Role.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private Role(int value, java.lang.String name) {
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
    public static Role forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
