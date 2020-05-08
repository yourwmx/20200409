package com.xzsd.app.order.dao;

import com.xzsd.app.order.entity.OrderInfo;
import com.xzsd.app.orderDetails.entity.OrderDetailsInfo;
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
    OrderInfo findOrderById(String orderId);
    /**
     * 订单状态修改
     * wumaoxing
     * 2020-04-04 11:39
     */
    int updateOrderState(OrderInfo orderInfo);
    /**
     * 修改订单状态为已评价
     * wumaoxing
     * 2020-04-14 10:32
     */
    int updateOrderStateToFinishComment(@Param("ordersId") String ordersId, @Param("ordersState") String ordersState);
    /**
     * 新增订单
     * wumaoxing
     * 2020-04-14 21:19
     */
    int addOrder(OrderInfo orderInfo);
}
