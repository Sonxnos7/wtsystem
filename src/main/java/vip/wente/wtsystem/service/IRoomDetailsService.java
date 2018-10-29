package vip.wente.wtsystem.service;

import org.apache.ibatis.annotations.Param;
import vip.wente.wtsystem.entity.RoomDetails;

import java.util.List;

/**
 * @program: WtSystem
 * @description: 管理房间的查询
 * @author: Sonxnos7
 * @create: 2018-10-16 18:33
 **/

public interface IRoomDetailsService {
    List<RoomDetails> getByRoomType(Integer type);
    /**
     * 添加商品种类
     * @param type
     * @param details
     * @return
     */
    Integer add(@Param("type") Integer type, @Param("details") String details);
}
