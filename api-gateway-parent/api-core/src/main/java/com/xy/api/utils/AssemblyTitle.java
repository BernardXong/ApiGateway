package com.xy.api.utils;

import lombok.Data;

/**
 * @Author Bernie【xiongyun100@163.com】
 * @CreateTime: 2020-01-09 10:48
 * @Description: 组件类型枚举
 */
public enum AssemblyTitle {
    /**
     * 认证、鉴权
     */
    AUTHEN("authentication"),

    /**
     * 流量控制
     */
    FLOW("flowControl"),

    /**
     * 缓存
     */
    CACHE("cache"),

    /**
     * 路由
     */
    ROUTER("router"),

    /**
     * 日志
     */
    LOG("log");

    private String title;
    AssemblyTitle(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * 自己定义一个静态方法,通过title返回枚举常量对象
     * @param title
     * @return
     */
    public static AssemblyTitle getValue(String title){

        for (AssemblyTitle assemblyTitle : values()) {
            if(assemblyTitle.getTitle() == title){
                return assemblyTitle;
            }
        }
        return null;
    }


}
