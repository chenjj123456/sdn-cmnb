package com.gwtt.ems.cmnb.websocket.server;

import com.gwtt.ems.cmnb.util.CmnbLogger;
import com.gwtt.ems.cmnb.websocket.listener.Notificator;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * {@link WebSocketServer} is responsible to start and stop web socket server
 */
public class WebSocketServer implements Runnable {

    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private static WebSocketServer instance = null;
    private final int port;

    private WebSocketServer(int port) {
        this.port = port;
    }

    public static WebSocketServer createInstance(int port) {
        instance = new WebSocketServer(port);
        return instance;
    }

    public int getPort() {
        return port;
    }

    public static WebSocketServer getInstance() {
        return instance;
    }

    public static void destroyInstance() {
        if (instance != null) {
            instance.stop();
        }
        instance = null;
    }

    @Override
    public void run() {
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new WebSocketServerInitializer())
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            Channel ch = b.bind(port).sync().channel();
            CmnbLogger.CMNBOUT.log("Web socket server started at port " + port, 3);
            ch.closeFuture().sync();
        } catch (InterruptedException e) {
            CmnbLogger.CMNBOUT.logException(e, 3);
        } finally {
            stop();
        }
    }

    private void stop() {
        Notificator.getInstance().removeAllListeners();
        if (bossGroup != null) {
            bossGroup.shutdownGracefully();
            bossGroup = null;
        }
        if (workerGroup != null) {
            workerGroup.shutdownGracefully();
            workerGroup = null;
        }
    }

}

