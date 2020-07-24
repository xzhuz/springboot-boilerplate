package fun.baozi.web.core.exception;

import fun.baozi.core.domain.Result;
import fun.baozi.core.exception.BaseException;
import fun.baozi.core.exception.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Global exception handler
 *
 * @author baozi
 * 2020-07-03
 */
@ControllerAdvice
public class ExceptionProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionProcessor.class);

    @ExceptionHandler
    @ResponseBody
    public Result<Object> exceptionHandler(Exception e) {
        Result<Object> result = new Result<>();
        if (e instanceof BaseException) {
            BaseException exception = (BaseException) e;
            ErrorCode errorCode = exception.getErrorCode();
            result.setCode(errorCode.getCode());
            result.setMsg(errorCode.getMsg());
            LOGGER.error("AppException.errorCode={}|errorMsg={}", errorCode.getCode(), errorCode.getMsg());
            return result;
        }
        result.setCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        result.setMsg(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        LOGGER.error("System Error, reason: {}", e.getMessage());
        return result;
    }
}
