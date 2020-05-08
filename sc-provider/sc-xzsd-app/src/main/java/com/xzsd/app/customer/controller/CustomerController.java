package com.xzsd.app.customer.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.customer.entity.CustomerInfo;
import com.xzsd.app.customer.service.CustomerService;
import com.xzsd.app.user.entity.UserInfo;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Resource
    private CustomerService customerService;

    /**
     * 客户注册
     * wumaoxing
     * 2020-03-30 9:47
     */
    @PostMapping(value = "addCustomer")
    public AppResponse addCustomer(CustomerInfo customerInfo) {
        try {
            return customerService.addCustomer(customerInfo);
        } catch (Exception e) {
            logger.error("客户注册异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改密码
     * wumaoxing
     * 2020-04-15 18:34
     */
    @PostMapping("updatePasswordById")
    public AppResponse updatePasswordById(UserInfo userInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            userInfo.setLastModifiedBy(userId);
            userInfo.setUserId(userId);
            return customerService.updatePasswordById(userInfo);
        } catch (Exception e) {
            logger.error("修改密码异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改店铺邀请码
     * wumaoxing
     * 2020-04-15 20:27
     */
    @PostMapping(value = "updateStoreInviteById")
    public AppResponse updateStoreInviteById(CustomerInfo customerInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            customerInfo.setLastModifiedBy(userId);
            return customerService.updateStoreInviteById(customerInfo);
        } catch (Exception e) {
            logger.error("修改店铺邀请码异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
