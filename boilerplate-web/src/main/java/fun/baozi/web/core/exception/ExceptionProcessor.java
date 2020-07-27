package fun.baozi.web.core.exception;

import fun.baozi.core.domain.result.Result;
import fun.baozi.core.exception.AppErrorCode;
import fun.baozi.core.exception.AppException;
import fun.baozi.core.exception.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public Result<String> exceptionHandler(Exception e) {
        if (e instanceof AppException) {
            // custom exception handler
            AppException exception = (AppException) e;
            ErrorCode errorCode = exception.getErrorCode();
            LOGGER.error("AppException.errorCode={}|errorMsg={}", errorCode.getCode(), errorCode.getMsg());
            return new Result<>(errorCode);
        }
        // unknown exception handler
        LOGGER.error("System Error, reason: {}", e.getMessage());
        return new Result<>(AppErrorCode.INTERNAL_SERVER_ERROR);
    }

}
