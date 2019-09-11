package com.gwtt.ems.cmnb.model.north.resources.ltp;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by chenjj on 2019/9/1
 */
@XmlRootElement(name = "ltps")
public class Ltps {
    private List<Ltp> ltp;

    public List<Ltp> getLtp() {
        return ltp;
    }

    public void setLtp(List<Ltp> ltp) {
        this.ltp = ltp;
    }
}
