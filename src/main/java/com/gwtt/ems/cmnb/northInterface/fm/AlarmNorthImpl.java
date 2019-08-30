package com.gwtt.ems.cmnb.northInterface.fm;

import com.gwtt.ems.cmnb.main.CmnbMain;
import com.gwtt.ems.cmnb.model.north.fault.AlarmList;
import com.gwtt.ems.cmnb.model.north.fault.Alarms;
import com.gwtt.ems.cmnb.model.north.fault.CurrentAlarmQueryCond;
import com.gwtt.ems.cmnb.model.north.fault.QueryAlarmsResponse;
import com.gwtt.ems.cmnb.northInterface.RestError.DealRestConfError;
import com.gwtt.ems.cmnb.northInterface.RestError.RestConfErrorList;
import com.gwtt.ems.cmnb.util.CmnbUtil;
import com.gwtt.nms.faultd.Alarm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by chenjj on 2019/8/29
 */

@Component
public class AlarmNorthImpl implements AlarmNorthAPI {
    private static final Logger LOG = LoggerFactory.getLogger(AlarmNorthImpl.class);

    @Override
    public Response queryAlarms(CurrentAlarmQueryCond request) {
        LOG.info("queryAlarms:{}", request.toString());
        if (request == null) {
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }

        //查找平台告警
        Alarm alarmCond = new Alarm();
        alarmCond.setId(Integer.valueOf(request.getId()));
        alarmCond.setSeverity(request.getPerceivedSeverity());
        alarmCond.setSource(request.getDetailAlarmSource());
//        alarmCond.setType(request.getAlarmType());
        alarmCond.setMessage(request.getProbableCause());
        long beginTime = 0L;
        long endTime = 0L;
        if (request.getBeginAlarmRaisedTime() != null) {
            beginTime = CmnbUtil.getMillisecondTime(request.getBeginAlarmRaisedTime());
        }
        if (request.getEndAlarmRaisedTime() != null) {
            endTime = CmnbUtil.getMillisecondTime(request.getEndAlarmRaisedTime());
        }

        if(beginTime>endTime){
            RestConfErrorList errorList = DealRestConfError.badRequest();
            return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
        }
        List<AlarmList> alarmList = new ArrayList<>();
        Alarms alarms=new Alarms();
        QueryAlarmsResponse response=new QueryAlarmsResponse();
        try {
            Vector vector = CmnbMain.alarmApi.getAlarms(alarmCond);
            if (vector.size() > 0) {
                //如果没有时间限制，则全部输出
                if (beginTime==0L&&endTime==0L) {
                    for (int i = 0; i < vector.size(); i++) {
                        Alarm nmsAlarm = (Alarm) vector.elementAt(i);
                        AlarmList alarm = CmnbUtil.parserAlarm(nmsAlarm);
                        alarmList.add(alarm);
                    }
                }
                //只有起始时间
                else if(beginTime>0&&endTime==0L){
                    for (int i = 0; i < vector.size(); i++) {
                        Alarm nmsAlarm = (Alarm) vector.elementAt(i);
                        if (nmsAlarm.getCreateTime()>beginTime){
                            AlarmList alarm = CmnbUtil.parserAlarm(nmsAlarm);
                            alarmList.add(alarm);
                        }
                    }
                }
                //只有结束时间
                else if(beginTime==0L&&endTime>0){
                    for (int i = 0; i < vector.size(); i++) {
                        Alarm nmsAlarm = (Alarm) vector.elementAt(i);
                        if (nmsAlarm.getCreateTime()<endTime){
                            AlarmList alarm = CmnbUtil.parserAlarm(nmsAlarm);
                            alarmList.add(alarm);
                        }
                    }
                }
                //同时有起始时间和结束时间
                else {
                    for (int i = 0; i < vector.size(); i++) {
                        Alarm nmsAlarm = (Alarm) vector.elementAt(i);
                        if (nmsAlarm.getCreateTime()>beginTime&&nmsAlarm.getCreateTime()<endTime){
                            AlarmList alarm = CmnbUtil.parserAlarm(nmsAlarm);
                            alarmList.add(alarm);
                        }
                    }
                }
            }
            if (alarmList.size()>0){
                alarms.setAlarmList(alarmList);
                response.setAlarms(alarms);
                LOG.info("queryAlarms:{}", alarms.toString());
                return Response.status(Response.Status.OK).entity(response).build();
            }else {
                LOG.info("queryAlarms:{}", "no such alarms");
                return Response.status(Response.Status.NO_CONTENT).entity("").build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            RestConfErrorList errorList = DealRestConfError.serverError();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorList).build();
        }
    }
}
