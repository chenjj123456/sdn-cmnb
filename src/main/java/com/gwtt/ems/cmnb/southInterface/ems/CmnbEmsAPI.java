package com.gwtt.ems.cmnb.southInterface.ems;

import com.gwtt.ems.cmnb.model.south.EmsConfigOrQueryResult;
import com.gwtt.ems.cmnb.model.south.resources.MeLocationData;
import com.gwtt.ems.cmnb.model.south.resources.NeData;
import com.gwtt.ems.cmnb.model.south.resources.NeDataList;
import com.gwtt.ems.cmnb.southInterface.eventListener.CmnbEventListener;

import java.util.List;

/**
 * Created by chenjj on 2019/9/1
 */
public interface CmnbEmsAPI {
    //resources
    public NeDataList getNes();
    public NeData getNeById(String neId);
    public EmsConfigOrQueryResult addMeLocation(List<MeLocationData> meLocationDataList);
    public EmsConfigOrQueryResult getNodeUuidByNodeId(String nodeId);

    public void addListener(CmnbEventListener cmnbEventListener);

    public void shutdown(CmnbEventListener cmnbEventListener);
}
