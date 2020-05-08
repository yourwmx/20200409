package com.xzsd.app.buycar.dao;

import com.xzsd.app.buycar.entity.BuycarInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * BuycarDao
 * wumaoxing
 * 2020-04-14 10:58
 */
public interface BuycarDao {
    /**
     * 新增购物车
     * wumaoxing
     * 2020-04-14 11:24
     */
    int addBuycar(BuycarInfo buycarInfo);
    /**
     * 查询购物车分页列表
     * wumaoxing
     * 2020-04-14 14:19
     */
    List<BuycarInfo> listBuycars(BuycarInfo buycarInfo);
    /**
     * 修改购物车
     * wumaoxing
     * 2020-04-14 15:17
     */
    int updateBuycarById(BuycarInfo buycarInfo);
    /**
     * 检验商品是否已在购物车中
     * wumaoxing
     * 2020-04-14 15:15
     */
    int countBuycarGoods(BuycarInfo buycarInfo);
    /**
     * 删除购物车
     * wumaoxing
     * 2020-04-14 15:26
     */
    int deleteBuycar(@Param("listDeleteBuycarId") List<String> listDeleteBuycarId, @Param("updateUserId") String updateUserId);
}
