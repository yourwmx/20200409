package com.xzsd.pc.good.dao;

import com.xzsd.pc.good.entity.GoodClassifyDataInfo;
import com.xzsd.pc.good.entity.GoodInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * GoodDao
 * wumaoxing
 * 2020-03-26 10:55
 */
public interface GoodDao {
    /**
     * 统计商品数量
     * wumaoxing
     * 2020-03-26 10:55
     */
    int countGoodAccount(GoodInfo goodInfo);
    /**
     * 新增商品
     * wumaoxing
     * 2020-03-26 11:02
     */
    int addGood(GoodInfo goodInfo);
    /**
     * 商品详情
     * wuamoxing
     * 2020-04-21 13:52
     */
    GoodInfo findGoodsById(String goodsId);
    /**
     * 修改商品
     * wumaoxing
     * 2020-03-26 14:22
     */
    int updateGoodById(GoodInfo goodInfo);
    /**
     * 删除商品
     * wumaoxing
     * 2020-03-28 10:25
     */
    int deleteGood(@Param("listDeleteGoodsId") List<String> listDeleteGoodsId, @Param("updateUserId") String updateUserId);
    /**
     * 商品上下架
     * wumaoxing
     * 2020-03-28 10:44
     */
    int updateGoodState(@Param("listUpdateGoodsId") List<String> listUpdateGoodsId, @Param("updateUserId") String updateUserId, @Param("goodsState") String goodsState);
    /**
     * 查询商品分类
     * wumaoxing
     * 2020-03-28 11:19
     */
    List<GoodClassifyDataInfo> queryTempGoodClassify(String lastClassifyId);
    /**
     * 商品分页列表
     * wumaoxing
     * 2020-03-28 11:33
     */
    List<GoodInfo> listGoods(GoodInfo goodInfo);
    /**
     * 查询商品分类下是否有商品
     * wumaoxing
     * 2020-05-01 14:38
     */
    int queryGoodByGoodClassify(String classifyId);
}
