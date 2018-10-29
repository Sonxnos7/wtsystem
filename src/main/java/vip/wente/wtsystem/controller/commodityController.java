package vip.wente.wtsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vip.wente.wtsystem.entity.Goods;
import vip.wente.wtsystem.entity.RoomDetails;
import vip.wente.wtsystem.service.IGoodsService;
import vip.wente.wtsystem.service.IRoomDetailsService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: wtsystem
 * @description: 商品相关控制器
 * @author: Mu
 * @create: 2018-10-17 15:56
 **/

@Controller
@RequestMapping("/commodity")
public class commodityController {
    @Autowired
    private IRoomDetailsService roomDetailsService;
    @Autowired
    private IGoodsService goodsService;
    @RequestMapping("/list")
    public String toList(HttpSession session,ModelMap map){
        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
        List<Goods> list=goodsService.getAllGoods(shopNumber);
        map.addAttribute("list",list);
        return "commodity/list";
    }
    //显示添加商品页面
    @RequestMapping("/toAdd")
    public String toAdd(ModelMap map){
        List<RoomDetails> types=roomDetailsService.getByRoomType(3);
        List<RoomDetails> titles=roomDetailsService.getByRoomType(4);
        map.addAttribute("list",types);
        map.addAttribute("titles",titles);
        return "commodity/add";
    }
    //显示修改商品页面
    @RequestMapping("/update")
    public String showUpdate(Integer id,HttpSession session,ModelMap map){
        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
        Goods good=goodsService.getGoodById(id,shopNumber);
        List<RoomDetails> types=roomDetailsService.getByRoomType(3);
        List<RoomDetails> titles=roomDetailsService.getByRoomType(4);
        map.addAttribute("list",types);
        map.addAttribute("titles",titles);
        map.addAttribute("good",good);
        return "commodity/update";
    }
    //处理添加商品业务
    @RequestMapping("/handle_add")
    public String handleAdd(HttpSession session,Integer type,Integer em,String name,double price){
        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
        List<Goods> g=goodsService.getGoodByName(shopNumber,name);
        if(g!=null&g.size()!=0){
            return name+"已经存在了！";
        }
        Goods goods=new Goods();
        goods.setShopNumber(shopNumber);
        goods.setEm(em);
        goods.setName(name);
        goods.setPrice(price);
        goods.setType(type);
        goodsService.add(goods);
        System.out.println("插入商品成功："+goods);
        return "redirect:list";
    }
    //进行删除商品业务
    @RequestMapping("/delete")
    public String delete(HttpSession session,Integer id){
        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
        goodsService.delete(id,shopNumber);
        return "redirect:list";
    }
    //进行修改商品业务
    @RequestMapping("/toUpdate")
    public String toUpdate(HttpSession session,Integer id,String name,Double price,Integer type,Integer em){
        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
        Goods goods=new Goods();
        goods.setId(id);
        goods.setShopNumber(shopNumber);
        goods.setEm(em);
        goods.setName(name);
        goods.setPrice(price);
        goods.setType(type);
        System.out.println("要修改的商品信息是："+goods);
        goodsService.update(goods);
        return "redirect:list";
    }
    //进行搜索商品
    @RequestMapping("/search")
    public String search(HttpSession session,String name,ModelMap map){
        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
        List<Goods> list=goodsService.getGoodByName(shopNumber,name);
        System.out.println("搜到的商品数："+list.size());
        map.addAttribute("list",list);
        return "commodity/list";
    }
}
