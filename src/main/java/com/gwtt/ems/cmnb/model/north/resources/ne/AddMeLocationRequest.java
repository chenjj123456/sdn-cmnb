package com.gwtt.ems.cmnb.model.north.resources.ne;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by chenjj on 2019/7/25
 */

@XmlRootElement(name = "input")
public class AddMeLocationRequest {

    @XmlElement(name = "me-location")
    private List<MeLocation> meLocation;

    public List<MeLocation> getMeLocation() {
        return meLocation;
    }

    public void setMeLocation(List<MeLocation> meLocation) {
        this.meLocation = meLocation;
    }
}
