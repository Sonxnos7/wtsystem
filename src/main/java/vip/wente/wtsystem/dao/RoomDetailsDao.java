package vip.wente.wtsystem.dao;

import org.springframework.stereotype.Repository;
import vip.wente.wtsystem.entity.RoomDetails;

import java.util.List;

/**
 * @program: WtSystem
 * @description: 房间管理的查询
 * @author: Sonxnos7
 * @create: 2018-10-16 18:25
 **/
@Repository
public interface RoomDetailsDao {
    List<RoomDetails> getByRoomType(Integer type);
}
