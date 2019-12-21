package com.xy.api.assembly;

import com.xy.api.assembly.ICmpt;
import com.xy.api.model.CmptRequest;
import com.xy.api.model.CmptResult;
import com.xy.api.model.FieldDTO;

import java.util.Map;

/**
 * AbstractCmpt
 *
 * @Description TODO
 * @Author Bernie【xiongyun100@163.com】
 * @Date 2019/12/21
 */
public abstract class AbstractCmpt implements ICmpt {

    @Override
    public CmptResult execute(CmptRequest request, Map<String, FieldDTO> config) {
        return null;
    }

    @Override
    public void destroy() {

    }
}
