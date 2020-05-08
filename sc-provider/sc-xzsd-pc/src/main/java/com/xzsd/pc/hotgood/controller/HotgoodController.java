package com.xzsd.pc.hotgood.controller;

import com.xzsd.pc.dictionary.entity.DictionaryInfo;
import com.xzsd.pc.hotgood.entity.HotgoodInfo;
import com.xzsd.pc.hotgood.service.HotgoodService;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 增删查改Hotgood
 * wumaoxing
 * 2020-04-04 12:10
 */
@RestController
@RequestMapping("/hotgood")
public class HotgoodController {

    private static final Logger logger = LoggerFactory.getLogger(HotgoodController.class);

    @Resource
    private HotgoodService hotgoodService;

    /**
     * 新增热门位商品
     * wumaoxing
     * 2020-04-04 12:18
     */
    @PostMapping("addHotgood")
    public AppResponse addHotgood(HotgoodInfo hotGoodInfo){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            hotGoodInfo.setCreateBy(userId);
            AppResponse appResponse = hotgoodService.addHotgood(hotGoodInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("热门位商品新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改热门位商品
     * wumaoxing
     * 2020-03-28 15:32
     */
    @PostMapping("updateHotgoodById")
    public AppResponse updateHotgoodById(HotgoodInfo hotGoodInfo){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            hotGoodInfo.setLastModifiedBy(userId);
            AppResponse appResponse = hotgoodService.updateHotgoodById(hotGoodInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("热门位商品修改失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除热门位商品
     * wumaoxing
     * 2020-03-29 20:45
     */
    @PostMapping("deleteHotgood")
    public AppResponse deleteHotgood(String hotgoodsId) {
        try {
            String updateUserId = SecurityUtils.getCurrentUserId();
            return hotgoodService.deleteHotgood(hotgoodsId, updateUserId);
        } catch (Exception e) {
            logger.error("删除热门位商品信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 热门位商品分页列表
     * wumaoxing
     * 2020-03-29 21:22
     */
    @RequestMapping(value = "listHotgoods")
    public AppResponse listHotgoods(HotgoodInfo hotGoodInfo) {
        try {
            return hotgoodService.listHotgoods(hotGoodInfo);
        } catch (Exception e) {
            logger.error("查询热门位商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 热门位商品详情
     * wumaoxing
     * 2020-04-22 9:43
     */
    @RequestMapping(value = "findHotgoodById")
    public AppResponse findHotgoodById(String hotgoodsId) {
        try {
            return hotgoodService.findHotgoodById(hotgoodsId);
        } catch (Exception e) {
            logger.error("查询热门位商品详情异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询热门位商品展示数量
     * wumaoxing
     * 2020-04-16 17:19
     */
    @RequestMapping(value = "queryHotgoodNumber")
    public AppResponse queryHotgoodNumber() {
        try {
            return hotgoodService.queryHotgoodNumber();
        } catch (Exception e) {
            logger.error("查询热门位商品展示数量异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 热门位商品展示数量设置
     * wumaoxing
     * 2020-03-29 20:45
     */
    @PostMapping("updateHotgoodNumber")
    public AppResponse updateHotgoodNumber(DictionaryInfo dictionaryInfo) {
        try {
            return hotgoodService.updateHotgoodNumber(dictionaryInfo);
        } catch (Exception e) {
            logger.error("热门位商品展示数量设置错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }


}
