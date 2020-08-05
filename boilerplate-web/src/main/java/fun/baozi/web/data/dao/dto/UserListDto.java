package fun.baozi.web.data.dao.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author baozi
 * 2020-07-15
 */
@Data
public class UserListDto {

    /**
     * User id
     * auto increment
     */
    private Integer id;

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
