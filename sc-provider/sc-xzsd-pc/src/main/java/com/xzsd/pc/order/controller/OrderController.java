package com.xzsd.pc.order.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.service.OrderService;
import com.xzsd.pc.orderDetails.entity.OrderDetailsInfo;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 改查Order
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private OrderService orderService;

    /**
     * 订单分页列表
     * wumaoxing
     * 2020-04-02 16:52
     */
    @RequestMapping(value = "listOrders")
    public AppResponse listOrders(OrderInfo orderInfo) {
        try {
            return orderService.listOrders(orderInfo);
        } catch (Exception e) {
            logger.error("查询订单列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 订单详情
     * wumaoxing
     * 2020-04-03 21:12
     */
    @RequestMapping(value = "findOrderById")
    public AppResponse findOrderById(OrderDetailsInfo orderDetailsInfo){
        try {
            return orderService.findOrderById(orderDetailsInfo);
        } catch (Exception e) {
            logger.error("查询订单详情异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 订单状态修改接口
     * wumaoxing
     * 2020-04-04 11:27
     */
    @PostMapping("updateOrderState")
    public AppResponse updateOrderState(String ordersId, String ordersState) {
        try {
            String updateUserId = SecurityUtils.getCurrentUserId();
            return orderService.updateOrderState(ordersId, updateUserId, ordersState);
        } catch (Exception e) {
            logger.error("订单状态修改错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
