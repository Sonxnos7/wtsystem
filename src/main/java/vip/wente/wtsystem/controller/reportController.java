package vip.wente.wtsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: wtsystem
 * @description: 报表相关控制器
 * @author: Mu
 * @create: 2018-11-17 14:29
 **/

@Controller
@RequestMapping("report")
public class reportController {
    //跳转商品日报表页面
    @RequestMapping("toCommodity")
    public String toCommodity(){
        return "report/commodity";
    }
    //跳转班结表页面
    @RequestMapping("toShift")
    public String toShift(){
        return "report/shift";
    }
    //跳转日报表页面
    @RequestMapping("toDay")
    public String toDay(){
        return "report/day";
    }
    //跳转周报表页面
    @RequestMapping("toWeek")
    public String toWeek(){
        return "report/week";
    }
    //跳转月报表页面
    @RequestMapping("toMonth")
    public String toMonth(){
        return "report/month";
    }

}
