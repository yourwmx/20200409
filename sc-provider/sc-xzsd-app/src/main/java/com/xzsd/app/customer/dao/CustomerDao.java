package com.xzsd.app.customer.dao;

import com.xzsd.app.customer.entity.CustomerInfo;

/**
 * CustomerDao
 * wumaoxing
 * 2020-04-13 10:07
 */
public interface CustomerDao {
    /**
     * 客户注册
     * wumaoxing
     * 2020-04-13 10:08
     */
    int addCustomer(CustomerInfo customerInfo);
    /**
     * 修改店铺邀请码
     * wumaoxing
     * 2020-04-13 20:32
     */
    int updateStoreInviteById(CustomerInfo customerInfo);
}
