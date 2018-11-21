package vip.wente.wtsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: wtsystem
 * @description: 主页控制器
 * @author: Mu
 * @create: 2018-10-16 14:45
 **/
@Controller
@RequestMapping("/main")
public class MainController {


    @RequestMapping("/toMain")
    public String toMain(){
        return "main/main";
    }

    // @RequestMapping("/toMain")
    // public String toMain(){
    //     return "main/main";
    // }
    // @RequestMapping("/toMain")
    // public String toMain(){
    //     return "main/main";
    // }
    // @RequestMapping("/toMain")
    // public String toMain(){
    //     return "main/main";
    // }
    // @RequestMapping("/toMain")
    // public String toMain(){
    //     return "main/main";
    // }

}
