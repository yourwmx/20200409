package com.xzsd.app.login.entity;

/**
 * 用户个人信息类
 * wumaoxing
 * 2020-03-27 15:21
 */
public class UserDataInfo {

    /**
     * 用户账号
     */
    private String userAccount;
    /**
     * 头像
     */
    private String photo;
    /**
     * 角色 0管理员 1用户 2司机 3客户
     */
    private String role;
    /**
     * 客户编号
     */
    private String customerId;
    /**
     * 客户所绑定的门店编号
     */
    private String storeId;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
