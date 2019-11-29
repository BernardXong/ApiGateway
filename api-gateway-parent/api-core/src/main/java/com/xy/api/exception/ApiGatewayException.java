package com.xy.api.exception;


/**
 * ApiGatewayException
 *
 * @Description api网关统一业务异常类
 * @Author Bernie【xiongyun100@163.com】
 * @Date 2019/6/11
 */
public class ApiGatewayException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ApiGatewayException(Object obj) {
        super(obj.toString());
    }

    /**
     * 将CheckedException转换为UncheckedException.
     */
    public static RuntimeException unchecked(Exception e) {
        if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        } else {
            return new RuntimeException(e);
        }
    }
}
