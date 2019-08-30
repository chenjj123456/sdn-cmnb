package com.gwtt.ems.cmnb.main;


import com.gwtt.ems.cmnb.northInterface.CmnbEventPush;
import com.gwtt.ems.cmnb.southInterface.eventListener.CmnbAlarmObserver;
import com.gwtt.ems.cmnb.util.CmnbLogger;
import com.gwtt.ems.cmnb.util.CmnbUtil;
import com.gwtt.ems.cmnb.websocket.server.WebSocketServer;
import com.gwtt.nms.faultd.AlarmAPI;
import com.gwtt.nms.topodbtemp.TopoAPI;
import com.gwtt.nms.util.NmsUtil;
import com.gwtt.nms.util.RunProcessInterface;

import java.rmi.RemoteException;

/**
 * Created by chenjj on 2019/7/23
 */
public class CmnbMain implements RunProcessInterface {

    private static boolean isInitialized = false;
    private CmnbAlarmObserver almObserver;
    public static AlarmAPI alarmApi;
    public static TopoAPI topoApi;

    @Override
    public String getProcessName() {
        return "Cmnb Module";
    }

    @Override
    public void callMain(String[] strings) {
        initialize();

    }

    private void initialize(){
        CmnbLogger.init();
        checkNeedAPI();
        CmnbUtil.init();
        startWebsocket();
        try {
            CmnbEventPush.getInstance().startSchedule();
        } catch (Exception ex) {
            CmnbLogger.CMNBERR.logException(ex, 3);
        }


        try {
            almObserver = CmnbAlarmObserver.getInstance();
            alarmApi.registerForAlarms(almObserver);
        } catch (RemoteException ex) {
            CmnbLogger.CMNBERR.logException(ex, 3);
        }

        try {
            //初始化helper 注册模块发给Rest等其他模块的通知
//            CmnbEmsHelper.getInstance().start();
//            CmnbServiceHelper.getInstance().start();

        } catch (Exception ex) {
            CmnbLogger.CMNBERR.logException(ex, 3);
        }

        isInitialized = true;

    }

    @Override
    public boolean isInitialized() {
        return isInitialized;
    }

    @Override
    public void shutDown() {
        try {
//            CmnbEmsHelper.getInstance().shutdown();
        } catch (Exception ex) {
            CmnbLogger.CMNBERR.logException(ex, 3);
        }

        try {
            if (almObserver != null) {
                alarmApi.deregisterForAlarms(almObserver);
            }
        } catch (Exception ex) {
            CmnbLogger.CMNBERR.logException(ex, 3);
        }

        try {
            CmnbEventPush.getInstance().stopSchedule();
        } catch (Exception ex) {
            CmnbLogger.CMNBERR.logException(ex, 3);
        }

    }

    private void checkNeedAPI() {
        while (NmsUtil.getAPI("TopoAPI") == null
                || NmsUtil.getAPI("MapAPI") == null
                || NmsUtil.getAPI("AlarmAPI") == null
                || NmsUtil.getAPI("NmsAuthAdminAPI") == null
                || NmsUtil.getAPI("EventAPI") == null
                || NmsUtil.getAPI("NmsAuthEngineAPI") == null) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
            }
        }
        alarmApi = (AlarmAPI) NmsUtil.getAPI("AlarmAPI");
        topoApi = (TopoAPI) NmsUtil.getAPI("TopoAPI");
    }

    private void startWebsocket(){
        Thread webSocketServerThread = new Thread(WebSocketServer.createInstance(CmnbUtil.wsPort));
        webSocketServerThread.setName("Web socket server on port " + CmnbUtil.wsPort);
        webSocketServerThread.start();

    }
}
