package com.xzsd.pc.goodClassify.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goodClassify.entity.GoodClassifyInfo;
import com.xzsd.pc.goodClassify.service.GoodClassifyService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 增删改查GoodClassify
 * wumaoxing
 * 2020-03-26 14:59
 */
@RestController
@RequestMapping("/goodClassify")
public class GoodClassifyController {

    private static final Logger logger = LoggerFactory.getLogger(GoodClassifyController.class);

    @Resource
    private GoodClassifyService goodClassifyService;

    /**
     * 新增商品分类
     * wumaoxing
     * 2020-03-26 15:04
     */
    @PostMapping("addGoodClassify")
    public AppResponse addGoodClassify(GoodClassifyInfo goodClassifyInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            goodClassifyInfo.setCreateBy(userId);
            AppResponse appResponse = goodClassifyService.addGoodClassify(goodClassifyInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("商品分类新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品分类
     * wumaoxing
     * 2020-03-26 16:15
     */
    @PostMapping("updateGoodClassifyById")
    public AppResponse updateGoodClassifyById(GoodClassifyInfo goodClassifyInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            goodClassifyInfo.setLastModifiedBy(userId);
            return goodClassifyService.updateGoodClassifyById(goodClassifyInfo);
        } catch (Exception e) {
            logger.error("修改商品分类信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除商品分类
     * wumaoxing
     * 2020-03-26 16:15
     */
    @PostMapping("deleteGoodClassifyById")
    public AppResponse deleteGoodClassifyById(String classifyId) {
        try {
            String updateUserId = SecurityUtils.getCurrentUserId();
            return goodClassifyService.deleteGoodClassifyById(classifyId, updateUserId);
        } catch (Exception e) {
            logger.error("删除商品分类信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品分类
     * wumaoxing
     * 2020-03-27 10:28
     */
    @RequestMapping(value = "queryGoodClassify")
    public AppResponse queryGoodClassify() {
        try {
            return goodClassifyService.queryGoodClassify();
        } catch (Exception e) {
            logger.error("查询商品分类异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品分类详情
     * wumaoxing
     * 2020-03-27 14:30
     */
    @RequestMapping(value = "findGoodClassifyById")
    public AppResponse findGoodClassifyById(String classifyId) {
        try {
            return goodClassifyService.findGoodClassifyById(classifyId);
        } catch (Exception e) {
            logger.error("商品分类查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
