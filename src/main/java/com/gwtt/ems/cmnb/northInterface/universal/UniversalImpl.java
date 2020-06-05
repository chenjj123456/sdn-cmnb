package com.gwtt.ems.cmnb.northInterface.universal;

import com.gwtt.ems.cmnb.model.north.notification.NotificationRequest;
import com.gwtt.ems.cmnb.model.north.notification.NotificationResponse;
import com.gwtt.ems.cmnb.northInterface.CmnbEventPush;
import com.gwtt.ems.cmnb.northInterface.fm.AlarmListenerAdapter;
import com.gwtt.ems.cmnb.northInterface.pse.PseListenerAdapter;
import com.gwtt.ems.cmnb.northInterface.resources.LtpListenerAdapter;
import com.gwtt.ems.cmnb.northInterface.resources.NeListenerAdapter;
import com.gwtt.ems.cmnb.northInterface.topology.LinkListenerAdapter;
import com.gwtt.ems.cmnb.northInterface.topology.NodeListenerAdapter;
import com.gwtt.ems.cmnb.northInterface.tunnel.SncLspListenerAdapter;
import com.gwtt.ems.cmnb.northInterface.tunnel.SncTunnelListenerAdapter;
import com.gwtt.ems.cmnb.util.CmnbLogger;
import com.gwtt.ems.cmnb.util.CmnbUtil;
import com.gwtt.ems.cmnb.websocket.listener.ListenerAdapter;
import com.gwtt.ems.cmnb.websocket.listener.Notificator;
import com.gwtt.ems.cmnb.websocket.server.WebSocketServer;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * Created by chenjj on 2019/8/1
 */
@Component
public class UniversalImpl implements UniversalAPI{

    private static final String ALARM = "chinamobile.restconf.rev20150206.alarms-notification";
    private static final String NODE = "chinamobile.restconf.rev20140904.node-notification";
    private static final String LINK = "chinamobile.restconf.rev20140904.link-notification";
    private static final String LTP = "chinamobile.restconf.rev20140904.ltp-notification";
    private static final String NE = "chinamobile.restconf.rev20140904.ne-notification";
    private static final String NCD = "chinamobile.restconf.rev20140904.ncd-notification";
    private static final String LSP = "chinamobile.restconf.rev20140904.snc-lsp-notification";
    private static final String TUNNEL = "chinamobile.restconf.rev20140904.snc-tunnel-notification";
    private static final String PW = "chinamobile.restconf.rev20140904.snc-pw-notification";
    private static final String ELINE = "chinamobile.restconf.rev20140904.snc-eline-notification";
    private static final String PM_QUERY = "chinamobile.restconf.rev20150618.pm-query-result-notification";
    private static final String PSES = "chinamobile.restconf.rev20150206.pses-notification";
    @Override
    public Response doHeartbeatHmfController() {
        return Response.status(Response.Status.OK).entity("").build();

    }

    @Override
    public Response createNotificationStream(NotificationRequest request) {
        //用于测试
//        Thread webSocketServerThread = new Thread(WebSocketServer.createInstance(CmnbUtil.wsPort));
//        webSocketServerThread.setName("Web socket server on port " + CmnbUtil.wsPort);
//        webSocketServerThread.start();

        String notfiyReq = request.getNotifications();
        String id = notfiyReq.substring(notfiyReq.lastIndexOf(".")+1);
        String streamId = null;
        try {
            streamId = "http://"
                    + Inet4Address.getLocalHost().getHostAddress()
                    + ":" + 9999
                    + "/restconf/streams/stream/"+id;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        ListenerAdapter listenter = Notificator.getInstance().getListenerFor(id);
        if (listenter == null) {
            createListener(notfiyReq);
            CmnbLogger.CMNBOUT.log("订阅成功:{},"+streamId,  3);
        }

        NotificationResponse output=new NotificationResponse();
        output.setNotificationStreamIdentifier(streamId);
        return Response.status(Response.Status.OK).entity(output).build();

    }

    private void createListener(String notfiyReq) {
        ListenerAdapter listener = null;
        switch (notfiyReq) {
            case ALARM:
                listener = new AlarmListenerAdapter();
                //用于测试
//                CmnbEventPush.getInstance().startSchedule();
                break;
            case NODE:
                listener = new NodeListenerAdapter();
                break;
            case LINK:
                listener = new LinkListenerAdapter();
                break;
            case LTP:
                listener = new LtpListenerAdapter();
                break;

            case NE:
                listener = new NeListenerAdapter();
                break;
            case NCD:

                break;

            case LSP:
                listener=new SncLspListenerAdapter();

                break;

            case TUNNEL:
                listener=new SncTunnelListenerAdapter();

                break;
            case PW:

                break;
            case ELINE:

                break;
            case PM_QUERY:
//                listener = new PerfListenerAdapter();
                break;
            case PSES:
                listener = new PseListenerAdapter();
                break;

        }
        if (listener != null) {
            Notificator.getInstance().addListener(listener);
        }

    }


}
