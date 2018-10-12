package vip.wente.wtsystem.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Collection;
import java.util.Map;

/**
 * @program: WtSystem
 * @description: 权限控制器
 * @author: Sonxnos7
 * @create: 2018-10-11 16:00
 **/

public class PermissionController {
    @Autowired
    //请求映射处理映射器
    private RequestMappingHandlerMapping rmhm;
    @RequestMapping("/reload")
    public String reload(){
        //将系统中所有权限表达式加载进入数据库
        //1.获取controller中所有带有@RequestMapping标签的方法
        Map<RequestMappingInfo, HandlerMethod> handleMethods = rmhm.getHandlerMethods();
        Collection<HandlerMethod> methods = handleMethods.values();
        for(HandlerMethod method:methods){
        //2.遍历所有方法，判断当前方法是否带有@RequiresPermossions注解
            RequiresPermissions anno = method.getMethodAnnotation(RequiresPermissions.class);
            if(anno!=null){
                //权限表达式
               String resources = anno.value()[0];

            }
        }
        return null;
    }
}
