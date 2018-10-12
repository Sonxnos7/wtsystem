package vip.wente.wtsystem;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import vip.wente.wtsystem.realm.MyRealm;

/**
 * @program: WtSystem
 * @description: 测试类
 * @author: Sonxnos7
 * @create: 2018-10-12 11:13
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class test {
    @Test
    public void test(){
        //使用md5进行加密，加密一次
        HashedCredentialsMatcher match=new HashedCredentialsMatcher();
        match.setHashAlgorithmName("md5");
        match.setHashIterations(1024);
        MyRealm ur=new MyRealm();
        ur.setCredentialsMatcher(match);
        //1.构建SecurityManager环境
        DefaultSecurityManager dsm=new DefaultSecurityManager();
        dsm.setRealm(ur);
        //2.主体提交认证请求
        SecurityUtils.setSecurityManager(dsm);
        Subject subject=SecurityUtils.getSubject();

        UsernamePasswordToken token=new UsernamePasswordToken("张三", "123");
        subject.login(token);
        System.out.println("用户身份认证："+subject.isAuthenticated());
        //subject.checkPermission("user:delete");
       // subject.checkRole("admin");
    }
}
