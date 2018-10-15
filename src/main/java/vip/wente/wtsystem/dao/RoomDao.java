package vip.wente.wtsystem.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import vip.wente.wtsystem.entity.Room;

import java.util.List;

/**
 * @program: WtSystem
 * @description: 房间的管理
 * @author: Sonxnos7
 * @create: 2018-10-12 18:24
 **/
@Repository
public interface RoomDao {
    /**
     * 添加房间
     * @param room
     * @return
     */
    Integer addRoom(Room room);

    /**
     * 获取所有房间
     * @return
     */
    List<Room> getRooms(@Param("where") String where, @Param("orderBy")String orderBy, @Param("offerset")Integer offerset, @Param("countPerpage")Integer countPerpage);

    /**
     * 修改房间信息
     * @param room
     * @return
     */
    Integer update(Room room);

    /**
     * 删除房间
     * @param id
     * @param shopNumber
     * @return
     */
    Integer delete(Integer id,Integer shopNumber);

}
