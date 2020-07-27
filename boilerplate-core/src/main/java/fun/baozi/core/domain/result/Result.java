package fun.baozi.core.domain.result;

import fun.baozi.core.exception.ErrorCode;

/**
 * Global response entity
 * @author baozi
 * 2020-07-03
 */
public class Result<T> {

    /**
     * Response code
     */
    private Integer code;
    /**
     * Response data detail
     */
    private T data;
    /**
     * Response message
     */
    private String msg;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Result(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public Result(){}
}
