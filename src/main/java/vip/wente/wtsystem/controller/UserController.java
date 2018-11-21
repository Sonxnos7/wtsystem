package vip.wente.wtsystem.controller;


import org.springframework.ui.ModelMap;
import vip.wente.wtsystem.entity.ResponseResult;
import vip.wente.wtsystem.entity.User;

import vip.wente.wtsystem.exceptions.ServiceException;
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
import java.util.List;
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

    //跳转员工管理页面
    @RequestMapping("/toStaffSet")
    public String toSfaffSet(){
        return "setting/staff";
    }

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
        return "login/login";
    }

    /**
     * 处理注册用户业务
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/handle_add",method = RequestMethod.POST)
    @ResponseBody
    public  ResponseResult<Void> reg(String username, String password, String role,Integer shopNumber){
        ResponseResult<Void> rr;
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        user.setShopNumber(shopNumber);
        try {
             User u=userService.addUser(user);
            System.out.println(u);
            rr=new ResponseResult<Void>( ResponseResult.STAT_OK);
            System.out.println("注册成功！");
        } catch (UsernameConflictException e) {
            rr=new ResponseResult<Void>(e);
        }

        return rr;
    }

    /**
     * 处理用户登录业务
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/handle_login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<Void> handle_login(String username, String password,HttpSession session){
        ResponseResult<Void> rr;
        Subject currentUser = SecurityUtils.getSubject();
        if(!currentUser.isAuthenticated()){
            // 把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken access_token = new UsernamePasswordToken(username, password);
            try{
                //登录认证 - 调用userRealm
                currentUser.login(access_token);
                // 判断当前用户是否登录
                if (currentUser.isAuthenticated() == true) {
                    //用户id，酒店id放入session
                    User user=userService.getUserByName(username);
                    Integer uid=user.getId();
                    Integer shopNumber=user.getShopNumber();
                    session.setAttribute("uid",uid);
                    session.setAttribute("uname",username);
                    session.setAttribute("shopNumber",shopNumber);
                    rr=new ResponseResult<Void>(0,"登陆成功");
                    return rr;
                }
            }catch (IncorrectCredentialsException e) {
                rr=new ResponseResult<Void>(1,"账号或密码错误");
                return rr;
            }

        }
        rr=new ResponseResult<Void>(1);
        return rr;

    }
    //处理修改用户密码业务
    @RequestMapping(value = "/update_pwd",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<Void> handle_pwd(String oldPassword,String newPassword,String confirmPassword,HttpSession session){
        ResponseResult<Void> rr;
        String username=(String) session.getAttribute("uname");
        User user=userService.getUserByName(username);
        //两次输入密码不一样
        if(!confirmPassword.equals(newPassword)){
           rr=new ResponseResult<>(0,"两次输入不一致！");
           return rr;
        }else{
            try {
                Integer id=(Integer) session.getAttribute("uid");
                userService.updatePwd(id, oldPassword, newPassword);
                rr=new ResponseResult<Void>(ResponseResult.STAT_OK);
                return rr;
            } catch (ServiceException e) {
                rr= new ResponseResult<Void>(0,e.getMessage());
                return rr;
            }

        }
    }
    //处理修改用户信息业务
    @RequestMapping(value="/handle_change_info",method=RequestMethod.POST)
    @ResponseBody
    public ResponseResult<Void> handleChangeInfo(
            String username,
            String mobile,
            String email,
            HttpSession session) {
        // 检查数据的有效性
        if ("".equals(username)) {
            username = null;
        }
        // 获取session中的uid
        Integer id =(Integer) session.getAttribute("uid");

        // 声明返回值
        ResponseResult<Void> rr;

        try {
            // 执行修改
            userService.changeInfo(id, username, mobile, email);
            rr = new ResponseResult<Void>(
                    ResponseResult.STAT_OK);
        } catch (ServiceException e) {
            rr = new ResponseResult<Void>(e);
        }

        return rr;
    }
    @RequestMapping("/getAllUser")
    public String getAllUsers(ModelMap map,HttpSession session){
        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
       List<User> list= userService.getAllUser(shopNumber);
       map.addAttribute("users",list);
        System.out.println("当前员工数："+list.size());
       return "userList";
    }
    @RequestMapping("/getUserInfo")
    public String changeInfo(Integer id,ModelMap map){
        User user=userService.finUserById(id);
        map.addAttribute("user",user);
        return "updateUser";
    }
    //处理登出业务
    @RequestMapping("/out")
    public String loginOut(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "login/login";
    }
}

