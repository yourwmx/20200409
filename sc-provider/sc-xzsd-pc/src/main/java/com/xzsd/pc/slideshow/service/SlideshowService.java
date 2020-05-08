package com.xzsd.pc.slideshow.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.good.dao.GoodDao;
import com.xzsd.pc.good.entity.GoodInfo;
import com.xzsd.pc.slideshow.dao.SlideshowDao;
import com.xzsd.pc.slideshow.entity.SlideshowInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 轮播图实现类
 * wumaoxing
 * 2020-03-28 14:47
 */
@Service
public class SlideshowService {

    @Resource
    private SlideshowDao slideshowDao;

    @Resource
    private GoodDao goodDao;

    /**
     * 新增轮播图
     * wumaoxing
     * 2020-03-28 14:54
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addSlideshow(SlideshowInfo slideshowInfo){
        slideshowInfo.setSlideshowsId(StringUtil.getCommonCode(2));
        //检验轮播图排序是否重复或商品是否存在
        int count = slideshowDao.querySlideshowSort(slideshowInfo);
        if (count != 0) {
            return AppResponse.bizError("轮播图排序重复或商品已存在，请重试！");
        }
        //检验商品状态是否为在售
        String goodsState = goodDao.findGoodsById(slideshowInfo.getGoodsId()).getGoodsState();
        if ("1".equals(goodsState) == false) {
            return AppResponse.bizError("商品状态不是在售，请重试！");
        }
        //新增轮播图
        count = slideshowDao.addSlideshow(slideshowInfo);
        if (count == 0) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 修改轮播图
     * wumaoxing
     * 2020-03-28 15:35
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateSlideshowById(SlideshowInfo slideshowInfo){
        //检验轮播图排序是否重复或商品是否存在(除了自己)
        int count = slideshowDao.querySlideshowSort(slideshowInfo);
        if (count != 0) {
            return AppResponse.bizError("轮播图排序重复或商品是否存在，请重试！");
        }
        //检验商品状态是否为在售
        String goodsState = goodDao.findGoodsById(slideshowInfo.getGoodsId()).getGoodsState();
        if ("1".equals(goodsState) == false) {
            return AppResponse.bizError("商品状态不是在售，请重试！");
        }
        //修改轮播图
        count = slideshowDao.updateSlideshowById(slideshowInfo);
        if (count == 0) {
            return AppResponse.bizError("修改失败，请重试！");
        }
        return AppResponse.success("修改成功！");
    }

    /**
     * 删除轮播图
     * wumaoxing
     * 2020-03-29 20:52
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteSlideshow(String slideshowsId, String updateUserId) {
        List<String> listDeleteSlideshowsId = Arrays.asList(slideshowsId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除轮播图
        int count = slideshowDao.deleteSlideshow(listDeleteSlideshowsId, updateUserId);
        if (count == 0) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 轮播图启用禁用
     * wumaoxing
     * 2020-03-29 20:52
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateSlideshowState(String slideshowsId, String updateUserId, String slideshowsState) {
        List<String> listUpdateSlideshowsId = Arrays.asList(slideshowsId.split(","));
        AppResponse appResponse = AppResponse.success("轮播图启用或禁用成功！");
        // 轮播图启用或禁用
        int count = slideshowDao.updateSlideshowState(listUpdateSlideshowsId, updateUserId, slideshowsState);
        if (count == 0) {
            appResponse = AppResponse.bizError("轮播图启用或禁用错误，请重试！");
        }
        return appResponse;
    }

    /**
     * 轮播图分页列表
     * wumaoxing
     * 2020-03-29 21:24
     */
    public AppResponse listSlideshows(SlideshowInfo slideshowInfo) {
        PageHelper.startPage(slideshowInfo.getPageNum(), slideshowInfo.getPageSize());
        List<SlideshowInfo> slideshowInfoList = slideshowDao.listSlideshows(slideshowInfo);
        // 包装Page对象
        PageInfo<SlideshowInfo> pageData = new PageInfo<SlideshowInfo>(slideshowInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * 轮播图详情
     * wumaoxing
     * 2020-04-22 9:58
     */
    public AppResponse findSlideshowById(String slideshowsId) {
        return AppResponse.success("查询成功！",slideshowDao.findSlideshowById(slideshowsId));
    }

    /**
     * 商品分页列表
     * wumaoxing
     * 2020-03-28 11:29
     */
    public AppResponse listGoods(GoodInfo goodInfo) {
        PageHelper.startPage(goodInfo.getPageNum(), goodInfo.getPageSize());
        List<GoodInfo> goodInfoList = slideshowDao.listGoods(goodInfo);
        // 包装Page对象
        PageInfo<GoodInfo> pageData = new PageInfo<GoodInfo>(goodInfoList);
        return AppResponse.success("查询成功！",pageData);
    }
}
