package com.xzsd.pc.order.dao;

import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.orderDetails.entity.OrderDetailsInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * OrderDao
 * wumaoxing
 * 2020-04-02 16:59
 */
public interface OrderDao {
    /**
     * 订单分页列表
     * wumaoxing
     * 2020-04-02 17:00
     */
    List<OrderInfo> listOrders(OrderInfo orderInfo);
    /**
     * 订单详情
     * wumaoxing
     * 2020-04-03 21:19
     */
    List<OrderDetailsInfo> findOrderById(String orderId);
    /**
     * 订单状态修改
     * wumaoxing
     * 2020-04-04 11:39
     */
    int updateOrderState(@Param("listUpdateOrdersId") List<String> listUpdateOrdersId, @Param("updateUserId") String updateUserId, @Param("ordersState") String ordersState);

}
