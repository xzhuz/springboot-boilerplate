package fun.baozi.web.core.response;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;


/**
 * 返回结果处理类.
 *
 * @author baozi
 * 2020-07-01
 */
@Configuration
public class RestReturnValueHandlerConfigurer implements InitializingBean {

    private final RequestMappingHandlerAdapter handlerAdapter;

    @Autowired
    public RestReturnValueHandlerConfigurer(RequestMappingHandlerAdapter handlerAdapter) {
        this.handlerAdapter = handlerAdapter;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        List<HandlerMethodReturnValueHandler> list = handlerAdapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> newList = new ArrayList<>();
        if (null != list) {
            for (HandlerMethodReturnValueHandler valueHandler : list) {
                if (valueHandler instanceof RequestResponseBodyMethodProcessor) {
                    MethodReturnValueHandler handler = new MethodReturnValueHandler(valueHandler);
                    newList.add(handler);
                } else {
                    newList.add(valueHandler);
                }
            }
        }
        handlerAdapter.setReturnValueHandlers(newList);
    }
}
