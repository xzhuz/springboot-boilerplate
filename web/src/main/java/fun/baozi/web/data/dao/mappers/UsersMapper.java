package fun.baozi.web.data.dao.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import fun.baozi.web.data.dao.dto.UserListDto;
import fun.baozi.web.data.dao.entity.Users;
import fun.baozi.web.data.dto.UserList;
import tk.mybatis.mapper.common.Mapper;

/**
 * Auto generate by mybatis-generator.
 *
 * @author baozi
 * 2020-07-15
 */
@Repository
public interface UsersMapper extends Mapper<Users> {

    /**
     * Query user list.
     *
     * @param user query param
     * @return user list
     */
    List<UserListDto> listUser(UserList user);

    /**
     * Count user list.
     *
     * @param user query Param
     * @return user count
     */
    Long countUser(UserList user);

    /**
     * Query user info detail by username.
     *
     * @param username username
     * @return user info detail
     */
    Users getUserByUsername(@Param("username") String username);

    /**
     * Delete user by username.
     *
     * @param username username
     * @return int
     */
    int deleteByUsername(@Param("username") String username);
}