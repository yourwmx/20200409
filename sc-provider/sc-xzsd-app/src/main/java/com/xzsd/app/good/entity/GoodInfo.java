package com.xzsd.app.good.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 商品类
 * wumaoxinhg
 * 2020-03-26 10:23
 */
public class GoodInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 商品编号
     */
    private String goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 一级分类编号
     */
    private String goodsFirstClassifyId;
    /**
     * 一级分类名称
     */
    private String goodsFirstClassifyName;
    /**
     * 二级分类编号
     */
    private String goodsSecondClassifyId;
    /**
     * 二级分类名称
     */
    private String goodsSecondClassifyName;
    /**
     * 商家编码
     */
    private String goodsMerchantId;
    /**
     * 商家名称
     */
    private String goodsMerchantName;
    /**
     * 广告词
     */
    private String goodsAdvertise;
    /**
     * 出版社
     */
    private String goodsPress;
    /**
     * 作者
     */
    private String goodsAuthor;
    /**
     * 定价
     */
    private double goodsFixMoney;
    /**
     * 售价
     */
    private double goodsSaleMoney;
    /**
     * 售货量
     */
    private String goodsSaleNumber;
    /**
     * 商品介绍
     */
    private String goodsProduce;
    /**
     * 商品状态 0未发布 1上架 2下架
     */
    private String goodsState;
    /**
     * 上架时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date goodsShelfTime;
    /**
     * 浏览量
     */
    private String goodsLookNumber;
    /**
     * 库存
     */
    private String goodsRestNumber;
    /**
     * isbn书号
     */
    private String goodsIsbnNumber;
    /**
     * 图片
     */
    private String goodsPhoto;
    /**
     * 好评率
     */
    private String goodsComment;
    /**
     * 评价星级
     */
    private double commentLevel;
    /**
     * 门店名称
     */
    private String storeName;
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

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsFirstClassifyId() {
        return goodsFirstClassifyId;
    }

    public void setGoodsFirstClassifyId(String goodsFirstClassifyId) {
        this.goodsFirstClassifyId = goodsFirstClassifyId;
    }

    public String getGoodsSecondClassifyId() {
        return goodsSecondClassifyId;
    }

    public void setGoodsSecondClassifyId(String goodsSecondClassifyId) {
        this.goodsSecondClassifyId = goodsSecondClassifyId;
    }

    public String getGoodsMerchantId() {
        return goodsMerchantId;
    }

    public void setGoodsMerchantId(String goodsMerchantId) {
        this.goodsMerchantId = goodsMerchantId;
    }

    public String getGoodsMerchantName() {
        return goodsMerchantName;
    }

    public void setGoodsMerchantName(String goodsMerchantName) {
        this.goodsMerchantName = goodsMerchantName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsAdvertise() {
        return goodsAdvertise;
    }

    public void setGoodsAdvertise(String goodsAdvertise) {
        this.goodsAdvertise = goodsAdvertise;
    }

    public String getGoodsPress() {
        return goodsPress;
    }

    public void setGoodsPress(String goodsPress) {
        this.goodsPress = goodsPress;
    }

    public String getGoodsAuthor() {
        return goodsAuthor;
    }

    public void setGoodsAuthor(String goodsAuthor) {
        this.goodsAuthor = goodsAuthor;
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

    public String getGoodsSaleNumber() {
        return goodsSaleNumber;
    }

    public void setGoodsSaleNumber(String goodsSaleNumber) {
        this.goodsSaleNumber = goodsSaleNumber;
    }

    public String getGoodsProduce() {
        return goodsProduce;
    }

    public void setGoodsProduce(String goodsProduce) {
        this.goodsProduce = goodsProduce;
    }

    public String getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(String goodsState) {
        this.goodsState = goodsState;
    }
    @JsonFormat(timezone="GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getGoodsShelfTime() {
        return goodsShelfTime;
    }

    public void setGoodsShelfTime(Date goodsShelfTime) {
        this.goodsShelfTime = goodsShelfTime;
    }

    public String getGoodsLookNumber() {
        return goodsLookNumber;
    }

    public void setGoodsLookNumber(String goodsLookNumber) {
        this.goodsLookNumber = goodsLookNumber;
    }

    public String getGoodsRestNumber() {
        return goodsRestNumber;
    }

    public void setGoodsRestNumber(String goodsRestNumber) {
        this.goodsRestNumber = goodsRestNumber;
    }

    public String getGoodsIsbnNumber() {
        return goodsIsbnNumber;
    }

    public void setGoodsIsbnNumber(String goodsIsbnNumber) {
        this.goodsIsbnNumber = goodsIsbnNumber;
    }

    public String getGoodsPhoto() {
        return goodsPhoto;
    }

    public void setGoodsPhoto(String goodsPhoto) {
        this.goodsPhoto = goodsPhoto;
    }

    public String getGoodsComment() {
        return goodsComment;
    }

    public void setGoodsComment(String goodsComment) {
        this.goodsComment = goodsComment;
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

    public String getGoodsFirstClassifyName() {
        return goodsFirstClassifyName;
    }

    public void setGoodsFirstClassifyName(String goodsFirstClassifyName) {
        this.goodsFirstClassifyName = goodsFirstClassifyName;
    }

    public String getGoodsSecondClassifyName() {
        return goodsSecondClassifyName;
    }

    public void setGoodsSecondClassifyName(String goodsSecondClassifyName) {
        this.goodsSecondClassifyName = goodsSecondClassifyName;
    }

    public double getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(double commentLevel) {
        this.commentLevel = commentLevel;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public String toString() {
        return "GoodInfo{" +
                "pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsFirstClassifyId='" + goodsFirstClassifyId + '\'' +
                ", goodsSecondClassifyId='" + goodsSecondClassifyId + '\'' +
                ", goodsMerchantId='" + goodsMerchantId + '\'' +
                ", goodsMerchantName='" + goodsMerchantName + '\'' +
                ", goodsAdvertise='" + goodsAdvertise + '\'' +
                ", goodsPress='" + goodsPress + '\'' +
                ", goodsAuthor='" + goodsAuthor + '\'' +
                ", goodsFixMoney=" + goodsFixMoney +
                ", goodsSaleMoney=" + goodsSaleMoney +
                ", goodsSaleNumber=" + goodsSaleNumber +
                ", goodsProduce='" + goodsProduce + '\'' +
                ", goodsState='" + goodsState + '\'' +
                ", goodsShelfTime=" + goodsShelfTime +
                ", goodsLookNumber='" + goodsLookNumber + '\'' +
                ", goodsRestNumber='" + goodsRestNumber + '\'' +
                ", goodsIsbnNumber='" + goodsIsbnNumber + '\'' +
                ", goodsPhoto='" + goodsPhoto + '\'' +
                ", goodsComment='" + goodsComment + '\'' +
                ", isDeleted=" + isDeleted +
                ", createBy='" + createBy + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                ", gmtModified=" + gmtModified +
                ", version='" + version + '\'' +
                '}';
    }
}
