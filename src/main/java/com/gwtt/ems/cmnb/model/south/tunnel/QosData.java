package com.gwtt.ems.cmnb.model.south.tunnel;

import com.gwtt.ems.cmnb.model.common.Exp;
import com.gwtt.ems.cmnb.model.common.TunnelMode;
import com.gwtt.ems.cmnb.model.south.EmsBaseData;

/**
 * Created by chenjj on 2019/9/17
 */
public class QosData extends EmsBaseData {
    private String belongedId;

    private TunnelMode tunnelMode;

    /**
     * tunnel mode.0 is close, 1 is open
     */
    private String cacMode;

    /**
     * convergence mode.0 is misconvergence, 1 is inherit TMS
     */
    private String convgMode;

    /**
     * Bandwidth adjustment mode.
     * 0 : dont Support automatic adjustment,
     * 1 : Support automatic adjustment
     */
    private String trafficAdjMode;

    /**
     * forward flow control. 0 : close, 1 : open
     */
    private String a2zPolicing;

    /**
     * forward flow control. 0 : close, 1 : open
     */
    private String z2aPolicing;

    /**
     * forward CIR. unit:Kbps
     */
    private String a2zCir;

    /**
     * reverse CIR. unit:Kbps
     */
    private String z2aCir;

    /**
     * forward PIR. unit:Kbps
     */
    private String a2zPir;

    /**
     * reverse PIR. unit:Kbps
     */
    private String z2aPir;

    /**
     * forward CBS. unit:Kbps
     */
    private String a2zCbs;

    /**
     * reverse CBS. unit:Kbps
     */
    private String z2aCbs;

    /**
     * forward PBS. unit:Kbps
     */
    private String a2zPbs;

    /**
     * reverse PBS. unit:Kbps
     */
    private String z2aPbs;

    /**
     * forward Color-Aware. 0 : unaware, 1 : aware
     */
    private String a2zColorMode;

    /**
     * reverse Color-Aware. 0 : unaware, 1 : aware
     */
    private String z2aColorMode;

    private Exp trafficClass;

    public String getBelongedId() {
        return belongedId;
    }

    public void setBelongedId(String belongedId) {
        this.belongedId = belongedId;
    }

    public TunnelMode getTunnelMode() {
        return tunnelMode;
    }

    public void setTunnelMode(TunnelMode tunnelMode) {
        this.tunnelMode = tunnelMode;
    }

    public String getCacMode() {
        return cacMode;
    }

    public void setCacMode(String cacMode) {
        this.cacMode = cacMode;
    }

    public String getConvgMode() {
        return convgMode;
    }

    public void setConvgMode(String convgMode) {
        this.convgMode = convgMode;
    }

    public String getTrafficAdjMode() {
        return trafficAdjMode;
    }

    public void setTrafficAdjMode(String trafficAdjMode) {
        this.trafficAdjMode = trafficAdjMode;
    }

    public String getA2zPolicing() {
        return a2zPolicing;
    }

    public void setA2zPolicing(String a2zPolicing) {
        this.a2zPolicing = a2zPolicing;
    }

    public String getZ2aPolicing() {
        return z2aPolicing;
    }

    public void setZ2aPolicing(String z2aPolicing) {
        this.z2aPolicing = z2aPolicing;
    }

    public String getA2zCir() {
        return a2zCir;
    }

    public void setA2zCir(String a2zCir) {
        this.a2zCir = a2zCir;
    }

    public String getZ2aCir() {
        return z2aCir;
    }

    public void setZ2aCir(String z2aCir) {
        this.z2aCir = z2aCir;
    }

    public String getA2zPir() {
        return a2zPir;
    }

    public void setA2zPir(String a2zPir) {
        this.a2zPir = a2zPir;
    }

    public String getZ2aPir() {
        return z2aPir;
    }

    public void setZ2aPir(String z2aPir) {
        this.z2aPir = z2aPir;
    }

    public String getA2zCbs() {
        return a2zCbs;
    }

    public void setA2zCbs(String a2zCbs) {
        this.a2zCbs = a2zCbs;
    }

    public String getZ2aCbs() {
        return z2aCbs;
    }

    public void setZ2aCbs(String z2aCbs) {
        this.z2aCbs = z2aCbs;
    }

    public String getA2zPbs() {
        return a2zPbs;
    }

    public void setA2zPbs(String a2zPbs) {
        this.a2zPbs = a2zPbs;
    }

    public String getZ2aPbs() {
        return z2aPbs;
    }

    public void setZ2aPbs(String z2aPbs) {
        this.z2aPbs = z2aPbs;
    }

    public String getA2zColorMode() {
        return a2zColorMode;
    }

    public void setA2zColorMode(String a2zColorMode) {
        this.a2zColorMode = a2zColorMode;
    }

    public String getZ2aColorMode() {
        return z2aColorMode;
    }

    public void setZ2aColorMode(String z2aColorMode) {
        this.z2aColorMode = z2aColorMode;
    }

    public Exp getTrafficClass() {
        return trafficClass;
    }

    public void setTrafficClass(Exp trafficClass) {
        this.trafficClass = trafficClass;
    }
}
