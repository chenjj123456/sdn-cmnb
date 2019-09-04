package com.gwtt.ems.cmnb.util;


import com.gwtt.ems.cmnb.model.common.AdminStatus;
import com.gwtt.ems.cmnb.model.common.OperateStatus;
import com.gwtt.ems.cmnb.model.north.fault.AlarmList;
import com.gwtt.ems.cmnb.model.north.resources.ltp.Ltp;
import com.gwtt.ems.cmnb.model.north.resources.ltp.Ltps;
import com.gwtt.ems.cmnb.model.north.resources.ncd.Ncd;
import com.gwtt.ems.cmnb.model.north.resources.ne.Ne;
import com.gwtt.ems.cmnb.model.north.resources.ne.NeNode;
import com.gwtt.ems.cmnb.model.north.topology.*;
import com.gwtt.ems.cmnb.model.south.resources.LtpData;
import com.gwtt.ems.cmnb.model.south.resources.NeData;
import com.gwtt.ems.cmnb.model.south.topology.LinkData;
import com.gwtt.ems.cmnb.model.south.topology.NodeData;
import com.gwtt.ems.cmnb.model.south.topology.TopologyData;
import com.gwtt.nms.faultd.Alarm;
import com.gwtt.nms.util.NmsUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by chenjj on 2019/8/24
 */
public class CmnbUtil {
    public static int wsPort = 9999;
    private static final Properties serverParamsTable = new Properties();

    public static void init(){
        try {
            File cmnbFile = new File(NmsUtil.AIM_ROOT + "/conf/cmnb.properties");
            serverParamsTable.load(new InputStreamReader(new FileInputStream(
                    cmnbFile)));
        } catch (Exception ex) {
            CmnbLogger.CMNBERR.logException(ex, 3);
        }

        try {
            wsPort = Integer.parseInt(getParameter("websocketPort", "9999"));
            if (getParameter("id").equalsIgnoreCase("null")){
                setParameter("id",new Uuid(TimeBasedUUIDGenerator.generateIdFromTimestamp(System.currentTimeMillis(),
                        getHostId()).toString()).getValue());
            }

            if (getParameter("parentNcdId").equalsIgnoreCase("null")){
                setParameter("parentNcdId", getHost().getHostAddress());
            }
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

    public static Ne parserNeData(NeData neData){
        Ne ne=new Ne();
        ne.setId(neData.getId());
        ne.setName(neData.getName());
        ne.setType(neData.getType());
        ne.setUserLabel(neData.getUserLabel());
        ne.setAdminIp(neData.getAdminIp());
        ne.setAdminStatus(neData.getAdminStatus());
        ne.setOperateStatus(neData.getOperateStatus());
        ne.setLongitude(neData.getLongitude());
        ne.setLatitude(neData.getLatitude());
        ne.setLocation(neData.getLocation());
        ne.setLatency(neData.getLatency());
        ne.setVendorName(neData.getVendorName());
        if (neData.getLtpDataList().size()>0){
            ne.setLtps(parserLtpDatas(neData.getLtpDataList()));
        }
        return ne;
    }

    public static NeNode parserNeDataToNeNode(NeData neData){
        NeNode neNode=new NeNode();
        neNode.setId(neData.getId());
        neNode.setName(neData.getName());
        neNode.setType(neData.getType());
        neNode.setUserLabel(neData.getUserLabel());
        neNode.setAdminIp(neData.getAdminIp());
        neNode.setAdminStatus(neData.getAdminStatus());
        neNode.setOperateStatus(neData.getOperateStatus());
        neNode.setLongitude(neData.getLongitude());
        neNode.setLatitude(neData.getLatitude());
        neNode.setLocation(neData.getLocation());
        neNode.setLatency(neData.getLatency());
        neNode.setVendorName(neData.getVendorName());
        return neNode;
    }

    public static Ltp parserLtpData(LtpData ltpData){
        Ltp ltp=new Ltp();
        ltp.setId(ltpData.getId());
        ltp.setUserLabel(ltpData.getUserlabel());
        ltp.setNeId(ltpData.getNeId());
        ltp.setName(ltpData.getName());
        ltp.setLayerRate(ltpData.getLayerRate());
        ltp.setIpAddress(ltpData.getIpAddress());
        ltp.setMtu(ltpData.getMtu());
        ltp.setSpeed(ltpData.getSpeed());
        ltp.setAdminStatus(ltpData.getAdminStatus());
        ltp.setOperateStatus(ltpData.getOperateStatus());
        ltp.setMacAddress(ltpData.getMacAddress());

        return ltp;
    }

    public static Ltps parserLtpDatas(List<LtpData> ltpDatas){
        Ltps ltps=new Ltps();
        List<Ltp> ltpList=new ArrayList<>();
        for (LtpData ltpData:ltpDatas){
            Ltp ltp=parserLtpData(ltpData);
            ltpList.add(ltp);
        }
        ltps.setLtp(ltpList);
        return ltps;
    }

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
    public static Ncd getNcdInfo(){
        Ncd ncd=new Ncd();
        ncd.setId(getParameter("id"));
        ncd.setUserLabel(getHost().getHostAddress());
        ncd.setParentNcdId(getParameter("parentNcdId"));
        ncd.setActiveControllerIp(getHost().getHostAddress());
        ncd.setActiveControllerLocation(getParameter("activeControllerLocation"));
        ncd.setVendorName(getParameter("vendorName"));
        ncd.setPort(Long.parseLong(getParameter("port")));
        if (getParameter("adminStatus").equalsIgnoreCase("adminDown")){
            ncd.setAdminStatus(AdminStatus.AdminDown);
        }else {
            ncd.setAdminStatus(AdminStatus.AdminUp);
        }

        if (getParameter("operateStatus").equalsIgnoreCase("operateDown")){
            ncd.setOperateStatus(OperateStatus.OperateDown);
        }else {
            ncd.setOperateStatus(OperateStatus.OperateUp);
        }
        return ncd;
    }

    private static InetAddress getHost() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            return address;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long getHostId() {
        long macAddressAsLong = 0;
        try {
            InetAddress address = InetAddress.getLocalHost();
            NetworkInterface ni = NetworkInterface.getByInetAddress(address);
            if (ni != null) {
                byte[] mac = ni.getHardwareAddress();
                //Converts array of unsigned bytes to an long
                if (mac != null) {
                    for (int i = 0; i < mac.length; i++) {
                        macAddressAsLong <<= 8;
                        macAddressAsLong ^= (long) mac[i] & 0xFF;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return macAddressAsLong;
    }

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

    public static Topology parserTopologyData(TopologyData topologyData){
        Topology topology=new Topology();
        topology.setId(topologyData.getId());
        topology.setName(topologyData.getName());
        topology.setLayerRate(topologyData.getLayerRate());
        if (topologyData.getSubLayerRate()!=null){
            topology.setSubLayerRate(topologyData.getSubLayerRate());
        }
        return topology;
    }

    public static Node parserNodeData(NodeData nodeData){
        Node node=new Node();
        node.setId(nodeData.getId());
        node.setName(nodeData.getName());
        node.setUserLabel(nodeData.getUserLabel());
        node.setNodeType(nodeData.getNodeType());
        node.setAdminStatus(nodeData.getAdminStatus());
        node.setOperateStatus(nodeData.getOperateStatus());
        node.setParentTopoId(nodeData.getParentTopoId());
        node.setResourceId(nodeData.getResourceId());
        return node;
    }

    public static ExtNode parserNodeDataToExtNode(NodeData nodeData){
        ExtNode extNode=new ExtNode();
        extNode.setId(nodeData.getId());
        extNode.setName(nodeData.getName());
        extNode.setUserLabel(nodeData.getUserLabel());
        extNode.setNodeType(nodeData.getNodeType());
        extNode.setAdminStatus(nodeData.getAdminStatus());
        extNode.setOperateStatus(nodeData.getOperateStatus());
        extNode.setParentTopoId(nodeData.getParentTopoId());
        extNode.setResourceId(nodeData.getResourceId());
        return extNode;
    }

    public static Link parserLinkData(LinkData linkData){
        Link link=new Link();
        link.setId(linkData.getId());
        link.setName(linkData.getName());
        link.setUserLabel(linkData.getUserLabel());
        link.setDirection(linkData.getDirection());
        link.setAdminStatus(linkData.getAdminStatus());
        link.setOperateStatus(linkData.getOperateStatus());
        link.setLayerRate(linkData.getLayerRate());
        link.setLeftLtpId(linkData.getLeftLtpId());
        link.setLeftNodeId(linkData.getLeftNodeId());
        link.setRightLtpId(linkData.getRightLtpId());
        link.setRightNodeId(linkData.getRightNodeId());

        LinkTeAttrCfg linkTeAttrCfg=new LinkTeAttrCfg();
        linkTeAttrCfg.setLatency(linkData.getLatency());
        linkTeAttrCfg.setMaxReservableBandwidth(linkData.getMaxReservableBandwidth());
        link.setLinkTeAttrCfg(linkTeAttrCfg);

        LinkTeAttrRun linkTeAttrRun=new LinkTeAttrRun();
        linkTeAttrRun.setAvailableBandwidth(linkData.getAvailableBandwidth());
        linkTeAttrRun.setLinkLatency(linkData.getLinkLatency());
        linkTeAttrRun.setPhysicalBandwidth(linkData.getPhysicalBandwidth());
        link.setLinkTeAttrRun(linkTeAttrRun);

        return link;
    }

    public static ExtLink parserLinkDataToExtLink(LinkData linkData){
        ExtLink extLink=new ExtLink();

        return extLink;
    }

}
