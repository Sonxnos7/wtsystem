package vip.wente.wtsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import vip.wente.wtsystem.entity.Room;
import vip.wente.wtsystem.service.IRoomService;

import javax.servlet.http.HttpSession;
import java.util.Date;

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
    //处理添加房间业务
    @RequestMapping("/addRoom")
    public String addRoom(Integer roomNumber, Integer roomAmount, Double standardPriceDay, HttpSession session){
        Integer shopNumber=(Integer) session.getAttribute("shopNumber");
        String createUser=(String) session.getAttribute("uname");
        Room room=new Room();
        room.setCreatedUser(createUser);
        room.setShopNumber(shopNumber);
        room.setRoomAmount(roomAmount);
        room.setRoomNumber(roomNumber);
        roomService.addRoom(room);
        return "redirect:list";
    }
    //显示所有房间的信息
    @RequestMapping("/list")
    public String showRoomList(){
        return null;
    }
}
