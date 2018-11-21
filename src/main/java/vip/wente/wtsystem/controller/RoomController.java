package vip.wente.wtsystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import vip.wente.wtsystem.entity.Room;
import vip.wente.wtsystem.entity.RoomDetails;
import vip.wente.wtsystem.service.IRoomDetailsService;
import vip.wente.wtsystem.service.IRoomService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @program: WtSystem
 * @description: 房间管理
 * @author: Sonxnos7
 * @create: 2018-10-13 10:25
 **/
@Controller
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private IRoomService roomService;
    @Autowired
    private IRoomDetailsService roomDetailsService;

    //跳转新增预订页面
    @RequestMapping("/toNewRes")
    public String toNewRes(){
        return "reservation/newRes";
    }

    //跳转查看预订页面
    @RequestMapping("/toListRes")
    public String toListRes(){
        return "reservation/listRes";
    }

    //跳转房间设置页面
    @RequestMapping("/toRoomSet")
    public String toRoomSet(){
        return "setting/room";
    }

    //显示添加房间页面
    @RequestMapping("/add")
    public String showAdd(ModelMap map){
        List<RoomDetails> type1=roomDetailsService.getByRoomType(1);
        List<RoomDetails> type2=roomDetailsService.getByRoomType(2);
        System.out.println(type1.size());
        map.addAttribute("type1",type1);
        map.addAttribute("type2",type2);
        return "roomset/add";
    }
    @RequestMapping("/update")
    public String showUpdate(ModelMap map,Integer id,HttpSession session){
        List<RoomDetails> type1=roomDetailsService.getByRoomType(1);
        List<RoomDetails> type2=roomDetailsService.getByRoomType(2);
        map.addAttribute("type1",type1);
        map.addAttribute("type2",type2);
        //获得要修改的房间
        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
        Room room=roomService.getRoomById(shopNumber,id);
        System.out.println("要修改的房间信息是："+room);
        map.addAttribute("room",room);
        return "roomset/update";
    }
    //处理添加房间业务
    @RequestMapping(value = "/addRoom",method = RequestMethod.POST)
    public String addRoom(String roomNumber,Integer roomAmount,Integer roomState,Integer roomType, Double standardPriceDay,Double vipPriceDay, HttpSession session){
        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
        String createUser=(String) session.getAttribute("uname");
        List<Room> r=roomService.getByName(shopNumber,roomNumber);
        if(r.size()!=0&r!=null){
            //房间已经存在
            return roomNumber+"已经存在了，房间号不能重复！";
        }
        Room room=new Room();
        room.setCreatedUser(createUser);
        room.setShopNumber(shopNumber);
        room.setRoomAmount(roomAmount);
        room.setRoomNumber(roomNumber);
        room.setRoomState(roomState);
        room.setRoomType(roomType);
        room.setVipPriceDay(vipPriceDay);
        room.setStandardPriceDay(standardPriceDay);
        System.out.println("添加的房间信息："+room);
        roomService.addRoom(room);
        return "redirect:list";
    }
    //处理修改房间信息业务
    @RequestMapping("/handle_update")
    public String handleUpdate(Integer id,String roomNumber,Integer roomAmount,Integer roomState,Integer roomType, Double standardPriceDay,Double vipPriceDay, HttpSession session){
        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
        String createUser=(String) session.getAttribute("uname");
        Room room=new Room();
        room.setId(id);
        room.setCreatedUser(createUser);
        room.setShopNumber(shopNumber);
        room.setRoomAmount(roomAmount);
        room.setRoomNumber(roomNumber);
        room.setRoomState(roomState);
        room.setRoomType(roomType);
        room.setVipPriceDay(vipPriceDay);
        room.setStandardPriceDay(standardPriceDay);
        roomService.update(room);
        return "redirect:list";
    }
    //显示所有房间的信息
    @RequestMapping("/list")
    public String showRoomList(HttpSession session, ModelMap map,Integer page){
        if(page==null){
            page=1;
        }

        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
        List<Room> rooms = roomService.getAllRooms(shopNumber,1,50);
        map.addAttribute("rooms",rooms);
        return "roomset/roomset";
    }
    @RequestMapping("/search")
    public String search(HttpSession session,String roomName,ModelMap map){
        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
        List<Room> rooms=roomService.getRoomByName(shopNumber,roomName);
        map.addAttribute("rooms",rooms);
        return "roomset/roomset";
    }
    @RequestMapping("/delete")
    public String delete(HttpSession session,Integer id){
        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
        roomService.delete(id,shopNumber);
        return "redirect:list";
    }

}
