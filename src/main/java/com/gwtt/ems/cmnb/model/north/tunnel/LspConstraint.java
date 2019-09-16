package com.gwtt.ems.cmnb.model.north.tunnel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Created by chenjj on 2019/9/16
 */
public class LspConstraint {

    private List<ExplicitIncludeNeList> explicitIncludeNeList;

    private List<ExplicitIncludeLinkList> explicitIncludeLinkList;

    private List<ExplicitExcludeNeList> explicitExcludeNeList;

    private List<ExplicitExcludeLinkList> explicitExcludeLinkList;

    public List<ExplicitIncludeNeList> getExplicitIncludeNeList() {
        return explicitIncludeNeList;
    }

    @XmlElementWrapper(name = "explicit-include-ne")
    @XmlElement(name = "explicit-include-ne-list")
    public void setExplicitIncludeNeList(List<ExplicitIncludeNeList> explicitIncludeNeList) {
        this.explicitIncludeNeList = explicitIncludeNeList;
    }

    public List<ExplicitIncludeLinkList> getExplicitIncludeLinkList() {
        return explicitIncludeLinkList;
    }

    @XmlElementWrapper(name = "explicit-include-link")
    @XmlElement(name = "explicit-include-link-list")
    public void setExplicitIncludeLinkList(List<ExplicitIncludeLinkList> explicitIncludeLinkList) {
        this.explicitIncludeLinkList = explicitIncludeLinkList;
    }

    public List<ExplicitExcludeNeList> getExplicitExcludeNeList() {
        return explicitExcludeNeList;
    }

    @XmlElementWrapper(name = "explicit-exclude-ne")
    @XmlElement(name = "explicit-exclude-ne-list")
    public void setExplicitExcludeNeList(List<ExplicitExcludeNeList> explicitExcludeNeList) {
        this.explicitExcludeNeList = explicitExcludeNeList;
    }

    public List<ExplicitExcludeLinkList> getExplicitExcludeLinkList() {
        return explicitExcludeLinkList;
    }

    @XmlElementWrapper(name = "explicit-exclude-link")
    @XmlElement(name = "explicit-exclude-link-list")
    public void setExplicitExcludeLinkList(List<ExplicitExcludeLinkList> explicitExcludeLinkList) {
        this.explicitExcludeLinkList = explicitExcludeLinkList;
    }
}
