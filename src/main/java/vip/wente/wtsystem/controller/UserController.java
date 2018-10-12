package vip.wente.wtsystem.controller;

import vip.wente.wtsystem.entity.ResponseResult;
import vip.wente.wtsystem.entity.User;
import vip.wente.wtsystem.exceptions.UsernameConflictException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import vip.wente.wtsystem.service.UserServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @program: fourteen
 * @description:
 * @author: Sonxnos7
 * @create: 2018-10-09 16:15
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    /**
     * 显示注册页面
     * @return
     */
    @RequestMapping("/add")
    public String add(Map map){
        return "add";
    }

    /**
     * 显示登陆业务
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 处理注册用户业务
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "/handle_add",method = RequestMethod.POST)
    @ResponseBody
    public  ResponseResult<Void> reg(String username, String password, String role,HttpSession session){
        ResponseResult<Void> rr;
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        try {
             User u=userService.addUser(user);
            System.out.println(u);
            session.setAttribute("uid", u.getId());
            session.setAttribute("uname", u.getUsername());
            rr=new ResponseResult<Void>( ResponseResult.STAT_OK);
            System.out.println("注册成功！");
        } catch (UsernameConflictException e) {
            rr=new ResponseResult<Void>(e);
        }

        return rr;
    }
    @RequestMapping(value = "/handle_login",method = RequestMethod.POST)
    public String handle_login(String username, String password){
        Subject currentUser = SecurityUtils.getSubject();
        if(!currentUser.isAuthenticated()){
            // 把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try{
                //登录认证 - 调用userRealm
                currentUser.login(token);
                System.out.println("22222222");
                // 判断当前用户是否登录
                if (currentUser.isAuthenticated() == true) {
                    return "index";
                }
            }catch (IncorrectCredentialsException e) {
                return "error";
            }

        }
        return "error";

    }
}
