package com.xzsd.app.login.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.driver.dao.DriverDao;
import com.xzsd.app.login.dao.LoginDao;
import com.xzsd.app.login.entity.UserDataInfo;
import com.xzsd.app.store.dao.StoreDao;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户实现类
 * wumaoxing
 * 2020-03-26 9:07
 */
@Service
public class LoginService {

    @Resource
    private LoginDao loginDao;

    @Resource
    private StoreDao storeDao;

    @Resource
    private DriverDao driverDao;

    /**
     * 个人信息查询
     * wumaoxing
     * 2020-03-26 9:08
     * @return
     */
    public AppResponse findInformationById(String role) {
        String userId = SecurityUtils.getCurrentUserId();
        if("2".equals(role)){
            UserDataInfo userPersonalMsgInfo = loginDao.findInformationById(userId);
            return AppResponse.success("查询成功！", userPersonalMsgInfo);
        }else if("3".equals(role)){
            return AppResponse.success("查询成功！",storeDao.findStoreById(userId));
        }else if("1".equals(role)){
            return AppResponse.success("查询成功！",driverDao.findDriverById(userId));
        }
        return AppResponse.bizError("请传入角色信息");
    }
}
