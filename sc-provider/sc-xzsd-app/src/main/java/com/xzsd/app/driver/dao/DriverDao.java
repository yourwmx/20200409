package com.xzsd.app.driver.dao;

import com.xzsd.app.driver.entity.DriverInfo;
import com.xzsd.app.store.entity.StoreInfo;

import java.util.List;

/**
 * DriverDao
 * wumaoxing
 * 2020-04-05 14:36
 */
public interface DriverDao {
    List<DriverInfo> listDrivers(String storeAreaId);
    /**
     * 司机详情
     * wumaoxing
     * 2020-04-05 21:49
     */
    DriverInfo findDriverById(String userId);
    /**
     * 查询门店
     * wumaoxing
     * 2020-04-17 16:43
     */
    List<StoreInfo> findStoreById(String driverAreaId);
}
