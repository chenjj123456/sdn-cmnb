package com.gwtt.ems.cmnb.websocket.server;

import com.gwtt.ems.cmnb.model.north.notification.UserChannel;
import com.gwtt.ems.cmnb.util.CmnbLogger;
import com.gwtt.ems.cmnb.websocket.listener.ListenerAdapter;
import com.gwtt.ems.cmnb.websocket.listener.Notificator;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Set;

import static io.netty.handler.codec.http.HttpHeaders.isKeepAlive;
import static io.netty.handler.codec.http.HttpHeaders.setContentLength;
import static io.netty.handler.codec.http.HttpMethod.GET;
import static io.netty.handler.codec.http.HttpResponseStatus.FORBIDDEN;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

public class WebSocketServerHandler extends SimpleChannelInboundHandler<Object> {

    private static final Logger LOG = LoggerFactory.getLogger(WebSocketServerHandler.class);
    private WebSocketServerHandshaker handshaker;
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        channels.add(incoming);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        removeChannel(incoming);
        CmnbLogger.CMNBOUT.log("Client:" + incoming.remoteAddress() + " has left", 3);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        removeChannel(incoming);
        CmnbLogger.CMNBOUT.log("Client:" + incoming.remoteAddress() + " is online", 3);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        removeChannel(incoming);
        CmnbLogger.CMNBOUT.log("Client:" + incoming.remoteAddress() + " is offline", 3);
    }

    protected void channelRead0(final ChannelHandlerContext ctx, final Object msg) throws Exception {
        if (msg instanceof FullHttpRequest) {
            handleHttpRequest(ctx, (FullHttpRequest) msg);
        } else if (msg instanceof WebSocketFrame) {
            handleWebSocketFrame(ctx, (WebSocketFrame) msg);
        }
    }

    private void handleHttpRequest(final ChannelHandlerContext ctx, final FullHttpRequest request) throws Exception {
        // 如果http解码失败 则返回http异常 并且判断消息头有没有包含Upgrade字段(协议升级)
        if (!request.getDecoderResult().isSuccess() || (!"websocket".equals(request.headers().get("Upgrade")))) {
            sendHttpResponse(ctx, request, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
            return;
        }
        if (request.getMethod() != GET) {
            sendHttpResponse(ctx, request, new DefaultFullHttpResponse(HTTP_1_1, FORBIDDEN));
            return;
        }
        String uriId = "";
        try {
            Channel channel = ctx.channel();
            CmnbLogger.CMNBOUT.log("handleHttpRequest:" + request.getUri(), 3);
            UserChannel userchannel = Notificator.getInstance().createUserChannelFromUri(request.getUri());
            userchannel.setChannel(channel);
//            ListenerAdapter listener = Notificator.getInstance().getListenerFor(streamName);//2 type listener :sla and alarm
            uriId = userchannel.getUriId();
            ListenerAdapter listener = Notificator.getInstance().getListenerFor(uriId);
            if (listener != null) {
                listener.addSubscriber(userchannel);
                CmnbLogger.CMNBOUT.log("handleHttpRequest addsub:" + ctx.channel().remoteAddress() + " " + uriId, 3);
                CmnbLogger.CMNBOUT.log("handleHttpRequest " + request.getUri(), 3);
            }
        } catch (Exception ex) {
            CmnbLogger.CMNBERR.logException(ex, 3);
        }

        // 构造握手响应返回
        WebSocketServerHandshakerFactory ws = new WebSocketServerHandshakerFactory("", null, false);
        handshaker = ws.newHandshaker(request);
        if (handshaker == null) {
            WebSocketServerHandshakerFactory.sendUnsupportedWebSocketVersionResponse(ctx.channel());
        } else {
            handshaker.handshake(ctx.channel(), request);
            HandlerContainer.addHandler(this, uriId);//2 type handler :sla and alarm
            CmnbLogger.CMNBOUT.log("handleHttpRequest addHandler" + uriId, 3);
        }
    }

    private static void sendHttpResponse(final ChannelHandlerContext ctx, final HttpRequest req, final FullHttpResponse res) {
        if (res.getStatus().code() != 200) {
            ByteBuf buf = Unpooled.copiedBuffer(res.getStatus().toString(), CharsetUtil.UTF_8);
            res.content().writeBytes(buf);
            buf.release();
            setContentLength(res, res.content().readableBytes());
        }
        ChannelFuture f = ctx.channel().writeAndFlush(res);
        if (!isKeepAlive(req) || res.getStatus().code() != 200) {
            f.addListener(ChannelFutureListener.CLOSE);
        }
    }

    private synchronized void removeChannel(Channel channel) {
        Set<String> listenerIds = Notificator.getInstance().getListenerIds();
        for (String id : listenerIds) {
            ListenerAdapter listener=Notificator.getInstance().getListenerFor(id);
            listener.removeSubscriber(channel);
        }
    }

    private void handleWebSocketFrame(final ChannelHandlerContext ctx, final WebSocketFrame frame) throws IOException {
        // 判断是否关闭链路指令
        if (frame instanceof CloseWebSocketFrame) {
            handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
            removeChannel(ctx.channel());
            return;
        }
        // 判断是否Ping消息 -- ping/pong心跳包
        if (frame instanceof PingWebSocketFrame) {
            ctx.channel().writeAndFlush(new PongWebSocketFrame(frame.content().retain()));
            return;
        }
        // 本程序仅支持文本消息， 不支持二进制消息
        if (!(frame instanceof TextWebSocketFrame)) {
            throw new UnsupportedOperationException(
                    String.format("%s frame types not supported", frame.getClass().getName()));
        }
    }

    @Override
    public void exceptionCaught(final ChannelHandlerContext ctx, final Throwable cause) throws Exception {
        if (cause instanceof java.nio.channels.ClosedChannelException == false) {
        }
        ctx.close();
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof FullHttpRequest) {
            handleHttpRequest(ctx, (FullHttpRequest) msg);
        } else if (msg instanceof WebSocketFrame) { // websocket帧类型 已连接
            handleWebSocketFrame(ctx, (WebSocketFrame) msg);
        }
    }
}
