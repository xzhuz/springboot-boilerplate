package fun.baozi.core.utils.number;

/**
 * Number utils
 *
 * @author baozi
 * 2020-07-03
 */
public class NumberUtils {

    /**
     * Check if a string is number or not
     *
     * @param str string
     * @return true | false
     */
    public static boolean isInteger(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if string is not a number
     *
     * @param str string
     * @return true | false
     */
    public static boolean isNotInteger(String str) {
        return !isInteger(str);
    }

}
