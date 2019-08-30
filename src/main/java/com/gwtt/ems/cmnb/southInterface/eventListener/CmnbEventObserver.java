package com.gwtt.ems.cmnb.southInterface.eventListener;

import java.util.Vector;

/**
 * Created by chenjj on 2019/8/23
 */
public class CmnbEventObserver implements CmnbEventListener {
    private static CmnbEventObserver instance;

    public static synchronized CmnbEventObserver getInstance() {
        if (null == instance) {
            instance = new CmnbEventObserver();
        }
        return instance;
    }

    @Override
    public void update(CmnbEvent event) {

    }

    @Override
    public void update(Vector vector) {
        for (int i = 0; i < vector.size(); i++) {
            CmnbEvent event = (CmnbEvent) vector.elementAt(i);
            if (event != null) {
                update(event);
            }
        }
    }
}
