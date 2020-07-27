package fun.baozi.web.domain.modals;

import lombok.Data;

import java.util.Date;

/**
 * Base user info.
 * @author baozi
 * 2020-07-15
 */
@Data
public class UserInfo {

    /**
     * User name.
     * Max length 10 character
     */
    private String username;

    /**
     * User password
     * Will be encrypt.
     */
    private String password;

    /**
     * User email
     * eg. spring@gmail.com
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
     * User expire time.
     * Default never expire
     */
    private Date expireTime;

    /**
     * User description
     * Default empty string.
     */
    private String description;

    /**
     * Time of user created
     */
    private Date createTime;

    /**
     * Time of user updated
     */
    private Date updateTime;
}
