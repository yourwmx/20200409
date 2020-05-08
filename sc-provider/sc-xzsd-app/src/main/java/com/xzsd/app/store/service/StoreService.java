package com.xzsd.app.store.service;

import com.xzsd.app.driver.dao.DriverDao;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * Store实现类
 * wumaoxing
 * 2020-04-04 21:36
 */
@Service
public class StoreService {

    @Resource
    private DriverDao driverDao;

    /**
     * 司机列表
     * wumaoxing
     * 2020-04-16 10:42
     */
    public AppResponse listDrivers(String storeAreaId) {
        return AppResponse.success("查询成功！",driverDao.listDrivers(storeAreaId));
    }
}
