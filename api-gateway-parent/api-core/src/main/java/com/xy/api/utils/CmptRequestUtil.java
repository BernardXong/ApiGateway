package com.xy.api.utils;

import com.xy.api.model.CmptRequest;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;

/**
 * @Author: Bernie
 * @CreateTime: 2019-11-28 14:39
 * @Description: HttpRequest封装类转换器 解析http协议，封装为httpRequest
 * @Company: bernie house
 * @Email: xiongyun100@163.com
 */

public class CmptRequestUtil {

    public static CmptRequest convert(ChannelHandlerContext ctx, Object msg){
        HttpRequest httpRequest = (HttpRequest)msg;
        CmptRequest cr = new CmptRequest(httpRequest.method());
        cr.setProtocolVersion(httpRequest.protocolVersion());
        cr.setDecoderResult(httpRequest.decoderResult());
        cr.setUri(httpRequest.uri());
        return cr;
    }
}
