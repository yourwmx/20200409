package com.xzsd.pc.driver.dao;

import com.xzsd.pc.driver.entity.DriverInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * DriverDao
 * wumaoxing
 * 2020-04-05 14:36
 */
public interface DriverDao {
    /**
     * 新增司机
     * wumaoxing
     * 2020-04-05 21:49
     */
    int addDriver(DriverInfo driverInfo);
    /**
     * 修改司机
     * wumaoxing
     * 2020-04-05 21:49
     */
    int updateDriverById(DriverInfo driverInfo);
    /**
     * 删除司机
     * wumaoxing
     * 2020-04-05 21:49
     */
    int deleteDriver(@Param("listDeleteUserId") List<String> listDeleteUserId, @Param("updateUserId") String updateUserId);
    /**
     * 司机列表
     * wumaoxing
     * 2020-04-05 21:49
     */
    List<DriverInfo> listDrivers(DriverInfo driverInfo);
    /**
     * 司机详情
     * wumaoxing
     * 2020-04-05 21:49
     */
    DriverInfo findDriverById(String driverId);
}
