package com.xzsd.pc.goodClassify.dao;

import com.xzsd.pc.goodClassify.entity.GoodClassifyCateInfo;
import com.xzsd.pc.goodClassify.entity.GoodClassifyInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * GoodClassifyDao
 * wumaoxing
 * 2020-03-26 15:18
 */
public interface GoodClassifyDao {
    /**
     * 统计商品分类数量
     * wumaoxing
     * 2020-03-26 15:19
     */
    int countGoodClassifyAccount(GoodClassifyInfo goodClassifyInfo);
    /**
     * 新增商品分类
     * wumaoxing
     * 2020-03-26 15:22
     */
    int addGoodClassify(GoodClassifyInfo goodClassifyInfo);
    /**
     * 修改商品分类
     * wumaoxing
     * 2020-03-26 16:22
     */
    int updateGoodClassifyById(GoodClassifyInfo goodClassifyInfo);
    /**
     * 删除商品分类
     * wumaoxing
     * 2020-03-26 16:23
     */
    int deleteGoodClassifyById(@Param("classifyId") String classifyId, @Param("updateUserId") String updateUserId);
    /**
     * 查询商品一级分类
     * wumaoxing
     * 2020-03-27 10:43
     */
    List<GoodClassifyCateInfo> queryGoodClassify();
    /**
     * 商品分类详情
     * wumaoxing
     * 2020-03-27 14:34
     */
    GoodClassifyInfo findGoodClassifyById(String classifyId);
    /**
     *  查询是否有二级分类
     *  wumaoxing
     *  2020-03-27 17:12
     */
    int queryHaveSecondGoodClassify(String classifyId);
    /**
     * 查询是否为一级分类
     * wumaoxing
     * 2020-05-03 17:47
     */
    String queryLastClassifyById(String classifyId);
}
