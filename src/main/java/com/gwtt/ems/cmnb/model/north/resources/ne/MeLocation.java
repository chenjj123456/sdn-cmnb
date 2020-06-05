package com.gwtt.ems.cmnb.model.north.resources.ne;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/7/24
 */
public class MeLocation {

    @XmlElement(name = "ne-id")
    private String neId;

    private String longitude;

    private String latitude;

    public MeLocation(String b) { }

    public String getNeId() {
        return neId;
    }

    public void setNeId(String neId) {
        this.neId = neId;
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
