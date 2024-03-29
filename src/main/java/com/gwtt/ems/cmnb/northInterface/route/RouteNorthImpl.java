package com.gwtt.ems.cmnb.northInterface.route;

import com.gwtt.ems.cmnb.model.common.CommandResult;
import com.gwtt.ems.cmnb.model.north.route.*;
import com.gwtt.ems.cmnb.model.north.tunnel.ConfigServiceResult;
import com.gwtt.ems.cmnb.model.south.route.*;
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
 * Created by chenjj on 2019/9/18
 */

@Component
public class RouteNorthImpl implements RouteNorthAPI {
    private static final Logger LOG = LoggerFactory.getLogger(RouteNorthImpl.class);

    @Override
    public Response getSncRouteForPw(String pwId, String lspId) {
        LOG.info("getSncRouteForPw:{},{}", pwId, lspId);
        if (pwId == null && lspId == null) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();

        } else {
            SncRouteData sncRouteData;
            if (pwId != null) {
                sncRouteData = CmnbServiceHelper.getInstance().getSncRouteByPw(pwId);
            } else {
                sncRouteData = CmnbServiceHelper.getInstance().getSncRouteByLsp(lspId);
            }
            //操作异常，Ems未返回错误
            if (sncRouteData == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回数据
                if (sncRouteData.getUuid() != null) {
                    SncRoute sncRoute = CmnbUtil.parserSncRouteData(sncRouteData);
                    LOG.info("getSncRouteForPw:{}", sncRoute.toString());
                    return Response.status(Response.Status.OK).entity(sncRoute).build();
                } else {
                    //无数据，Ems返回错误描述
                    RestConfErrorList errorList = DealRestConfError.noContent(sncRouteData.getErrorDesc());
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
                }
            }
        }
    }

    @Override
    public Response modifyLspRouteProperty(String tunnelId, String lspId, SncRoute sncRoute) {
        LOG.info("modifyLspRouteProperty:{},{}", tunnelId + ":" + lspId, sncRoute.toString());
        if (lspId == null || sncRoute == null) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }
        try {
            SncRouteData sncRouteData = CmnbUtil.parserSncRoute(sncRoute);
            CommandResult commandResult = CmnbServiceHelper.getInstance().modifyLspRouteProperty(tunnelId, lspId, sncRouteData);
            //操作异常，Ems未返回错误
            if (commandResult == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回配置结果
                ConfigServiceResult configServiceResult = new ConfigServiceResult();
                configServiceResult.setCommandResult(commandResult);
                LOG.info("modifyLspRouteProperty:{}", commandResult.toString());
                return Response.status(Response.Status.OK).entity(configServiceResult).build();
            }

        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList = DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();

        }
    }

    @Override
    public Response requestRoutes(RequestRoutesInput input) {
        LOG.info("requestRoutes:{}", input.toString());
        if (input == null) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }

        List<RouteCalResult> routeCalResults = new ArrayList<>();
        try {
            List<RouteCalReqData> routeCalReqDataList = new ArrayList<>();
            if (input.getRouteCalReqs().getRouteCalReq().size() > 0) {
                for (RouteCalReq routeCalReq : input.getRouteCalReqs().getRouteCalReq()) {
                    RouteCalReqData routeCalReqData = CmnbUtil.parserRouteCalReq(routeCalReq);
                    routeCalReqDataList.add(routeCalReqData);
                }
            }
            RequestRoutesOutputData requestRoutesOutputData = CmnbServiceHelper.getInstance().requestRoutes(routeCalReqDataList);
            //操作异常，Ems未返回错误
            if (requestRoutesOutputData == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回数据列表
                if (requestRoutesOutputData.getRouteCalResultDataList().size() > 0) {
                    for (RouteCalResultData routeCalResultData : requestRoutesOutputData.getRouteCalResultDataList()) {
                        RouteCalResult routeCalResult = CmnbUtil.parserRouteCalResultData(routeCalResultData);
                        routeCalResults.add(routeCalResult);
                    }

                    RequestRoutesOutput requestRoutesOutput = new RequestRoutesOutput();
                    requestRoutesOutput.setRouteCalResult(routeCalResults);
                    LOG.info("requestRoutes:{}", routeCalResults.toString());
                    return Response.status(Response.Status.OK).entity(requestRoutesOutput).build();
                } else {
                    //无数据，Ems返回错误描述
                    RestConfErrorList errorList = DealRestConfError.noContent(requestRoutesOutputData.getErrorDesc());
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
    public Response requestRestoreRoutes(RequestRestoreRoutesInput input) {
        LOG.info("requestRestoreRoutes:{}", input.toString());
        if (input == null) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }

        List<RouteCalResult> routeCalResults = new ArrayList<>();
        try {
            List<RerouteCalReqData> rerouteCalReqDataList = new ArrayList<>();
            if (input.getRerouteCalReqs().getRerouteCalReq().size() > 0) {
                for (RerouteCalReq rerouteCalReq : input.getRerouteCalReqs().getRerouteCalReq()) {
                    RerouteCalReqData rerouteCalReqData = CmnbUtil.parserRerouteCalReq(rerouteCalReq);
                    rerouteCalReqDataList.add(rerouteCalReqData);
                }
            }
            RequestRoutesOutputData requestRoutesOutputData = CmnbServiceHelper.getInstance().requestRestoreRoutes(rerouteCalReqDataList);
            //操作异常，Ems未返回错误
            if (requestRoutesOutputData == null) {
                RestConfErrorList errorList = DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            } else {
                //操作正常，返回数据列表
                if (requestRoutesOutputData.getRouteCalResultDataList().size() > 0) {
                    for (RouteCalResultData routeCalResultData : requestRoutesOutputData.getRouteCalResultDataList()) {
                        RouteCalResult routeCalResult = CmnbUtil.parserRouteCalResultData(routeCalResultData);
                        routeCalResults.add(routeCalResult);
                    }

                    RequestRoutesOutput requestRoutesOutput = new RequestRoutesOutput();
                    requestRoutesOutput.setRouteCalResult(routeCalResults);
                    LOG.info("requestRestoreRoutes:{}", routeCalResults.toString());
                    return Response.status(Response.Status.OK).entity(requestRoutesOutput).build();
                } else {
                    //无数据，Ems返回错误描述
                    RestConfErrorList errorList = DealRestConfError.noContent(requestRoutesOutputData.getErrorDesc());
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
