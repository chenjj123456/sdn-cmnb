package com.gwtt.ems.cmnb.model.south.tunnel;

import com.gwtt.ems.cmnb.model.common.Exp;
import com.gwtt.ems.cmnb.model.common.OamMode;
import com.gwtt.ems.cmnb.model.south.EmsBaseData;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by chenjj on 2019/9/17
 */
public class OamData extends EmsBaseData {
    /**
     * id of pw or lsp that route belong to.
     */
    private String belongedId;

    private String name;

    private String megId;

    private List<MepData> mep;

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

    public void setMegId(String megId) {
        this.megId = megId;
    }

    public List<MepData> getMep() {
        return mep;
    }

    public void setMep(List<MepData> mep) {
        this.mep = mep;
    }

    public boolean isCcAllow() {
        return ccAllow;
    }

    public void setCcAllow(boolean ccAllow) {
        this.ccAllow = ccAllow;
    }

    public Exp getCcExp() {
        return ccExp;
    }

    public void setCcExp(Exp ccExp) {
        this.ccExp = ccExp;
    }

    public BigDecimal getCcInterval() {
        return ccInterval;
    }

    public void setCcInterval(BigDecimal ccInterval) {
        this.ccInterval = ccInterval;
    }

    public OamMode getLmMode() {
        return lmMode;
    }

    public void setLmMode(OamMode lmMode) {
        this.lmMode = lmMode;
    }

    public OamMode getDmMode() {
        return dmMode;
    }

    public void setDmMode(OamMode dmMode) {
        this.dmMode = dmMode;
    }
}
