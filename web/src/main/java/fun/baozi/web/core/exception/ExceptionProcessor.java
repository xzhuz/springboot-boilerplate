package fun.baozi.web.core.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import fun.baozi.core.domain.result.Result;
import fun.baozi.core.exception.AppErrorCode;
import fun.baozi.core.exception.AppException;
import fun.baozi.core.exception.ErrorCode;

/**
 * Global exception handler.
 *
 * @author baozi
 * 2020-07-03
 */
@ControllerAdvice
public class ExceptionProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionProcessor.class);

    /**
     * 异常处理函数.
     * 将异常映射成restful返回结果
     *
     * @param e 异常
     * @return 返回结果
     */
    @ExceptionHandler
    @ResponseBody
    public Result<String> exceptionHandler(Exception e) {
        if (e instanceof AppException) {
            // custom exception handler
            AppException exception = (AppException) e;
            ErrorCode errorCode = exception.getErrorCode();
            LOGGER.error("AppException.errorCode={}|errorMsg={}", errorCode.getCode(),
                    errorCode.getMsg());
            return new Result<>(errorCode);
        }
        // unknown exception handler
        LOGGER.error("System Error Found. ", e);
        return new Result<>(AppErrorCode.INTERNAL_SERVER_ERROR);
    }

}
