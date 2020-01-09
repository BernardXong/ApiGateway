package com.xy.api.init;

import com.xy.api.exception.ApiGatewayException;
import com.xy.api.model.CmptRequest;
import com.xy.api.model.CmptResult;
import com.xy.api.utils.CmptRequestUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @Author: Bernie
 * @CreateTime: 2019-11-28 11:11
 * @Description: 网络请求控制器：网络请求转发网关执行器
 * @Company: Bernie House
 * @Email: xiongyun100@163.com
 */

public class HttpServerInboundHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = LogManager.getLogger(HttpServerInboundHandler.class);

    private GatewayExecutor gatewayExecutor = new GatewayExecutor();
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            if (msg instanceof HttpRequest && msg instanceof HttpContent) {
                CmptRequest cmptRequest = CmptRequestUtil.convert(ctx, msg);
                CmptResult cmptResult = this.gatewayExecutor.execute(cmptRequest);
                //签名认证、鉴权
                //流量控制
                //缓存

                FullHttpResponse response = encapsulateResponse(cmptResult);
                ctx.write(response);
                ctx.flush();
            }
        } catch (Exception e) {
            logger.error("网关入口异常，" + e.getMessage());
            throw new ApiGatewayException(e);
        }

    }

    /**
     *@Description: 将网关执行结果对象转换为http响应对象
     *@Param: cmptResult 网关执行结果类
     *@Return: FullHttpResponse http响应类
     *@Author: Bernie 
     *@CreateTime: 2019-11-28
     */
    private FullHttpResponse encapsulateResponse(CmptResult cmptResult){
            return null;
    }



}
