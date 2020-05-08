package com.xzsd.app.slideshow.entity;

import java.util.Date;

/**
 * 轮播图类
 * wumaoxing
 * 2020-03-28 14:32
 */
public class SlideshowInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 轮播图id
     */
    private String slideshowsId;
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 排序
     */
    private String slideshowsSort;
    /**
     * 图片路径
     */
    private String slideshowsRoute;
    /**
     * 有效期起
     */
    private String slideshowsTimeStart;
    /**
     * 有效期止
     */
    private String slideshowsTimeEnd;
    /**
     * 轮播图状态 0禁用 1可用
     */
    private String slideshowsState;
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

    public String getSlideshowsId() {
        return slideshowsId;
    }

    public void setSlideshowsId(String slideshowsId) {
        this.slideshowsId = slideshowsId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getSlideshowsSort() {
        return slideshowsSort;
    }

    public void setSlideshowsSort(String slideshowsSort) {
        this.slideshowsSort = slideshowsSort;
    }

    public String getSlideshowsRoute() {
        return slideshowsRoute;
    }

    public void setSlideshowsRoute(String slideshowsRoute) {
        this.slideshowsRoute = slideshowsRoute;
    }

    public String getSlideshowsTimeStart() {
        return slideshowsTimeStart;
    }

    public void setSlideshowsTimeStart(String slideshowsTimeStart) {
        this.slideshowsTimeStart = slideshowsTimeStart;
    }

    public String getSlideshowsTimeEnd() {
        return slideshowsTimeEnd;
    }

    public void setSlideshowsTimeEnd(String slideshowsTimeEnd) {
        this.slideshowsTimeEnd = slideshowsTimeEnd;
    }

    public String getSlideshowsState() {
        return slideshowsState;
    }

    public void setSlideshowsState(String slideshowsState) {
        this.slideshowsState = slideshowsState;
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


}
