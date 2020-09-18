package fun.baozi.core.domain.enums;

/**
 * Global result code
 * @author baozi
 * 2020-07-27
 */
public enum ResultCode {
    // success
    SUCCESS(1000, "Success"),

    FAILED(1001, "Failed"),

    VALIDATE_FAILED(1002, "Validate failed"),

    ERROR(5000, "Unknown error");

    private final int code;
    private final String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
