package com.gwtt.ems.cmnb.model.north.notification;

import com.gwtt.ems.cmnb.model.north.event.Adds;
import com.gwtt.ems.cmnb.model.north.event.Deletes;
import com.gwtt.ems.cmnb.model.north.event.Updates;

/**
 * Created by chenjj on 2019/9/18
 */
public class SncLspNotification {
    private Adds adds;
    private Updates updates;
    private Deletes deletes;

    public Adds getAdds() {
        return adds;
    }

    public void setAdds(Adds adds) {
        this.adds = adds;
    }

    public Updates getUpdates() {
        return updates;
    }

    public void setUpdates(Updates updates) {
        this.updates = updates;
    }

    public Deletes getDeletes() {
        return deletes;
    }

    public void setDeletes(Deletes deletes) {
        this.deletes = deletes;
    }
}
