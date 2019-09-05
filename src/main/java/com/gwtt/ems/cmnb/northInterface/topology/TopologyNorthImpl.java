package com.gwtt.ems.cmnb.northInterface.topology;

import com.gwtt.ems.cmnb.model.common.ConfigResult;
import com.gwtt.ems.cmnb.model.north.topology.*;
import com.gwtt.ems.cmnb.model.south.EmsConfigResult;
import com.gwtt.ems.cmnb.model.south.topology.*;
import com.gwtt.ems.cmnb.northInterface.RestError.DealRestConfError;
import com.gwtt.ems.cmnb.northInterface.RestError.RestConfErrorList;
import com.gwtt.ems.cmnb.southInterface.service.CmnbServiceHelper;
import com.gwtt.ems.cmnb.util.CmnbUtil;
import com.gwtt.ems.cmnb.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenjj on 2019/9/3
 */

@Component
public class TopologyNorthImpl implements TopoLogyNorthAPI {
    private static final Logger LOG = LoggerFactory.getLogger(TopologyNorthImpl.class);

    @Override
    public Response getTopologyByLayerRate(String layerRate) {
        LOG.info("getTopologyByLayerRate:{}", layerRate);
        if (layerRate == null) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }

        List<Topology> topologyList = new ArrayList<>();
        try {
            TopologyDataList topologyDataList = CmnbServiceHelper.getInstance().getTopologyByLayerRate(layerRate);
            //操作异常，Ems未返回错误
            if (topologyDataList == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回数据列表
                if (topologyDataList.getTopologyDataList().size() > 0) {
                    for (TopologyData topologyData : topologyDataList.getTopologyDataList()) {
                        Topology topology = CmnbUtil.parserTopologyData(topologyData);
                        topologyList.add(topology);
                    }

                    Topologies topologies = new Topologies();
                    topologies.setTopology(topologyList);
                    LOG.info("getTopologyByLayerRate:{}", topologyList.toString());
                    return Response.status(Response.Status.OK).entity(topologies).build();
                } else {
                    //无数据，Ems返回错误描述
                    RestConfErrorList errorList = DealRestConfError.noContent(topologyDataList.getErrorDesc());
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList = DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();

        }
    }

    @Override
    public Response getTopologyById(String id) {
        LOG.info("getTopologyById:{}", id);
        if (id == null) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }

        try {
            TopologyDataList topologyDataList = CmnbServiceHelper.getInstance().getTopologyByLayerRate(Constants.TOPOLOGY_ID_PHY);
            //操作异常，Ems未返回错误
            if (topologyDataList == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回数据列表
                Topology topology = null;
                if (topologyDataList.getTopologyDataList().size() > 0) {
                    for (TopologyData topologyData : topologyDataList.getTopologyDataList()) {
                        if (topologyData.getUuid().equals(id)) {
                            topology = CmnbUtil.parserTopologyData(topologyData);
                            break;
                        }
                    }

                    if (topology != null) {
                        LOG.info("getTopologyById:{}", topology.toString());
                        return Response.status(Response.Status.OK).entity(topology).build();
                    } else {
                        RestConfErrorList errorList = DealRestConfError.noContent("There is no such topology");
                        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
                    }

                } else {
                    //无数据，Ems返回错误描述
                    RestConfErrorList errorList = DealRestConfError.noContent(topologyDataList.getErrorDesc());
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList = DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();

        }
    }

    @Override
    public Response getTopoNodesByTopoId(String topoId) {
        LOG.info("getTopoNodesByTopoId:{}", topoId);
        if (topoId == null) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }

        List<Node> nodeList = new ArrayList<>();
        try {
            NodeDataList nodeDataList = CmnbServiceHelper.getInstance().getTopoNodesByTopoId(Constants.TOPOLOGY_ID_PHY, topoId);
            //操作异常，Ems未返回错误
            if (nodeDataList == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回数据列表
                if (nodeDataList.getNodeDataList().size() > 0) {
                    for (NodeData nodeData : nodeDataList.getNodeDataList()) {
                        Node node = CmnbUtil.parserNodeData(nodeData);
                        nodeList.add(node);
                    }

                    Nodes nodes = new Nodes();
                    nodes.setNode(nodeList);
                    LOG.info("getTopoNodesByTopoId:{}", nodeList.toString());
                    return Response.status(Response.Status.OK).entity(nodes).build();
                } else {
                    //无数据，Ems返回错误描述
                    RestConfErrorList errorList = DealRestConfError.noContent(nodeDataList.getErrorDesc());
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList = DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();

        }
    }

    @Override
    public Response getTopoExtNodesByTopoId(String topoId) {
        LOG.info("getTopoExtNodesByTopoId:{}", topoId);
        if (topoId == null) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }

        List<ExtNode> nodeList = new ArrayList<>();
        try {
            NodeDataList nodeDataList = CmnbServiceHelper.getInstance().getTopoExtNodesByTopoId(Constants.TOPOLOGY_ID_PHY, topoId);
            //操作异常，Ems未返回错误
            if (nodeDataList == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回数据列表
                if (nodeDataList.getNodeDataList().size() > 0) {
                    for (NodeData nodeData : nodeDataList.getNodeDataList()) {
                        ExtNode extNode = CmnbUtil.parserNodeDataToExtNode(nodeData);
                        nodeList.add(extNode);
                    }

                    ExtNodes extNodes = new ExtNodes();
                    extNodes.setExtNode(nodeList);
                    LOG.info("getTopoExtNodesByTopoId:{}", nodeList.toString());
                    return Response.status(Response.Status.OK).entity(extNodes).build();
                } else {
                    //无数据，Ems返回错误描述
                    RestConfErrorList errorList = DealRestConfError.noContent(nodeDataList.getErrorDesc());
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList = DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();

        }
    }

    @Override
    public Response getTopoLinksByTopoId(String topoId) {
        LOG.info("getTopoLinksByTopoId:{}", topoId);
        if (topoId == null) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }

        List<Link> linkList = new ArrayList<>();
        try {
            LinkDataList linkDataList = CmnbServiceHelper.getInstance().getTopoLinksByTopoId(Constants.TOPOLOGY_ID_PHY, topoId);
            //操作异常，Ems未返回错误
            if (linkDataList == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回数据列表
                if (linkDataList.getLinkDataList().size() > 0) {
                    for (LinkData linkData : linkDataList.getLinkDataList()) {
                        Link link = CmnbUtil.parserLinkData(linkData);
                        linkList.add(link);
                    }

                    Links links = new Links();
                    links.setLink(linkList);
                    LOG.info("getTopoLinksByTopoId:{}", linkList.toString());
                    return Response.status(Response.Status.OK).entity(links).build();
                } else {
                    //无数据，Ems返回错误描述
                    RestConfErrorList errorList = DealRestConfError.noContent(linkDataList.getErrorDesc());
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList = DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();

        }
    }

    @Override
    public Response getTopoExtLinksByTopoId(String topoId) {
        LOG.info("getTopoExtLinksByTopoId:{}", topoId);
        if (topoId == null) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }

        List<ExtLink> extLinkList = new ArrayList<>();
        try {
            LinkDataList linkDataList = CmnbServiceHelper.getInstance().getTopoExtLinksByTopoId(Constants.TOPOLOGY_ID_PHY, topoId);
            //操作异常，Ems未返回错误
            if (linkDataList == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回数据列表
                if (linkDataList.getLinkDataList().size() > 0) {
                    for (LinkData linkData : linkDataList.getLinkDataList()) {
                        ExtLink extLink = CmnbUtil.parserLinkDataToExtLink(linkData);
                        extLinkList.add(extLink);
                    }

                    ExtLinks extLinks = new ExtLinks();
                    extLinks.setExtLink(extLinkList);
                    LOG.info("getTopoExtLinksByTopoId:{}", extLinkList.toString());
                    return Response.status(Response.Status.OK).entity(extLinks).build();
                } else {
                    //无数据，Ems返回错误描述
                    RestConfErrorList errorList = DealRestConfError.noContent(linkDataList.getErrorDesc());
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList = DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();

        }
    }

    @Override
    public Response getTopoNodeByNodeId(String nodeId) {
        LOG.info("getTopoNodeByNodeId:{}", nodeId);
        if (nodeId == null) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }

        try {
            NodeData nodeData = CmnbServiceHelper.getInstance().getTopoNodeByNodeId(Constants.TOPOLOGY_ID_PHY, nodeId);
            //操作异常，Ems未返回错误
            if (nodeData == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回数据列表
                if (nodeData.getUuid() != null) {
                    Node node = CmnbUtil.parserNodeData(nodeData);
                    LOG.info("getTopoNodeByNodeId:{}", node.toString());
                    return Response.status(Response.Status.OK).entity(node).build();
                } else {
                    //无数据，Ems返回错误描述
                    RestConfErrorList errorList = DealRestConfError.noContent(nodeData.getErrorDesc());
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList = DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();

        }
    }

    @Override
    public Response getTopoExtNodeByNodeId(String nodeId) {
        LOG.info("getTopoExtNodeByNodeId:{}", nodeId);
        if (nodeId == null) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }

        try {
            NodeData nodeData = CmnbServiceHelper.getInstance().getTopoExtNodeByNodeId(Constants.TOPOLOGY_ID_PHY, nodeId);
            //操作异常，Ems未返回错误
            if (nodeData == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回数据列表
                if (nodeData.getUuid() != null) {
                    ExtNode extNode = CmnbUtil.parserNodeDataToExtNode(nodeData);
                    LOG.info("getTopoExtNodeByNodeId:{}", extNode.toString());
                    return Response.status(Response.Status.OK).entity(extNode).build();
                } else {
                    //无数据，Ems返回错误描述
                    RestConfErrorList errorList = DealRestConfError.noContent(nodeData.getErrorDesc());
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList = DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();

        }
    }

    @Override
    public Response getTopoLinkByLinkId(String linkId) {
        LOG.info("getTopoLinkByLinkId:{}", linkId);
        if (linkId == null) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }

        try {
            LinkData linkData = CmnbServiceHelper.getInstance().getTopoLinkByLinkId(Constants.TOPOLOGY_ID_PHY, linkId);
            //操作异常，Ems未返回错误
            if (linkData == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回数据列表
                if (linkData.getUuid() != null) {
                    Link link = CmnbUtil.parserLinkData(linkData);
                    LOG.info("getTopoLinkByLinkId:{}", link.toString());
                    return Response.status(Response.Status.OK).entity(link).build();
                } else {
                    //无数据，Ems返回错误描述
                    RestConfErrorList errorList = DealRestConfError.noContent(linkData.getErrorDesc());
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList = DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();

        }
    }

    @Override
    public Response getTopoExtLinkByLinkId(String linkId) {
        LOG.info("getTopoExtLinkByLinkId:{}", linkId);
        if (linkId == null) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }

        try {
            LinkData linkData = CmnbServiceHelper.getInstance().getTopoExtLinkByLinkId(Constants.TOPOLOGY_ID_PHY, linkId);
            //操作异常，Ems未返回错误
            if (linkData == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回数据列表
                if (linkData.getUuid() != null) {
                    ExtLink extLink = CmnbUtil.parserLinkDataToExtLink(linkData);
                    LOG.info("getTopoExtLinkByLinkId:{}", extLink.toString());
                    return Response.status(Response.Status.OK).entity(extLink).build();
                } else {
                    //无数据，Ems返回错误描述
                    RestConfErrorList errorList = DealRestConfError.noContent(linkData.getErrorDesc());
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList = DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();

        }
    }

    @Override
    public Response getTopoLinkTeAttrByLinkId(String linkId, String attr) {
        LOG.info("getTopoLinkTeAttrByLinkId:{},{}", linkId, attr);
        if (linkId == null || !attr.equalsIgnoreCase("true")) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }

        try {
            LinkData linkData = CmnbServiceHelper.getInstance().getTopoExtLinkByLinkId(Constants.TOPOLOGY_ID_PHY, linkId);
            //操作异常，Ems未返回错误
            if (linkData == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回数据列表
                if (linkData.getUuid() != null) {
                    Link link = CmnbUtil.parserLinkData(linkData);
                    LOG.info("getTopoLinkTeAttrByLinkId:{}", link.toString());
                    return Response.status(Response.Status.OK).entity(link).build();
                } else {
                    //无数据，Ems返回错误描述
                    RestConfErrorList errorList = DealRestConfError.noContent(linkData.getErrorDesc());
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList = DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();

        }
    }

    @Override
    public Response getTopoExtLinkTeAttrByLinkId(String linkId, String attr) {
        LOG.info("getTopoExtLinkTeAttrByLinkId:{},{}", linkId, attr);
        if (linkId == null || !attr.equalsIgnoreCase("true")) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }

        try {
            LinkData linkData = CmnbServiceHelper.getInstance().getTopoExtLinkByLinkId(Constants.TOPOLOGY_ID_PHY, linkId);
            //操作异常，Ems未返回错误
            if (linkData == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回数据列表
                if (linkData.getUuid() != null) {
                    ExtLink extlink = CmnbUtil.parserLinkDataToExtLink(linkData);
                    LOG.info("getTopoExtLinkTeAttrByLinkId:{}", extlink.toString());
                    return Response.status(Response.Status.OK).entity(extlink).build();
                } else {
                    //无数据，Ems返回错误描述
                    RestConfErrorList errorList = DealRestConfError.noContent(linkData.getErrorDesc());
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList = DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();

        }
    }

    @Override
    public Response createExtLink(ExtLink extLink) {
        LOG.info("createExtLink:{}", extLink.toString());
        if (extLink == null) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }
        try {

            LinkData linkData = CmnbUtil.parserExtLink(extLink);
            EmsConfigResult result = CmnbServiceHelper.getInstance().createExtLink(Constants.TOPOLOGY_ID_PHY,linkData);
            //操作异常，Ems未返回错误
            if (result == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回配置结果
                if (result.getResult().equals(ConfigResult.Success)) {
                    LOG.info("createExtLink:{}", "success");
                    return Response.status(Response.Status.OK).entity("success").build();
                } else {
                    LOG.info("createExtLink:{}", "failed");
                    RestConfErrorList errorList = DealRestConfError.noContent(result.getErrorDesc());
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList = DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
        }
    }

    @Override
    public Response deleteExtLink(String linkId) {
        LOG.info("deleteExtLink:{}", linkId);
        if (linkId == null) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }
        try {

            EmsConfigResult result = CmnbServiceHelper.getInstance().deleteExtLink(Constants.TOPOLOGY_ID_PHY,linkId);
            //操作异常，Ems未返回错误
            if (result == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回配置结果
                if (result.getResult().equals(ConfigResult.Success)) {
                    LOG.info("deleteExtLink:{}", "success");
                    return Response.status(Response.Status.OK).entity("success").build();
                } else {
                    LOG.info("deleteExtLink:{}", "failed");
                    RestConfErrorList errorList = DealRestConfError.noContent(result.getErrorDesc());
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList = DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
        }
    }

    @Override
    public Response configLink(String linkId, LinkTeAttrCfg linkTeAttrCfg) {
        LOG.info("configLink:{},{}", linkId,linkTeAttrCfg.toString());
        if (linkId == null||linkTeAttrCfg==null) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }
        try {

            LinkData linkData = CmnbUtil.parserLinkWithLinkTeAttrCfg(linkId,linkTeAttrCfg);
            EmsConfigResult result = CmnbServiceHelper.getInstance().configLink(Constants.TOPOLOGY_ID_PHY,linkData);
            //操作异常，Ems未返回错误
            if (result == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回配置结果
                if (result.getResult().equals(ConfigResult.Success)) {
                    LOG.info("configLink:{}", "success");
                    return Response.status(Response.Status.OK).entity("success").build();
                } else {
                    LOG.info("configLink:{}", "failed");
                    RestConfErrorList errorList = DealRestConfError.noContent(result.getErrorDesc());
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList = DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
        }
    }

    @Override
    public Response createLink(Link link) {
        LOG.info("createLink:{}", link.toString());
        if (link == null) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }
        try {

            LinkData linkData = CmnbUtil.parserLink(link);
            EmsConfigResult result = CmnbServiceHelper.getInstance().createLink(Constants.TOPOLOGY_ID_PHY,linkData);
            //操作异常，Ems未返回错误
            if (result == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回配置结果
                if (result.getResult().equals(ConfigResult.Success)) {
                    LOG.info("createLink:{}", "success");
                    return Response.status(Response.Status.OK).entity("success").build();
                } else {
                    LOG.info("createLink:{}", "failed");
                    RestConfErrorList errorList = DealRestConfError.noContent(result.getErrorDesc());
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList = DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
        }
    }

    @Override
    public Response deleteLink(String linkId) {
        LOG.info("deleteLink:{}", linkId);
        if (linkId == null) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }
        try {

            EmsConfigResult result = CmnbServiceHelper.getInstance().deleteLink(Constants.TOPOLOGY_ID_PHY,linkId);
            //操作异常，Ems未返回错误
            if (result == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回配置结果
                if (result.getResult().equals(ConfigResult.Success)) {
                    LOG.info("deleteLink:{}", "success");
                    return Response.status(Response.Status.OK).entity("success").build();
                } else {
                    LOG.info("deleteLink:{}", "failed");
                    RestConfErrorList errorList = DealRestConfError.noContent(result.getErrorDesc());
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList = DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
        }
    }
}
