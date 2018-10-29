package vip.wente.wtsystem.dao;

import org.apache.ibatis.annotations.Param;
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

    /**
     * 添加商品种类
     * @param type
     * @param details
     * @return
     */
    Integer add(@Param("type") Integer type, @Param("details") String details);
}
