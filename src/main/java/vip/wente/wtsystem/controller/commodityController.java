package vip.wente.wtsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: wtsystem
 * @description: 商品相关控制器
 * @author: Mu
 * @create: 2018-10-17 15:56
 **/

@Controller
@RequestMapping("/commodity")
public class commodityController {

    @RequestMapping("/list")
    public String toList(){
        return "commodity/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "commodity/add";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(){
        return "commodity/update";
    }
}
