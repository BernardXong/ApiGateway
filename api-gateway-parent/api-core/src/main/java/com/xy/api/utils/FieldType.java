package com.xy.api.utils;
/**
 * @Author Bernie Xiong【yun.xiong@51wph.com】
 * @version: v1.0
 * @description: com.xy.api.utils
 * @Date 2019/12/21 17:14
 */

public enum FieldType {

    STRING("String"),NUMBER("Number"),MEDIA("media");

    private String type;
    FieldType(String type){
        this.type = type;
    }
}
