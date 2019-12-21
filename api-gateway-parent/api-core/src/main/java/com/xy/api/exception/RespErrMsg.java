package com.xy.api.exception;

import lombok.Data;

/**
 * RespErrMsg
 *
 * @Description 组建返回错误信息
 * @Author Bernie【xiongyun100@163.com】
 * @Date 2019/12/21
 */
@Data
public class RespErrMsg {

    /***
     * @Author Bernie
     * @Description 错误编码
     * @Date 17:21 2019/12/21
     * @Param
     * @return
     **/
    private String code;

    /***
     * @Author Bernie
     * @Description 错误内容
     * @Date 17:22 2019/12/21
     * @Param
     * @return
     **/
    private String msg;

    public RespErrMsg(String code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
