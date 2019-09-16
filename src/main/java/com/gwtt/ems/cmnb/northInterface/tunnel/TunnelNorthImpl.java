package com.gwtt.ems.cmnb.northInterface.tunnel;

import com.gwtt.ems.cmnb.util.CmnbUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;

/**
 * Created by chenjj on 2019/9/16
 */
public class TunnelNorthImpl implements TunnelNorthAPI {
    private static final Logger LOG = LoggerFactory.getLogger(TunnelNorthImpl.class);

    @Override
    public Response getAllSncTunnels(int dep, String srcNeId, String dstNeId, String ncdId) {
        Object input[]={dep,srcNeId,dstNeId,ncdId};
        LOG.info("getAllSncTunnels:{},{},{},{}",input);
        if(srcNeId != null && srcNeId.equals("null")){
            srcNeId = null;
        }
        if(dstNeId != null && dstNeId.equals("null")){
            dstNeId = null;
        }

//        List<Topology> topologyList = new ArrayList<>();
//        try {
//            TopologyDataList topologyDataList = CmnbServiceHelper.getInstance().getTopologyByLayerRate(layerRate);
//            //操作异常，Ems未返回错误
//            if (topologyDataList == null) {
//                RestConfErrorList errorList = DealRestConfError.serverError();
//                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
//            } else {
//                //操作正常，返回数据列表
//                if (topologyDataList.getTopologyDataList().size() > 0) {
//                    for (TopologyData topologyData : topologyDataList.getTopologyDataList()) {
//                        Topology topology = CmnbUtil.parserTopologyData(topologyData);
//                        topologyList.add(topology);
//                    }
//
//                    Topologies topologies = new Topologies();
//                    topologies.setTopology(topologyList);
//                    LOG.info("getTopologyByLayerRate:{}", topologyList.toString());
//                    return Response.status(Response.Status.OK).entity(topologies).build();
//                } else {
//                    //无数据，Ems返回错误描述
//                    RestConfErrorList errorList = DealRestConfError.noContent(topologyDataList.getErrorDesc());
//                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            RestConfErrorList errorList = DealRestConfError.serverError();
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
//
//        }


        return null;
    }
}
