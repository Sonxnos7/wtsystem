package vip.wente.wtsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vip.wente.wtsystem.entity.Goods;
import vip.wente.wtsystem.entity.GoodsStock;
import vip.wente.wtsystem.entity.RoomDetails;
import vip.wente.wtsystem.service.IGoodsService;
import vip.wente.wtsystem.service.IGoodsSrockService;
import vip.wente.wtsystem.service.IRoomDetailsService;

import javax.servlet.ServletException;
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
    @Autowired
    private IGoodsSrockService goodsSrockService;
    @RequestMapping("/list")
    public String toList(HttpSession session,ModelMap map){
        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
        List<Goods> list=goodsService.getAllGoods(shopNumber);
        map.addAttribute("list",list);
        return "commodity/list";
    }
    //显示添加商品种类页面
    @RequestMapping("/toAdd")
    public String toAdd(ModelMap map){
        List<RoomDetails> types=roomDetailsService.getByRoomType(3);
        List<RoomDetails> titles=roomDetailsService.getByRoomType(4);
        map.addAttribute("list",types);
        map.addAttribute("titles",titles);
        return "commodity/add";
    }
    //显示添加商品数量的页面
    @RequestMapping("/toUp")
    public String toUp(ModelMap map,HttpSession session){
        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
        List<Goods> list=goodsService.getAllGoods(shopNumber);
        map.addAttribute("list",list);
        return "commodity/count";
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
    //显示增加商品库存页面
    @RequestMapping("/toAmount")
    public String showUpAmount(HttpSession session,Integer id,ModelMap map){
        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
        Goods good=goodsService.getGoodById(id,shopNumber);
        map.addAttribute("good",good);
        return "commodity/upAmount";
    }
    //显示出库页面
    @RequestMapping("/todeAmount")
    public String showdeAmount(HttpSession session,Integer id,ModelMap map){
        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
        Goods good=goodsService.getGoodById(id,shopNumber);
        map.addAttribute("good",good);
        return "commodity/deAmount";
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
    //进行增加商品库存修改业务
    @RequestMapping("/changAmount")
    @Transactional
    public String changeAmount(HttpSession session,Integer id,Integer number,double price){
        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
        String user=(String) session.getAttribute("uname");
        Goods goods=goodsService.getGoodById(id,shopNumber);
        goods.setAmount(number);
        goodsService.updateAmount(goods);
        //进行库存业务处理
        String goodsname=goods.getName();
        String em=goods.getEmName();
        String name=goods.getName();
        GoodsStock goodsStock=new GoodsStock();
        goodsStock.setCreatedUser(user);
        goodsStock.setEm(em);
        goodsStock.setNumber(number);
        goodsStock.setPrice(price);
        goodsStock.setShopNumber(shopNumber);
        goodsStock.setType(1);
        goodsStock.setName(name);
        goodsSrockService.add(goodsStock);
        return "redirect:toUp";
    }
    //进行出库业务处理
    @RequestMapping("/handle_Amount")
    public String deAmount(HttpSession session,Integer id,Integer number,double price){
        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
        String user=(String) session.getAttribute("uname");
        Goods goods=goodsService.getGoodById(id,shopNumber);
        Integer amount=goods.getAmount();
        if(number>amount){
            //出库的数量大于当前库存
            return "error";
        }
        goods.setAmount(-number);
        goodsService.updateAmount(goods);
        //进行库存业务处理
        String goodsname=goods.getName();
        String em=goods.getEmName();
        String name=goods.getName();
        GoodsStock goodsStock=new GoodsStock();
        goodsStock.setCreatedUser(user);
        goodsStock.setEm(em);
        goodsStock.setNumber(number);
        goodsStock.setPrice(price);
        goodsStock.setShopNumber(shopNumber);
        goodsStock.setType(2);
        goodsStock.setName(name);
        goodsSrockService.add(goodsStock);
        return "redirect:toUp";
    }
}
