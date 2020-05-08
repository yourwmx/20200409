package com.xzsd.pc.store.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.service.StoreService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/store")
public class StoreController {

    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);

    @Resource
    private StoreService storeService;

    /**
     * 新增门店
     * wumaoxing
     * 2020-04-05 14:29
     */
    @PostMapping("addStore")
    public AppResponse addStore(StoreInfo storeInfo){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            storeInfo.setCreateBy(userId);
            AppResponse appResponse = storeService.addStore(storeInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("门店新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改门店
     * wumaoxing
     * 2020-04-05 14:29
     */
    @PostMapping("updateStoreById")
    public AppResponse updateStoreById(StoreInfo storeInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            storeInfo.setLastModifiedBy(userId);
            return storeService.updateStoreById(storeInfo);
        } catch (Exception e) {
            logger.error("修改门店信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除门店
     * wumaoxing
     * 2020-04-05 14:29
     */
    @PostMapping("deleteStore")
    public AppResponse deleteStore(String storeId){
        try {
            String updateUserId = SecurityUtils.getCurrentUserId();
            return storeService.deleteStore(storeId, updateUserId);
        } catch (Exception e) {
            logger.error("删除门店信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 门店分页
     * wumaoxing
     * 2020-04-05 14:29
     */
    @RequestMapping(value = "listStores")
    public AppResponse listStores(StoreInfo storeInfo) {
        try {
            return storeService.listStores(storeInfo);
        } catch (Exception e) {
            logger.error("查询门店列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 门店详情
     * wumaoxing
     * 2020-04-04 22:15
     */
    @RequestMapping(value = "findStoreById")
    public AppResponse findStoreById(String storeId){
        try {
            return storeService.findStoreById(storeId);
        } catch (Exception e) {
            logger.error("查询门店详情异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 门店所在位置分类
     * wumaoxing
     * 2020-04-05 13:40
     */
    @RequestMapping("queryStoreLocalClassify")
    public AppResponse queryStoreLocalClassify(String lastClassifyId){
        try {
            return storeService.queryStoreLocalClassify(lastClassifyId);
        } catch (Exception e) {
            logger.error("查询门店所在位置分类异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
