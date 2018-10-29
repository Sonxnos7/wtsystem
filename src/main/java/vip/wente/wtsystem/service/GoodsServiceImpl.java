package vip.wente.wtsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.wente.wtsystem.dao.GoodsDao;
import vip.wente.wtsystem.entity.Goods;

import java.util.List;

/**
 * @program: WtSystem
 * @description:
 * @author: Sonxnos7
 * @create: 2018-10-18 09:37
 **/
@Service("goodsService")
public class GoodsServiceImpl implements IGoodsService{
    @Autowired
    private GoodsDao goodsDao;
    //添加商品
    @Override
    public Integer add(Goods goods) {
        return goodsDao.add(goods);
    }
    //获取所有商品信息
    @Override
    public List<Goods> getAllGoods(Integer shopNumber) {
        String where="shopNumber='"+shopNumber+"'";
        String orderBy="price asc,id asc";
        List<Goods> list=goodsDao.getAllGoods(where,orderBy,null,null);
        return list;
    }
    //根据id获取商品
    @Override
    public Goods getGoodById(Integer id, Integer shopNumber) {
        String where="shopNumber='"+shopNumber+"' and r.id="+id;
        return goodsDao.getAllGoods(where,null,null,null).get(0);
    }
    //根据name获取商品
    @Override
    public List<Goods> getGoodByName(Integer shopNumber, String name) {
        String where="shopNumber='"+shopNumber+"' and r.name='"+name+"'";
        return goodsDao.getAllGoods(where,null,null,null);
    }

    //删除商品
    @Override
    public Integer delete(Integer id, Integer shopNumber) {
        return goodsDao.delete(id,shopNumber);
    }
    //修改商品信息
    @Override
    public Integer update(Goods goods) {
        return goodsDao.update(goods);
    }
}
