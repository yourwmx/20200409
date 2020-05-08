package com.xzsd.pc.customer.controller;

import com.xzsd.pc.customer.entity.CustomerInfo;
import com.xzsd.pc.customer.service.CustomerService;
import com.xzsd.pc.good.controller.GoodController;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 查Customer
 * wumaoxing
 * 2020-03-30 9:45
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Resource
    private CustomerService customerService;

    /**
     * 客户分页列表
     * wumaoxing
     * 2020-03-30 9:47
     */
    @PostMapping(value = "listCustomers")
    public AppResponse listCustomers(CustomerInfo customerInfo) {
        try {
            return customerService.listCustomers(customerInfo);
        } catch (Exception e) {
            logger.error("查询客户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
