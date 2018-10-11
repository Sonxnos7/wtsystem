package vip.wente.wtsystem.service;

import vip.wente.wtsystem.entity.User;

/**
 * @program: fourteen
 * @description:
 * @author: Sonxnos7
 * @create: 2018-10-09 16:09
 **/

public interface IUserService {
    /**
     * 添加用户
     * @param user
     * @return
     */
   User addUser(User user);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User getUserByName(String username);
}
