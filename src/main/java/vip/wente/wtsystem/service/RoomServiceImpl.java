package vip.wente.wtsystem.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import vip.wente.wtsystem.dao.RoomDao;
import vip.wente.wtsystem.entity.Room;

import java.util.List;

/**
 * @program: WtSystem
 * @description: 管理房间的业务
 * @author: Sonxnos7
 * @create: 2018-10-12 18:37
 **/
@Service("roomService")
public class RoomServiceImpl  implements IRoomService{
    @Autowired
    private RoomDao roomDao;
    @Override
    //实现增加房间
    public Integer addRoom(Room room) {
        return roomDao.addRoom(room);
    }
    //修改房间信息
    @Override
    public Integer update(Room room) {
        return roomDao.update(room);
    }
    //删除房间
    @Override
    public Integer delete(Integer id, Integer shopNumber) {
        return roomDao.delete(id,shopNumber);
    }
    //获取所有房间信息，默认按照房间状态排序
    @Override
    public PageInfo<Room> getAllRooms(Integer shopNumber, Integer pageNum, Integer pageSize) {
        //使用分页插件
        PageHelper.startPage(pageNum, pageSize);
        String where="shopNumber='"+shopNumber+"'";
        String orderBy="roomAmount asc,id asc";
        List<Room> list= roomDao.getRooms(where,orderBy,null,null);
        System.out.println("查到的房间数："+list.size());
        for(Room r:list){
            System.out.println(r);
        }
        PageInfo<Room> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    //获取所有空房间信息
    @Override
    public List<Room> getEmptyRooms(Integer shopNumber,Integer offset, Integer countPerpage) {
        String where= "shopNumber='"+shopNumber+"' and roomStateID=0";
        String orderBy="roomAmount asc,id asc";
        return roomDao.getRooms(where,orderBy,offset,countPerpage);
    }
    //获取被使用的房间
    @Override
    public List<Room> getUseRooms(Integer shopNumber, Integer offset, Integer countPerpage) {
        String where= "shopNumber='"+shopNumber+"' and roomStateID=1";
        String orderBy="roomAmount asc,id asc";
        return roomDao.getRooms(where,orderBy,offset,countPerpage);
    }

    //获取所有被预定的房间
    @Override
    public List<Room> getOrderRooms(Integer shopNumber,Integer offset, Integer countPerpage) {
        String where= "shopNumber='"+shopNumber+"' and roomStateID=2";
        String orderBy="roomAmount asc,id asc";
        return roomDao.getRooms(where,orderBy,offset,countPerpage);
    }
    //通过id获取房间信息
    @Override
    public Room getRoomById(Integer shopNumber, Integer id) {
        String where="shopNumber='"+shopNumber+"' and r.id="+id;
        Room room=roomDao.getRooms(where,null,null,null).get(0);
        return room;
    }
}
