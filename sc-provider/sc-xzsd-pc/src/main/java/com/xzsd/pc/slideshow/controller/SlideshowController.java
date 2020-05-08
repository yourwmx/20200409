package com.xzsd.pc.slideshow.controller;

import com.xzsd.pc.good.entity.GoodInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.slideshow.entity.SlideshowInfo;
import com.xzsd.pc.slideshow.service.SlideshowService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 增删改查Slideshow
 * wumaoxing
 * 2020-03-28 14:00
 */
@RestController
@RequestMapping("/slideshow")
public class SlideshowController {

    private static final Logger logger = LoggerFactory.getLogger(SlideshowController.class);

    @Resource
    private SlideshowService slideshowService;

    /**
     * 新增轮播图
     * wumaoxing
     * 2020-03-28 14:06
     */
    @PostMapping("addSlideshow")
    public AppResponse addSlideshow(SlideshowInfo slideshowInfo){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            slideshowInfo.setCreateBy(userId);
            AppResponse appResponse = slideshowService.addSlideshow(slideshowInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("轮播图新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改轮播图
     * wumaoxing
     * 2020-03-28 15:32
     */
    @PostMapping("updateSlideshowById")
    public AppResponse updateSlideshowById(SlideshowInfo slideshowInfo){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            slideshowInfo.setLastModifiedBy(userId);
            AppResponse appResponse = slideshowService.updateSlideshowById(slideshowInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("轮播图修改失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除轮播图
     * wumaoxing
     * 2020-03-29 20:45
     */
    @PostMapping("deleteSlideshow")
    public AppResponse deleteSlideshow(String slideshowsId) {
        try {
            String  updateUserId= SecurityUtils.getCurrentUserId();
            return slideshowService.deleteSlideshow(slideshowsId, updateUserId);
        } catch (Exception e) {
            logger.error("删除轮播图信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 轮播图启用禁用
     * wumaoxing
     * 2020-03-29 20:45
     */
    @PostMapping("updateSlideshowState")
    public AppResponse updateSlideshowState(String slideshowsId, String slideshowsState) {
        try {
            String updateUserId= SecurityUtils.getCurrentUserId();
            return slideshowService.updateSlideshowState(slideshowsId, updateUserId, slideshowsState);
        } catch (Exception e) {
            logger.error("轮播图启用或禁用错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 轮播图分页列表
     * wumaoxing
     * 2020-03-29 21:22
     */
    @RequestMapping(value = "listSlideshows")
    public AppResponse listGoods(SlideshowInfo slideshowInfo) {
        try {
            return slideshowService.listSlideshows(slideshowInfo);
        } catch (Exception e) {
            logger.error("查询轮播图列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 轮播图详情
     * wumaoxing
     * 2020-04-22 9:56
     */
    @RequestMapping(value = "findSlideshowById")
    public AppResponse findSlideshowById(String slideshowsId) {
        try {
            return slideshowService.findSlideshowById(slideshowsId);
        } catch (Exception e) {
            logger.error("查询轮播图详情异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 商品分页列表
     * wumaoxing
     * 2020-03-29 22:0
     */
    @RequestMapping(value = "listGoods")
    public AppResponse listGoods(GoodInfo goodInfo) {
        try {
            return slideshowService.listGoods(goodInfo);
        } catch (Exception e) {
            logger.error("查询商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
