package com.xzsd.app.goodClassify.dao;

import com.xzsd.app.goodClassify.entity.GoodClassifyFirstInfo;

import java.util.List;

/**
 * GoodClassifyDao
 * wumaoxing
 * 2020-03-26 15:18
 */
public interface GoodClassifyDao {
    /**
     * 查询商品一级分类
     * wumaoxing
     * 2020-03-27 10:43
     */
    List<GoodClassifyFirstInfo> queryGoodClassify();
}
