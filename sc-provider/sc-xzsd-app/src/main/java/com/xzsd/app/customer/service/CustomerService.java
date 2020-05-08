package com.xzsd.app.customer.service;

import com.neusoft.util.UUIDUtils;
import com.xzsd.app.customer.dao.CustomerDao;
import com.xzsd.app.customer.entity.CustomerInfo;
import com.xzsd.app.store.dao.StoreDao;
import com.xzsd.app.user.dao.UserDao;
import com.xzsd.app.user.entity.UserInfo;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.PasswordUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 客户实现类
 * wumaoxing
 * 2020-04-13 9:31
 */
@Service
public class CustomerService {

    @Resource
    private CustomerDao customerDao;

    @Resource
    private UserDao userDao;

    @Resource
    private StoreDao storeDao;

    /**
     * 新增客户
     * wumaoxing
     * 2020-04-05 14:39
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addCustomer(CustomerInfo customerInfo) {
        //检验客户或手机号是否存在
        UserInfo userInfo = new UserInfo();
        String userId = UUIDUtils.getUUID();
        userInfo.setUserId(userId);
        userInfo.setName(customerInfo.getCustomerName());
        userInfo.setPhoto(customerInfo.getPhoto());
        userInfo.setPhone(customerInfo.getCustomerPhone());
        userInfo.setUserAccount(customerInfo.getCustomerAccount());
        int countDriver = userDao.countUserAccountOrPhone(userInfo);
        if (countDriver != 0) {
            return AppResponse.bizError("客户或手机号已存在，请重新输入！");
        }
        //验证邀请码是否存在
        String inviteCode = customerInfo.getInviteCode();
        if(inviteCode != null && inviteCode != "") {
            String storeId = storeDao.queryStoreIdByInviteCode(inviteCode);
            if (storeId == null) {
                return AppResponse.bizError("门店邀请码不存在，请重新输入！");
            }
            customerInfo.setStoreId(storeId);
        }
        //设置默认头像
        if(customerInfo.getPhoto() == null){
            userInfo.setPhoto("https://bookstore-1301648696.cos.ap-guangzhou.myqcloud.com/lover/lover_2020050213395179469.jpeg");
        }
        //新增用户
        customerInfo.setCustomerId(UUIDUtils.getUUID());
        userInfo.setUserPassword(PasswordUtils.generatePassword(customerInfo.getCustomerPassword()));
        userInfo.setSex(customerInfo.getCustomerSex());
        userInfo.setEmail(customerInfo.getEmail());
        userInfo.setIdCard(customerInfo.getIdCard());
        userInfo.setRole(2 + "");
        int count = userDao.addUser(userInfo);
        if (count == 0) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        //新增客户
        customerInfo.setUserId(userId);
        customerInfo.setCustomerId(UUIDUtils.getUUID());
        count = customerDao.addCustomer(customerInfo);
        if (count == 0) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 修改密码
     * wumaoxing
     * 2020-04-15 18:37
     */
    public AppResponse updatePasswordById(UserInfo userInfo) {
        AppResponse appResponse = AppResponse.success("修改密码成功！");
        // 需要校验原密码是否正确
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(userInfo.getUserPassword(),userDao.findUserById(userInfo.getUserId()).getUserPassword()) == false){
            return AppResponse.bizError("原密码不正确，请重试！");
        }
        // 修改密码
        userInfo.setNewPassword(PasswordUtils.generatePassword(userInfo.getNewPassword()));
        int count = userDao.updateUserPasswordById(userInfo);
        if(0 == count) {
            appResponse = AppResponse.bizError("修改密码失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 修改店铺邀请码
     * wumaoxing
     * 2020-04-15 20:15
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStoreInviteById(CustomerInfo customerInfo){
        //检验门店邀请码是否存在
        String storeId = storeDao.queryStoreIdByInviteCode(customerInfo.getNewInviteCode());
        customerInfo.setStoreId(storeId);
        if(storeId == null){
            return AppResponse.bizError("门店邀请码不存在，请重试！");
        }
        //修改店铺邀请码
        int count = customerDao.updateStoreInviteById(customerInfo);
        if(count == 0){
            return AppResponse.bizError("修改店铺邀请码失败，请重试！");
        }
        return AppResponse.success("修改成功！");
    }
}
