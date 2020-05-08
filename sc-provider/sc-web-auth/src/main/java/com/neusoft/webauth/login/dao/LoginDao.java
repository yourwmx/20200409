package com.neusoft.webauth.login.dao;


import com.neusoft.webauth.login.entity.UserDataInfo;

/**
 * LoginDao
 * wumaoxing
 * 2020-03-26 9:10
 */
public interface LoginDao {
    /**
     * 个人信息查询
     * wumaoxing
     * 2020-03-26 9:10
     * @param userId
     * @return
     */
    UserDataInfo findInformationById(String userId);
}
