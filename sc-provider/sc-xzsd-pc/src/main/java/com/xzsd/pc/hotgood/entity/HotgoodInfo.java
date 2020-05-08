package com.xzsd.pc.hotgood.entity;

import java.util.Date;

/**
 * Hotgood类
 * wumaoxing
 * 2020-04-04 12:13
 */
public class HotgoodInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 商品位编号
     */
    private String hotgoodsId;
    /**
     * 商品编号
     */
    private String goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 售价
     */
    private String goodsSaleMoney;
    /**
     * 商品介绍
     */
    private String goodsProduce;
    /**
     * 排序
     */
    private String hotgoodsSort;
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

    public String getHotgoodsId() {
        return hotgoodsId;
    }

    public void setHotgoodsId(String hotgoodsId) {
        this.hotgoodsId = hotgoodsId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getHotgoodsSort() {
        return hotgoodsSort;
    }

    public void setHotgoodsSort(String hotgoodsSort) {
        this.hotgoodsSort = hotgoodsSort;
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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsSaleMoney() {
        return goodsSaleMoney;
    }

    public void setGoodsSaleMoney(String goodsSaleMoney) {
        this.goodsSaleMoney = goodsSaleMoney;
    }

    public String getGoodsProduce() {
        return goodsProduce;
    }

    public void setGoodsProduce(String goodsProduce) {
        this.goodsProduce = goodsProduce;
    }
}
