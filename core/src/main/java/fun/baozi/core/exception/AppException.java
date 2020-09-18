package fun.baozi.core.exception;

/**
 * Global error code exception definition
 * @author baozi
 * 2020-07-03
 */
public class AppException extends RuntimeException {

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


    public AppException(ErrorCode errorCode, Exception exception) {
        this.errorCode = errorCode;
        this.exception = exception;
    }

    public AppException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.exception = new Exception(errorCode.getMsg());
    }


    public AppException(ErrorCode errorCode, String msg) {
        this.errorCode = errorCode;
        this.exception = new Exception(msg);
    }
}
