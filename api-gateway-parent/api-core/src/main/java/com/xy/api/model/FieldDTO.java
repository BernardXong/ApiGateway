package com.xy.api.model;

import com.xy.api.utils.FieldType;
import lombok.Data;

/**
 * FieldDTO
 *
 * @Description 组件特殊配置DTO
 * @Author Bernie【xiongyun100@163.com】
 * @Date 2019/12/21
 */
@Data
public class FieldDTO {

    /**
     *  组件类型(认证鉴权、流量控制、转发)
     */
    private String title;
    /**
     * 组件参数名称
     */
    private String name;
    /**
     * 参数类型，默认字符串
     */
    private FieldType fieldType = FieldType.STRING;
    /**
     * 参数值
     */
    private String defaultValue;
    /**
     * 是否必要参数
     */
    private boolean required;
    /**
     * 包含的正则表达式
     */
    private String regExp;
    /**
     * 参数描述
     */
    private String description;
}
