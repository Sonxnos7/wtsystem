package vip.wente.wtsystem.dao;

import org.springframework.stereotype.Repository;
import vip.wente.wtsystem.entity.GoodsStock;

/**
 * @program: WtSystem
 * @description: 库存接口
 * @author: Sonxnos7
 * @create: 2018-10-30 15:07
 **/
@Repository
public interface GoodsStockDao {
    /**
     * 添加库存记录
     * @param goodsStock
     * @return
     */
    Integer add(GoodsStock goodsStock);
}
