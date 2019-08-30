package com.gwtt.ems.cmnb.model.north.event;

import com.gwtt.ems.cmnb.model.common.UpdateType;
import com.gwtt.ems.cmnb.model.north.CmnbBaseData;

/**
 * Created by chenjj on 2019/8/29
 */
public class EventInQueque {
    private PushEventType pushEventType;
    private UpdateType eventUpdateType;
    private CmnbBaseData pushEventData;

    public PushEventType getPushEventType() {
        return pushEventType;
    }

    public void setPushEventType(PushEventType pushEventType) {
        this.pushEventType = pushEventType;
    }

    public UpdateType getEventUpdateType() {
        return eventUpdateType;
    }

    public void setEventUpdateType(UpdateType eventUpdateType) {
        this.eventUpdateType = eventUpdateType;
    }

    public CmnbBaseData getPushEventData() {
        return pushEventData;
    }

    public void setPushEventData(CmnbBaseData pushEventData) {
        this.pushEventData = pushEventData;
    }
}
