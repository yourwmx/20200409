package com.xzsd.pc.hotgood.dao;

import com.xzsd.pc.dictionary.entity.DictionaryInfo;
import com.xzsd.pc.hotgood.entity.HotgoodInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * HotgoodDao
 * wumaoxing
 * 2020-04-04 13:35
 */
public interface HotgoodDao {
    /**
     * 新增热门位商品
     * wumaoxing
     * 2020-04-04 13:37
     */
    int addHotgood(HotgoodInfo hotgoodInfo);
    /**
     * 检验热门位商品排序是否重复或商品是否存在
     * wumaoxing
     * 2020-04-04 13:37
     */
    int queryHotgoodSort(HotgoodInfo hotgoodInfo);
    /**
     * 修改热门位商品
     * wumaoxing
     * 2020-04-04 13:37
     */
    int updateHotgoodById(HotgoodInfo hotgoodInfo);
    /**
     * 删除热门位商品
     * wumaoxing
     * 2020-04-04 13:37
     */
    int deleteHotgood(@Param("listDeleteHotgoodsId") List<String> listDeleteHotgoodsId, @Param("updateUserId") String updateUserId);
    /**
     * 热门位商品分页列表
     * wumaoxing
     * 2020-04-04 13:37
     */
    List<HotgoodInfo> listHotgoods(HotgoodInfo hotgoodInfo);
    /**
     * 热门位商品详情
     * wumaoxing
     * 2020-04-22 9:52
     */
    HotgoodInfo findHotgoodById(String hotgoodsId);
    /**
     * 热门位商品展示数量设置
     * wumaoxing
     * 2020-04-04 13:37
     */
    int updateHotgoodNumber(DictionaryInfo dictionaryInfo);
    /**
     * 检验热门位商品是否存在
     * wumaoxing
     * 2020-05-01 20:41
     */
    List<String> queryHotgood(@Param("listDeleteGoodsId") List<String> listDeleteGoodsId);
}
