package vip.wente.wtsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.wente.wtsystem.dao.RoomDetailsDao;
import vip.wente.wtsystem.entity.RoomDetails;

import java.util.List;

/**
 * @program: WtSystem
 * @description: 关联房间实现方法
 * @author: Sonxnos7
 * @create: 2018-10-16 18:34
 **/
@Service("roomDetailsService")
public class RoomDetailsServiceImpl implements IRoomDetailsService{
    @Autowired
    private RoomDetailsDao roomDetailsDao;
    @Override
    public List<RoomDetails> getByRoomType(Integer type) {
        return roomDetailsDao.getByRoomType(type);
    }
}
