package com.xzsd.app.store.dao;

import com.xzsd.app.store.entity.StoreInfo;

/**
 * StoreDao
 * wumaoxing
 * 2020-04-04 21:40
 */
public interface StoreDao {
    /**
     * 检验门店是否存在或店长是否已绑定门店
     * wumaoxing
     * 2020-04-04 21:36
     */
    StoreInfo findStoreById(String userId);
    /**
     * 通过邀请码查询门店编号是否存在
     * wumaoxing
     * 2020-04-13 10:35
     */
    String queryStoreIdByInviteCode(String inviteCode);
}
