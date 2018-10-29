package vip.wente.wtsystem.service;

import vip.wente.wtsystem.entity.Goods;
import vip.wente.wtsystem.entity.Member;
import vip.wente.wtsystem.entity.Room;

import java.util.List;

/**
 * @program: WtSystem
 * @description: 会员管理
 * @author: Sonxnos7
 * @create: 2018-10-23 10:21
 **/

public interface IMemberService {
    /**
     * 添加会员
     * @param member
     * @return
     */
    Integer add(Member member);
    /**
     * 查询当前酒店的所有会员
     * @param shopNumber 酒店id
     * @return
     */
    List<Member> getAllMembers(Integer shopNumber, Integer offerset, Integer countPerpage);

    /**
     * 根据id获取会员信息
     * @param id
     * @param shopNumber
     * @return
     */
    Member getMemberById(Integer id,Integer shopNumber);

    /**
     * 搜索业务
     * @param shopNumber
     * @return
     */
    List<Member> getMemberBySearch(Integer  shopNumber,String info);

    /**
     * 删除会员
     * @param id
     * @param shopNumber
     * @return
     */
    Integer delete(Integer id,Integer shopNumber);

    /**
     * 修改会员信息
     * @param member
     * @return
     */
    Integer update(Member member);

    /**
     * 会员总数
     * @param shopNumber
     * @return
     */
    Integer getMemberCount(Integer shopNumber);
}
