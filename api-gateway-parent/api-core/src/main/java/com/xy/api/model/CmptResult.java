package com.xy.api.model;

import com.xy.api.exception.RespErrMsg;
import lombok.Data;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Bernie
 * @CreateTime: 2019-11-28 14:42
 * @Description: 网关执行结果类
 * @Company: bernie house
 * @Email: xiongyun100@163.com
 */
@Data
public class CmptResult {
        /***
         * @Author Bernie
         * @Description  组件返回错误信息
         * @Date 17:08 2019/12/21
         * @Param
         * @return
         **/
        RespErrMsg respErrMsg;

        /***
         * @Author Bernie
         * @Description  组件过滤是否通过
         * @Date 17:08 2019/12/21
         * @Param
         * @return
         **/
        private boolean passed;

        /***
         * @Author Bernie
         * @Description 组件返回数据
         * @Date 17:08 2019/12/21
         * @Param
         * @return
         **/
        private byte[] data;

        /***
         * @Author Bernie
         * @Description  透传后端服务响应头信息

         * @Date 17:08 2019/12/21
         * @Param
         * @return
         **/
        private Map<String, String> header = new HashMap<>();

        /***
         * @Author Bernie
         * @Description 返回响应数据类型
         * @Date 17:08 2019/12/21
         * @Param
         * @return
         **/
        private MediaType mediaType;
        /***
         * @Author Bernie
         * @Description  默认返回状态码为 200
         * @Date 17:08 2019/12/21
         * @Param
         * @return
         **/
        private Integer statusCode = 200;
}
