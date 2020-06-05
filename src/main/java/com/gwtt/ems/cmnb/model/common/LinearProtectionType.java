package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/16
 */
public enum LinearProtectionType {
    /**
     * unprotected.
     *
     */
    @XmlElement(name = "unprotected")
    Unprotected(0, "unprotected"),

    /**
     * 1:1 path protection.
     *
     */
    @XmlElement(name = "path-protection-1-to-1")
    PathProtection1To1(1, "path-protection-1-to-1"),

    /**
     * 1+1 path protection.
     *
     */
    @XmlElement(name = "path-protection-1-plus-1")
    PathProtection1Plus1(2, "path-protection-1-plus-1"),

    /**
     * No protection with recovery.
     *
     */
    @XmlElement(name = "unprotected-with-recovery")
    UnprotectedWithRecovery(3, "unprotected-with-recovery"),

    /**
     * 1:1 with recovery.
     *
     */
    @XmlElement(name = "with-recovery-1-to-1")
    WithRecovery1To1(4, "with-recovery-1-to-1"),

    /**
     * 1+1 with recovery.
     *
     */
    @XmlElement(name = "with-recovery-1-plus-1")
    WithRecovery1Plus1(5, "with-recovery-1-plus-1"),

    /**
     * Permanent 1:1 protection.
     *
     */
    @XmlElement(name = "permanent-1-to-1-protection")
    Permanent1To1Protection(6, "permanent-1-to-1-protection"),

    /**
     * manual confirmation Permanent 1:1 protection.
     *
     */
    @XmlElement(name = "manual-confirmation-Permanent-1-to-1-protection")
    ManualConfirmationPermanent1To1Protection(7, "manual-confirmation-Permanent-1-to-1-protection")
    ;


    java.lang.String name;
    int value;
    private static final java.util.Map<java.lang.Integer, LinearProtectionType> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, LinearProtectionType> b = com.google.common.collect.ImmutableMap.builder();
        for (LinearProtectionType enumItem : LinearProtectionType.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private LinearProtectionType(int value, java.lang.String name) {
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
     * @return corresponding LinearProtectionType item
     */
    public static LinearProtectionType forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
