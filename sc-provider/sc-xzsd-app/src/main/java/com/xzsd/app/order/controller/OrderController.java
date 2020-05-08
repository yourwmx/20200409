package com.xzsd.app.order.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.order.entity.OrderInfo;
import com.xzsd.app.order.service.OrderService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private OrderService orderService;

    /**
     * 新增订单
     * wumaoxing
     * 2020-04-14 19:58
     */
    @PostMapping(value = "addOrder")
    public AppResponse addOrder(@RequestBody OrderInfo orderInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            orderInfo.setCreateBy(userId);
            return orderService.addOrder(orderInfo);
        } catch (Exception e) {
            logger.error("新增订单异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 订单分页列表
     * wumaoxing
     * 2020-04-14 21:57
     */
    @RequestMapping("listOrders")
    public AppResponse listOrders(OrderInfo orderInfo){
        try {
            return orderService.listOrders(orderInfo);
        } catch (Exception e) {
            logger.error("查询订单分页列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 订单详情
     * wumaoxing
     * 2020-04-14 17:11
     */
    @RequestMapping("findOrderById")
    public AppResponse findOrderById(String ordersId){
        try {
            return orderService.findOrderById(ordersId);
        } catch (Exception e) {
            logger.error("查询订单详情异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 订单状态修改
     * wumaoxing
     * 2020-04-15 20:37
     */
    @PostMapping(value = "updateOrderState")
    public AppResponse updateOrderState(OrderInfo orderInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            orderInfo.setLastModifiedBy(userId);
            return orderService.updateOrderState(orderInfo);
        } catch (Exception e) {
            logger.error("订单状态修改异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
