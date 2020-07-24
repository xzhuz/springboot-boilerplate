package fun.baozi.core.exception;

/**
 * base error code enumeration
 * @author baozi
 * 2020-07-24
 */
public enum BaseErrorCode implements ErrorCode {
    // Date parse failed
    PARSE_DATE_ERROR("400001", "Date parse failed."),
    ;

    private final String code;

    private final String msg;

    BaseErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
