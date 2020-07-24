package fun.baozi.web.web.req;

import fun.baozi.core.domain.page.PageInfo;
import lombok.Data;

/**
 * User list.
 * @author baozi
 * 2020-07-15
 */
@Data
public class ListUserRq extends PageInfo {


    /**
     * User name.
     * Max length 10 character
     */
    private String username;


    /**
     * User email
     * eg. spring@gmail.com
     */
    private String email;

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

    /**
     * Start create time.
     */
    private Long startCreateTime;

    /**
     * End create time.
     */
    private Long endCreateTime;

    /**
     * Start update time.
     */
    private Long startUpdateTime;

    /**
     * End update time.
     */
    private Long endUpdateTime;
}
