package com.xzsd.app.goodClassify.controller;

import com.xzsd.app.goodClassify.dao.GoodClassifyDao;
import com.xzsd.app.goodClassify.service.GoodClassifyService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/goodClassify")
public class GoodClassifyController {
    private static final Logger logger = LoggerFactory.getLogger(GoodClassifyController.class);

    @Resource
    private GoodClassifyService goodClassifyService;

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
}
