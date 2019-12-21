package com.xy.api.assembly;

import com.xy.api.model.CmptRequest;
import com.xy.api.model.CmptResult;
import com.xy.api.model.FieldDTO;

import java.util.Map;

/**
 * ICmpt
 *
 * @Description TODO
 * @Author Bernie【xiongyun100@163.com】
 * @Date 2019/12/21
 */
public interface ICmpt {
    /**
     * 组件执行入口
     *
     * @param request
     * @param config，组件实例的参数配置
     * @return
     */
    CmptResult execute(CmptRequest request, Map<String, FieldDTO> config);

    /**
     * 销毁组件持有的特殊资源，比如线程。
     */
    void destroy();
}
