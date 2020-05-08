package com.xzsd.pc.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.orderDetails.entity.OrderDetailsInfo;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 订单实现类
 * wumaoxing
 * 2020-04-02 16:53
 */
@Service
public class OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private UserDao userDao;
    /**
     * 订单分页列表
     * wumaoxing
     * 2020-03-28 11:29
     */
    public AppResponse listOrders(OrderInfo orderInfo) {
        //当前角色为管理员（0）还是店长（3）需判断
        String userId = SecurityUtils.getCurrentUserId();
        orderInfo.setUserId(userId);
        String role = userDao.getCurrentRole(userId);
        orderInfo.setRole(role);
        PageInfo<OrderInfo> pageData = null;
        //判断日期的起止是否合法
        if(orderInfo.getPayTimeStart() != null && orderInfo.getPayTimeEnd() != null){
            if(orderInfo.getPayTimeStart().compareTo(orderInfo.getPayTimeEnd()) > 0){
                return AppResponse.bizError("日期起止不合法！");
            }
        }
        PageHelper.startPage(orderInfo.getPageNum(), orderInfo.getPageSize());
        List<OrderInfo> orderInfoList = orderDao.listOrders(orderInfo);
        // 包装Page对象
        pageData = new PageInfo<OrderInfo>(orderInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * 订单详情
     * wumaoxing
     * 2020-04-03 21:12
     */
    public AppResponse findOrderById(OrderDetailsInfo orderDetailsInfo){
        return AppResponse.success("查询成功！", orderDao.findOrderById(orderDetailsInfo.getOrdersId()));
    }

    /**
     * 订单状态修改接口
     * wumaoxing
     * 2020-04-04 11:36
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderState(String ordersId, String updateUserId, String ordersState) {
        List<String> listUpdateOrdersId = Arrays.asList(ordersId.split(","));
        AppResponse appResponse = AppResponse.success("订单状态修改成功！");
        // 订单状态修改
        int count = orderDao.updateOrderState(listUpdateOrdersId, updateUserId, ordersState);
        if (count == 0) {
            appResponse = AppResponse.bizError("订单状态修改失败，请重试！");
        }
        return appResponse;
    }
}
