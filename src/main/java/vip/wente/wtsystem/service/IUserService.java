package vip.wente.wtsystem.service;

import vip.wente.wtsystem.entity.User;

import java.util.List;

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
    /**
     * 根据id查找用户信息
     * @param id
     * @return
     */
    User finUserById(int id);
    /**
     * 修改用户密码
     * @param id  用户id
     * @param oldPassword 老密码
     * @param newPassword 新密码
     * @return
     */
    void updatePwd(Integer id,String oldPassword,String newPassword);
    /**
     * 修改用户信息
     * @param id
     * @param username
     * @param email
     * @return
     */
    Integer changeInfo(Integer id,String username,String mobile,String email);

    /**
     * 删除员工
     * @param id
     * @return
     */
    Integer delete(Integer id,Integer shopNumber);

    /**
     * 获取酒店所有员工
     * @param shopNumber
     * @return
     */
    List<User> getAllUser(Integer shopNumber);
}
