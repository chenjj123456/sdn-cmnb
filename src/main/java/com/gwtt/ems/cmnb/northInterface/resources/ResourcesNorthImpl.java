package com.gwtt.ems.cmnb.northInterface.resources;

import com.gwtt.ems.cmnb.model.north.resources.*;
import com.gwtt.ems.cmnb.model.south.resources.LtpDataList;
import com.gwtt.ems.cmnb.model.south.resources.NeData;
import com.gwtt.ems.cmnb.model.south.resources.NeDataList;
import com.gwtt.ems.cmnb.northInterface.RestError.DealRestConfError;
import com.gwtt.ems.cmnb.northInterface.RestError.RestConfErrorList;
import com.gwtt.ems.cmnb.southInterface.ems.CmnbEmsHelper;
import com.gwtt.ems.cmnb.util.CmnbUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenjj on 2019/9/1
 */

@Component
public class ResourcesNorthImpl implements ResourcesNorthAPI {
    private static final Logger LOG = LoggerFactory.getLogger(ResourcesNorthImpl.class);

    @Override
    public Response getNesByNcdId(String ncdId) {
        LOG.info("getNesByNcdId:{}", ncdId);
        if (ncdId==null){
            RestConfErrorList errorList=DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }

        List<Ne> neList = new ArrayList<>();
        try {
            NeDataList neDataList = CmnbEmsHelper.getInstance().getNes();
            //操作异常，Ems未返回错误
            if (neDataList==null){
                RestConfErrorList errorList=DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            }else {
                //操作正常，返回数据列表
                if(neDataList.getNeDataList().size()>0){
                    for (NeData neData : neDataList.getNeDataList()) {
                        Ne ne =CmnbUtil.parserNeData(neData);
                        neList.add(ne);
                    }

                    NeList neLists=new NeList();
                    neLists.setNe(neList);
                    Nes nes=new Nes();
                    nes.setNeList(neLists);
                    LOG.info("getNesByNcdId:{}", neList.toString());
                    return Response.status(Response.Status.OK).entity(nes).build();
                }else {
                    //无数据，Ems返回错误描述
                    RestConfErrorList errorList=DealRestConfError.noContent(neDataList.getErrorDesc());
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList=DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();

        }

    }

    @Override
    public Response getLtpsByNe(String neId) {
        LOG.info("getLtpsByNe:{}", neId);
        if (neId==null){
            RestConfErrorList errorList=DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }

        try {
            LtpDataList ltpDataList = CmnbEmsHelper.getInstance().getLtpsByNeId(neId);
            //操作异常，Ems未返回错误
            if (ltpDataList==null){
                RestConfErrorList errorList=DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            }else {
                //操作正常，返回数据列表
                if(ltpDataList.getLtpDataList().size()>0){
                    Ltps ltps=CmnbUtil.parserLtpDatas(ltpDataList.getLtpDataList());
                    LOG.info("getLtpsByNe:{}", ltps.toString());
                    return Response.status(Response.Status.OK).entity(ltps).build();
                    }
                else {
                    //无数据，Ems返回错误描述
                    RestConfErrorList errorList=DealRestConfError.noContent(ltpDataList.getErrorDesc());
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList=DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();

        }

    }

    @Override
    public Response getNcdById(String ncdId) {
        return null;
    }

    @Override
    public Response getNcds() {
        return null;
    }

    @Override
    public Response getNeById(String neId) {
        LOG.info("getNeById:{}", neId);
        if (neId==null){
            RestConfErrorList errorList=DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }

        try {
            NeData neData = CmnbEmsHelper.getInstance().getNeById(neId);
            //操作异常，Ems未返回错误
            if (neData==null){
                RestConfErrorList errorList=DealRestConfError.serverError();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
            }else {
                //操作正常，返回数据列表
                if(neData!=null){
                    Ne ne=CmnbUtil.parserNeData(neData);
                    LOG.info("getNeById:{}", ne.toString());
                    return Response.status(Response.Status.OK).entity(ne).build();
                }
                else {
                    //无数据，Ems返回错误描述
                    RestConfErrorList errorList=DealRestConfError.noContent(neData.getErrorDesc());
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList=DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();

        }
    }

    @Override
    public Response getAllNcds() {
        return null;
    }

    @Override
    public Response getSpecifiedNcd() {
        return null;
    }

    @Override
    public Response addMeLocation(AddMeLocationRequest request) {
        return null;
    }
}