package com.xzsd.app.goodClassify.entity;

import java.util.Date;

/**
 * 商品分类
 * wumaoxing
 * 2020-03-26 15:06
 */
public class GoodClassifyInfo {
    /**
     * 分类编号
     */
    private String classifyId;
    /**
     * 商品编号
     */
    private String goodsId;
    /**
     * 上级分类编号
     */
    private String lastClassifyId;
    /**
     * 分类名称
     */
    private String classifyName;
    /**
     * 备注
     */
    private String classifyNote;
    /**
     * 分类等级
     */
    private String classifyLevel;
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

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getLastClassifyId() {
        return lastClassifyId;
    }

    public void setLastClassifyId(String lastClassifyId) {
        this.lastClassifyId = lastClassifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public String getClassifyNote() {
        return classifyNote;
    }

    public void setClassifyNote(String classifyNote) {
        this.classifyNote = classifyNote;
    }

    public String getClassifyLevel() {
        return classifyLevel;
    }

    public void setClassifyLevel(String classifyLevel) {
        this.classifyLevel = classifyLevel;
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

    @Override
    public String toString() {
        return "GoodClassifyInfo{" +
                "classifyId='" + classifyId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", lastClassifyId='" + lastClassifyId + '\'' +
                ", classifyName='" + classifyName + '\'' +
                ", classifyNote='" + classifyNote + '\'' +
                ", classifyLevel='" + classifyLevel + '\'' +
                ", isDeleted=" + isDeleted +
                ", createBy='" + createBy + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                ", gmtModified=" + gmtModified +
                ", version='" + version + '\'' +
                '}';
    }
}
