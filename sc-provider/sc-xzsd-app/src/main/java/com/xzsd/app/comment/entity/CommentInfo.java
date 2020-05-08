package com.xzsd.app.comment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xzsd.app.photo.entity.PhotoInfo;

import java.util.Date;
import java.util.List;

/**
 * 评价类
 * wumaoxing
 * 2020-04-13 17:00
 */
public class CommentInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 评价编号
     */
    private String commentId;
    /**
     * 好评
     */
    private String highComment;
    /**
     * 客户编号
     */
    private String customerId;
    /**
     * 商品编号
     */
    private String goodsId;
    /**
     * 客户账号
     */
    private String customerAccount;
    /**
     * 评价星级
     */
    private double commentLevel;
    /**
     * 评价内容
     */
    private String comment;
    /**
     * 评价图片
     */
    private String commentPhoto;
    /**
     * 商品评价数据
     */
    private List<PhotoInfo> list;
    /**
     * 评价时间
     */
    private Date commentTime;
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

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getHighComment() {
        return highComment;
    }

    public void setHighComment(String highComment) {
        this.highComment = highComment;
    }

    public String getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(String customerAccount) {
        this.customerAccount = customerAccount;
    }

    public double getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(double commentLevel) {
        this.commentLevel = commentLevel;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentPhoto() {
        return commentPhoto;
    }

    public void setCommentPhoto(String commentPhoto) {
        this.commentPhoto = commentPhoto;
    }

    @JsonFormat(timezone="GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public List<PhotoInfo> getList() {
        return list;
    }

    public void setList(List<PhotoInfo> list) {
        this.list = list;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
