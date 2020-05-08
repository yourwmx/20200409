package com.xzsd.app.good.controller;

import com.xzsd.app.good.entity.GoodInfo;
import com.xzsd.app.good.service.GoodService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/good")
public class GoodController {
    private static final Logger logger = LoggerFactory.getLogger(GoodController.class);

    @Resource
    private GoodService goodService;

    /**
     * 商品二级分类及商品列表
     * wumaoxing
     * 2020-03-28 11:27
     */
    @RequestMapping(value = "listGoods")
    public AppResponse listGoods(GoodInfo goodInfo) {
        try {
            return goodService.listGoods(goodInfo);
        } catch (Exception e) {
            logger.error("查询商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品详细
     * wumaoxing
     * 2020-04-13 16:22
     */
    @RequestMapping(value = "findGoodById")
    public AppResponse findGoodById(String goodsId, String storeId) {
        try {
            return goodService.findGoodById(goodsId, storeId);
        } catch (Exception e) {
            logger.error("查询商品详细异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
