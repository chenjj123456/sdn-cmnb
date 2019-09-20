package com.gwtt.ems.cmnb.util;


import com.gwtt.ems.cmnb.model.common.*;
import com.gwtt.ems.cmnb.model.north.fault.AlarmList;
import com.gwtt.ems.cmnb.model.north.resources.ltp.Ltp;
import com.gwtt.ems.cmnb.model.north.resources.ltp.Ltps;
import com.gwtt.ems.cmnb.model.north.resources.ncd.Ncd;
import com.gwtt.ems.cmnb.model.north.resources.ne.MeLocation;
import com.gwtt.ems.cmnb.model.north.resources.ne.Ne;
import com.gwtt.ems.cmnb.model.north.resources.ne.NeNode;
import com.gwtt.ems.cmnb.model.north.route.*;
import com.gwtt.ems.cmnb.model.north.topology.*;
import com.gwtt.ems.cmnb.model.north.tunnel.*;
import com.gwtt.ems.cmnb.model.south.EmsConfigOrQueryResult;
import com.gwtt.ems.cmnb.model.south.resources.LtpData;
import com.gwtt.ems.cmnb.model.south.resources.MeLocationData;
import com.gwtt.ems.cmnb.model.south.resources.NeData;
import com.gwtt.ems.cmnb.model.south.route.*;
import com.gwtt.ems.cmnb.model.south.topology.LinkData;
import com.gwtt.ems.cmnb.model.south.topology.NodeData;
import com.gwtt.ems.cmnb.model.south.topology.TopologyData;
import com.gwtt.ems.cmnb.model.south.tunnel.*;
import com.gwtt.ems.cmnb.southInterface.ems.CmnbEmsHelper;
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

    public static void init() {
        try {
            File cmnbFile = new File(NmsUtil.AIM_ROOT + "/conf/cmnb.properties");
            serverParamsTable.load(new InputStreamReader(new FileInputStream(
                    cmnbFile)));
        } catch (Exception ex) {
            CmnbLogger.CMNBERR.logException(ex, 3);
        }

        try {
            wsPort = Integer.parseInt(getParameter("websocketPort", "9999"));
            if (getParameter("id").equalsIgnoreCase("null")) {
                setParameter("id", new Uuid(TimeBasedUUIDGenerator.generateIdFromTimestamp(System.currentTimeMillis(),
                        getHostId()).toString()).getValue());
            }

            if (getParameter("parentNcdId").equalsIgnoreCase("null")) {
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
        serverParamsTable.setProperty(key, val);
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

    public static long getMillisecondTime(String dateAndTime) {
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

    public static Ne parserNeData(NeData neData) {
        Ne ne = new Ne();
        ne.setId(neData.getUuid());
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
        if (neData.getLtpDataList().size() > 0) {
            ne.setLtp(parserLtpDatas(neData.getLtpDataList()).getLtp());
        }
        return ne;
    }

    public static NeNode parserNeDataToNeNode(NeData neData) {
        NeNode neNode = new NeNode();
        neNode.setId(neData.getUuid());
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

    public static Ltp parserLtpData(LtpData ltpData) {
        Ltp ltp = new Ltp();
        ltp.setId(ltpData.getUuid());
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

    public static Ltps parserLtpDatas(List<LtpData> ltpDatas) {
        Ltps ltps = new Ltps();
        List<Ltp> ltpList = new ArrayList<>();
        for (LtpData ltpData : ltpDatas) {
            Ltp ltp = parserLtpData(ltpData);
            ltpList.add(ltp);
        }
        ltps.setLtp(ltpList);
        return ltps;
    }

    public static Ncd getNcdInfo() {
        Ncd ncd = new Ncd();
        ncd.setId(getParameter("id"));
        //用于测试
//        ncd.setId("0d1cfe72-015e-1000-0000-1c3947d8427a");
        ncd.setUserLabel(getHost().getHostAddress());
        ncd.setParentNcdId(getParameter("parentNcdId"));
        ncd.setActiveControllerIp(getHost().getHostAddress());
        ncd.setActiveControllerLocation(getParameter("activeControllerLocation"));
        ncd.setVendorName(getParameter("vendorName"));
//                ncd.setPort(6653L);
        ncd.setPort(Long.parseLong(getParameter("port")));
        if (getParameter("adminStatus").equalsIgnoreCase("adminDown")) {
            ncd.setAdminStatus(AdminStatus.AdminDown);
        } else {
            ncd.setAdminStatus(AdminStatus.AdminUp);
        }

        if (getParameter("operateStatus").equalsIgnoreCase("operateDown")) {
            ncd.setOperateStatus(OperateStatus.OperateDown);
        } else {
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
        alarmList.setId(alarm.getId() + "");
        return alarmList;
    }

    public static MeLocationData parserMeLocation(MeLocation meLocation){
        MeLocationData meLocationData=new MeLocationData();
        meLocationData.setNeUuid(meLocation.getNeId());
        meLocationData.setLatitude(meLocation.getLatitude());
        meLocationData.setLongitude(meLocation.getLongitude());
        return meLocationData;
    }

    public static Topology parserTopologyData(TopologyData topologyData) {
        Topology topology = new Topology();
        topology.setId(topologyData.getUuid());
        topology.setName(topologyData.getName());
        topology.setLayerRate(topologyData.getLayerRate());
        if (topologyData.getSubLayerRate() != null) {
            topology.setSubLayerRate(topologyData.getSubLayerRate());
        }
        return topology;
    }

    public static Node parserNodeData(NodeData nodeData) {
        Node node = new Node();
        node.setId(nodeData.getUuid());
        node.setName(nodeData.getName());
        node.setUserLabel(nodeData.getUserLabel());
        node.setNodeType(nodeData.getNodeType());
        node.setAdminStatus(nodeData.getAdminStatus());
        node.setOperateStatus(nodeData.getOperateStatus());
        node.setParentTopoId(nodeData.getParentTopoId());
        node.setResourceId(nodeData.getResourceId());
        return node;
    }

    public static ExtNode parserNodeDataToExtNode(NodeData nodeData) {
        ExtNode extNode = new ExtNode();
        extNode.setId(nodeData.getUuid());
        extNode.setName(nodeData.getName());
        extNode.setUserLabel(nodeData.getUserLabel());
        extNode.setNodeType(nodeData.getNodeType());
        extNode.setAdminStatus(nodeData.getAdminStatus());
        extNode.setOperateStatus(nodeData.getOperateStatus());
        extNode.setParentTopoId(nodeData.getParentTopoId());
        extNode.setResourceId(nodeData.getResourceId());
        return extNode;
    }

    public static Link parserLinkData(LinkData linkData) {
        Link link = new Link();
        link.setId(linkData.getUuid());
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

        LinkTeAttrCfg linkTeAttrCfg = new LinkTeAttrCfg();
        linkTeAttrCfg.setLatency(linkData.getLatency());
        linkTeAttrCfg.setMaxReservableBandwidth(linkData.getMaxReservableBandwidth());
        link.setLinkTeAttrCfg(linkTeAttrCfg);

        LinkTeAttrRun linkTeAttrRun = new LinkTeAttrRun();
        linkTeAttrRun.setAvailableBandwidth(linkData.getAvailableBandwidth());
        linkTeAttrRun.setLinkLatency(linkData.getLinkLatency());
        linkTeAttrRun.setPhysicalBandwidth(linkData.getPhysicalBandwidth());
        link.setLinkTeAttrRun(linkTeAttrRun);

        return link;
    }

    public static ExtLink parserLinkDataToExtLink(LinkData linkData) {
        ExtLink extLink = new ExtLink();
        extLink.setId(linkData.getUuid());
        extLink.setName(linkData.getName());
        extLink.setUserLabel(linkData.getUserLabel());
        extLink.setDirection(linkData.getDirection());
        extLink.setExtLinkType(linkData.getExtLinkType());
        extLink.setAdminStatus(linkData.getAdminStatus());
        extLink.setOperateStatus(linkData.getOperateStatus());
        extLink.setLayerRate(linkData.getLayerRate());
        extLink.setLeftLtpId(linkData.getLeftLtpId());
        extLink.setLeftNodeId(linkData.getLeftNodeId());
        extLink.setRightLtpId(linkData.getRightLtpId());
        extLink.setRightNodeId(linkData.getRightNodeId());

        LinkTeAttrCfg linkTeAttrCfg = new LinkTeAttrCfg();
        linkTeAttrCfg.setLatency(linkData.getLatency());
        linkTeAttrCfg.setMaxReservableBandwidth(linkData.getMaxReservableBandwidth());
        extLink.setLinkTeAttrCfg(linkTeAttrCfg);

        LinkTeAttrRun linkTeAttrRun = new LinkTeAttrRun();
        linkTeAttrRun.setAvailableBandwidth(linkData.getAvailableBandwidth());
        linkTeAttrRun.setLinkLatency(linkData.getLinkLatency());
        linkTeAttrRun.setPhysicalBandwidth(linkData.getPhysicalBandwidth());
        extLink.setLinkTeAttrRun(linkTeAttrRun);

        extLink.setLeftLtpMac(linkData.getLeftLtpMac());
        extLink.setRightLtpMac(linkData.getRightLtpMac());
        return extLink;
    }

    public static LinkData parserExtLink(ExtLink extLink) {
        LinkData linkData = new LinkData();
        linkData.setUuid(extLink.getId());
        linkData.setName(extLink.getName());
        linkData.setUserLabel(extLink.getUserLabel());
        linkData.setDirection(extLink.getDirection());
        linkData.setExtLinkType(extLink.getExtLinkType());
        linkData.setAdminStatus(extLink.getAdminStatus());
        linkData.setOperateStatus(extLink.getOperateStatus());
        linkData.setLayerRate(extLink.getLayerRate());
        linkData.setLeftLtpId(extLink.getLeftLtpId());
        linkData.setLeftNodeId(extLink.getLeftNodeId());
        linkData.setRightLtpId(extLink.getRightLtpId());
        linkData.setRightNodeId(extLink.getRightNodeId());

        linkData.setLatency(extLink.getLinkTeAttrCfg().getLatency());
        linkData.setMaxReservableBandwidth(extLink.getLinkTeAttrCfg().getMaxReservableBandwidth());

        linkData.setAvailableBandwidth(extLink.getLinkTeAttrRun().getAvailableBandwidth());
        linkData.setLinkLatency(extLink.getLinkTeAttrRun().getLinkLatency());
        linkData.setPhysicalBandwidth(extLink.getLinkTeAttrRun().getPhysicalBandwidth());

        extLink.setLeftLtpMac(extLink.getLeftLtpMac());
        extLink.setRightLtpMac(extLink.getRightLtpMac());
        return linkData;
    }

    public static LinkData parserLink(Link link) {
        LinkData linkData = new LinkData();
        linkData.setUuid(link.getId());
        linkData.setName(link.getName());
        linkData.setUserLabel(link.getUserLabel());
        linkData.setDirection(link.getDirection());
        linkData.setAdminStatus(link.getAdminStatus());
        linkData.setOperateStatus(link.getOperateStatus());
        linkData.setLayerRate(link.getLayerRate());
        linkData.setLeftLtpId(link.getLeftLtpId());
        linkData.setLeftNodeId(link.getLeftNodeId());
        linkData.setRightLtpId(link.getRightLtpId());
        linkData.setRightNodeId(link.getRightNodeId());

        linkData.setLatency(link.getLinkTeAttrCfg().getLatency());
        linkData.setMaxReservableBandwidth(link.getLinkTeAttrCfg().getMaxReservableBandwidth());

        linkData.setAvailableBandwidth(link.getLinkTeAttrRun().getAvailableBandwidth());
        linkData.setLinkLatency(link.getLinkTeAttrRun().getLinkLatency());
        linkData.setPhysicalBandwidth(link.getLinkTeAttrRun().getPhysicalBandwidth());

        return linkData;
    }

    public static LinkData parserLinkWithLinkTeAttrCfg(String linkId, LinkTeAttrCfg linkTeAttrCfg) {
        LinkData linkData = new LinkData();
        linkData.setUuid(linkId);
        linkData.setLatency(linkTeAttrCfg.getLatency());
        linkData.setMaxReservableBandwidth(linkTeAttrCfg.getMaxReservableBandwidth());
        return linkData;

    }

    public static String getNodeUuidByNodeId(String nodeId) {
        String neUuid = null;
        try {
            EmsConfigOrQueryResult result = CmnbEmsHelper.getInstance().getNodeUuidByNodeId(nodeId);
            switch (result.getResult()) {
                case Success:
                    neUuid = result.getValue().toString();
                    break;
                case Fail:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return neUuid;
    }

    public static SncTunnel parserSncTunnelData(SncTunnelData sncTunnelData) {
        SncTunnel sncTunnel = new SncTunnel();
        sncTunnel.setId(sncTunnelData.getUuid());
        sncTunnel.setName(sncTunnelData.getName());
        sncTunnel.setUserLabel(sncTunnelData.getUserLabel());
        sncTunnel.setTenantId(sncTunnelData.getTenantId());
        sncTunnel.setCreater(sncTunnelData.getCreater());
        sncTunnel.setParentNcdId(getParameter("parentNcdId"));
        sncTunnel.setDirection(sncTunnelData.getDirection());
        sncTunnel.setType(sncTunnelData.getType());
        sncTunnel.setSourceNeId(sncTunnelData.getSourceNeId());
        sncTunnel.setDestinationNeId(sncTunnelData.getDestinationNeId());
        sncTunnel.setSourceIp(sncTunnelData.getSourceIp());
        sncTunnel.setDestinationIp(sncTunnelData.getDestinationIp());

        if (sncTunnelData.getQos() != null) {
            sncTunnel.setQos(parserQosData(sncTunnelData.getQos()));
        }

        if (sncTunnelData.getSncSwitch() != null) {
            sncTunnel.setSncSwitch(parserSncSwitchData(sncTunnelData.getSncSwitch()));
        }

        if (sncTunnelData.getSncLsp() != null && sncTunnelData.getSncLsp().size() > 0) {
            List<SncLsp> sncLsps = new ArrayList<>();
            for (SncLspData sncLspData : sncTunnelData.getSncLsp()) {
                sncLsps.add(parserSncLspData(sncLspData));
            }
            sncTunnel.setSncLsp(sncLsps);
        }

        sncTunnel.setAdminStatus(sncTunnelData.getAdminStatus());
        sncTunnel.setOperateStatus(sncTunnelData.getOperateStatus());

        return sncTunnel;

    }

    public static Qos parserQosData(QosData qosData) {
        Qos qos = new Qos();
        qos.setBelongedId(qosData.getBelongedId());
        qos.setTunnelMode(qosData.getTunnelMode());
        qos.setCacMode(qosData.getCacMode());
        qos.setConvgMode(qosData.getConvgMode());
        qos.setTrafficAdjMode(qosData.getTrafficAdjMode());
        qos.setA2zPolicing(qosData.getA2zPolicing());
        qos.setZ2aPolicing(qosData.getZ2aPolicing());
        qos.setA2zCir(qosData.getA2zCir());
        qos.setZ2aCir(qosData.getZ2aCir());
        qos.setA2zPir(qosData.getA2zPir());
        qos.setZ2aPir(qosData.getZ2aPir());
        qos.setA2zCbs(qosData.getA2zCbs());
        qos.setZ2aCbs(qosData.getZ2aCbs());
        qos.setA2zPbs(qosData.getA2zPbs());
        qos.setZ2aPbs(qosData.getZ2aPbs());
        qos.setA2zColorMode(qosData.getA2zColorMode());
        qos.setZ2aColorMode(qosData.getZ2aColorMode());
        qos.setTrafficClass(qosData.getTrafficClass());
        return qos;
    }

    public static SncSwitch parserSncSwitchData(SncSwitchData sncSwitchData) {
        SncSwitch sncSwitch = new SncSwitch();
        sncSwitch.setSncId(sncSwitchData.getSncId());
        sncSwitch.setName(sncSwitchData.getName());
        sncSwitch.setLayerRate(sncSwitchData.getLayerRate());
        sncSwitch.setLinearProtectionType(sncSwitchData.getLinearProtectionType());
        sncSwitch.setLinearProtectionProtocol(sncSwitchData.getLinearProtectionProtocol());
        sncSwitch.setSwitchMode(sncSwitchData.getSwitchMode());
        sncSwitch.setRevertiveMode(sncSwitchData.getRevertiveMode());
        sncSwitch.setWtr(sncSwitchData.getWtr());
        sncSwitch.setHoldOffTime(sncSwitchData.getHoldOffTime());
        sncSwitch.setRerouteRevertiveMode(sncSwitchData.getRerouteRevertiveMode());
        sncSwitch.setRerouteWtr(sncSwitchData.getRerouteWtr());

        return sncSwitch;
    }

    public static SncLsp parserSncLspData(SncLspData sncLspData) {
        SncLsp sncLsp = new SncLsp();
        sncLsp.setId(sncLspData.getUuid());
        sncLsp.setName(sncLspData.getName());
        sncLsp.setUserLabel(sncLspData.getUserLabel());
        sncLsp.setDirection(sncLspData.getDirection());
        sncLsp.setRole(sncLspData.getRole());
        sncLsp.setType(sncLspData.getType());
        sncLsp.setIngressNeId(sncLspData.getIngressNeId());
        sncLsp.setEgressNeId(sncLspData.getEgressNeId());
        if (sncLspData.getExplicitExcludeNes() != null
                || sncLspData.getExplicitIncludeLinks() != null
                || sncLspData.getExplicitIncludeNes() != null
                || sncLspData.getExplicitExcludeLinks() != null) {
            NeLinkConstraint lspConstraint = new NeLinkConstraint();

            if (sncLspData.getExplicitIncludeNes() != null && sncLspData.getExplicitIncludeNes().size() > 0) {
                lspConstraint.setExplicitIncludeNeList(sncLspData.getExplicitIncludeNes());
            }

            if (sncLspData.getExplicitIncludeLinks()!=null&&sncLspData.getExplicitIncludeLinks().size()>0){

                lspConstraint.setExplicitIncludeLinkList(sncLspData.getExplicitIncludeLinks());
            }

            if (sncLspData.getExplicitExcludeNes() != null && sncLspData.getExplicitExcludeNes().size() > 0) {
                lspConstraint.setExplicitExcludeNeList(sncLspData.getExplicitExcludeNes());
            }

            if (sncLspData.getExplicitExcludeLinks()!=null&&sncLspData.getExplicitExcludeLinks().size()>0){
                lspConstraint.setExplicitExcludeLinkList(sncLspData.getExplicitExcludeLinks());
            }

            sncLsp.setLspConstraint(lspConstraint);
        }
        sncLsp.setAdminStatus(sncLspData.getAdminStatus());
        sncLsp.setOperateStatus(sncLspData.getOperateStatus());

        if (sncLspData.getOam()!=null){
            sncLsp.setOam(parserOamData(sncLspData.getOam()));
        }
        return sncLsp;

    }

    public static Oam parserOamData(OamData oamData) {
        Oam oam=new Oam();
        oam.setBelongedId(oamData.getBelongedId());
        oam.setName(oamData.getName());
        oam.setMegId(oamData.getMegId());

        if (oamData.getMep()!=null&&oamData.getMep().size()>0){
            List<Mep> meps=new ArrayList<>();
            for (MepData mepData:oamData.getMep()){
                meps.add(parserMepData(mepData));
            }
            oam.setMep(meps);
        }

        oam.setCcAllow(oamData.isCcAllow());
        oam.setCcExp(oamData.getCcExp());
        oam.setCcInterval(oamData.getCcInterval());
        oam.setLmMode(oamData.getLmMode());
        oam.setDmMode(oamData.getDmMode());
        return oam;
    }

    public static Mep parserMepData(MepData mepData) {
        Mep mep=new Mep();
        mep.setId(mepData.getId());
        mep.setName(mepData.getName());
        return mep;
    }

    public static CreateTunnelInputData parserCreateTunnelInput(CreateTunnelInput input){
        CreateTunnelInputData createTunnelInputData=new CreateTunnelInputData();

        SncTunnelData sncTunnelData=new SncTunnelData();
        sncTunnelData.setUuid(input.getSncTunnel().getId());
        sncTunnelData.setName(input.getSncTunnel().getName());
        sncTunnelData.setUserLabel(input.getSncTunnel().getUserLabel());
        sncTunnelData.setTenantId(input.getSncTunnel().getTenantId());
        sncTunnelData.setCreater(input.getSncTunnel().getCreater());
        sncTunnelData.setDirection(input.getSncTunnel().getDirection());
        sncTunnelData.setType(input.getSncTunnel().getType());
        sncTunnelData.setSourceNeId(input.getSncTunnel().getSourceNeId());
        sncTunnelData.setDestinationNeId(input.getSncTunnel().getDestinationNeId());
        sncTunnelData.setSourceIp(input.getSncTunnel().getSourceIp());
        sncTunnelData.setDestinationIp(input.getSncTunnel().getDestinationIp());

        if (input.getSncTunnel().getQos()!=null){
            QosData qosData=parserQos(input.getSncTunnel().getQos());
            sncTunnelData.setQos(qosData);
        }

        if (input.getSncTunnel().getSncSwitch()!=null){
            SncSwitchData sncSwitchData=parserSncSwitch(input.getSncTunnel().getSncSwitch());
            sncTunnelData.setSncSwitch(sncSwitchData);
        }

        if (input.getSncTunnel().getSncLsp().size()>0){
            List<SncLspData> sncLspDataList=new ArrayList<>();
            for (SncLsp sncLsp:input.getSncTunnel().getSncLsp()){
                SncLspData sncLspData=parserSncLsp(sncLsp);
                sncLspDataList.add(sncLspData);
            }

            sncTunnelData.setSncLsp(sncLspDataList);
        }

        sncTunnelData.setAdminStatus(input.getSncTunnel().getAdminStatus());
        sncTunnelData.setOperateStatus(input.getSncTunnel().getOperateStatus());

        return createTunnelInputData;
    }

    public static SncLspData parserSncLsp(SncLsp sncLsp){
        SncLspData sncLspData=new SncLspData();
        sncLspData.setUuid(sncLsp.getId());
        sncLspData.setName(sncLsp.getName());
        sncLspData.setUserLabel(sncLsp.getUserLabel());
        sncLspData.setDirection(sncLsp.getDirection());
        sncLspData.setRole(sncLsp.getRole());
        sncLspData.setType(sncLsp.getType());
        sncLspData.setIngressNeId(sncLsp.getIngressNeId());
        sncLspData.setEgressNeId(sncLsp.getIngressNeId());

        if (sncLsp.getLspConstraint().getExplicitExcludeNeList() != null && sncLsp.getLspConstraint().getExplicitExcludeNeList().size() > 0) {
            sncLspData.setExplicitExcludeNes(sncLsp.getLspConstraint().getExplicitExcludeNeList());
        }

        if (sncLsp.getLspConstraint().getExplicitExcludeLinkList() != null && sncLsp.getLspConstraint().getExplicitExcludeLinkList().size() > 0) {
            sncLspData.setExplicitExcludeLinks(sncLsp.getLspConstraint().getExplicitExcludeLinkList());
        }

        if (sncLsp.getLspConstraint().getExplicitIncludeNeList() != null && sncLsp.getLspConstraint().getExplicitIncludeNeList().size() > 0) {
            sncLspData.setExplicitIncludeNes(sncLsp.getLspConstraint().getExplicitIncludeNeList());
        }

        if (sncLsp.getLspConstraint().getExplicitIncludeLinkList() != null && sncLsp.getLspConstraint().getExplicitIncludeLinkList().size() > 0) {
            sncLspData.setExplicitIncludeLinks(sncLsp.getLspConstraint().getExplicitIncludeLinkList());
        }

        sncLspData.setAdminStatus(sncLsp.getAdminStatus());
        sncLspData.setOperateStatus(sncLsp.getOperateStatus());

        if (sncLsp.getOam()!=null){
            sncLspData.setOam(parserOam(sncLsp.getOam()));
        }

        return sncLspData;
    }

    public static QosData parserQos(Qos qos){
        QosData qosData=new QosData();
        qosData.setBelongedId(qos.getBelongedId());
        qosData.setTunnelMode(qos.getTunnelMode());
        qosData.setCacMode(qos.getCacMode());
        qosData.setConvgMode(qos.getConvgMode());
        qosData.setTrafficAdjMode(qos.getTrafficAdjMode());
        qosData.setA2zPolicing(qos.getA2zPolicing());
        qosData.setZ2aPolicing(qos.getZ2aPolicing());
        qosData.setA2zCir(qos.getA2zCir());
        qosData.setZ2aCir(qos.getZ2aCir());
        qosData.setA2zPir(qos.getA2zPir());
        qosData.setZ2aPir(qos.getZ2aPir());
        qosData.setA2zCbs(qos.getA2zCbs());
        qosData.setZ2aCbs(qos.getZ2aCbs());
        qosData.setA2zPbs(qos.getA2zPbs());
        qosData.setZ2aPbs(qos.getZ2aPbs());
        qosData.setA2zColorMode(qos.getA2zColorMode());
        qosData.setZ2aColorMode(qos.getZ2aColorMode());
        qosData.setTrafficClass(qos.getTrafficClass());
        return qosData;
    }

    public static SncSwitchData parserSncSwitch(SncSwitch sncSwitch){
        SncSwitchData sncSwitchData=new SncSwitchData();
        sncSwitchData.setSncId(sncSwitch.getSncId());
        sncSwitchData.setName(sncSwitch.getName());
        sncSwitchData.setLayerRate(sncSwitch.getLayerRate());
        sncSwitchData.setLinearProtectionType(sncSwitch.getLinearProtectionType());
        sncSwitchData.setLinearProtectionProtocol(sncSwitch.getLinearProtectionProtocol());
        sncSwitchData.setSwitchMode(sncSwitch.getSwitchMode());
        sncSwitchData.setRevertiveMode(sncSwitch.getRevertiveMode());
        sncSwitchData.setWtr(sncSwitch.getWtr());
        sncSwitchData.setHoldOffTime(sncSwitch.getHoldOffTime());
        sncSwitchData.setRerouteRevertiveMode(sncSwitch.getRerouteRevertiveMode());
        sncSwitchData.setRerouteWtr(sncSwitch.getRerouteWtr());
        return sncSwitchData;
    }

    public static OamData parserOam(Oam oam){
        OamData oamData=new OamData();
        oamData.setBelongedId(oam.getBelongedId());
        oamData.setName(oam.getName());
        oamData.setMegId(oam.getMegId());

        if (oam.getMep()!=null&&oam.getMep().size()>0){
            List<MepData> mepDatas=new ArrayList<>();
            for (Mep mep:oam.getMep()){
                mepDatas.add(parserMep(mep));
            }
            oamData.setMep(mepDatas);
        }

        oamData.setCcAllow(oam.isCcAllow());
        oamData.setCcExp(oam.getCcExp());
        oamData.setCcInterval(oam.getCcInterval());
        oamData.setLmMode(oam.getLmMode());
        oamData.setDmMode(oam.getDmMode());
        return oamData;
    }

    public static MepData parserMep(Mep mep){
        MepData mepData=new MepData();
        mepData.setId(mep.getId());
        mepData.setName(mep.getName());
        return mepData;
    }

    public static SncRoute parserSncRouteData(SncRouteData sncRouteData){
        SncRoute sncRoute=new SncRoute();
        sncRoute.setId(sncRouteData.getUuid());
        sncRoute.setName(sncRouteData.getName());
        sncRoute.setLayerRate(sncRouteData.getLayerRate());
        sncRoute.setSncId(sncRouteData.getSncId());

        if (sncRouteData.getXcDataList().size()>0){
            List<XcList> xcLists=new ArrayList<>();
            for (XcData xcData:sncRouteData.getXcDataList()){
                XcList xcList=parserXcData(xcData);
                xcLists.add(xcList);
            }
            Xcs xcs=new Xcs();
            xcs.setXcList(xcLists);
            sncRoute.setXcs(xcs);
        }

        return sncRoute;
    }

    public static XcList parserXcData(XcData xcData){
        XcList xcList=new XcList();
        xcList.setNeId(xcData.getNeId());
        xcList.setIngressLtpId(xcData.getIngressLtpId());
        xcList.setForwardInLabel(xcData.getForwardInLabel());
        xcList.setBackwardOutLabel(xcData.getBackwardOutLabel());
        xcList.setBackwardPeerId(xcData.getBackwardPeerId());
        xcList.setEgressLtpId(xcData.getEgressLtpId());
        xcList.setForwardOutLabel(xcData.getForwardOutLabel());
        xcList.setBackwardInLabel(xcData.getBackwardInLabel());
        xcList.setForwardPeerId(xcData.getForwardPeerId());
        xcList.setEgressVlan(xcData.getEgressVlan());
        xcList.setIngressVlan(xcData.getIngressVlan());

        return xcList;
    }

    public static SncRouteData parserSncRoute(SncRoute sncRoute){
        SncRouteData sncRouteData=new SncRouteData();
        sncRouteData.setUuid(sncRoute.getId());
        sncRouteData.setName(sncRoute.getName());
        sncRouteData.setLayerRate(sncRoute.getLayerRate());
        sncRouteData.setSncId(sncRoute.getSncId());

        if (sncRoute.getXcs().getXcList().size()>0){
            List<XcData> xcDataList=new ArrayList<>();
            for (XcList xcList:sncRoute.getXcs().getXcList()){
                XcData xcData=parserXcList(xcList);
                xcDataList.add(xcData);
            }

            sncRouteData.setXcDataList(xcDataList);
        }
        return sncRouteData;
    }

    public static XcData parserXcList(XcList xcList){
        XcData xcData=new XcData();
        xcData.setNeId(xcList.getNeId());
        xcData.setIngressLtpId(xcList.getIngressLtpId());
        xcData.setForwardInLabel(xcList.getForwardInLabel());
        xcData.setBackwardOutLabel(xcList.getBackwardOutLabel());
        xcData.setBackwardPeerId(xcList.getBackwardPeerId());
        xcData.setEgressLtpId(xcList.getEgressLtpId());
        xcData.setForwardOutLabel(xcList.getForwardOutLabel());
        xcData.setBackwardInLabel(xcList.getBackwardInLabel());
        xcData.setForwardPeerId(xcList.getForwardPeerId());
        xcData.setEgressVlan(xcList.getEgressVlan());
        xcData.setIngressVlan(xcList.getIngressVlan());
        return xcData;
    }

    public static RouteCalReqData parserRouteCalReq(RouteCalReq routeCalReq){
        RouteCalReqData routeCalReqData=new RouteCalReqData();
        routeCalReqData.setSequenceNo(routeCalReq.getRouteCalReqContainer().getSequenceNo());
        routeCalReqData.setCalculatePolicy(routeCalReq.getRouteCalReqContainer().getCalculatePolicy());
        routeCalReqData.setCalculateType(routeCalReq.getRouteCalReqContainer().getCalculateType());
        routeCalReqData.setCalculateMode(routeCalReq.getRouteCalReqContainer().getCalculateMode());
        routeCalReqData.setCalculateInterconnectionMode(routeCalReq.getRouteCalReqContainer().getCalculateInterconnectionMode());
        routeCalReqData.setLayerRate(routeCalReq.getRouteCalReqContainer().getLayerRate());
        routeCalReqData.setLeftNeId(routeCalReq.getRouteCalReqContainer().getLeftNeIds().getLeftNeId());
        routeCalReqData.setRightNeId(routeCalReq.getRouteCalReqContainer().getRightNeIds().getRightNeId());
        routeCalReqData.setWorkCalculateConstraint(routeCalReq.getRouteCalReqContainer().getWorkCalculateConstraint());
        routeCalReqData.setProtectCalculateConstraint(routeCalReq.getRouteCalReqContainer().getProtectCalculateConstraint());
        routeCalReqData.setTunnelUsePolicy(routeCalReq.getRouteCalReqContainer().getTunnelUsePolicy());
        routeCalReqData.setL3vpnId(routeCalReq.getRouteCalReqContainer().getL3vpnId());
        routeCalReqData.setGwIp(routeCalReq.getRouteCalReqContainer().getGwIp());
        routeCalReqData.setGwMask(routeCalReq.getRouteCalReqContainer().getGwMask());
        routeCalReqData.setVlan(routeCalReq.getRouteCalReqContainer().getVlan());

        return routeCalReqData;
    }

    public static RouteCalResult parserRouteCalResultData(RouteCalResultData routeCalResultData){
        RouteCalResult routeCalResult=new RouteCalResult();

        RouteCalResultContainer routeCalResultContainer=new RouteCalResultContainer();
        routeCalResultContainer.setSequenceNo(routeCalResultData.getSequenceNo());
        routeCalResultContainer.setGroupNo(routeCalResultData.getGroupNo());
        routeCalResultContainer.setRole(routeCalResultData.getRole());
        routeCalResultContainer.setIngressNeId(routeCalResultData.getIngressNeId());
        routeCalResultContainer.setEgressNeId(routeCalResultData.getEgressNeId());
        routeCalResultContainer.setLatency(routeCalResultContainer.getLatency());
        routeCalResultContainer.setMaxAvailbleBandwidth(routeCalResultData.getMaxAvailbleBandwidth());
        routeCalResult.setRouteCalResultContainer(routeCalResultContainer);

        if (routeCalResultData.getXcDataList().size()>0){
            Xcs xcs=new Xcs();
            List<XcList> xcLists=new ArrayList<>();
            for (XcData xcData:routeCalResultData.getXcDataList()){
                XcList xcList=parserXcData(xcData);
                xcLists.add(xcList);
            }
            xcs.setXcList(xcLists);
            routeCalResult.setXcs(xcs);

        }

        routeCalResult.setSharedTunnelId(routeCalResultData.getSharedTunnelId());

        return routeCalResult;

    }

    public static RerouteCalReqData parserRerouteCalReq(RerouteCalReq rerouteCalReq){

        RerouteCalReqData rerouteCalReqData=new RerouteCalReqData();
        rerouteCalReqData.setSequenceNo(rerouteCalReq.getRerouteCalReqContainer().getSequenceNo());
        rerouteCalReqData.setLayerRate(rerouteCalReq.getRerouteCalReqContainer().getLayerRate());
        rerouteCalReqData.setLspid(rerouteCalReq.getRerouteCalReqContainer().getLspid());
        rerouteCalReqData.setLeftNeId(rerouteCalReq.getRerouteCalReqContainer().getLeftNeId().getLeftNeId());
        rerouteCalReqData.setRightNeId(rerouteCalReq.getRerouteCalReqContainer().getRightNeIds().getRightNeId());
        rerouteCalReqData.setCalculateConstraint(rerouteCalReq.getRerouteCalReqContainer().getCalculateConstraint());
        return rerouteCalReqData;

    }

    public static RequestLabelsInputData parserRequestLabelsInput(RequestLabelsInput input){
        RequestLabelsInputData requestLabelsInputData=new RequestLabelsInputData();
        if (input.getNeIds().getNeIdList().size()>0){
            requestLabelsInputData.setNeIdLists(input.getNeIds().getNeIdList());
        }

        requestLabelsInputData.setLabelNumber(input.getLabelNumber());
        return requestLabelsInputData;
    }
}
