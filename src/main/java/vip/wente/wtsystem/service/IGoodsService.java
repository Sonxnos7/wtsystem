package vip.wente.wtsystem.service;

import vip.wente.wtsystem.entity.Goods;

import java.util.List;

/**
 * @program: WtSystem
 * @description:
 * @author: Sonxnos7
 * @create: 2018-10-18 09:37
 **/

public interface IGoodsService {
    /**
     * 添加商品
     * @param goods
     * @return
     */
    Integer add(Goods goods);

    /**
     * 获取所有的商品信息
     * @param shopNumber
     * @return
     */
    List<Goods> getAllGoods(Integer shopNumber);

    /**
     * 根据商品id获取商品信息
     * @param id
     * @param shopNumber
     * @return
     */
    Goods getGoodById(Integer id,Integer shopNumber);

    /**
     * 根据名字查询商品
     * @param shopNumber
     * @param name
     * @return
     */
    List<Goods> getGoodByName(Integer shopNumber,String name);

    /**
     * 删除商品
     * @param id
     * @param shopNumber
     * @return
     */
    Integer delete(Integer id,Integer shopNumber);

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
