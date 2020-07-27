package fun.baozi.web.domain.error;

import fun.baozi.core.exception.ErrorCode;

/**
 * @author baozi
 * 2020-06-24
 */
public enum UserErrorCode implements ErrorCode {
    // 参数为空
    REGISTER_USER_PARAM_IS_NULL(3000001, "注册用户出错:参数为空!"),
    // 用户登录参数错误
    USER_LOGIN_PARAM_ERROR(3000002, "用户登录出错:参数为空!")
    ;

    private final Integer code;

    private final String msg;

    UserErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
