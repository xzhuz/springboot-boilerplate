package fun.baozi.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import fun.baozi.core.domain.page.PageBean;
import fun.baozi.core.utils.encrypt.EncryptUtils;
import fun.baozi.data.dao.dto.UserListDto;
import fun.baozi.data.dao.entity.Users;
import fun.baozi.data.dao.mappers.UsersMapper;
import fun.baozi.data.domain.UserList;
import fun.baozi.web.domain.enums.UserDeletedEnum;
import fun.baozi.web.domain.modals.UserRegister;
import fun.baozi.web.service.UserService;
import fun.baozi.web.web.res.ListUserRs;
import fun.baozi.web.web.res.RegisterUserRs;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.util.Assert;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Implements of userService
 * @author baozi
 * 2020-07-15
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public RegisterUserRs register(UserRegister req) {
        // assert request param is legal
        Assert.notNull(req, "Request can not be null.");
        Assert.notEmpty(req.getUsername(), "Username can not be empty.");
        Assert.notEmpty(req.getPassword(), "password can not be empty.");
        Assert.notEmpty(req.getEmail(), "Email can not be empty.");
        // set register param
        Users user = new Users();
        user.setCreateTime(new Date());
        user.setDeleted(UserDeletedEnum.NORMAL.getCode());
        user.setAvatar(req.getAvatar());
        user.setDescription(req.getDescription());
        user.setEmail(req.getEmail());
        String nickname = Strings.isBlank(req.getNickname()) ? req.getUsername() : req.getNickname();
        user.setNickname(nickname);
        // The password needs to be encrypted
        String password = EncryptUtils.md5(req.getPassword());
        user.setPassword(password);
        user.setUsername(req.getUsername());
        // Register
        usersMapper.insertSelective(user);

        // Assemble user register response
        RegisterUserRs res = new RegisterUserRs();
        res.setUserId(user.getId());
        res.setUsername(user.getUsername());
        res.setNickname(nickname);
        res.setAvatar(user.getAvatar());
        return res;
    }

    @Override
    public PageBean<ListUserRs> userList(UserList user) {
        if (Objects.isNull(user)) {
            return emptyBean();
        }
        Long count = usersMapper.countUser(user);
        // user count is null or less than 1
        if (Objects.isNull(count) || count < 1) {
            return emptyBean();
        }
        PageHelper.startPage(user.getPageNum(), user.getPageSize(), false);
        List<UserListDto> userList = usersMapper.listUser(user);
        PageHelper.clearPage();
        // just in case userList is null or empty
        if (CollectionUtils.isEmpty(userList)) {
            return emptyBean();
        }
        List<ListUserRs> userRsList = userList.stream()
                .map(this::assembleUserRs)
                .collect(Collectors.toList());
        PageBean<ListUserRs> pageBean = new PageBean<>();
        pageBean.setData(userRsList);
        pageBean.setCount(count);
        return pageBean;
    }

    /**
     * Assemble user response
     * @param u db user list
     * @return user response list
     */
    private ListUserRs assembleUserRs(UserListDto u) {
        ListUserRs rs = new ListUserRs();
        rs.setUserId(u.getId());
        rs.setUsername(u.getUsername());
        rs.setEmail(u.getEmail());
        rs.setAvatar(u.getAvatar());
        rs.setNickname(u.getNickname());
        rs.setExpireTime(u.getExpireTime());
        rs.setDescription(u.getDescription());
        rs.setCreateTime(u.getCreateTime());
        rs.setUpdateTime(u.getUpdateTime());
        return rs;
    }

    /**
     * Empty page bean
     * @return bean
     */
    private PageBean<ListUserRs> emptyBean() {
        PageBean<ListUserRs> pageBean = new PageBean<>();
        pageBean.setCount(0L);
        pageBean.setData(Lists.newArrayList());
        return pageBean;
    }
}
