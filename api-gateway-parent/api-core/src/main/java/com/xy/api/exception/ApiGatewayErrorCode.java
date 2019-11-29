package com.xy.api.exception;



/**
 * @Author Bernie Xiong【yun.xiong@51wph.com】
 * @version: v1.0
 * @description: 业务异常错误码枚举
 * @Date 2019/6/11 20:28
 */
public enum ApiGatewayErrorCode {

    /**
     * 对象为空
     */
    NULL_OBJ("LUO001","对象为空"),
    /**
     * 添加对象失败
     */
    ERROR_ADD_OBJ("LUO002","添加对象失败"),
    /**
     * 系统繁忙，请稍后再试....
     */
    UNKNOWN_ERROR("LUO999","系统繁忙，请稍后再试....");

    private String value;
    private String desc;

    ApiGatewayErrorCode(String value, String desc) {
        this.setValue(value);
        this.setDesc(desc);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "[" + this.value + "]" + this.desc;
    }
}
