package vip.wente.wtsystem.service;

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
}
