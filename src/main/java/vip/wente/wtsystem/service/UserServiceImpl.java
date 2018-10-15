package vip.wente.wtsystem.service;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import vip.wente.wtsystem.dao.UserDao;
import vip.wente.wtsystem.entity.User;

import vip.wente.wtsystem.exceptions.PasswordNotExit;
import vip.wente.wtsystem.exceptions.UsernameConflictException;
import vip.wente.wtsystem.exceptions.UsernameIsNll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @program: fourteen
 * @description:
 * @author: Sonxnos7
 * @create: 2018-10-09 16:10
 **/
@Service("userService")

public class UserServiceImpl implements IUserService{
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;
    //将密码加密
    public String getEncrpytedPassword(String password, String salt) {
        String str =password+salt;
        String md5 = DigestUtils.md5DigestAsHex(str.getBytes());
        return md5;
    }
    @Override
    public User addUser(User user) {
        User u = getUserByName(user.getUsername());
       if(u!=null){
           //此用户名已经被占用
           throw new UsernameConflictException("用户名："+user.getUsername()+"已经被占用！");
       }
        //用户名没有被占有，则执行注册相关任务
        //把密码加密
        String saltStr = UUID.randomUUID().toString();
        ByteSource salt = ByteSource.Util.bytes(saltStr);
        String pwd = new SimpleHash("MD5",user.getPassword(),salt,1024).toString();
        System.out.println("md5pwd:"+pwd );
        user.setPassword(pwd);
        //保存uuid
        user.setSalt(saltStr);
        //保存日志信息
        Date now=new Date();
        user.setCreatedUser("System");
        user.setCreatedTime(now);
        user.setModifiedUser("System");
        user.setModifiedTime(now);
        userDao.add(user);
        return user;
    }
    //根据用户名查询
    @Override
    public User getUserByName(String username) {
        String where="username='"+username+"'";
        List<User> users=userDao.select(where, null, null, null);
        if(users.size()==0) {
            return null;
        }else {
            return users.get(0);
        }
    }
    //根据id查询用户
    @Override
    public User finUserById(int id) {
        String where="id='"+id+"'";
        List<User> users=userDao.select(where, null, null, null);
        if(users.size()==0) {
            return null;
        }else {
            return users.get(0);
        }
    }

    //修改用户密码
    @Override
    public void updatePwd(Integer id, String oldPassword, String newPassword) {
        //获得id对应的用户
        User data = finUserById(id);
        if (data != null) {
            String salt = data.getSalt();
            String md5oldpwd = getEncrpytedPassword(oldPassword, salt).toUpperCase();
            if (data.getPassword().equals(md5oldpwd)) {
                //密码匹配，可以修改
                String md5newpwd = getEncrpytedPassword(newPassword, salt).toUpperCase();
                User user = new User();
                user.setId(id);
                user.setPassword(md5newpwd);
                userDao.update(user);
            } else {
                //密码不匹配，不可以修改
                throw new PasswordNotExit("密码不正确，您无法修改此密码");
            }
        } else {
            throw new UsernameIsNll("此用户不存在，可能被删除，请联系管理员");
        }
    }

    @Override
    public Integer changeInfo(Integer id, String username, String mobile, String email) {
        // 获取id匹配的用户信息
        User data = finUserById(id);
        // 判断是否获取到用户信息
        if (data == null) {
            throw new UsernameIsNll("用户信息不存在(id=" + id + ")，可能已经被删除，请联系系统管理员！");
        } else {
            // 判断用户名参数是否为null
            if (username != null) {
                // 不为null，即客户端提交了用户名，表示希望修改用户名
                // 则：检查用户名是否被占用
                User u = getUserByName(username);
                if (u != null) {
                    // 找到用户名匹配的数据，即用户名是存在的
                    // 则：判断这个用户名是不是当前用户(自己)的
                    if (data.getUsername().equals(u.getUsername())) {
                        // 找到的用户名也是自己占用的用户名
                        // 则：不需要修改用户名
                        username = null;
                    } else {
                        // 找到的用户名并不是自己占用的，而是别人已经占用的用户名
                        // 则：抛出异常
                        throw new UsernameConflictException("您希望更新的用户名(" + username + ")已经被占用！");
                    }
                }
            }

            // 执行修改
            User user = new User();
            user.setId(id);
            user.setUsername(username);
            user.setMobile(mobile);
            user.setEmail(email);
            System.out.println("修改后的user："+user);
            return userDao.update(user);
        }

    }
    //删除员工
    @Override
    public Integer delete(Integer id,Integer shopNumber) {
        return userDao.delete(id,shopNumber);
    }
    //获取所有员工信息
    @Override
    public List<User> getAllUser(Integer shopNumber) {
        String where="shopNumber='"+shopNumber+"'";
        List<User> users=userDao.select(where, null, null, null);
        return users;
    }
}
