package com.xzsd.app.hotgood.dao;

import com.xzsd.app.hotgood.entity.HotgoodInfo;

import java.util.List;

/**
 * HotgoodDao
 * wumaoxing
 * 2020-04-04 13:35
 */
public interface HotgoodDao {
    /**
     * 热门位商品分页列表
     * wumaoxing
     * 2020-04-04 13:37
     */
    List<HotgoodInfo> listHotgoods(int hotgoodShowNumber);
}
