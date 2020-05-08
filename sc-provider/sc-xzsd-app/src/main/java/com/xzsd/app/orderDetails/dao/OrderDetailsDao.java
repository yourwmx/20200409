package com.xzsd.app.orderDetails.dao;

import com.xzsd.app.orderDetails.entity.OrderDetailsInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * OrderDetailsDao
 * wumaoxing
 * 2020-04-14 20:59
 */
public interface OrderDetailsDao {
    /**
     * 新增订单明细
     * @return
     */
    int addOrderDetails(@Param("orderDetailsInfoList") List<OrderDetailsInfo> orderDetailsInfoList);
}
