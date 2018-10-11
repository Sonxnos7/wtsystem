package vip.wente.wtsystem.service;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import vip.wente.wtsystem.dao.UserDao;
import vip.wente.wtsystem.entity.User;

import vip.wente.wtsystem.exceptions.UsernameConflictException;
import vip.wente.wtsystem.exceptions.UsernameIsNll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
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
        String pwd = new SimpleHash("MD5",user.getPassword(),salt,1024).toHex();
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

    @Override
    public User getUserByName(String username) {
        if(username == null){
            throw new UsernameIsNll("用户名不能为空！");
        }
        User user = userDao.getUserByName(username);
        if(user != null){
            //存在此用户
            return user;
        }else{
            return null;
        }
    }
}
