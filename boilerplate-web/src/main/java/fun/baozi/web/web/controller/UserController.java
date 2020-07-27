package fun.baozi.web.web.controller;

import com.google.common.collect.Lists;
import fun.baozi.core.domain.enums.DateFormatEnum;
import fun.baozi.core.domain.page.PageBean;
import fun.baozi.core.domain.page.PageResult;
import fun.baozi.core.utils.date.DateUtils;
import fun.baozi.data.domain.UserList;
import fun.baozi.web.domain.modals.UserRegister;
import fun.baozi.web.service.UserService;
import fun.baozi.web.web.req.ListUserRq;
import fun.baozi.web.web.req.RegisterUserRq;
import fun.baozi.web.web.res.RegisterUserRs;
import fun.baozi.web.web.res.ListUserRs;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Objects;

/**
 * @author baozi
 * 2020-07-15
 */
@RestController
@RequestMapping("/user")
@Api(value = "UserController", description = "UserController")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "User register")
    @PostMapping("/register")
    public RegisterUserRs register(@RequestBody RegisterUserRq rq) {
        UserRegister user = new UserRegister();
        BeanUtils.copyProperties(rq, user, UserRegister.class);
        return userService.register(user);
    }

    @ApiOperation(value = "Query user list")
    @GetMapping("/list")
    public PageResult<ListUserRs> userList(@ModelAttribute ListUserRq rq) {
        UserList user = new UserList();
        BeanUtils.copyProperties(rq, user, UserList.class);
        user.setStartCreateTime(getFormatTime(rq.getStartCreateTime()));
        user.setEndCreateTime(getFormatTime(rq.getEndCreateTime()));
        user.setStartExpireTime(getFormatTime(rq.getStartExpireTime()));
        user.setEndExpireTime(getFormatTime(rq.getEndExpireTime()));
        user.setStartUpdateTime(getFormatTime(rq.getStartUpdateTime()));
        user.setEndUpdateTime(getFormatTime(rq.getEndUpdateTime()));
        PageBean<ListUserRs> pageBean = userService.userList(user);
        if (Objects.isNull(pageBean)) {
            return new PageResult<>(Lists.newArrayList(), 0L, rq);
        }
        return new PageResult<>(pageBean, rq);
    }


    /**
     * Get timestamp format time string
     * @param timestamp long type time
     * @return string type time
     */
    private String getFormatTime(Long timestamp) {
        if (Objects.nonNull(timestamp) && timestamp > 0) {
            Date dateTime = DateUtils.stampToDate(timestamp);
            return DateUtils.format(dateTime, DateFormatEnum.EXPLICIT_DATE);
        }
        return Strings.EMPTY;
    }

}
