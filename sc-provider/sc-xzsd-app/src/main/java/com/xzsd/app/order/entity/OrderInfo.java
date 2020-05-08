package com.xzsd.app.order.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xzsd.app.orderDetails.entity.OrderDetailsInfo;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * Order类
 * wumaoxing
 * 2020-03-30 20:57
 */
public class OrderInfo {
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 角色
     */
    private String role;
    /**
     * 订单明细类
     */
    private List<OrderDetailsInfo> orderDetailsInfoList;
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 订单编号
     */
    private String ordersId;
    /**
     * 门店编号
     */
    private String storeId;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 门店地址
     */
    private String storeAddress;
    /**
     * 购买数量
     */
    private String buyNumber;
    /**
     * 订单总价
     */
    private double ordersTotalMoney;
    /**
     * 订单状态 0未到货 1已到货 2未取货 3已取货 4未评价 5已评价 6已取消
     */
    private String ordersState;
    /**
     * 支付状态
     */
    private String ordersPayState;
    /**
     * 下单人编号
     */
    private String customerId;
    /**
     * 下单人编号
     */
    private String customerAccount;
    /**
     * 下单人姓名
     */
    private String customerName;
    /**
     * 下单人手机
     */
    private String customerPhone;
    /**
     * 付款时间起
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date payTimeStart;
    /**
     * 付款时间止
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date payTimeEnd;
    /**
     * 付款时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ordersPayTime;
    /**
     * 删除标记 0未删 1删
     */
    private int isDeleted;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改人
     */
    private String lastModifiedBy;
    /**
     * 修改时间
     */
    private Date gmtModified;
    /**
     * 版本号
     */
    private String version;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(String ordersId) {
        this.ordersId = ordersId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(String buyNumber) {
        this.buyNumber = buyNumber;
    }

    public double getOrdersTotalMoney() {
        return ordersTotalMoney;
    }

    public void setOrdersTotalMoney(double ordersTotalMoney) {
        this.ordersTotalMoney = ordersTotalMoney;
    }

    public String getOrdersState() {
        return ordersState;
    }

    public void setOrdersState(String ordersState) {
        this.ordersState = ordersState;
    }

    public String getOrdersPayState() {
        return ordersPayState;
    }

    public void setOrdersPayState(String ordersPayState) {
        this.ordersPayState = ordersPayState;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(String customerAccount) {
        this.customerAccount = customerAccount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Date getPayTimeStart() {
        return payTimeStart;
    }

    public void setPayTimeStart(Date payTimeStart) {
        this.payTimeStart = payTimeStart;
    }

    public Date getPayTimeEnd() {
        return payTimeEnd;
    }

    public void setPayTimeEnd(Date payTimeEnd) {
        this.payTimeEnd = payTimeEnd;
    }
    @JsonFormat(timezone="GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getOrdersPayTime() {
        return ordersPayTime;
    }

    public void setOrdersPayTime(Date ordersPayTime) {
        this.ordersPayTime = ordersPayTime;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    @JsonFormat(timezone="GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<OrderDetailsInfo> getOrderDetailsInfoList() {
        return orderDetailsInfoList;
    }

    public void setOrderDetailsInfoList(List<OrderDetailsInfo> orderDetailsInfoList) {
        this.orderDetailsInfoList = orderDetailsInfoList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }
}
