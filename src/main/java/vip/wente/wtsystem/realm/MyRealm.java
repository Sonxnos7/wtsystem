package vip.wente.wtsystem.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import vip.wente.wtsystem.entity.User;
import vip.wente.wtsystem.exceptions.UsernameIsNll;
import vip.wente.wtsystem.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @program: fourteen
 * @description: 自定义relam
 * @author: Sonxnos7
 * @create: 2018-10-10 09:50
 **/

public class  MyRealm extends AuthorizingRealm {
    @Autowired
   private IUserService userService;

    @Override
    //用户授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前用户的用户名
        String username=(String) principalCollection.getPrimaryPrincipal();
        User user=userService.getUserByName(username);
        if(user!=null){
            //权限信息对象info,用来存放查出的用户的所有的角色（role）
            SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
            String role=user.getRole();
            info.addRole(role);
            return info;
        }
        return null;
    }

    @Override
    //用户认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //token携带了用户信息
        System.out.println("开始进行认证");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        //获取前端输入的用户名
        String userName  = usernamePasswordToken.getUsername();
        System.out.println("username : "+ userName);
        User user = userService.getUserByName(userName);
        if(user==null){
            throw new UsernameIsNll("此用户不存在");
        }
        System.out.println(user);
        //当前realm对象的name
        String realmName = getName();
        //盐值
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
        //封装用户信息，构建AuthenticationInfo对象并返回
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName, user.getPassword(),credentialsSalt,realmName);
        SecurityUtils.getSubject().getSession().setAttribute("user", user);
        System.out.println("认证完毕");
        return info;

    }
}
