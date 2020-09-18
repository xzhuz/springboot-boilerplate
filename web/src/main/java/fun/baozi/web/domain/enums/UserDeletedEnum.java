package fun.baozi.web.domain.enums;

/**
 * User deleted status enumeration.
 *
 * @author baozi
 *      2020-07-15
 */
public enum UserDeletedEnum {
    // not deleted
    NORMAL((byte) 0),
    DELETED((byte) 1),
    ;

    private final byte code;

    UserDeletedEnum(byte code) {
        this.code = code;
    }

    public byte getCode() {
        return code;
    }
}
