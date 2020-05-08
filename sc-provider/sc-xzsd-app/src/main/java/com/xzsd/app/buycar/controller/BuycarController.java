package com.xzsd.app.buycar.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.buycar.entity.BuycarInfo;
import com.xzsd.app.buycar.service.BuycarService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/buycar")
public class BuycarController {
    private static final Logger logger = LoggerFactory.getLogger(BuycarController.class);

    @Resource
    private BuycarService buycarService;
    /**
     * 新增购物车
     * wumaoxing
     * 2020-04-14 11:04
     */
    @PostMapping(value = "addBuycar")
    public AppResponse addBuycar(BuycarInfo buycarInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            buycarInfo.setCreateBy(userId);
            return buycarService.addBuycar(buycarInfo);
        } catch (Exception e) {
            logger.error("新增购物车异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询购物车分页列表
     * wumaoxing
     * 2020-04-14 14:11
     */
    @RequestMapping("listBuycars")
    public AppResponse listBuycars(BuycarInfo buycarInfo){
        try {
            return buycarService.listBuycars(buycarInfo);
        } catch (Exception e) {
            logger.error("查询购物车异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改购物车
     * wumaoxing
     * 2020-04-14 14:43
     */
    @PostMapping(value = "updateBuycarById")
    public AppResponse updateBuycarById(BuycarInfo buycarInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            buycarInfo.setLastModifiedBy(userId);
            return buycarService.updateBuycarById(buycarInfo);
        } catch (Exception e) {
            logger.error("修改购物车异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除购物车
     * wumaoxing
     * 2020-04-14 14:43
     */
    @PostMapping(value = "deleteBuycar")
    public AppResponse deleteBuycar(String buycarId) {
        try {
            String updateUserId = SecurityUtils.getCurrentUserId();
            return buycarService.deleteBuycar(buycarId,updateUserId);
        } catch (Exception e) {
            logger.error("删除购物车异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    
}
