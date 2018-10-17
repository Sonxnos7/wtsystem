package vip.wente.wtsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import vip.wente.wtsystem.entity.ResponseResult;
import vip.wente.wtsystem.entity.RoomDetails;
import vip.wente.wtsystem.service.IRoomDetailsService;

import java.util.List;

/**
 * @program: WtSystem
 * @description: 房间关联处理器
 * @author: Sonxnos7
 * @create: 2018-10-16 18:39
 **/
@Controller
@RequestMapping("/roomDetails")
public class RoomDetailsController {
    @Autowired
    private IRoomDetailsService roomDetailsService;
    @RequestMapping("/getDetails")
    public ResponseResult<List<RoomDetails>> getRoomDetails(Integer type){
        ResponseResult<List<RoomDetails>> rr;
        List<RoomDetails> list=roomDetailsService.getByRoomType(type);
        rr=new ResponseResult<List<RoomDetails>>(1,list);
        return rr;
    }
}
