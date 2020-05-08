package com.xzsd.app.buycar.entity;

import java.util.Date;

/**
 * 购物车类
 * wumaoxing
 * 2020-04-14 10:57
 */
public class BuycarInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 购物车编号
     */
    private String buycarId;
    /**
     * 商品编号
     */
    private String goodsId;
    /**
     * 客户编号
     */
    private String customerId;
    /**
     * 总价
     */
    private double totalMoney;
    /**
     * 数量
     */
    private String buyNumber;
    /**
     * 定价
     */
    private double goodsFixMoney;
    /**
     * 售价
     */
    private double goodsSaleMoney;
    /**
     * 图片
     */
    private String goodsPhoto;
    /**
     * 商品名称
     */
    private String goodsName;
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

    public String getBuycarId() {
        return buycarId;
    }

    public void setBuycarId(String buycarId) {
        this.buycarId = buycarId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(String buyNumber) {
        this.buyNumber = buyNumber;
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

    public String getGoodsPhoto() {
        return goodsPhoto;
    }

    public void setGoodsPhoto(String goodsPhoto) {
        this.goodsPhoto = goodsPhoto;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
