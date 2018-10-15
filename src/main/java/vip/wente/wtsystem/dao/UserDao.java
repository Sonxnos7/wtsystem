package vip.wente.wtsystem.dao;

import org.apache.ibatis.annotations.Param;
import vip.wente.wtsystem.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: fourteen
 * @description:
 * @author: Sonxnos7
 * @create: 2018-10-09 15:47
 **/
@Repository
public  interface UserDao {
    /**
     * 添加用户
     * @param user
     * @return
     */
    Integer add(User user);

    /**
     * 根据条件查询用户
     * @return
     */
    List<User> select(
            @Param("where") String where,
            @Param("orderBy")String orderBy,
            @Param("offset")Integer offset,
            @Param("countPerPage")Integer countPerPage);

    /**
     * 修改用户信息
     * @param user 至少封装了用户的id和用户的信息
     * @return 受影响的行数
     */
    Integer update(User user);

    /**
     * 删除用户
     * @param id
     * @param shopNumber
     * @return
     */
    Integer delete(@Param("id")Integer id,@Param("shopNumber") Integer shopNumber);

}
