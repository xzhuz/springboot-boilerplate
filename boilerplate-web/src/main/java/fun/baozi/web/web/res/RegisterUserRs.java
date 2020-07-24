package fun.baozi.web.web.res;

import lombok.Data;

/**
 * Register user response
 * @author baozi
 * 2020-07-15
 */
@Data
public class RegisterUserRs {

    /**
     * User id
     */
    private Integer userId;

    /**
     * User name
     */
    private String username;

    /**
     * User nickname
     */
    private String nickname;

    /**
     * User avatar image url.
     */
    private String avatar;


}
