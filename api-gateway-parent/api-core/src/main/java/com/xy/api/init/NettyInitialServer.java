package com.xy.api.init;

import com.sun.net.httpserver.HttpServer;
import com.xy.api.utils.NettyParamsUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

/**
 * @Author: Bernie
 * @CreateTime: 2019-11-28 10:24
 * @Description: netty初始化服务，作为http容器接收
 * @Company: Bernie House
 * @Email: xiongyun100@163.com
 */
@Component
public class NettyInitialServer {
    private static final Logger logger = LogManager.getLogger(NettyInitialServer.class);

    @Autowired
    private NettyParamsUtil nettyParamsUtil;
    public void run() throws Exception {
        int port = nettyParamsUtil.getServerPort();
        int sobacklog = nettyParamsUtil.getSobackLog();
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .option(ChannelOption.SO_BACKLOG, sobacklog)
                    .childHandler(new ChannelHandlerInitializer());

            // 绑定端口
            ChannelFuture f = serverBootstrap.bind(port).sync();
            logger.info("HttpServer name is " + HttpServer.class.getName() + " started and listen on " + f.channel().localAddress());
            //等待服务监听端口关闭
            String msgClose = "等待服务监听端口关闭";
            logger.info(msgClose);
            f.channel().closeFuture().await();
        }finally {
            //退出，释放线程资源
            String msgExit = "退出，释放线程资源";
            logger.info(msgExit);
            workerGroup.shutdownGracefully();
        }

    }
}
