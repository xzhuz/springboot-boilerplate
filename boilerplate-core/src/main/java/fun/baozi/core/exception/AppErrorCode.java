package fun.baozi.core.exception;

/**
 * base error code enumeration
 * @author baozi
 * 2020-07-24
 */
public enum AppErrorCode implements ErrorCode {
    // Internal server error
    INTERNAL_SERVER_ERROR(400000, "Internal Server Error"),
    // Date parse failed
    PARSE_DATE_ERROR(400001, "Date parse failed."),
    ;

    private final Integer code;

    private final String msg;

    AppErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
