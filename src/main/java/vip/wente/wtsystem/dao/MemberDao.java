package vip.wente.wtsystem.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import vip.wente.wtsystem.entity.Member;
import vip.wente.wtsystem.entity.Room;

import java.util.List;

/**
 * @program: WtSystem
 * @description: 会员管理
 * @author: Sonxnos7
 * @create: 2018-10-23 09:36
 **/
@Repository
public interface MemberDao {
    /**
     * 添加会员
     * @param member
     * @return
     */
    Integer add(Member member);

    /**
     * 获取所有会员
     * @return
     */
    List<Member> getMerbers(@Param("where") String where, @Param("orderBy")String orderBy, @Param("offerset")Integer offerset, @Param("countPerpage")Integer countPerpage);

    /**
     * 修改会员信息
     * @param member
     * @return
     */
    Integer update(Member member);
    /**
     * 删除会员
     */
    Integer delete(@Param("id") Integer id,@Param("shopNumber") Integer shopNumber);

    /**
     * 获取会员总数
     * @param shopNumber
     * @return
     */
    Integer getMemberCount(Integer shopNumber);
}
