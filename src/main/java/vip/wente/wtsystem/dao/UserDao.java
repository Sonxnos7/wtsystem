package vip.wente.wtsystem.dao;

import vip.wente.wtsystem.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
     * 根据用户名查询用户
     * @param username

     * @return
     */
   User getUserByName(String username);
    /**
     * 查询用户得权限
     * @param userId
     */
    List<String> findPermission(Integer userId);

    /**
     * 查询用户可见的菜单
     * @param id
     * @return
     */
    List<Map<String,Object>> menuList(Integer id);

}
