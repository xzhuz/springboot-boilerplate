package fun.baozi.core.exception;

/**
 * Global error code
 * @author baozi
 * 2020-07-03
 */
public interface ErrorCode {

    /**
     * get error code
     * @return error code
     */
    Integer getCode();

    /**
     * get error message
     * @return error message
     */
    String getMsg();
}
