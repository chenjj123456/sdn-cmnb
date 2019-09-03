package com.gwtt.ems.cmnb.southInterface.eventListener;

import com.gwtt.ems.cmnb.model.north.event.EventInQueque;
import com.gwtt.ems.cmnb.model.north.event.PushEventType;
import com.gwtt.ems.cmnb.model.north.resources.ltp.Ltp;
import com.gwtt.ems.cmnb.model.north.resources.ne.NeNode;
import com.gwtt.ems.cmnb.model.south.EmsBaseData;
import com.gwtt.ems.cmnb.model.south.resources.LtpData;
import com.gwtt.ems.cmnb.model.south.resources.NeData;
import com.gwtt.ems.cmnb.northInterface.CmnbEventPush;
import com.gwtt.ems.cmnb.util.CmnbUtil;

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
    public void update(CmnbEvent cmnbEvent) {
        EventInQueque eventInQueque=new EventInQueque();
        eventInQueque.setEventUpdateType(cmnbEvent.getUpdateType());

        EmsBaseData emsBaseData=new EmsBaseData();
        switch (cmnbEvent.getUpdateType()){
            case Add:
                emsBaseData=cmnbEvent.getNewObj();
                break;
            case Update:
                emsBaseData=cmnbEvent.getNewObj();
                break;
            case Delete:
                emsBaseData=cmnbEvent.getOldObj();
                break;
        }

        switch (cmnbEvent.getObjType()){
            case Ncd:
                break;
            case Ne:
                eventInQueque.setPushEventType(PushEventType.Ne);
                NeNode neNode=CmnbUtil.parserNeDataToNeNode((NeData)emsBaseData);
                eventInQueque.setPushEventData(neNode);
                break;
            case Ltp:
                eventInQueque.setPushEventType(PushEventType.Ltp);
                Ltp ltp=CmnbUtil.parserLtpData((LtpData)emsBaseData);
                eventInQueque.setPushEventData(ltp);
                break;
            case TopoLink:
                break;


        }

        CmnbEventPush.getInstance().addEvent(eventInQueque);

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
