package fun.baozi.web.web.req;

import fun.baozi.web.domain.req.UserInfo;
import lombok.Data;

/**
 * Register user request
 *
 * @author baozi
 * 2020-07-15
 */
@Data
public class RegisterUserRq extends UserInfo {

    /**
     * User name.
     * Max length 10 character
     */
    private String username;


    /**
     * User email
     * eg. xx@gamil.com
     */
    private String email;

    /**
     * User avatar
     * Avatar image url
     */
    private String avatar;

    /**
     * User nickname.
     * Default equals to username.
     */
    private String nickname;

    /**
     * Start expire time.
     *
     */
    private Long startExpireTime;

    /**
     * End expire time.
     */
    private Long endExpireTime;


}

