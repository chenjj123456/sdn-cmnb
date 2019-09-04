package com.gwtt.ems.cmnb.model.north.topology;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by chenjj on 2019/9/4
 */

@XmlRootElement(name = "links", namespace="urn:chinamobile:nettopology")
public class Links {
    private List<Link> link;

    public List<Link> getLink() {
        return link;
    }

    public void setLink(List<Link> link) {
        this.link = link;
    }
}
