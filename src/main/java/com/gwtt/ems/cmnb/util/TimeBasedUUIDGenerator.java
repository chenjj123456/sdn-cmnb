package com.gwtt.ems.cmnb.util;

import java.util.UUID;

public class TimeBasedUUIDGenerator {

    public static final Object LOCK = new Object();

    private static long lastTime;
    private static long clockSequence = 0;

    public final static UUID generateIdFromTimestamp(long timestamp, long hostid) {

//        synchronized (LOCK) {
//            if (timestamp > lastTime) {
//                lastTime = timestamp;
//                clockSequence = 0;
//            } else {
//                ++clockSequence;
//            }
//        }
//
//        long time = timestamp;

        //暂时固定UUID
        timestamp = 0;
        long time = timestamp;

        // low Time
        time = timestamp << 32;

        // mid Time
        time |= ((timestamp & 0xFFFF00000000L) >> 16);

        // hi Time
        time |= 0x1000 | ((timestamp >> 48) & 0x0FFF);

        long clockSequenceHi = clockSequence;

        clockSequenceHi <<= 48;

        long lsb = clockSequenceHi | hostid;

        return new UUID(time, lsb);
    }

}
