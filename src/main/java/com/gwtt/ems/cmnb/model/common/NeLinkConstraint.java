package com.gwtt.ems.cmnb.model.common;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Created by chenjj on 2019/9/16
 */
public class NeLinkConstraint {

    private List<NeId> explicitIncludeNeList;

    private List<LinkId> explicitIncludeLinkList;

    private List<NeId> explicitExcludeNeList;

    private List<LinkId> explicitExcludeLinkList;

    public List<NeId> getExplicitIncludeNeList() {
        return explicitIncludeNeList;
    }

    @XmlElementWrapper(name = "explicit-include-ne")
    @XmlElement(name = "explicit-include-ne-list")
    public void setExplicitIncludeNeList(List<NeId> explicitIncludeNeList) {
        this.explicitIncludeNeList = explicitIncludeNeList;
    }

    public List<LinkId> getExplicitIncludeLinkList() {
        return explicitIncludeLinkList;
    }

    @XmlElementWrapper(name = "explicit-include-link")
    @XmlElement(name = "explicit-include-link-list")
    public void setExplicitIncludeLinkList(List<LinkId> explicitIncludeLinkList) {
        this.explicitIncludeLinkList = explicitIncludeLinkList;
    }

    public List<NeId> getExplicitExcludeNeList() {
        return explicitExcludeNeList;
    }

    @XmlElementWrapper(name = "explicit-exclude-ne")
    @XmlElement(name = "explicit-exclude-ne-list")
    public void setExplicitExcludeNeList(List<NeId> explicitExcludeNeList) {
        this.explicitExcludeNeList = explicitExcludeNeList;
    }

    public List<LinkId> getExplicitExcludeLinkList() {
        return explicitExcludeLinkList;
    }

    @XmlElementWrapper(name = "explicit-exclude-link")
    @XmlElement(name = "explicit-exclude-link-list")
    public void setExplicitExcludeLinkList(List<LinkId> explicitExcludeLinkList) {
        this.explicitExcludeLinkList = explicitExcludeLinkList;
    }
}
