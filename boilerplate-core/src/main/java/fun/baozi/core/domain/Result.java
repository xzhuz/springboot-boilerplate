package fun.baozi.core.domain;

/**
 * Global response entity
 * @author baozi
 * 2020-07-03
 */
public class Result<T> {

    /**
     * Response code
     */
    private String code;
    /**
     * Response data detail
     */
    private T data;
    /**
     * Response message
     */
    private String msg;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
}
