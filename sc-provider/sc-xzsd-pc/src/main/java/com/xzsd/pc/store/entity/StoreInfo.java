package com.xzsd.pc.store.entity;

import java.util.Date;

/**
 * Store类
 * wumaoxing
 * 2020-04-04 21:21
 */
public class StoreInfo {
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 角色
     */
    private String role;
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 门店编号
     */
    private String storeId;
    /**
     * 店长编号
     */
    private String storeManagerId;
    /**
     * 门店账号
     */
    private String storeAccount;
    /**
     * 店长姓名
     */
    private String storeManagerName;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 省编号
     */
    private String storeProvinceId;
    /**
     * 市编号
     */
    private String storeCityId;
    /**
     * 区编号
     */
    private String storeAreaId;
    /**
     * 省
     */
    private String storeProvince;
    /**
     * 市
     */
    private String storeCity;
    /**
     * 区
     */
    private String storeArea;
    /**
     * 联系电话
     */
    private String storePhone;
    /**
     * 详细地址
     */
    private String storeAddress;
    /**
     * 门店邀请码
     */
    private String inviteCode;
    /**
     * 营业执照编码
     */
    private String bussinessCode;
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

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreManagerId() {
        return storeManagerId;
    }

    public void setStoreManagerId(String storeManagerId) {
        this.storeManagerId = storeManagerId;
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

    public String getStoreProvinceId() {
        return storeProvinceId;
    }

    public void setStoreProvinceId(String storeProvinceId) {
        this.storeProvinceId = storeProvinceId;
    }

    public String getStoreCityId() {
        return storeCityId;
    }

    public void setStoreCityId(String storeCityId) {
        this.storeCityId = storeCityId;
    }

    public String getStoreAreaId() {
        return storeAreaId;
    }

    public void setStoreAreaId(String storeAreaId) {
        this.storeAreaId = storeAreaId;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getBussinessCode() {
        return bussinessCode;
    }

    public void setBussinessCode(String bussinessCode) {
        this.bussinessCode = bussinessCode;
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

    public void setRole(String role) {
        this.role = role;
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

    public String getStoreProvince() {
        return storeProvince;
    }

    public void setStoreProvince(String storeProvince) {
        this.storeProvince = storeProvince;
    }

    public String getStoreCity() {
        return storeCity;
    }

    public void setStoreCity(String storeCity) {
        this.storeCity = storeCity;
    }

    public String getStoreArea() {
        return storeArea;
    }

    public void setStoreArea(String storeArea) {
        this.storeArea = storeArea;
    }

    public String getStoreManagerName() {
        return storeManagerName;
    }

    public void setStoreManagerName(String storeManagerName) {
        this.storeManagerName = storeManagerName;
    }

    public String getStoreAccount() {
        return storeAccount;
    }

    public void setStoreAccount(String storeAccount) {
        this.storeAccount = storeAccount;
    }

}
