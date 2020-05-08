package com.xzsd.app.driver.controller;

import com.xzsd.app.driver.service.DriverService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/driver")
public class DriverController {

    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);

    @Resource
    private DriverService driverService;

    /**
     * 查询门店
     * wumaoxing
     * 2020-04-17 16:39
     */
    @RequestMapping(value = "findStoreById")
    public AppResponse findStoreById(String driverAreaId) {
        try {
            return driverService.findStoreById(driverAreaId);
        } catch (Exception e) {
            logger.error("查询店长个人信息异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
