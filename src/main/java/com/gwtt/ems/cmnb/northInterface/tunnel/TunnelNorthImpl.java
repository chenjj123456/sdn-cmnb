package com.gwtt.ems.cmnb.northInterface.tunnel;

import com.gwtt.ems.cmnb.model.common.CommandResult;
import com.gwtt.ems.cmnb.model.north.tunnel.*;
import com.gwtt.ems.cmnb.model.south.tunnel.*;
import com.gwtt.ems.cmnb.northInterface.RestError.DealRestConfError;
import com.gwtt.ems.cmnb.northInterface.RestError.RestConfErrorList;
import com.gwtt.ems.cmnb.southInterface.service.CmnbServiceHelper;
import com.gwtt.ems.cmnb.util.CmnbUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenjj on 2019/9/16
 */
@Component
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

        List<SncTunnel> sncTunnelList = new ArrayList<>();
        try {
            SncTunnelDataList sncTunnelDataList = CmnbServiceHelper.getInstance().getAllSncTunnels(srcNeId,dstNeId);
            //操作异常，Ems未返回错误
            if (sncTunnelDataList == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回数据列表
                if (sncTunnelDataList.getSncTunnelDataList().size() > 0) {
                    for (SncTunnelData sncTunnelData : sncTunnelDataList.getSncTunnelDataList()) {
                        SncTunnel sncTunnel = CmnbUtil.parserSncTunnelData(sncTunnelData);
                        sncTunnelList.add(sncTunnel);
                    }

                    SncTunnels sncTunnels=new SncTunnels();
                    sncTunnels.setSncTunnel(sncTunnelList);
                    LOG.info("getAllSncTunnels:{}", sncTunnels.toString());
                    return Response.status(Response.Status.OK).entity(sncTunnels).build();
                } else {
                    //无数据，Ems返回错误描述
                    RestConfErrorList errorList = DealRestConfError.noContent(sncTunnelDataList.getErrorDesc());
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
    public Response getSncTunnelsById(String tunnelId, int depth) {
        LOG.info("getSncTunnelsById:{},{}",tunnelId,depth);

        List<SncTunnel> sncTunnelList = new ArrayList<>();
        try {
            SncTunnelData sncTunnelData = CmnbServiceHelper.getInstance().getSncTunnelsById(tunnelId);
            //操作异常，Ems未返回错误
            if (sncTunnelData == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回数据
                if (sncTunnelData.getUuid()!=null) {
                    SncTunnel sncTunnel=CmnbUtil.parserSncTunnelData(sncTunnelData);
                    LOG.info("getSncTunnelsById:{}", sncTunnel.toString());
                    return Response.status(Response.Status.OK).entity(sncTunnel).build();
                } else {
                    //无数据，Ems返回错误描述
                    RestConfErrorList errorList = DealRestConfError.noContent(sncTunnelData.getErrorDesc());
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
    public Response createTunnel(CreateTunnelInput input) {
        LOG.info("createTunnel:{}",input.toString());
        if (input == null) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }

        try {
            CreateTunnelInputData createTunnelInputData=CmnbUtil.parserCreateTunnelInput(input);
            CommandResult commandResult = CmnbServiceHelper.getInstance().createTunnel(createTunnelInputData);
            //操作异常，Ems未返回错误
            if (commandResult == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回配置结果
                ConfigServiceResult configServiceResult=new ConfigServiceResult();
                configServiceResult.setCommandResult(commandResult);
                LOG.info("createTunnel:{}", commandResult.toString());
                return Response.status(Response.Status.OK).entity(configServiceResult).build();
            }

        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList = DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();

        }
    }

    @Override
    public Response deleteTunnel(DeleteTunnelInput input) {
        LOG.info("deleteTunnel:{}",input.getTunnelId());
        if (input == null) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }

        try {
            CommandResult commandResult = CmnbServiceHelper.getInstance().deleteTunnel(input.getTunnelId());
            //操作异常，Ems未返回错误
            if (commandResult == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回配置结果
                ConfigServiceResult configServiceResult=new ConfigServiceResult();
                configServiceResult.setCommandResult(commandResult);
                LOG.info("deleteTunnel:{}", commandResult.toString());
                return Response.status(Response.Status.OK).entity(configServiceResult).build();
            }

        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList = DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();

        }
    }

    @Override
    public Response modifyTunnelBasicProperty(String tunnelId, String userLabel) {
        LOG.info("modifyTunnelBasicProperty:{},{}",tunnelId,userLabel);
        if (tunnelId == null||userLabel==null) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }
        try {
            CommandResult commandResult = CmnbServiceHelper.getInstance().modifyTunnelBasicProperty(tunnelId,userLabel);
            //操作异常，Ems未返回错误
            if (commandResult == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回配置结果
                ConfigServiceResult configServiceResult=new ConfigServiceResult();
                configServiceResult.setCommandResult(commandResult);
                LOG.info("modifyTunnelBasicProperty:{}", commandResult.toString());
                return Response.status(Response.Status.OK).entity(configServiceResult).build();
            }

        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList = DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();

        }
    }

    @Override
    public Response modifyTunnelQos(String tunnelId, Qos qos) {
        LOG.info("modifyTunnelQos:{},{}",tunnelId,qos.toString());
        if (tunnelId == null||qos==null) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }
        try {
            QosData qosData=CmnbUtil.parserQos(qos);
            CommandResult commandResult = CmnbServiceHelper.getInstance().modifyTunnelQos(tunnelId,qosData);
            //操作异常，Ems未返回错误
            if (commandResult == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回配置结果
                ConfigServiceResult configServiceResult=new ConfigServiceResult();
                configServiceResult.setCommandResult(commandResult);
                LOG.info("modifyTunnelQos:{}", commandResult.toString());
                return Response.status(Response.Status.OK).entity(configServiceResult).build();
            }

        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList = DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();

        }
    }

    @Override
    public Response modifyTunnelSwitchProperty(String tunnelId, SncSwitch sncSwitch) {
        LOG.info("modifyTunnelSwitchProperty:{},{}",tunnelId,sncSwitch.toString());
        if (tunnelId == null||sncSwitch==null) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }
        try {
            SncSwitchData sncSwitchData=CmnbUtil.parserSncSwitch(sncSwitch);
            CommandResult commandResult = CmnbServiceHelper.getInstance().modifyTunnelSwitchProperty(tunnelId,sncSwitchData);
            //操作异常，Ems未返回错误
            if (commandResult == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回配置结果
                ConfigServiceResult configServiceResult=new ConfigServiceResult();
                configServiceResult.setCommandResult(commandResult);
                LOG.info("modifyTunnelSwitchProperty:{}", commandResult.toString());
                return Response.status(Response.Status.OK).entity(configServiceResult).build();
            }

        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList = DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();

        }
    }
}
