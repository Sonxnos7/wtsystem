package vip.wente.wtsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vip.wente.wtsystem.entity.Member;
import vip.wente.wtsystem.entity.RoomDetails;
import vip.wente.wtsystem.service.IGoodsService;
import vip.wente.wtsystem.service.IMemberService;
import vip.wente.wtsystem.service.IRoomDetailsService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: wtsystem
 * @description: 会员相关控制器
 * @author: Mu
 * @create: 2018-10-18 13:16
 **/

@Controller
@RequestMapping("/member")
public class memberController {
    @Autowired
    private IMemberService memberService;
    @Autowired
    private IRoomDetailsService roomDetailsService;
    @RequestMapping("/toList")
    public String toList(HttpSession session, ModelMap map,Integer page){
        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
        Integer count=memberService.getMemberCount(shopNumber);
        //每页10条
        Integer pages=(int)Math.ceil(count*1.0/ 1000);
        map.addAttribute("totalPage",pages);
        if(page==null||page<0) {
            page=1;
        }
        //判断page的值是否在最大值范围内
        if(page>pages) {
            page=pages;
        }
        map.addAttribute("indexPage",page);
        Integer offset=(page-1)*1000;
        List<Member> list=memberService.getAllMembers(shopNumber,offset,1000);
        map.addAttribute("list",list);
        return "member/list";
    }
    //显示添加页面
    @RequestMapping("/toAdd")
    public String toadd(ModelMap map){
        List<RoomDetails> type1=roomDetailsService.getByRoomType(7);
        List<RoomDetails> type2=roomDetailsService.getByRoomType(5);
        List<RoomDetails> type3=roomDetailsService.getByRoomType(6);
        map.addAttribute("type1",type1);
        map.addAttribute("type2",type2);
        map.addAttribute("type3",type3);
        return "member/add";
    }
    //显示修改会员页面
    @RequestMapping("/toUpdate")
    public String toUpdate(ModelMap map,Integer id,HttpSession session){
        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
        List<RoomDetails> type=roomDetailsService.getByRoomType(6);
        Member member=memberService.getMemberById(id,shopNumber);
        map.addAttribute("type",type);
        map.addAttribute("member",member);
        return "member/update";
    }
    //处理添加业务
    @RequestMapping("/handle_Add")
    public String toAdd(HttpSession session, Member member){
        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
        String createUser=(String) session.getAttribute("uname");
        member.setShopNumber(shopNumber);
        member.setCreatedUser(createUser);
        memberService.add(member);
        return "redirect:toList";
    }
    //处理修改业务
    @RequestMapping(value = "/handle_update",method = RequestMethod.POST)
    public String handleUpdate(Integer id,HttpSession session,String name,Integer lever,String phone,String other){
        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
        Member member=memberService.getMemberById(id,shopNumber);
        String user=(String) session.getAttribute("uname");
        member.setModifiedUser(user);
        member.setName(name);
        member.setId(id);
        member.setShopNumber(shopNumber);
        member.setPhone(phone);
        member.setLever(lever);
        member.setOther(other);
        memberService.update(member);
        return "redirect:toList";
    }
    //进行搜索业务
    @RequestMapping("/search")
    public String search(HttpSession session,String info,ModelMap map){
        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
        List<Member> list=memberService.getMemberBySearch(shopNumber,info);
        map.addAttribute("list",list);
        return "member/list";
    }
    //处理删除业务
    @RequestMapping("/delete")
    public String deleteById(HttpSession session,Integer id){
        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
        memberService.delete(id,shopNumber);
        return "redirect:toList";
    }
}
