package vip.wente.wtsystem.service;

import vip.wente.wtsystem.entity.GoodsStock;

/**
 * @program: WtSystem
 * @description: 商品库存接口
 * @author: Sonxnos7
 * @create: 2018-10-30 15:15
 **/

public interface IGoodsSrockService {
    /**
     * 添加库存记录
     * @param goodsStock
     * @return
     */
    Integer add(GoodsStock goodsStock);
}
