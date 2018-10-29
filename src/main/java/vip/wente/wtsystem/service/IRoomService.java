package vip.wente.wtsystem.service;

import com.github.pagehelper.PageInfo;
import vip.wente.wtsystem.entity.Room;

import java.util.List;

/**
 * @program: WtSystem
 * @description: 管理房间的接口
 * @author: Sonxnos7
 * @create: 2018-10-12 18:36
 **/

public interface IRoomService {
    /**
     * 添加房间
     * @param room
     * @return
     */
    Integer addRoom(Room room);

    /**
     * 修改房间信息
     * @param room
     * @return
     */
    Integer update(Room room);

    /**
     * 删除房间
     * @param id 房间id
     * @param shopNumber 酒店id
     * @return
     */
    Integer delete(Integer id,Integer shopNumber);

    /**
     * 查询当前酒店的所有房间
     * @param shopNumber 酒店id
     * @return
     */
    List<Room> getAllRooms(Integer shopNumber, Integer pageNum, Integer pageSize);

    /**
     * 查询当前酒店所有的空房间
     * @param shopNumber 酒店id
     * @return
     */
    List<Room> getEmptyRooms(Integer shopNumber,Integer offset, Integer countPerpage);

    /**
     * 查询当前被使用的房间
     * @param shopNumber
     * @param offset
     * @param countPerpage
     * @return
     */
    List<Room> getUseRooms(Integer shopNumber,Integer offset, Integer countPerpage);

    /**
     * 查询当前酒店所有被预定的房间
     * @param shopNumber
     * @return
     */
    List<Room> getOrderRooms(Integer shopNumber,Integer offset, Integer countPerpage);

    /**
     * 根据id获取房间信息
     * @param shopNumber
     * @param id
     * @return
     */
    Room getRoomById(Integer shopNumber,Integer id);

    /**
     * 根据房间号进行模糊查询获得房间信息
     * @param shopNumber
     * @param roomNumber
     * @return
     */
    List<Room> getRoomByName(Integer shopNumber,String roomNumber);

    /**
     * 根据房间号进行查询获得房间信息
     * @param shopNumber
     * @param roomNumber
     * @return
     */
    List<Room> getByName(Integer shopNumber,String roomNumber);

}
