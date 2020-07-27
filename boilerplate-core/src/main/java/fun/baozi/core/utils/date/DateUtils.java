package fun.baozi.core.utils.date;

import fun.baozi.core.domain.enums.DateFormatEnum;
import fun.baozi.core.exception.AppErrorCode;
import fun.baozi.core.exception.AppException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * Date utils
 * @author baozi
 * 2020-07-07
 */
public class DateUtils {

    /**
     * Calculate the date plus the specified number of days
     * @param day days
     * @return Result date
     */
    public static Date addDay(Date date, int day) {
        if (Objects.isNull(date)) {
            return date;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, day);
        return calendar.getTime();
    }

    /**
     * Calculate the date plus the specified number of minutes
     * @param minutes minutes
     * @return Result date
     */
    public static Date addMinute(Date date, int minutes) {
        if (Objects.isNull(date)) {
            return date;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }

    /**
     * Calculate the date plus the specified number of hours
     * @param date specified date
     * @param hours hours
     * @return Result date
     */
    public static Date addHour(Date date, int hours) {
        if (Objects.isNull(date)) {
            return date;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hours);
        return calendar.getTime();
    }

    /**
     * Format date to specified date
     * @param date date
     * @param format Date format
     * @return Date after format
     */
    public static String format(Date date, DateFormatEnum format) {
        if (Objects.isNull(date) || Objects.isNull(format)) {
            return null;
        }
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(format.getFormat());
            return formatter.format(date);
        } catch (Exception e) {
            throw new AppException(AppErrorCode.PARSE_DATE_ERROR);
        }
    }

    /**
     * Convert timestamp to date
     * @param timestamp timestamp, long type
     * @return date type
     */
    public static Date stampToDate(Long timestamp) {
        if (Objects.isNull(timestamp)) {
            return null;
        }
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(timestamp);
            return calendar.getTime();
        } catch (Exception e) {
            throw new AppException(AppErrorCode.PARSE_DATE_ERROR);
        }
    }

}
