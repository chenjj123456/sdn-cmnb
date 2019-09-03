package com.gwtt.ems.cmnb.southInterface.ems;

import com.gwtt.ems.cmnb.model.south.EmsConfigResult;
import com.gwtt.ems.cmnb.model.south.resources.MeLocationData;
import com.gwtt.ems.cmnb.model.south.resources.NeData;
import com.gwtt.ems.cmnb.model.south.resources.NeDataList;
import com.gwtt.ems.cmnb.southInterface.eventListener.CmnbEventListener;

import java.util.List;

/**
 * Created by chenjj on 2019/9/1
 */
public interface CmnbEmsAPI {
    public NeDataList getNes();
    public NeData getNeById(String neId);
    public EmsConfigResult addMeLocation(List<MeLocationData> meLocationDataList);

    public void addListener(CmnbEventListener cmnbEventListener);

    public void shutdown(CmnbEventListener cmnbEventListener);
}
