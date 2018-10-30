package vip.wente.wtsystem.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import vip.wente.wtsystem.entity.Goods;
import vip.wente.wtsystem.entity.Room;

import java.util.List;

/**
 * @program: WtSystem
 * @description: 商品的接口方法
 * @author: Sonxnos7
 * @create: 2018-10-18 09:27
 **/
@Repository
public interface GoodsDao {
    /**
     * 添加商品
     * @param goods
     * @return
     */
    Integer add(Goods goods);

    /**
     * 获得所有商品
     * @param
     * @return
     */
    List<Goods> getAllGoods(@Param("where") String where, @Param("orderBy")String orderBy, @Param("offerset")Integer offerset, @Param("countPerpage")Integer countPerpage);

    /**
     * 删除商品
     * @param id
     * @param shopNumber
     * @return
     */
    Integer delete(@Param("id") Integer id,@Param("shopNumber") Integer shopNumber);

    /**
     * 修改商品信息
     * @param goods
     * @return
     */
    Integer update(Goods goods);

    /**
     * 修改商品库存
     * @param goods
     * @return
     */
    Integer updateAmount(Goods goods);
}
