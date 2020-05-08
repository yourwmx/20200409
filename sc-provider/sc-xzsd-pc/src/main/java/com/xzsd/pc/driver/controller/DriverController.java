package com.xzsd.pc.driver.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.service.DriverService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
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
     * 新增司机
     * wumaoxing
     * 2020-04-04 21:33
     */
    @PostMapping("addDriver")
    public AppResponse addDriver(DriverInfo driverInfo){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            driverInfo.setCreateBy(userId);
            AppResponse appResponse = driverService.addDriver(driverInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("司机新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改司机
     * wumaoxing
     * 2020-04-04 21:52
     */
    @PostMapping("updateDriverById")
    public AppResponse updateDriverById(DriverInfo driverInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            driverInfo.setLastModifiedBy(userId);
            return driverService.updateDriverById(driverInfo);
        } catch (Exception e) {
            logger.error("修改司机信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除司机
     * wumaoxing
     * 2020-04-04 22:02
     */
    @PostMapping("deleteDriver")
    public AppResponse deleteDriver(String userId){
        try {
            String updateUserId = SecurityUtils.getCurrentUserId();
            return driverService.deleteDriver(userId, updateUserId);
        } catch (Exception e) {
            logger.error("删除司机信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 司机分页
     * wumaoxing
     * 2020-04-04 22:12
     */
    @RequestMapping(value = "listDrivers")
    public AppResponse listDrivers(DriverInfo driverInfo) {
        try {
            return driverService.listDrivers(driverInfo);
        } catch (Exception e) {
            logger.error("查询司机列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 司机详情
     * wumaoxing
     * 2020-04-04 22:15
     */
    @RequestMapping(value = "findDriverById")
    public AppResponse findDriverById(String driverId){
        try {
            return driverService.findDriverById(driverId);
        } catch (Exception e) {
            logger.error("查询司机详情异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
