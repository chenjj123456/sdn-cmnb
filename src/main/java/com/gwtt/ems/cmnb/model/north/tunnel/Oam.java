package com.gwtt.ems.cmnb.model.north.tunnel;

import com.gwtt.ems.cmnb.model.common.Exp;
import com.gwtt.ems.cmnb.model.common.OamMode;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by chenjj on 2019/9/16
 */
public class Oam {
    /**
     * id of pw or lsp that route belong to.
     */
    private String belongedId;

    private String name;

    private String megId;

    private List<Mep> mep;

    private boolean ccAllow;

    private Exp ccExp;

    /**
     * Connect Confirm interval.
     * fraction-digits 1;
     * range "3.3 | 10 | 100 | 1000"
     */
    private BigDecimal ccInterval;

    private OamMode lmMode;

    private OamMode dmMode;

    public String getBelongedId() {
        return belongedId;
    }

    @XmlElement(name = "belonged-id")
    public void setBelongedId(String belongedId) {
        this.belongedId = belongedId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMegId() {
        return megId;
    }

    @XmlElement(name = "meg-id")
    public void setMegId(String megId) {
        this.megId = megId;
    }

    public List<Mep> getMep() {
        return mep;
    }

    @XmlElementWrapper(name = "meps")
    @XmlElement(name = "mep")
    public void setMep(List<Mep> mep) {
        this.mep = mep;
    }

    public boolean isCcAllow() {
        return ccAllow;
    }

    @XmlElement(name = "cc-allow")
    public void setCcAllow(boolean ccAllow) {
        this.ccAllow = ccAllow;
    }

    public Exp getCcExp() {
        return ccExp;
    }

    @XmlElement(name = "cc-exp")
    public void setCcExp(Exp ccExp) {
        this.ccExp = ccExp;
    }

    public BigDecimal getCcInterval() {
        return ccInterval;
    }

    @XmlElement(name = "cc-interval")
    public void setCcInterval(BigDecimal ccInterval) {
        this.ccInterval = ccInterval;
    }

    public OamMode getLmMode() {
        return lmMode;
    }

    @XmlElement(name = "lm-mode")
    public void setLmMode(OamMode lmMode) {
        this.lmMode = lmMode;
    }

    public OamMode getDmMode() {
        return dmMode;
    }

    @XmlElement(name = "dm-mode")
    public void setDmMode(OamMode dmMode) {
        this.dmMode = dmMode;
    }
}
