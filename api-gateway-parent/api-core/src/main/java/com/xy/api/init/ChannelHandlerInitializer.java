package com.xy.api.init;

import com.xy.api.utils.NettyParamsUtil;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: Bernie
 * @CreateTime: 2019-11-28 10:54
 * @Description: handler初始化类
 * @Company: Bernie House
 * @Email: xiongyun100@163.com
 */

public class ChannelHandlerInitializer extends ChannelInitializer<SocketChannel> {
    private static final Logger logger = LogManager.getLogger(ChannelHandlerInitializer.class);

    @Autowired
    private NettyParamsUtil nettyParamsUtil;
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline p = socketChannel.pipeline();
        p.addLast(new HttpRequestDecoder());
        p.addLast(new HttpResponseEncoder());
        int maxContentLength = 2000;
        try {
            maxContentLength = nettyParamsUtil.getMaxContentLength();
        } catch (Exception e) {
            logger.warn("netty.maxContentLength配置异常，系统默认为：2000KB");
        }
        // HTTP 消息的合并处理
        p.addLast(new HttpObjectAggregator(maxContentLength * 1024));
        p.addLast(new HttpServerInboundHandler());

    }
}
