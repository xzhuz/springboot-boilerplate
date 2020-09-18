package fun.baozi.web.core.response;


import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import fun.baozi.core.domain.enums.ResultCode;
import fun.baozi.core.domain.result.Result;

/**
 * 通过修改RequestMappingHandlerAdapter中的returnValueHandlers中的值，
 * 将RequestResponseBodyMethodProcessor替换成自定义对象。
 *
 * @author baozi
 * 2020-07-01
 */
public class MethodReturnValueHandler implements HandlerMethodReturnValueHandler {

    private final HandlerMethodReturnValueHandler proxyObject;

    public MethodReturnValueHandler(HandlerMethodReturnValueHandler proxyObject) {
        this.proxyObject = proxyObject;
    }

    @Override
    public boolean supportsReturnType(MethodParameter methodParameter) {
        return proxyObject.supportsReturnType(methodParameter);
    }

    @Override
    public void handleReturnValue(Object o, MethodParameter methodParameter,
            ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest)
            throws Exception {
        Result<Object> result = new Result<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMsg());
        result.setData(o);
        proxyObject.handleReturnValue(result, methodParameter, modelAndViewContainer,
                nativeWebRequest);
    }
}
