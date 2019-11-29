package com.xy.api.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/****
 * @Author Bernie
 * @Description 接口参数工具类
 * @Date 10:36 2019/7/5
 **/
@Data
@Component
@ConfigurationProperties(prefix = "netty")
public class NettyParamsUtil {

    /**
     *  httpServer端口
     */
    private int serverPort;
    /**
     *  netty默认backlog大小(再tcp内核中大小等于3次握手后syn queue和acept queue队列的总和)
     */
    private int sobackLog;
    /**
     *  netty最大文本长度，默认2000KB
     */
    private int maxContentLength;
}
