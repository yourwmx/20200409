package com.xzsd.pc.driver.entity;

import java.util.Date;

/**
 * 司机类
 * wumaoxing
 * 2020-04-05 14:20
 */
public class DriverInfo {
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
     * 司机编号
     */
    private String driverId;
    /**
     * 司机名称
     */
    private String driverName;
    /**
     * 司机手机
     */
    private String driverPhone;
    /**
     * 司机账号
     */
    private String driverAccount;
    /**
     * 司机密码
     */
    private String driverPassword;
    /**
     * 身份证
     */
    private String idCard;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 省编号
     */
    private String driverProvinceId;
    /**
     * 市编号
     */
    private String driverCityId;
    /**
     * 区编号
     */
    private String driverAreaId;
    /**
     * 省
     */
    private String driverProvince;
    /**
     * 市
     */
    private String driverCity;
    /**
     * 区
     */
    private String driverArea;
    /**
     * 门店省编号
     */
    private String storeProvinceId;
    /**
     * 门店市编号
     */
    private String storeCityId;
    /**
     * 门店区编号
     */
    private String storeAreaId;
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

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDriverProvinceId() {
        return driverProvinceId;
    }

    public void setDriverProvinceId(String driverProvinceId) {
        this.driverProvinceId = driverProvinceId;
    }

    public String getDriverCityId() {
        return driverCityId;
    }

    public void setDriverCityId(String driverCityId) {
        this.driverCityId = driverCityId;
    }

    public String getDriverAreaId() {
        return driverAreaId;
    }

    public void setDriverAreaId(String driverAreaId) {
        this.driverAreaId = driverAreaId;
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

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getDriverAccount() {
        return driverAccount;
    }

    public void setDriverAccount(String driverAccount) {
        this.driverAccount = driverAccount;
    }

    public String getDriverPassword() {
        return driverPassword;
    }

    public void setDriverPassword(String driverPassword) {
        this.driverPassword = driverPassword;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getDriverProvince() {
        return driverProvince;
    }

    public void setDriverProvince(String driverProvince) {
        this.driverProvince = driverProvince;
    }

    public String getDriverCity() {
        return driverCity;
    }

    public void setDriverCity(String driverCity) {
        this.driverCity = driverCity;
    }

    public String getDriverArea() {
        return driverArea;
    }

    public void setDriverArea(String driverArea) {
        this.driverArea = driverArea;
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
}
