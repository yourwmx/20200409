package com.xzsd.app.orderDetails.entity;

import java.util.Date;

/**
 * 订单明细类
 * wumaoxing
 * 2020-04-10 12:51
 */
public class OrderDetailsInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 订单明细编号
     */
    private String orderDetailsId;
    /**
     * 订单编号
     */
    private String ordersId;
    /**
     * 商品编号
     */
    private String goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品图片
     */
    private String goodsPhoto;
    /**
     * 商品介绍
     */
    private String goodsProduce;
    /**
     * 定价
     */
    private double goodsFixMoney;
    /**
     * 售价
     */
    private double goodsSaleMoney;
    /**
     * 购买数量
     */
    private String buyNumber;
    /**
     * 总金额
     */
    private double totalMoney;
    /**
     * 购物车编号
     */
    private String buycarId;
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

    public String getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(String orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public String getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(String ordersId) {
        this.ordersId = ordersId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsFixMoney() {
        return goodsFixMoney;
    }

    public void setGoodsFixMoney(double goodsFixMoney) {
        this.goodsFixMoney = goodsFixMoney;
    }

    public double getGoodsSaleMoney() {
        return goodsSaleMoney;
    }

    public void setGoodsSaleMoney(double goodsSaleMoney) {
        this.goodsSaleMoney = goodsSaleMoney;
    }

    public String getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(String buyNumber) {
        this.buyNumber = buyNumber;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

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

    public String getBuycarId() {
        return buycarId;
    }

    public void setBuycarId(String buycarId) {
        this.buycarId = buycarId;
    }

    public String getGoodsPhoto() {
        return goodsPhoto;
    }

    public void setGoodsPhoto(String goodsPhoto) {
        this.goodsPhoto = goodsPhoto;
    }

    public String getGoodsProduce() {
        return goodsProduce;
    }

    public void setGoodsProduce(String goodsProduce) {
        this.goodsProduce = goodsProduce;
    }
}
