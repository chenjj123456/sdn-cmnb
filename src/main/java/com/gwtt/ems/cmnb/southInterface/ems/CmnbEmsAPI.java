package com.gwtt.ems.cmnb.southInterface.ems;

import com.gwtt.ems.cmnb.model.south.resources.LtpDataList;
import com.gwtt.ems.cmnb.model.south.resources.NeData;
import com.gwtt.ems.cmnb.model.south.resources.NeDataList;
import com.gwtt.ems.cmnb.southInterface.eventListener.CmnbEventListener;

/**
 * Created by chenjj on 2019/9/1
 */
public interface CmnbEmsAPI {
    public NeDataList getNes();
    public LtpDataList getLtpsByNeId(String neId);
    public NeData getNeById(String neId);

    public void addListener(CmnbEventListener cmnbEventListener);

    public void shutdown(CmnbEventListener cmnbEventListener);
}
