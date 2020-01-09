package com.xy.api.init;

import com.xy.api.model.CmptRequest;
import com.xy.api.model.CmptResult;
import com.xy.api.model.FieldDTO;
import com.xy.api.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * GatewayExecutor
 *
 * @Description 自定义组件执行器，不同的执行器执行方法不同
 * @Author Bernie【xiongyun100@163.com】
 * @Date 2019/12/21
 */
@Component
public class GatewayExecutor {

    @Autowired
    private RedisUtil redisUtil;
    private String assembleKey = "assembly";
    private Map<String,Map<String,FieldDTO>> assembleMap = new LinkedHashMap<>(16);

    @PostConstruct
    public void init(){
        //组件集合key: assembly;组件集合value: authentication、flowControl、cache、router、log
        Set<String> assemblyTitles = redisUtil.get(assembleKey);
        //循环组件配置，放置map里
        for(String s : assemblyTitles){
            Map<String,FieldDTO> params = redisUtil.get(s);
            if(null != params){
                //TODO 有序存值待开发
                assembleMap.put(s,params);
            }

        }
        //获取网关执行优先级配置
    }

    /***
     *  网关通用执行类，功能包括签名认证、缓存、流量控制、转发
     * @param cmptRequest
     * @return
     */
    public CmptResult execute(CmptRequest cmptRequest){

            return null;
    }

}
