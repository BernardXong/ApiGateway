package com.xy.api.model;

import com.xy.api.utils.FieldType;
import lombok.Data;

/**
 * FieldDTO
 *
 * @Description TODO
 * @Author Bernie【xiongyun100@163.com】
 * @Date 2019/12/21
 */
@Data
public class FieldDTO {

    private String title;

    private String name;

    private FieldType fieldType = FieldType.STRING;

    private String defaultValue;

    private boolean required;

    private String regExp;

    private String description;
}
