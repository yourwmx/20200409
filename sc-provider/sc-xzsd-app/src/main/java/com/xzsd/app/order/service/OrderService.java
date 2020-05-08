package com.xzsd.app.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.app.buycar.dao.BuycarDao;
import com.xzsd.app.good.dao.GoodDao;
import com.xzsd.app.good.entity.GoodInfo;
import com.xzsd.app.order.dao.OrderDao;
import com.xzsd.app.order.entity.OrderInfo;
import com.xzsd.app.orderDetails.dao.OrderDetailsDao;
import com.xzsd.app.orderDetails.entity.OrderDetailsInfo;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private OrderDetailsDao orderDetailsDao;

    @Resource
    private BuycarDao buycarDao;

    @Resource
    private GoodDao goodDao;

    /**
     * 新增订单
     * wumaoxing
     * 2020-04-14 20:25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addOrder(OrderInfo orderInfo){
        orderInfo.setOrdersId(StringUtil.getCommonCode(2));
        double ordersTotalMoney = 0;
        int count,buyNumber = 0,flag = 0;
        //购物车列表
        List<String> list = new ArrayList<>();
        //商品库存信息列表
        List<String> goodsRestNumberList = new ArrayList<>();
        //商品购买数量列表
        List<String> buyNumberList = new ArrayList<>();
        //订单明细列表
        List<OrderDetailsInfo> orderDetailsInfoList = new ArrayList<>();
        for(OrderDetailsInfo item: orderInfo.getOrderDetailsInfoList()) {
            //从购物车结算，则删除购物车
            if (item.getBuycarId() != null) {
                flag = 1;
                list.add(item.getBuycarId());
            }
            //初始化
            goodsRestNumberList.add(item.getGoodsId());
            buyNumberList.add(item.getBuyNumber());
            item.setOrderDetailsId(StringUtil.getCommonCode(2));
            item.setOrdersId(orderInfo.getOrdersId());
            item.setCreateBy(orderInfo.getCreateBy());
            item.setTotalMoney(Double.parseDouble(item.getBuyNumber())*item.getGoodsSaleMoney());
            orderDetailsInfoList.add(item);
            buyNumber += Integer.parseInt(item.getBuyNumber());
            ordersTotalMoney += item.getTotalMoney();
        }
        //从购物车结算，则删除购物车
        if(flag == 1){
            count = buycarDao.deleteBuycar(list, orderInfo.getCreateBy());
            if (count == 0) {
                return AppResponse.bizError("删除购物车失败，请重试！");
            }
        }
        //查询商品库存
        List<GoodInfo> originalGoodsInfo = goodDao.queryGoodsRestNumber(goodsRestNumberList);
        //判断库存是否小于购买数量
        for(int i = 0;i < buyNumberList.size(); i++){
            String goodsRestNumber = originalGoodsInfo.get(i).getGoodsRestNumber();
            if(Integer.parseInt(goodsRestNumber) < Integer.parseInt(buyNumberList.get(i))){
                return AppResponse.bizError("商品库存不足，请重试！");
            }
            originalGoodsInfo.get(i).setLastModifiedBy(orderInfo.getCreateBy());
            originalGoodsInfo.get(i).setGoodsRestNumber((Integer.parseInt(goodsRestNumber)-Integer.parseInt(buyNumberList.get(i))+""));
        }
        //修改商品库存
        count = goodDao.updateGoodsRestNumber(originalGoodsInfo);
        if (count == 0) {
            return AppResponse.bizError("修改商品库存失败，请重试！");
        }
        //新增订单
        count = orderDetailsDao.addOrderDetails(orderDetailsInfoList);
        if (count == 0) {
            return AppResponse.bizError("新增订单明细失败，请重试！");
        }
        orderInfo.setBuyNumber(buyNumber + "");
        orderInfo.setOrdersTotalMoney(ordersTotalMoney);
        count = orderDao.addOrder(orderInfo);
        if (count == 0) {
            return AppResponse.bizError("新增订单失败，请重试！");
        }
        return AppResponse.success("新增订单成功！");
    }

    /**
     * 订单分页列表
     * wumaoxing
     * 2020-04-14 22:00
     */
    public AppResponse listOrders(OrderInfo orderInfo){
        PageHelper.startPage(orderInfo.getPageNum(), orderInfo.getPageSize());
        List<OrderInfo> orderInfoList = orderDao.listOrders(orderInfo);
        // 包装Page对象
        PageInfo<OrderInfo> pageData = new PageInfo<OrderInfo>(orderInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * 订单详情
     * wumaoxing
     * 2020-04-15 17:15
     */
    public AppResponse findOrderById(String ordersId){
        return AppResponse.success("查询成功！",orderDao.findOrderById(ordersId));
    }

    /**
     * 订单状态修改
     * wumaoxing
     * 2020-04-15 20:42
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderState(OrderInfo orderInfo){
        int count;
        //若确认收货则添加商品销量
        if("3".equals(orderInfo.getOrdersState())){
            //查询原订单
            OrderInfo originalOrderInfo = orderDao.findOrderById(orderInfo.getOrdersId());
            //商品销量列表
            List<String> goodsSaleNumberList = new ArrayList<>();
            //商品购买数量列表
            List<String> buyNumberList = new ArrayList<>();
            for(OrderDetailsInfo item: originalOrderInfo.getOrderDetailsInfoList()){
                goodsSaleNumberList.add(item.getGoodsId());
                buyNumberList.add(item.getBuyNumber());
            }
            //查询商品销量
            List<GoodInfo> originalGoodsInfo = goodDao.queryGoodsRestNumber(goodsSaleNumberList);
            for(int i = 0;i < buyNumberList.size(); i++){
                String goodsSaleNumber = originalGoodsInfo.get(i).getGoodsSaleNumber();
                originalGoodsInfo.get(i).setLastModifiedBy(orderInfo.getLastModifiedBy());
                originalGoodsInfo.get(i).setGoodsSaleNumber((Integer.parseInt(goodsSaleNumber)+Integer.parseInt(buyNumberList.get(i))+""));
            }
            //添加商品销量
            count = goodDao.updateGoodsSaleNumber(originalGoodsInfo);
            if (count == 0) {
                return AppResponse.bizError("修改商品销量失败，请重试！");
            }
        }
        //若取消订单则库存回退
        if("6".equals(orderInfo.getOrdersState())){
            //查询原订单
            OrderInfo originalOrderInfo = orderDao.findOrderById(orderInfo.getOrdersId());
            //商品库存列表
            List<String> goodsRestNumberList = new ArrayList<>();
            //商品购买数量列表
            List<String> buyNumberList = new ArrayList<>();
            for(OrderDetailsInfo item: originalOrderInfo.getOrderDetailsInfoList()){
                goodsRestNumberList.add(item.getGoodsId());
                buyNumberList.add(item.getBuyNumber());
            }
            //查询商品库存与销量
            List<GoodInfo> originalGoodsInfo = goodDao.queryGoodsRestNumber(goodsRestNumberList);
            for(int i = 0;i < buyNumberList.size(); i++){
                String goodsRestNumber = originalGoodsInfo.get(i).getGoodsRestNumber();
                originalGoodsInfo.get(i).setLastModifiedBy(orderInfo.getLastModifiedBy());
                originalGoodsInfo.get(i).setGoodsRestNumber((Integer.parseInt(goodsRestNumber)+Integer.parseInt(buyNumberList.get(i))+""));
            }
            //商品库存回退
            count = goodDao.updateGoodsRestNumber(originalGoodsInfo);
            if (count == 0) {
                return AppResponse.bizError("修改商品库存失败，请重试！");
            }
        }
        //订单状态修改
        count = orderDao.updateOrderState(orderInfo);
        if(count == 0){
            return AppResponse.bizError("订单状态修改失败，请重试！");
        }
        return AppResponse.success("修改成功！");
    }
}
