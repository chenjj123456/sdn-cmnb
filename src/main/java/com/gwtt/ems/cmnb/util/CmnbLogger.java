package com.gwtt.ems.cmnb.util;

import com.gwtt.management.log.DefaultLogUser;
import com.gwtt.management.log.Log;
import com.gwtt.management.log.LogMgr;
import com.gwtt.management.log.LogUser;

/**
 * Created by chenjj on 2019/8/19
 */

public class CmnbLogger {

    public static void init() {
        CMNBOUT = LogMgr.getLogUser("CMNBOUT");
        CMNBERR = LogMgr.getLogUser("CMNBERR");
        if (CMNBOUT == null) {
            CMNBOUT = new DefaultLogUser(null, Log.VERBOSE, null);
        }
        if (CMNBERR == null) {
            CMNBERR = new DefaultLogUser(null, Log.VERBOSE, null);
        }
    }
    public static LogUser CMNBOUT = new DefaultLogUser(null, Log.VERBOSE, null);
    public static LogUser CMNBERR = new DefaultLogUser(null, Log.VERBOSE, null);
}