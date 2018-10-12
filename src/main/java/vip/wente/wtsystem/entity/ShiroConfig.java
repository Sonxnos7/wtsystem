package vip.wente.wtsystem.entity;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import vip.wente.wtsystem.realm.MyRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: fourteen
 * @description: shiro实体类
 * @author: Sonxnos7
 * @create: 2018-10-09 22:08
 **/

@Configuration
public class ShiroConfig {
    private static final Logger logger = LoggerFactory
            .getLogger(ShiroConfig.class);

    /**
     * ShiroFilterFactoryBean 处理拦截资源文件过滤器
     *  </br>1,配置shiro安全管理器接口securityManage;
     *  </br>2,shiro 连接约束配置filterChainDefinitions;
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(
            org.apache.shiro.mgt.SecurityManager securityManager) {
        //shiroFilterFactoryBean对象
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 配置shiro安全管理器 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 指定要求登录时的链接
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        // 未授权时跳转的界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        // filterChainDefinitions拦截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 配置不会被拦截的链接 从上向下顺序判断
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/templates/**", "anon");
        filterChainDefinitionMap.put("/handle_login","anon");
        // 配置退出过滤器,具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        //add操作，该用户必须有【addOperation】权限
       filterChainDefinitionMap.put("/add", "authc");

        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问【放行】-->
       //filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean
                .setFilterChainDefinitionMap(filterChainDefinitionMap);
        logger.debug("Shiro拦截器工厂类注入成功");
        return shiroFilterFactoryBean;
    }
    /**
     * 身份认证realm; (账号密码校验；权限等)
     *
     * @return
     */
    @Bean(name = "myRealm")
    public MyRealm myAuthRealm(HashedCredentialsMatcher matcher) {
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(matcher);
        return myRealm;
    }
    /**
     * shiro安全管理器设置realm认证
     * @return
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager(@Qualifier("myRealm") MyRealm myRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myRealm);
        return manager;
    }



    /**
     *进行MD5加密配置
     * @return
     */
    @Bean(name = "hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //指定加密方式为MD5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //加密次数
        credentialsMatcher.setHashIterations(1024);

        return credentialsMatcher;

    }
    /**
     * Shiro生命周期处理器
     * @return
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    /**
     *  开启shiro aop注解支持.
     *  使用代理方式;所以需要开启代码支持;
     *  开启 权限注解
     *  Controller才能使用@RequiresPermissions
     * @param securityManager
     * @return
     */

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * 整合 thymeleaf标签
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect() {

        return new ShiroDialect();
    }


}
