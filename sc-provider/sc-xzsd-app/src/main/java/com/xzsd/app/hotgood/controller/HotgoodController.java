package com.xzsd.app.hotgood.controller;

import com.xzsd.app.hotgood.service.HotgoodService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/hotgood")
public class HotgoodController {
    private static final Logger logger = LoggerFactory.getLogger(HotgoodController.class);

    @Resource
    private HotgoodService hotgoodService;

    /**
     * 查询热门位商品
     * wumaoxing
     * 2020-04-13 14:41
     */
    @RequestMapping(value = "listHotgoods")
    public AppResponse listHotgoods() {
        try {
            return hotgoodService.listHotgoods();
        } catch (Exception e) {
            logger.error("查询热门位商品异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
