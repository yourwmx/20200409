package com.xzsd.app.store.controller;

import com.xzsd.app.store.service.StoreService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
     * 司机列表
     * wumaoxing
     * 2020-04-16 10:41
     */
    @RequestMapping(value = "listDrivers")
    public AppResponse listDrivers(String storeAreaId) {
        try {
            return storeService.listDrivers(storeAreaId);
        } catch (Exception e) {
            logger.error("查询司机列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
