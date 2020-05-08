package com.xzsd.pc.hotgood.service;

import com.xzsd.pc.dictionary.dao.DictionaryDao;
import com.xzsd.pc.dictionary.entity.DictionaryInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.good.dao.GoodDao;
import com.xzsd.pc.hotgood.dao.HotgoodDao;
import com.xzsd.pc.hotgood.entity.HotgoodInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Hotgood实现类
 * wumaoxing
 * 2020-04-04 12:12
 */
@Service
public class HotgoodService {

    @Resource
    private HotgoodDao hotgoodDao;

    @Resource
    private DictionaryDao dictionaryDao;

    @Resource
    private GoodDao goodDao;

    /**
     * 新增热门位商品
     * wumaoxing
     * 2020-04-04 13:33
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addHotgood(HotgoodInfo hotgoodInfo){
        //检验热门位商品排序是否重复或商品是否存在
        int count = hotgoodDao.queryHotgoodSort(hotgoodInfo);
        if (count != 0) {
            return AppResponse.bizError("热门位商品排序重复或商品已存在，请重试！");
        }
        //检验商品状态是否为在售
        String goodsState = goodDao.findGoodsById(hotgoodInfo.getGoodsId()).getGoodsState();
        if ("1".equals(goodsState) == false) {
            return AppResponse.bizError("商品状态不是在售，请重试！");
        }
        //新增热门位商品
        hotgoodInfo.setHotgoodsId(StringUtil.getCommonCode(2));
        count = hotgoodDao.addHotgood(hotgoodInfo);
        if (count == 0) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 修改热门位商品
     * wumaoxing
     * 2020-04-04 13:33
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateHotgoodById(HotgoodInfo hotgoodInfo){
        //检验热门位商品排序是否重复或商品是否存在(除了自己)
        int count = hotgoodDao.queryHotgoodSort(hotgoodInfo);
        if (count != 0) {
            return AppResponse.bizError("热门位商品排序重复或商品已存在，请重试！");
        }
        //检验商品状态是否为在售
        String goodsState = goodDao.findGoodsById(hotgoodInfo.getGoodsId()).getGoodsState();
        if ("1".equals(goodsState) == false) {
            return AppResponse.bizError("商品状态不是在售，请重试！");
        }
        //修改轮播图
        count = hotgoodDao.updateHotgoodById(hotgoodInfo);
        if (count == 0) {
            return AppResponse.bizError("修改失败，请重试！");
        }
        return AppResponse.success("修改成功！");
    }

    /**
     * 删除热门位商品
     * wumaoxing
     * 2020-04-04 13:33
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteHotgood(String hotgoodsId, String updateUserId) {
        List<String> listDeleteHotgoodsId = Arrays.asList(hotgoodsId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除热门位商品
        int count = hotgoodDao.deleteHotgood(listDeleteHotgoodsId, updateUserId);
        if (count == 0) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 热门位商品分页列表
     * wumaoxing
     * 2020-04-04 13:33
     */
    public AppResponse listHotgoods(HotgoodInfo hotgoodInfo) {
        PageHelper.startPage(hotgoodInfo.getPageNum(), hotgoodInfo.getPageSize());
        List<HotgoodInfo> hotgoodInfoList = hotgoodDao.listHotgoods(hotgoodInfo);
        // 包装Page对象
        PageInfo<HotgoodInfo> pageData = new PageInfo<HotgoodInfo>(hotgoodInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * 热门位商品详情
     * wumaoxing
     * 2020-04-22 9:45
     */
    public AppResponse findHotgoodById(String hotgoodsId) {
        return AppResponse.success("查询成功！",hotgoodDao.findHotgoodById(hotgoodsId));
    }

    /**
     * 查询热门位商品展示数量
     * wumaoxing
     * 2020-04-16 17:22
     */
    public AppResponse queryHotgoodNumber() {
        return AppResponse.success("查询成功！",dictionaryDao.queryVById("HotgoodShowNumber"));
    }

    /**
     * 热门位商品展示数量设置
     * wumaoxing
     * 2020-04-04 13:33
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateHotgoodNumber(DictionaryInfo dictionaryInfo) {
        AppResponse appResponse = AppResponse.success("热门位商品展示数量设置成功！");
        // 热门位商品展示数量设置
        int count = hotgoodDao.updateHotgoodNumber(dictionaryInfo);
        if (count == 0) {
            appResponse = AppResponse.bizError("热门位商品展示数量设置失败，请重试！");
        }
        return appResponse;
    }
}
