package com.gwtt.ems.cmnb.util;


import com.gwtt.ems.cmnb.model.north.fault.AlarmList;
import com.gwtt.nms.faultd.Alarm;
import com.gwtt.nms.util.NmsUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

/**
 * Created by chenjj on 2019/8/24
 */
public class CmnbUtil {
    public static int wsPort = 9999;
    private static final Properties serverParamsTable = new Properties();

    public static void init(){
        try {
            File omcFile = new File(NmsUtil.AIM_ROOT + "/conf/omc.properties");
            serverParamsTable.load(new InputStreamReader(new FileInputStream(
                    omcFile)));
        } catch (Exception ex) {
            CmnbLogger.CMNBERR.logException(ex, 3);
        }

        try {
            String df=CmnbUtil.getParameter("omcId","gwttomc");

            wsPort = Integer.parseInt(CmnbUtil.getParameter("websocketPort", "9999"));
        } catch (Exception ex) {
            CmnbLogger.CMNBERR.logException(ex, 3);
        }

    }

    public static String getParameter(String name, String defval) {
        return serverParamsTable.getProperty(name, defval);
    }

    public static String getParameter(String key) {
        return serverParamsTable.getProperty(key.trim());
    }

    public static void setParameter(String key, String val) {
        serverParamsTable.setProperty(key,val);
    }



    public static String getDatetime(long l) {
        String datetime = getDatetimeStr(l);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = df.parse(datetime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getDateAndTime(date);
    }

    public static String getDatetimeStr(long l) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(l);
        return df.format(date);
    }

    public static String getDateAndTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, -8);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String dateString = formatter.format(cal.getTime());
        return dateString;
    }

    public static long getMillisecondTime(String dateAndTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = null;
        try {
            date = sdf.parse(dateAndTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, 8);
        return cal.getTimeInMillis();

    }

//    public static Ne parserNeData(NeData neData){
//        Ne ne=new Ne();
//        ne.setRmUID(RmUidGenerator.getNeUID(neData.getIpAddress()));
//        ne.setAdminStatus(neData.getAdminStatus());
//        ne.setControlPlaneIp(neData.getControlPlaneIP());
//        ne.setHardwareVersion(neData.getHardwareVersion());
//        ne.setIpAddress(neData.getIpAddress());
//        ne.setLatency(neData.getLatency());
//        ne.setLatitude(neData.getLatitude());
//        ne.setLocation(neData.getLocation());
//        ne.setLongitude(neData.getLongitude());
//        ne.setMaxCapacity(neData.getMaxCapacity());
//        ne.setNativeName(neData.getNativeName());
//        ne.setProductName(neData.getProductName());
//        ne.setReality(neData.getReality());
//        ne.setSoftwareVersion(neData.getSoftwareVersion());
//        ne.setState(neData.getState());
//        ne.setSynchronizationSupportStatus(neData.getSynchronizationSupportStatus());
//        ne.setVendor(neData.getVendor());
//        return ne;
//    }
//
//    public static Port parserPortData(PortData portData){
//        Port port=new Port();
//        port.setRmUID(RmUidGenerator.getPortUID(portData.getNeId()+":"+portData.getId()));
//        port.setNermUID(RmUidGenerator.getNeUID(portData.getNeId()));
//        if (portData.getCardId() != null) {
//            port.setCardrmUID(RmUidGenerator.getCardUID(portData));
//        }
//        if (portData.getHolderId() != null) {
//            port.setHolderrmUID(RmUidGenerator.getHolderUID(portData));
//        }
//        port.setPortNo(portData.getPortNo());
//        port.setNativeName(portData.getNativeName());
//        port.setPhysicalOrLogical(portData.getPhysicalOrLogical());
//        port.setPortType(portData.getPortType());
//        port.setPortSubType(portData.getPortSubType());
//        port.setSignalType(portData.getSignalType());
//        port.setPortRate(portData.getPortRate());
//        port.setDirection(portData.getDirection());
//        port.setRole(portData.getRole());
//        if (portData.getIpAddress() != null) {
//            port.setIpAddress(portData.getIpAddress());
//        }
//        if (portData.getIpMask() != null) {
//            port.setIpMask(portData.getIpMask());
//        }
//        port.setIsOverlay(portData.getIsOverlay());
//        port.setLayerRate(portData.getLayerRate());
//        port.setMtu(portData.getMtu());
//        port.setAdminStatus(portData.getAdminStatus());
//        port.setOperateStatus(portData.getOperateStatus());
//        if (portData.getMacAddress() != null) {
//            port.setMacAddress(portData.getMacAddress());
//        }
//        return port;
//    }
//
//    public static TopoLink parserTopoLinkData(TopoLinkData topoLinkData){
//        TopoLink topoLink=new TopoLink();
//        topoLink.setRmUID(RmUidGenerator.getTopoLinkUID(topoLinkData.getId()));
//        topoLink.setNativeName(topoLinkData.getNativeName());
//        topoLink.setaEndNermUID(RmUidGenerator.getNeUID(topoLinkData.getaEndNeId()));
//        topoLink.setzEndNermUID(RmUidGenerator.getNeUID(topoLinkData.getzEndNeId()));
//        topoLink.setaEndPortrmUID(RmUidGenerator.getPortUID(topoLinkData.getaEndPortInfo()));
//        topoLink.setzEndPortrmUID(RmUidGenerator.getPortUID(topoLinkData.getzEndPortInfo()));
//        topoLink.setRate(topoLinkData.getRate());
//        topoLink.setDirection(topoLinkData.getDirection());
//        topoLink.setReality(topoLinkData.getReality());
//        topoLink.setLayerRate(topoLinkData.getLayerRate());
//        topoLink.setAdminStatus(topoLinkData.getAdminStatus());
//        topoLink.setOperateStatus(topoLinkData.getOperateStatus());
//        topoLink.setLatency(topoLinkData.getLatency());
//        topoLink.setMaxReservableBandwidth(topoLinkData.getMaxReservableBandwidth());
//        topoLink.setPhysicalBandwidth(topoLinkData.getPhysicalBandwidth());
//        topoLink.setAvailableBandwidth(topoLinkData.getAvailableBandwidth());
//        topoLink.setLinkLatency(topoLinkData.getLinkLatency());
//        topoLink.setLeftPortMac(topoLinkData.getLeftPortMac());
//        topoLink.setRightPortMac(topoLinkData.getRightPortMac());
//        return topoLink;
//    }
//
//    public static TopoLinkData parserTopoLink(TopoLink topoLink){
//        TopoLinkData topoLinkData=new TopoLinkData();
//        topoLinkData.setId(RmUidToId.getLinkIdByLinkUid(topoLink.getRmUID()));
//        topoLinkData.setNativeName(topoLink.getNativeName());
//        topoLinkData.setaEndNeId(RmUidToId.getNeIdByNeUid(topoLink.getaEndNermUID()));
//        topoLinkData.setzEndNeId(RmUidToId.getNeIdByNeUid(topoLink.getzEndNermUID()));
//        topoLinkData.setaEndPortInfo(RmUidToId.getPortInfoByPortUid(topoLink.getaEndPortrmUID()));
//        topoLinkData.setzEndPortInfo(RmUidToId.getPortInfoByPortUid(topoLink.getzEndPortrmUID()));
//        topoLinkData.setRate(topoLink.getRate());
//        topoLinkData.setDirection(topoLink.getDirection());
//        topoLinkData.setReality(topoLink.getReality());
//        topoLinkData.setLayerRate(topoLink.getLayerRate());
//        topoLinkData.setAdminStatus(topoLink.getAdminStatus());
//        topoLinkData.setOperateStatus(topoLink.getOperateStatus());
//        topoLinkData.setLatency(topoLink.getLatency());
//        topoLinkData.setMaxReservableBandwidth(topoLink.getMaxReservableBandwidth());
//        topoLinkData.setPhysicalBandwidth(topoLink.getPhysicalBandwidth());
//        topoLinkData.setAvailableBandwidth(topoLink.getAvailableBandwidth());
//        topoLinkData.setLinkLatency(topoLink.getLinkLatency());
//        topoLinkData.setLeftPortMac(topoLink.getLeftPortMac());
//        topoLinkData.setRightPortMac(topoLink.getRightPortMac());
//        return topoLinkData;
//
//    }
//
//    public static LinkTeAttrCfgData parserLinkTeCfg(LinkTeAttrCfg linkTeAttrCfg){
//        LinkTeAttrCfgData linkTeAttrCfgData=new LinkTeAttrCfgData();
//        linkTeAttrCfgData.setLatency(linkTeAttrCfg.getLatency());
//        linkTeAttrCfgData.setMaxReservableBandwidth(linkTeAttrCfg.getMaxReservableBandwidth());
//        return linkTeAttrCfgData;
//    }
//
//    public static Omc getOmcInfo(){
//        Omc omc=new Omc();
//        omc.setRmUID(getParameter("rmUID"));
//        omc.setNativeName(getParameter("nativeName"));
//        omc.setCommuAddress(getParameter("commuAddress"));
//        omc.setOmcVersion(getParameter("omcVersion"));
//        omc.setInterfaceVersion(getParameter("interfaceVersion"));
//        omc.setEquipmentDomain(getParameter("equipmentDomain"));
//        omc.setVendor(getParameter("vendor"));
//        omc.setActiveControllerLocation(getParameter("activeControllerLocation"));
//        omc.setPort(getParameter("port"));
//        omc.setAdminStatus(getParameter("adminStatus"));
//        omc.setOperateStatus(getParameter("operateStatus"));
//        return omc;
//    }
//
    public static AlarmList parserAlarm(Alarm alarm) {
        AlarmList alarmList = new AlarmList();
        alarmList.setAlarmRaisedTime(CmnbUtil.getDatetime(alarm.getCreateTime()));
        alarmList.setAlarmSource(alarm.getSource());
//        restAlarm.setAlarmSourceType();
        alarmList.setPerceivedSeverity(alarm.getPreviousSeverity());
        alarmList.setProbableCause(alarm.getMessage());
        alarmList.setSequence(BigInteger.valueOf(alarm.getId()));
        alarmList.setId(alarm.getId()+"");
        return alarmList;
    }

}
