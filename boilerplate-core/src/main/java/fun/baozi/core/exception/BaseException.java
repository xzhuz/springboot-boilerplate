package fun.baozi.core.exception;

/**
 * Global error code exception definition
 * @author baozi
 * 2020-07-03
 */
public class BaseException extends RuntimeException {

    /**
     * error code enumeration
     */
    private final ErrorCode errorCode;

    /**
     * exception detail
     */
    private final Exception exception;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public Exception getException() {
        return exception;
    }


    public BaseException(ErrorCode errorCode, Exception exception) {
        this.errorCode = errorCode;
        this.exception = exception;
    }

    public BaseException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.exception = new Exception(errorCode.getMsg());
    }


    public BaseException(ErrorCode errorCode, String msg) {
        this.errorCode = errorCode;
        this.exception = new Exception(msg);
    }
}
