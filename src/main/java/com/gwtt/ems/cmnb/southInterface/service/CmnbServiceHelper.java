package com.gwtt.ems.cmnb.southInterface.service;

import com.gwtt.ems.cmnb.model.common.AdminStatus;
import com.gwtt.ems.cmnb.model.common.CommandResult;
import com.gwtt.ems.cmnb.model.common.NeId;
import com.gwtt.ems.cmnb.model.south.EmsConfigOrQueryResult;
import com.gwtt.ems.cmnb.model.south.route.RequestRoutesOutputData;
import com.gwtt.ems.cmnb.model.south.route.RerouteCalReqData;
import com.gwtt.ems.cmnb.model.south.route.RouteCalReqData;
import com.gwtt.ems.cmnb.model.south.route.SncRouteData;
import com.gwtt.ems.cmnb.model.south.topology.*;
import com.gwtt.ems.cmnb.model.south.tunnel.*;
import com.gwtt.ems.cmnb.southInterface.eventListener.CmnbEventObserver;
import com.gwtt.ems.cmnb.util.CmnbLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * Created by chenjj on 2019/9/4
 */
public class CmnbServiceHelper {
    private static CmnbServiceHelper instance;
    private List<CmnbServiceAPI> cmnbServiceApis = new ArrayList<>();

    private CmnbServiceHelper() {
        try {
            ClassLoader loader = CmnbServiceAPI.class.getClassLoader();
            CmnbLogger.CMNBOUT.log("loader:" + loader, 3);
            ServiceLoader<CmnbServiceAPI> serviceLoader = ServiceLoader.load(CmnbServiceAPI.class, loader);
            CmnbLogger.CMNBOUT.log("serviceLoader:" + loader, 3);
            for (CmnbServiceAPI api : serviceLoader) {
                CmnbLogger.CMNBOUT.log("loader api:" + api, 3);
                cmnbServiceApis.add(api);
            }

        } catch (Exception ex) {

            CmnbLogger.CMNBERR.logException(ex, 3);
        }


    }

    public static synchronized CmnbServiceHelper getInstance() {
        if (instance == null) {
            instance = new CmnbServiceHelper();
        }
        return instance;
    }

    public void start() {
        if (cmnbServiceApis != null) {
            //模块发给REST的事件
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    api.addListener(CmnbEventObserver.getInstance());
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }

    }

    public void shutdown() {
        if (cmnbServiceApis != null) {
            //模块发给REST的事件
            for (CmnbServiceAPI api : cmnbServiceApis) {
                api.shutdown(CmnbEventObserver.getInstance());
            }
        }
    }

    public TopologyDataList getTopologyByLayerRate(String layerRate){
        TopologyDataList result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.getTopologyByLayerRate(layerRate);
                    //查询到一个结果后退出
                    if (result != null && result.getTopologyDataList().size() > 0) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public NodeDataList getTopoNodesByTopoId(String layerRate,String topoId){
        NodeDataList result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.getTopoNodesByTopoId(layerRate,topoId);
                    //查询到一个结果后退出
                    if (result != null && result.getNodeDataList().size() > 0) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public NodeDataList getTopoExtNodesByTopoId(String layerRate,String topoId){
        NodeDataList result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.getTopoExtNodesByTopoId(layerRate,topoId);
                    //查询到一个结果后退出
                    if (result != null && result.getNodeDataList().size() > 0) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public LinkDataList getTopoLinksByTopoId(String layerRate, String topoId){
        LinkDataList result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.getTopoLinksByTopoId(layerRate,topoId);
                    //查询到一个结果后退出
                    if (result != null && result.getLinkDataList().size() > 0) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public LinkDataList getTopoExtLinksByTopoId(String layerRate, String topoId){
        LinkDataList result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.getTopoExtLinksByTopoId(layerRate,topoId);
                    //查询到一个结果后退出
                    if (result != null && result.getLinkDataList().size() > 0) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }
    public NodeData getTopoNodeByNodeId(String layerRate, String nodeId){
        NodeData result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.getTopoNodeByNodeId(layerRate,nodeId);
                    //查询到一个结果后退出
                    if (result != null ) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public NodeData getTopoExtNodeByNodeId(String layerRate, String nodeId){
        NodeData result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.getTopoExtNodeByNodeId(layerRate,nodeId);
                    //查询到一个结果后退出
                    if (result != null ) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public LinkData getTopoLinkByLinkId(String layerRate, String linkId){
        LinkData result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.getTopoLinkByLinkId(layerRate,linkId);
                    //查询到一个结果后退出
                    if (result != null ) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public LinkData getTopoExtLinkByLinkId(String layerRate, String linkId){
        LinkData result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.getTopoExtLinkByLinkId(layerRate,linkId);
                    //查询到一个结果后退出
                    if (result != null ) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public EmsConfigOrQueryResult createExtLink(String layerRate,LinkData linkData){
        EmsConfigOrQueryResult result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.createExtLink(layerRate,linkData);
                    //查询到一个结果后退出
                    if (result != null ) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public EmsConfigOrQueryResult createLink(String layerRate,LinkData linkData){
        EmsConfigOrQueryResult result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.createLink(layerRate,linkData);
                    //查询到一个结果后退出
                    if (result != null ) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public EmsConfigOrQueryResult deleteExtLink(String layerRate,String linkId){
        EmsConfigOrQueryResult result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.deleteExtLink(layerRate,linkId);
                    //查询到一个结果后退出
                    if (result != null ) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public EmsConfigOrQueryResult deleteLink(String layerRate,String linkId){
        EmsConfigOrQueryResult result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.deleteLink(layerRate,linkId);
                    //查询到一个结果后退出
                    if (result != null ) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public EmsConfigOrQueryResult configLink(String layerRate,LinkData linkData){
        EmsConfigOrQueryResult result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.configLink(layerRate,linkData);
                    //查询到一个结果后退出
                    if (result != null ) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public SncTunnelDataList getAllSncTunnels(String srcNeId, String dstNeId){
        SncTunnelDataList result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.getAllSncTunnels(srcNeId,dstNeId);
                    //查询到一个结果后退出
                    if (result != null ) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }

        //用于测试
//        result=new SncTunnelDataList();
//        SncTunnelData sncTunnelData1=new SncTunnelData();
//        sncTunnelData1.setAdminStatus(AdminStatus.AdminUp);
//        sncTunnelData1.setDestinationIp("sdlfa");
//
//        SncTunnelData sncTunnelData2=new SncTunnelData();
//        sncTunnelData2.setAdminStatus(AdminStatus.AdminDown);
//        sncTunnelData2.setDestinationIp("zskdflh");
//        List<SncTunnelData> sncTunnelDatas=new ArrayList<>();
//        sncTunnelDatas.add(sncTunnelData1);
//        sncTunnelDatas.add(sncTunnelData2);
//        result.setSncTunnelDataList(sncTunnelDatas);
        return result;
    }

    public SncTunnelData getSncTunnelsById(String tunnelId){
        SncTunnelData result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.getSncTunnelsById(tunnelId);
                    //查询到一个结果后退出
                    if (result != null ) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public CommandResult createTunnel(CreateTunnelInputData createTunnelInputData){
        CommandResult result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.createTunnel(createTunnelInputData);
                    //查询到一个结果后退出
                    if (result != null ) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    //route一起删除
    public CommandResult deleteTunnel(String tunnelUuid){
        CommandResult result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.deleteTunnel(tunnelUuid);
                    //查询到一个结果后退出
                    if (result != null ) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public CommandResult modifyTunnelBasicProperty(String tunnelId,String userLabel){
        CommandResult result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.modifyTunnelBasicProperty(tunnelId,userLabel);
                    //查询到一个结果后退出
                    if (result != null ) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public CommandResult modifyTunnelQos(String tunnelId,QosData qosData){
        CommandResult result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.modifyTunnelQos(tunnelId,qosData);
                    //查询到一个结果后退出
                    if (result != null ) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public CommandResult modifyTunnelSwitchProperty(String tunnelId,SncSwitchData sncSwitchData){
        CommandResult result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.modifyTunnelSwitchProperty(tunnelId,sncSwitchData);
                    //查询到一个结果后退出
                    if (result != null ) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public CommandResult modifyLspOam(String tunnelId,String lspId,OamData oamData){
        CommandResult result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.modifyLspOam(tunnelId,lspId,oamData);
                    //查询到一个结果后退出
                    if (result != null ) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public SncRouteData getSncRouteByPw(String pwId){
        SncRouteData result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.getSncRouteByPw(pwId);
                    //查询到一个结果后退出
                    if (result != null ) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public SncRouteData getSncRouteByLsp(String lspId){
        SncRouteData result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.getSncRouteByLsp(lspId);
                    //查询到一个结果后退出
                    if (result != null ) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public CommandResult modifyLspRouteProperty(String tunnelId,String lspId,SncRouteData sncRouteData){
        CommandResult result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.modifyLspRouteProperty(tunnelId,lspId,sncRouteData);
                    //查询到一个结果后退出
                    if (result != null ) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }
    public RequestRoutesOutputData requestRoutes(List<RouteCalReqData> routeCalReqDataList){
        RequestRoutesOutputData result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.requestRoutes(routeCalReqDataList);
                    //查询到一个结果后退出
                    if (result != null ) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public RequestRoutesOutputData requestRestoreRoutes(List<RerouteCalReqData>rerouteCalReqDataList){
        RequestRoutesOutputData result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.requestRestoreRoutes(rerouteCalReqDataList);
                    //查询到一个结果后退出
                    if (result != null ) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public RequestLabelsOutputData requestLabels(RequestLabelsInputData requestLabelsInputData){
        RequestLabelsOutputData result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.requestLabels(requestLabelsInputData);
                    //查询到一个结果后退出
                    if (result != null ) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public RequestMegidSpacesOutputData requestMegidSpaces(List<NeId> neIds){
        RequestMegidSpacesOutputData result = null;

        if (cmnbServiceApis != null) {
            for (CmnbServiceAPI api : cmnbServiceApis) {
                try {
                    result = api.requestMegidSpaces(neIds);
                    //查询到一个结果后退出
                    if (result != null ) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }
}
