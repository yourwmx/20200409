package com.xzsd.app.customer.entity;

import java.util.Date;

/**
 * 客户类
 * wumaoxing
 * 2020-04-13 9:26
 */
public class CustomerInfo {
    /**
     * 客户编号
     */
    private String customerId;
    /**
     * 门店编号
     */
    private String storeId;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 客户积分
     */
    private String customerCredit;
    /**
     * 客户账号
     */
    private String customerAccount;
    /**
     * 客户密码
     */
    private String customerPassword;
    /**
     * 手机号
     */
    private String customerPhone;
    /**
     * 客户姓名
     */
    private String customerName;
    /**
     * 性别
     */
    private String customerSex;
    /**
     * 身份证
     */
    private String idCard;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 邀请码
     */
    private String inviteCode;
    /**
     * 新邀请码
     */
    private String newInviteCode;
    /**
     * 头像
     */
    private String photo;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCustomerCredit() {
        return customerCredit;
    }

    public void setCustomerCredit(String customerCredit) {
        this.customerCredit = customerCredit;
    }

    public String getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(String customerAccount) {
        this.customerAccount = customerAccount;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(String customerSex) {
        this.customerSex = customerSex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNewInviteCode() {
        return newInviteCode;
    }

    public void setNewInviteCode(String newInviteCode) {
        this.newInviteCode = newInviteCode;
    }
}
