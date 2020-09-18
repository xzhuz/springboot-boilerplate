package fun.baozi.core.domain.enums;

/**
 * Date format enumeration
 * @author baozi
 * 2020-07-07
 */
public enum DateFormatEnum {
    // explicit date string
    EXPLICIT_DATE("yyyy-MM-dd HH:mm:ss"),
    SIMPLE_DATE("yyyy-MM-dd"),
    DATE_SLASH("yyyy/MM/dd HH:mm:ss"),
    SIMPLE_DATE_SLASH("yyyy/MM/dd"),
    ;

    private final String format;

    DateFormatEnum(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
