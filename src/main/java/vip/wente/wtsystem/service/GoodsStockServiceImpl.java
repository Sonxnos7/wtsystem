package vip.wente.wtsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.wente.wtsystem.dao.GoodsStockDao;
import vip.wente.wtsystem.entity.GoodsStock;

/**
 * @program: WtSystem
 * @description: 商品库存
 * @author: Sonxnos7
 * @create: 2018-10-30 15:16
 **/
@Service
public class GoodsStockServiceImpl implements IGoodsSrockService{
    @Autowired
    private GoodsStockDao goodsStockDao;
    //添加商品库存记录
    @Override
    public Integer add(GoodsStock goodsStock) {
        return goodsStockDao.add(goodsStock);
    }
}
