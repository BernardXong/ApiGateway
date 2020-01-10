package com.xy.api.utils;

/**
 * @Author: Bernie
 * @CreateTime: 2020-01-10 17:49
 * @Description: 认证类型枚举
 * @Email: xiongyun100@163.com
 */

public enum AuthType {

    TOKEN("token"),
    WECHAT_TOKEN("wechatToken"),
    IP_DOMAIN("ipDomain"),
    CIPHER("chpher");

    private String name;
    AuthType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 自己定义一个静态方法,通过name返回枚举常量对象
     * @param name
     * @return
     */
    public static AuthType getValue(String name){

        for (AuthType authType : values()) {
            if(authType.getName() == name){
                return authType;
            }
        }
        return null;
    }
}
