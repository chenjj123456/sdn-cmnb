package com.gwtt.ems.cmnb.model.south.resources;

import com.gwtt.ems.cmnb.model.south.EmsBaseData;

/**
 * Created by chenjj on 2019/9/2
 */
public class MeLocationData extends EmsBaseData {
    private String neUuid;

    private String longitude;

    private String latitude;

    public String getNeUuid() {
        return neUuid;
    }

    public void setNeUuid(String neUuid) {
        this.neUuid = neUuid;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
