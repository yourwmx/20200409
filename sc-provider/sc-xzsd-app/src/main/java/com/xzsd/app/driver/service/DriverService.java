package com.xzsd.app.driver.service;

import com.xzsd.app.driver.dao.DriverDao;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DriverService {

    @Resource
    private DriverDao driverDao;

    /**
     * 查询门店
     * wumaoxing
     * 2020-04-17 16:40
     */
    public AppResponse findStoreById(String driverAreaId){
        return AppResponse.success("查询成功！",driverDao.findStoreById(driverAreaId));
    }
}
