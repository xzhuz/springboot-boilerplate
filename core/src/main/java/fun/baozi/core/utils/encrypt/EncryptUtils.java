package fun.baozi.core.utils.encrypt;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

/**
 * md5 encrypt utils
 *
 * @author baozi
 * 2020-07-15
 */

public class EncryptUtils {

    /**
     * md5 encrypt
     *
     * @param code origin code
     * @return encrypt code
     */
    public static String md5(String code) {
        return Hashing.md5().newHasher().putString(code, Charsets.UTF_8).hash().toString();
    }

    /**
     * sha256
     *
     * @param code origin code
     * @return encrypt code
     */
    public static String sha256(String code) {
        return Hashing.sha256().newHasher().putString(code, Charsets.UTF_8).hash().toString();
    }

    /**
     * crc32
     *
     * @param code origin code
     * @return encrypt code
     */
    public static String crc32(String code) {
        return Hashing.crc32().newHasher().putString(code, Charsets.UTF_8).hash().toString();
    }

    /**
     * sha512
     *
     * @param code origin code
     * @return encrypt code
     */
    public static String sha512(String code) {
        return Hashing.sha512().newHasher().putString(code, Charsets.UTF_8).hash().toString();
    }

}
