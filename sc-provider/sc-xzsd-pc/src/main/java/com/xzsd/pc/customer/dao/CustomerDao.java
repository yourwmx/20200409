package com.xzsd.pc.customer.dao;

import com.xzsd.pc.customer.entity.CustomerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * CustomerDao
 * wumaoxing
 * 2020-03-30 9:52
 */
@Mapper
public interface CustomerDao {
    /**
     * 客户分页列表
     * wumaoxing
     * 2020-03-30 9:53
     */
    List<CustomerInfo> listCustomers(CustomerInfo customerInfo);
}
