package vip.wente.wtsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: wtsystem
 * @description: 会员相关控制器
 * @author: Mu
 * @create: 2018-10-18 13:16
 **/

@Controller
@RequestMapping("/member")
public class memberController {

    @RequestMapping("/toList")
    public String toList(){
        return "member/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "member/add";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(){
        return "member/update";
    }
}
