package com.neusoft.webauth.login.controller;

import com.neusoft.webauth.login.service.LoginService;
import com.neusoft.webauth.utils.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 个人信息、登陆User
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private LoginService loginService;
    /**
     * 个人信息查询
     * wumaoxing
     * 2020-03-26 9:00
     */
    @RequestMapping(value = "findInformationById")
    public AppResponse findInformationById() {
        try {
            return loginService.findInformationById();
        } catch (Exception e) {
            logger.error("查询个人信息异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
