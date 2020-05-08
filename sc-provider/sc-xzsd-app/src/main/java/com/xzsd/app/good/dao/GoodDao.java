package com.xzsd.app.good.dao;

import com.xzsd.app.comment.entity.CommentInfo;
import com.xzsd.app.good.entity.GoodClassifyDataInfo;
import com.xzsd.app.good.entity.GoodInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * GoodDao
 * wumaoxing
 * 2020-03-26 10:55
 */
public interface GoodDao {
    /**
     * 商品分页列表
     * wumaoxing
     * 2020-03-28 11:33
     */
    List<GoodInfo> listGoods(GoodInfo goodInfo);
    /**
     * 查询商品详细
     * wumaoxing
     * 2020-04-13 16:31
     */
    GoodInfo findGoodById(String goodsId);
    /**
     * 查询门店名称
     * wumaoxing
     * 2020-04-25 21:19
     */
    String findStoreById(String storeId);
    /**
     * 查询商品库存与销量
     * wumaoxing
     * 2020-04-21 15:01
     */
    List<GoodInfo> queryGoodsRestNumber(@Param("goodsRestNumberList") List<String> goodsRestNumberList);
    /**
     * 修改商品库存
     * wumaoxing
     * 2020-04-21 16:07
     */
    int updateGoodsRestNumber(@Param("originalGoodsInfo") List<GoodInfo> originalGoodsInfo);
    /**
     * 修改商品销量
     * wumaoxing
     * 2020-04-26 13:39
     */
    int updateGoodsSaleNumber(@Param("originalGoodsInfo") List<GoodInfo> originalGoodsInfo);
    /**
     * 修改商品浏览量
     * wumaoxing
     * 2020-04-21 18:03
     */
    int updateGoodsLookNumber(String goodsId);
}
